package com.netsoft.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.ConfiguretableBean;
import com.netsoft.services.intf.IConfiguretableServices;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.ConfiguretableForm;

public class ConfiguretableAction extends DispatchAction {
	private IConfiguretableServices ics;
	
	

	public ActionForward getType(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		List<ConfiguretableBean> list=ics.getType();
		request.setAttribute("configList",list);
		return mapping.findForward("configView");
	}
	
	public ActionForward configViewMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String type=request.getParameter("type");
		String name=this.getNameByType(type);
		List<ConfiguretableBean> list;
		String maxcount;
		if("dzsubtype".equals(type))
		{
			String id=request.getParameter("id");
			request.setAttribute("id",id);
			list=ics.getAllByType("dz",Integer.parseInt(id));
			maxcount=ics.getMaxNumByType("dz");
		}else
		{
			list=ics.getAllByType(type,0);
			maxcount=ics.getMaxNumByType(type);
		}
		List<ConfiguretableBean> dzlist=ics.getAllByType("dz",0);
		request.setAttribute("configViewList", list);
		request.setAttribute("typeName",name);
		request.setAttribute("type",type);
		request.setAttribute("dzlist",dzlist);
		request.setAttribute("maxcount",maxcount);
		
		return mapping.findForward("configViewMessage");
	}
	
	public ActionForward addConfig(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ConfiguretableForm cf=(ConfiguretableForm) form;
		ConfiguretableBean cb=new ConfiguretableBean();
		BeanUtils.copyProperties(cf,cb);
		if("dzsubtype".equals(cb.getConfigtype()))
		{
			cb.setConfigtype("dz");
			String id=request.getParameter("id");
			cb.setConfigtopid(Integer.parseInt(id));
		}
		ics.addConfig(cb);
		return new ActionForward("/config.crm?method=configViewMessage&type="+cf.getConfigtype());
	}
	
	/**
	 * 修改配置信息显示视图
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modiConfigView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ConfiguretableForm cf=(ConfiguretableForm) form;
		String id=request.getParameter("id");
		ConfiguretableBean ctb=ics.getConfigByid(Integer.parseInt(id));
		BeanUtils.copyProperties(ctb,cf);
		request.setAttribute("ctb",ctb);
		request.setAttribute("maxnum",ctb.getConfigvalue());
		return mapping.findForward("modiconfigview");
	}
	
	/**
	 * 修改配置信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modiConfig(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!CheckUser.checkSession(request, response))
		{
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		ConfiguretableForm  cf=(ConfiguretableForm) form;
		ConfiguretableBean cb=new ConfiguretableBean();
		BeanUtils.copyProperties(cf,cb);
		ics.updateConfig(cb);
		return new ActionForward("/config.crm?method=configViewMessage&type="+cf.getConfigtype());
	}
	public IConfiguretableServices getIcs() {
		return ics;
	}

	public void setIcs(IConfiguretableServices ics) {
		this.ics = ics;
	}
	
	private String getNameByType(String type)
	{
		if ("dj".equals(type)) {
			return "客户等级配置";
		}
		if ("dz".equals(type)) {
			return "客户地址配置";
		}
		if ("fk".equals(type)) {
			return "客户反馈配置";
		}
		if ("ly".equals(type)) {
			return "客户来源配置";
		}
		if ("qh".equals(type)) {
			return "客户电话区号配置";
		}
		if ("xz".equals(type)) {
			return "客户公司性质";
		}
		if ("syzxz".equals(type)) {
			return "客户公司所有制类型";
		}
		return "非法类型";
	}

}
