package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.NoteBookBean;

public interface INoteBookServices {
	public List<NoteBookBean> getAllNoteBook(int page, int size);

	/**
	 * ȡ�������ӵ��ܼ�¼��
	 * 
	 * @return
	 */
	public int getAllNoteBookCount();
	/**
	 * ��������ȡ����
	 * @param page
	 * @param size
	 * @param topid
	 * @return
	 */
	public List<NoteBookBean> getNoteBookByTopId(int page,int size,int topid);
	/**
	 * ͳ�Ƹ����ĸ�����
	 * @param topid
	 * @return
	 */
	public int getNoteBookByTopIdCount(int topid);
	/**
	 * �ظ�����
	 * @param nbb
	 */
	public void addNoteBook(NoteBookBean nbb);
	/**
	 * ����idɾ�����ӣ�������������������ȫ��ɾ��
	 * @param id
	 * @return
	 */
	public boolean delNoteBook(int id);
}
