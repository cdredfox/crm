package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IFeedbackStyleDao;
import com.netsoft.dao.pojos.Feedbackstyle;

public class FeedbackStyleDao implements IFeedbackStyleDao {

	public ICommonDao icd;

	public Feedbackstyle addFeedbackStyle(Feedbackstyle feedbackstyle) {
		icd.add(feedbackstyle);
		return null;
	}

	public boolean delFeedbackStyle(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Feedbackstyle getFeedbackStyle(Integer id) {
		return icd.getObjectById(Feedbackstyle.class, id);
	}

	public boolean modiFeedbackStyle(Feedbackstyle feedbackstyle) {
		return icd.updateObject(feedbackstyle);
	}

	public List<Feedbackstyle> qryFeedbackStyleList() {
		return icd.getObjectAll(Feedbackstyle.class);
	}

	public ICommonDao getIcd() {
		return icd;
	}

	public void setIcd(ICommonDao icd) {
		this.icd = icd;
	}

	public Feedbackstyle qryFeedbackStyleByFid(Integer fid) {
		String hql = "from Feedbackstyle where fid=:fid";
		HashMap hm = new HashMap();
		hm.put("fid", fid);
		List list = icd.getObjectByHql(hql, hm);
		if (list.size() > 0) {
			return (Feedbackstyle) list.get(0);
		}
		return null;
	}

}
