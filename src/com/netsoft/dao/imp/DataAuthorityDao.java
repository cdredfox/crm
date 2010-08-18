package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IDataAuthorityDao;
import com.netsoft.dao.pojos.DataAuthority;

public class DataAuthorityDao implements IDataAuthorityDao {

	  private ICommonDao cd;
	  Logger log = Logger.getLogger(this.getClass());
	
	public boolean deleteDataAuthorityByTopId(int topid)
	{
		String hql="delete from DataAuthority where topid=:topid";
		HashMap hm=new HashMap();
		hm.put("topid",topid);
		return cd.dele(hql, hm);
	}
	
	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}

	public boolean addDataAuthority(DataAuthority da)
	{
		return cd.add(da);
	}
	public List<DataAuthority> getDataAuthorityByTopId(int topid) {
		String hql="from DataAuthority as d where d.topid=:topid";
		
		HashMap hm=new HashMap();
		hm.put("topid", topid);
		return cd.getObjectByHql(hql,hm);
	}

}
