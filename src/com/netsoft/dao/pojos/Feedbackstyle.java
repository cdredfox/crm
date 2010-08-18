package com.netsoft.dao.pojos;

/**
 * Feedbackstyle entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Feedbackstyle implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer fid;
	private String style;

	// Constructors

	/** default constructor */
	public Feedbackstyle() {
	}

	/** full constructor */
	public Feedbackstyle(Integer fid, String style) {
		this.fid = fid;
		this.style = style;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}