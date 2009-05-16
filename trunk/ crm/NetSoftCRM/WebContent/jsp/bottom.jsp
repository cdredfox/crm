<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>底部边栏</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
title=style href="<%=request.getContextPath()%>/css/style.css" type=text/css rel=stylesheet>
<STYLE>BODY {
	COLOR: #104a7b
}
</STYLE>

<SCRIPT language=javascript>

var MenuIsShow=true;
var ToolIsShow=true;
function ShowHideMenu()
{
	if(MenuIsShow)
		{
		parent.frames.frmMenu.cols="0,*";
		MenuIsShow=false;
		}
	else
		{
		parent.frames.frmMenu.cols="135,*";
		MenuIsShow=true;
		}
}
function ShowHideTool()
{
	if(ToolIsShow)
		{
		parent.frames.frmTool. rows="0,*,25,0,0";
		ToolIsShow=false;
		}
	else
		{
		parent.frames.frmTool. rows="46,*,25,0,0";
		ToolIsShow=true;
		}
}


</SCRIPT>

<META content="MSHTML 6.00.2900.2912" name=GENERATOR></HEAD>
<BODY leftMargin=0 background=<%=request.getContextPath()%>/images/bbg.gif topMargin=2  marginheight="0" marginwidth="0" onload="getMessage(${Employees.id});"><!--显示提示框-->
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD vAlign=center noWrap align=left width=146 height=25>
      <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD vAlign=center noWrap align=left><FONT 
            color=#104a7b>&nbsp;当前用户：${Employees.ename}</FONT></TD>
          <TD vAlign=center noWrap align=left height="100%">&nbsp;<FONT 
            color=#104a7b>&nbsp;本次登录时间：12 时 27 分 </FONT></TD></TR></TBODY></TABLE></TD>
    <TD vAlign=center noWrap align=right><FONT color=#104a7b>系统消息：</FONT></TD>
    <TD id="shortMsg" vAlign=center noWrap align=left width=160 ></TD>
    <TD vAlign=center noWrap align=right><FONT color=#104a7b>邮件：</FONT></TD>
    <TD id=email vAlign=center noWrap align=left width=25 name="email"></TD>
    <TD vAlign=center noWrap align=right><FONT color=#104a7b>系统信息：</FONT></TD>
    <TD vAlign=center noWrap align=left width=180>
      <MARQUEE id=information onmouseover=this.stop(); dataFormatAs=html 
      style="DISPLAY: none; WIDTH: 100%; COLOR: #ffffff" 
      onmouseout=this.start(); scrollAmount=2 scrollDelay=1 height=8 
      scroll> 
      <span>
      <FONT color=#104A7B face='Wingdings 2'>8</FONT>&nbsp;<a href='#' target='detail'>待办理的流程申请：<font color=104A7B>5</font></a>&nbsp;&nbsp;<FONT color=#104A7B face='Wingdings 2'>8</FONT>&nbsp;<a href='Task/TaskCurrentDay.asp?Menu=1' target='detail'>当前任务：<font color=104A7B>1</font>件</a>
      </span>
      </MARQUEE>
      </TD></TR></TBODY></TABLE>
</BODY></HTML>