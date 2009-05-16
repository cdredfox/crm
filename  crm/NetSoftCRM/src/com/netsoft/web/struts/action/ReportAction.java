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
import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacksubBean;
import com.netsoft.services.intf.IConfiguretableServices;
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

	/**
	 * ��������
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
		List result = null;// ��ϸ����
		FeedbackReportBean countfrb = null;// ͳ����
		List fklist = null;// ������
		if ("".equals(request.getParameter("flag"))) {
			// ����ͳ�Ʊ���
			result = ifs.getFeedbackTypeReportByDate(rf.getStartdate(), rf
					.getEnddate());
			fklist = iconfigs.getAllByType("fk", 0);
			countfrb = ifs.getFeedbackTypeReportCountDataByList(ifs
					.getFeedbackTypeReportByDate(rf.getStartdate(), rf
							.getEnddate()));
			countfrb.setEname("��  ��");

		} else if ("colligate".equals(request.getParameter("flag"))) {
			// �ۺ�ͳ�Ʊ���
			fklist = iconfigs.getAllByType(rf.getType(), 0);
			List qrylist = iconfigs.getAllByType("dj", 0);
			result = irs.getAddCoustomerReportData(rf.getStartdate(), rf
					.getEnddate(), rf.getType(), rf.getQrydz());
			countfrb = irs.getFeedbackTypeReportCountDataByList(irs
					.getAddCoustomerReportData(rf.getStartdate(), rf
							.getEnddate(), rf.getType(), rf.getQrydz()), rf
					.getType());
			request.setAttribute("flag", "colligate");
			countfrb.setEname("��  ��");
			request.setAttribute("qrylist", qrylist);
		} else if ("inback".equals(request.getParameter("flag"))) {
			// �����ͻ�����ͳ�Ʊ���
			String address=processAdress(request, iconfigs);
			result = ifs.getIntFeedBackReportData(rf.getCompanyName(), rf.eid,
					rf.getQrydz(), rf.getQryxz(), rf.getStartdate(), rf
							.getEnddate(),address);
			countfrb = ifs.getFeedbackTypeReportCountDataByList(ifs
					.getIntFeedBackReportData(rf.getCompanyName(), rf.eid, rf
							.getQrydz(), rf.getQryxz(), rf.getStartdate(), rf
							.getEnddate(),address));
			countfrb.setEname("��  ��");
			countfrb.setOpenDate("��  Ч");
			List qrylist = iconfigs.getAllByType("dj", 0);
			fklist = iconfigs.getAllByType("fk", 0);
			List xzlist = iconfigs.getAllByType("xz", 0);
			List el = ies.getAllEmployee();
			// ��õ���ֵ
			List<ConfiguretableBean> customerdz = iconfigs.getAllByType("dz", 0);
			request.setAttribute("flag", "inback");
			request.setAttribute("qrylist", qrylist);
			request.setAttribute("xzlist", xzlist);
			request.setAttribute("customerdz", customerdz);
			request.setAttribute("el", el);

		} else if("busiowen".equals(request.getParameter("flag")))
		{
			//��ҵ����Ա��ǰ�ͻ�ͳ�����ݱ���
			fklist = iconfigs.getAllByType("dj", 0);
			result=irs.getBusiOwenCustomer();
			countfrb=irs.getFeedbackTypeReportCountDataByList(irs.getBusiOwenCustomer(),"dj");
			request.setAttribute("flag", "busiowen");
			countfrb.setEname("�� ��");
			
		}
		else {
			// ����ҵ��ͳ�Ʊ���
			fklist = iconfigs.getAllByType("dj", 0);
			result = irs.getBusiCountReportData(rf.getStartdate(), rf
					.getEnddate());
			countfrb = irs.getFeedbackTypeReportCountDataByList(
					irs.getBusiCountReportData(rf.getStartdate(), rf
							.getEnddate()), "dj");
			request.setAttribute("flag", "flag");
			countfrb.setEname("��  ��");

		}
		request.setAttribute("frb", result);
		request.setAttribute("fklist", fklist);
		request.setAttribute("countfrb", countfrb);
		return mapping.findForward("feedbackView");
	}

	/**
	 * ��������ͳ�Ƴ�ʼ��
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
	 * ҵ��ͳ�Ʊ����ʼ��
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
	 * ҵ��ͳ�Ʊ���
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
	 * �ۺ�ҵ�񱨱��ʼ��
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
	 * �����ͻ����������ʼ��
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
		// ��õ���ֵ
		List<ConfiguretableBean> customerdz = iconfigs.getAllByType("dz", 0);
		request.setAttribute("customerdz", customerdz);
		List el = ies.getAllEmployee();
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
	 * �����ͻ����������ѯ��ַ����
	 * @param request
	 * @param iconfig
	 * @return
	 */
	private String processAdress(HttpServletRequest request,IConfiguretableServices iconfig)
	{
		// ��ַƴ��
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
		//20080830 �ͻ�Ҫ��������Ӳ����Զ�����ʡ���ɵ�ַ�ֶ����õ�ʱ����������������
		if (city != null) {
			city = count + city;
		} else if ("����".equals(city)) {
			return null;
		}
		return city;
	}

}
