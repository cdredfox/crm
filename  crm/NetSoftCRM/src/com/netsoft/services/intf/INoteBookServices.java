package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.NoteBookBean;

public interface INoteBookServices {
	public List<NoteBookBean> getAllNoteBook(int page, int size);

	/**
	 * 取所有帖子的总记录数
	 * 
	 * @return
	 */
	public int getAllNoteBookCount();
	/**
	 * 根据主贴取跟贴
	 * @param page
	 * @param size
	 * @param topid
	 * @return
	 */
	public List<NoteBookBean> getNoteBookByTopId(int page,int size,int topid);
	/**
	 * 统计该贴的跟贴数
	 * @param topid
	 * @return
	 */
	public int getNoteBookByTopIdCount(int topid);
	/**
	 * 回复贴子
	 * @param nbb
	 */
	public void addNoteBook(NoteBookBean nbb);
	/**
	 * 根据id删除贴子，如果是主贴则将其下面的全部删除
	 * @param id
	 * @return
	 */
	public boolean delNoteBook(int id);
}
