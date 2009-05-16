package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.Configuretable;

public interface IConfiguretableDao {
	
	/**
	 * 增加一个配置
	 */
	public boolean addConfig(Configuretable ct);

	/**
	 * 根据ID删除一个配置
	 * @param id
	 * @return
	 */
	public boolean delConfig(int id);
	
	/**
	 * 得到所有的配置分类
	 */
	public List<Configuretable> getType();
	/**
	 * 根所某个type得到typ下的所有列表
	 * @param type
	 * @return
	 */
	public List<Configuretable> getAllByType(String type,int flag);
	
	public  List<Configuretable> qryConfigByAny(String hql,HashMap hm);
	
	public Configuretable getConfigByid(int id);
	
	public void updateConfig(Configuretable ctb);
}
