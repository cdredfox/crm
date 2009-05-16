package com.netsoft.util.tag;

/**
 *   ��ǩ˵��������ǩ������Ҫ��Ϊ��������ҳ��������ʾ��ҳ���������JSPҳ�����ɷ���
 *������ǩ����˵����page ��ǰҳ��
 *				 count ��ҳ��
 *				 action ��ҳ����Ҫ�ύ���Ŀ�����
 *				 valuename ��ҳ����ҳ�ı�����
 *������ǩ�汾��V1.0
 *	����ǩ����/ʱ�䣺���/2006.11.17 ������
 * 
 */

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class CurrPage extends TagSupport {

	private int page; /** ��ǰҳ�� */
	private int count;/** �ܼ�¼�� */
	private String ajaxOn; /** �Ƿ�����ajax��ҳ */
	private int pageSize;/** ÿҳ��ʾ�ļ�¼�� ��ʱֻ��AJAX������ */
	private String methodName; /** ajax��ҳ�����ݴ���ĳ��� */
	private String action; /** Ҫ�ύ��˭ */
	private String valuename;/** ��Action����������ҳ��ֵ�ı��� */
	
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
				 sb.append("<option value='"+i+"' selected='selected'>��"+i+"ҳ</option>");
			 }else
			 {
				 sb.append("<option value='"+i+"'>��"+i+"ҳ</option>");
			 }
		 }
		 sb.append("</select>");
		 sb.append("</td>");
		 sb.append("<td align='right'>");
		 if(ajaxOn.equals("false"))
		 {
		 sb.append("<a href='"+action+'?'+valuename+"=1'>��һҳ</a>   <a href='"+action+'?'+valuename+"="+(((page-1)<0)?count:(page-1))+"'>��һҳ</a>   <a href='"+action+'?'+valuename+"="+((page+1>count)?1:(page+1))+"'>��һҳ</a>   <a href='"+action+'?'+valuename+"="+count+"'>��δҳ</a>");
		 }else
		 {
			 sb.append("<TABLE cellSpacing=0 cellPadding=0 border=0><TBODY><TR vAlign=top>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick="+methodName+"(1,"+pageSize+",'page'); height=19 alt=��һҳ src='/NetSoftCRM/images/first.gif' width=19></TD>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick=getTopPage("+pageSize+",'page'); height=19 alt=��һҳ src='/NetSoftCRM/images/prev.gif' width=19></TD>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick=getNextPage("+pageSize+",'page'); height=19 alt=��һҳ src='/NetSoftCRM/images/next.gif' width=19></TD>");
			 sb.append("<TD vAlign=center width='26%'><IMG class=icon0 id=ImgFirstPage style='MARGIN-LEFT: 4px' onclick="+methodName+"("+count+","+pageSize+",'page'); height=19 alt=��δҳ src='/NetSoftCRM/images/last.gif' width=19></TD>");
			 sb.append("</TR></TBODY></TABLE>");
			// sb.append("<a href=javascript:"+methodName+"(1,"+pageSize+",'page')><img src='/NetSoftCRM/images/first.gif' alt='��һҳ'/></a>   <a href=javascript:getTopPage("+pageSize+",'page')><img src='/NetSoftCRM/images/prev.gif' alt='��һҳ'/></a>    <a href=javascript:getNextPage("+pageSize+",'page')><img src='/NetSoftCRM/images/next.gif' alt='��һҳ'/></a>     <a href=javascript:"+methodName+"("+count+","+pageSize+",'page')><img src='/NetSoftCRM/images/last.gif' alt='��δҳ'/></a>");
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
