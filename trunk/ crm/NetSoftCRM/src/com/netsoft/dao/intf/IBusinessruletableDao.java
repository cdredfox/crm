package com.netsoft.dao.intf;

import java.util.List;

import com.netsoft.dao.pojos.Businessruletable;

public interface IBusinessruletableDao {
	/**
	 * 得到所有的规则设置
	 * @param brt
	 */
	public List<Businessruletable> getAllRule();
	/**
	 * 修改一个规则设置对象
	 * @param brt
	 */
	public void updateRule(Businessruletable brt);
	
	/**
	 * 根据id号查找一个规则
	 * @param id
	 * @return
	 */
	public Businessruletable getRuleById(int id);

}
