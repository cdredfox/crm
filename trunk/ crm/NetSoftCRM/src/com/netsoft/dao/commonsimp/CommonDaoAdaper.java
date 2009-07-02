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
 * @author 杨飞
 * @工程名 SpringCommonTest
 * @文件名 CommonDaoAdaper.java
 * @编写日期 Dec 15, 2006
 * @功能说明 公共接口的适配器类。提供所有Spring hibernate模板的操作
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
		log.debug("保存对象方法");
		try {
			hbtTemplate.save(obj);
			log.debug("保存对象成功");
			return true;
		} catch (Exception e) {
			log.error("保存对象失败", e);
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
		log.debug("删除对象方法");
		try {
			hbtTemplate.delete(obj);
			log.debug("删除对象成功");
			return true;
		} catch (Exception e) {
			log.error("删除对象失败", e);
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
		log.debug("根据hql语句删除对象方法");
		try {
			boolean flag = this.execute(hql, hm);
			log.debug("删除对象在成功");
			return flag;
		} catch (Exception e) {
			log.error("删除对象失败", e);
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
		log.debug("根据类或主键列删除对象方法");
		try {
			hbtTemplate.delete(this.getObjectById(cl, s));
			log.debug("删除对象在成功");
			return true;
		} catch (Exception e) {
			log.error("删除对象失败", e);
			return false;
		}
	}

	// //暂时的解决方案。有一种是在配置文件里面配置的。但是却没有找到正确的方法。！！
	// public boolean dele(final Class cl,final Serializable s)
	// {
	// log.debug("根据类或主键列删除对象方法");
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
	// log.debug("删除对象在成功");
	// return true;
	// } catch (Exception e) {
	// log.error("删除对象失败",e);
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
		log.debug("根据类查到所有的对象");
		try {
			String hql = "from " + cl.getName();
			List li = hbtTemplate.find(hql);
			log.debug("批量查找对象在成功");
			return li;
		} catch (Exception e) {
			log.error("批量查找对象失败", e);
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
		log.debug("根据hql查到所有的对象");
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
			log.debug("批量查找对象在成功");
			return li;
		} catch (Exception e) {
			log.error("批量查找对象失败", e);
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
		log.debug("根据id查找对象");
		try {
			log.debug("批量查找对象在成功");
			return (cl) hbtTemplate.get(cl, s);
		} catch (Exception e) {
			log.error("批量查找对象失败", e);
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
		log.debug("根据hql语句修改对象");
		try {
			boolean flag = this.execute(hql, hm);
			log.debug("修改对象在成功");
			return flag;
		} catch (Exception e) {
			log.error("修改对象失败", e);
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.dao.commonsimp.CommonDao#updateObject(java.lang.Object)
	 */
	public boolean updateObject(Object obj) {
		log.debug("根据对象修改方法");
		try {
			hbtTemplate.update(obj);
			log.debug("修改对象在成功");
			return true;
		} catch (Exception e) {
			log.error("修改对象失败", e);
			return false;
		}
	}

	/**
	 * 这个方法是私有的。仅供类内部调用。 因为Spring的hibernate模板中只提供几种有限的查询方法。如要理灵活运用或者扩展功能。
	 * 只有重写他的回调方法来实现，hibernate模板中的回调方法。有几种。如是查询的话
	 * 就重写他的excutefind()方法。修改等操作就重写excute()即可。下面有代码。可以参考一下。 如有不懂。可联系我。具体询问
	 * 这个方法供修改。删除等功能调用
	 * 
	 */
	private boolean execute(final String hql, final HashMap hm) {
		log.debug("调用执行hql语句的公共方法");
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
								} else if(hm.get(key).getClass() == Integer[].class){
									query.setParameterList(key, (Object[])hm
											.get(key));
								}
								else{
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
			log.debug("公共方法执行成功");
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("公共方法以执行失败", e);
			return false;
		}

	}

	public List getObjectByHql(String hql) {
		log.debug("批量查询开始执行");
		try {
			List list = hbtTemplate.find(hql);
			log.debug("批量查询执行成功");
			return list;
		} catch (Exception e) {
			log.error("批量查询执行失败", e);
			return null;
		}
	}

	/**
	 * 通用的分页方法.spring解决方案
	 */
	public List currenPage(final int page, final int size, final String hql,
			final HashMap hm) {
		log.info("currenPage方法开始执行了");
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
			log.info("currenPage方法开始执行成功");
			return li;
		} catch (Exception e) {
			log.error("currenPage方法开始执行失败了", e);
			return null;
		}
	}

	public <cl> cl addreturn(Object obj) {
		log.debug("保存对象方法");
		try {
			log.debug("保存对象成功");
			return (cl) hbtTemplate.save(obj);
		} catch (Exception e) {
			log.error("保存对象失败", e);
			e.printStackTrace();
			return null;
		}
	}
	
	public void setHbtTemplate(SessionFactory sessionfactory) {
		this.hbtTemplate = new HibernateTemplate(sessionfactory);
	}
}
