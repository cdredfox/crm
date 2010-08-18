package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.ICustomerstableDao;
import com.netsoft.dao.pojos.Customerstable;

/**
 * 对客户表进行相关的dao维护
 * @author yangfei
 *
 */
public class CustomerstableDao implements ICustomerstableDao {

	Logger log = Logger.getLogger(this.getClass());
	private ICommonDao cd;
	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}
	public <cl> cl addCustomerstable(Customerstable cu) {
		//cd.add(cu);
		return cd.addreturn(cu);
	}
    /**
     * 根据传过来的客户ID删除一个客户
     */
	public boolean delCustomerstable(int id) {
		try {
			log.info("delCustomerstable方法开始执行!");
			return cd.dele(Customerstable.class,id);
		} catch (Exception e) {
			log.error("delCustomerstable方法执行失败!");
			return false;
		}
	}

	/**
	 * 获取所有的客户对象
	 */
	public List<Customerstable> getAllCustomerstable(int page,int size,String company,int eid,String startdate,String enddate) {
		HashMap hm=new HashMap();
		String hql="from Customerstable where 1=1 ";
		if(company!=null && !"".equals(company.trim()))
		{
			hql=hql+" and customercompany like :company";
			hm.put("company", "%"+company.trim()+"%");
		}
		if(eid!=0)
		{
			hql=hql+" and employye=:eid";
			hm.put("eid", eid);
		}
		if(startdate!=null && !"".equals(startdate.trim()))
		{
			hql=hql+" and customeradddate>=:startdate";
			hm.put("startdate", startdate);
		}
		if(enddate!=null && !"".equals(enddate.trim()))
		{
			hql=hql+" and customeradddate<=:enddate";
			hm.put("enddate", enddate);
		}
		List result=cd.currenPage(page, size, hql, hm);
		return result;

	}

	public List<Customerstable> getCustomersByEid(int eid,int page,int size,String company,String startdate,String enddate,int cutomergrade) {
		String hql="from Customerstable where employye =:eid";
		HashMap hm=new HashMap();
		if(company!=null && !"".equals(company.trim()))
		{
			hql=hql+" and customercompany like :company";
			hm.put("company", "%"+company.trim()+"%");
		}
		if(startdate!=null && !"".equals(startdate.trim()))
		{
			hql=hql+" and customeradddate>=:startdate";
			hm.put("startdate", startdate);
		}
		if(enddate!=null && !"".equals(enddate.trim()))
		{
			hql=hql+" and customeradddate<=:enddate";
			hm.put("enddate", enddate);
		}
		if(cutomergrade!=0)
		{
			hql=hql+" and cutomergrade=:cutomergrade";
			hm.put("cutomergrade", cutomergrade);
		}
		hql=hql+" order by customernextdate";
		hm.put("eid", eid);
		List result=cd.currenPage(page, size, hql, hm);
		return result;

	}

	public List<Customerstable> getCustomersByOpen(int page,int size,String company,String startdate,String enddate,int cutomergrade) {
		String hql="from Customerstable where employye is null";
		HashMap hm=new HashMap();
		if(company!=null && !"".equals(company.trim()))
		{
			hql=hql+" and customercompany like :company";
			hm.put("company", "%"+company.trim()+"%");
		}
		if(startdate!=null && !"".equals(startdate.trim()))
		{
			hql=hql+" and customeradddate>=:startdate";
			hm.put("startdate", startdate);
		}
		if(enddate!=null && !"".equals(enddate.trim()))
		{
			hql=hql+" and customeradddate<=:enddate";
			hm.put("enddate", enddate);
		}
		if(cutomergrade!=0)
		{
			hql=hql+" and cutomergrade=:cutomergrade";
			hm.put("cutomergrade", cutomergrade);
		}
		List result=cd.currenPage(page, size, hql, hm);
		return result;

	}

	/**
	 * 更新一个客户对象
	 */
	public void updateCustomerstable(Customerstable cu) {
		try {
			cd.updateObject(cu);
		} catch (Exception e) {
			log.error("Dao层更新客户对象时出错了");
		}

	}

	public List<Customerstable> getCustomersByAny(HashMap hm,String hql) {
		return cd.getObjectByHql(hql, hm);
	}

	public List<Customerstable> getCustomerByEidAndGrade(int eid, int grade) {
		String hql="from Customerstable where employye =:eid and cutomergrade =:grade";
		HashMap hm=new HashMap();
		hm.put("eid", eid);
		hm.put("grade", grade);
		List result=cd.getObjectByHql(hql, hm);
		return result;
	}

	/**
	 * 根据ID得到一个客户持久化对象
	 */
	public Customerstable getCustomerById(int id) {
		try {
			return cd.getObjectById(Customerstable.class,id);
		} catch (Exception e) {
			log.error("Dao层根据ID查找客户对象时出错了");
			return null;
		}
	}

	public List<Customerstable> getCustomerByGrade(int grade) {
		String hql="from Customerstable where cutomergrade =:grade and employye is not null";
		HashMap hm=new HashMap();
		hm.put("grade", grade);
		List result=cd.getObjectByHql(hql, hm);
		return result;
	}

	public List<Customerstable> getCustomersByInvali(int page,int size,String company,String startdate,String enddate,int cutomergrade) {
		String hql="from Customerstable where employye is null and cutomergrade =:grade";
		HashMap hm=new HashMap();
		hm.put("grade",999999);
		if(company!=null && !"".equals(company.trim()))
		{
			hql=hql+" and customercompany like :company";
			hm.put("company", "%"+company.trim()+"%");
		}
		if(startdate!=null && !"".equals(startdate.trim()))
		{
			hql=hql+" and customeradddate>=:startdate";
			hm.put("startdate", startdate);
		}
		if(enddate!=null && !"".equals(enddate.trim()))
		{
			hql=hql+" and customeradddate<=:enddate";
			hm.put("enddate", enddate);
		}
		if(cutomergrade!=0)
		{
			hql=hql+" and cutomergrade=:cutomergrade";
			hm.put("cutomergrade", cutomergrade);
		}
		List result=cd.currenPage(page, size, hql, hm);
		return result;

	}

}
