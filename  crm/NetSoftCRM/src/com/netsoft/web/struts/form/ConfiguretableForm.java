package com.netsoft.web.struts.form;

import org.apache.struts.action.ActionForm;

public class ConfiguretableForm extends ActionForm {
	private Integer configid;
	private String configvalue;
	private String configtype;
	private String confignote;
	private String configtypename;
	private String configmessage;
	private Integer configtopid;

	public Integer getConfigid() {
		return configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public String getConfigvalue() {
		return configvalue;
	}

	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}

	public String getConfigtype() {
		return configtype;
	}

	public void setConfigtype(String configtype) {
		this.configtype = configtype;
	}

	public String getConfignote() {
		return confignote;
	}

	public void setConfignote(String confignote) {
		this.confignote = confignote;
	}

	public String getConfigtypename() {
		if ("dj".equals(this.getConfigtype())) {
			return "�ͻ��ȼ�����";
		}
		if ("dz".equals(this.getConfigtype())) {
			return "�ͻ���ַ����";
		}
		if ("fk".equals(this.getConfigtype())) {
			return "�ͻ���������";
		}
		if ("ly".equals(this.getConfigtype())) {
			return "�ͻ���Դ����";
		}
		if ("qh".equals(this.getConfigtype())) {
			return "�ͻ��绰��������";
		}
		if ("xz".equals(this.getConfigtype())) {
			return "�ͻ���˾����";
		}
		if ("syzxz".equals(this.getConfigtype())) {
			return "�ͻ���˾����������";
		}
		return "�Ƿ�����";
	}

	public void setConfigtypename(String configtypename) {
		this.configtypename = configtypename;
	}

	public String getConfigmessage() {
		return configmessage;
	}

	public void setConfigmessage(String configmessage) {
		this.configmessage = configmessage;
	}

	public Integer getConfigtopid() {
		return configtopid;
	}

	public void setConfigtopid(Integer configtopid) {
		this.configtopid = configtopid;
	}
}
