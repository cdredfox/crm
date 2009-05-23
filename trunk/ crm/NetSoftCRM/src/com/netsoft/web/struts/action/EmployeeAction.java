﻿/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.netsoft.web.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.pojos.Depts;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Roles;
import com.netsoft.services.intf.IDeptsServices;
import com.netsoft.services.intf.IEmployeeServices;
import com.netsoft.services.intf.IRoleServices;
import com.netsoft.util.CheckUser;
import com.netsoft.util.Chinese2Spell;
import com.netsoft.util.ConsoleDate;
import com.netsoft.web.struts.form.EmployeeForm;

/**
 * MyEclipse Struts Creation date: 01-14-2007
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/employee" name="employeeForm" parameter="method"
 *                scope="request" validate="true"
 */
public class EmployeeAction extends DispatchAction {

	private IEmployeeServices ies;

	private Logger log = Logger.getLogger(this.getClass());

	private IDeptsServices ids;

	private IRoleServices irs;

	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			String page = request.getParameter("page");
			if (page == null || page.equals("0")) {
				page = "1";
			}
			int pagecount=(int) Math.ceil(ies.getCount() / 5.0f);
			if(Integer.parseInt(page)>pagecount)
			{
				page=String.valueOf(pagecount);
			}
			List list = ies.CurrentPage(Integer.parseInt(page), 5);
			request.setAttribute("elist", list);
			request.setAttribute("count", pagecount);
			request.setAttribute("page", page);
			log.info("EmployeeAction中list长度为：" + list.size());
		} catch (Exception e) {
			log.error("EmployeeAction中getAll方法出现异常了", e);
		}
		return mapping.findForward("succeed");
	}

	public ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if(!CheckUser.checkSession(request, response))
			{
				return mapping.findForward(CheckUser.JUMP_URL);
			}
			EmployeeForm ef = (EmployeeForm) form;
			EmployeeBean eb = new EmployeeBean();
			eb.setDepts(ef.getDepts());
			eb.setEaccount(ef.getEaccount());
			eb.setEname(ef.getEname());
			eb.setEpwd(ef.getEpwd());
			eb.setRoleid(ef.getEmidrs()[0]); // 增加员工的时候。只能选择一个角色。
			if (ies.addEmployye(eb)) {
				request.setAttribute("msg", "员工已经成功增加，谢谢您的操作");
			} else {
				request.setAttribute("msg", "员工增加失败，请检查您的操作");
			}
		} catch (Exception e) {
			log.error("EmployeeAction中addUser方法出现异常了", e);
		}
		return mapping.findForward("addSucceed");
	}

	public ActionForward modiUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			EmployeeForm ef = (EmployeeForm) form;
			EmployeeBean eb = new EmployeeBean();
			eb.setId(ef.getId());
			eb.setDepts(ef.getDepts());
			eb.setEaccount(ef.getEaccount());
			eb.setEname(ef.getEname());
			eb.setEpwd(ef.getEpwd());
			eb.setRoleid(ef.getEmidrs()[0]);
			if (ies.updateEmployye(eb)) {
				request.setAttribute("msg", "员工成功修改，谢谢您的操作");
			} else {
				request.setAttribute("msg", "员工修改失败，请检查您的操作");
			}
		} catch (Exception e) {
			log.error("EmployeeAction中modiUser方法出现异常了", e);
		}
		return mapping.findForward("addSucceed");
	}

	public ActionForward modiView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeForm ef = (EmployeeForm) form;
			EmployeeBean eb = ies.getEmployyeById(id);
			ef.setDepts(eb.getDepts());
			ef.setEaccount(eb.getEaccount());
			// int roleid = ((Roles) em.getEmidrs().iterator().next()).getId();
			ef.setEmidrs(new Integer[] { eb.getRoleid() });
			ef.setEname(eb.getEname());
			ef.setEpwd(eb.getEpwd());
			ef.setId(eb.getId());
			List<Depts> deptList = ids.getAllDepts();
			List<Roles> roleList = irs.getAllRoles();
			request.setAttribute("deptList", deptList);
			request.setAttribute("roleList", roleList);
			request.setAttribute("em", eb);
			request.setAttribute("repwd",eb.getEpwd());
		} catch (Exception e) {
			log.error("EmployeeAction中modiView方法出现异常了", e);
		}
		return mapping.findForward("modiView");
	}

	public ActionForward roleView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeBean em1 = ies.getEmployyeById(id);
			List rolelist = new ArrayList();
			request.setAttribute("em", em1);
			rolelist.addAll(em1.getEmidrs());
		} catch (Exception e) {
			log.error("EmployeeAction中modiView方法出现异常了", e);
		}
		return mapping.findForward("roleView");
	}

	/**
	 * 根据登
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addUserCheck(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String type = "";
		try {
			type = request.getParameter("type");
			List<Depts> deptList = ids.getAllDepts();
			List<Roles> roleList = irs.getAllRoles();
			request.setAttribute("deptList", deptList);
			request.setAttribute("roleList", roleList);
		} catch (Exception e) {
			log.error("EmployeeAction中addUserCheck方法出现异常了");
		}
		if (type == null || "".equals(type)) {
			return mapping.findForward("addNext"); // 新增用户
		} else if ("transfer".equals(type)) {
			request.setAttribute("type", "transfer");
		}
		return mapping.findForward("modiUserQry"); // 用户维护
	}

	public ActionForward qryUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String type = request.getParameter("transfer");
		try {

			String page = request.getParameter("page");
			String eaccount = request.getParameter("eaccount");
			String ename = request.getParameter("ename");
			String emidrs = request.getParameter("emidrs");
			String depts = request.getParameter("depts");
			EmployeeBean eb = new EmployeeBean();
			HashMap hm = new HashMap();
			if (eaccount != null && !"".equals(eaccount)) {
				hm.put("eaccount", eaccount);
				eb.setEaccount(eaccount);
			}
			if (ename != null && !"".equals(ename)) {
				hm.put("ename", ename);
				eb.setEname(ename);
			}
			if (emidrs != null && !"".equals(emidrs)) {
				hm.put("emidrs", emidrs);
				eb.setRoleid(Integer.parseInt(emidrs));
			}
			if (depts != null && !"".equals(depts)) {
				hm.put("depts", depts);
				eb.setDepts(Integer.parseInt(depts));
			}
			if (page == null || page.equals("0")) {
				page = "1";
			}

			
			int pagecount=(int) Math.ceil(ies.getCountByCurrentPage(hm) / 5.0f);
			if(Integer.parseInt(page)>pagecount)
			{
				page=String.valueOf(pagecount);
			}
			List list = ies.CurrentPageQry(Integer.parseInt(page), 5, hm);
			request.setAttribute("elist", list);
			request.setAttribute("count", pagecount);
			request.setAttribute("page", page);
			request.setAttribute("eb", eb);
			request.setAttribute("flag", "y");
		} catch (Exception e) {
			log.error("EmployeeAction中qryUser方法出现异常了", e);
		}
		if (type != null && !"".equals(type)) {
			request.setAttribute("type", "transfer");
			return mapping.findForward("transferSucceed"); // 用户修改信息查询
		}
		return mapping.findForward("succeed");
	}

	/**
	 * 失效用户信息转移VIEW
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward transferEmployeeView(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String id = request.getParameter("id");
		EmployeeBean em = ies.getEmployyeById(Integer.parseInt(id));
		List<Depts> list = ids.getAllDepts();
		List<EmployeeBean> employee = ies.findEmployeeByAny("depts", "1");
		request.setAttribute("em", em);
		request.setAttribute("dlist", list);
		request.setAttribute("emlist", employee);
		return mapping.findForward("operTransfer");
	}

	/**
	 * 失效用信息转移
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward transferEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		EmployeeForm eb = (EmployeeForm) form;
		if ("0".equals(eb.getOpen())) {
			ies.changCustomerOwener(eb.getId(), eb.getToId());
		} else {
			ies.changCustomerOwener(eb.getId(), 0);
		}
		request.setAttribute("message", "失效用户的客户信息转移成功");
		return mapping.findForward("result");
	}

	public ActionForward changePWD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			String oldpwd = request.getParameter("oldpwd");
			EmployeeBean employee = (EmployeeBean) request.getSession()
					.getAttribute("Employees");
			int id = employee.getId();
			EmployeeBean emp = ies.getEmployyeById(id);
			String pwd = emp.getEpwd();
			if (oldpwd.equals(pwd)) {
				String newpwd = request.getParameter("newpwd");
				Roles role = (Roles) emp.getEmidrs().iterator().next();
				employee.setRoleid(role.getId());
				employee.setEpwd(newpwd);
				ies.updateEmployye(employee);
				request.setAttribute("message", "修改密码成功！");
			} else {
				request.setAttribute("message",
						"<font color='red'>您输入的旧密码不正确，请返回重新操作</font>");
			}
			return mapping.findForward("result");
		} catch (Exception e) {
			log.error("EmployeeAction中changePWD方法出现异常了", e);
			return null;
		}
	}

	public IEmployeeServices getIes() {
		return ies;
	}

	public void setIes(IEmployeeServices ies) {
		this.ies = ies;
	}

	public IDeptsServices getIds() {
		return ids;
	}

	public void setIds(IDeptsServices ids) {
		this.ids = ids;
	}

	public IRoleServices getIrs() {
		return irs;
	}

	public void setIrs(IRoleServices irs) {
		this.irs = irs;
	}

}