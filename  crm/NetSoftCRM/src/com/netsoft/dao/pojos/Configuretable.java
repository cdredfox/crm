package com.netsoft.dao.pojos;

/**
 * Configuretable entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Configuretable implements java.io.Serializable {

	// Fields

	private Integer configid;
	private String configvalue;
	private String configtype;
	private String confignote;
	private String configmessage;
	private Integer configtopid;

	// Constructors

	/** default constructor */
	public Configuretable() {
	}

	/** full constructor */
	public Configuretable(String configvalue, String configtype,
			String confignote,String configmessage) {
		this.configvalue = configvalue;
		this.configtype = configtype;
		this.confignote = confignote;
		this.configmessage=configmessage;
	}

	// Property accessors

	public Integer getConfigid() {
		return this.configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public String getConfigvalue() {
		return this.configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getConfigtype() {
		return this.configtype;
	}

	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	public String getConfignote() {
		return this.confignote;
	}

	public void setConfignote(String confignote) {
		this.confignote = confignote;
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