package com.netsoft.util.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.netsoft.dao.imp.MenusDao;
import com.netsoft.dao.imp.RolesDao;
import com.netsoft.dao.intf.IMenusDao;
import com.netsoft.dao.intf.IRolesDao;
import com.netsoft.dao.pojos.Menus;

/*
 * 角色增加，维护显示权限表格
 */
public class RoleInitTag extends BodyTagSupport {

	private String listName;
	private String scope;
	private String role;// 要取哪一大类的权限 0为全部 -1 为系统资源维护 -2 客户资源管理 -3 为综合查询管理 -4
						// 为其它特殊权限(即控制到组件的权限)
	Logger log = Logger.getLogger(this.getClass());

	@Override
	public int doEndTag() throws JspException {
		String body = this.getBodyContent() == null ? "" : this
				.getBodyContent().getString();
		JspWriter out = pageContext.getOut();
		List<Menus> topMenus = new ArrayList();
		List<Menus> owenList = null;
		// 取该用户的权限
		if (body != null && !"".equals(body)) {
			log.info("标签体中有内容.....");
			log.info("内容是：" + body);
			owenList = (List<Menus>) pageContext.getRequest().getAttribute(
					"rolelist");
		}
		try {
			StringBuffer sb = new StringBuffer();
			List<Menus> list = new ArrayList();
			// 检查作用域。取得放在作用域中的对象
			if (scope.equals("session")) {
				list = (List) pageContext.getSession().getAttribute(listName);
			} else {
				list = (List) pageContext.getRequest().getAttribute(listName);
			}
			sb
					.append("<table  cellspacing=1 cellpadding=0 border=0 id=bgtable width=100% align=center><tr><td id=bgtitle colspan=2 align=center>");
			if ("-1".equals(role)) {
				sb.append("系统资源维护");
			} else if ("-2".equals(role)) {
				sb.append("客户资源管理");
			} else if ("-3".equals(role)) {
				sb.append("综合查询管理");
			} else if ("-4".equals(role)) {
				sb.append("其它特殊权限管理");
			}
			for (Menus menus : list) {

				if (menus.getMtopId() == Integer.parseInt(role)) {
					topMenus.add(menus);
				}
			}
			// 取第二级菜单
			int i = 1;
			for (Menus menus : topMenus) {
				sb.append("</td></tr><tr><td width=80 id=bgbody align=left>")
						.append(menus.getMname()).append(
								"</td><td id=bgbody align=left width=700>");
				log.info("父菜单：" + menus.getMname());
				for (Menus menus2 : list) {
					if (menus2.getMtopId().equals(menus.getId())) {
						if (owenList == null || owenList.size() <= 0) {

							sb.append(
									"<input type='checkbox' name='rmidptables"
											+ role.substring(1) + "' value='"
											+ menus2.getId() + "'>&nbsp;")
									.append(menus2.getMname());
						} else {
							boolean flag = false;// 初始标志
							for (Menus menus3 : owenList) {
								// 循环显示已有权限
								// log.info(menus2.getId()+":"+menus2.getMname()+"==="+menus3.getId()+":"+menus3.getMname());
								// log.info(menus2.getId()==menus3.getId());
								// log.info(menus2.getId().equals(menus3.getId()));
								// log.info(String.valueOf(menus2.getId()).equals(String.valueOf(menus3.getId())));
								if (menus2.getId().equals(menus3.getId())) {
									flag = true;
									break;
								}
							}
							if (!flag) {
								sb.append(
										"<input type='checkbox' name='rmidptables"
												+ role.substring(1)
												+ "' value='" + menus2.getId()
												+ "'>&nbsp;").append(
										menus2.getMname());
							} else {
								sb.append(
										"<input type='checkbox' checked=checked name='rmidptables"
												+ role.substring(1)
												+ "' value='" + menus2.getId()
												+ "'>&nbsp;").append(
										menus2.getMname());
							}
						}
					}
				}
				sb.append("</td></tr>");
			}

			sb
					.append("<tr><td colspan=6 id=bgbody><input type=button value=全选 onclick=selall('rmidptables"
							+ role.substring(1)
							+ "') class=mybutton><input type=button value=反选 class=mybutton onclick=self('rmidptables"
							+ role.substring(1) + "') ></td></tr></table>");
			log.info(sb.toString());
			out.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
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
