package com.netsoft.dao.pojos;

import java.util.Date;
import java.util.Set;

/**
 * Customerstable entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Customerstable implements java.io.Serializable {

	// Fields

	private Integer customerid;
	private Employye employye;
	private String customercompany;
	private String customerphone;
	private String customername;
	private String customerfax;
	private Double customerprice;
	private Date customeroutdate;
	private String customerfeedback;
	private String customeraddress;
	private Date customeradddate;
	private Date customernextdate;
	private Integer cutomergrade;
	private Integer customerproperty;
	private Integer customersource;
	private Integer customerfeedbacktype;
	private Integer customerowenerxz;
	private String customerhandset;
	private Date customerfeedbackdate;
	private Set feedbacktables;
	private Employye addemployye;//锟酵伙拷录锟斤拷锟斤拷
	private Configuretable customerprovince;
	private Configuretable customercity;
	

	// Constructors

	public Configuretable getCustomerprovince() {
		return customerprovince;
	}

	public void setCustomerprovince(Configuretable customerprovince) {
		this.customerprovince = customerprovince;
	}

	public Configuretable getCustomercity() {
		return customercity;
	}

	public void setCustomercity(Configuretable customercity) {
		this.customercity = customercity;
	}

	/** default constructor */
	public Customerstable() {
	}

	/** full constructor */
	public Customerstable(Employye employye, String customercompany,
			String customerphone, String customername, String customerfax,
			Double customerprice, Date customeroutdate, String customerfeedback,
			String customeraddress, Date customeradddate,
			Date customernextdate, Integer cutomergrade,
			Integer customerproperty, Integer customersource,
			Integer customerfeedbacktype,String customerhandset,Integer customerowenerxz,Date customerfeedbackdate,Employye addemployye) {
		this.employye = employye;
		this.customercompany = customercompany;
		this.customerphone = customerphone;
		this.customername = customername;
		this.customerfax = customerfax;
		this.customerprice = customerprice;
		this.customeroutdate = customeroutdate;
		this.customerfeedback = customerfeedback;
		this.customeraddress = customeraddress;
		this.customeradddate = customeradddate;
		this.customernextdate = customernextdate;
		this.cutomergrade = cutomergrade;
		this.customerproperty = customerproperty;
		this.customersource = customersource;
		this.customerfeedbacktype = customerfeedbacktype;
		this.customerhandset=customerhandset;
		this.customerowenerxz=customerowenerxz;
		this.customerfeedbackdate=customerfeedbackdate;
		this.addemployye=addemployye;
	}

	// Property accessors

	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Employye getEmployye() {
		return this.employye;
	}

	public void setEmployye(Employye employye) {
		this.employye = employye;
	}

	public String getCustomercompany() {
		return this.customercompany;
	}

	public void setCustomercompany(String customercompany) {
		this.customercompany = customercompany;
	}

	public String getCustomerphone() {
		return this.customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerfax() {
		return this.customerfax;
	}

	public void setCustomerfax(String customerfax) {
		this.customerfax = customerfax;
	}

	public Double getCustomerprice() {
		return this.customerprice;
	}

	public void setCustomerprice(Double customerprice) {
		this.customerprice = customerprice;
	}

	public Date getCustomeroutdate() {
		return this.customeroutdate;
	}

	public void setCustomeroutdate(Date customeroutdate) {
		this.customeroutdate = customeroutdate;
	}

	public String getCustomerfeedback() {
		return this.customerfeedback;
	}

	public void setCustomerfeedback(String customerfeedback) {
		this.customerfeedback = customerfeedback;
	}

	public String getCustomeraddress() {
		return this.customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public Date getCustomeradddate() {
		return this.customeradddate;
	}

	public void setCustomeradddate(Date customeradddate) {
		this.customeradddate = customeradddate;
	}

	public Date getCustomernextdate() {
		return this.customernextdate;
	}

	public void setCustomernextdate(Date customernextdate) {
		this.customernextdate = customernextdate;
	}

	public Integer getCutomergrade() {
		return this.cutomergrade;
	}

	public void setCutomergrade(Integer cutomergrade) {
		this.cutomergrade = cutomergrade;
	}

	public Integer getCustomerproperty() {
		return this.customerproperty;
	}

	public void setCustomerproperty(Integer customerproperty) {
		this.customerproperty = customerproperty;
	}

	public Integer getCustomersource() {
		return this.customersource;
	}

	public void setCustomersource(Integer customersource) {
		this.customersource = customersource;
	}

	public Integer getCustomerfeedbacktype() {
		return this.customerfeedbacktype;
	}

	public void setCustomerfeedbacktype(Integer customerfeedbacktype) {
		this.customerfeedbacktype = customerfeedbacktype;
	}

	public String getCustomerhandset() {
		return customerhandset;
	}

	public void setCustomerhandset(String customerhandset) {
		this.customerhandset = customerhandset;
	}

	public Integer getCustomerowenerxz() {
		return customerowenerxz;
	}

	public void setCustomerowenerxz(Integer customerowenerxz) {
		this.customerowenerxz = customerowenerxz;
	}

	public Date getCustomerfeedbackdate() {
		return customerfeedbackdate;
	}

	public void setCustomerfeedbackdate(Date customerfeedbackdate) {
		this.customerfeedbackdate = customerfeedbackdate;
	}

	public Set getFeedbacktables() {
		return feedbacktables;
	}

	public void setFeedbacktables(Set feedbacktables) {
		this.feedbacktables = feedbacktables;
	}

	public Employye getAddemployye() {
		return addemployye;
	}

	public void setAddemployye(Employye addemployye) {
		this.addemployye = addemployye;
	}

}