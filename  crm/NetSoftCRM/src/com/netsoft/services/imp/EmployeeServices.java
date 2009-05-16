package com.netsoft.services.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.intf.IDeptsDao;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.intf.IRolesDao;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Emidr;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;
import com.netsoft.services.intf.IEmployeeServices;
import com.netsoft.util.CRM;
import com.netsoft.util.ConsoleDate;
import com.netsoft.util.CurrentPages;

public class EmployeeServices implements IEmployeeServices {
	Logger log = Logger.getLogger(this.getClass());

	public IEmployeeDao ed;

	public IRolesDao rd;

	private IDeptsDao dd;
	
	private ICustomerstableDao cd;
	private int countpage;
	private int countcurrentpage;
	private List currentlist;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.services.imp.IEmployeeServices#isCheckLogin(com.netsoft.dao.beans.EmployeeBean)
	 */
	public EmployeeBean isCheckLogin(EmployeeBean eb) {
		log.debug("isCheckLogin开始执行");
		try {
			Employye ebs = new Employye();
			ebs.setEaccount(eb.getEaccount());
			ebs.setEpwd(eb.getEpwd());
			if ((ebs = ed.getEmployyeByeAccountAndPwd(ebs)) == null) {
				log.error("isCheckLogin执行成功。但是返回NULL值");
				return null;
			} else {
				// BeanUtils.copyProperties(eb,ebs);
				eb.setDepts(ebs.getDepts()==null?0:ebs.getDepts().getId());
				eb.setDeptsName(ebs.getDepts()==null?"":ebs.getDepts().getDname());
				eb.setEaccount(ebs.getEaccount());
				eb.setEmidrs(ebs.getEmidrs());
				eb.setEname(ebs.getEname());
				eb.setEpwd(ebs.getEpwd());
				eb.setId(ebs.getId());
				log.debug("isCheckLogin执行成功。");
				return eb;
			}
		} catch (Exception e) {
			log.error("isCheckLogin执行失败", e);
			return null;
		}
	}

	public IEmployeeDao getEd() {
		return ed;
	}

	public void setEd(IEmployeeDao ed) {
		this.ed = ed;
	}

	public Set<Menus> getMenusByEmployee(EmployeeBean eb) {
		log.debug("getMenusByEmployee方法开始执行");
		try {
			// 这里用SET集合，是为了解决角色之间拥有相同的权限。最终生成的还是只有一个。
			Set<Menus> ms = new HashSet<Menus>();
			Employye ebs = new Employye();
			ebs = ed.getEmployeeById(eb.getId());
			Set<Roles> rs = ed.getRolesByEmployee(ebs);
			log.info("set长度为： " + rs.size());
			for (Roles roles : rs) {
				if (roles.getRname().equals(CRM.LOGIN_ROLES)) {
					log.info("为登录角色。跳过");
				} else {
					log.info("不是登录角色。开始进行取得菜单");
					ms.addAll(rd.getMenusByRole(roles));
				}
			}
			log.info("getMenusByEmployee方法执行成功");
			log.info("最后总共取得菜单为：" + ms.size());
			return ms;
		} catch (Exception e) {
			log.debug("getMenusByEmployee方法执行失败", e);
			return null;
		}
	}

	public IRolesDao getRd() {
		return rd;
	}

	public void setRd(IRolesDao rd) {
		this.rd = rd;
	}

	// 根据员工ID得到员工
	public EmployeeBean getEmployyeById(int id) {
		Employye em = new Employye();
		em.setId(id);
		em=ed.getEmployeeById(id);
		EmployeeBean emd=this.copyEmployye(em);
//		BeanUtils.copyProperties(em, emd);
//		emd.setDepts(em.getDepts().getId());
//		emd.setDeptsName(em.getDepts().getDname());
//		int roleid=em.getEmidrs().iterator().hasNext()==true?((Roles) em.getEmidrs().iterator().next()).getId():0;
//		emd.setRoleid(roleid);
		return emd;

	}

	/** 得到所有的员工 */
	public List getAllEmployee() {
		List list = new ArrayList();
		try {
			log.info("Services层getAllEmployee方法开始执行");
			List<Employye> li = ed.getAllEmployee();

			for (Employye employye : li) {
				EmployeeBean ebs=this.copyEmployye(employye);
				list.add(ebs);
			}

			log.info("Services层getAllEmployee方法执行完成");
			return list;
		} catch (Exception e) {
			log.error("Services层getAllEmployee方法执行失败", e);
			return null;
		}

	}

