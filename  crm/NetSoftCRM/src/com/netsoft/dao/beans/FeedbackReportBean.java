package com.netsoft.dao.beans;

import java.util.List;

public class FeedbackReportBean {
	
	public String ename;
	public String feedbacktype;
	public String feedbacknum;
	public List feedsubbean;
	public int count;
	public Integer lastfeedbacktype;
	public Integer customerid;
	/**
	 * �Ƿ���ɫ��ʾ
	 */
	public int iscolor;
	/**
	 * ��������칫��
	 */
	public String openDate;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getFeedbacktype() {
		return feedbacktype;
	}

	public void setFeedbacktype(String feedbacktype) {
		this.feedbacktype = feedbacktype;
	}

	public String getFeedbacknum() {
		return feedbacknum;
	}

	public void setFeedbacknum(String feedbacknum) {
		this.feedbacknum = feedbacknum;
	}

	public List getFeedsubbean() {
		return feedsubbean;
	}

	public void setFeedsubbean(List feedsubbean) {
		this.feedsubbean = feedsubbean;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getLastfeedbacktype() {
		return lastfeedbacktype;
	}

	public void setLastfeedbacktype(Integer lastfeedbacktype) {
		this.lastfeedbacktype = lastfeedbacktype;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public int getIscolor() {
		return iscolor;
	}

	public void setIscolor(int iscolor) {
		this.iscolor = iscolor;
	}

}
