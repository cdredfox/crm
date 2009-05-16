package com.netsoft.dao.intf;

import java.util.List;

import com.netsoft.dao.pojos.Feedbackstyle;

public interface IFeedbackStyleDao {
	public Feedbackstyle getFeedbackStyle(Integer id);
	public Feedbackstyle addFeedbackStyle(Feedbackstyle feedbackstyle);
	public boolean delFeedbackStyle(Integer id);
	public boolean modiFeedbackStyle(Feedbackstyle feedbackstyle);
	public List<Feedbackstyle> qryFeedbackStyleList();
	public Feedbackstyle qryFeedbackStyleByFid(Integer fid);
}
