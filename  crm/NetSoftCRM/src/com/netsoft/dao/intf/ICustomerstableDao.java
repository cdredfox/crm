package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.Customerstable;

public interface ICustomerstableDao {
	
	/**
	 * 更新一个客户对象
	 */
	public void updateCustomerstable(Customerstable cu);
	/**
	 * 增加一个客户对象
	 * @param cu
	 */
	public <cl> cl addCustomerstable(Customerstable cu);
	/**
	 * 根据客户ID删除一个客户对象
	 * @param id
	 */
	public boolean delCustomerstable(int id);
	/**
	 * 取得所有的客户对象
	 */
	public List<Customerstable> getAllCustomerstable(int page,int size,String company,int eid,String startdate,String enddate);
	/**
	 * 根据员工ID取得该员工名下的所有客户对象 分页
	 * @param eid
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Customerstable> getCustomersByEid(int eid,int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 取得所有公开的客户对象
	 */
	public List<Customerstable> getCustomersByOpen(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	
	/**
	 * 取所有失销客户
	 * @return
	 */
	public List<Customerstable> getCustomersByInvali(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 
	 * @param hm
	 * @param hql
	 * @return
	 */
	
	public List<Customerstable> getCustomersByAny(HashMap hm,String hql);
	
	/**
	 * 查某员工名下的某等级的所有客户
	 * @param eid
	 * @param grade
	 * @return
	 */
	public List<Customerstable> getCustomerByEidAndGrade(int eid,int grade);
	
	/**
	 * 根据客户ID得到一个持久化客户对象
	 * @param id
	 * @return
	 */
	public Customerstable getCustomerById(int id);
	
	public List<Customerstable> getCustomerByGrade(int grade);
}
