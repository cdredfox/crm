package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacksubBean;
import com.netsoft.dao.beans.FeedbacktableBean;
import com.netsoft.dao.intf.IBusinessruletableDao;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.intf.IFeedbacktypeDao;
import com.netsoft.dao.pojos.Businessruletable;
import com.netsoft.dao.pojos.Configuretable;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Feedbacktable;
import com.netsoft.services.intf.IConfiguretableServices;
import com.netsoft.services.intf.IFeedbackTypeService;
import com.netsoft.util.ConsoleDate;

public class FeedbackTypeService implements IFeedbackTypeService {

	public IFeedbacktypeDao ifd;
	public IConfiguretableDao icd;
	public ICustomerstableDao icustomerstabledao;
	public IEmployeeDao ied;
	public IBusinessruletableDao ibd;
	
	/**
	 * 要进行公开日期判断的客户等级
	 */
	public static HashSet OPEN_CUSTOMER_GRADE_ID=new HashSet();
	/**
	 * 存放客户等级对应的业务规则编号
	 */
	public static HashMap CUSTOMER_GRADE_RULE_ID=new HashMap();
	static
	{
		OPEN_CUSTOMER_GRADE_ID.add(18);
		OPEN_CUSTOMER_GRADE_ID.add(19);
		OPEN_CUSTOMER_GRADE_ID.add(20);
		OPEN_CUSTOMER_GRADE_ID.add(21);
		
		CUSTOMER_GRADE_RULE_ID.put(18, 1);
		CUSTOMER_GRADE_RULE_ID.put(19, 2);
		CUSTOMER_GRADE_RULE_ID.put(20, 3);
		CUSTOMER_GRADE_RULE_ID.put(21, 4);
	}
	
