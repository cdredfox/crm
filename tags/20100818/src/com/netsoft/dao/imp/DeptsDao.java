package com.netsoft.dao.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IDeptsDao;
import com.netsoft.dao.pojos.Depts;

/**
 * @author 彭媛<pengyuan>
 * @工程名 NetSoftCRM
 * @文件名 DeptsDao.java
 * @编写日期 Dec 27, 2006
 * @功能说明 对部门表进行操作
 */
public class DeptsDao implements IDeptsDao {
	Logger logger = Logger.getLogger(this.getClass());
	private ICommonDao cd;
	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}

	public boolean addDept(Depts depts) {
		try {
			return cd.add(depts);
		} catch (Exception e) {
			logger.error("DeptsDao中间的addDept方法出错", e);
			return false;
		}
		
	}

	public boolean deleteDept(Depts depts) {
		try {
			return cd.dele(depts);
		} catch (Exception e) {
			logger.error("DeptsDao中间的deleteDept方法出错", e);
			return false;
		}
		
	}

	public List<Depts> getAllDepts() {
		try {
			List<Depts> ls = cd.getObjectAll(Depts.class);
			return ls;
		} catch (Exception e) {
			logger.error("DeptsDao中间的getAllDept方法出错", e);
			return null;
		}
		
	}

	public boolean updateDept(Depts depts) {
		try {
			return cd.updateObject(depts);
		} catch (Exception e) {
			logger.error("DeptsDao中间的updateDept方法出错", e);
			return false;
		}
		
	}

	public boolean deleteDeptById(Class cl, Serializable id) {
		try {
			return cd.dele(Depts.class, id);
		} catch (Exception e) {
			logger.error("DeptsDao中间的deleteDeptById方法出错", e);
			return false;
		}	
	}
	
	/**根据部门ID查找部门对象*/
	public Depts getDeptsById(int id)
	{
	   try {
		return cd.getObjectById(Depts.class, id);
	} catch (Exception e) {
		logger.error("DeptsDao中间的getDeptsById方法出错", e);
		return null;
	}
	}
	
	/**
	 * 根据员工查找其所属的部门
	 * @param id
	 * @return
	 */
	public List getDeptsByEid(int id)
	{
		 String hql="from Depts as d where d.employye=:employye";
		 HashMap hm=new HashMap();
		 hm.put("employye",id);
		return cd.getObjectByHql(hql, hm);
	}
}
