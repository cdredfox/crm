package com.netsoft.dao.pojos;

/**
 * Rmidptable entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Rmidptable implements java.io.Serializable {

	// Fields

	private Integer id;
	private Roles roles;
	private Menus menus;

	// Constructors

	/** default constructor */
	public Rmidptable() {
	}

	/** full constructor */
	public Rmidptable(Roles roles, Menus menus) {
		this.roles = roles;
		this.menus = menus;
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

	public Menus getMenus() {
		return this.menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

}