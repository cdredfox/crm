package com.netsoft.dao.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rname;
	private String rmessage;
	private Set emidrs = new HashSet(0);
	private Set rmidptables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** full constructor */
	public Roles(String rname, String rmessage, Set emidrs, Set rmidptables) {
		this.rname = rname;
		this.rmessage = rmessage;
		this.emidrs = emidrs;
		this.rmidptables = rmidptables;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRmessage() {
		return this.rmessage;
	}

	public void setRmessage(String rmessage) {
		this.rmessage = rmessage;
	}

	public Set getEmidrs() {
		return this.emidrs;
	}

	public void setEmidrs(Set emidrs) {
		this.emidrs = emidrs;
	}

	public Set getRmidptables() {
		return this.rmidptables;
	}

	public void setRmidptables(Set rmidptables) {
		this.rmidptables = rmidptables;
	}

}