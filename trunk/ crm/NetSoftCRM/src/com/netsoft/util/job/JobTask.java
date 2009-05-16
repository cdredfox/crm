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
 * 处理系统中需要运行的自动任务
 * 
 * @author yangfei
 * 
 */
public class JobTask {
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * 客户等级：未见面意向不明确
	 */
	private static int CUSTOMER_GRADE_NOMEET=18;
	/**
	 * 客户等级：未见面预约将出单
	 */
	private static int CUSTOMER_GRADE_NOMEET_BESPEAK=19;
	/**
	 * 客户等级：已拜访未正式面谈
	 */
	private static int CUSTOMER_GRADE_VISIT_NOMEET=20;
	/**
	 * 客户等级：已正式面谈将出单
	 */
	private static int CUSTOMER_GRADE_MEET=21;
	public ICustomerstableDao icd;
	public IBusinessruletableDao ibd;

	/**
	 * 未见面意向客户公开规则设置
	 * 
	 * @return
	 */
	public boolean task001() {
		try {
			log.info("开始执行未见面意向客户公开规则设置任务.......");
			Businessruletable bt=ibd.getRuleById(1);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_NOMEET);
			log.info("共找到该状态客户对象 "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// 如果是没有反馈日期的则代表是新增客户，找他的增加日期
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("测试执行... 执行时间： "+new Date());
			log.info("任务未见面意向客户公开规则设置执行完成.......");
			return true;
		} catch (Exception e) {
			log.error("执行任务未见面意向客户公开规则设置出错了...", e);
			return false;
		}
	}

	/**
	 * 未见面预约客户公开规则设置
	 * 
	 * @return
	 */
	public boolean task002() {
		try {
			log.info("开始执行未见面预约客户公开规则设置设置任务.......");
			Businessruletable bt=ibd.getRuleById(2);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_NOMEET_BESPEAK);
			log.info("共找到该状态客户对象 "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// 如果是没有反馈日期的则代表是新增客户，找他的增加日期
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("测试执行... 执行时间： "+new Date());
			log.info("任务未见面预约客户公开规则设置执行完成.......");
			return true;
		} catch (Exception e) {
			log.error("执行任务未见面预约客户公开规则设置出错了...", e);
			return false;
		}
	}
	
	/**
	 * 已拜访未正式面谈客户公开规则设置
	 * 
	 * @return
	 */
	public boolean task003() {
		try {
			log.info("开始执行已拜访未正式面谈客户公开规则设置任务.......");
			Businessruletable bt=ibd.getRuleById(3);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_VISIT_NOMEET);
			log.info("共找到该状态客户对象 "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// 如果是没有反馈日期的则代表是新增客户，找他的增加日期
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("测试执行... 执行时间： "+new Date());
			log.info("任务已拜访未正式面谈客户公开规则设置执行完成.......");
			return true;
		} catch (Exception e) {
			log.error("执行任务已拜访未正式面谈客户公开规则设置出错了...", e);
			return false;
		}
	}
	
	/**
	 * 已正式面谈客户公开规则设置
	 * 
	 * @return
	 */
	public boolean task004() {
		try {
			log.info("开始执行已正式面谈客户公开规则设置任务.......");
			Businessruletable bt=ibd.getRuleById(4);
			int enddays=Integer.parseInt(bt.getRulevalue());
			List<Customerstable> list = icd.getCustomerByGrade(JobTask.CUSTOMER_GRADE_MEET);
			log.info("共找到该状态客户对象 "+list.size());
			for (Customerstable customerstable : list) {
				Date adddate=customerstable.getCustomerfeedbackdate();
				if(adddate==null)
				{
					// 如果是没有反馈日期的则代表是新增客户，找他的增加日期
					adddate=customerstable.getCustomeradddate();
					
				}
				int days=this.daysBetween(new Date(),adddate);
				if(days>=enddays)
				{
					customerstable.setEmployye(null);
					icd.updateCustomerstable(customerstable);
				}
			}
			// System.out.println("测试执行... 执行时间： "+new Date());
			log.info("任务已正式面谈客户公开规则设置执行完成.......");
			return true;
		} catch (Exception e) {
			log.error("执行任务已正式面谈客户公开规则设置出错了...", e);
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
	 * 求两个日期之间相差的天数
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
