package com.netsoft.services.intf;

import java.util.List;

public interface IMenusServices {

	/**批量删除某个角色的权限*/
	public abstract boolean delAllByRole(int rid, int[] menus);
   
	public boolean addAllByRole(Integer rid,Integer[] menus);
	/**根据TOPID取相应的菜单值*/
	public List getInitMenus(int mid);
	
	/**取得所有菜单*/
	public List getAllMenus();
}