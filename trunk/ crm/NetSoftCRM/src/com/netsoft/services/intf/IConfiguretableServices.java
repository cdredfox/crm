package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.ConfiguretableBean;
import com.netsoft.dao.pojos.Configuretable;

public interface IConfiguretableServices {
	/**
	 * ȡ������Ϣ�Ĵ���
	 * @return
	 */
	public List<ConfiguretableBean> getType();
	
	/**
	 * ���type���Ͳ������������е�������
	 * @param type
	 * @return
	 */
	public List<ConfiguretableBean> getAllByType(String type,int flag);
	
	/**
	 * ����һ������
	 * @param cb
	 * @return
	 */
	public boolean addConfig(ConfiguretableBean cb);
	
	/**
	 * ���oid��ɾ��һ������
	 * @param id
	 * @return
	 */
	public boolean delConfig(int id);
	
	public String qryConfigByTypeAndValue(String type,String value);
	
	public String qryPhoneByTypeAndValue(String type, String value);
	
	public ConfiguretableBean getConfigByid(int id);
	/**
	 * ȡ��ĳ���͵������
	 * @param type
	 * @return
	 */
	public String getMaxNumByType(String type);
	/**
	 * �޸�һ��������Ϣ
	 * @param cb
	 */
	public void updateConfig(ConfiguretableBean cb);
	public Configuretable qryConfigByValue(String type, String value);
}
