package com.netsoft.dao.intf;

import java.io.Serializable;
import java.util.List;


import com.netsoft.dao.pojos.Menus;



public interface IMenusDao {
	/**
	 * 
	 * @功能说明　添加权限菜单
	 * @返回类型　boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean addMenus(Menus menus);
	/**
	 * 
	 * @功能说明　删除权限菜单
	 * @返回类型　boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean deleteMenus(Menus menus);
	/**
	 * 
	 * @功能说明　根据id删除权限菜单
	 * @返回类型　boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean deleteMenusById(Class cl,Serializable id);
	/**
	 * 
	 * @功能说明　修改权限菜单
	 * @返回类型　boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean updateMenus(Menus menus);
	/**
	 * 
	 * @功能说明　获取所有权限菜单
	 * @返回类型　List<Menus>
	 * @param 
	 * @return 一个List集合
	 */
	public List<Menus> getAllMenus();
	
	/**根据id查找权限*/
	public abstract Menus getMenusById(int mid);
	
	/**
	 * 根据topid取相应的菜单值
	 * @param topid
	 * @return
	 */
	public List getMenusByTopId(int topid);
}
