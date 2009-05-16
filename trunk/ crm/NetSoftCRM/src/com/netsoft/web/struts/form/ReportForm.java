package com.netsoft.web.struts.form;


import java.util.Date;

import org.apache.struts.action.ActionForm;

public class ReportForm extends ActionForm {
	public String startdate;
	public String enddate;
	public String type;
	public String qrydz;
	public String companyName;
	public String eid;
	public String qryxz;
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQrydz() {
		return qrydz;
	}
	public void setQrydz(String qrydz) {
		this.qrydz = qrydz;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getQryxz() {
		return qryxz;
	}
	public void setQryxz(String qryxz) {
		this.qryxz = qryxz;
	}

}
