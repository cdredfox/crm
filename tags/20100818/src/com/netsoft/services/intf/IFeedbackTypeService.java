package com.netsoft.services.intf;

import java.util.Date;
import java.util.List;

import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacktableBean;
import com.netsoft.dao.pojos.Feedbacktable;

public interface IFeedbackTypeService {
	
	/**
	 * 根据日期查找反馈报表数据
	 * @param start
	 * @param end
	 * @return
	 */
	public List getFeedbackTypeReportByDate(String start,String end);

	/**
	 * 获取某个客户的反馈记录，分页
	 * @param id
	 * @param page
	 * @param size
	 * @return
	 */
	public List<FeedbacktableBean> getFeedbackTypeByCustomerid(int id,int page,int size);
	
	/**
	 * 增加一个反馈
	 * @param ftb
	 * @return
	 */
	public boolean addFeedbackType(FeedbacktableBean ftb);
	
	/**
	 * 根据id删除一个反馈
	 * @param id
	 * @return
	 */
	public boolean delFeedbackType(int id);
	
	/**
	 * 获取分页的总记录数，为分页提供服务
	 * @return
	 */
	public int getCount(int id);
	
	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean>  data);
	
	/**
	 * 内网客户反馈统计业务报表
	 * @param companyName 公司名称
	 * @param eid 客户所有人
	 * @param dz 客户等级
	 * @param xz 客户性质
	 * @param startdate 开始日期
	 * @param enddate 结束日期
	 * @return
	 */
	public List getIntFeedBackReportData(String companyName,String eid,String dz,String xz,String startdate,String enddate,String address);
}
