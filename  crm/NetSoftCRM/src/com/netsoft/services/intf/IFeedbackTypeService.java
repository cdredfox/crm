package com.netsoft.services.intf;

import java.util.Date;
import java.util.List;

import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacktableBean;
import com.netsoft.dao.pojos.Feedbacktable;

public interface IFeedbackTypeService {
	
	/**
	 * �������ڲ��ҷ�����������
	 * @param start
	 * @param end
	 * @return
	 */
	public List getFeedbackTypeReportByDate(String start,String end);

	/**
	 * ��ȡĳ���ͻ��ķ�����¼����ҳ
	 * @param id
	 * @param page
	 * @param size
	 * @return
	 */
	public List<FeedbacktableBean> getFeedbackTypeByCustomerid(int id,int page,int size);
	
	/**
	 * ����һ������
	 * @param ftb
	 * @return
	 */
	public boolean addFeedbackType(FeedbacktableBean ftb);
	
	/**
	 * ����idɾ��һ������
	 * @param id
	 * @return
	 */
	public boolean delFeedbackType(int id);
	
	/**
	 * ��ȡ��ҳ���ܼ�¼����Ϊ��ҳ�ṩ����
	 * @return
	 */
	public int getCount(int id);
	
	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean>  data);
	
	/**
	 * �����ͻ�����ͳ��ҵ�񱨱�
	 * @param companyName ��˾����
	 * @param eid �ͻ�������
	 * @param dz �ͻ��ȼ�
	 * @param xz �ͻ�����
	 * @param startdate ��ʼ����
	 * @param enddate ��������
	 * @return
	 */
	public List getIntFeedBackReportData(String companyName,String eid,String dz,String xz,String startdate,String enddate,String address);
}
