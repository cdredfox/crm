package com.netsoft.services.test.com.netsoft.services.test;

import java.util.List;

import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.services.intf.IReportServices;
import com.netsoft.test.framework.SuperTestCase;

public class ReportServiceTest extends SuperTestCase {

	@Override
	public void testMethod() throws Exception {
		assertEquals(0, 0);

	}
	
	public void testGetFeedbackDaliyReportData(){
		IReportServices reportService=(IReportServices) context.getBean("IReportServices");
		List<FeedbackReportBean> list=reportService.getFeedbackDaliyReportData("53", "2008-04-28");
		assertEquals(3, list.size());
	}

}
