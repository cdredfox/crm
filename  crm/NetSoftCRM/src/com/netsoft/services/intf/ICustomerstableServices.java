package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.CustomerstableBean;

public interface ICustomerstableServices {
	public int INVALI_CUSTOMER_GRADE=999999;//失效的客户等级
	/**
	 * 根据传进来的电话和姓名来检查客户是否已存在
	 * @param type
	 * @param number
	 * @param name
	 * @return
	 */
	public int checkCustomer(String type,String number,String name);
	/**
	 * 得到某员工名下的所有客户信息
	 * @param id
	 * @return
	 */
	public List<CustomerstableBean> getAllCustomerByEid(int id,int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 取得所有的公开客户信息
	 * @return
	 */
	public List<CustomerstableBean> getAllOpenCustomer(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 取所有的撤销客信息
	 * @param page
	 * @param size
	 * @return
	 */
	public List<CustomerstableBean> getAllInvaliCustomer(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 取得所有的客户信息
	 * @return
	 */
	public List<CustomerstableBean> getAllCustomer(int page,int size,String company,int eid,String startdate,String enddate);
	/**
	 * 增加一个客户信息
	 * @param cb
	 * @return
	 */
	public String addCustomer(CustomerstableBean cb);
	
	/**
	 * 取得某员工名下所有客户的合计数
	 * @param eid
	 * @return
	 */
	public int getCount(int eid,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 得到所有公开客户的数量
	 * @return
	 */
	public int getOpenCount(String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 得到所有的失效客户信息
	 * @return
	 */
	public int getInvaliCount(String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 得到所有客户的数量
	 * @return
	 */
	public int getAllCount(String company,int eid,String startdate,String enddate);
	/**
	 * 删除一个客户信息
	 * @param id
	 * @param flag 是不是真正的删除
	 * @return
	 */
	public boolean delCustomerByFlag(int id,String flag);
	/**
	 * 根据客户ID得到客户对象
	 * @param id
	 * @return
	 */
	public CustomerstableBean getCustomerById(int id);
	
	/**
	 * 根据业务对象更新一个客户对象
	 * @param ctb
	 * @return
	 */
	public boolean updateCustomer(CustomerstableBean ctb);
	/**
	 * 将指定的客户信息设为公开
	 * @param id
	 * @return
	 */
	public boolean changeCustomerOpen(int id);
	/**
	 * 删除一个客户信息
	 * @param id
	 * @return
	 */
	public boolean delCustomer(int id);
	
}
