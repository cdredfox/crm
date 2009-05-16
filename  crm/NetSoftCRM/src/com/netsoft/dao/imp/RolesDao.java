package com.netsoft.dao.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.netsoft.dao.commonintf.ICommonDao;
import com.netsoft.dao.intf.IRolesDao;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;

/**
 * @author ����<pengyuan>
 * @������ NetSoftCRM
 * @�ļ��� RolesDao.java
 * @��д���� Dec 26, 2006
 * @����˵�� �Խ�ɫ����в���
 * @����˵�� 
 */
public class RolesDao implements IRolesDao {	
	Logger logger = Logger.getLogger(this.getClass());
	private ICommonDao cd;
	public ICommonDao getCd() {
		return cd;
	}

	public void setCd(ICommonDao cd) {
		this.cd = cd;
	}

	/* (non-Javadoc)
	 * @see com.netsoft.dao.imp.IRoles#addRoles(com.netsoft.dao.pojos.Roles)
	 */
	public boolean addRoles(Roles roles) {
		try {
			return cd.add(roles);
		} catch (Exception e) {
			logger.error("RolesDao�м��addroles��������", e);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.netsoft.dao.imp.IRoles#deleteRoles(com.netsoft.dao.pojos.Roles)
	 */
	public boolean deleteRoles(Roles roles) {
		try{
			return cd.dele(roles);
		}catch(Exception e){
			logger.error("RolesDao�м��deleteRoles��������", e);
		}
		return false;
	}

	public List<Roles> getAllRoles() {
		try {
			List<Roles> ls=cd.getObjectAll(Roles.class);
			return ls;
		} catch (Exception e) {
			logger.error("RolesDao�м��getAllRoles��������", e);
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.netsoft.dao.imp.IRoles#updateRoles(com.netsoft.dao.pojos.Roles)
	 */
	public boolean updateRoles(Roles roles) {
		try {
			return  cd.updateObject(roles);
		} catch (Exception e) {
			logger.error("RolesDao�м��updateRoles��������", e);
			return false;
		}
		
	}

	public boolean deleteRolesById(Class cl, Serializable rid) {
		try {
			return cd.dele(Roles.class, rid);
		} catch (Exception e) {
			logger.error("RolesDao�м��deleeRolesById��������", e);
			return false;
		}
		
	}

	public boolean RolesRemoveMenus(Roles roles, Menus menus) {
		try {
			roles.getEmidrs().remove(menus);
			cd.updateObject(roles);
			return true;
		} catch (Exception e) {
			logger.error("RolesDao�м��RolesRemoveMenus��������", e);
			return false;
		}
		
	}

	public boolean RolesSetMenus(Roles roles, Menus menus) {
		try {
			roles.getEmidrs().add(menus);
			cd.updateObject(roles);
			return true;
		} catch (Exception e) {
			logger.error("RolesDao�м��RolesSetMenus��������", e);
			return false;
		}
		
	}
	
	
	public Set<Menus> getMenusByRole(Roles roles) {
		logger.debug("getMenusByRole������ʼִ��");
		try {
		    roles=cd.getObjectById(Roles.class, roles.getId());
			Set<Menus> s=roles.getRmidptables();
			logger.debug("getMenusByRole������s��ֵΪ��"+s.size());
		    logger.debug("getMenusByRole����ִ�гɹ�");
		    return s;
		} catch (Exception e) {
			logger.error("getMenusByRole����ִ��ʧ��",e);
			return null;
		}
	}

	public Roles getRoles(Integer id) {
		try {
			HashMap hm=new HashMap();
			hm.put("id", id);
			List ls = cd.getObjectByHql("from Roles where id=:id", hm);
			if(ls!=null && ls.size()!=0){
				Roles rs=(Roles) ls.get(0);
				return rs;
			}else{
				return null;
			}
		} catch (Exception e) {
			logger.error("getRoles����ִ��ʧ��",e);
			return null;
		}
	}

	public boolean updateRdelStyleOnRoles(Integer id, Integer rdelstyle) {
		try {
			HashMap hm=new HashMap();
			hm.put("id", id);
			hm.put("rdelstyle", rdelstyle);
			return cd.updateObject("update Roles set rdelstyle=:rdelstyle where id=:id", hm);
		} catch (Exception e) {
			logger.error("updateRdelStyleOnRoles����ִ��ʧ��",e);
			return false;
		}
	}

}
