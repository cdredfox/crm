package com.netsoft.dao.beans;

import java.util.Date;

import com.netsoft.dao.pojos.Configuretable;
import com.netsoft.dao.pojos.Customerstable;
import com.netsoft.dao.pojos.Employye;

public class FeedbacktableBean {
	public Integer id;
	public Customerstable feedbackcustomer;
	public Configuretable feedbacktype;
	public Date feedbackdate;
	public String feedbackmessage;
	public Employye feedbackeid;
	public String ename;
	public Integer feedbackcustomerid;
	public Integer feedbacktypeid;
	public Integer feedbackemployye;
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
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getFeedbackcustomerid() {
		return feedbackcustomerid;
	}
	public void setFeedbackcustomerid(Integer feedbackcustomerid) {
		this.feedbackcustomerid = feedbackcustomerid;
	}
	public Integer getFeedbacktypeid() {
		return feedbacktypeid;
	}
	public void setFeedbacktypeid(Integer feedbacktypeid) {
		this.feedbacktypeid = feedbacktypeid;
	}
	public Integer getFeedbackemployye() {
		return feedbackemployye;
	}
	public void setFeedbackemployye(Integer feedbackemployye) {
		this.feedbackemployye = feedbackemployye;
	}

}
