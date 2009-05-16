package com.netsoft.dao.intf;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;


public interface IRolesDao {
	/**
	 * 
	 * @功能说明　添加一个角色
	 * @返回类型　boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean addRoles(Roles roles);
	/**
	 * 
	 * @功能说明　删除一个角色
	 * @返回类型　boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean deleteRoles(Roles roles);
	/**
	 * 
	 * @功能说明　根据角色id删除一个角色
	 * @返回类型　boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean deleteRolesById(Class cl,Serializable rid);
	/**
	 * 
	 * @功能说明　修改一个角色
	 * @返回类型　boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean updateRoles(Roles roles);
	/**
	 * 
	 * @功能说明　获取所有的角色
	 * @返回类型　List<Roles>
	 * @param 
	 * @return 一个List集合
	 */
	public List<Roles> getAllRoles();
	/**
	 * 
	 * @功能说明　根据角色添加权限菜单
	 * @返回类型　boolean
	 * @param  roles,menus
	 * @return 
	 */
	public boolean RolesSetMenus(Roles roles,Menus menus);
	/**
	 * 
	 * @功能说明　根据角色删除权限菜单
	 * @返回类型　boolean
	 * @param roles,menus
	 * @return 
	 */
	public boolean RolesRemoveMenus(Roles roles,Menus menus);
	
	/**
	 * 
	 * @功能说明　根据角色取得该角色下的所以菜单权限
	 * @返回类型　Set<Menus>
	 * @param roles
	 * @return 一个set集合
	 */
	public Set<Menus> getMenusByRole(Roles roles);
	/**
	 * 
	 * @功能说明　根据ID和rdelstyle获得一个角色信息
	 * @返回类型　Roles
	 * @param  id,rdelstyle
	 * @return 
	 */
	public abstract Roles getRoles(Integer id);
	/**
	 * 
	 * @功能说明　根据ID修改一个角色信息的rdelstyle此方法主要用语回收站功能
	 * @返回类型　boolean
	 * @param  id,rdelstyle
	 * @return 
	 */
	public abstract boolean updateRdelStyleOnRoles(Integer id,Integer rdelstyle);
}