	/**
	 * 反馈报表数据
	 */
	public List getFeedbackTypeReportByDate(String start, String end) {
		String hql = "from Feedbacktable where feedbackdate>=:startdate and feedbackdate<=:enddate order by feedbackeid,feedbacktype";
		HashMap hm = new HashMap();
		hm.put("startdate", start);
		hm.put("enddate", end);
		List result=new ArrayList();
		List<Feedbacktable> list = ifd.getFeedbackByWhere(hql, hm,0,0);
		FeedbackReportBean frb;
		FeedbacksubBean fsb=new FeedbacksubBean();
		int i=0;
		int eid=0;
		List relist=new ArrayList();
		for (Feedbacktable feedbacktable : list) {
			if(i==0)
			{
				//第一次
				//relist=new ArrayList();
				eid=feedbacktable.getFeedbackeid().getId();
				relist.add(feedbacktable);
			}
			if(eid==feedbacktable.getFeedbackeid().getId()&& i>0)
			{
				relist.add(feedbacktable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,null));
					result.add(frb);
				}
			}else if(eid!=feedbacktable.getFeedbackeid().getId() && i>0)
			{ //不是第一次，但业务员不同
				eid=feedbacktable.getFeedbackeid().getId();
				frb=this.fromatReportData(this.genReportDate(relist,null));
				result.add(frb);
				relist=new ArrayList();
				eid=feedbacktable.getFeedbackeid().getId();
				relist.add(feedbacktable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,null));
					result.add(frb);
				}
			}
			i++;
		}

		if(i==1)
		{
			//只有一个
			frb=this.fromatReportData(this.genReportDate(relist,null));
			result.add(frb);
		}
		return result;
	}

	
	/**
	 * 内网客户反馈统计报表数据
	 */
	public List getIntFeedBackReportData(String companyName,String emid,String dz,String xz,String startdate,String enddate,String address){
		StringBuffer hql = new StringBuffer("select feed from Feedbacktable as feed,Customerstable customer where 1=1 and feed.feedbackcustomer=customer.customerid");
		StringBuffer hql1=new StringBuffer("from Customerstable where 1=1 ");
		//StringBuffer hql=new StringBuffer("select feed from Feedbacktable as feed RIGHT join Customerstable customer on  customer.customerid=feed.feedbackcustomer where 1=1 ");
		HashMap hm = new HashMap();
		HashMap hm1=new HashMap();
		if(companyName!=null && !"".equals(companyName.trim()))
		{
			hql.append(" and customer.customercompany like :companyName");
			hm.put("companyName", "%"+companyName+"%");
			hql1.append(" and customercompany like :companyName");
			hm1.put("companyName", "%"+companyName+"%");
		}
		
		if(emid!=null && !"".equals(emid.trim()))
		{
			
			if("open".equals(emid.trim()))
			{
				hql.append(" and customer.employye is null");
				hql1.append(" and employye is null");
			}else
			{
				hql.append(" and customer.employye = :emid");
				hql1.append(" and employye = :emid");
				hm.put("emid", emid);
				hm1.put("emid", emid);
			}
			
		}
		
		if(dz!=null && !"".equals(dz.trim()))
		{
			hql.append(" and customer.cutomergrade = :dz");
			hm.put("dz", dz);
			hql1.append(" and cutomergrade = :dz");
			hm1.put("dz", dz);
		}
		
		if(address!=null && !"".equals(address.trim()))
		{
			hql.append(" and customer.customeraddress like :address");
			hm.put("address",address+"%");
			hql1.append(" and customeraddress like :address");
			hm1.put("address",address+"%");
		}
		
		if(xz!=null && !"".equals(xz))
		{
			hql.append(" and customer.customerproperty = :xz");
			hm.put("xz", xz);
			hql1.append(" and customerproperty = :xz");
			hm1.put("xz", xz);
		}
		
		if(startdate!=null && !"".equals(startdate))
		{
			hql.append(" and feed.feedbackdate>=:startdate");
			hm.put("startdate", startdate);
			
		}
		
		if(enddate!=null && !"".equals(enddate))
		{
			hql.append(" and feed.feedbackdate<=:enddate");
			hm.put("enddate", enddate);
		}
		hql.append(" order by feed.feedbackcustomer,feed.feedbacktype ");
		List result=new ArrayList();
		List cidList=new ArrayList();
		List<Feedbacktable> list = ifd.getFeedbackByWhere(hql.toString(), hm,0,0);
		FeedbackReportBean frb;
		FeedbacksubBean fsb=new FeedbacksubBean();
		int i=0;
		int cid=0;
		List relist=new ArrayList();
		for (Feedbacktable feedbacktable : list) {
			if(i==0)
			{
				//第一次
				//relist=new ArrayList();
				cid=feedbacktable.getFeedbackcustomer().getCustomerid();
				relist.add(feedbacktable);
			}
			if(cid==feedbacktable.getFeedbackcustomer().getCustomerid()&& i>0)
			{
				relist.add(feedbacktable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,"inback"));
					//result.add(frb);
					result.add(this.addOpenDate(frb));
					cidList.add(frb.getCustomerid());
				}
			}else if(cid!=feedbacktable.getFeedbackcustomer().getCustomerid() && i>0)
			{ //不是第一次，但业务员不同
				cid=feedbacktable.getFeedbackcustomer().getCustomerid();
				frb=this.fromatReportData(this.genReportDate(relist,"inback"));
				//result.add(frb);
				result.add(this.addOpenDate(frb));
				cidList.add(frb.getCustomerid());
				relist=new ArrayList();
				cid=feedbacktable.getFeedbackcustomer().getCustomerid();
				relist.add(feedbacktable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,"inback"));
					result.add(this.addOpenDate(frb));
					//result.add(frb);
					cidList.add(frb.getCustomerid());
				}
			}
			i++;
		}

		if(i==1)
		{
			//只有一个
			frb=this.fromatReportData(this.genReportDate(relist,"inback"));
			result.add(this.addOpenDate(frb));
			//result.add(frb);
			cidList.add(frb.getCustomerid());
		}
		
		//以下部分为显示没有反馈信息的客户也要显示出来
		if(emid==null || "".equals(emid.trim()))
		{
			emid="0";
		}
		List<Customerstable> clist= icustomerstabledao.getCustomersByAny(hm1, hql1.toString());
			//icustomerstabledao.getAllCustomerstable(0, 0,null,Integer.parseInt(emid),null, null);
		List cintList=new ArrayList();
		for (Customerstable customer : clist) {
			cintList.add(customer.getCustomerid());
		}
		cintList.removeAll(cidList);
		for(int e=0;e<cintList.size();e++)
		{
			int temp=(Integer) cintList.get(e);
			frb=new FeedbackReportBean();
			frb.setCount(0);
			frb.setCustomerid(temp);
			frb.setEname(icustomerstabledao.getCustomerById(temp).getCustomercompany());
			frb.setLastfeedbacktype(0);
			frb.setFeedsubbean(this.readyNullData());
			result.add(this.addOpenDate(frb));
			//result.add(frb);
		}
		return result;
	}
	
	
	public List<Feedbacktable> getFeedBackByType(int type,
			List<Feedbacktable> list) {
		List<Feedbacktable> result = new ArrayList();
		Feedbacktable fb;
		for (Feedbacktable feedbacktable : list) {
			if (feedbacktable.getFeedbacktype().getConfigid() == type) {
				fb = new Feedbacktable();
				BeanUtils.copyProperties(feedbacktable, fb);
				result.add(fb);
			}
		}
		return result;
	}

	public IFeedbacktypeDao getIfd() {
		return ifd;
	}

	public void setIfd(IFeedbacktypeDao ifd) {
		this.ifd = ifd;
	}


	public List<FeedbacktableBean> getFeedbackTypeByCustomerid(int id,int page,int size) {
		String hql = "from Feedbacktable where feedbackcustomer=:cid order by feedbackdate desc";
		HashMap hm = new HashMap();
		hm.put("cid", id);
		FeedbacktableBean fbb;
		List result = new ArrayList();
		List<Feedbacktable> list = ifd.getFeedbackByWhere(hql, hm,page,size);
		for (Feedbacktable feedbacktable : list) {
			fbb = new FeedbacktableBean();
			BeanUtils.copyProperties(feedbacktable, fbb);
			fbb.setEname(feedbacktable.getFeedbackeid()==null?"":feedbacktable.getFeedbackeid().getEname());
			result.add(fbb);
		}
		return result;
	}

	public boolean addFeedbackType(FeedbacktableBean ftb) {
		Configuretable configuretable=icd.getConfigByid(ftb.getFeedbacktypeid());
		Customerstable customertable=icustomerstabledao.getCustomerById(ftb.getFeedbackcustomerid());
		Employye employye=ied.getEmployeeEdelStyleId(ftb.getFeedbackemployye());
		Feedbacktable feedbacktable=new Feedbacktable();
		feedbacktable.setFeedbackdate(ftb.getFeedbackdate());
		feedbacktable.setFeedbackmessage(ftb.getFeedbackmessage());
		feedbacktable.setFeedbackcustomer(customertable);
		feedbacktable.setFeedbackeid(employye);
		feedbacktable.setFeedbacktype(configuretable);
		return ifd.addFeedbackTable(feedbacktable);
	}

	public IConfiguretableDao getIcd() {
		return icd;
	}

	public void setIcd(IConfiguretableDao icd) {
		this.icd = icd;
	}

	public ICustomerstableDao getIcustomerstabledao() {
		return icustomerstabledao;
	}

	public void setIcustomerstabledao(ICustomerstableDao icustomerstabledao) {
		this.icustomerstabledao = icustomerstabledao;
	}

	public IEmployeeDao getIed() {
		return ied;
	}

	public void setIed(IEmployeeDao ied) {
		this.ied = ied;
	}

	public boolean delFeedbackType(int id) {
		return ifd.delFeekback(id);
	}

	public int getCount(int id) {
		return this.getFeedbackTypeByCustomerid(id, 0, 0).size();
	}

	/**
	 * 生成报表数据 根据取到的list集合
	 * @param data 要处理的数据
	 * @param flag 标志位，现在主要用来区分是不是内网客户反馈报表，其它报表都是显示业务员，而内网客户反馈报表显示的是客户名称
	 *  			如果是内网客户报表则传一个 inback进去，如果不是，则传null;
	 * @return
	 */
	public FeedbackReportBean genReportDate(List<Feedbacktable> data,String flag)
	{
		FeedbackReportBean frb=new FeedbackReportBean();
		FeedbacksubBean fsb=new FeedbacksubBean();
		List fsblist=new ArrayList();
		int i=0;
		int type=0;
		int count=0;
		for (Feedbacktable feedbacktable : data) {
			if(i==0)
			{
				//第一次
				type=feedbacktable.getFeedbacktype().getConfigid();
				fsb.setType(type);
				fsb.setNum(1);
				//fsblist.add(fsb);
			}
			if(type==feedbacktable.getFeedbacktype().getConfigid()&& i>0)
			{
				fsb.setNum(fsb.getNum()+1);
				if(i==data.size()-1)
				{
					fsblist.add(fsb);
					count=count+fsb.getNum();
				}
			}else if(type!=feedbacktable.getFeedbacktype().getConfigid() && i>0)
			{ //不是第一次，但类型不同
				type=feedbacktable.getFeedbacktype().getConfigid();
				fsblist.add(fsb);
				count=count+fsb.getNum();
				fsb=new FeedbacksubBean();
				fsb.setType(feedbacktable.getFeedbacktype().getConfigid());
				fsb.setNum(fsb.getNum()==0?1:fsb.getNum());
				if(i==data.size()-1)
				{
					fsblist.add(fsb);
					count=count+fsb.getNum();
				}
			}
			i++;
		}
		if(i==1)
		{
			count=count+fsb.getNum();
			fsblist.add(fsb);
		}
		if(flag==null || "".equals(flag))
		{
			frb.setEname(data.get(0).getFeedbackeid().getEname());
		}else
		{
			//如果是内网客户反馈统计报表
			frb.setEname(data.get(0).getFeedbackcustomer().getCustomercompany());
			frb.setLastfeedbacktype(data.get(0).getFeedbackcustomer().getCustomerfeedbacktype());
			frb.setCustomerid(data.get(0).getFeedbackcustomer().getCustomerid());
		}
		
		frb.setFeedsubbean(fsblist);
		frb.setCount(count);
		return frb;
	}
	
	public FeedbackReportBean fromatReportData(FeedbackReportBean data)
	{
		List<FeedbacksubBean> fsblist=data.getFeedsubbean();
		FeedbacksubBean fsb;
		List<Configuretable> fklist=icd.getAllByType("fk",0);
		for (Configuretable configuretable : fklist) {
			boolean flag=false;
			int type=configuretable.getConfigid();
			for (FeedbacksubBean feedbacksubbean : fsblist) {
				if(type==feedbacksubbean.getType())
				{
					flag=true;
					break;
				}
			}
		 if(!flag)
		 {
			 fsb=new FeedbacksubBean();
			 fsb.setType(configuretable.getConfigid());
			 fsb.setNum(0);
			 fsblist.add(fsb);
		 }
		}
		data.setFeedsubbean(fsblist);
		return data;
	}

	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean> data) {
		FeedbackReportBean frb=new FeedbackReportBean();
		List<Configuretable> fklist=icd.getAllByType("fk",0);//当前系统中的反馈列表
		List<FeedbacksubBean> list=new ArrayList();
		int count=0;//汇总记录数
		int i=0;
		
		for (FeedbackReportBean feedbackReportBean : data) {
			if(i==0)
			{
				frb.setFeedsubbean(feedbackReportBean.getFeedsubbean());
				list=frb.getFeedsubbean();
			}else
			{
				List<FeedbacksubBean> relist=feedbackReportBean.getFeedsubbean();
				for (FeedbacksubBean feedbacksubBean : list) {
					for (FeedbacksubBean refsb : relist) {
						if(refsb.getType()==feedbacksubBean.getType())
						{
							feedbacksubBean.setNum(feedbacksubBean.getNum()+refsb.getNum());
							break;
						}
					}
				}
			}
			count=count+feedbackReportBean.getCount();
			i++;
		}
		
		frb.setCount(count);
		return frb;
	}
	
	
	/**
	 * 准备空数据
	 * @return
	 */
	private List readyNullData()
	{
		List result=new ArrayList();
		List<Configuretable> fklist=icd.getAllByType("fk",0);
		FeedbacksubBean fsb1=null;
		for (Configuretable configuretable : fklist) {
			fsb1=new FeedbacksubBean();
			fsb1.setNum(0);
			fsb1.setType(configuretable.getConfigid());
			result.add(fsb1);
		}
		return result;
	}
	
	/**
	 * 为报表数据每行对象增加一个还差多少天客户信息将公开的列(内网客户反馈报表专用)
	 * @param frb
	 * @return
	 */
	private FeedbackReportBean addOpenDate(FeedbackReportBean frb)
	{
		
		int customerid=frb.getCustomerid();
		Customerstable customerstable=icustomerstabledao.getCustomerById(customerid);
		if(OPEN_CUSTOMER_GRADE_ID.contains(customerstable.getCutomergrade()))
		{
			//是公开类型的
			int openday=this.getOpenDayByCustomer(customerstable);
			if(openday<4)
			{
				//小于等于三天公开的时候，深色显示
				frb.setIscolor(1);
			}
			frb.setOpenDate(openday+"天后公开");
		}else
		{
			//不是公开类型的
			frb.setOpenDate("永不公开");
		}
		return frb;
	}
	
	/**
	 * 根据一个客户对象，取该客户对象离设置的公开日期还有多久
	 * @param customerstable
	 * @return
	 */
	private int getOpenDayByCustomer(Customerstable customerstable)
	{
		
		Date adddate=customerstable.getCustomerfeedbackdate();
		if(adddate==null)
		{
			// 如果是没有反馈日期的则代表是新增客户，找他的增加日期
			adddate=customerstable.getCustomeradddate();
			
		}
		int days=ConsoleDate.getDateDay(new Date(),adddate);
		int ruleid=(Integer) CUSTOMER_GRADE_RULE_ID.get(customerstable.getCutomergrade());
		Businessruletable bt=ibd.getRuleById(ruleid);
		int enddays=Integer.parseInt(bt.getRulevalue());
		
		return enddays-Math.abs(days);
	}


	public IBusinessruletableDao getIbd() {
		return ibd;
	}


	public void setIbd(IBusinessruletableDao ibd) {
		this.ibd = ibd;
	}
}
