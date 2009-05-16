package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.BusinessruletableBean;

public interface IBusinessruletableServices {
	/**
	 * 查询所有的规则
	 * @return
	 */
	public List<BusinessruletableBean> getAllRule();
	
	/**
	 * 修改一个规则
	 * @param brb
	 */
	public void updateRule(BusinessruletableBean brb);
	
	/**
	 * 根据ID查找某个规则对象
	 * @param id
	 * @return
	 */
	public BusinessruletableBean getRuleById(int id);

}
