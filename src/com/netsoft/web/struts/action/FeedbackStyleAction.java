package com.netsoft.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.netsoft.dao.beans.FeedbackStyleBean;
import com.netsoft.services.intf.IConfiguretableServices;
import com.netsoft.services.intf.IFeedbackStyleService;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.feedbackstyleForm;

public class FeedbackStyleAction extends DispatchAction {

	public IConfiguretableServices ics;
	public IFeedbackStyleService ifs;

	public ActionForward initView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		List fklist = ics.getAllByType("fk", 0);
		List result = ifs.qryFeedbackStyleService();
		request.setAttribute("fklist", fklist);
		request.setAttribute("result", result);
		return mapping.findForward("feedbackstyleconfig");
	}

	
	public ActionForward saveStyle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		feedbackstyleForm styleform=(feedbackstyleForm) form;
		
		FeedbackStyleBean feedbackstyle=new FeedbackStyleBean();
		feedbackstyle.setId(styleform.getId());
		feedbackstyle.setFid(styleform.getFid());
		feedbackstyle.setStyle(styleform.getStyle());
		ifs.saveFeedbackStyle(feedbackstyle);
		System.out.println(styleform.getId());
		System.out.println(styleform.getFid());
		System.out.println(styleform.getStyle());
		System.out.println("ok...");
		request.setAttribute("message","谢谢您！操作成功，反馈格式内容已成功增加");
		return mapping.findForward("result");
	}
	
	public IConfiguretableServices getIcs() {
		return ics;
	}

	public void setIcs(IConfiguretableServices ics) {
		this.ics = ics;
	}

	public IFeedbackStyleService getIfs() {
		return ifs;
	}

	public void setIfs(IFeedbackStyleService ifs) {
		this.ifs = ifs;
	}
}
