package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.ConfiguretableBean;

public interface IConfiguretableServices {
	/**
	 * 取配置信息的大类
	 * @return
	 */
	public List<ConfiguretableBean> getType();
	
	/**
	 * 根据type类型查找其下面所有的子类型
	 * @param type
	 * @return
	 */
	public List<ConfiguretableBean> getAllByType(String type,int flag);
	
	/**
	 * 增加一个配置
	 * @param cb
	 * @return
	 */
	public boolean addConfig(ConfiguretableBean cb);
	
	/**
	 * 根据oid来删除一个对象
	 * @param id
	 * @return
	 */
	public boolean delConfig(int id);
	
	public String qryConfigByTypeAndValue(String type,String value);
	
	public String qryPhoneByTypeAndValue(String type, String value);
	
	public ConfiguretableBean getConfigByid(int id);
	/**
	 * 取得某类型的最大编号
	 * @param type
	 * @return
	 */
	public String getMaxNumByType(String type);
	/**
	 * 修改一个配置信息
	 * @param cb
	 */
	public void updateConfig(ConfiguretableBean cb);
}
