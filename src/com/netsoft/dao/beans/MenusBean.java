package com.netsoft.dao.beans;

public class MenusBean {
	private Integer id;
    private String mname;
    private String murl;
    private Integer mtopId;
    private String mmessage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMmessage() {
		return mmessage;
	}
	public void setMmessage(String mmessage) {
		this.mmessage = mmessage;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getMtopId() {
		return mtopId;
	}
	public void setMtopId(Integer mtopId) {
		this.mtopId = mtopId;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
}
