package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.BusinessruletableBean;

public interface IBusinessruletableServices {
	/**
	 * ��ѯ���еĹ���
	 * @return
	 */
	public List<BusinessruletableBean> getAllRule();
	
	/**
	 * �޸�һ������
	 * @param brb
	 */
	public void updateRule(BusinessruletableBean brb);
	
	/**
	 * ����ID����ĳ���������
	 * @param id
	 * @return
	 */
	public BusinessruletableBean getRuleById(int id);

}
