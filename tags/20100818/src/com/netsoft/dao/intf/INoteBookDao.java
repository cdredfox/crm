package com.netsoft.dao.intf;

import java.util.List;

import com.netsoft.dao.pojos.Notebook;

public interface INoteBookDao {
	/**
	 * 按页数来取所有的论坛贴
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Notebook> getAllNoteBook(int page,int size);
	/**
	 * 根据主题贴找回复贴并分页
	 * @param page
	 * @param size
	 * @param topid
	 * @return
	 */
	public List<Notebook> getNoteBookByTopId(int page,int size,int topid);
	/**
	 * 增加跟贴
	 * @param nb
	 */
	public void addNoteBook(Notebook nb);
	/**
	 * 删除指定id的贴子，如果是主贴的话，其下的跟贴也将删除
	 * @param id
	 * @return
	 */
	public boolean delNoteBook(int id);
}
