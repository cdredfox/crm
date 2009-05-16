package com.netsoft.dao.intf;

import java.util.List;

import com.netsoft.dao.pojos.Notebook;

public interface INoteBookDao {
	/**
	 * ��ҳ����ȡ���е���̳��
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Notebook> getAllNoteBook(int page,int size);
	/**
	 * �����������һظ�������ҳ
	 * @param page
	 * @param size
	 * @param topid
	 * @return
	 */
	public List<Notebook> getNoteBookByTopId(int page,int size,int topid);
	/**
	 * ���Ӹ���
	 * @param nb
	 */
	public void addNoteBook(Notebook nb);
	/**
	 * ɾ��ָ��id�����ӣ�����������Ļ������µĸ���Ҳ��ɾ��
	 * @param id
	 * @return
	 */
	public boolean delNoteBook(int id);
}
