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
	 * 未锟斤拷锟斤拷预约锟斤拷锟斤拷锟斤拷锟酵伙拷锟斤拷ID锟脚★拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷芸锟?
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
	 * 锟斤拷锟酵伙拷锟角凤拷锟斤拷锟?20080712锟睫革拷锟斤拷锟襟，斤拷一锟斤拷细锟斤拷锟斤拷示锟斤拷息 锟斤拷锟截猴拷锟藉： 0 系统锟斤拷没锟叫该客伙拷锟斤拷息 1 锟斤拷锟斤拷一锟斤拷锟斤拷息锟斤拷锟斤拷锟揭革拷锟斤拷息为锟斤拷锟斤拷锟津撤碉拷 2
	 * 锟斤拷锟斤拷一锟斤拷锟斤拷息锟斤拷锟斤拷锟矫客伙拷锟斤拷息为锟斤拷锟斤拷 3 锟斤拷锟节讹拷锟斤拷锟斤拷息
	 */
	public int checkCustomer(String type, String number, String name) {
		StringBuilder hql = new StringBuilder(
				"from Customerstable where customercompany like :name");
		HashMap hm = new HashMap();
		if ("".equals(name.trim())) {
			//hm.put("name", "");
		} else {
			hm.put("name", "%" + name.trim() + "%");
		}
		if(!"".equals(number.trim())){
		if ("1".equals(type)) {
			// 1锟斤拷锟斤拷只锟?
			hql.append(" or customerhandset = :handset");
			hm.put("handset", number.trim());
		} else if ("2".equals(type)) {
			// 2锟斤拷锟界话
			hql.append(" or customerphone like :phone");
			hm.put("phone", "%-" + number.trim());
		}
		}
		List<Customerstable> list = icd.getCustomersByAny(hm, hql.toString());
		boolean flag = false;
		if (list != null && list.size() > 0) {
			if (list.size() == 1) {
				// 锟斤拷锟街伙拷锟揭伙拷锟斤拷锟较拷锟斤拷锟斤拷腋锟斤拷锟较拷枪锟斤拷锟斤拷突锟斤拷锟斤拷叱锟斤拷锟斤拷突锟?
				if (list.get(0).getEmployye() == null)
					return 1;
				else
					return 2;
			} else {
				// 锟斤拷锟斤拷卸锟斤拷锟?
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
		return 0;// 锟斤拷锟较低筹拷锟矫伙拷懈每突锟斤拷锟较?
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
			// 锟斤拷锟斤拷锟斤拷锟斤拷拥锟轿达拷锟斤拷锟皆ぴ硷拷突锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷偷目突锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟?
			// 1,锟斤拷未锟斤拷锟斤拷预约锟酵伙拷锟斤拷锟斤拷锟斤拷锟斤拷
			Businessruletable business = ibd.getRuleById(5);
			// 2,锟斤拷锟皆憋拷锟斤拷锟接碉拷懈锟斤拷锟斤拷涂突锟斤拷锟斤拷锟斤拷锟?
			List cl = icd.getCustomerByEidAndGrade(cb.getEid(),
					CUSTOMER_GRADE_LOCK);
			// 3,锟斤拷锟斤拷锟斤拷
			if (cl != null && cl.size() > 0) {
				if (Integer.parseInt(business.getRulevalue()) < cl.size()) {
					return "锟斤拷锟?未锟斤拷锟斤拷预约锟酵伙拷锟斤拷锟斤拷锟斤拷 锟斤拷锟酵客伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷系统锟斤拷锟斤拷锟斤拷锟斤拷茫锟斤拷锟斤拷锟斤拷锟斤拷痈锟斤拷锟斤拷偷目突锟?";
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
	 * 锟斤拷菘突锟绌D删锟斤拷某一锟斤拷锟酵伙拷 锟斤拷锟絝lag为y锟斤拷为锟斤拷锟斤拷锟缴撅拷锟轿猲锟斤拷 删锟斤拷锟斤拷锟斤拷锟斤拷锟缴撅拷锟斤拷锟角斤拷锟斤拷燃锟斤拷锟轿э拷锟斤拷锟缴拷锟斤拷业锟斤拷员之锟斤拷墓锟较?
	 */
	public boolean delCustomerByFlag(int id, String flag) {
		try {
			log.info("Services锟斤拷delCustomer锟斤拷锟斤拷锟斤拷始执锟斤拷");
			if ("y".equals(flag)) {
				icd.delCustomerstable(id);
				return true;
			} else {
				return this.delCustomer(id);
			}
		} catch (Exception e) {
			log.error("Services锟斤拷delCustomer锟斤拷锟斤拷执锟斤拷失锟斤拷", e);
			return false;
		}
	}

	public CustomerstableBean getCustomerById(int id) {
		try {
			log.info("Services锟斤拷getCustomerById锟斤拷锟斤拷锟斤拷始执锟斤拷");
			CustomerstableBean ctb = new CustomerstableBean();
			Customerstable ct = icd.getCustomerById(id);
			BeanUtils.copyProperties(ct, ctb);
			return ctb;
		} catch (Exception e) {
			log.error("Services锟斤拷getCustomerById锟斤拷锟斤拷执锟斤拷失锟斤拷", e);
			return null;
		}
	}

	public boolean updateCustomer(CustomerstableBean ctb) {

		try {
			log.info("Services锟斤拷updateCustomer锟斤拷锟斤拷锟斤拷始执锟斤拷");

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
			log.error("Services锟斤拷updateCustomer锟斤拷锟斤拷执锟斤拷失锟斤拷", e);
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
	 * 锟斤拷锟叫癸拷锟斤拷锟酵伙拷锟斤拷锟斤拷锟斤拷
	 */
	public int getOpenCount(String company, String startdate, String enddate,int cutomergrade) {
		return this.getAllOpenCustomer(0, 0, company, startdate, enddate,cutomergrade)
				.size();
	}

	/**
	 * 锟斤拷取锟斤拷锟叫的客伙拷锟斤拷息 2008024 锟睫革拷 锟斤拷锟斤拷强突锟铰硷拷锟斤拷锟街な憋拷牟锟窖拷突锟斤拷斜?锟斤拷eid为-1
	 * 锟斤拷锟轿?1锟侥伙拷锟斤拷锟斤拷锟斤拷锟角诧拷锟角癸拷锟斤拷锟酵伙拷锟斤拷锟斤拷枪锟斤拷锟斤拷突锟斤拷锟斤拷锟绞撅拷锟斤拷锟斤拷枪锟斤拷锟斤拷突锟斤拷锟斤拷锟绞?
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
	 * 锟斤拷锟叫客伙拷锟斤拷锟斤拷锟斤拷
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
			log.error("删锟斤拷突锟斤拷锟较⑹憋拷锟斤拷锟?(锟斤拷锟斤拷锟斤拷锟斤拷删锟斤拷,锟斤拷为锟斤拷锟斤拷突锟?", e);
			return false;
		}

	}
	
	public boolean batchChangGrade(String[] ids,int grade)
	{
		for(int i=0;i<ids.length;i++)
		{
			int id=Integer.parseInt(ids[i]);
			Customerstable customertalbe = icd.getCustomerById(id);
			customertalbe.setCutomergrade(new Integer(grade));
			icd.updateCustomerstable(customertalbe);
		}
		return true;
	}

   public boolean batchOpen(String[] ids)
   {
	   for(int i=0;i<ids.length;i++)
		{
		   int id=Integer.parseInt(ids[i]);
			this.changeCustomerOpen(id);
		}
		return true;
   }
   
   public boolean changOwener(String[] ids,int eid)
   {
	   Employye employee=ied.getEmployeeById(eid);
	   for(int i=0;i<ids.length;i++)
		{
			int id=Integer.parseInt(ids[i]);
			Customerstable customertalbe = icd.getCustomerById(id);
			customertalbe.setEmployye(employee);
			icd.updateCustomerstable(customertalbe);
		}
		return true;
   }
   
   public boolean batchDel(String[] ids)
   {
	   for(int i=0;i<ids.length;i++)
		{
			int id=Integer.parseInt(ids[i]);
			Customerstable customertalbe = icd.getCustomerById(id);
			Integer grade=customertalbe.getCutomergrade();
			String flag=grade.intValue()==this.INVALI_CUSTOMER_GRADE?"y":"n";
			this.delCustomerByFlag(id, flag);
		}
		return true;
   }
}
