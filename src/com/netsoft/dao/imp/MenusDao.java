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
 * @author 彭媛<pengyuan>
 * @工程名 NetSoftCRM
 * @文件名 MenusDao.java
 * @编写日期 Dec 26, 2006
 * @功能说明 对权限菜单表进行操作
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
			logger.error("MenusDap中间的addMenus方法出错", e);
			return false;
		}
		
	}

	public boolean deleteMenus(Menus menus) {
		try {
			return cd.dele(menus);
		} catch (Exception e) {
			logger.error("MenusDap中间的deleteMenus方法出错", e);
			return false;
		}
		
	}

	public List<Menus> getAllMenus() {
		try {
			List<Menus> ls=cd.getObjectAll(Menus.class);
			return ls;
		} catch (Exception e) {
			logger.error("MenusDap中间的getAllMenus方法出错", e);
			return null;
		}
		
	}

	public boolean updateMenus(Menus menus) {
		try {
			return cd.updateObject(menus);
		} catch (Exception e) {
			logger.error("MenusDap中间的updateMenus方法出错", e);
			return false;
		}
		
	}

	public boolean deleteMenusById(Class cl, Serializable id) {
		try {
			return cd.dele(Menus.class, id);
		} catch (Exception e) {
			logger.error("MenusDao中间的deleteMenusById方法出错", e);
			return false;
		}
	}

	public Menus getMenusById(int mid) {
		try {
			return cd.getObjectById(Menus.class, mid);
		}catch (Exception e) {
			logger.error("MenusDao中间的getMenusById方法出错", e);
			return null;
		}
	}
	
	/**
	 * 根据topid取相应的菜单值
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
			logger.error("MenusDao中间的getMenusByTopId方法出错了",e);
			return null;
		}
	}

}
