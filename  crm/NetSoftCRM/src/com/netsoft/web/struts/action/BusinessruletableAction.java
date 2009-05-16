package com.netsoft.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.BusinessruletableBean;
import com.netsoft.services.intf.IBusinessruletableServices;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.BusinessruletableForm;

public class BusinessruletableAction extends DispatchAction {

	private IBusinessruletableServices ibs;

	public IBusinessruletableServices getIbs() {
		return ibs;
	}

	public void setIbs(IBusinessruletableServices ibs) {
		this.ibs = ibs;
	}

	public ActionForward ruleView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		List rulelist = ibs.getAllRule();
		request.setAttribute("rulelist",rulelist);
		return mapping.findForward("ruleView");
	}

	public ActionForward updateRuleView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String id=request.getParameter("id");
		BusinessruletableBean bb=ibs.getRuleById(Integer.parseInt(id));
		request.setAttribute("bb",bb);
		return mapping.findForward("updateRuleView");
	}

	public ActionForward updateRule(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		BusinessruletableForm bf=(BusinessruletableForm) form;
		BusinessruletableBean bb=new BusinessruletableBean();
		BeanUtils.copyProperties(bf,bb);
		ibs.updateRule(bb);
		return mapping.findForward("updateRuleResult");
	}
}