	/** 得到所有员工并分页 */

	public List CurrentPage(int page, int size) {
		try {
			log.info("getAllEmployee重载分页中值为：" + page + "  " + size);
			List li = CurrentPages.CurrentPage(page, size, this
					.getAllEmployee());
			log.info("getAllEmployee重载分页中长度为：" + li.size());
			return li;
		} catch (Exception e) {
			log.error("Services层getAllEmployee重载分页方法执行失败", e);
			return null;
		}

	}

	/**
	 * 根据员工的ID删除某一个员工 返回值代表：1 不能删除，该员工还有客户关联。 2 删除成功。 3 删除失败，DAO方法出错。 4
	 * 删除失败，出异常了 5 该员工是某部门的负责人，不能删除
	 */
	public String delEmployee(int id) {
		try {
			log.info("Services层delEmployee方法开始执行");
			log.info("Services层delEmployee方法执行完成");
			Employye em = new Employye();
			em = ed.getEmployeeById(id);
			if (em.getCustomerstables() != null
					&& em.getCustomerstables().size() > 0) {
				return "1";
			}
			if(em.getDeptses().iterator().hasNext()==true)
			{
				return "5";
			}
			if (ed.delEmployee(em)) {
				return "2";
			} else {
				return "3";
			}
		} catch (Exception e) {
			log.error("Services层delEmployee方法执行失败", e);
			return "4";
		}
	}

	/** 保存员工对象 */

	public boolean addEmployye(EmployeeBean eb) {
		try {
			Employye em = new Employye();
			Roles role = rd.getRoles(eb.getRoleid());
			em.setDepts(dd.getDeptsById(eb.getDepts()));
			em.setEaccount(eb.getEaccount());
			em.setEname(eb.getEname());
			em.setEpwd(eb.getEpwd());
			em.getEmidrs().add(role);
			ed.addEmployee(em);
			return true;
		} catch (Exception e) {
			log.error("Services层的addEmployye方法执行失败", e);
			return false;
		}

	}

	public IDeptsDao getDd() {
		return dd;
	}

	public void setDd(IDeptsDao dd) {
		this.dd = dd;
	}

	public boolean updateEmployye(EmployeeBean eb) {
		try {

			Roles role = rd.getRoles(eb.getRoleid());
			Employye em = new Employye();
			Employye em1 = ed.getEmployeeById(eb.getId());
			em1.setDepts(dd.getDeptsById(eb.getDepts()));
			em1.setEaccount(eb.getEaccount());
			em1.setEname(eb.getEname());
			em1.setEpwd(eb.getEpwd());
			em1.getEmidrs().clear();
			em1.getEmidrs().add(role);
			ed.updateEmployee(em1);
			return true;
		} catch (Exception e) {
			log.error("updateEmployye方法执行出错了", e);
			return false;
		}
	}

	public List<EmployeeBean> findEmployeeByAny(String any, String code) {
		try {
			List list = new ArrayList();
			List<Employye> li = ed.findEmployyeByAny(any, code);
			for (Employye employye : li) {
				EmployeeBean ebs=this.copyEmployye(employye);
				list.add(ebs);
			}
			return list;
		} catch (Exception e) {
			log.error("findEmployeeByAny方法执行失败", e);
			return null;
		}
	}

	public boolean sendRole(Integer[] role, int eid) {

		try {
			log.info("数组的值为：" + role);
			Employye em = ed.getEmployeeById(eid);
			em.getEmidrs().clear();
			for (Integer integer : role) {
				Roles r = rd.getRoles(integer);
				ed.EmployeeSetRole(em, r);
			}
			return true;
		} catch (Exception e) {
			log.error("EmployeeService中sendRole方法出错了", e);
			return false;
		}

	}

	/** 根据查询条件得到部分员工 */

	public List CurrentPageQry(int page, int size, HashMap hm) {
		try {
			log.info("getEmployeeByQry重载分页中值为：" + page + "  " + size);
			List li = CurrentPages.CurrentPage(page, size,currentlist);
			return li;
			
		} catch (Exception e) {
			log.error("Services层getEmployeeByQry重载分页方法执行失败", e);
			return null;
		}

	}

