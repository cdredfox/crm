package com.netsoft.dao.beans;

import java.util.HashSet;
import java.util.Set;

public class RolesBean {
	
    private Integer id;
    private String rname;
    private Integer rdelStyle;
    private String rmessage;
    private Integer[] allMenus;
    private Set emidrs = new HashSet(0);
    private Set rmidptables = new HashSet(0);
	public Set getEmidrs() {
		return emidrs;
	}
	public void setEmidrs(Set emidrs) {
		this.emidrs = emidrs;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRdelStyle() {
		return rdelStyle;
	}
	public void setRdelStyle(Integer rdelStyle) {
		this.rdelStyle = rdelStyle;
	}
	public String getRmessage() {
		return rmessage;
	}
	public void setRmessage(String rmessage) {
		this.rmessage = rmessage;
	}
	public Set getRmidptables() {
		return rmidptables;
	}
	public void setRmidptables(Set rmidptables) {
		this.rmidptables = rmidptables;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Integer[] getAllMenus() {
		return allMenus;
	}
	public void setAllMenus(Integer[] allMenus) {
		this.allMenus = allMenus;
	}

}
