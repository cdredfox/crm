package com.netsoft.dao.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.netsoft.dao.pojos.Depts;

public class EmployeeBean {
	private Integer id;
	private Integer depts;
	private String deptsName;
	private String eaccount;
	private String ename;
	private String epwd;
	private Integer login;
	private Integer roleid;
	private String rolename;
	private Set emidrs = new HashSet(0);

	/**
	 * �Ƿ���Ȩ�޽��пͻ������ƺ͹̶��绰�޸�
	 */
	private String roleflag;
	/**
	 * �Ƿ���Ȩ�޶Գ����ͻ����г���ɾ������
	 */
	private String delFlag;
	/**
	 * �Ƿ���bbs����Ȩ��
	 */
	private String bbsFlag;

	/**
	 * �Ƿ���Ȩ�޲鿴ȫ�������ͻ�������Ϣ
	 */
	private String viewFlag;
	/**
	 * �Ƿ���Ȩ��ɾ���ͻ�������Ϣ
	 */
	private String delFeedBackFlag;

	public Integer getDepts() {
		return depts;
	}

	public void setDepts(Integer depts) {
		this.depts = depts;
	}

	public String getEaccount() {
		return eaccount;
	}

	public void setEaccount(String eaccount) {
		this.eaccount = eaccount;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpwd() {
		return epwd;
	}

	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptsName() {
		return deptsName;
	}

	public void setDeptsName(String deptsName) {
		this.deptsName = deptsName;
	}

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	public Set getEmidrs() {
		return emidrs;
	}

	public void setEmidrs(Set emidrs) {
		this.emidrs = emidrs;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoleflag() {
		return roleflag;
	}

	public void setRoleflag(String roleflag) {
		this.roleflag = roleflag;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getBbsFlag() {
		return bbsFlag;
	}

	public void setBbsFlag(String bbsFlag) {
		this.bbsFlag = bbsFlag;
	}

	public String getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}

	public String getDelFeedBackFlag() {
		return delFeedBackFlag;
	}

	public void setDelFeedBackFlag(String delFeedBackFlag) {
		this.delFeedBackFlag = delFeedBackFlag;
	}
}
