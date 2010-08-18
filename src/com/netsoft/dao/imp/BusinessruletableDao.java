package com.netsoft.dao.imp;

import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IBusinessruletableDao;
import com.netsoft.dao.pojos.Businessruletable;

public class BusinessruletableDao implements IBusinessruletableDao {

	Logger log = Logger.getLogger(this.getClass());
	private ICommonDao cd;
	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}
	public List<Businessruletable> getAllRule() {
		return cd.getObjectAll(Businessruletable.class);
	}

	public void updateRule(Businessruletable brt) {
		cd.updateObject(brt);

	}
	
	/**
	 * 根据id号查找一个规则
	 * @param id
	 * @return
	 */
	public Businessruletable getRuleById(int id)
	{
		return cd.getObjectById(Businessruletable.class,id);
	}

}
