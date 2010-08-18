package com.netsoft.dao.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * Menus entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Menus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mname;
	private String murl;
	private Integer mtopId;
	private String mmessage;
	private Set rmidptables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menus() {
	}

	/** full constructor */
	public Menus(String mname, String murl, Integer mtopId, String mmessage,
			Set rmidptables) {
		this.mname = mname;
		this.murl = murl;
		this.mtopId = mtopId;
		this.mmessage = mmessage;
		this.rmidptables = rmidptables;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMurl() {
		return this.murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public Integer getMtopId() {
		return this.mtopId;
	}

	public void setMtopId(Integer mtopId) {
		this.mtopId = mtopId;
	}

	public String getMmessage() {
		return this.mmessage;
	}

	public void setMmessage(String mmessage) {
		this.mmessage = mmessage;
	}

	public Set getRmidptables() {
		return this.rmidptables;
	}

	public void setRmidptables(Set rmidptables) {
		this.rmidptables = rmidptables;
	}

}