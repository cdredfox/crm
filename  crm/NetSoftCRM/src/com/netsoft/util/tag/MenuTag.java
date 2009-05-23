package com.netsoft.util.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.netsoft.dao.beans.MenusBean;
import com.netsoft.dao.pojos.Menus;

public class MenuTag extends BodyTagSupport {
    private String listName;
    private String scope;
    private String role;//要取哪一大类的权限 0为全部 -1 为系统资源维护 -2 客户资源管理 -3 为综合查询管理
    Logger log=Logger.getLogger(this.getClass());
	@Override
	public int doStartTag() throws JspException { 
		JspWriter out = pageContext.getOut();
		List<Menus> topMenus=new ArrayList();
		try {
		 StringBuffer sb=new StringBuffer();
		 List<Menus> list=new ArrayList();
		 //检查作用域。取得放在作用域中的对象
		  if(scope.equals("session"))
		 {
		 list=(List) pageContext.getSession().getAttribute(listName);
		 }else
		 {
		 list=(List) pageContext.getRequest().getAttribute(listName); 
		 }

      sb.append("<table border='0' cellpadding='0' cellspacing='0' width='100%'>\n<div id='menu'>");
		  //取第一级菜单
      log.info("取得的菜单长度为："+list.size());
		 for (Menus menus : list) {
			log.info("第一个记录："+menus.getMtopId());
			if(Integer.parseInt(role)==0)
			{
			if(menus.getMtopId()<0)
			{
				topMenus.add(menus);
			}
			}else
			{
				if(menus.getMtopId()==Integer.parseInt(role))
				{
					topMenus.add(menus);
				}
			}
		} 
	//取第二级菜单
		 int i=1;
		 for (Menus menus : topMenus) {
			 sb.append("	<TR onmousedown=\"this.children[0].style.background='url(/NetSoftCRM/images/menuimages/menubg_level1_now.gif)';\" id=BarNumber"+i+" onClick=\"this.flag='true';showHideSubMenu();\" flagHasUrl='false' level='"+i+"' name='"+i+"'><TD onmouseover=menuMouseOver(this) style='BACKGROUND-IMAGE: url(/NetSoftCRM/images/menuimages/menubg_level1.gif); CURSOR: hand; HEIGHT: 20px; TEXT-ALIGN: center' onmouseout=menuMouseOut(this)>"+menus.getMname()+"</TD></TR>");
			 sb.append("\n");
			 log.info("父菜单："+menus.getMname());
			 for (Menus menus2 : list) {
				 log.info("list长度为: "+list.size());
				 log.info("子菜单编号:"+menus2.getMtopId()+" "+"父菜单编号:"+menus.getId());
				 log.info(menus2.getMtopId()==menus.getId());
				 if(menus2.getMtopId().equals(menus.getId()))
				{
					sb.append("		<TR style='DISPLAY: none' level='"+i+"'> <TD onmouseover=menuNextMouseOver(this) style='PADDING-LEFT: 28px; BACKGROUND-IMAGE: url(/NetSoftCRM/images/menuimages/menubg_level2.gif); CURSOR: hand; HEIGHT: 20px' onclick=\"doLink('/NetSoftCRM"+menus2.getMurl()+"','detail')\" onmouseout=menuNextMouseOut(this) flagNext='false'>"+menus2.getMname()+"</TD></TR>\n");
					log.info("子菜单："+menus2.getMname());
				}
			}
			 i=i+1;
		}
		 
		 sb.append("<script language=javascript> levelStatus=BarNumber"+(i-1)+"; showHideMenu(BarNumber"+(i-1)+");</script> </table>\n</div>");
		 log.info(sb.toString());
		 out.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return super.doStartTag();
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
