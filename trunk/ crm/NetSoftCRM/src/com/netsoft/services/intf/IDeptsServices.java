package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.DeptsBean;

public interface IDeptsServices {

	/**���ݲ���ID�õ����Ŷ���*/
	public abstract DeptsBean getDeptsById(int id);

	public abstract List getAllDepts();
	
	/**
	 * ����һ��BO��������һ������
	 * @param db
	 */
	public abstract void addDepts(DeptsBean db);
	
	/**
	 * ����һ��BO�����޸�һ������
	 * @param db
	 */
	public abstract void updateDepts(DeptsBean db);
	
	/**
	 * ����ID��ɾ��һ������
	 * @param id
	 */
	public abstract String delDepts(int id);
	

}