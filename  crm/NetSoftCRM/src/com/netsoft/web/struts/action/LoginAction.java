/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.netsoft.web.struts.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.services.intf.IEmployeeServices;
import com.netsoft.services.intf.IMenusServices;
import com.netsoft.util.CRM;
import com.netsoft.web.struts.form.LoginForm;

/**
 * MyEclipse Struts Creation date: 12-28-2006
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/login" name="loginForm" input="/login.jsp"
 *                scope="request" validate="true"
 */
public class LoginAction extends DispatchAction {

	Logger log = Logger.getLogger(this.getClass());
	public IEmployeeServices es;
	public IMenusServices ms;

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method
												// stub
		log.info("����������������:-----" + loginForm.getUsername());
		EmployeeBean eb = new EmployeeBean();
		eb.setEaccount(loginForm.getUsername());
		eb.setEpwd(loginForm.getUserpwd());
		if ((eb = es.isCheckLogin(eb)) == null) {
			request.setAttribute("message",
					"<font color='red'>��������û����������������������</font>");
			return mapping.getInputForward();
		} else {
			Set<Menus> sm = es.getMenusByEmployee(eb);
			List menulist = ms.getAllMenus();
			List<Menus> list = new ArrayList();
			list.addAll(sm);
			/**
			 * @todo ����ϵͳ��Ҫ���Ƶ�����ؼ�������Ȩ�� Ŀǰ���ü�¼Ȩ�ޱ�ŵķ�ʽ��ʵ�֣��Ժ󽫸Ľ����ķ������ף�
			 */
			for (Menus menus : list) {
				if (menus.getId() == CRM.MODI_CUSTOMER_NAME_ID) {
					eb.setRoleflag("Y");
					// break;
				}
				if (menus.getId() == CRM.DEL_CUSTOMER_TRUE_ID) {
					eb.setDelFlag("Y");
					//break;
				}
				if(menus.getId()==CRM.BBS_MANAGE_ID)
				{
					eb.setBbsFlag("Y");
				}
				if(menus.getId()==CRM.VIEW_FEEDBACK_ID)
				{
					eb.setViewFlag("Y");
				}
				if(menus.getId()==CRM.DEL_FEEDBACK_ID)
				{
					eb.setDelFeedBackFlag("Y");
				}
			}
			request.getSession().setAttribute("menulist", menulist);// ȡ�����в˵�
			request.getSession().setAttribute("list", list); // �˵�ֵȡ��
			request.getSession().setAttribute("Employees", eb);
			return mapping.findForward("main");
		}
	}

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("ִ���˳�����.......");
		request.getSession().invalidate();
		log.info("session�ɹ�����....ִ������ҳ��");
		return mapping.findForward("login");
	}

	public IEmployeeServices getEs() {
		return es;
	}

	public void setEs(IEmployeeServices es) {
		this.es = es;
	}

	public IMenusServices getMs() {
		return ms;
	}

	public void setMs(IMenusServices ms) {
		this.ms = ms;
	}
}