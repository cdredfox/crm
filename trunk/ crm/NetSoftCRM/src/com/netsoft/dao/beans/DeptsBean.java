package com.netsoft.dao.beans;

import com.netsoft.dao.pojos.Employye;

public class DeptsBean {
	 private Integer id;
     private Integer employye;
     private String dname;
     private String employyeName;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getEmployye() {
		return employye;
	}
	public void setEmployye(Integer employye) {
		this.employye = employye;
	}
	public String getEmployyeName() {
		return employyeName;
	}
	public void setEmployyeName(String employyeName) {
		this.employyeName = employyeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
