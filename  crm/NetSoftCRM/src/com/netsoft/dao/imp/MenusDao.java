package com.netsoft.dao.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IMenusDao;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;

/**
 * @author ����<pengyuan>
 * @������ NetSoftCRM
 * @�ļ��� MenusDao.java
 * @��д���� Dec 26, 2006
 * @����˵�� ��Ȩ�޲˵�����в���
 */
public class MenusDao implements IMenusDao {
	Logger logger = Logger.getLogger(this.getClass());
	private ICommonDao cd;
	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}

	public boolean addMenus(Menus menus) {
		try {
			return cd.add(menus);
		} catch (Exception e) {
			logger.error("MenusDap�м��addMenus��������", e);
			return false;
		}
		
	}

	public boolean deleteMenus(Menus menus) {
		try {
			return cd.dele(menus);
		} catch (Exception e) {
			logger.error("MenusDap�м��deleteMenus��������", e);
			return false;
		}
		
	}

	public List<Menus> getAllMenus() {
		try {
			List<Menus> ls=cd.getObjectAll(Menus.class);
			return ls;
		} catch (Exception e) {
			logger.error("MenusDap�м��getAllMenus��������", e);
			return null;
		}
		
	}

	public boolean updateMenus(Menus menus) {
		try {
			return cd.updateObject(menus);
		} catch (Exception e) {
			logger.error("MenusDap�м��updateMenus��������", e);
			return false;
		}
		
	}

	public boolean deleteMenusById(Class cl, Serializable id) {
		try {
			return cd.dele(Menus.class, id);
		} catch (Exception e) {
			logger.error("MenusDao�м��deleteMenusById��������", e);
			return false;
		}
	}

	public Menus getMenusById(int mid) {
		try {
			return cd.getObjectById(Menus.class, mid);
		}catch (Exception e) {
			logger.error("MenusDao�м��getMenusById��������", e);
			return null;
		}
	}
	
	/**
	 * ����topidȡ��Ӧ�Ĳ˵�ֵ
	 * @param topid
	 * @return
	 */
	public List getMenusByTopId(int topid)
	{
		try {
			String hql="from Menus as m where m.mtopId=:topid";
			HashMap hm=new HashMap();
			hm.put("topid", topid);
			return cd.getObjectByHql(hql, hm);
		} catch (Exception e) {
			logger.error("MenusDao�м��getMenusByTopId����������",e);
			return null;
		}
	}

}
