package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.Feedbacktable;

public interface IFeedbacktypeDao {
	public List getFeedbackByWhere(String hql,HashMap hm,int page,int size);
	/**
	 * 根据ID查找一个反馈对象
	 * @param id
	 * @return
	 */
	public Feedbacktable getFeedbackByid(int id);
	/**
	 * 增加一个反馈对象
	 * @param fb
	 * @return
	 */
	public boolean addFeedbackTable(Feedbacktable fb);
	
	/**
	 * 根据ID删除一个反馈对象
	 * @param id
	 * @return
	 */
	public boolean delFeekback(int id);

}
