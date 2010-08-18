package com.netsoft.util.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.services.intf.IFeedbackTypeService;
import com.netsoft.services.intf.IReportServices;
import com.netsoft.util.job.JobTask;

import junit.framework.TestCase;

public class TestCustomer{

	public void setUp() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml","servicesContext.xml"});
		IReportServices service=(IReportServices) appContext.getBean("IReportServices");
		//JobTask task=(JobTask) appContext.getBean("task");
		//task.task001();
	//	service.getFeedbackTypeReportByDate(new Date("2008-04-01"), new Date());
		}

	public static void main(String[] args) {
		TestCustomer ts=new TestCustomer();
		ts.setUp();
		//System.out.println(new Date());
	}
}
