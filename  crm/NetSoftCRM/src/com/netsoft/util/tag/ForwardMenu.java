package com.netsoft.util.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ForwardMenu extends BodyTagSupport {
    private String menuname;
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			StringBuffer sb=new StringBuffer();
			sb.append(menuname);
			out.print(sb.toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		    try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		
		return super.doStartTag();
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

}
