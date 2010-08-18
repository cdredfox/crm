package com.netsoft.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.netsoft.dao.intf.IMenusDao;
import com.netsoft.dao.intf.IRolesDao;
import com.netsoft.dao.pojos.Menus;
import com.netsoft.dao.pojos.Roles;
import com.netsoft.services.intf.IMenusServices;
import com.netsoft.services.intf.IRoleServices;

public class MenusServices implements IMenusServices {
   private IRoleServices irs;
   private IRolesDao ird;
	Logger log=Logger.getLogger(this.getClass());
   private IMenusDao imd;
	/* (non-Javadoc)
	 * @see com.netsoft.services.imp.IMenusServices#delAllByRole(int, int[])
	 */
	public boolean delAllByRole(int rid,int[] menus)
	{
	try {
		Set mr=irs.getMenusByRole(rid);
		List<Menus> mrlist=new ArrayList();
		List<Menus> mrlist2=new ArrayList();
		
		mrlist.addAll(mr);
		log.info("本身长度为："+mrlist.size());
		log.info("数组长度为："+menus.length);
		
		for(int i=0;i<mrlist.size();i++)
		{
			for(int j=0;j<menus.length;j++)
			{
				if(mrlist.get(i).getId()==menus[j])
				{
					mrlist2.add(mrlist.get(i));
					break;
				}
			}
			}
		
		log.info("最终可删长度为："+mrlist2.size());
		mrlist.removeAll(mrlist2);
	    Roles role=ird.getRoles(rid);
	    role.getRmidptables().clear();
	    role.getRmidptables().addAll(mrlist);
	    log.info("角色中的长度为："+role.getRmidptables().size());
	    ird.updateRoles(role);
		return true;
	} catch (Exception e) {
		log.error("MenusServices中delAllByRole方法出现异常了",e);
		return false;
	}
	}
	
	/**增加权限给角色*/
	public boolean addAllByRole(Integer rid,Integer[] menus)
	{
		try {
			Set mr=irs.getMenusByRole(rid);
			List<Menus> mrlist=new ArrayList();
			List<Menus> mrlist2=new ArrayList();
			mrlist.addAll(mr);
			log.info("第一次权限长度为："+mrlist.size());
			for(int i=0;i<menus.length;i++)
			{
				mrlist.add(imd.getMenusById(menus[i]));
			}
			log.info("增加权限后长度为："+mrlist.size());
			 Roles role=ird.getRoles(rid);
			 role.getRmidptables().clear();
			 role.getRmidptables().addAll(mrlist);
			 log.info("角色中的长度为："+role.getRmidptables().size());
			 ird.updateRoles(role);
			return true;
		} catch (Exception e) {
			log.error("MenusServices中addAllByRole方法出现异常了",e);
			return false;
		}
		
	}
	
	
	
	
	public IRoleServices getIrs() {
		return irs;
	}
	public void setIrs(IRoleServices irs) {
		this.irs = irs;
	}
	public IRolesDao getIrd() {
		return ird;
	}
	public void setIrd(IRolesDao ird) {
		this.ird = ird;
	}

	public IMenusDao getImd() {
		return imd;
	}

	public void setImd(IMenusDao imd) {
		this.imd = imd;
	}

	/**根据TOPID取相应的菜单值*/
	public List getInitMenus(int mid) {
		return imd.getMenusByTopId(mid);
	}
	/**取得所有菜单*/
	public List getAllMenus(){
		return imd.getAllMenus();
	}
}
