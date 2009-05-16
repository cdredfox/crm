package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.CustomerstableBean;
import com.netsoft.dao.intf.IBusinessruletableDao;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.pojos.Businessruletable;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.services.intf.ICustomerstableServices;

public class CustomerstableServices implements ICustomerstableServices {

	Logger log = Logger.getLogger(this.getClass());
	/**
	 * δ����ԤԼ�������ͻ���ID�š�����������ܿ�
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
	 * ���ͻ��Ƿ���� 20080712�޸����󣬽�һ��ϸ����ʾ��Ϣ ���غ��壺 0 ϵͳ��û�иÿͻ���Ϣ 1 ����һ����Ϣ�����Ҹ���ϢΪ�����򳷵� 2
	 * ����һ����Ϣ�����ÿͻ���ϢΪ���� 3 ���ڶ�����Ϣ
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
			// 1����ֻ�
			hql.append(" or customerhandset = :handset");
			hm.put("handset", number.trim());
		} else if ("2".equals(type)) {
			// 2���绰
			hql.append(" or customerphone like :phone");
			hm.put("phone", "%-" + number.trim());
		}
		List<Customerstable> list = icd.getCustomersByAny(hm, hql.toString());
		boolean flag = false;
		if (list != null && list.size() > 0) {
			if (list.size() == 1) {
				// ���ֻ��һ����Ϣ�����Ҹ���Ϣ�ǹ����ͻ����߳����ͻ�
				if (list.get(0).getEmployye() == null)
					return 1;
				else
					return 2;
			} else {
				// ����ж���
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
		return 0;// ���ϵͳ��û�иÿͻ���Ϣ
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
			// ��������ӵ�δ����ԤԼ�ͻ����������͵Ŀͻ���������������������
			// 1,��δ����ԤԼ�ͻ���������
			Businessruletable business = ibd.getRuleById(5);
			// 2,���Ա����ӵ�и����Ϳͻ�������
			List cl = icd.getCustomerByEidAndGrade(cb.getEid(),
					CUSTOMER_GRADE_LOCK);
			// 3,������
			if (cl != null && cl.size() > 0) {
				if (Integer.parseInt(business.getRulevalue()) < cl.size()) {
					return "��� δ����ԤԼ�ͻ������� ���Ϳͻ�������������ϵͳ��������ã��������Ӹ����͵Ŀͻ�!";
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
	 * ��ݿͻ�IDɾ��ĳһ���ͻ� ���flagΪy��Ϊ�����ɾ��Ϊn�� ɾ���������ɾ����ǽ���ȼ���ΪʧЧ����ɢ���ҵ��Ա֮��Ĺ�ϵ
	 */
	public boolean delCustomerByFlag(int id, String flag) {
		try {
			log.info("Services��delCustomer������ʼִ��");

			if ("y".equals(flag)) {
				icd.delCustomerstable(id);
				return true;
			} else {
				return this.delCustomer(id);
			}
		} catch (Exception e) {
			log.error("Services��delCustomer����ִ��ʧ��", e);
			return false;
		}
	}

	public CustomerstableBean getCustomerById(int id) {
		try {
			log.info("Services��getCustomerById������ʼִ��");
			CustomerstableBean ctb = new CustomerstableBean();
			Customerstable ct = icd.getCustomerById(id);
			BeanUtils.copyProperties(ct, ctb);
			return ctb;
		} catch (Exception e) {
			log.error("Services��getCustomerById����ִ��ʧ��", e);
			return null;
		}
	}

	public boolean updateCustomer(CustomerstableBean ctb) {

		try {
			log.info("Services��updateCustomer������ʼִ��");

			Customerstable ct = icd.getCustomerById(ctb.getCustomerid());
			ct.setCustomercompany(ctb.getCustomercompany());
			
			ct.setCustomerprovince(ctb.getCustomerprovince());
			ct.setCustomercity(ctb.getCustomercity());
			
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
			log.error("Services��updateCustomer����ִ��ʧ��", e);
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
	 * ���й����ͻ�������
	 */
	public int getOpenCount(String company, String startdate, String enddate,int cutomergrade) {
		return this.getAllOpenCustomer(0, 0, company, startdate, enddate,cutomergrade)
				.size();
	}

	/**
	 * ��ȡ���еĿͻ���Ϣ 2008024 �޸� ����ǿͻ�¼����֤ʱ�Ĳ�ѯ�ͻ��б?��eidΪ-1
	 * ���Ϊ-1�Ļ��������ǲ��ǹ����ͻ�����ǹ����ͻ�����ʾ�����ǹ����ͻ�����ʾ
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
	 * ���пͻ�������
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
			log.error("ɾ��ͻ���Ϣʱ����!(��������ɾ��,��Ϊ����ͻ�)", e);
			return false;
		}

	}

}
