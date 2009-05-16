package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.Feedbacktable;

public interface IFeedbacktypeDao {
	public List getFeedbackByWhere(String hql,HashMap hm,int page,int size);
	/**
	 * ����ID����һ����������
	 * @param id
	 * @return
	 */
	public Feedbacktable getFeedbackByid(int id);
	/**
	 * ����һ����������
	 * @param fb
	 * @return
	 */
	public boolean addFeedbackTable(Feedbacktable fb);
	
	/**
	 * ����IDɾ��һ����������
	 * @param id
	 * @return
	 */
	public boolean delFeekback(int id);

}
