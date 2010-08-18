package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.BusinessruletableBean;
import com.netsoft.dao.intf.IBusinessruletableDao;
import com.netsoft.dao.pojos.Businessruletable;
import com.netsoft.services.intf.IBusinessruletableServices;

public class BusinessruletableServices implements IBusinessruletableServices {

	private IBusinessruletableDao ibrtd;
	public List<BusinessruletableBean> getAllRule() {
		List<Businessruletable> list=ibrtd.getAllRule();
		BusinessruletableBean bb;
		List<BusinessruletableBean> slist=new ArrayList<BusinessruletableBean>();
		for (Businessruletable businessruletable : list) {
			bb=new BusinessruletableBean();
			BeanUtils.copyProperties(businessruletable, bb);
			slist.add(bb);
		}
		
		return slist;
	}

	public void updateRule(BusinessruletableBean brb) {
		Businessruletable btb=new Businessruletable();
		BeanUtils.copyProperties(brb, btb);
		ibrtd.updateRule(btb);
	}

	/**
	 * 根据ID查找某个规则对象
	 * @param id
	 * @return
	 */
	public BusinessruletableBean getRuleById(int id)
	{
		BusinessruletableBean bb=new BusinessruletableBean();
		Businessruletable bt=ibrtd.getRuleById(id);
		BeanUtils.copyProperties(bt, bb);
		return bb;
	}
	public IBusinessruletableDao getIbrtd() {
		return ibrtd;
	}

	public void setIbrtd(IBusinessruletableDao ibrtd) {
		this.ibrtd = ibrtd;
	}

}
