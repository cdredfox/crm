package com.netsoft.services.intf;

import java.util.List;
import java.util.Set;

import com.netsoft.dao.beans.RolesBean;

public interface IRoleServices {
	
	/**ȡ�����еĽ�ɫ*/
	public abstract List getAllRoles();
	
	/**�޸Ľ�ɫ״̬��0��Ч��1��Ч*/
	public abstract boolean changeStyle(int cid,int style);
   
	/**ȡ��ĳ��ɫ���������Ȩ��*/
	public abstract Set getMenusByRole(int rid);
	
	/**����һ����ɫ*/
	public abstract boolean addRole(RolesBean rb);
	
	/**���ݽ�ɫIDɾ��һ����ɫ*/
	public abstract String delRoleById(int id);
	/**
	 * ����ID�õ���ɫ��
	 * @param id
	 * @return
	 */
	public abstract String getRoleNameById(int id);
	/**
	 * ����һ��BO��ɫ�����޸Ľ�ɫ�Ķ���
	 * @param rb
	 * @return
	 */
	public abstract boolean updateRole(RolesBean rb);
}