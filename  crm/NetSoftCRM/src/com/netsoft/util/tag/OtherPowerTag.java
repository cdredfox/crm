package com.netsoft.util.tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.netsoft.dao.pojos.Menus;

/**
 * ����Ȩ�޹���ı�ǩ(����������ʾ���߲���ʾ���)
 * 
 * @author admin
 * 
 */
public class OtherPowerTag extends BodyTagSupport {
	// Ҫ�����ĸ�Ȩ�� ���
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
