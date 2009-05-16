package com.netsoft.dao.intf;

import java.io.Serializable;
import java.util.List;


import com.netsoft.dao.pojos.Menus;



public interface IMenusDao {
	/**
	 * 
	 * @����˵�������Ȩ�޲˵�
	 * @�������͡�boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean addMenus(Menus menus);
	/**
	 * 
	 * @����˵����ɾ��Ȩ�޲˵�
	 * @�������͡�boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean deleteMenus(Menus menus);
	/**
	 * 
	 * @����˵��������idɾ��Ȩ�޲˵�
	 * @�������͡�boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean deleteMenusById(Class cl,Serializable id);
	/**
	 * 
	 * @����˵�����޸�Ȩ�޲˵�
	 * @�������͡�boolean
	 * @param menus
	 * @return 
	 */
	public abstract boolean updateMenus(Menus menus);
	/**
	 * 
	 * @����˵������ȡ����Ȩ�޲˵�
	 * @�������͡�List<Menus>
	 * @param 
	 * @return һ��List����
	 */
	public List<Menus> getAllMenus();
	
	/**����id����Ȩ��*/
	public abstract Menus getMenusById(int mid);
	
	/**
	 * ����topidȡ��Ӧ�Ĳ˵�ֵ
	 * @param topid
	 * @return
	 */
	public List getMenusByTopId(int topid);
}
