package com.netsoft.services.intf;

import java.util.List;
import java.util.Set;

import com.netsoft.dao.beans.RolesBean;

public interface IRoleServices {
	
	/**取得所有的角色*/
	public abstract List getAllRoles();
	
	/**修改角色状态。0有效　1无效*/
	public abstract boolean changeStyle(int cid,int style);
   
	/**取得某角色下面的所有权限*/
	public abstract Set getMenusByRole(int rid);
	
	/**增加一个角色*/
	public abstract boolean addRole(RolesBean rb);
	
	/**根据角色ID删除一个角色*/
	public abstract String delRoleById(int id);
	/**
	 * 根据ID得到角色名
	 * @param id
	 * @return
	 */
	public abstract String getRoleNameById(int id);
	/**
	 * 根据一个BO角色对象修改角色的对象
	 * @param rb
	 * @return
	 */
	public abstract boolean updateRole(RolesBean rb);
}