package com.netsoft.dao.intf;

import java.util.List;

import com.netsoft.dao.pojos.Businessruletable;

public interface IBusinessruletableDao {
	/**
	 * �õ����еĹ�������
	 * @param brt
	 */
	public List<Businessruletable> getAllRule();
	/**
	 * �޸�һ���������ö���
	 * @param brt
	 */
	public void updateRule(Businessruletable brt);
	
	/**
	 * ����id�Ų���һ������
	 * @param id
	 * @return
	 */
	public Businessruletable getRuleById(int id);

}
