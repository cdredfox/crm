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
			log.info("getAllRoles的长度为：" + role.size());
			for (Roles roles : role) {
				RolesBean rb = new RolesBean();
				BeanUtils.copyProperties(rb, roles);
				list.add(rb);
			}
			return list;
		} catch (Exception e) {
			log.error("RoleServices中getAllRoles方法出现异常了", e);
			return null;
		}
	}

	/** 修改角色状态。0有效 1无效 */
	public boolean changeStyle(int cid, int style) {
		try {
			if (style == 1) {
				ird.updateRdelStyleOnRoles(cid, 0);
			} else {
				ird.updateRdelStyleOnRoles(cid, 1);
			}
			return true;
		} catch (Exception e) {
			log.error("RoleServices中changeStyle方法出现异常了", e);
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
			log.error("RoleServices中getMenusByRole方法出现异常了", e);
			return null;
		}
	}

	/** 增加一个角色 */
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
			log.error("RoleServices中getMenusByRole方法出现异常了", e);
			return false;
		}

	}

	/** 根据角色ID删除一个角色 */
	public String delRoleById(int id) {
		try {
			Roles role=ird.getRoles(id);
			if(role.getEmidrs().size()>0)
			{
				return "当前角色不能被删除!请先将该角色下的员工先转移到其它角色上!";
			}
			 if(ird.deleteRolesById(Roles.class, id))
			 {
				 return "当前角色被成功删除";
			 }else
			 {
				 return "角色删除失败!未知错误";
			 }
		} catch (Exception e) {
			log.error("RoleServices中delRoleById方法出现异常了", e);
			return "角色删除时发生异常,请联系相关的系统人员!";
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
			log.error("修改角色权限时出错了!",e);
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
	 * 根据ID得到角色名
	 * @param id
	 * @return
	 */
	public String getRoleNameById(int id) {
		return ird.getRoles(id).getRname();
	}
}
