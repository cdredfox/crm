package com.netsoft.dao.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * Employye entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Employye implements java.io.Serializable {

	// Fields

	private Integer id;
	private Depts depts;
	private String eaccount;
	private String ename;
	private String epwd;
	private Set deptses = new HashSet(0);
	private Set emidrs = new HashSet(0);
	private Set customerstables = new HashSet(0);
	private Set feedbackstables=new HashSet(0);
	private Set notebooks=new HashSet(0);

	// Constructors

	public Set getFeedbackstables() {
		return feedbackstables;
	}

	public void setFeedbackstables(Set feedbackstables) {
		this.feedbackstables = feedbackstables;
	}

	/** default constructor */
	public Employye() {
	}

	/** full constructor */
	public Employye(Depts depts, String eaccount, String ename, String epwd,
			Set deptses, Set emidrs, Set customerstables,Set notebooks) {
		this.depts = depts;
		this.eaccount = eaccount;
		this.ename = ename;
		this.epwd = epwd;
		this.deptses = deptses;
		this.emidrs = emidrs;
		this.customerstables = customerstables;
		this.notebooks=notebooks;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Depts getDepts() {
		return this.depts;
	}

	public void setDepts(Depts depts) {
		this.depts = depts;
	}

	public String getEaccount() {
		return this.eaccount;
	}

	public void setEaccount(String eaccount) {
		this.eaccount = eaccount;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpwd() {
		return this.epwd;
	}

	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}

	public Set getDeptses() {
		return this.deptses;
	}

	public void setDeptses(Set deptses) {
		this.deptses = deptses;
	}

	public Set getEmidrs() {
		return this.emidrs;
	}

	public void setEmidrs(Set emidrs) {
		this.emidrs = emidrs;
	}

	public Set getCustomerstables() {
		return this.customerstables;
	}

	public void setCustomerstables(Set customerstables) {
		this.customerstables = customerstables;
	}

	public Set getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(Set notebooks) {
		this.notebooks = notebooks;
	}

}