package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IFeedbacktypeDao;
import com.netsoft.dao.pojos.Feedbacktable;

public class FeedbacktypeDao implements IFeedbacktypeDao {
	private static Logger log=Logger.getLogger(FeedbacktypeDao.class);
	public ICommonDao icd;

	public List<Feedbacktable> getFeedbackByWhere(String hql, HashMap hm,int page,int size) {
		try {
			return icd.currenPage(page, size, hql, hm);
		} catch (Exception e) {
			log.error("FeedbacktypeDao.getFeedbackByWhere出错了!",e);
			return null;
		}
		
	}

	public ICommonDao getIcd() {
		return icd;
	}

	public void setIcd(ICommonDao icd) {
		this.icd = icd;
	}

	public Feedbacktable getFeedbackByid(int id) {
		return icd.getObjectById(Feedbacktable.class,id);
	}

	public boolean addFeedbackTable(Feedbacktable fb) {
		icd.add(fb);
		return true;
	}

	public boolean delFeekback(int id) {
		return icd.dele(Feedbacktable.class, id);
	}

}
