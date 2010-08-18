package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.pojos.Configuretable;

public class ConfiguretableDao implements IConfiguretableDao {
	 private ICommonDao cd;
	 Logger log = Logger.getLogger(this.getClass());

	public boolean addConfig(Configuretable ct) {
		cd.add(ct);
		return true;
	}

	public boolean delConfig(int id) {
		return cd.dele(Configuretable.class,id);
	}

	public List<Configuretable> getAllByType(String type,int flag) {
		String hql="from Configuretable where configtype=:type and configtopid=:flag";
		HashMap hm=new HashMap();
		hm.put("type",type);
		hm.put("flag", flag);
		List<Configuretable> list=cd.getObjectByHql(hql, hm);
		return list;
	}

	public List<Configuretable> getType() {
		String hql="from Configuretable group by configtype";
		List<Configuretable> list=cd.getObjectByHql(hql);
		return list;
	}

	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}

	public List<Configuretable> qryConfigByAny(String hql, HashMap hm) {
		return cd.getObjectByHql(hql, hm);
	}

	public Configuretable getConfigByid(int id) {
		return cd.getObjectById(Configuretable.class, id);
	}

	public void updateConfig(Configuretable ctb) {
		cd.updateObject(ctb);
		
	}

}
