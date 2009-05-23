package com.netsoft.web.struts.action;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.netsoft.dao.beans.CustomerstableBean;
import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacktableBean;
import com.netsoft.services.intf.ICustomerstableServices;
import com.netsoft.services.intf.IFeedbackTypeService;
import com.netsoft.util.CheckUser;
import com.netsoft.util.ConsoleDate;
import com.netsoft.web.struts.form.FeedBackTableForm;

public class FeedBackTableAction extends DispatchAction {

	public ICustomerstableServices ics;
	public IFeedbackTypeService ifts;
	/**
	 * 增加反馈信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addFeedback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		FeedBackTableForm ftf=(FeedBackTableForm) form;
		Date currenDate=new Date();
		FeedbacktableBean ftb=new FeedbacktableBean();
		int customerid=ftf.getFeedbackcustomer();
		//1,填反馈表与更新客户表
		CustomerstableBean ctb=ics.getCustomerById(customerid);
		ftb.setFeedbackcustomerid(customerid);
		ftb.setFeedbackemployye(ftf.getFeedbackeid());
		ftb.setFeedbackmessage(ftf.getFeedbackmessage());
		ftb.setFeedbacktypeid(ftf.getFeedbacktype());
		ftb.setFeedbackdate(currenDate);
		if(!"".equals(ftf.getFeedbackoutdate()))
		{
			Date feedbackoutdate=ConsoleDate.String2Date(ftf.getFeedbackoutdate());
			ctb.setCustomeroutdate(feedbackoutdate);
		}
		if(!"".equals(ftf.getFeedbacknextdate()))
		{
			Date feedbacknextdate=ConsoleDate.String2Date(ftf.getFeedbacknextdate());
			ctb.setCustomernextdate(feedbacknextdate);
		}else
		{
			//默认不填的话。默认为七天后,反馈日期
			Date nextdate=ConsoleDate.dateIncrease(ConsoleDate.Date2String(currenDate),Calendar.DATE,7);
			ctb.setCustomernextdate(nextdate);
		}
		ctb.setEid(ftf.getFeedbackeid());
		ctb.setCustomerfeedbackdate(currenDate);
		//ctb.setCustomerprice(Long.parseLong(String.valueOf(ftf.getFeedbackprice())));
		ctb.setCustomerprice(ftf.getFeedbackprice().doubleValue());
		ctb.setCustomerfeedback(ftf.getFeedbackmessage());
		ctb.setCustomerfeedbacktype(ftf.getFeedbacktype());
		ics.updateCustomer(ctb);
		ifts.addFeedbackType(ftb);
		//request.setAttribute("message","恭喜您！反馈信息增加成功");
		//return mapping.findForward("result");
		//2008/10/02 应肖松的要求,反馈信息增加成功后,跳转到我的客户查询界面
		return new ActionForward("/customer.crm?method=customerManager&customertype=1");
	}
	public ICustomerstableServices getIcs() {
		return ics;
	}
	public void setIcs(ICustomerstableServices ics) {
		this.ics = ics;
	}
	public IFeedbackTypeService getIfts() {
		return ifts;
	}
	public void setIfts(IFeedbackTypeService ifts) {
		this.ifts = ifts;
	}

}