	public List getEmployeeByQry(HashMap hm) {

		List list = new ArrayList();
		String roleid = (String) hm.get("emidrs");
		try {
			log.info("Services层getEmployeeByQry方法开始执行");
			hm.remove("emidrs");
			List<Employye> li = ed.findEmployyeByHashMap(hm);
			if (li == null || li.size() == 0) {
				countpage = 0;
				return null;
			}
			for (Employye employye : li) {
				boolean flag = false;
				EmployeeBean ebs = new EmployeeBean();
				//BeanUtils.copyProperties(employye,ebs);
				ebs.setDepts(employye.getDepts()==null?0:employye.getDepts().getId());
				ebs.setDeptsName(employye.getDepts()==null?"":employye.getDepts().getDname());
				ebs.setEaccount(employye.getEaccount());
				ebs.setEmidrs(employye.getEmidrs());
				ebs.setEname(employye.getEname());
				ebs.setEpwd(employye.getEpwd());
				ebs.setId(employye.getId());
				Iterator iter = employye.getEmidrs().iterator();
				while (iter.hasNext()) {
					Roles role = (Roles) iter.next();
					if (roleid != null && !"".equals(roleid))
						flag = roleid.equals(String.valueOf(role.getId()));
					else
						flag = true;
					ebs.setRolename(role.getRname());
					ebs.setRoleid(role.getId());
				}
				ebs.setDeptsName(employye.getDepts()==null?"":employye.getDepts().getDname());
				ebs.setLogin(isCheckLogin(ebs) == null ? 0 : 1);
				if (flag)
					list.add(ebs);
				flag = false;
			}

			log.info("Services层getEmployeeByQry方法执行完成");
			countpage = list.size();
			return list;
		} catch (Exception e) {
			log.error("Services层getEmployeeByQry方法执行失败", e);
			return null;
		}
	}

	/**
	 * 将某员工名下的所有客户转移到另一员工下，如果toId=0 则代表公开，不转到任何人名义下。
	 * 
	 * @param id
	 * @param toId
	 */
	public boolean changCustomerOwener(int id, int toId) {
		try {
			Employye em = ed.getEmployeeById(id);
			Employye toEm;
			if (toId == 0) {
				toEm = null;
			} else {
				toEm = ed.getEmployeeById(toId);
			}

			Set customers = em.getCustomerstables();
			if (customers.size() <= 0) {
				// 该员工名下没有客户，直接返回
				log.info("该员工名下无客户信息");
				return true;
			}
			Iterator itera = customers.iterator();
			while (itera.hasNext()) {
				Customerstable customer = (Customerstable) itera.next();
				customer.setEmployye(toEm);
				cd.updateCustomerstable(customer);
			}
			return true;
		} catch (Exception e) {
			log.error("转移员工名下客户信息失败", e);
			return false;
		}
	}

	public int getCount() {

		return this.getAllEmployee().size();
	}

	public int getCountQry() {
		return countpage;
	}

	public ICustomerstableDao getCd() {
		return cd;
	}

	public void setCd(ICustomerstableDao cd) {
		this.cd = cd;
	}
	
	public EmployeeBean copyEmployye(Employye employye)
	{
		EmployeeBean ebs = new EmployeeBean();
		ebs.setDepts(employye.getDepts()==null?0:employye.getDepts().getId());
		ebs.setDeptsName(employye.getDepts()==null?"":employye.getDepts().getDname());
		ebs.setEaccount(employye.getEaccount());
		ebs.setEmidrs(employye.getEmidrs());
		ebs.setEname(employye.getEname());
		ebs.setEpwd(employye.getEpwd());
		ebs.setId(employye.getId());
		Iterator iter = employye.getEmidrs().iterator();
		while (iter.hasNext()) {
			Roles role = (Roles) iter.next();
			ebs.setRolename(role.getRname());
			ebs.setRoleid(role.getId());
		}
		ebs.setDeptsName(employye.getDepts()==null?"":employye.getDepts().getDname());
		ebs.setLogin(isCheckLogin(ebs) == null ? 0 : 1);
		return ebs;
	}

	public int getCountByCurrentPage(HashMap hm) {
		//return this.countcurrentpage;
		this.currentlist=this.getEmployeeByQry(hm);
		return currentlist.size();
	}

}
