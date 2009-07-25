package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.DataAuthority;
public interface IDataAuthorityDao {
	public List<DataAuthority> getDataAuthorityByTopId(int topid);
	public boolean deleteDataAuthorityByTopId(int topid);	
	public boolean addDataAuthority(DataAuthority da);
}
