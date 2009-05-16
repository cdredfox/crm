package com.netsoft.dao.commonsimp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.netsoft.dao.commonintf.ICommonDao;

/**
 * 
 * @author ���
 * @������ SpringCommonTest
 * @�ļ��� CommonDaoAdaper.java
 * @��д���� Dec 15, 2006
 * @����˵�� �����ӿڵ��������ࡣ�ṩ����Spring hibernateģ��Ĳ���
 */
// extends HibernateDaoSupport
public class CommonDaoAdaper implements ICommonDao {

	Logger log = Logger.getLogger(this.getClass());
	HibernateTemplate hbtTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#add(java.lang.Object)
	 */
	public boolean add(Object obj) {
		log.debug("������󷽷�");
		try {
			hbtTemplate.save(obj);
			log.debug("�������ɹ�");
			return true;
		} catch (Exception e) {
			log.error("�������ʧ��", e);
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#dele(java.lang.Object)
	 */
	public boolean dele(Object obj) {
		log.debug("ɾ�����󷽷�");
		try {
			hbtTemplate.delete(obj);
			log.debug("ɾ������ɹ�");
			return true;
		} catch (Exception e) {
			log.error("ɾ������ʧ��", e);
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#dele(java.lang.String,
	 *      java.util.HashMap)
	 */
	public boolean dele(final String hql, final HashMap hm) {
		log.debug("����hql���ɾ�����󷽷�");
		try {
			boolean flag = this.execute(hql, hm);
			log.debug("ɾ�������ڳɹ�");
			return flag;
		} catch (Exception e) {
			log.error("ɾ������ʧ��", e);
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#dele(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public boolean dele(Class cl, Serializable s) {
		log.debug("�������������ɾ�����󷽷�");
		try {
			hbtTemplate.delete(this.getObjectById(cl, s));
			log.debug("ɾ�������ڳɹ�");
			return true;
		} catch (Exception e) {
			log.error("ɾ������ʧ��", e);
			return false;
		}
	}

	// //��ʱ�Ľ����������һ�����������ļ��������õġ�����ȴû���ҵ���ȷ�ķ���������
	// public boolean dele(final Class cl,final Serializable s)
	// {
	// log.debug("�������������ɾ�����󷽷�");
	// try {
	// hbtTemplate.execute(new HibernateCallback(){
	//
	// public Object doInHibernate(Session session) throws HibernateException,
	// SQLException {
	// session.setFlushMode(FlushMode.AUTO);
	// session.delete(getObjectById(cl, s));
	// session.flush();
	// return null;
	// }
	// });
	// log.debug("ɾ�������ڳɹ�");
	// return true;
	// } catch (Exception e) {
	// log.error("ɾ������ʧ��",e);
	// return false;
	// }
	//		
	// }
	//  
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#getObjectAll(java.lang.Class)
	 */
	public <cl> List<cl> getObjectAll(Class cl) {
		// TODO Auto-generated method stub
		log.debug("������鵽���еĶ���");
		try {
			String hql = "from " + cl.getName();
			List li = hbtTemplate.find(hql);
			log.debug("�������Ҷ����ڳɹ�");
			return li;
		} catch (Exception e) {
			log.error("�������Ҷ���ʧ��", e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#getObjectByHql(java.lang.String,
	 *      java.util.HashMap)
	 */
	public List getObjectByHql(final String hql, final HashMap hm) {
		log.debug("����hql�鵽���еĶ���");
		try {
			List li = hbtTemplate.executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					Iterator item = hm.keySet().iterator();
					while (item.hasNext()) {
						String key = item.next().toString();
						if (hm.get(key).getClass() == Integer.class) {
							query.setInteger(key, (Integer) hm.get(key));
						} else {
							query.setString(key, hm.get(key).toString());
						}
					}
					return query.list();
				}
			});
			log.debug("�������Ҷ����ڳɹ�");
			return li;
		} catch (Exception e) {
			log.error("�������Ҷ���ʧ��", e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#getObjectById(java.lang.Class,
	 *      java.io.Serializable)
	 */

	public <cl> cl getObjectById(Class cl, Serializable s) {
		log.debug("����id���Ҷ���");
		try {
			log.debug("�������Ҷ����ڳɹ�");
			return (cl) hbtTemplate.get(cl, s);
		} catch (Exception e) {
			log.error("�������Ҷ���ʧ��", e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#updateObject(java.lang.String,
	 *      java.util.HashMap)
	 */
	public boolean updateObject(final String hql, final HashMap hm) {
		log.debug("����hql����޸Ķ���");
		try {
			boolean flag = this.execute(hql, hm);
			log.debug("�޸Ķ����ڳɹ�");
			return flag;
		} catch (Exception e) {
			log.error("�޸Ķ���ʧ��", e);
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#updateObject(java.lang.Object)
	 */
	public boolean updateObject(Object obj) {
		log.debug("���ݶ����޸ķ���");
		try {
			hbtTemplate.update(obj);
			log.debug("�޸Ķ����ڳɹ�");
			return true;
		} catch (Exception e) {
			log.error("�޸Ķ���ʧ��", e);
			return false;
		}
	}

	/**
	 * ���������˽�еġ��������ڲ����á� ��ΪSpring��hibernateģ����ֻ�ṩ�������޵Ĳ�ѯ��������Ҫ��������û�����չ���ܡ�
	 * ֻ����д���Ļص�������ʵ�֣�hibernateģ���еĻص��������м��֡����ǲ�ѯ�Ļ�
	 * ����д����excutefind()�������޸ĵȲ�������дexcute()���ɡ������д��롣���Բο�һ�¡� ���в���������ϵ�ҡ�����ѯ��
	 * ����������޸ġ�ɾ���ȹ��ܵ���
	 * 
	 */
	private boolean execute(final String hql, final HashMap hm) {
		log.debug("����ִ��hql���Ĺ�������");
		try {
			boolean flag = (Boolean) hbtTemplate
					.execute(new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Transaction tx = session.beginTransaction();
							Query query = session.createQuery(hql);
							Iterator item = hm.keySet().iterator();
							while (item.hasNext()) {
								String key = item.next().toString();
								if (hm.get(key).getClass() == Integer.class) {
									query
											.setInteger(key, (Integer) hm
													.get(key));
								} else {
									query
											.setString(key, hm.get(key)
													.toString());
								}
							}
							int i = query.executeUpdate();
							tx.commit();
							return i == 0 ? false : true;
						}
					});
			log.debug("��������ִ�гɹ�");
			return flag;
		} catch (Exception e) {
			log.debug("����������ִ��ʧ��", e);
			return false;
		}

	}

	public List getObjectByHql(String hql) {
		log.debug("������ѯ��ʼִ��");
		try {
			List list = hbtTemplate.find(hql);
			log.debug("������ѯִ�гɹ�");
			return list;
		} catch (Exception e) {
			log.error("������ѯִ��ʧ��", e);
			return null;
		}
	}

	/**
	 * ͨ�õķ�ҳ����.spring�������
	 */
	public List currenPage(final int page, final int size, final String hql,
			final HashMap hm) {
		log.info("currenPage������ʼִ����");
		try {
			List li = hbtTemplate.executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {

					Query query = session.createQuery(hql);
					Iterator item = hm.keySet().iterator();
					while (item.hasNext()) {
						String key = item.next().toString();
						if (hm.get(key).getClass() == Integer.class) {
							query.setInteger(key, (Integer) hm.get(key));
						} else {
							query.setString(key, hm.get(key).toString());
						}
					}
					if (size > 0) {
						return query.setFirstResult((page * size) - size)
								.setMaxResults(size).list();
					}
						return query.list();
				}
			}

			);
			log.info("currenPage������ʼִ�гɹ�");
			return li;
		} catch (Exception e) {
			log.error("currenPage������ʼִ��ʧ����", e);
			return null;
		}
	}

	public <cl> cl addreturn(Object obj) {
		log.debug("������󷽷�");
		try {
			log.debug("�������ɹ�");
			return (cl) hbtTemplate.save(obj);
		} catch (Exception e) {
			log.error("�������ʧ��", e);
			e.printStackTrace();
			return null;
		}
	}
	
	public void setHbtTemplate(SessionFactory sessionfactory) {
		this.hbtTemplate = new HibernateTemplate(sessionfactory);
	}
}
