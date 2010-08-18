package com.netsoft.util.tag;

/**
 *   标签说明：本标签功能主要是为来辅助分页。用来显示分页栏。解决在JSP页面生成繁琐
 *　　标签参数说明：page 当前页面
 *				 count 总页数
 *				 action 分页请求要提交到的控制器
 *				 valuename 分页传送页的变量名
 *　　标签版本：V1.0
 *	　标签作者/时间：杨飞/2006.11.17 　　　
 * 
 */

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrPage extends TagSupport {

	private int page; /** 当前页数 */
	private int count;/** 总记录数 */
	private String ajaxOn; /** 是否启用ajax分页 */
	private int pageSize;/** 每页显示的记录数 暂时只对AJAX起作用 */
	private String methodName; /** ajax分页后。数据处理的程序 */
	private String action; /** 要提交给谁 */
	private String valuename;/** 在Action端用来接受页面值的变量 */
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		 JspWriter out = pageContext.getOut();
		 StringBuffer sb=new StringBuffer();
		 if(ajaxOn.equals("false"))
		 {
		 sb.append("<script language='javascript'> function fun(){window.location.reload('"+action+"?"+valuename+"='+page.value);}</script>");
		 }
		 else
		 {
			 sb.append("<script language='javascript'> function fun(){"+methodName+"('page',"+pageSize+");}</script>");
		 }
		 sb.append("<table width='100%' border='0'><tr><td align='left'>");
		 sb.append("<select id='page' onchange='fun();'>");
		 for(int i=1;i<=count;i++)
		 {
			 if(i==page)
			 {
				 sb.append("<option value='"+i+"' selected='selected'>第"+i+"页</option>");
			 }else
			 {
				 sb.append("<option value='"+i+"'>第"+i+"页</option>");
			 }
		 }
		 sb.append("</select>");
		 sb.append("</td>");
		 sb.append("<td align='right'>");
		 if(ajaxOn.equals("false"))
		 {
		 sb.append("<a href='"+action+'?'+valuename+"=1'>第一页</a>   <a href='"+action+'?'+valuename+"="+(((page-1)<0)?count:(page-1))+"'>上一页</a>   <a href='"+action+'?'+valuename+"="+((page+1>count)?1:(page+1))+"'>下一页</a>   <a href='"+action+'?'+valuename+"="+count+"'>最未页</a>");
		 }else
		 {
			 sb.append("<TABLE cellSpacing=0 cellPadding=0 border=0><TBODY><TR vAlign=top>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick="+methodName+"(1,"+pageSize+",'page'); height=19 alt=第一页 src='/NetSoftCRM/images/first.gif' width=19></TD>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick=getTopPage("+pageSize+",'page'); height=19 alt=上一页 src='/NetSoftCRM/images/prev.gif' width=19></TD>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick=getNextPage("+pageSize+",'page'); height=19 alt=下一页 src='/NetSoftCRM/images/next.gif' width=19></TD>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick="+methodName+"("+count+","+pageSize+",'page'); height=19 alt=最未页 src='/NetSoftCRM/images/last.gif' width=19></TD>");
			 sb.append("</TR></TBODY></TABLE>");
			// sb.append("<a href=javascript:"+methodName+"(1,"+pageSize+",'page')><img src='/NetSoftCRM/images/first.gif' alt='第一页'/></a>   <a href=javascript:getTopPage("+pageSize+",'page')><img src='/NetSoftCRM/images/prev.gif' alt='上一页'/></a>    <a href=javascript:getNextPage("+pageSize+",'page')><img src='/NetSoftCRM/images/next.gif' alt='下一页'/></a>     <a href=javascript:"+methodName+"("+count+","+pageSize+",'page')><img src='/NetSoftCRM/images/last.gif' alt='最未页'/></a>");
		 }
		 sb.append("</td>");
		 sb.append("</tr>");
		sb.append("</table>");
		System.out.println(sb.toString());
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setValuename(String valuename) {
		this.valuename = valuename;
	}

	public String getAjaxOn() {
		return ajaxOn;
	}

	public void setAjaxOn(String ajaxOn) {
		this.ajaxOn = ajaxOn;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getAction() {
		return action;
	}

	public int getCount() {
		return count;
	}

	public int getPage() {
		return page;
	}

	public String getValuename() {
		return valuename;
	}

}
