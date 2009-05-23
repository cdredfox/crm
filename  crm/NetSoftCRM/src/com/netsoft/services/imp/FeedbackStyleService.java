package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.FeedbackStyleBean;
import com.netsoft.dao.intf.IConfiguretableDao;
import com.netsoft.dao.intf.IFeedbackStyleDao;
import com.netsoft.dao.pojos.Configuretable;
import com.netsoft.dao.pojos.Feedbackstyle;
import com.netsoft.services.intf.IFeedbackStyleService;

public class FeedbackStyleService implements IFeedbackStyleService {

	public IFeedbackStyleDao ifsd;
	public IConfiguretableDao icd;

	public List<FeedbackStyleBean> qryFeedbackStyleService() {
		List<Feedbackstyle> list = ifsd.qryFeedbackStyleList();
		List result = new ArrayList();
		FeedbackStyleBean fbsb = null;
		for (Feedbackstyle feedbackstyle : list) {
			fbsb = new FeedbackStyleBean();
			BeanUtils.copyProperties(feedbackstyle, fbsb);
			Configuretable feedbackName = icd.getConfigByid(feedbackstyle
					.getFid().intValue());
			fbsb.setFeedbackName(feedbackName.getConfignote());
		}
		return result;
	}

	public IFeedbackStyleDao getIfsd() {
		return ifsd;
	}

	public void setIfsd(IFeedbackStyleDao ifsd) {
		this.ifsd = ifsd;
	}

	public IConfiguretableDao getIcd() {
		return icd;
	}

	public void setIcd(IConfiguretableDao icd) {
		this.icd = icd;
	}

	public String qryFeedbackStyleByFid(Integer fid) {
		Feedbackstyle style = ifsd.qryFeedbackStyleByFid(fid);
		if (style == null) {
			return "";
		}
		return style.getId() + "@@@" + style.getStyle();
	}

	public Feedbackstyle saveFeedbackStyle(FeedbackStyleBean fbsb) {
		Feedbackstyle feedbackstyle = null;
		if (fbsb.getId() == null || fbsb.getId() == 0) {
			feedbackstyle = new Feedbackstyle();
			feedbackstyle.setFid(fbsb.getFid());
			feedbackstyle.setStyle(fbsb.getStyle());
			ifsd.addFeedbackStyle(feedbackstyle);
		} else {
			feedbackstyle = ifsd.getFeedbackStyle(fbsb.getId());;
			feedbackstyle.setStyle(fbsb.getStyle()==null?"":fbsb.getStyle());
			ifsd.modiFeedbackStyle(feedbackstyle);
		}
		return null;
	}

}
