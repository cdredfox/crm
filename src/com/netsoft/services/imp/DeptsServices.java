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
			log.info("services层getDeptsById方法开始执行");
			Depts dept = dd.getDeptsById(id);
			DeptsBean db = new DeptsBean();
			BeanUtils.copyProperties(db, dept);
			db.setEmployyeName(dept.getEmployye() == null ? "" : dept
					.getEmployye().getEname());
			log.info("services层getDeptsById方法执行成功");
			return db;
		} catch (Exception e) {
			log.error("services层getDeptsById方法执行失败", e);
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
			log.info("services层getAllDepts方法开始执行");
			List li = new ArrayList();
			List<Depts> list = dd.getAllDepts();
			for (Depts depts : list) {
				DeptsBean db = new DeptsBean();
				BeanUtils.copyProperties(db, depts);
				db.setEmployyeName(depts.getEmployye() == null ? "" : depts
						.getEmployye().getEname());
				li.add(db);
			}
			log.info("services层getAllDepts方法执行成功");
			return li;
		} catch (Exception e) {
			log.error("services层getAllDepts方法执行失败", e);
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
		//将以前所管理的部门清空
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
	 * 根据一个BO对象修改一个部门
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
	 * 根据ID号删除一个部门
	 * 
	 * @param id
	 */
	public String delDepts(int id) {
		Depts dept = dd.getDeptsById(id);
		if (dept.getEmployyes().size() > 0) {
			return "1"; // 代表部门下有员工，不能删除
		} else {
			dd.deleteDeptById(Depts.class, id);
		}
		return "2"; // 代表删除成功
	}

	public IEmployeeDao getEd() {
		return ed;
	}

	public void setEd(IEmployeeDao ed) {
		this.ed = ed;
	}
}
