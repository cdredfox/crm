package com.netsoft.util.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.netsoft.dao.pojos.Menus;

/**
 * 特殊权限管理的标签(用来管理显示或者不显示组件)
 * 
 * @author admin
 * 
 */
public class OtherPowerTag extends BodyTagSupport {
	// 要管理哪个权限 编号
	public String mid;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		List<Menus> list = (List) pageContext.getSession().getAttribute("list");
		for (Menus menu : list) {
			if (mid.equals(String.valueOf(menu.getId()))) {
				return super.doStartTag();
			}
		}
		return this.SKIP_BODY;
	}
}
