package com.netsoft.dao.intf;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;


public interface IRolesDao {
	/**
	 * 
	 * @����˵�������һ����ɫ
	 * @�������͡�boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean addRoles(Roles roles);
	/**
	 * 
	 * @����˵����ɾ��һ����ɫ
	 * @�������͡�boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean deleteRoles(Roles roles);
	/**
	 * 
	 * @����˵�������ݽ�ɫidɾ��һ����ɫ
	 * @�������͡�boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean deleteRolesById(Class cl,Serializable rid);
	/**
	 * 
	 * @����˵�����޸�һ����ɫ
	 * @�������͡�boolean
	 * @param roles
	 * @return 
	 */
	public abstract boolean updateRoles(Roles roles);
	/**
	 * 
	 * @����˵������ȡ���еĽ�ɫ
	 * @�������͡�List<Roles>
	 * @param 
	 * @return һ��List����
	 */
	public List<Roles> getAllRoles();
	/**
	 * 
	 * @����˵�������ݽ�ɫ���Ȩ�޲˵�
	 * @�������͡�boolean
	 * @param  roles,menus
	 * @return 
	 */
	public boolean RolesSetMenus(Roles roles,Menus menus);
	/**
	 * 
	 * @����˵�������ݽ�ɫɾ��Ȩ�޲˵�
	 * @�������͡�boolean
	 * @param roles,menus
	 * @return 
	 */
	public boolean RolesRemoveMenus(Roles roles,Menus menus);
	
	/**
	 * 
	 * @����˵�������ݽ�ɫȡ�øý�ɫ�µ����Բ˵�Ȩ��
	 * @�������͡�Set<Menus>
	 * @param roles
	 * @return һ��set����
	 */
	public Set<Menus> getMenusByRole(Roles roles);
	/**
	 * 
	 * @����˵��������ID��rdelstyle���һ����ɫ��Ϣ
	 * @�������͡�Roles
	 * @param  id,rdelstyle
	 * @return 
	 */
	public abstract Roles getRoles(Integer id);
	/**
	 * 
	 * @����˵��������ID�޸�һ����ɫ��Ϣ��rdelstyle�˷�����Ҫ�������վ����
	 * @�������͡�boolean
	 * @param  id,rdelstyle
	 * @return 
	 */
	public abstract boolean updateRdelStyleOnRoles(Integer id,Integer rdelstyle);
}
