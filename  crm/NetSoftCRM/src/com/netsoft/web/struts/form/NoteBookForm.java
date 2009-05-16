package com.netsoft.web.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class NoteBookForm extends ActionForm {
	
	/**
	 * 主要内容
	 */
	public String noteBook;
	/**
	 * 标题
	 */
	public String noteTitle;
	/**
	 * 是否置顶
	 */
	public String noteTop;
	public String getNoteBook() {
		return noteBook;
	}
	public void setNoteBook(String noteBook) {
		this.noteBook = noteBook;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteTop() {
		return noteTop;
	}
	public void setNoteTop(String noteTop) {
		this.noteTop = noteTop;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.noteTop="0";
	}

}
