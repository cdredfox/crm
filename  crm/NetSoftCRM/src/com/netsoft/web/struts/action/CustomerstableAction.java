package com.netsoft.web.struts.action;

import java.util.ArrayList;
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

import com.netsoft.dao.pojos.Configuretable;
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
		// ��˾����
		List<ConfiguretableBean> customerxz = iconfig.getAllByType("xz", 0);
		// �ͻ���Դ
		List<ConfiguretableBean> customerly = iconfig.getAllByType("ly", 0);
		// �ͻ�����
		List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
		// ��õ���ֵ
		List<ConfiguretableBean> customerdz = iconfig.getAllByType("dz", 0);
		// ȡ���
		List<ConfiguretableBean> customerqh = iconfig.getAllByType("qh", 0);
		// ȡ��˾����������
		List<ConfiguretableBean> customersyzxz = iconfig.getAllByType("syzxz",
				0);
		if ("2".equals(cf.getPhonetype())) {
			// �绰
			request.setAttribute("phone", cf.getPhone());

		} else {
			// �ֻ�
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
		
		Configuretable province=iconfig.qryConfigByValue("dz", String.valueOf(cf.getCustomerprovinceid()));
		Configuretable city=iconfig.qryConfigByValue("dz", String.valueOf(cf.getCustomercityid()));
		// ��ַƴ��
		//String count = request.getParameter("customercounty");
		//String city = request.getParameter("city");
		//String cityinfo = request.getParameter("address");
		//count = iconfig.qryConfigByTypeAndValue("dz", count);
		//city = iconfig.qryConfigByTypeAndValue("dz", city);

//		if (city != null) {
			//20080830 �ͻ�Ҫ��������Ӳ����Զ�����ʡ���ɵ�ַ�ֶ����õ�ʱ��������������
	//		city = count + city + cityinfo;
	//	} else if ("����".equals(city)) {
	//		city = cityinfo;
	//	}
	//	cf.setCustomeraddress(city);
		// �绰���
		String number = request.getParameter("phonenumer");
		// �绰����
		String pnumber = request.getParameter("pnumber");
		// �������
		String fnumber = request.getParameter("fnumber");

		number = iconfig.qryPhoneByTypeAndValue("qh", number);
		cf.setCustomerfax(number + "-" + fnumber);
		cf.setCustomerphone(number + "-" + pnumber);
		CustomerstableBean cb = new CustomerstableBean();
		BeanUtils.copyProperties(cf, cb);
		cb.setCustomeradddate(new Date());
		cb.setCustomerprovince(province);
		cb.setCustomercity(city);
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
				// �ҵĿͻ�
				list = ics.getAllCustomerByEid(employee.getId().intValue(),
						Integer.parseInt(page), psize, company, startdate,
						enddate,cutomergrade);
				request
						.setAttribute("count", (int) Math
								.ceil(ics.getCount(employee.getId(), company,
										startdate, enddate, cutomergrade) / 20.0f));
				cf.setCustomertype("1");
			} else if ("all".equals(type)) {
				// �����ͻ�
				list = ics.getAllOpenCustomer(Integer.parseInt(page), psize,
						company, startdate, enddate, cutomergrade);
				request.setAttribute("count", (int) Math.ceil(ics.getOpenCount(
						company, startdate, enddate, cutomergrade) / 20.0f));
				request.setAttribute("flag", "y");
				cf.setCustomertype("2");
			} else if ("invali".equals(type)) {
				// ����ͻ�
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
			log.info("CustomerstableAction��list����Ϊ��" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("CustomerstableAction��getAll���������쳣��", e);
		}
		return mapping.findForward("customerManager");
	}

	/**
	 * ��ʾ�޸���ͼ
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
		// ��˾����
		List<ConfiguretableBean> customerxz = iconfig.getAllByType("xz", 0);
		// �ͻ���Դ
		List<ConfiguretableBean> customerly = iconfig.getAllByType("ly", 0);
		// �ͻ�����
		List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
		// ȡ��˾����������
		List<ConfiguretableBean> customersyzxz = iconfig.getAllByType("syzxz",
				0);
		// ��õ���ֵ
		List<ConfiguretableBean> customerdz = iconfig.getAllByType("dz", 0);
		// ȡ���
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
		  
		  int provinceid=Integer.parseInt(ctb.getCustomerprovince()==null?"0":ctb.getCustomerprovince().getConfigvalue().trim());
		  
		  List<ConfiguretableBean> customercity=new ArrayList<ConfiguretableBean>();
		  if(provinceid!=0)
		  {
			  customercity=iconfig.getAllByType("dz",provinceid);
		  }
		  ctf.setCustomerprovinceid(provinceid);
		  ctf.setCustomercityid(Integer.parseInt(ctb.getCustomercity()==null?"0":ctb.getCustomercity().getConfigvalue().trim()));
		  request.setAttribute("customercity", customercity);
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
		
	    String number = iconfig.qryPhoneByTypeAndValue("qh", ctf.getCustomerarea());
		ctb.setCustomerphone(number+"-"+ctf.getCustomerphone());
		ctb.setCustomerfax(number+"-"+ctf.getCustomerfax());
		Configuretable province=iconfig.qryConfigByValue("dz", String.valueOf(ctf.getCustomerprovinceid()));
		Configuretable city=iconfig.qryConfigByValue("dz", String.valueOf(ctf.getCustomercityid()));
		ctb.setCustomerprovince(province);
		ctb.setCustomercity(city);
		String message = "";
		if (ics.updateCustomer(ctb)) {
			//message = "���Ѿ��ɹ��ĸ����˿ͻ���Ϣ!";
			//2008/10/02 ӦФ�ɵ�Ҫ��,�ͻ���Ϣ�޸ĳɹ���,��ת���ҵĿͻ���ѯ����
			return new ActionForward("/customer.crm?method=customerManager&customertype=1");
		} else {
			message = "�Բ���!�ͻ���Ϣ����ʧ�ܣ������Ի�����ϵϵͳ����Ա!";
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
			log.info("CustomerstableAction��list����Ϊ��" + list.size());
		} catch (Exception e) {
			log.error("CustomerstableAction��getAll���������쳣��", e);
		}
		return mapping.findForward("customerAll");
	}

	/**
	 * ��ʾ��ϸ���ϵĵ�һ��VIEW��ͼ
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

		// ��˾����
		List<ConfiguretableBean> customerxz = iconfig.getAllByType("xz", 0);
		// �ͻ���Դ
		List<ConfiguretableBean> customerly = iconfig.getAllByType("ly", 0);
		// �ͻ�����
		List<ConfiguretableBean> customerdj = iconfig.getAllByType("dj", 0);
		// ȡ��˾����������
		List<ConfiguretableBean> customersyzxz = iconfig.getAllByType("syzxz",
				0);
		// �ͻ���������
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
	 * ��ʾ������Ϣ��VIEW
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
		// �ͻ���������
		List<ConfiguretableBean> customerfk = iconfig.getAllByType("fk", 0);
		request.setAttribute("result", fbb);
		request.setAttribute("customer", customer);
		request.setAttribute("customerfk", customerfk);
		return mapping.findForward("feedbackView");
	}

	/**
	 * �ͻ����ʱ�����������ͬ��Ĺ����ͻ������action
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
			log.info("CustomerstableAction��list����Ϊ��" + list.size());
		} catch (Exception e) {
			log.error("CustomerstableAction��getAll���������쳣��", e);
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
