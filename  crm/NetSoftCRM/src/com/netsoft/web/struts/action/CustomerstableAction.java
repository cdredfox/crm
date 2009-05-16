package com.netsoft.web.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.ForwardAction;
import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.ConfiguretableBean;
import com.netsoft.dao.beans.CustomerstableBean;
import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.beans.FeedbacktableBean;
import com.netsoft.services.intf.IConfiguretableServices;
import com.netsoft.services.intf.ICustomerstableServices;
import com.netsoft.services.intf.IEmployeeServices;
import com.netsoft.services.intf.IFeedbackTypeService;
import com.netsoft.util.CheckUser;
import com.netsoft.web.struts.form.CustomerstableForm;

public class CustomerstableAction extends DispatchAction {
	public ICustomerstableServices ics;
	public IConfiguretableServices iconfig;
	public IFeedbackTypeService ifs;
	public IEmployeeServices ies;
	private int psize = 20;

	public ICustomerstableServices getIcs() {
		return ics;
	}

	public void setIcs(ICustomerstableServices ics) {
		this.ics = ics;
	}

	public ActionForward addCustomerView(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		CustomerstableForm cf = (CustomerstableForm) form;
		// 公司性质
		List<ConfiguretableBean> customerxz = iconfig.getAllByType("xz", 0);
		// 客户来源
		List<ConfiguretableBean> customerly = iconfig.getAllByType("ly", 0);
		// 客户级别
		List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
		// 获得地区值
		List<ConfiguretableBean> customerdz = iconfig.getAllByType("dz", 0);
		// 取区号
		List<ConfiguretableBean> customerqh = iconfig.getAllByType("qh", 0);
		// 取公司所有制性质
		List<ConfiguretableBean> customersyzxz = iconfig.getAllByType("syzxz",
				0);
		if ("2".equals(cf.getPhonetype())) {
			// 电话
			request.setAttribute("phone", cf.getPhone());

		} else {
			// 手机
			cf.setCustomerhandset(cf.getPhone());
		}
		request.setAttribute("customerxz", customerxz);
		request.setAttribute("customerly", customerly);
		request.setAttribute("customerdj", customerdj);
		request.setAttribute("customerdz", customerdz);
		request.setAttribute("customerqh", customerqh);
		request.setAttribute("customersyzxz", customersyzxz);
		return mapping.findForward("addCustomerView");
	}

	public ActionForward addCustomer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		CustomerstableForm cf = (CustomerstableForm) form;

		// 地址拼接
		String count = request.getParameter("customercounty");
		String city = request.getParameter("city");
		String cityinfo = request.getParameter("address");
		count = iconfig.qryConfigByTypeAndValue("dz", count);
		city = iconfig.qryConfigByTypeAndValue("dz", city);

		if (city != null) {
			//20080830 客户要求城市增加不用自动增加省，由地址字段设置的时候，设置完整的名称
			city = count + city + cityinfo;
		} else if ("其他".equals(city)) {
			city = cityinfo;
		}
		cf.setCustomeraddress(city);
		// 电话区号
		String number = request.getParameter("phonenumer");
		// 电话号码
		String pnumber = request.getParameter("pnumber");
		// 传真号码
		String fnumber = request.getParameter("fnumber");

