package com.netsoft.web.struts.form;

import org.apache.struts.action.ActionForm;

public class BusinessruletableForm extends ActionForm {
	private Integer ruleid;
	private String rulecode;
	private String rulevalue;
	private String rulenote;
	public Integer getRuleid() {
		return ruleid;
	}
	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}
	public String getRulecode() {
		return rulecode;
	}
	public void setRulecode(String rulecode) {
		this.rulecode = rulecode;
	}
	public String getRulevalue() {
		return rulevalue;
	}
	public void setRulevalue(String rulevalue) {
		this.rulevalue = rulevalue;
	}
	public String getRulenote() {
		return rulenote;
	}
	public void setRulenote(String rulenote) {
		this.rulenote = rulenote;
	}

}
