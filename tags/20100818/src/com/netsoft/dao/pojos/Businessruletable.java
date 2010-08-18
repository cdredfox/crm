package com.netsoft.dao.pojos;

/**
 * Businessruletable entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Businessruletable implements java.io.Serializable {

	// Fields

	private Integer ruleid;
	private String rulecode;
	private String rulevalue;
	private String rulenote;

	// Constructors

	/** default constructor */
	public Businessruletable() {
	}

	/** full constructor */
	public Businessruletable(String rulecode, String rulevalue, String rulenote) {
		this.rulecode = rulecode;
		this.rulevalue = rulevalue;
		this.rulenote = rulenote;
	}

	// Property accessors

	public Integer getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}

	public String getRulecode() {
		return this.rulecode;
	}

	public void setRulecode(String rulecode) {
		this.rulecode = rulecode;
	}

	public String getRulevalue() {
		return this.rulevalue;
	}

	public void setRulevalue(String rulevalue) {
		this.rulevalue = rulevalue;
	}

	public String getRulenote() {
		return this.rulenote;
	}

	public void setRulenote(String rulenote) {
		this.rulenote = rulenote;
	}

}