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
		log.debug("getEmployyeByeAccountAndPwd()����ִ�п�ʼ");
		 try {
			 String hql="from Employye as e where e.eaccount=:eaccount and e.epwd=:pwd";
			 HashMap hm=new HashMap();
			 hm.put("eaccount", eb.getEaccount());
			 hm.put("pwd", eb.getEpwd());
	    	 List<Employye> li=cd.getObjectByHql(hql, hm);
	    	 if(li==null ||li.size()==0)
	    	 {
	    		 log.debug("getEmployyeByeAccountAndPwd()����ִ�н��ΪNULL������NULL");
	    		 return null;
	    	 }else
	    	 {
	    		 log.debug("getEmployyeByeAccountAndPwd()����ִ�гɹ�");
	    		 return li.get(0);
	    	 }
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("getEmployyeByeAccountAndPwd()����ִ��ʧ��",e);
			return null;
		}
    	
     }
	
	  /**
	    * ������������ѯ
	    * @param hm
	    * @return
	    */
	   public List findEmployyeByHashMap(HashMap hm)
	   {
		   log.debug("findEmployyeByHashMap()����ִ�п�ʼ");
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
		    		 log.debug("findEmployyeByHashMap()����ִ�н��ΪNULL������NULL");
		    		 return null;
		    	 }else
		    	 {
		    		 log.debug("findEmployyeByHashMap()����ִ�гɹ�");
		    		 return li;
		    	 }
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("findEmployyeByHashMap()����ִ��ʧ��",e);
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
		log.debug("EmployeeSetRole()����ִ�п�ʼ");
		try {
			em.getEmidrs().add(role);
			cd.updateObject(em);
			log.debug("EmployeeSetRole()����ִ�гɹ�");
			return true;
		} catch (Exception e) {
			log.debug("EmployeeSetRole()����ִ��ʧ��",e);
			return false;
		}
	}

	public boolean EmployeeRemoveRole(Employye em, Roles role) {
		try {
			log.debug("EmployeeRemoveRole()����ִ�п�ʼ");
			em.getEmidrs().remove(role);
			cd.updateObject(em);
			log.debug("EmployeeRemoveRole()����ִ�гɹ�");
			return true;
		} catch (Exception e) {
			log.debug("EmployeeRemoveRole()����ִ��ʧ��",e);
			return false;
		}
		
	}

	public Set getRolesByEmployee(Employye em) {
		log.debug("getRolesByEmployee()������ʼִ��");
		try {
			HashMap hm=new HashMap();
//			String hql="from Roles as r where r.emidrs=:id";
//			hm.put("id",em.getId());
//			List list=cd.getObjectByHql(hql, hm);
			Set list=em.getEmidrs();
			log.info("getRolesByEmployee()�����г���Ϊ��"+list.size());
			log.debug("getRolesByEmployee()����ִ�гɹ�");
			return list;
		} catch (Exception e) {
			log.debug("getRolesByEmployee()����ִ��ʧ��",e);
		    return null;
		}
	}

	public Employye getEmployeeById(int id) {
		try {
			log.info("getEmployeeById()������ʼִ��");
			log.info("getEmployeeById()����ִ�гɹ�");
			Employye employee=cd.getObjectById(Employye.class,id);
			return employee;
			
		} catch (Exception e) {
			log.error("getEmployeeById()����ִ��ʧ��",e);
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
			log.error("getEmployeeEdelStyleId()����ִ��ʧ��", e);
			return null;
		}
		
	}

	public List getAllEmployee() {
		try {
			log.info("getAllEmployee������ʼִ��");
			List li=cd.getObjectAll(Employye.class);
			log.info("getAllEmployee�ĳ���Ϊ����"+li.size());
			log.info("getAllEmployee����ִ�гɹ�");
			return li;
		} catch (Exception e) {
			log.error("getAllEmployee����ִ��ʧ��",e);
			return null;
		}
	}
	
	/**���ݴ������Ķ���ɾ��һ��Ա��*/
	public boolean delEmployee(Employye em)
	{
		try {
			log.info("delEmployee������ʼִ��");
			return cd.dele(Employye.class,em.getId());
		} catch (Exception e) {
			log.error("delEmployee����ִ��ʧ��",e);
			return false;
		}
		
	}
	
	/**����Ա��*/
	 public boolean addEmployee(Employye ed)
	 {
		 try {
			 log.info("addEmployee������ʼִ��");
			 cd.add(ed);
			 log.info("addEmployee����ִ�гɹ�");
			 return true;
		} catch (Exception e) {
			log.error("addEmployee����ִ��ʧ��",e);
			return false;
		}
		 
	 }
	
	 /**�޸�Ա��*/
   public boolean updateEmployee(Employye em)
   {
	  try {
		cd.updateObject(em);
		return true;
	} catch (Exception e) {
		log.error("updateEmployee����������");
		return false;
	}   
   }

	public List findEmployyeByAny(String str1, String str2) {
		try {
			String hql="from Employye as e where e."+str1+" like :"+str1;
			log.info("findEmployyeByAny��hql������Ϊ��"+hql+"  str2Ϊ��"+str2);
			HashMap hm=new HashMap();
			hm.put(str1,str2);
			return cd.getObjectByHql(hql, hm);
		} catch (Exception e) {
			log.error("findEmployyeByAny����������",e);
			return null;
		}
	}
}
