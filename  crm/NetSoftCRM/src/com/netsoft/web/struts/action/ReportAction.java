package com.netsoft.web.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.netsoft.dao.beans.ConfiguretableBean;
import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacksubBean;
import com.netsoft.services.intf.IConfiguretableServices;
import com.netsoft.services.intf.ICustomerstableServices;
import com.netsoft.services.intf.IEmployeeServices;
import com.netsoft.services.intf.IFeedbackTypeService;
import com.netsoft.services.intf.IReportServices;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.ReportForm;

public class ReportAction extends DispatchAction {

	public IConfiguretableServices iconfigs;
	public IFeedbackTypeService ifs;
	public IReportServices irs;
	public IEmployeeServices ies;
	public ICustomerstableServices ics;

	public ICustomerstableServices getIcs() {
		return ics;
	}

	public void setIcs(ICustomerstableServices ics) {
		this.ics = ics;
	}

	/**
	 * 反馈报表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward feedbackReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ReportForm rf = (ReportForm) form;
		List result = null;// 详细内容
		FeedbackReportBean countfrb = null;// 统计行
		List fklist = null;// 标题栏
		if ("".equals(request.getParameter("flag"))) {
			// 反馈统计报表
			result = ifs.getFeedbackTypeReportByDate(rf.getStartdate(), rf
					.getEnddate());
			fklist = iconfigs.getAllByType("fk", 0);
			countfrb = ifs.getFeedbackTypeReportCountDataByList(ifs
					.getFeedbackTypeReportByDate(rf.getStartdate(), rf
							.getEnddate()));
			countfrb.setEname("合  计");

		} else if ("colligate".equals(request.getParameter("flag"))) {
			// 综合统计报表
			fklist = iconfigs.getAllByType(rf.getType(), 0);
			List qrylist = iconfigs.getAllByType("dj", 0);
			result = irs.getAddCoustomerReportData(rf.getStartdate(), rf
					.getEnddate(), rf.getType(), rf.getQrydz());
			countfrb = irs.getFeedbackTypeReportCountDataByList(irs
					.getAddCoustomerReportData(rf.getStartdate(), rf
							.getEnddate(), rf.getType(), rf.getQrydz()), rf
					.getType());
			request.setAttribute("flag", "colligate");
			countfrb.setEname("合  计");
			request.setAttribute("qrylist", qrylist);
		} else if ("inback".equals(request.getParameter("flag"))) {
			// 内网客户反馈统计报表
			String address=processAdress(request, iconfigs);
			result = ifs.getIntFeedBackReportData(rf.getCompanyName(), rf.eid,
					rf.getQrydz(), rf.getQryxz(), rf.getStartdate(), rf
							.getEnddate(),address);
			countfrb = ifs.getFeedbackTypeReportCountDataByList(ifs
					.getIntFeedBackReportData(rf.getCompanyName(), rf.eid, rf
							.getQrydz(), rf.getQryxz(), rf.getStartdate(), rf
							.getEnddate(),address));
			countfrb.setEname("合  计");
			countfrb.setOpenDate("无  效");
			List qrylist = iconfigs.getAllByType("dj", 0);
			fklist = iconfigs.getAllByType("fk", 0);
			List xzlist = iconfigs.getAllByType("xz", 0);
			List el = ies.getAllEmployee();
			// 获得地区值
			List<ConfiguretableBean> customerdz = iconfigs.getAllByType("dz", 0);
			request.setAttribute("flag", "inback");
			request.setAttribute("qrylist", qrylist);
			request.setAttribute("xzlist", xzlist);
			request.setAttribute("customerdz", customerdz);
			request.setAttribute("el", el);

		} else if("busiowen".equals(request.getParameter("flag")))
		{
			//各业务人员当前客户统计数据报表
			fklist = iconfigs.getAllByType("dj", 0);
			result=irs.getBusiOwenCustomer();
			countfrb=irs.getFeedbackTypeReportCountDataByList(irs.getBusiOwenCustomer(),"dj");
			request.setAttribute("flag", "busiowen");
			countfrb.setEname("合 计");
			
		}
		else {
			// 新增业务统计报表
			fklist = iconfigs.getAllByType("dj", 0);
			result = irs.getBusiCountReportData(rf.getStartdate(), rf
					.getEnddate());
			countfrb = irs.getFeedbackTypeReportCountDataByList(
					irs.getBusiCountReportData(rf.getStartdate(), rf
							.getEnddate()), "dj");
			request.setAttribute("flag", "flag");
			countfrb.setEname("合  计");

		}
		request.setAttribute("frb", result);
		request.setAttribute("fklist", fklist);
		request.setAttribute("countfrb", countfrb);
		return mapping.findForward("feedbackView");
	}

	/**
	 * 反馈报表统计初始化
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward feedbackReportInit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		List fklist = iconfigs.getAllByType("fk", 0);
		request.setAttribute("fklist", fklist);
		return mapping.findForward("feedbackView");
	}

	/**
	 * 业务统计报表初始化
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward busiCountReportInit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		List fklist = iconfigs.getAllByType("dj", 0);
		request.setAttribute("fklist", fklist);
		request.setAttribute("flag", "flag");
		return mapping.findForward("feedbackView");
	}

	/**
	 * 业务统计报表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward busiCountReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		List fklist = iconfigs.getAllByType("dj", 0);
		request.setAttribute("fklist", fklist);
		request.setAttribute("flag", "flag");
		return mapping.findForward("feedbackView");
	}

	/**
	 * 综合业务报表初始化
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward colligatetReportInit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ReportForm rf = (ReportForm) form;
		rf.setType("xz");
		List qrylist = iconfigs.getAllByType("dj", 0);
		List fklist = iconfigs.getAllByType("xz", 0);
		request.setAttribute("flag", "colligate");
		request.setAttribute("qrylist", qrylist);
		request.setAttribute("fklist", fklist);
		return mapping.findForward("feedbackView");
	}

	public IConfiguretableServices getIconfigs() {
		return iconfigs;
	}

	public void setIconfigs(IConfiguretableServices iconfigs) {
		this.iconfigs = iconfigs;
	}

	public IFeedbackTypeService getIfs() {
		return ifs;
	}

	public void setIfs(IFeedbackTypeService ifs) {
		this.ifs = ifs;
	}

	public IReportServices getIrs() {
		return irs;
	}

	public void setIrs(IReportServices irs) {
		this.irs = irs;
	}

	/**
	 * 内网客户反馈报表初始化
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward inFeedbackReportInit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ReportForm rf = (ReportForm) form;
		// rf.setType("xz");
		List qrylist = iconfigs.getAllByType("dj", 0);
		List fklist = iconfigs.getAllByType("fk", 0);
		List xzlist = iconfigs.getAllByType("xz", 0);
		// 获得地区值
		List<ConfiguretableBean> customerdz = iconfigs.getAllByType("dz", 0);
		request.setAttribute("customerdz", customerdz);
		List el = ies.getAllEmployee();
		EmployeeBean employee = (EmployeeBean) request.getSession()
		.getAttribute("Employees");
			int id = employee.getId();
		List subordinate=ies.getEmployeesByTopId(id);
		request.setAttribute("subordinate",subordinate);
		request.setAttribute("flag", "inback");
		request.setAttribute("qrylist", qrylist);
		request.setAttribute("fklist", fklist);
		request.setAttribute("xzlist", xzlist);
		request.setAttribute("el", el);
		return mapping.findForward("feedbackView");
	}

	public IEmployeeServices getIes() {
		return ies;
	}

	public void setIes(IEmployeeServices ies) {
		this.ies = ies;
	}
	
	/**
	 * 内网客户反馈报表查询地址处理
	 * @param request
	 * @param iconfig
	 * @return
	 */
	private String processAdress(HttpServletRequest request,IConfiguretableServices iconfig)
	{
		// 地址拼接
		String count = request.getParameter("customercounty");
		String city = request.getParameter("city");
		if("0".equals(count))
		{
			return null;
		}
		count = iconfig.qryConfigByTypeAndValue("dz", count);
		if("0".equals(city))
		{
			return count;
		}
		
		city = iconfig.qryConfigByTypeAndValue("dz", city);
		//20080830 客户要求城市增加不用自动增加省，由地址字段设置的时候，设置完整的名称
		if (city != null) {
			city = count + city;
		} else if ("其他".equals(city)) {
			return null;
		}
		return city;
	}
	
	public ActionForward batchControl(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ReportForm rf = (ReportForm) form;
		String[] custId=request.getParameterValues("custId");
		String control=request.getParameter("control");
		if("changeGrade".equals(control))
		{
			int grade=Integer.parseInt(request.getParameter("changeGrade"));
			ics.batchChangGrade(custId, grade);
		}else if("batchDel".equals(control))
		{
			ics.batchDel(custId);
		}else if("changeOwener".equals(control))
		{
			int eid=Integer.parseInt(request.getParameter("changeOwener"));
			ics.changOwener(custId, eid);
		}else if("batchOpen".equals(control))
		{
			ics.batchDel(custId);
		}
		String message="批量操作客户成功!";
		request.setAttribute("message", message);
		return mapping.findForward("result");
	}
	

}
