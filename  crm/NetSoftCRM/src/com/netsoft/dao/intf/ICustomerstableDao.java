package com.netsoft.dao.intf;

import java.util.HashMap;
import java.util.List;

import com.netsoft.dao.pojos.Customerstable;

public interface ICustomerstableDao {
	
	/**
	 * ����һ���ͻ�����
	 */
	public void updateCustomerstable(Customerstable cu);
	/**
	 * ����һ���ͻ�����
	 * @param cu
	 */
	public <cl> cl addCustomerstable(Customerstable cu);
	/**
	 * ���ݿͻ�IDɾ��һ���ͻ�����
	 * @param id
	 */
	public boolean delCustomerstable(int id);
	/**
	 * ȡ�����еĿͻ�����
	 */
	public List<Customerstable> getAllCustomerstable(int page,int size,String company,int eid,String startdate,String enddate);
	/**
	 * ����Ա��IDȡ�ø�Ա�����µ����пͻ����� ��ҳ
	 * @param eid
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Customerstable> getCustomersByEid(int eid,int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * ȡ�����й����Ŀͻ�����
	 */
	public List<Customerstable> getCustomersByOpen(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	
	/**
	 * ȡ����ʧ���ͻ�
	 * @return
	 */
	public List<Customerstable> getCustomersByInvali(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * 
	 * @param hm
	 * @param hql
	 * @return
	 */
	
	public List<Customerstable> getCustomersByAny(HashMap hm,String hql);
	
	/**
	 * ��ĳԱ�����µ�ĳ�ȼ������пͻ�
	 * @param eid
	 * @param grade
	 * @return
	 */
	public List<Customerstable> getCustomerByEidAndGrade(int eid,int grade);
	
	/**
	 * ���ݿͻ�ID�õ�һ���־û��ͻ�����
	 * @param id
	 * @return
	 */
	public Customerstable getCustomerById(int id);
	
	public List<Customerstable> getCustomerByGrade(int grade);
}
