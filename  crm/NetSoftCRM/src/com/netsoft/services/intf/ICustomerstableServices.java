package com.netsoft.services.intf;

import java.util.List;

import com.netsoft.dao.beans.CustomerstableBean;

public interface ICustomerstableServices {
	public int INVALI_CUSTOMER_GRADE=999999;//ʧЧ�Ŀͻ��ȼ�
	/**
	 * ���ݴ������ĵ绰�����������ͻ��Ƿ��Ѵ���
	 * @param type
	 * @param number
	 * @param name
	 * @return
	 */
	public int checkCustomer(String type,String number,String name);
	/**
	 * �õ�ĳԱ�����µ����пͻ���Ϣ
	 * @param id
	 * @return
	 */
	public List<CustomerstableBean> getAllCustomerByEid(int id,int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * ȡ�����еĹ����ͻ���Ϣ
	 * @return
	 */
	public List<CustomerstableBean> getAllOpenCustomer(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * ȡ���еĳ�������Ϣ
	 * @param page
	 * @param size
	 * @return
	 */
	public List<CustomerstableBean> getAllInvaliCustomer(int page,int size,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * ȡ�����еĿͻ���Ϣ
	 * @return
	 */
	public List<CustomerstableBean> getAllCustomer(int page,int size,String company,int eid,String startdate,String enddate);
	/**
	 * ����һ���ͻ���Ϣ
	 * @param cb
	 * @return
	 */
	public String addCustomer(CustomerstableBean cb);
	
	/**
	 * ȡ��ĳԱ���������пͻ��ĺϼ���
	 * @param eid
	 * @return
	 */
	public int getCount(int eid,String company,String startdate,String enddate,int cutomergrade);
	/**
	 * �õ����й����ͻ�������
	 * @return
	 */
	public int getOpenCount(String company,String startdate,String enddate,int cutomergrade);
	/**
	 * �õ����е�ʧЧ�ͻ���Ϣ
	 * @return
	 */
	public int getInvaliCount(String company,String startdate,String enddate,int cutomergrade);
	/**
	 * �õ����пͻ�������
	 * @return
	 */
	public int getAllCount(String company,int eid,String startdate,String enddate);
	/**
	 * ɾ��һ���ͻ���Ϣ
	 * @param id
	 * @param flag �ǲ���������ɾ��
	 * @return
	 */
	public boolean delCustomerByFlag(int id,String flag);
	/**
	 * ���ݿͻ�ID�õ��ͻ�����
	 * @param id
	 * @return
	 */
	public CustomerstableBean getCustomerById(int id);
	
	/**
	 * ����ҵ��������һ���ͻ�����
	 * @param ctb
	 * @return
	 */
	public boolean updateCustomer(CustomerstableBean ctb);
	/**
	 * ��ָ���Ŀͻ���Ϣ��Ϊ����
	 * @param id
	 * @return
	 */
	public boolean changeCustomerOpen(int id);
	/**
	 * ɾ��һ���ͻ���Ϣ
	 * @param id
	 * @return
	 */
	public boolean delCustomer(int id);
	
}
