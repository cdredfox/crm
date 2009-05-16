package com.netsoft.dao.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IDeptsDao;
import com.netsoft.dao.pojos.Depts;

/**
 * @author ����<pengyuan>
 * @������ NetSoftCRM
 * @�ļ��� DeptsDao.java
 * @��д���� Dec 27, 2006
 * @����˵�� �Բ��ű���в���
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
			logger.error("DeptsDao�м��addDept��������", e);
			return false;
		}
		
	}

	public boolean deleteDept(Depts depts) {
		try {
			return cd.dele(depts);
		} catch (Exception e) {
			logger.error("DeptsDao�м��deleteDept��������", e);
			return false;
		}
		
	}

	public List<Depts> getAllDepts() {
		try {
			List<Depts> ls = cd.getObjectAll(Depts.class);
			return ls;
		} catch (Exception e) {
			logger.error("DeptsDao�м��getAllDept��������", e);
			return null;
		}
		
	}

	public boolean updateDept(Depts depts) {
		try {
			return cd.updateObject(depts);
		} catch (Exception e) {
			logger.error("DeptsDao�м��updateDept��������", e);
			return false;
		}
		
	}

	public boolean deleteDeptById(Class cl, Serializable id) {
		try {
			return cd.dele(Depts.class, id);
		} catch (Exception e) {
			logger.error("DeptsDao�м��deleteDeptById��������", e);
			return false;
		}	
	}
	
	/**���ݲ���ID���Ҳ��Ŷ���*/
	public Depts getDeptsById(int id)
	{
	   try {
		return cd.getObjectById(Depts.class, id);
	} catch (Exception e) {
		logger.error("DeptsDao�м��getDeptsById��������", e);
		return null;
	}
	}
	
	/**
	 * ����Ա�������������Ĳ���
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
