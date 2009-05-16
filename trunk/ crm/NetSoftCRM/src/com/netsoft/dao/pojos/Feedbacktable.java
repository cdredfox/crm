package com.netsoft.dao.pojos;

import java.util.Date;

public class Feedbacktable implements java.io.Serializable {

	public Integer id;
	public Customerstable feedbackcustomer;
	public Configuretable feedbacktype;
	public Date feedbackdate;
	public String feedbackmessage;
	public Employye feedbackeid;
	public Feedbacktable() {
	}
	public Feedbacktable(Integer id, Customerstable feedbackcustomer,
			Configuretable feedbacktype, Date feedbackdate,
			String feedbackmessage, Employye feedbackeid) {
		this.id = id;
		this.feedbackcustomer = feedbackcustomer;
		this.feedbacktype = feedbacktype;
		this.feedbackdate = feedbackdate;
		this.feedbackmessage = feedbackmessage;
		this.feedbackeid = feedbackeid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customerstable getFeedbackcustomer() {
		return feedbackcustomer;
	}
	public void setFeedbackcustomer(Customerstable feedbackcustomer) {
		this.feedbackcustomer = feedbackcustomer;
	}
	public Configuretable getFeedbacktype() {
		return feedbacktype;
	}
	public void setFeedbacktype(Configuretable feedbacktype) {
		this.feedbacktype = feedbacktype;
	}
	public Date getFeedbackdate() {
		return feedbackdate;
	}
	public void setFeedbackdate(Date feedbackdate) {
		this.feedbackdate = feedbackdate;
	}
	public String getFeedbackmessage() {
		return feedbackmessage;
	}
	public void setFeedbackmessage(String feedbackmessage) {
		this.feedbackmessage = feedbackmessage;
	}
	public Employye getFeedbackeid() {
		return feedbackeid;
	}
	public void setFeedbackeid(Employye feedbackeid) {
		this.feedbackeid = feedbackeid;
	}

}
