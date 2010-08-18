package com.netsoft.dao.pojos;

/**
 * Emidr entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Emidr implements java.io.Serializable {

	// Fields

	private Integer id;
	private Roles roles;
	private Employye employye;

	// Constructors

	/** default constructor */
	public Emidr() {
	}

	/** full constructor */
	public Emidr(Roles roles, Employye employye) {
		this.roles = roles;
		this.employye = employye;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Employye getEmployye() {
		return this.employye;
	}

	public void setEmployye(Employye employye) {
		this.employye = employye;
	}

}