package com.netsoft.services.intf;

import java.util.List;

public interface IMenusServices {

	/**����ɾ��ĳ����ɫ��Ȩ��*/
	public abstract boolean delAllByRole(int rid, int[] menus);
   
	public boolean addAllByRole(Integer rid,Integer[] menus);
	/**����TOPIDȡ��Ӧ�Ĳ˵�ֵ*/
	public List getInitMenus(int mid);
	
	/**ȡ�����в˵�*/
	public List getAllMenus();
}