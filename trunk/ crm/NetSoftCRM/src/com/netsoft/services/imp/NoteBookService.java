package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.netsoft.dao.beans.NoteBookBean;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.intf.INoteBookDao;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Notebook;
import com.netsoft.services.intf.INoteBookServices;
import com.netsoft.util.Escape;

public class NoteBookService implements INoteBookServices {
	private INoteBookDao ibd;
	private IEmployeeDao ied;

	public INoteBookDao getIbd() {
		return ibd;
	}

	public void setIbd(INoteBookDao ibd) {
		this.ibd = ibd;
	}

	/**
	 * 按页数取得贴子记录
	 */
	public List<NoteBookBean> getAllNoteBook(int page, int size) {
		List<Notebook> list = ibd.getAllNoteBook(page, size);
		List<NoteBookBean> result = new ArrayList<NoteBookBean>();
		NoteBookBean nbb;
		for (Notebook notebook : list) {
			nbb = new NoteBookBean();
			BeanUtils.copyProperties(notebook, nbb);
			result.add(nbb);
		}
		return result;
	}
	
	/**
	 * 取所有帖子的总记录数
	 * @return
	 */
	public int getAllNoteBookCount()
	{
		return this.getAllNoteBook(0, 0).size();
	}
	
	/**
	 * 根据主贴取跟贴
	 * @param page
	 * @param size
	 * @param topid
	 * @return
	 */
	public List<NoteBookBean> getNoteBookByTopId(int page,int size,int topid)
	{
		List<Notebook> list=ibd.getNoteBookByTopId(page, size, topid);
		List<NoteBookBean> result = new ArrayList<NoteBookBean>();
		NoteBookBean nbb;
		for (Notebook notebook : list) {
			nbb = new NoteBookBean();
			BeanUtils.copyProperties(notebook, nbb);
			//nbb.setNote(Escape.unescape(nbb.getNote()));
			result.add(nbb);
		}
		return result;	
	}
	
	/**
	 * 统计该贴的跟贴数
	 * @param topid
	 * @return
	 */
	public int getNoteBookByTopIdCount(int topid)
	{
		return this.getNoteBookByTopId(0, 0, topid).size();
	}
	
	/**
	 * 回复贴子
	 * @param nbb
	 */
	public void addNoteBook(NoteBookBean nbb)
	{
		Notebook nb=new Notebook();
		nb.setNote(nbb.getNote());
		Employye em=ied.getEmployeeById(nbb.getEmployeeid());
		nb.setEid(em);
		nb.setTitle(nbb.getTitle());
		nb.setTop(nbb.getTop());
		nb.setTopid(nbb.getTopid());
		nb.setWriteDate(nbb.getWriteDate());
		ibd.addNoteBook(nb);
	}

	public IEmployeeDao getIed() {
		return ied;
	}

	public void setIed(IEmployeeDao ied) {
		this.ied = ied;
	}
	
	/**
	 * 根据id删除贴子，如果是主贴则将其下面的全部删除
	 * @param id
	 * @return
	 */
	public boolean delNoteBook(int id)
	{
		return ibd.delNoteBook(id);
	}
}
