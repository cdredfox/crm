package com.netsoft.web.struts.form;

import org.apache.struts.action.ActionForm;

public class feedbackstyleForm extends ActionForm {
	private Integer id;
	private Integer fid;
	private String style;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}

}