		number = iconfig.qryPhoneByTypeAndValue("qh", number);
		cf.setCustomerfax(number + "-" + fnumber);
		cf.setCustomerphone(number + "-" + pnumber);
		CustomerstableBean cb = new CustomerstableBean();
		BeanUtils.copyProperties(cf, cb);
		cb.setCustomeradddate(new Date());
		String message = ics.addCustomer(cb);
		if(message.startsWith("return"))
		{
			String cid[]=message.split(":");
			String result="/customer.crm?method=feedbackView&id="+cid[1];
			return new ActionForward(result);
		}
		request.setAttribute("message", message);
		return mapping.findForward("resultView");
	}

	public ActionForward customerManager(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			if (!CheckUser.checkSession(request, response)) {
				return mapping.findForward(CheckUser.JUMP_URL);
			}
			CustomerstableForm cf = (CustomerstableForm) form;
			String company = cf.getCustomercompany();
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
			request.setAttribute("customerdj", customerdj);
			int cutomergrade = cf.getCutomergrade()==null?0:cf.getCutomergrade();

			String page = request.getParameter("page");
			String type = request.getParameter("type");
			String customertype = request.getParameter("customertype");
			cf.setCustomertype(customertype);
			if (page == null || page.equals("0")) {
				page = "1";
			}
			EmployeeBean employee = (EmployeeBean) request.getSession()
					.getAttribute("Employees");
			List list = null;
			;
			if (type == null || "".equals(type)) {
				// 我的客户
				list = ics.getAllCustomerByEid(employee.getId().intValue(),
						Integer.parseInt(page), psize, company, startdate,
						enddate,cutomergrade);
				request
						.setAttribute("count", (int) Math
								.ceil(ics.getCount(employee.getId(), company,
										startdate, enddate, cutomergrade) / 20.0f));
				cf.setCustomertype("1");
			} else if ("all".equals(type)) {
				// 公开客户
				list = ics.getAllOpenCustomer(Integer.parseInt(page), psize,
						company, startdate, enddate, cutomergrade);
				request.setAttribute("count", (int) Math.ceil(ics.getOpenCount(
						company, startdate, enddate, cutomergrade) / 20.0f));
				request.setAttribute("flag", "y");
				cf.setCustomertype("2");
			} else if ("invali".equals(type)) {
				// 撤销客户
				list = ics.getAllInvaliCustomer(Integer.parseInt(page), psize,
						company, startdate, enddate, cutomergrade);
				request.setAttribute("count", (int) Math.ceil(ics
						.getInvaliCount(company, startdate, enddate, cutomergrade) / 20.0f));
				request.setAttribute("flag", "n");
				cf.setCustomertype("3");
			}

			if (startdate != null && !"".equals(startdate.trim())) {
				request.setAttribute("startdate", startdate);
			}
			if (enddate != null && !"".equals(enddate.trim())) {
				request.setAttribute("enddate", enddate);
			}
			request.setAttribute("elist", list);
			request.setAttribute("page", page);
			log.info("CustomerstableAction中list长度为：" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("CustomerstableAction中getAll方法出现异常了", e);
		}
		return mapping.findForward("customerManager");
	}

	/**
	 * 显示修改视图
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward customerModiView(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		CustomerstableForm ctf = (CustomerstableForm) form;
		String id = request.getParameter("id");
		CustomerstableBean ctb = ics.getCustomerById(Integer.parseInt(id));
		// 公司性质
		List<ConfiguretableBean> customerxz = iconfig.getAllByType("xz", 0);
		// 客户来源
		List<ConfiguretableBean> customerly = iconfig.getAllByType("ly", 0);
		// 客户级别
		List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
		// 取公司所有制性质
		List<ConfiguretableBean> customersyzxz = iconfig.getAllByType("syzxz",
				0);
		// 获得地区值
		List<ConfiguretableBean> customerdz = iconfig.getAllByType("dz", 0);
		// 取区号
		List<ConfiguretableBean> customerqh = iconfig.getAllByType("qh", 0);
		
		request.setAttribute("customerxz", customerxz);
		request.setAttribute("customerly", customerly);
		request.setAttribute("customerdj", customerdj);
		request.setAttribute("customerdz", customerdz);
		request.setAttribute("customerqh", customerqh);
		request.setAttribute("customersyzxz", customersyzxz);
		request.setAttribute("ename", ctb.getEmployye() == null ? "" : ctb
				.getEmployye().getEname());
		request.setAttribute("eid", ctb.getEmployye() == null ? "" : ctb
				.getEmployye().getId());
		  BeanUtils.copyProperties(ctb, form);
		  if(ctb.getCustomerphone()!=null && !"".equals(ctb.getCustomerphone().trim()))
		  {
			 ctf.setCustomerarea(ctb.getCustomerphone().split("-")[0]);
			 if(ctb.getCustomerphone().split("-").length>1)
			 {
				 ctf.setCustomerphone(ctb.getCustomerphone().split("-")[1]);
			 }
		  }
		  if(ctb.getCustomerfax()!=null && !"".equals(ctb.getCustomerfax().trim()))
		  {
			 ctf.setCustomerfaxarea(ctb.getCustomerfax().split("-")[0]);
			 if(ctb.getCustomerfax().split("-").length>1)
			 {
				 ctf.setCustomerfax(ctb.getCustomerfax().split("-")[1]);
			 }
			 
		  }
		return mapping.findForward("customerModiView");
	}

	public ActionForward modiCustomer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		CustomerstableForm ctf = (CustomerstableForm) form;
		CustomerstableBean ctb = new CustomerstableBean();
		BeanUtils.copyProperties(ctf, ctb);
		ctb.setCustomerphone(ctf.getCustomerarea()+"-"+ctf.getCustomerphone());
		ctb.setCustomerfax(ctf.getCustomerfaxarea()+"-"+ctf.getCustomerfax());
		String message = "";
		if (ics.updateCustomer(ctb)) {
			//message = "您已经成功的更新了客户信息!";
			//2008/10/02 应肖松的要求,客户信息修改成功后,跳转到我的客户查询界面
			return new ActionForward("/customer.crm?method=customerManager&customertype=1");
		} else {
			message = "对不起!客户信息更新失败，请重试或者联系系统管理员!";
		}
		request.setAttribute("message", message);
		return mapping.findForward("resultView");

	}

	public ActionForward customerAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			CustomerstableForm cf = (CustomerstableForm) form;
			List elist = ies.getAllEmployee();
			String company = cf.getCustomercompany();
			int name = cf.getEid();
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String page = request.getParameter("page");
			if (page == null || page.equals("0")) {
				page = "1";
			}
			List list;
			list = ics.getAllCustomer(Integer.parseInt(page), psize, company,
					name, startdate, enddate);
			request.setAttribute("count", (int) Math.ceil(ics.getAllCount(
					company, name, startdate, enddate) / 20.0f));

			request.setAttribute("elist", list);
			request.setAttribute("el", elist);
			request.setAttribute("page", page);
			if (startdate != null && !"".equals(startdate.trim())) {
				request.setAttribute("startdate", startdate);
			}
			if (enddate != null && !"".equals(enddate.trim())) {
				request.setAttribute("enddate", enddate);
			}
			log.info("CustomerstableAction中list长度为：" + list.size());
		} catch (Exception e) {
			log.error("CustomerstableAction中getAll方法出现异常了", e);
		}
		return mapping.findForward("customerAll");
	}

	/**
	 * 显示详细资料的第一个VIEW视图
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward detailInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String id = request.getParameter("id");
		CustomerstableBean ctb = ics.getCustomerById(Integer.parseInt(id));

		// 公司性质
		List<ConfiguretableBean> customerxz = iconfig.getAllByType("xz", 0);
		// 客户来源
		List<ConfiguretableBean> customerly = iconfig.getAllByType("ly", 0);
		// 客户级别
		List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
		// 取公司所有制性质
		List<ConfiguretableBean> customersyzxz = iconfig.getAllByType("syzxz",
				0);
		// 客户反馈类型
		List<ConfiguretableBean> customerfk = iconfig.getAllByType("fk", 0);
		request.setAttribute("customerfk", customerfk);
		request.setAttribute("customerxz", customerxz);
		request.setAttribute("customerly", customerly);
		request.setAttribute("customerdj", customerdj);
		request.setAttribute("customersyzxz", customersyzxz);
		request.setAttribute("id", id);
		request.setAttribute("ctb", ctb);
		return mapping.findForward("detailInfoView");
	}

	/**
	 * 显示反馈信息的VIEW
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward feedbackView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		String id = request.getParameter("id");

		String page = request.getParameter("page");
		if (page == null || page.equals("0")) {
			page = "1";
		}
		int pagecount = (int) Math
				.ceil(ifs.getCount(Integer.parseInt(id)) / 20.0f);
		if (Integer.parseInt(page) > pagecount) {
			page = String.valueOf(pagecount);
		}

		List fbb;
		fbb = ifs.getFeedbackTypeByCustomerid(Integer.parseInt(id), Integer
				.parseInt(page), psize);
		// list = ics.getAllCustomer(Integer.parseInt(page), 5);
		request.setAttribute("count", pagecount);
		// request.setAttribute("elist", list);
		request.setAttribute("page", page);
		CustomerstableBean customer = ics.getCustomerById(Integer.parseInt(id));
		// 客户反馈类型
		List<ConfiguretableBean> customerfk = iconfig.getAllByType("fk", 0);
		request.setAttribute("result", fbb);
		request.setAttribute("customer", customer);
		request.setAttribute("customerfk", customerfk);
		return mapping.findForward("feedbackView");
	}

	/**
	 * 客户检查时，如果碰到有同名的公开客户请求此action
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward customerList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!CheckUser.checkSession(request, response)) {
			return mapping.findForward(CheckUser.JUMP_URL);
		}
		try {
			CustomerstableForm cf=(CustomerstableForm) form;
			String companyname = cf.getCustomercompany();
			

			List list = ics.getAllCustomer(0, 0, companyname, -1, null, null);
			request.setAttribute("elist", list);
			log.info("CustomerstableAction中list长度为：" + list.size());
		} catch (Exception e) {
			log.error("CustomerstableAction中getAll方法出现异常了", e);
		}
		return mapping.findForward("customerList");
	}

	public IConfiguretableServices getIconfig() {
		return iconfig;
	}

	public void setIconfig(IConfiguretableServices iconfig) {
		this.iconfig = iconfig;
	}

	public IFeedbackTypeService getIfs() {
		return ifs;
	}

	public void setIfs(IFeedbackTypeService ifs) {
		this.ifs = ifs;
	}

	public IEmployeeServices getIes() {
		return ies;
	}

	public void setIes(IEmployeeServices ies) {
		this.ies = ies;
	}

}
