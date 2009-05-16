<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0052)http://weboa.haitiansoft.com/haitianoa/toolsmain.asp -->
<HTML><HEAD>
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/main.js"></SCRIPT>

<SCRIPT language=JavaScript>
<!--
var menu_scroll=null;//菜单滚动项
function init()
{
	menu_scroll=BarMenu;//菜单滚动项
}
//--></SCRIPT>

<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="<%=request.getContextPath()%>/css/main1.css" type=text/css rel=stylesheet><LINK 
href="<%=request.getContextPath()%>/css/style.css" type=text/css rel=stylesheet><LINK 
href="<%=request.getContextPath()%>/css/table.css" type=text/css rel=stylesheet>
<SCRIPT language=JavaScript>
function setstyle(d)
{
 switch (d)
 {
case 1: 
	b1.className="butdown-s"; 
	b2.className="but-s"; 
	b3.className="but-s"; 
	break;
case 2:
	b1.className="but-s"; 
	b2.className="butdown-s"; 
	b3.className="but-s"; 
	break;
case 3:
	b1.className="but-s"; 
	b2.className="but-s"; 
	b3.className="butdown-s"; 
	break;
}
}
function mover(id){
var id;
if(id.className=="sbut")
id.className="but-s";
}
function mout(id){
var id;
if(id.className=="but-s")
id.className="but-s";
}
function show(url,w,h,t,l,s){
window.open(url,"","width="+w+",height="+h+",resizable=0,top="+t+",left="+l+",toolbar=no,status=no, menubar=no, scrollbars="+s+", resizable=no, location=no, status=no");
}
</SCRIPT>

<META content="MSHTML 6.00.2900.2912" name=GENERATOR></HEAD>
<BODY oncontextmenu="return true" onselectstart="return false" 
onkeydown="if((event.ctrlKey)||(event.keyCode==116)){event.keyCode=0;return false}" 
ondragstart="return false" text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0 
onload=init() scrolling="no">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD height="100%"><IFRAME id=BarMenu border=0 name=BarMenu marginWidth=0 
      frameSpacing=0 marginHeight=0 src="<%=request.getContextPath()%>/jsp/${menus==null?'ToolsDetail.jsp':'menu.jsp'}" 
      frameBorder=0 noResize width="100%" scrolling=no height="100%" 
      vspale="0"></IFRAME></TD></TR>
  <TR>
    <TD vAlign=bottom align=right background=<%=request.getContextPath()%>/images/menubg.gif 
    height=23><IMG onmouseup=movover();movstar(-5,2) 
      onmousedown=movover();movstar(-10,2) onmouseover=movstar(-5,2) 
      style="MARGIN-TOP: 2px; CURSOR: hand" onmouseout=movover() height=17 
      src="<%=request.getContextPath()%>/images/menu_pageup.gif" width=18 border=0 ;>&nbsp;<IMG 
      onmouseup=movover();movstar(5,2) onmousedown=movover();movstar(10,2) 
      onmouseover=movstar(5,2) style="MARGIN-TOP: 2px; CURSOR: hand" 
      onmouseout=movover() height=17 src="<%=request.getContextPath()%>/images/menu_pagedown.gif" 
      width=18 border=0 ;>&nbsp;</TD></TR></TBODY></TABLE></BODY></HTML>