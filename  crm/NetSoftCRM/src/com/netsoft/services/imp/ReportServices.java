package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacksubBean;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.intf.IFeedbacktypeDao;
import com.netsoft.dao.pojos.Configuretable;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Feedbacktable;
import com.netsoft.services.intf.IReportServices;
import com.netsoft.util.CRM;

public class ReportServices implements IReportServices {

	public ICustomerstableDao icd;
	public IConfiguretableDao iconfigd;
	public IFeedbacktypeDao ifd;
	
	public IFeedbacktypeDao getIfd() {
		return ifd;
	}

	public void setIfd(IFeedbacktypeDao ifd) {
		this.ifd = ifd;
	}

	/**
	 * 综合统计
	 */
	public List getAddCoustomerReportData(String startdate, String enddate,
			String type,String customergrade) {
		HashMap hm=new HashMap();
		String hql="from Customerstable where customeradddate>=:startdate and customeradddate<=:enddate and eid is not null and cutomergrade=:grade order by eid,";
		if("ly".equals(type))
		{
			hql=hql+"customersource";
		}else if("xz".equals(type))
		{
			hql=hql+"customerproperty";
		}else
		{
			hql=hql+"";
		}
		hm.put("startdate", startdate);
		hm.put("enddate", enddate);
		hm.put("grade",customergrade);
		List<Customerstable> list=icd.getCustomersByAny(hm, hql);
		FeedbackReportBean frb;
		FeedbacksubBean fsb=new FeedbacksubBean();
		List result=new ArrayList();
		int i=0;
		int eid=0;
		List relist=new ArrayList();
		for (Customerstable customerstable : list) {
			if(i==0)
			{
				//第一次
				//relist=new ArrayList();
				eid=customerstable.getEmployye().getId();
				relist.add(customerstable);
			}
			if(eid==customerstable.getEmployye().getId()&& i>0)
			{
				relist.add(customerstable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,type),type);
					result.add(frb);
				}
			}else if(eid!=customerstable.getEmployye().getId() && i>0)
			{ //不是第一次，但业务员不同
				eid=customerstable.getEmployye().getId();
				frb=this.fromatReportData(this.genReportDate(relist,type),type);
				result.add(frb);
				relist=new ArrayList();
				eid=customerstable.getEmployye().getId();
				relist.add(customerstable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,type),type);
					result.add(frb);
				}
			}
			i++;
		}
		if(i==1)
		{
			//只有一个
			frb=this.fromatReportData(this.genReportDate(relist,type),type);
			result.add(frb);
		}
		return result;
	}

	/**
	 * 新增客户统计
	 */
	public List getBusiCountReportData(String startdate, String enddate) {
		String hql="from Customerstable where customeradddate>=:startdate and customeradddate<=:enddate and addeid is not null order by addeid,cutomergrade";
		HashMap hm=new HashMap();
		hm.put("startdate", startdate);
		hm.put("enddate", enddate);
		List<Customerstable> list=icd.getCustomersByAny(hm, hql);
		FeedbackReportBean frb;
		FeedbacksubBean fsb=new FeedbacksubBean();
		List result=new ArrayList();
		int i=0;
		int eid=0;
		List relist=new ArrayList();
		for (Customerstable customerstable : list) {
			if(i==0)
			{
				//第一次
				//relist=new ArrayList();
				eid=customerstable.getAddemployye().getId();
				relist.add(customerstable);
			}
			if(eid==customerstable.getAddemployye().getId()&& i>0)
			{
				relist.add(customerstable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReport(relist,"dj"),"dj");
					result.add(frb);
				}
			}else if(eid!=customerstable.getAddemployye().getId() && i>0)
			{ //不是第一次，但业务员不同
				eid=customerstable.getAddemployye().getId();
				frb=this.fromatReportData(this.genReport(relist,"dj"),"dj");
				result.add(frb);
				relist=new ArrayList();
				eid=customerstable.getAddemployye().getId();
				relist.add(customerstable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReport(relist,"dj"),"dj");
					result.add(frb);
				}
			}
			i++;
		}
		if(i==1)
		{
			//只有一个
			frb=this.fromatReportData(this.genReport(relist,"dj"),"dj");
			result.add(frb);
		}
		return result;
	}

	
	
	/**
	 * 各业务人员当前客户统计数据报表
	 */
	public List getBusiOwenCustomer() {
		String hql="from Customerstable order by eid,cutomergrade";
		HashMap hm=new HashMap();
		List<Customerstable> list=icd.getCustomersByAny(hm, hql);
		FeedbackReportBean frb;
		FeedbacksubBean fsb=new FeedbacksubBean();
		List result=new ArrayList();
		int i=0;
		int eid=0;
		List relist=new ArrayList();
		for (Customerstable customerstable : list) {
			if(i==0)
			{
				//第一次
				//relist=new ArrayList();
				eid=customerstable.getEmployye()==null?0:customerstable.getEmployye().getId();
				//eid=customerstable.getEmployye().getId();
				relist.add(customerstable);
			}
			
			
			if((eid==(customerstable.getEmployye()==null?0:customerstable.getEmployye().getId()))&& i>0)
			{
				relist.add(customerstable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,"dj"),"dj");
					result.add(frb);
				}
			}else if(eid!=(customerstable.getEmployye()==null?0:customerstable.getEmployye().getId()) && i>0)
			{ //不是第一次，但业务员不同
				eid=customerstable.getEmployye()==null?0:customerstable.getEmployye().getId();
				frb=this.fromatReportData(this.genReportDate(relist,"dj"),"dj");
				result.add(frb);
				relist=new ArrayList();
				eid=customerstable.getEmployye()==null?0:customerstable.getEmployye().getId();
				relist.add(customerstable);
				if(i==list.size()-1)
				{
					frb=this.fromatReportData(this.genReportDate(relist,"dj"),"dj");
					result.add(frb);
				}
			}
			i++;
		}
		if(i==1)
		{
			//只有一个
			frb=this.fromatReportData(this.genReportDate(relist,"dj"),"dj");
			result.add(frb);
		}
		return result;
	}
	
	/**
	 * 根据查询出的数据，生成报表数据
	 * @param data
	 * @return
	 */
	private FeedbackReportBean genReportDate(List<Customerstable> data,String ftype)
	{
		FeedbackReportBean frb=new FeedbackReportBean();
		FeedbacksubBean fsb=new FeedbacksubBean();
		List fsblist=new ArrayList();
		int i=0;
		int type=0;
		int count=0;
		for (Customerstable customerstable : data) {
			if(i==0)
			{
				//第一次
				//type=customerstable.getCutomergrade();
				type=this.returnCustomerByType(customerstable, ftype);
				fsb.setType(type);
				fsb.setNum(1);
				//fsblist.add(fsb);
			}
			if(type==this.returnCustomerByType(customerstable, ftype)&& i>0)
			{
				fsb.setNum(fsb.getNum()+1);
				if(i==data.size()-1)
				{
					fsblist.add(fsb);
					count=count+fsb.getNum();
				}
			}else if(type!=this.returnCustomerByType(customerstable, ftype) && i>0)
			{ //不是第一次，但类型不同
				type=this.returnCustomerByType(customerstable, ftype);
				fsblist.add(fsb);
				count=count+fsb.getNum();
				fsb=new FeedbacksubBean();
				fsb.setType(this.returnCustomerByType(customerstable, ftype));
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
		
		//frb.setEname(data.get(0).getEmployye().getEname());
		frb.setEname(data.get(0).getEmployye()==null?"公开客户":data.get(0).getEmployye().getEname());
		frb.setFeedsubbean(fsblist);
		frb.setCount(count);
		return frb;
	}

	/**
	 * 根据报表数据，格式化数据
	 * @param data
	 * @param ftype
	 * @return
	 */
	private  FeedbackReportBean fromatReportData(FeedbackReportBean data,String ftype)
	{
		List<FeedbacksubBean> fsblist=data.getFeedsubbean();
		FeedbacksubBean fsb;
		List<Configuretable> fklist=iconfigd.getAllByType(ftype,0);
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
	
	/**
	 * 计算汇总行
	 * @param data
	 * @param ftype
	 * @return
	 */
	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean> data,String ftype) {
		FeedbackReportBean frb=new FeedbackReportBean();
		List<Configuretable> fklist=iconfigd.getAllByType(ftype,0);//当前系统中的反馈列表
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
	 * 根据客户对象和类型返回值
	 * @param cu
	 * @param type
	 * @return
	 */
	private int returnCustomerByType(Customerstable cu,String type)
	{
		if("ly".equals(type))
		{
			return cu.getCustomersource();
		}else if("xz".equals(type))
		{
			return cu.getCustomerproperty();
		}else
		{
			return cu.getCutomergrade();
		}
	}
	
	public ICustomerstableDao getIcd() {
		return icd;
	}

	public void setIcd(ICustomerstableDao icd) {
		this.icd = icd;
	}

	public IConfiguretableDao getIconfigd() {
		return iconfigd;
	}

	public void setIconfigd(IConfiguretableDao iconfigd) {
		this.iconfigd = iconfigd;
	}
	
	
	
	/**
	 * 根据查询出的数据，生成报表数据(专用于新增客户统计报表)
	 * @param data
	 * @return
	 */
	private FeedbackReportBean genReport(List<Customerstable> data,String ftype)
	{
		FeedbackReportBean frb=new FeedbackReportBean();
		FeedbacksubBean fsb=new FeedbacksubBean();
		List fsblist=new ArrayList();
		int i=0;
		int type=0;
		int count=0;
		for (Customerstable customerstable : data) {
			if(i==0)
			{
				//第一次
				//type=customerstable.getCutomergrade();
				type=this.returnCustomerByType(customerstable, ftype);
				fsb.setType(type);
				fsb.setNum(1);
				//fsblist.add(fsb);
			}
			if(type==this.returnCustomerByType(customerstable, ftype)&& i>0)
			{
				fsb.setNum(fsb.getNum()+1);
				if(i==data.size()-1)
				{
					fsblist.add(fsb);
					count=count+fsb.getNum();
				}
			}else if(type!=this.returnCustomerByType(customerstable, ftype) && i>0)
			{ //不是第一次，但类型不同
				type=this.returnCustomerByType(customerstable, ftype);
				fsblist.add(fsb);
				count=count+fsb.getNum();
				fsb=new FeedbacksubBean();
				fsb.setType(this.returnCustomerByType(customerstable, ftype));
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
		
		//frb.setEname(data.get(0).getEmployye().getEname());
		frb.setEname(data.get(0).getEmployye()==null?"未发现的数据":data.get(0).getAddemployye().getEname());
		frb.setFeedsubbean(fsblist);
		frb.setCount(count);
		return frb;
	}
	
	
	
	/**
	 * 查询每天各时段的反馈报表数据
	 */
	@SuppressWarnings("unchecked")
	public List<FeedbackReportBean> getFeedbackDaliyReportData(String eid,String date){
		StringBuffer hql=new StringBuffer();
		List<Object> values=new ArrayList<Object>();
		hql.append(" SELECT count(*) as num,f.feedbacktype,CASE");
		hql.append(" WHEN feedbackdate>'").append(date+" 00:00:00").append("' AND feedbackdate<='").append(date+" 09:00:00").append("' THEN 1");
		hql.append(" WHEN feedbackdate>'").append(date+" 09:00:00").append("' AND feedbackdate<='").append(date+" 10:00:00").append("' THEN 2");
		hql.append(" WHEN feedbackdate>'").append(date+" 10:00:00").append("' AND feedbackdate<='").append(date+" 11:00:00").append("' THEN 3");
		hql.append(" WHEN feedbackdate>'").append(date+" 11:00:00").append("' AND feedbackdate<='").append(date+" 12:00:00").append("' THEN 4");
		hql.append(" WHEN feedbackdate>'").append(date+" 12:00:00").append("' AND feedbackdate<='").append(date+" 13:30:00").append("' THEN 5");
		hql.append(" WHEN feedbackdate>'").append(date+" 13:30:00").append("' AND feedbackdate<='").append(date+" 14:30:00").append("' THEN 6");
		hql.append(" WHEN feedbackdate>'").append(date+" 14:30:00").append("' AND feedbackdate<='").append(date+" 15:30:00").append("' THEN 7");
		hql.append(" WHEN feedbackdate>'").append(date+" 15:30:00").append("' AND feedbackdate<='").append(date+" 16:30:00").append("' THEN 8");
		hql.append(" WHEN feedbackdate>'").append(date+" 16:30:00").append("' AND feedbackdate<='").append(date+" 17:30:00").append("' THEN 9");
		hql.append(" WHEN feedbackdate>'").append(date+" 17:30:00").append("' AND feedbackdate<='").append(date+" 24:00:00").append("' THEN 10");
		hql.append(" END as timeType");
		hql.append(" from feedbacktable f");
		hql.append(" where 1=1");
		if(StringUtils.isNotEmpty(eid)){
			hql.append(" and f.feedbackeid=?");
			values.add(eid);
		}
		hql.append(" and feedbackdate>='").append(date+" 00:00:00").append("' and feedbackdate<='").append(date+" 23:59:59'");
		hql.append(" group by timeType,feedbacktype");
		hql.append(" order by timeType");
		List<Object[]> reportData=ifd.getFeedbackDaliyReportData(hql.toString(), values.toArray());
		List<FeedbackReportBean> result=this.genDaliyReport(reportData);
		Collections.sort(result);
		return result;
	}
	
	/**
	 * 转换每天各时段的报表数据为通用报表数据格式
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<FeedbackReportBean> genDaliyReport(List<Object[]> data){
		List<FeedbackReportBean> result=new ArrayList<FeedbackReportBean>();
		List<FeedbacksubBean> fsbList=new ArrayList<FeedbacksubBean>();
		FeedbackReportBean frb=null;
		FeedbacksubBean fsb=null;
		int size=0;
		Integer oldRow=0;
		int total=0;
		for (Object[] obj : data) {
			Integer newRow=Integer.parseInt((String.valueOf(obj[2])));//是哪个时间段
			if(size==0){//第一次
				oldRow=Integer.parseInt(String.valueOf(obj[2]));//是哪个时间段
				frb=new FeedbackReportBean();
				frb.setId((Integer)obj[2]);
				fsb=new FeedbacksubBean();
				fsb.setType(Integer.parseInt(String.valueOf(obj[1])));
				fsb.setNum(Integer.parseInt(String.valueOf(obj[0])));
				fsbList=new ArrayList<FeedbacksubBean>();
				total+=fsb.getNum();
				fsbList.add(fsb);
				size++;
			}else{
				fsb=new FeedbacksubBean();
				fsb.setType(Integer.parseInt(String.valueOf(obj[1])));
				fsb.setNum(Integer.parseInt(String.valueOf(obj[0])));
				if(!newRow.equals(oldRow)){//不在同一个时间段
					frb.setCount(total);
					frb.setFeedsubbean(fsbList);
					result.add(frb);
					total=0;
					fsbList=new ArrayList<FeedbacksubBean>();
					fsbList.add(fsb);
					total+=fsb.getNum();
					frb=new FeedbackReportBean();
					frb.setId((Integer)obj[2]);
				}else{
					//在同一个时间段
					total+=fsb.getNum();
					fsbList.add(fsb);
				}
			}
			oldRow=newRow;
	}
		if(frb!=null){
			frb.setCount(total);
			frb.setFeedsubbean(fsbList);
		}
		if(frb!=null)
			result.add(frb);
		this.fromatReportData(result);
		return result;
	}
	
	/**
	 * 格式化返回的报表格式。填充没有数据的反馈类型
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void fromatReportData(List<FeedbackReportBean> list)
	{
		List result =new ArrayList();
		FeedbackReportBean frb;
		Map<Integer,Object> map=new HashMap<Integer,Object>();
			for (FeedbackReportBean data : list) {
				map.put(data.getId(),null);
				data.setEname((String)CRM.TIME_SCOPE.get(data.getId()));
				this.formatFeedbackReportBean(data);
			}
		for(int i=1;i<12;i++){
			if(!map.containsKey(i)){
				frb=new FeedbackReportBean();
				frb.setId(i);
				frb.setEname((String)CRM.TIME_SCOPE.get(i));
				frb.setFeedsubbean(new ArrayList<Configuretable>());
				this.formatFeedbackReportBean(frb);
				list.add(frb);
		}
		}
   }
    /**
     * 格式化	FeedbackReportBean 填充没有数据的反馈类型
     * @param data
     */
   private void formatFeedbackReportBean(FeedbackReportBean data){
	   List<FeedbacksubBean> fsblist=data.getFeedsubbean();
		FeedbacksubBean fsb;
		List<Configuretable> fklist=iconfigd.getAllByType("fk",0);
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
   }
}
