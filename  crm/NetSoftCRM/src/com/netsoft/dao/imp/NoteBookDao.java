package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.INoteBookDao;
import com.netsoft.dao.pojos.Notebook;


public class NoteBookDao implements INoteBookDao {
	private ICommonDao icd;

	public ICommonDao getIcd() {
		return icd;
	}

	public void setIcd(ICommonDao icd) {
		this.icd = icd;
	}
	
	/**
	 * ��ҳ��ȡ���е�����
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Notebook> getAllNoteBook(int page,int size)
	{
		String hql="from Notebook where 1=1 and topid=0 order by top desc,writeDate desc";
		HashMap hm=new HashMap();
		return icd.currenPage(page, size,hql, hm);
	}
	
	/**
	 * �����������һظ�������ҳ
	 * @param page
	 * @param size
	 * @param topid
	 * @return
	 */
	public List<Notebook> getNoteBookByTopId(int page,int size,int topid)
	{
		String hql="from Notebook where 1=1 and (topid= :topid or id=:id) order by writeDate desc";
		
		HashMap hm=new HashMap();
		hm.put("topid", topid);
		hm.put("id", topid);
		return icd.currenPage(page, size,hql, hm);
	}

	/**
	 * ���Ӹ���
	 * @param nb
	 */
	public void addNoteBook(Notebook nb)
	{
		icd.add(nb);
	}

	public boolean delNoteBook(int id) {
		String hql="delete from Notebook where topid=:topid or id=:id";
		HashMap hm=new HashMap();
		hm.put("topid", id);
		hm.put("id",id);
		return icd.dele(hql,hm);
	}
}
