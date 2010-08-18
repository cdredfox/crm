package com.netsoft.dao.beans;

public class ConfiguretableBean {
	private Integer configid;
	private String configvalue;
	private String configtype;
	private String confignote;
	private String configmessage;
	private Integer configtopid;

	public Integer getConfigid() {
		return configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public String getConfigvalue() {
		return configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getConfigtype() {
		return configtype;
	}

	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	public String getConfignote() {
		return confignote;
	}

	public void setConfignote(String confignote) {
		this.confignote = confignote;
	}

	public String getConfigtypename() {
		if ("dj".equals(this.getConfigtype())) {
			return "客户等级配置";
		}
		if ("dz".equals(this.getConfigtype())) {
			return "客户地址配置";
		}
		if ("fk".equals(this.getConfigtype())) {
			return "客户反馈配置";
		}
		if ("ly".equals(this.getConfigtype())) {
			return "客户来源配置";
		}
		if ("qh".equals(this.getConfigtype())) {
			return "客户电话区号配置";
		}
		if ("xz".equals(this.getConfigtype())) {
			return "客户公司性质";
		}
		if ("syzxz".equals(this.getConfigtype())) {
			return "客户公司所有制类型";
		}
		return "非法类型";
	}

	public void setConfigtypename(String configtypename) {
	}

	public String getConfigmessage() {
		return configmessage;
	}

	public void setConfigmessage(String configmessage) {
		this.configmessage = configmessage;
	}

	public Integer getConfigtopid() {
		return configtopid;
	}

	public void setConfigtopid(Integer configtopid) {
		this.configtopid = configtopid;
	}

}
