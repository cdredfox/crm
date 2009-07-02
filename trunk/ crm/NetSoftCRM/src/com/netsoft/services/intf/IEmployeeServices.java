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
	
	/**得到所有的员工*/
	public List getAllEmployee();
	/**根据ID删除一个员工*/
	public String delEmployee(int id);
	
/**保存员工对象*/
	
	public boolean addEmployye(EmployeeBean eb);
	
	/**修改员工对象*/
	public boolean updateEmployye(EmployeeBean eb);
	
	/**根据某条件查询员工集合*/
	
	public List<EmployeeBean> findEmployeeByAny(String any,String code);
	
	/**分页*/
	public List CurrentPage(int page,int size);
	
	/** 根据查询条件得到部分员工 */

	public List CurrentPageQry(int page, int size,HashMap hm);
	
	/**批量给某员工授权*/
	
	public boolean sendRole(Integer role[],int eid);
	
	/**总记录数*/
	public int getCount();
	
	/**
	 * 得到按条件查询的记录数
	 * @return
	 */
	public int getCountQry();
	
	/**
	 * 将某员工名下的所有客户转移到另一员工下，如果toId=0 则代表公开，不转到任何人名义下。
	 * @param id
	 * @param toId
	 */
	public boolean changCustomerOwener(int id,int toId);
	/**
	 * 查询分页的总记录
	 * @return
	 */
	public int getCountByCurrentPage(HashMap hm);
	
	/**
	 * 查询某个员工下所有的下属
	 * @param topId
	 * @return
	 */
	public List<EmployeeBean> getEmployeesByTopId(int topId);
	
	 /**
	    * 批量设置一批员工
	    * @param eids
	    * @param topId
	    * @return
	    */
	   public boolean batchUpdateEmployye(Integer[] eids,int topId);
}