package com.netsoft.util.job;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.intf.IBusinessruletableDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.pojos.Businessruletable;
import com.netsoft.dao.pojos.Customerstable;

/**
 * ����ϵͳ����Ҫ���е��Զ�����
 * 
 * @author yangfei
 * 
 */
public class JobTask {
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * �ͻ��ȼ���δ����������ȷ
	 */
	private static int CUSTOMER_GRADE_NOMEET=18;
	/**
	 * �ͻ��ȼ���δ����ԤԼ������
	 */
	private static int CUSTOMER_GRADE_NOMEET_BESPEAK=19;
	/**
	 * �ͻ��ȼ����Ѱݷ�δ��ʽ��̸
	 */
	private static int CUSTOMER_GRADE_VISIT_NOMEET=20;
	/**
	 * �ͻ��ȼ�������ʽ��̸������
	 */
	private static int CUSTOMER_GRADE_MEET=21;
	public ICustomerstableDao icd;
	public IBusinessruletableDao ibd;

	/**
	 * δ��������ͻ�������������
	 * 
	 * @return
	 */
	public boolean task001() {
		try {
			log.info("��ʼִ��δ��������ͻ�����������������.......");
			Businessruletable bt=ibd.getRuleById(1);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_NOMEET);
			log.info("���ҵ���״̬�ͻ����� "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// �����û�з������ڵ�������������ͻ�����������������
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("����ִ��... ִ��ʱ�䣺 "+new Date());
			log.info("����δ��������ͻ�������������ִ�����.......");
			return true;
		} catch (Exception e) {
			log.error("ִ������δ��������ͻ������������ó�����...", e);
			return false;
		}
	}

	/**
	 * δ����ԤԼ�ͻ�������������
	 * 
	 * @return
	 */
	public boolean task002() {
		try {
			log.info("��ʼִ��δ����ԤԼ�ͻ���������������������.......");
			Businessruletable bt=ibd.getRuleById(2);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_NOMEET_BESPEAK);
			log.info("���ҵ���״̬�ͻ����� "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// �����û�з������ڵ�������������ͻ�����������������
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("����ִ��... ִ��ʱ�䣺 "+new Date());
			log.info("����δ����ԤԼ�ͻ�������������ִ�����.......");
			return true;
		} catch (Exception e) {
			log.error("ִ������δ����ԤԼ�ͻ������������ó�����...", e);
			return false;
		}
	}
	
	/**
	 * �Ѱݷ�δ��ʽ��̸�ͻ�������������
	 * 
	 * @return
	 */
	public boolean task003() {
		try {
			log.info("��ʼִ���Ѱݷ�δ��ʽ��̸�ͻ�����������������.......");
			Businessruletable bt=ibd.getRuleById(3);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_VISIT_NOMEET);
			log.info("���ҵ���״̬�ͻ����� "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// �����û�з������ڵ�������������ͻ�����������������
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("����ִ��... ִ��ʱ�䣺 "+new Date());
			log.info("�����Ѱݷ�δ��ʽ��̸�ͻ�������������ִ�����.......");
			return true;
		} catch (Exception e) {
			log.error("ִ�������Ѱݷ�δ��ʽ��̸�ͻ������������ó�����...", e);
			return false;
		}
	}
	
	/**
	 * ����ʽ��̸�ͻ�������������
	 * 
	 * @return
	 */
	public boolean task004() {
		try {
			log.info("��ʼִ������ʽ��̸�ͻ�����������������.......");
			Businessruletable bt=ibd.getRuleById(4);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_MEET);
			log.info("���ҵ���״̬�ͻ����� "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// �����û�з������ڵ�������������ͻ�����������������
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("����ִ��... ִ��ʱ�䣺 "+new Date());
			log.info("��������ʽ��̸�ͻ�������������ִ�����.......");
			return true;
		} catch (Exception e) {
			log.error("ִ����������ʽ��̸�ͻ������������ó�����...", e);
			return false;
		}
	}
	
	public ICustomerstableDao getIcd() {
		return icd;
	}

	public void setIcd(ICustomerstableDao icd) {
		this.icd = icd;
	}

	/**
	 * ����������֮����������
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public int daysBetween(Date d1, Date d2) {
		GregorianCalendar calendar1 = new GregorianCalendar();
		GregorianCalendar calendar2 = new GregorianCalendar();
		calendar1.setTime(d1);
		calendar2.setTime(d2);
		calendar1.set(java.util.GregorianCalendar.HOUR_OF_DAY, 0);
		calendar1.set(java.util.GregorianCalendar.MINUTE, 0);
		calendar1.set(java.util.GregorianCalendar.SECOND, 0);
		calendar1.set(java.util.GregorianCalendar.HOUR_OF_DAY, 0);
		calendar1.set(java.util.GregorianCalendar.MINUTE, 0);
		calendar1.set(java.util.GregorianCalendar.SECOND, 0);
		int days = ((int) (calendar1.getTime().getTime() / 1000) - (int) (calendar2
				.getTime().getTime() / 1000)) / 3600 / 24;
		return days;
	}

	public void mainTask()
	{
		this.task001();
		this.task002();
		this.task003();
		this.task004();
	}
	public IBusinessruletableDao getIbd() {
		return ibd;
	}

	public void setIbd(IBusinessruletableDao ibd) {
		this.ibd = ibd;
	}
}
