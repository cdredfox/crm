package com.netsoft.dao.commonintf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface ICommonDao {

	/**
	 * ���Ӷ���Ĺ��÷���
	 * ���������Ҫ��������һ���־û����󡣲��ӵ����ݿ���
	 * Ҫ���ṩ�Ĳ�����һ��pojo�������ڲ��õ���hibernateģ��
	 * ����ֻ���ṩ��hibernateӳ���pojo����
	 */
	public abstract boolean add(Object obj);

	/**
	 * ���ݳ־û����󡣴ӳֻ�������ɾ����Ӧ�Ķ���
	 * ͬʱ�����ݿ��ж�Ӧ�ļ�¼��ɾ����
	 * Ҫ���ṩ�Ĳ�����һ��pojo�������ڲ��õ���hibernateģ��
	 * ����ֻ���ṩ��hibernateӳ���pojo����
	 */
	public abstract boolean dele(Object obj);

	/**
	 * �����ṩ��HQL�������̬ɾ�������кܴ������ԣ�
	 * �ṩ�������һ�����ơ���ο�˵���е����ģ�塣��ʹ��ռλ����HashMap�б���
	 * �������Ӧ��ռλ���ļ���ֵ
	 * ������ʾ����䡣��ο���
	 * ��������Ҫ��User������ɾ��username=redfox���������
	 * ����������䣺
	 * delete from User as u where u.username=:name
	 * ������hashmap�д�ŵ�ֵ��Ҫ����������
	 *  hm.add("name","redfox")
	 *  �������ʱ������HASHMAP�����Ӷ��ֵ���ɡ� 
	 *  ����˽�з���excute��ִ�о���Ĳ���������ʵ�־Ͳο�excute����
	 */
	public abstract boolean dele(final String hql, final HashMap hm);

	/**
	 * ���ݴ������Ķ������ͣ����ж����OID��ɾ����Ӧ�ĳ־û�����
	 * ͬʱ�����ݿ������Ӧ�ļ�¼��ɾ����
	 * ����c1ΪClass���͵ģ�����Ӧ��Ҫɾ���ĳ־û������Class��
	 * ����sΪ���л�������������Ҫ��ָ�ֻ��������OID��ʶ��
	 */
	public abstract boolean dele(Class cl, Serializable s);

	/**
	 * ����������ø��ݴ������ĳ־û���������͡���ȡ��
	 * ���е�������͵ĳֻ�������
	 * ����cl��Ҫ��ѯ����һ���͡�ʹ��ʱ������ȷ�ϡ��������Ƿ�
	 * �ǳ־û���������͡�������ܻ��ѯ���ɹ�
	 */
	public abstract <cl> List<cl> getObjectAll(Class cl);

	/**
	 * �����ṩ��HQL�������̬��ѯ�����кܴ������ԣ�
	 * �ṩ�������һ�����ơ���ο�˵���е����ģ�塣��ʹ��ռλ����HashMap�б���
	 * �������Ӧ��ռλ���ļ���ֵ
	 * ������ʾ����䡣��ο���
	 * ��������Ҫ��User�����в�ѯusername=redfox���������
	 * ����������䣺
	 * from User as u where u.username=:name
	 * ������hashmap�д�ŵ�ֵ��Ҫ����������
	 *  hm.add("name","redfox")
	 *  �������ʱ������HASHMAP�����Ӷ��ֵ���ɡ� 
	 *  �˷�����д��Spirng��hibernateģ��Ļص�������ʵ�֡���Ϊhibernateģ���ṩ�ķ���ʵ�ַ�ʽ����
	 */
	public abstract List getObjectByHql(final String hql, final HashMap hm);

	/**
	 * ���ݴ������Ķ������ͣ����ж����OID�����Ҷ�Ӧ�ĳ־û�����
	 * ����c1ΪClass���͵ģ�����Ӧ��Ҫ��ѯ�ĳ־û������Class��
	 * ����sΪ���л�������������Ҫ��ָ�ֻ��������OID��ʶ��
	 */

	public abstract <cl> cl getObjectById(Class cl, Serializable s);

	/**
	 * �����ṩ��HQL�������̬�޸Ķ����кܴ������ԣ�
	 * �ṩ�������һ�����ơ���ο�˵���е����ģ�塣��ʹ��ռλ����HashMap�б���
	 * �������Ӧ��ռλ���ļ���ֵ
	 * ������ʾ����䡣��ο���
	 * ��������Ҫ��User����username=redfox����������޸ĳ�username=foxconn��
	 * ����������䣺
	 * update User set username=:str1 where username=:str2
	 * ������hashmap�д�ŵ�ֵ��Ҫ����������
	 *  hm.add("str1","foxconn")
	 *  hm.add("str2","cdredfox")
	 *  �������ʱ������HASHMAP�����Ӷ��ֵ���ɡ� 
	 *  ����˽�з���excute��ִ�о���Ĳ���������ʵ�־Ͳο�excute����
	 */
	
	/**
	 *  �����ṩ��HQL�������ѯ�������ذ汾
	 *  ������ذ汾���ܸ�����
	 */
	public abstract List getObjectByHql(String hql);
	public abstract boolean updateObject(final String hql, final HashMap hm);

	/**
	 * ���ݳ־û����󡣴ӳֻ��������޸���Ӧ�Ķ���
	 * ͬʱ�����ݿ��ж�Ӧ�ļ�¼�޸ĵ���
	 * Ҫ�󴫹����Ķ������Ѿ��޸Ĺ��Ķ���
	 * Ҫ���ṩ�Ĳ�����һ��pojo�������ڲ��õ���hibernateģ��
	 * ����ֻ���ṩ��hibernateӳ���pojo����
	 */
	public abstract boolean updateObject(Object obj);
	
	/**
	 * ����־û����󲢷��ظö���
	 * @param obj
	 * @return
	 */
	public <cl> cl addreturn(Object obj);
	
	public List currenPage(final int page,final int size,final String hql,final HashMap hm);

}