package com.netsoft.web.struts.form;

import org.apache.struts.action.ActionForm;

public class FeedBackTableForm extends ActionForm {
	
	public Integer feedbackcustomer;
	public Integer feedbacktype;
	public String feedbackdate;
	public String feedbackmessage;
	public Integer feedbackeid;
	public String feedbackoutdate;
	public Double feedbackprice;
	public String feedbacknextdate;
	public Integer getFeedbackcustomer() {
		return feedbackcustomer;
	}
	public void setFeedbackcustomer(Integer feedbackcustomer) {
		this.feedbackcustomer = feedbackcustomer;
	}
	public Integer getFeedbacktype() {
		return feedbacktype;
	}
	public void setFeedbacktype(Integer feedbacktype) {
		this.feedbacktype = feedbacktype;
	}
	public String getFeedbackdate() {
		return feedbackdate;
	}
	public void setFeedbackdate(String feedbackdate) {
		this.feedbackdate = feedbackdate;
	}
	public String getFeedbackmessage() {
		return feedbackmessage;
	}
	public void setFeedbackmessage(String feedbackmessage) {
		this.feedbackmessage = feedbackmessage;
	}
	public Integer getFeedbackeid() {
		return feedbackeid;
	}
	public void setFeedbackeid(Integer feedbackeid) {
		this.feedbackeid = feedbackeid;
	}
	public String getFeedbackoutdate() {
		return feedbackoutdate;
	}
	public void setFeedbackoutdate(String feedbackoutdate) {
		this.feedbackoutdate = feedbackoutdate;
	}
	public Double getFeedbackprice() {
		return feedbackprice;
	}
	public void setFeedbackprice(Double feedbackprice) {
		this.feedbackprice = feedbackprice;
	}
	public String getFeedbacknextdate() {
		return feedbacknextdate;
	}
	public void setFeedbacknextdate(String feedbacknextdate) {
		this.feedbacknextdate = feedbacknextdate;
	}
	

}
