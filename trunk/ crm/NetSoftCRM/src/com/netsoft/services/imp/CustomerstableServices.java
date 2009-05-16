package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.CustomerstableBean;
import com.netsoft.dao.intf.IBusinessruletableDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.pojos.Businessruletable;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.services.intf.ICustomerstableServices;

public class CustomerstableServices implements ICustomerstableServices {

	Logger log = Logger.getLogger(this.getClass());
	/**
	 * 未见面预约将出单客户的ID号。这个有数量管控
	 */
	private static int CUSTOMER_GRADE_LOCK = 19;
	private ICustomerstableDao icd;
	private IEmployeeDao ied;
	private IBusinessruletableDao ibd;

	public ICustomerstableDao getIcd() {
		return icd;
	}

	public void setIcd(ICustomerstableDao icd) {
		this.icd = icd;
	}

	/**
	 * 检查客户是否存在 20080712修改需求，进一步细化提示信息 返回含义： 0 系统中没有该客户信息 1 存在一条信息，并且该信息为公开或撤单 2
	 * 存在一条信息，但该客户信息为独享 3 存在多条信息
	 */
	public int checkCustomer(String type, String number, String name) {
		StringBuilder hql = new StringBuilder(
				"from Customerstable where customercompany like :name");
		HashMap hm = new HashMap();
		if ("".equals(name.trim())) {
			hm.put("name", "");
		} else {
			hm.put("name", "%" + name.trim() + "%");
		}
		if ("1".equals(type)) {
			// 1代表手机
			hql.append(" or customerhandset = :handset");
			hm.put("handset", number.trim());
		} else if ("2".equals(type)) {
			// 2代表电话
			hql.append(" or customerphone like :phone");
			hm.put("phone", "%-" + number.trim());
		}
		List<Customerstable> list = icd.getCustomersByAny(hm, hql.toString());
		boolean flag = false;
		if (list != null && list.size() > 0) {
			if (list.size() == 1) {
				// 如果只有一条信息，并且该信息是公开客户或者撤单客户
				if (list.get(0).getEmployye() == null)
					return 1;
				else
					return 2;
			} else {
				// 如果有多条
				for (Customerstable customerstable : list) {
					if (customerstable.getEmployye() == null) {
						flag = true;
						break;
					}
				}
				if (flag) {
					return 3;
				} else {
					return 2;
				}
			}
		}
		return 0;// 代表系统中没有该客户信息
	}

	public List<CustomerstableBean> getAllCustomerByEid(int id, int page,
			int size, String company, String startdate, String enddate,int cutomergrade) {
		List<Customerstable> list = icd.getCustomersByEid(id, page, size,
				company, startdate, enddate,cutomergrade);
		CustomerstableBean cb;
		List result = new ArrayList();
		for (Customerstable customerstable : list) {
			cb = new CustomerstableBean();
			BeanUtils.copyProperties(customerstable, cb);
			cb.setEname(customerstable.getEmployye().getEname());
			result.add(cb);
		}
		return result;
	}

	public String addCustomer(CustomerstableBean cb) {
		if (cb.getCutomergrade() == CUSTOMER_GRADE_LOCK) {
			// 如果是增加的未见面预约客户将出单类型的客户则检查规则里面的数量设置
			// 1,查未见面预约客户数量规则
			Businessruletable business = ibd.getRuleById(5);
			// 2,查该员工已拥有该类型客户的数量
			List cl = icd.getCustomerByEidAndGrade(cb.getEid(),
					CUSTOMER_GRADE_LOCK);
			// 3,检查规则
			if (cl != null && cl.size() > 0) {
				if (Integer.parseInt(business.getRulevalue()) < cl.size()) {
					return "您的 未见面预约客户将出单 类型客户的数量超出了系统规则的设置，您不能增加该类型的客户!";
				}
			}
		}

		Customerstable cu = new Customerstable();
		BeanUtils.copyProperties(cb, cu);
		Employye employye = ied.getEmployeeEdelStyleId(cb.getEid());
		cu.setEmployye(employye);
		cu.setAddemployye(employye);
		int cfr=icd.addCustomerstable(cu);
		return "return:"+cfr;
	}

	public IEmployeeDao getIed() {
		return ied;
	}

	public void setIed(IEmployeeDao ied) {
		this.ied = ied;
	}

	public IBusinessruletableDao getIbd() {
		return ibd;
	}

	public void setIbd(IBusinessruletableDao ibd) {
		this.ibd = ibd;
	}

	public int getCount(int eid, String company, String startdate,
			String enddate,int cutomergrade) {
		return this.getAllCustomerByEid(eid, 0, 0, company, startdate, enddate, cutomergrade)
				.size();
	}

	/**
	 * 根据客户ID删除某一个客户 如果flag为y则为真正的删除，为n则 删除不是真正的删除，而是将其等级改为失效，解散其和业务员之间的关系
	 */
	public boolean delCustomerByFlag(int id, String flag) {
		try {
			log.info("Services层delCustomer方法开始执行");

			if ("y".equals(flag)) {
				icd.delCustomerstable(id);
				return true;
			} else {
				return this.delCustomer(id);
			}
		} catch (Exception e) {
			log.error("Services层delCustomer方法执行失败", e);
			return false;
		}
	}

	public CustomerstableBean getCustomerById(int id) {
		try {
			log.info("Services层getCustomerById方法开始执行");
			CustomerstableBean ctb = new CustomerstableBean();
			Customerstable ct = icd.getCustomerById(id);
			BeanUtils.copyProperties(ct, ctb);
			return ctb;
		} catch (Exception e) {
			log.error("Services层getCustomerById方法执行失败", e);
			return null;
		}
	}

