package com.netsoft.dao.imp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.netsoft.dao.beans.EmployeeBean;
import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IEmployeeDao;
import com.netsoft.dao.pojos.Employye;
import com.netsoft.dao.pojos.Roles;


public class EmployeeDao implements IEmployeeDao {
    private ICommonDao cd;
    
    /* (non-Javadoc)
	 * @see com.netsoft.dao.intf.EmployeeDaoIntf#getEmployyeByeAccountAndPwd(com.netsoft.dao.beans.EmployeeBean)
	 */
    Logger log = Logger.getLogger(this.getClass());
	public Employye getEmployyeByeAccountAndPwd(Employye eb)
     {
		log.debug("getEmployyeByeAccountAndPwd()方法执行开始");
		 try {
			 String hql="from Employye as e where e.eaccount=:eaccount and e.epwd=:pwd";
			 HashMap hm=new HashMap();
			 hm.put("eaccount", eb.getEaccount());
			 hm.put("pwd", eb.getEpwd());
	    	 List<Employye> li=cd.getObjectByHql(hql, hm);
	    	 if(li==null ||li.size()==0)
	    	 {
	    		 log.debug("getEmployyeByeAccountAndPwd()方法执行结果为NULL。返回NULL");
	    		 return null;
	    	 }else
	    	 {
	    		 log.debug("getEmployyeByeAccountAndPwd()方法执行成功");
	    		 return li.get(0);
	    	 }
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("getEmployyeByeAccountAndPwd()方法执行失败",e);
			return null;
		}
    	
     }
	
	  /**
	    * 根据条件来查询
	    * @param hm
	    * @return
	    */
	   public List findEmployyeByHashMap(HashMap hm)
	   {
		   log.debug("findEmployyeByHashMap()方法执行开始");
			 try {
				 StringBuffer hql=new StringBuffer();
				 hql.append("from Employye as e where 1=1");
				 Iterator iter=hm.keySet().iterator();
				 while(iter.hasNext())
				 {
					 String any=(String) iter.next();
					 if(!"".equals(hm.get(any)))
						 hql.append(" and e."+any+" ="+" :"+any);
				 }
		    	 List<Employye> li=cd.getObjectByHql(hql.toString(), hm);
		    	 if(li==null ||li.size()==0)
		    	 {
		    		 log.debug("findEmployyeByHashMap()方法执行结果为NULL。返回NULL");
		    		 return null;
		    	 }else
		    	 {
		    		 log.debug("findEmployyeByHashMap()方法执行成功");
		    		 return li;
		    	 }
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("findEmployyeByHashMap()方法执行失败",e);
				return null;
			}
	    	
	   }
	
	public ICommonDao getCd() {
		return cd;
	}
	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}

	public boolean EmployeeSetRole(Employye em, Roles role) {
		log.debug("EmployeeSetRole()方法执行开始");
		try {
			em.getEmidrs().add(role);
			cd.updateObject(em);
			log.debug("EmployeeSetRole()方法执行成功");
			return true;
		} catch (Exception e) {
			log.debug("EmployeeSetRole()方法执行失败",e);
			return false;
		}
	}

	public boolean EmployeeRemoveRole(Employye em, Roles role) {
		try {
			log.debug("EmployeeRemoveRole()方法执行开始");
			em.getEmidrs().remove(role);
			cd.updateObject(em);
			log.debug("EmployeeRemoveRole()方法执行成功");
			return true;
		} catch (Exception e) {
			log.debug("EmployeeRemoveRole()方法执行失败",e);
			return false;
		}
		
	}

	public Set getRolesByEmployee(Employye em) {
		log.debug("getRolesByEmployee()方法开始执行");
		try {
			HashMap hm=new HashMap();
//			String hql="from Roles as r where r.emidrs=:id";
//			hm.put("id",em.getId());
//			List list=cd.getObjectByHql(hql, hm);
			Set list=em.getEmidrs();
			log.info("getRolesByEmployee()方法中长度为："+list.size());
			log.debug("getRolesByEmployee()方法执行成功");
			return list;
		} catch (Exception e) {
			log.debug("getRolesByEmployee()方法执行失败",e);
		    return null;
		}
	}

	public Employye getEmployeeById(int id) {
		try {
			log.info("getEmployeeById()方法开始执行");
			log.info("getEmployeeById()方法执行成功");
			Employye employee=cd.getObjectById(Employye.class,id);
			return employee;
			
		} catch (Exception e) {
			log.error("getEmployeeById()方法执行失败",e);
			return null;
		}
		
	}

	public Employye getEmployeeEdelStyleId(Integer id) {
		try {
			HashMap hm=new HashMap();
			hm.put("id", id);
			List ls = cd.getObjectByHql("from Employye where id=:id", hm);
			if(ls!=null && ls.size()!=0){
				Employye ey=(Employye) ls.get(0);
				return ey;
			}else{
				return null;
			}
		} catch (Exception e) {
			log.error("getEmployeeEdelStyleId()方法执行失败", e);
			return null;
		}
		
	}

	public List getAllEmployee() {
		try {
			log.info("getAllEmployee方法开始执行");
			List li=cd.getObjectAll(Employye.class);
			log.info("getAllEmployee的长度为：　"+li.size());
			log.info("getAllEmployee方法执行成功");
			return li;
		} catch (Exception e) {
			log.error("getAllEmployee方法执行失败",e);
			return null;
		}
	}
	
	/**根据传过来的对象删除一个员工*/
	public boolean delEmployee(Employye em)
	{
		try {
			log.info("delEmployee方法开始执行");
			return cd.dele(Employye.class,em.getId());
		} catch (Exception e) {
			log.error("delEmployee方法执行失败",e);
			return false;
		}
		
	}
	
	/**增加员工*/
	 public boolean addEmployee(Employye ed)
	 {
		 try {
			 log.info("addEmployee方法开始执行");
			 cd.add(ed);
			 log.info("addEmployee方法执行成功");
			 return true;
		} catch (Exception e) {
			log.error("addEmployee方法执行失败",e);
			return false;
		}
		 
	 }
	
	 /**修改员工*/
   public boolean updateEmployee(Employye em)
   {
	  try {
		cd.updateObject(em);
		return true;
	} catch (Exception e) {
		log.error("updateEmployee方法出错了");
		return false;
	}   
   }

	public List findEmployyeByAny(String str1, String str2) {
		try {
			String hql="from Employye as e where e."+str1+" like :"+str1;
			log.info("findEmployyeByAny中hql语句输出为："+hql+"  str2为："+str2);
			HashMap hm=new HashMap();
			hm.put(str1,str2);
			return cd.getObjectByHql(hql, hm);
		} catch (Exception e) {
			log.error("findEmployyeByAny方法出错了",e);
			return null;
		}
	}
	
	public List<Employye> getEmployeesByTopId(int topId)
	{
		String hql="from Employye as e where e.topId=:topId";
		HashMap hm=new HashMap();
		hm.put("topId",topId);
		return cd.getObjectByHql(hql, hm);
	}
	
	public boolean batchUpdateEmployye(Integer[] eids,int topId)
	{
		String hql="update Employye  set topId=:topId where id in (:ids)";
		HashMap hm=new HashMap();
		hm.put("topId",topId);
		hm.put("ids",eids);
		return cd.updateObject(hql, hm);
	}
}
