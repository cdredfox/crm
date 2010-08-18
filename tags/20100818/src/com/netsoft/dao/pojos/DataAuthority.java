package com.netsoft.dao.pojos;

public class DataAuthority implements java.io.Serializable{
	public DataAuthority() {
		
	}
	private Integer id;
	private Employye eid;
	public Integer getId() {
		return id;
	}
	public DataAuthority(Integer id, Employye eid, Employye topid) {
		super();
		this.id = id;
		this.eid = eid;
		this.topid = topid;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Employye getEid() {
		return eid;
	}
	public void setEid(Employye eid) {
		this.eid = eid;
	}
	public Employye getTopid() {
		return topid;
	}
	public void setTopid(Employye topid) {
		this.topid = topid;
	}
	private Employye topid;
}
