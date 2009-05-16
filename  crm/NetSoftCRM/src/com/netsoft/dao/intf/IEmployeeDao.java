package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.imp.EmployeeDao;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Roles;

public interface IEmployeeDao {

	/**
	 * 
	 * @����˵�������ݴ��������û�VI������ʻ���������ȡ����Ӧ��POJO����
	 * @�������͡�Employye
	 * @param eb
	 * @return 
	 */
	public abstract Employye getEmployyeByeAccountAndPwd(Employye eb);
   
	/**
	 * 
	 * @����˵������Ա������һ����ɫ
	 * @�������͡�boolean
	 * @return
	 */
	public boolean EmployeeSetRole(Employye em,Roles role);
	
	
	/**
	 * 
	 * @����˵������Ա��ɾ��һ����ɫ
	 * @�������͡�boolean
	 * @param em
	 * @param role
	 * @return
	 */
	public boolean EmployeeRemoveRole(Employye em,Roles role);
	
	/**
	 * 
	 * @����˵��������Ա������ȡ��Ա�����������н�ɫ�б�
	 * @�������͡�List
	 * @param em
	 * @return  ����һ����ɫ��Set����
	 */
	public Set getRolesByEmployee(Employye em);
    /**
     * 
     * @����˵��������Ա��ID�õ�Ա������
     * @�������͡�Employye
     * @param em
     * @return
     */
    public Employye getEmployeeById(int id);
    /**
     * 
     * @����˵��������Ա��ID��EdelStyle��ѯ
     * @�������͡�boolean 
     * @param id,edelstyle
     * @return
     */
    public Employye getEmployeeEdelStyleId(Integer id);

    /**�õ����е�Ա������*/
    
    public List getAllEmployee(); 
    
    /**���ݴ������Ķ���ɾ��һ��Ա��*/
	public boolean delEmployee(Employye em);
	
	/**����Ա��*/
	 public boolean addEmployee(Employye ed);
	 
	 /**�޸�Ա��*/
	   public boolean updateEmployee(Employye em);
	   
	  /**����ĳ��������ֵ��ѯԱ��
	   *  str1 ����
	   *  str2��ֵ
	   * */
	   public List findEmployyeByAny(String str1,String str2);
	   
	   /**
	    * ������������ѯ
	    * @param hm
	    * @return
	    */
	   public List findEmployyeByHashMap(HashMap hm);
}