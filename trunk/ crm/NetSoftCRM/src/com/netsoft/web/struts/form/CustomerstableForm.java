package com.netsoft.web.struts.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.netsoft.dao.pojos.Employye;

public class CustomerstableForm extends ActionForm {
	private Integer customerid;
	private Employye employye;
	private String customercompany;
	private String customerarea;
	private String customerphone;
	public String getCustomerarea() {
		return customerarea;
	}
	public void setCustomerarea(String customerarea) {
		this.customerarea = customerarea;
	}
	private String customername;
	private String customerfax;
	private String customerfaxarea;
	private Double customerprice;
	public String getCustomerfaxarea() {
		return customerfaxarea;
	}
	public void setCustomerfaxarea(String customerfaxarea) {
		this.customerfaxarea = customerfaxarea;
	}
	private Date customeroutdate;
	private String customerfeedback;
	private String customeraddress;
	private Date customeradddate;
	private Date customernextdate;
	private Integer cutomergrade;
	private Integer customerproperty;
	private Integer customersource;
	private Integer customerfeedbacktype;
	private String customerhandset;
	private String phone;
	private String phonetype;
	private int eid;
	private String customertype;
	private Integer customerowenerxz;
	private Date customerfeedbackdate;
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public Employye getEmployye() {
		return employye;
	}
	public void setEmployye(Employye employye) {
		this.employye = employye;
	}
	public String getCustomercompany() {
		return customercompany;
	}
	public void setCustomercompany(String customercompany) {
		this.customercompany = customercompany;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		if("2".equals(this.getPhonetype()))
		{
			this.customerphone=this.getPhone();
		}else
		{
			this.customerphone = customerphone;
		}
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerfax() {
		return customerfax;
	}
	public void setCustomerfax(String customerfax) {
		this.customerfax = customerfax;
	}
	public Double getCustomerprice() {
		return customerprice;
	}
	public void setCustomerprice(Double customerprice) {
		this.customerprice = customerprice;
	}
	public Date getCustomeroutdate() {
		return customeroutdate;
	}
	public void setCustomeroutdate(Date customeroutdate) {
		this.customeroutdate = customeroutdate;
	}
	public String getCustomerfeedback() {
		return customerfeedback;
	}
	public void setCustomerfeedback(String customerfeedback) {
		this.customerfeedback = customerfeedback;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public Date getCustomeradddate() {
		return customeradddate;
	}
	public void setCustomeradddate(Date customeradddate) {
		this.customeradddate = customeradddate;
	}
	public Date getCustomernextdate() {
		return customernextdate;
	}
	public void setCustomernextdate(Date customernextdate) {
		this.customernextdate = customernextdate;
	}
	public Integer getCutomergrade() {
		return cutomergrade;
	}
	public void setCutomergrade(Integer cutomergrade) {
		this.cutomergrade = cutomergrade;
	}
	public Integer getCustomerproperty() {
		return customerproperty;
	}
	public void setCustomerproperty(Integer customerproperty) {
		this.customerproperty = customerproperty;
	}
	public Integer getCustomersource() {
		return customersource;
	}
	public void setCustomersource(Integer customersource) {
		this.customersource = customersource;
	}
	public Integer getCustomerfeedbacktype() {
		return customerfeedbacktype;
	}
	public void setCustomerfeedbacktype(Integer customerfeedbacktype) {
		this.customerfeedbacktype = customerfeedbacktype;
	}
	public String getCustomerhandset() {
		return customerhandset;
	}
	public void setCustomerhandset(String customerhandset) {
		if("1".equals(this.getPhonetype()))
		{
			this.customerhandset=this.getPhone();
		}else
		{
			this.customerhandset = customerhandset;
		}
		
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhonetype() {
		return phonetype;
	}
	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getCustomertype() {
		return customertype;
	}
	public void setCustomertype(String customertype) {
		this.customertype = customertype;
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
}
