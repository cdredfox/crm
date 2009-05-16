package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.Configuretable;

public interface IConfiguretableDao {
	
	/**
	 * ����һ������
	 */
	public boolean addConfig(Configuretable ct);

	/**
	 * ����IDɾ��һ������
	 * @param id
	 * @return
	 */
	public boolean delConfig(int id);
	
	/**
	 * �õ����е����÷���
	 */
	public List<Configuretable> getType();
	/**
	 * ����ĳ��type�õ�typ�µ������б�
	 * @param type
	 * @return
	 */
	public List<Configuretable> getAllByType(String type,int flag);
	
	public  List<Configuretable> qryConfigByAny(String hql,HashMap hm);
	
	public Configuretable getConfigByid(int id);
	
	public void updateConfig(Configuretable ctb);
}
