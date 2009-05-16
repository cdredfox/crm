package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.netsoft.dao.beans.RolesBean;
import com.netsoft.dao.imp.MenusDao;
import com.netsoft.dao.intf.IMenusDao;
import com.netsoft.dao.intf.IRolesDao;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;
import com.netsoft.services.intf.IMenusServices;
import com.netsoft.services.intf.IRoleServices;

public class RoleServices implements IRoleServices {
	private IRolesDao ird;
	private IMenusServices ims;
	private IMenusDao imd;
	private Logger log = Logger.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netsoft.services.imp.IRoleServices#getAllRoles()
	 */
	public List getAllRoles() {
		try {
			List<RolesBean> list = new ArrayList();
			List<Roles> role = ird.getAllRoles();
			log.info("getAllRoles�ĳ���Ϊ��" + role.size());
			for (Roles roles : role) {
				RolesBean rb = new RolesBean();
				BeanUtils.copyProperties(rb, roles);
				list.add(rb);
			}
			return list;
		} catch (Exception e) {
			log.error("RoleServices��getAllRoles���������쳣��", e);
			return null;
		}
	}

	/** �޸Ľ�ɫ״̬��0��Ч 1��Ч */
	public boolean changeStyle(int cid, int style) {
		try {
			if (style == 1) {
				ird.updateRdelStyleOnRoles(cid, 0);
			} else {
				ird.updateRdelStyleOnRoles(cid, 1);
			}
			return true;
		} catch (Exception e) {
			log.error("RoleServices��changeStyle���������쳣��", e);
			return false;
		}

	}

	public IRolesDao getIrd() {
		return ird;
	}

	public void setIrd(IRolesDao ird) {
		this.ird = ird;
	}

	public Set getMenusByRole(int rid) {
		try {
			Roles roles = new Roles();
			roles.setId(rid);
			return ird.getMenusByRole(roles);
		} catch (Exception e) {
			log.error("RoleServices��getMenusByRole���������쳣��", e);
			return null;
		}
	}

	/** ����һ����ɫ */
	public boolean addRole(RolesBean rb) {
		try {
			Roles r = new Roles();
			r.setRname(rb.getRname());
			ird.addRoles(r);
			ims.addAllByRole(r.getId(), rb.getAllMenus());
			addMenus(-1, r);
			addMenus(-2, r);
			addMenus(-3, r);
			ird.updateRoles(r);
			return true;
		} catch (Exception e) {
			log.error("RoleServices��getMenusByRole���������쳣��", e);
			return false;
		}

	}

	/** ���ݽ�ɫIDɾ��һ����ɫ */
	public String delRoleById(int id) {
		try {
			Roles role=ird.getRoles(id);
			if(role.getEmidrs().size()>0)
			{
				return "��ǰ��ɫ���ܱ�ɾ��!���Ƚ��ý�ɫ�µ�Ա����ת�Ƶ�������ɫ��!";
			}
			 if(ird.deleteRolesById(Roles.class, id))
			 {
				 return "��ǰ��ɫ���ɹ�ɾ��";
			 }else
			 {
				 return "��ɫɾ��ʧ��!δ֪����";
			 }
		} catch (Exception e) {
			log.error("RoleServices��delRoleById���������쳣��", e);
			return "��ɫɾ��ʱ�����쳣,����ϵ��ص�ϵͳ��Ա!";
		}

	}

	public IMenusServices getIms() {
		return ims;
	}

	public void setIms(IMenusServices ims) {
		this.ims = ims;
	}

	public void addMenus(int topid, Roles r) {
		List list = ims.getInitMenus(topid);
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				r.getRmidptables().add((Menus)list.get(i));
			}
		}

	}

	public boolean updateRole(RolesBean rb) {
		try {
			Roles role=ird.getRoles(rb.getId());
			role.getRmidptables().clear();
			Integer[] menus=rb.getAllMenus();
			for (Integer integer : menus) {
				role.getRmidptables().add(imd.getMenusById(integer));
			}
			addMenus(-1, role);
			addMenus(-2, role);
			addMenus(-3, role);
			ird.updateRoles(role);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("�޸Ľ�ɫȨ��ʱ������!",e);
			return false;
		}
		
	}

	public IMenusDao getImd() {
		return imd;
	}

	public void setImd(IMenusDao imd) {
		this.imd = imd;
	}
	/**
	 * ����ID�õ���ɫ��
	 * @param id
	 * @return
	 */
	public String getRoleNameById(int id) {
		return ird.getRoles(id).getRname();
	}
}
