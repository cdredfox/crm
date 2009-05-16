package com.netsoft.services.intf;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;

public interface IEmployeeServices {

	public abstract EmployeeBean isCheckLogin(EmployeeBean eb);
    
	public Set<Menus> getMenusByEmployee(EmployeeBean eb);
   
	public EmployeeBean getEmployyeById(int id);
	
	/**�õ����е�Ա��*/
	public List getAllEmployee();
	/**����IDɾ��һ��Ա��*/
	public String delEmployee(int id);
	
/**����Ա������*/
	
	public boolean addEmployye(EmployeeBean eb);
	
	/**�޸�Ա������*/
	public boolean updateEmployye(EmployeeBean eb);
	
	/**����ĳ������ѯԱ������*/
	
	public List<EmployeeBean> findEmployeeByAny(String any,String code);
	
	/**��ҳ*/
	public List CurrentPage(int page,int size);
	
	/** ���ݲ�ѯ�����õ�����Ա�� */

	public List CurrentPageQry(int page, int size,HashMap hm);
	
	/**������ĳԱ����Ȩ*/
	
	public boolean sendRole(Integer role[],int eid);
	
	/**�ܼ�¼��*/
	public int getCount();
	
	/**
	 * �õ���������ѯ�ļ�¼��
	 * @return
	 */
	public int getCountQry();
	
	/**
	 * ��ĳԱ�����µ����пͻ�ת�Ƶ���һԱ���£����toId=0 �����������ת���κ��������¡�
	 * @param id
	 * @param toId
	 */
	public boolean changCustomerOwener(int id,int toId);
	/**
	 * ��ѯ��ҳ���ܼ�¼
	 * @return
	 */
	public int getCountByCurrentPage(HashMap hm);
}