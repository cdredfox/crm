package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.beans.FeedbackReportBean;
import com.netsoft.dao.beans.FeedbacksubBean;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.pojos.Configuretable;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Feedbacktable;
import com.netsoft.services.intf.IReportServices;

public class ReportServices implements IReportServices {

	public ICustomerstableDao icd;
	public IConfiguretableDao iconfigd;
	/**
	 * �ۺ�ͳ��
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
				//��һ��
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
			{ //���ǵ�һ�Σ���ҵ��Ա��ͬ
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
			//ֻ��һ��
			frb=this.fromatReportData(this.genReportDate(relist,type),type);
			result.add(frb);
		}
		return result;
	}

	/**
	 * �����ͻ�ͳ��
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
				//��һ��
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
			{ //���ǵ�һ�Σ���ҵ��Ա��ͬ
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
			//ֻ��һ��
			frb=this.fromatReportData(this.genReport(relist,"dj"),"dj");
			result.add(frb);
		}
		return result;
	}

	
	
	/**
	 * ��ҵ����Ա��ǰ�ͻ�ͳ�����ݱ���
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
				//��һ��
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
			{ //���ǵ�һ�Σ���ҵ��Ա��ͬ
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
			//ֻ��һ��
			frb=this.fromatReportData(this.genReportDate(relist,"dj"),"dj");
			result.add(frb);
		}
		return result;
	}
	
	/**
	 * ���ݲ�ѯ�������ݣ����ɱ�������
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
				//��һ��
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
			{ //���ǵ�һ�Σ������Ͳ�ͬ
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
		frb.setEname(data.get(0).getEmployye()==null?"�����ͻ�":data.get(0).getEmployye().getEname());
		frb.setFeedsubbean(fsblist);
		frb.setCount(count);
		return frb;
	}

	/**
	 * ���ݱ������ݣ���ʽ������
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
	 * ���������
	 * @param data
	 * @param ftype
	 * @return
	 */
	public FeedbackReportBean getFeedbackTypeReportCountDataByList(List<FeedbackReportBean> data,String ftype) {
		FeedbackReportBean frb=new FeedbackReportBean();
		List<Configuretable> fklist=iconfigd.getAllByType(ftype,0);//��ǰϵͳ�еķ����б�
		List<FeedbacksubBean> list=new ArrayList();
		int count=0;//���ܼ�¼��
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
	 * ���ݿͻ���������ͷ���ֵ
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
	 * ���ݲ�ѯ�������ݣ����ɱ�������(ר���������ͻ�ͳ�Ʊ���)
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
				//��һ��
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
			{ //���ǵ�һ�Σ������Ͳ�ͬ
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
		frb.setEname(data.get(0).getEmployye()==null?"δ���ֵ�����":data.get(0).getAddemployye().getEname());
		frb.setFeedsubbean(fsblist);
		frb.setCount(count);
		return frb;
	}
	
}
