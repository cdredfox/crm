package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.FeedbackStyleBean;
import com.netsoft.dao.pojos.Feedbackstyle;

public interface IFeedbackStyleService {
	public List<FeedbackStyleBean> qryFeedbackStyleService();
	public String qryFeedbackStyleByFid(Integer fid);
	public Feedbackstyle saveFeedbackStyle(FeedbackStyleBean feedbackstyle);
}
