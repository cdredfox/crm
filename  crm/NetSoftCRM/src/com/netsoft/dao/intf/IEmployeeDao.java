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
	 * @功能说明　根据传进来的用户VI对象的帐户与密码来取得相应的POJO对象
	 * @返回类型　Employye
	 * @param eb
	 * @return 
	 */
	public abstract Employye getEmployyeByeAccountAndPwd(Employye eb);
   
	/**
	 * 
	 * @功能说明　给员工增加一个角色
	 * @返回类型　boolean
	 * @return
	 */
	public boolean EmployeeSetRole(Employye em,Roles role);
	
	
	/**
	 * 
	 * @功能说明　给员工删掉一个角色
	 * @返回类型　boolean
	 * @param em
	 * @param role
	 * @return
	 */
	public boolean EmployeeRemoveRole(Employye em,Roles role);
	
	/**
	 * 
	 * @功能说明　根据员工对象取得员工所属的所有角色列表
	 * @返回类型　List
	 * @param em
	 * @return  返回一个角色的Set集合
	 */
	public Set getRolesByEmployee(Employye em);
    /**
     * 
     * @功能说明　根据员工ID得到员工对象
     * @返回类型　Employye
     * @param em
     * @return
     */
    public Employye getEmployeeById(int id);
    /**
     * 
     * @功能说明　根据员工ID和EdelStyle查询
     * @返回类型　boolean 
     * @param id,edelstyle
     * @return
     */
    public Employye getEmployeeEdelStyleId(Integer id);

    /**得到所有的员工对象*/
    
    public List getAllEmployee(); 
    
    /**根据传过来的对象删除一个员工*/
	public boolean delEmployee(Employye em);
	
	/**增加员工*/
	 public boolean addEmployee(Employye ed);
	 
	 /**修改员工*/
	   public boolean updateEmployee(Employye em);
	   
	  /**根据某种条件与值查询员工
	   *  str1 条件
	   *  str2　值
	   * */
	   public List findEmployyeByAny(String str1,String str2);
	   
	   /**
	    * 根据条件来查询
	    * @param hm
	    * @return
	    */
	   public List findEmployyeByHashMap(HashMap hm);
}