package com.netsoft.dao.intf;

import java.io.Serializable;
import java.util.List;

import com.netsoft.dao.pojos.Depts;

/**
 * 
 * @����˵�������ݴ������Ĳ��Ŷ���ȡ����Ӧ��POJO����
 * @�������͡�boolean
 * @param depts
 * @return 
 */
public interface IDeptsDao {
	/*���һ������*/
	public abstract boolean addDept(Depts depts);
	/*ɾ��һ������*/
	public abstract boolean deleteDept(Depts depts);
	/*����idɾ������*/
	public abstract boolean deleteDeptById(Class cl,Serializable id);
	/*�޸�һ������*/
	public abstract boolean updateDept(Depts depts);
	/*��ȡ���в���*/
	public List<Depts> getAllDepts();
	/**���ݲ���ID���Ҳ��Ŷ���*/
	public Depts getDeptsById(int id);
	
	/**
	 * ����Ա�������������Ĳ���
	 * @param id
	 * @return
	 */
	public List getDeptsByEid(int id);
}
