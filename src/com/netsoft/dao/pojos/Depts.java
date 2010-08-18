package com.netsoft.dao.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * Depts entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Depts implements java.io.Serializable {

	// Fields

	private Integer id;
	private Employye employye;
	private String dname;
	private Integer topDeptId;
	private Set employyes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Depts() {
	}

	/** full constructor */
	public Depts(Employye employye, String dname, Integer topDeptId,
			Set employyes) {
		this.employye = employye;
		this.dname = dname;
		this.topDeptId = topDeptId;
		this.employyes = employyes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employye getEmployye() {
		return this.employye;
	}

	public void setEmployye(Employye employye) {
		this.employye = employye;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getTopDeptId() {
		return this.topDeptId;
	}

	public void setTopDeptId(Integer topDeptId) {
		this.topDeptId = topDeptId;
	}

	public Set getEmployyes() {
		return this.employyes;
	}

	public void setEmployyes(Set employyes) {
		this.employyes = employyes;
	}

}