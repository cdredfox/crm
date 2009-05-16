package com.netsoft.web.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.beans.NoteBookBean;
import com.netsoft.services.intf.INoteBookServices;
import com.netsoft.util.CRM;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.CustomerstableForm;
import com.netsoft.web.struts.form.NoteBookForm;

public class NoteBookAction extends DispatchAction {
	private INoteBookServices inbs;

	public INoteBookServices getInbs() {
		return inbs;
	}

	public void setInbs(INoteBookServices inbs) {
		this.inbs = inbs;
	}

	public ActionForward getAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}

		String page = request.getParameter("page");
		if (page == null || page.equals("0")) {
			page = "1";
		}
		List list = null;

		list = inbs.getAllNoteBook(Integer.parseInt(page), CRM.PAGE_SIZE);
		int allCount=inbs.getAllNoteBookCount();
		double count=Math.ceil((double)allCount/CRM.PAGE_SIZE);
		request.setAttribute("count",(int)count);
		request.setAttribute("elist", list);
		request.setAttribute("page", page);
		return mapping.findForward("note_list");
	}

	public ActionForward showView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		if (type != null && !"".equals(type)) {
			id = String.valueOf(CRM.NOTE_BOOK_ID);
		}

		String page = request.getParameter("page");
		if (page == null || page.equals("0")) {
			page = "1";
		}
		List list = null;
		list = inbs.getNoteBookByTopId(Integer.parseInt(page),
				CRM.BBS_PAGE_SIZE, Integer.parseInt(id));
		request.setAttribute("count", (int) Math.ceil((double)inbs
				.getNoteBookByTopIdCount(Integer.parseInt(id))
				/ CRM.BBS_PAGE_SIZE));
		request.setAttribute("elist", list);
		request.setAttribute("page", page);
		request.setAttribute("title", list.size()>0?((NoteBookBean) list.get(0)).getTitle():"");
		request.setAttribute("topid", id);
		if (type != null && !"".equals(type)) {
			return mapping.findForward("showNoteBook");
		} else {
			return mapping.findForward("showView");
		}
	}

	public ActionForward addNoteBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String type = request.getParameter("type");
		EmployeeBean eb = (EmployeeBean) request.getSession().getAttribute(
				"Employees");
		NoteBookBean nbb = new NoteBookBean();
		NoteBookForm nbf = (NoteBookForm) form;
		nbb.setEmployeeid(eb.getId());
		nbb.setNote(nbf.getNoteBook());
		nbb.setWriteDate(new Date());
		if (type == null) {
			int topid = Integer.parseInt(request.getParameter("topid"));
			// 回复贴子
			nbb.setTop(0);
			nbb.setTopid(topid);
			nbb.setTitle("回贴贴子");
			inbs.addNoteBook(nbb);
			return new ActionForward("/notebook.crm?method=showView&id="
					+ topid);
		} else if ("showNoteBook".equals(type)) {
			// 流言本
			int topid = Integer.parseInt(request.getParameter("topid"));
			// 回复贴子
			nbb.setTop(0);
			nbb.setTopid(topid);
			nbb.setTitle("回复流言");
			if("Y".equals(eb.getBbsFlag()))
			{
				nbb.setNote("<b><font color='red'>"+nbb.getNote()+"</font></b>");
			}
			inbs.addNoteBook(nbb);
			return new ActionForward(
					"/notebook.crm?method=showView&type=notebook&id=" + topid);
		} else {

			nbb.setTop(Integer.parseInt(nbf.noteTop));

			nbb.setTopid(0);// 为主贴设为零
			if("Y".equals(eb.getBbsFlag()))
			{
				nbb.setTitle("<b><font color='red'>"+nbf.getNoteTitle()+"</font></b>");
			}else{
				nbb.setTitle(nbf.getNoteTitle());
			}
			
			inbs.addNoteBook(nbb);
			return new ActionForward("/notebook.crm?method=getAll");

		}

	}
}
