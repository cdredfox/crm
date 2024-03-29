﻿/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.netsoft.web.struts.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.netsoft.dao.intf.IMenusDao;
import com.netsoft.services.intf.IMenusServices;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.MenusForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-19-2007
 * 
 * XDoclet definition:
 * @struts.action path="/menus" name="menusForm" parameter="method" scope="request" validate="true"
 */
public class MenusAction extends DispatchAction {
	private IMenusServices ims;
	public ActionForward removePower(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		MenusForm menusForm = (MenusForm) form;
		int[] m=menusForm.getId();
		System.out.println(m.length);
		
	    int rid=Integer.parseInt(request.getParameter("pid"));
	   if(ims.delAllByRole(rid,m))
	   {
	   return mapping.findForward("sucess");
	   }else
	   {
		   return null;
	   }
	   }
	
	public ActionForward addPower(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		MenusForm menusForm = (MenusForm) form;
		int[] m=menusForm.getId();
	    int rid=Integer.parseInt(request.getParameter("pid"));
//	   if(ims.addAllByRole(rid,m))
//	   {
//		return mapping.findForward("sucess");
//	   }else
//	   {
//		   return null;
//	   }
	    return null;
	   }
	
	
	public IMenusServices getIms() {
		return ims;
	}
	public void setIms(IMenusServices ims) {
		this.ims = ims;
	}
}