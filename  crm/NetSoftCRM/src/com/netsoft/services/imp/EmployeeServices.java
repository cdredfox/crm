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
		log.debug("isCheckLogin��ʼִ��");
		try {
			Employye ebs = new Employye();
			ebs.setEaccount(eb.getEaccount());
			ebs.setEpwd(eb.getEpwd());
			if ((ebs = ed.getEmployyeByeAccountAndPwd(ebs)) == null) {
				log.error("isCheckLoginִ�гɹ������Ƿ���NULLֵ");
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
				log.debug("isCheckLoginִ�гɹ���");
				return eb;
			}
		} catch (Exception e) {
			log.error("isCheckLoginִ��ʧ��", e);
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
		log.debug("getMenusByEmployee������ʼִ��");
		try {
			// ������SET���ϣ���Ϊ�˽����ɫ֮��ӵ����ͬ��Ȩ�ޡ��������ɵĻ���ֻ��һ����
			Set<Menus> ms = new HashSet<Menus>();
			Employye ebs = new Employye();
			ebs = ed.getEmployeeById(eb.getId());
			Set<Roles> rs = ed.getRolesByEmployee(ebs);
			log.info("set����Ϊ�� " + rs.size());
			for (Roles roles : rs) {
				if (roles.getRname().equals(CRM.LOGIN_ROLES)) {
					log.info("Ϊ��¼��ɫ������");
				} else {
					log.info("���ǵ�¼��ɫ����ʼ����ȡ�ò˵�");
					ms.addAll(rd.getMenusByRole(roles));
				}
			}
			log.info("getMenusByEmployee����ִ�гɹ�");
			log.info("����ܹ�ȡ�ò˵�Ϊ��" + ms.size());
			return ms;
		} catch (Exception e) {
			log.debug("getMenusByEmployee����ִ��ʧ��", e);
			return null;
		}
	}

	public IRolesDao getRd() {
		return rd;
	}

	public void setRd(IRolesDao rd) {
		this.rd = rd;
	}

	// ����Ա��ID�õ�Ա��
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

	/** �õ����е�Ա�� */
	public List getAllEmployee() {
		List list = new ArrayList();
		try {
			log.info("Services��getAllEmployee������ʼִ��");
			List<Employye> li = ed.getAllEmployee();

			for (Employye employye : li) {
				EmployeeBean ebs=this.copyEmployye(employye);
				list.add(ebs);
			}

			log.info("Services��getAllEmployee����ִ�����");
			return list;
		} catch (Exception e) {
			log.error("Services��getAllEmployee����ִ��ʧ��", e);
			return null;
		}

	}

	/** �õ�����Ա������ҳ */

	public List CurrentPage(int page, int size) {
		try {
			log.info("getAllEmployee���ط�ҳ��ֵΪ��" + page + "  " + size);
			List li = CurrentPages.CurrentPage(page, size, this
					.getAllEmployee());
			log.info("getAllEmployee���ط�ҳ�г���Ϊ��" + li.size());
			return li;
		} catch (Exception e) {
			log.error("Services��getAllEmployee���ط�ҳ����ִ��ʧ��", e);
			return null;
		}

	}

	/**
	 * ����Ա����IDɾ��ĳһ��Ա�� ����ֵ����1 ����ɾ������Ա�����пͻ������� 2 ɾ���ɹ��� 3 ɾ��ʧ�ܣ�DAO�������� 4
	 * ɾ��ʧ�ܣ����쳣�� 5 ��Ա����ĳ���ŵĸ����ˣ�����ɾ��
	 */
	public String delEmployee(int id) {
		try {
			log.info("Services��delEmployee������ʼִ��");
			log.info("Services��delEmployee����ִ�����");
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
			log.error("Services��delEmployee����ִ��ʧ��", e);
			return "4";
		}
	}

	/** ����Ա������ */

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
			log.error("Services���addEmployye����ִ��ʧ��", e);
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
			log.error("updateEmployye����ִ�г�����", e);
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
			log.error("findEmployeeByAny����ִ��ʧ��", e);
			return null;
		}
	}

	public boolean sendRole(Integer[] role, int eid) {

		try {
			log.info("�����ֵΪ��" + role);
			Employye em = ed.getEmployeeById(eid);
			em.getEmidrs().clear();
			for (Integer integer : role) {
				Roles r = rd.getRoles(integer);
				ed.EmployeeSetRole(em, r);
			}
			return true;
		} catch (Exception e) {
			log.error("EmployeeService��sendRole����������", e);
			return false;
		}

	}

	/** ���ݲ�ѯ�����õ�����Ա�� */

	public List CurrentPageQry(int page, int size, HashMap hm) {
		try {
			log.info("getEmployeeByQry���ط�ҳ��ֵΪ��" + page + "  " + size);
			List li = CurrentPages.CurrentPage(page, size,currentlist);
			return li;
			
		} catch (Exception e) {
			log.error("Services��getEmployeeByQry���ط�ҳ����ִ��ʧ��", e);
			return null;
		}

	}

	public List getEmployeeByQry(HashMap hm) {

		List list = new ArrayList();
		String roleid = (String) hm.get("emidrs");
		try {
			log.info("Services��getEmployeeByQry������ʼִ��");
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

			log.info("Services��getEmployeeByQry����ִ�����");
			countpage = list.size();
			return list;
		} catch (Exception e) {
			log.error("Services��getEmployeeByQry����ִ��ʧ��", e);
			return null;
		}
	}

	/**
	 * ��ĳԱ�����µ����пͻ�ת�Ƶ���һԱ���£����toId=0 �����������ת���κ��������¡�
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
				// ��Ա������û�пͻ���ֱ�ӷ���
				log.info("��Ա�������޿ͻ���Ϣ");
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
			log.error("ת��Ա�����¿ͻ���Ϣʧ��", e);
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
