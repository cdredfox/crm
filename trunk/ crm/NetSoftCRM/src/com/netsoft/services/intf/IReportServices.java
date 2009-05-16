package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.FeedbackReportBean;

/**
 * ����service
 * @author yangfei
 *
 */
public interface IReportServices {
	
	/**
	 * �����ͻ�ͳ�Ʊ���
	 * @param startdate
	 * @param enddate
	 * @param type
	 * @return
	 */
	public List getBusiCountReportData(String startdate,String enddate);
	
	/**
	 * �ۺ�ͳ�Ʊ���
	 * @param startdate
	 * @param enddate
	 * @param type
	 * @return
	 */
	public List getAddCoustomerReportData(String startdate,String enddate,String type,String customergrade);
	
	/**
	 * ���������
	 * @param data
	 * @param ftype
	 * @return
	 */
	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean> data,String ftype);
	
	/**
	 * ��ҵ����Ա��ǰ�ͻ�ͳ�����ݱ���
	 * @return
	 */
	public List getBusiOwenCustomer();
	

}