	public boolean updateCustomer(CustomerstableBean ctb) {

		try {
			log.info("Services层updateCustomer方法开始执行");

			Customerstable ct = icd.getCustomerById(ctb.getCustomerid());
			ct.setCustomercompany(ctb.getCustomercompany());
			ct.setCustomeraddress(ctb.getCustomeraddress());
			ct.setCustomerfax(ctb.getCustomerfax());
			ct.setCustomerphone(ctb.getCustomerphone());
			ct.setCustomersource(ctb.getCustomersource());
			ct.setCutomergrade(ctb.getCutomergrade());
			ct.setCustomerproperty(ctb.getCustomerproperty());
			ct.setCustomerprice(ctb.getCustomerprice());
			ct.setCustomername(ctb.getCustomername());
			ct.setCustomerhandset(ctb.getCustomerhandset());
			ct.setCustomerowenerxz(ctb.getCustomerowenerxz());
			if (ctb.getCustomerfeedbackdate() != null
					&& !"".equals(ctb.getCustomerfeedbackdate())) {
				Employye employye = ied.getEmployeeEdelStyleId(ctb.getEid());
				ct.setEmployye(employye);
				ct.setCustomeroutdate(ctb.getCustomeroutdate());
				ct.setCustomerfeedback(ctb.getCustomerfeedback());
				ct.setCustomerfeedbackdate(ctb.getCustomerfeedbackdate());
				ct.setCustomerfeedbacktype(ctb.getCustomerfeedbacktype());
				ct.setCustomernextdate(ctb.getCustomernextdate());
				ct.setCustomerprice(ctb.getCustomerprice());
			}
			if (ctb.getCutomergrade() != null) {
				if (ctb.getCutomergrade() == this.INVALI_CUSTOMER_GRADE) {
					ct.setEmployye(null);
				}
			}
			icd.updateCustomerstable(ct);
			return true;
		} catch (Exception e) {
			log.error("Services层updateCustomer方法执行失败", e);
			return false;
		}
	}

	public List<CustomerstableBean> getAllOpenCustomer(int page, int size,
			String company, String startdate, String enddate,int cutomergrade) {
		List<Customerstable> list = icd.getCustomersByOpen(page, size, company,
				startdate, enddate,cutomergrade);
		CustomerstableBean cb;
		List result = new ArrayList();
		for (Customerstable customerstable : list) {
			cb = new CustomerstableBean();
			BeanUtils.copyProperties(customerstable, cb);
			// cb.setEname(customerstable.getEmployye().getEname());
			result.add(cb);
		}
		return result;
	}

	/**
	 * 所有公开客户的数量
	 */
	public int getOpenCount(String company, String startdate, String enddate,int cutomergrade) {
		return this.getAllOpenCustomer(0, 0, company, startdate, enddate,cutomergrade)
				.size();
	}

	/**
	 * 获取所有的客户信息 2008024 修改 如果是客户录入验证时的查询客户列表，则eid为-1
	 * 如果为-1的话则检查期是不是公开客户如果是公开客户就显示，不是公开客户不显示
	 */
	public List<CustomerstableBean> getAllCustomer(int page, int size,
			String name, int eid, String startdate, String enddate) {
		int employeid = 0;
		if (eid >= 0) {
			employeid = eid;
		}
		List<Customerstable> list = icd.getAllCustomerstable(page, size, name,
				employeid, startdate, enddate);
		CustomerstableBean cb;
		List result = new ArrayList();
		for (Customerstable customerstable : list) {
			cb = new CustomerstableBean();
			if (eid >= 0) {
				BeanUtils.copyProperties(customerstable, cb);
				cb.setEname(customerstable.getEmployye() == null ? ""
						: customerstable.getEmployye().getEname());
				result.add(cb);
			} else {
				if (customerstable.getEmployye() == null) {
					BeanUtils.copyProperties(customerstable, cb);
					cb.setEname(customerstable.getEmployye() == null ? ""
							: customerstable.getEmployye().getEname());
					result.add(cb);
				}
			}
		}
		return result;
	}

	/**
	 * 所有客户的数量
	 */
	public int getAllCount(String name, int eid, String startdate,
			String enddate) {
		return this.getAllCustomer(0, 0, name, eid, startdate, enddate).size();
	}

	public boolean changeCustomerOpen(int id) {
		Customerstable customertalbe = icd.getCustomerById(id);
		customertalbe.setEmployye(null);
		icd.updateCustomerstable(customertalbe);
		return true;
	}

	public List<CustomerstableBean> getAllInvaliCustomer(int page, int size,
			String company, String startdate, String enddate,int cutomergrade) {
		List<Customerstable> list = icd.getCustomersByInvali(page, size,
				company, startdate, enddate,cutomergrade);
		CustomerstableBean cb;
		List result = new ArrayList();
		for (Customerstable customerstable : list) {
			cb = new CustomerstableBean();
			BeanUtils.copyProperties(customerstable, cb);
			// cb.setEname(customerstable.getEmployye().getEname());
			result.add(cb);
		}
		return result;
	}

	public int getInvaliCount(String company, String startdate, String enddate,int cutomergrade) {
		return this.getAllInvaliCustomer(0, 0, company, startdate, enddate,cutomergrade)
				.size();
	}

	public boolean delCustomer(int id) {
		try {
			Customerstable customer = icd.getCustomerById(id);
			customer.setEmployye(null);
			customer.setCutomergrade(this.INVALI_CUSTOMER_GRADE);
			icd.updateCustomerstable(customer);
			// return icd.delCustomerstable(id);
			return true;
		} catch (Exception e) {
			log.error("删除客户信息时出错!(不是真正删除,改为撤消客户)", e);
			return false;
		}

	}

}
