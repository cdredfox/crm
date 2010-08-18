package com.netsoft.dao.beans;

import java.util.Date;

import com.netsoft.dao.pojos.Employye;

public class NoteBookBean {

		// Fields

		private Integer id;
		private String title;
		private String note;
		private Integer top;
		private Employye eid;
		private Date writeDate;
		private Integer employeeid;
		private Integer topid;

		// Constructors

		/** default constructor */
		public NoteBookBean() {
		}

		/** full constructor */
		public NoteBookBean(String title, String note, Integer top, Employye eid) {
			this.title = title;
			this.note = note;
			this.top = top;
			this.eid = eid;
		}

		// Property accessors

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getNote() {
			return this.note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public Integer getTop() {
			return this.top;
		}

		public void setTop(Integer top) {
			this.top = top;
		}

		public Employye getEid() {
			return this.eid;
		}

		public void setEid(Employye eid) {
			this.eid = eid;
		}

		public Date getWriteDate() {
			return writeDate;
		}

		public void setWriteDate(Date writeDate) {
			this.writeDate = writeDate;
		}

		public Integer getEmployeeid() {
			return employeeid;
		}

		public void setEmployeeid(Integer employeeid) {
			this.employeeid = employeeid;
		}

		public Integer getTopid() {
			return topid;
		}

		public void setTopid(Integer topid) {
			this.topid = topid;
		}
}
