package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.ConfiguretableBean;
import com.netsoft.dao.pojos.Configuretable;

public interface IConfiguretableServices {
	/**
	 * 取锟斤拷锟斤拷锟斤拷息锟侥达拷锟斤拷
	 * @return
	 */
	public List<ConfiguretableBean> getType();
	
	/**
	 * 锟斤拷锟絫ype锟斤拷锟酵诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷锟斤拷锟斤拷
	 * @param type
	 * @return
	 */
	public List<ConfiguretableBean> getAllByType(String type,int flag);
	
	/**
	 * 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷
	 * @param cb
	 * @return
	 */
	public boolean addConfig(ConfiguretableBean cb);
	
	/**
	 * 锟斤拷锟给id锟斤拷删锟斤拷一锟斤拷锟斤拷锟斤拷
	 * @param id
	 * @return
	 */
	public boolean delConfig(int id);
	
	public String qryConfigByTypeAndValue(String type,String value);
	
	public String qryPhoneByTypeAndValue(String type, String value);
	
	public ConfiguretableBean getConfigByid(int id);
	/**
	 * 取锟斤拷某锟斤拷锟酵碉拷锟斤拷锟斤拷锟?
	 * @param type
	 * @return
	 */
	public String getMaxNumByType(String type);
	/**
	 * 锟睫革拷一锟斤拷锟斤拷锟斤拷锟斤拷息
	 * @param cb
	 */
	public void updateConfig(ConfiguretableBean cb);
	public Configuretable qryConfigByValue(String type, String value);
}
