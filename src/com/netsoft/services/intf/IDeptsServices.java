package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.DeptsBean;

public interface IDeptsServices {

	/**根据部门ID得到部门对象*/
	public abstract DeptsBean getDeptsById(int id);

	public abstract List getAllDepts();
	
	/**
	 * 根据一个BO对象增加一个部门
	 * @param db
	 */
	public abstract void addDepts(DeptsBean db);
	
	/**
	 * 根据一个BO对象修改一个部门
	 * @param db
	 */
	public abstract void updateDepts(DeptsBean db);
	
	/**
	 * 根据ID号删除一个部门
	 * @param id
	 */
	public abstract String delDepts(int id);
	

}