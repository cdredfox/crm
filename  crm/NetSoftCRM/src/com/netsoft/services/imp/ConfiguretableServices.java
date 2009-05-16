package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.ConfiguretableBean;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.pojos.Configuretable;
import com.netsoft.services.intf.IConfiguretableServices;

public class ConfiguretableServices implements IConfiguretableServices {
	private IConfiguretableDao icd;
	public List<ConfiguretableBean> getType() {
		List<Configuretable> list=icd.getType();
		List<ConfiguretableBean> result=new ArrayList<ConfiguretableBean>();
		ConfiguretableBean ctb;
		for (Configuretable configuretable : list) {
			ctb=new ConfiguretableBean();
			BeanUtils.copyProperties(configuretable, ctb);
			result.add(ctb);
		}
		return result;
	}
	public IConfiguretableDao getIcd() {
		return icd;
	}
	public void setIcd(IConfiguretableDao icd) {
		this.icd = icd;
	}
	public List<ConfiguretableBean> getAllByType(String type,int flag) {
		List<Configuretable> list = icd.getAllByType(type,flag);
		List<ConfiguretableBean> result=new ArrayList<ConfiguretableBean>();
		ConfiguretableBean ctb;
		for (Configuretable configuretable : list) {
			ctb=new ConfiguretableBean();
			BeanUtils.copyProperties(configuretable, ctb);
			result.add(ctb);
		}
		return result;
	}
	public boolean addConfig(ConfiguretableBean cb) {
		Configuretable ct=new Configuretable();
		BeanUtils.copyProperties(cb,ct);
		icd.addConfig(ct);
		return true;
	}
	public boolean delConfig(int id) {
		if(id==999999)
		{
			return false;
		}
		return icd.delConfig(id);
	}
	public String qryConfigByTypeAndValue(String type, String value) {
		String hql="from Configuretable where configtype=:type and configvalue=:value";
		HashMap hm=new HashMap();
		hm.put("type",type);
		hm.put("value", value);
		List<Configuretable> list=icd.qryConfigByAny(hql, hm);
		if(list!=null && list.size()>0)
		{
			return list.get(0).getConfignote();
		}
		return "";
	}
	//²éµç»°ºÅÂë
	public String qryPhoneByTypeAndValue(String type, String value) {
		String hql="from Configuretable where configtype=:type and configmessage=:value";
		HashMap hm=new HashMap();
		hm.put("type",type);
		hm.put("value", value);
		List<Configuretable> list=icd.qryConfigByAny(hql, hm);
		if(list!=null && list.size()>0)
		{
			return list.get(0).getConfignote();
		}
		return "";
	}
	public ConfiguretableBean getConfigByid(int id) {
		ConfiguretableBean ctb=new ConfiguretableBean();
		Configuretable ct=icd.getConfigByid(id);
		BeanUtils.copyProperties(ct, ctb);
		return ctb;
	}
	public String getMaxNumByType(String type) {
		String hql="from Configuretable where configtype=:type order by configid desc";
		HashMap hm=new HashMap();
		hm.put("type",type);
		List<Configuretable> list=icd.qryConfigByAny(hql, hm);
		if(list!=null && list.size()>0)
		{
			if("dj".equals(type))
			{
				return list.get(1).getConfigvalue();
			}else
			{
				return list.get(0).getConfigvalue();
			}
			}
		return "";
	}
	public void updateConfig(ConfiguretableBean cb) {
		Configuretable ctb=new Configuretable();
			BeanUtils.copyProperties(cb, ctb);
		icd.updateConfig(ctb);
		
	}
}
