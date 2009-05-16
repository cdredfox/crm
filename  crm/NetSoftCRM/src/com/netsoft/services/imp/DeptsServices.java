package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.bsf.util.Bean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.netsoft.dao.beans.DeptsBean;
import com.netsoft.dao.imp.DeptsDao;
import com.netsoft.dao.intf.IDeptsDao;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.pojos.Depts;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.services.intf.IDeptsServices;

public class DeptsServices implements IDeptsServices {

	Logger log = Logger.getLogger(this.getClass());
	private IDeptsDao dd;
	private IEmployeeDao ed;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.services.imp.IDeptsServices#getDeptsById(int)
	 */
	public DeptsBean getDeptsById(int id) {
		try {
			log.info("services��getDeptsById������ʼִ��");
			Depts dept = dd.getDeptsById(id);
			DeptsBean db = new DeptsBean();
			BeanUtils.copyProperties(db, dept);
			db.setEmployyeName(dept.getEmployye() == null ? "" : dept
					.getEmployye().getEname());
			log.info("services��getDeptsById����ִ�гɹ�");
			return db;
		} catch (Exception e) {
			log.error("services��getDeptsById����ִ��ʧ��", e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.services.imp.IDeptsServices#getAllDepts()
	 */
	public List getAllDepts() {
		try {
			log.info("services��getAllDepts������ʼִ��");
			List li = new ArrayList();
			List<Depts> list = dd.getAllDepts();
			for (Depts depts : list) {
				DeptsBean db = new DeptsBean();
				BeanUtils.copyProperties(db, depts);
				db.setEmployyeName(depts.getEmployye() == null ? "" : depts
						.getEmployye().getEname());
				li.add(db);
			}
			log.info("services��getAllDepts����ִ�гɹ�");
			return li;
		} catch (Exception e) {
			log.error("services��getAllDepts����ִ��ʧ��", e);
			return null;
		}
	}

	public IDeptsDao getDd() {
		return dd;
	}

	public void setDd(IDeptsDao dd) {
		this.dd = dd;
	}

	public void addDepts(DeptsBean db) {
		Depts dept = new Depts();
		Employye employye = (Employye) ed.findEmployyeByAny("ename",
				db.getEmployyeName()).get(0);
		List<Depts> list=dd.getDeptsByEid(employye.getId());
		//����ǰ������Ĳ������
		for (Depts depts : list) {
			depts.setEmployye(null);
			dd.updateDept(depts);
		}
		dept.setDname(db.getDname());
		dept.setEmployye(employye);
		dd.addDept(dept);
		employye.setDepts(dept);
		ed.updateEmployee(employye);
	}

	/**
	 * ����һ��BO�����޸�һ������
	 * 
	 * @param db
	 */
	public void updateDepts(DeptsBean db) {
		Depts dept = new Depts();
		Employye employye = (Employye) ed.findEmployyeByAny("ename",
				db.getEmployyeName()).get(0);
		List<Depts> list=dd.getDeptsByEid(employye.getId());
		for (Depts depts : list) {
			depts.setEmployye(null);
			dd.updateDept(depts);
		}
		dept.setId(db.getId());
		dept.setDname(db.getDname());
		employye.setDepts(dept);
		dept.setEmployye(employye);
		dd.updateDept(dept);
		ed.updateEmployee(employye);
	}

	/**
	 * ����ID��ɾ��һ������
	 * 
	 * @param id
	 */
	public String delDepts(int id) {
		Depts dept = dd.getDeptsById(id);
		if (dept.getEmployyes().size() > 0) {
			return "1"; // ����������Ա��������ɾ��
		} else {
			dd.deleteDeptById(Depts.class, id);
		}
		return "2"; // ����ɾ���ɹ�
	}

	public IEmployeeDao getEd() {
		return ed;
	}

	public void setEd(IEmployeeDao ed) {
		this.ed = ed;
	}
}
