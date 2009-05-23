package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.FeedbackReportBean;

/**
 * 报表service
 * @author yangfei
 *
 */
public interface IReportServices {
	
	/**
	 * 新增客户统计报表
	 * @param startdate
	 * @param enddate
	 * @param type
	 * @return
	 */
	public List getBusiCountReportData(String startdate,String enddate);
	
	/**
	 * 综合统计报表
	 * @param startdate
	 * @param enddate
	 * @param type
	 * @return
	 */
	public List getAddCoustomerReportData(String startdate,String enddate,String type,String customergrade);
	
	/**
	 * 计算汇总行
	 * @param data
	 * @param ftype
	 * @return
	 */
	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean> data,String ftype);
	
	/**
	 * 各业务人员当前客户统计数据报表
	 * @return
	 */
	public List getBusiOwenCustomer();
	

}
