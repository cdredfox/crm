package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netsoft.dao.pojos.Feedbacktable;

public interface IFeedbacktypeDao {
	public List getFeedbackByWhere(String hql,Map<String,Object> hm,int page,int size);
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
	
	/**
	 * 取得每日反馈报表的数据
	 * @param sql
	 * @param values
	 * @return
	 */
	public List getFeedbackDaliyReportData(String sql,Object[] values);

}
