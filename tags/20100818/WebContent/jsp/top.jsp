<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE></TITLE>
<STYLE>IMG.toolIcon {
	MARGIN-TOP: -2px; CURSOR: hand; MARGIN-RIGHT: 4px
}
#showMenu TD {
	FONT-SIZE: 9pt
}
.caidan0 {
	PADDING-RIGHT: 5px; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; CURSOR: hand; PADDING-TOP: 4px; TEXT-ALIGN: center
}
.caidan1 {
	BORDER-RIGHT: #336699 1px solid; PADDING-RIGHT: 4px; BORDER-TOP: #336699 1px solid; PADDING-LEFT: 4px; PADDING-BOTTOM: 2px; BORDER-LEFT: #336699 1px solid; CURSOR: hand; PADDING-TOP: 3px; BORDER-BOTTOM: #336699 1px solid; BACKGROUND-COLOR: #f3f3f3; TEXT-ALIGN: center
}
.caidan2 {
	BORDER-RIGHT: #336699 1px solid; PADDING-RIGHT: 4px; BORDER-TOP: #336699 1px solid; PADDING-LEFT: 4px; PADDING-BOTTOM: 2px; BORDER-LEFT: #336699 1px solid; CURSOR: hand; PADDING-TOP: 3px; BORDER-BOTTOM: #336699 1px solid; BACKGROUND-COLOR: #e9f2f8; TEXT-ALIGN: center
}
.caidan5 {
	PADDING-RIGHT: 5px; PADDING-LEFT: 5px; PADDING-BOTTOM: 1px; CURSOR: hand; PADDING-TOP: 1px; TEXT-ALIGN: center
}
.caidan6 {
	BORDER-RIGHT: 1px outset; PADDING-RIGHT: 4px; BORDER-TOP: 1px outset; PADDING-LEFT: 4px; BORDER-LEFT: 1px outset; CURSOR: hand; BORDER-BOTTOM: 1px outset; TEXT-ALIGN: center
}
.caidan7 {
	BORDER-RIGHT: 1px inset; PADDING-RIGHT: 4px; BORDER-TOP: 1px inset; PADDING-LEFT: 4px; BORDER-LEFT: 1px inset; CURSOR: hand; COLOR: #ff2200; BORDER-BOTTOM: 1px inset; TEXT-ALIGN: center
}
.LL {
	PADDING-LEFT: 1px
}
</STYLE>

<SCRIPT language=JavaScript>
<!-- 
function getCookieVal (offset) {
var endstr = document.cookie.indexOf (";", offset);
if (endstr == -1)
endstr = document.cookie.length;
return unescape(document.cookie.substring(offset, endstr));
}
function GetCookie (name) {
var arg = name + "=";
var alen = arg.length;
var clen = document.cookie.length;
var i = 0;
while (i < clen) {
var j = i + alen;
if (document.cookie.substring(i, j) == arg)
return getCookieVal (j);
i = document.cookie.indexOf(" ", i) + 1;
if (i == 0) break; 
}
return null;
} 
function SetCookie (name, value) {
var expdate = new Date ();
expdate.setTime (expdate.getTime() + (24 * 60 * 60 * 1000 * 31));
var argv = SetCookie.arguments;
var argc = SetCookie.arguments.length;
var expires = (argc > 2) ? argv[2] : null;
var path = (argc > 3) ? argv[3] : null;
var domain = (argc > 4) ? argv[4] : null;
var secure = (argc > 5) ? argv[5] : false;
document.cookie = name + "=" + escape (value) +
"; expires=" + expdate.toGMTString() +
((path == null) ? "" : ("; path=" + path)) +
((domain == null) ? "" : ("; domain=" + domain)) +
((secure == true) ? "; secure" : "");
}
// --></SCRIPT>

<SCRIPT language=javascript>
var menu_current="menu";
loadok = false;
var urlBasePath="";
//定义了打开规则
function menuOpen(url,id,type)
{
	if(id=="") id=null;
	if(menu_current!=-1&&type=="Menu")
		document.all(menu_current).className="caidan0";
	if(id==null)
	{
		var ob=window.event.srcElement;
		if(ob.tagName=="TD"){	
		}
		menu_current=ob.id;
		}
	else
		if(type=="Menu"){
		menu_current=id;
		document.all(menu_current).className="caidan2";	
		}
	//if(top.contents.document.getElementById("xinxipage").style.display=="block")
	//top.contents.showHideMenu();
		switch (url)
		{
		case "Menu":
			top.dir.location.href="menutool.jsp";
		//	top.detail.location.href="welcome.htm";
			break;
		case "left":
			top.dir.location.href="menutool.jsp";
		//	top.detail.location.href="welcome.htm";
			break;
		case "qq":
			top.dir.location.href="QQ.asp";
		//	top.detail.location.href="welcome.htm";
			break;
		case "max":
			fullscreen();
			break;
		case "min":
			restore();
			break;
		case "tool":
			top.dir.location.href="toolsmain.asp";
			break;
		case "web":
			top.bottom.MM_timelinePlay('Timeline1');
		//	top.detail.location.href="welcome.htm";
			break;
		case "back":
			history.back();
			break;
		case "forward":
			history.forward();
			break;
		case "refresh":
			top.location.reload();
			break;
		default:
			top.detail.location.href=url;
		}
	//if(hasUrl==1)
	//{	
	//	top.contents.new_date.loadLeftMenu(menu_current);	}
	//top.contents.new_date.levelStatus=null;
	//top.fraContent.cols="148,12,*";
	//top.fraConLeft.icon_left.src="images/close_left.gif";
	//top.frames.main.location.href="welcome.htm";		
}
function fullscreen(){
RemoveIEToolbar.ToolBar=0 
SetCookie("_myUserConfigMainIsFullScreen",0);
}
function OpenQQNew()
 {
 window.open ("QQ_Full.asp","_blank",
 "status=no,resizable=1,toolbar=no,status=no,menubar=no,scrollbars=no,width=60,height=60,left=200,top=200");
 }
function restore(){
RemoveIEToolbar.ToolBar=1 
SetCookie("_myUserConfigMainIsFullScreen",1);
}
function ScreenIsFull()
{
	CookieCurrentValue=GetCookie("_myUserConfigMainIsFullScreen");
	if(CookieCurrentValue!=null)
	{
	RemoveIEToolbar.ToolBar=CookieCurrentValue 
	}
	else
		RemoveIEToolbar.ToolBar=1 
}
function ShowMainStatus(){//Main：状态工作
	top.frmMenu.cols="0,0,*";
}
function ShowStatus(){//其它状态工作
	top.frmMenu.cols="160,12,*";
	top.fraConLeft.location.href="conLeft.jsp";
}
</SCRIPT>

<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.2912" name=GENERATOR></HEAD>
<BODY onselectstart="return false;" style="FONT-SIZE: 10pt" bgColor=#0870d3 
leftMargin=0 topMargin=0 onload=javascript:ScreenIsFull(); rightMargin=0>
<OBJECT id=RemoveIEToolbar codeBase=COM/nskey.dll height=1 width=1 
classid=CLSID:2646205B-878C-11d1-B07C-0000C040BCDB VIEWASTEXT><PARAM NAME="ToolBar" VALUE="1"></OBJECT>

<TABLE style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0 
width="100%" border=0>
  <TBODY>
  <TR height=58>
    <TD vAlign=top><IMG src="<%=request.getContextPath()%>/images/top/topbg.jpg" border=0></TD>
    <TD align=right><IMG src="<%=request.getContextPath()%>/images/top/banner_right.jpg" 
  border=0></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=2 width="100%" border=0>
  <TBODY>
  <TR>
    <TD id=showMenu background=<%=request.getContextPath()%>/images/top/btn_bg.gif>
      <TABLE height=17 cellPadding=0 width="100%" border=0 valign="center">
        <TBODY>
        <TR>
          <TD vAlign=center width=20>
            <DIV align=center><IMG src="<%=request.getContextPath()%>/images/top/topMenuLeft.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan1"' class=caidan0 
          onmousedown='this.className="caidan2"' 
          onmouseover='this.className="caidan1"' 
          onclick='javascript:ShowStatus();parent.dir.location.href="menutool.jsp?taget=menu&menuid=0"' 
          onmouseout='this.className="caidan0"' noWrap><IMG class=toolIcon 
            style="MARGIN-LEFT: 3px; MARGIN-RIGHT: 5px" 
            src="<%=request.getContextPath()%>/images/top/tool_img1.gif" align=absMiddle>全部功能</TD>
          
          <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan1"' class=caidan0 
          onmousedown='this.className="caidan2"' 
          onmouseover='this.className="caidan1"' 
          onclick='javascript:ShowStatus();parent.dir.location.href="menutool.jsp?taget=menu&menuid=-2"'
          onmouseout='this.className="caidan0"' noWrap><IMG class=toolIcon 
            style="MARGIN-LEFT: 3px; MARGIN-RIGHT: 5px" src="<%=request.getContextPath()%>/images/top/xz.gif" 
            align=absMiddle>&#23458;&#25143;&#36164;&#28304;</TD>
          <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan1"' class=caidan0 
          onmousedown='this.className="caidan2"' 
          onmouseover='this.className="caidan1"' 
          onclick='javascript:ShowStatus();parent.dir.location.href="menutool.jsp?taget=menu&menuid=-3"'
          onmouseout='this.className="caidan0"' noWrap><IMG class=toolIcon 
            style="MARGIN-LEFT: 3px; MARGIN-RIGHT: 5px" 
            src="<%=request.getContextPath()%>/images/top/LiuCheng.gif" align=absMiddle>&#38144;&#21806;&#31649;&#29702;</TD>
          <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan1"' class=caidan0 
          onmousedown='this.className="caidan2"' 
          onmouseover='this.className="caidan1"' 
         onclick='javascript:ShowStatus();parent.dir.location.href="menutool.jsp?taget=menu&menuid=-1"'
          onmouseout='this.className="caidan0"' noWrap><IMG class=toolIcon 
            style="MARGIN-LEFT: 3px; MARGIN-RIGHT: 5px" src="<%=request.getContextPath()%>/images/top/menu.gif" 
            align=absMiddle>&#31995;&#32479;&#36164;&#28304;</TD>
            
            <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan1"' class=caidan0 
          onmousedown='this.className="caidan2"' 
          onmouseover='this.className="caidan1"' 
          onclick='javascript:ShowStatus();parent.detail.location.href="../notebook.crm?method=getAll"'
          onmouseout='this.className="caidan0"' noWrap><IMG class=toolIcon 
            style="MARGIN-LEFT: 3px; MARGIN-RIGHT: 5px" 
            src="<%=request.getContextPath()%>/images/top/LiuCheng.gif" align=absMiddle>公司论坛</TD>
            
             <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan1"' class=caidan0 
          onmousedown='this.className="caidan2"' 
          onmouseover='this.className="caidan1"' 
          onclick='javascript:ShowStatus();parent.detail.location.href="../notebook.crm?method=showView&type=notebook"'
          onmouseout='this.className="caidan0"' noWrap><IMG class=toolIcon 
            style="MARGIN-LEFT: 3px; MARGIN-RIGHT: 5px" 
            src="<%=request.getContextPath()%>/images/top/LiuCheng.gif" align=absMiddle>公司留言本</TD>
            
          <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD noWrap width="100%"></TD>
          <TD vAlign=center width=20><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif">
            <DIV></DIV></TD>
          
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=a 
          onmouseover='this.className="caidan6"' title=我的工作台 
          onclick='menuOpen("desktop.jsp","a","icon");menuOpen("left","left","icon");' 
          onmouseout='this.className="caidan5"' noWrap><IMG class=face-a 
            src="<%=request.getContextPath()%>/images/top/099.gif" border=0></TD>
          
  
          <TD vAlign=center width=20><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif">
            <DIV></DIV></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=e 
          onmouseover='this.className="caidan6"' 
          onclick='menuOpen("back","e","icon")' 
          onmouseout='this.className="caidan5"' noWrap><IMG title=后退 
            src="<%=request.getContextPath()%>/images/top/HouTui.gif" border=0></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=d 
          onmouseover='this.className="caidan6"' 
          onclick='menuOpen("forward","d","icon")' 
          onmouseout='this.className="caidan5"' vAlign=center noWrap><IMG 
            title=前进 src="<%=request.getContextPath()%>/images/top/QianJin.gif" border=0></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=s 
          onmouseover='this.className="caidan6"' 
          onclick='menuOpen("refresh","s","icon")' 
          onmouseout='this.className="caidan5"' noWrap><IMG title=刷新 
            src="<%=request.getContextPath()%>/images/top/refresh.gif" border=0></TD>
          <TD vAlign=center width=20>
            <DIV align=center><IMG height=14 
            src="<%=request.getContextPath()%>/images/top/toolbar_group.gif"></DIV></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=qt 
          onmouseover='this.className="caidan6"' title=考勤签退 
          onclick='javascript:alert("该功能暂时未开通");' 
          onmouseout='this.className="caidan5"' noWrap><IMG 
            src="<%=request.getContextPath()%>/images/top/IEQianTui.gif" border=0></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=h 
          onmouseover='this.className="caidan6"' 
          onclick='menuOpen("min","h","icon")' 
          onmouseout='this.className="caidan5"' noWrap width=10><IMG alt=窗口还原 
            src="<%=request.getContextPath()%>/images/top/IERestore.gif" border=0></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=g 
          onmouseover='this.className="caidan6"' 
          onclick='menuOpen("max","g","icon")' 
          onmouseout='this.className="caidan5"' noWrap width=10><IMG alt=窗口最大化 
            src="<%=request.getContextPath()%>/images/top/IEMax.gif" border=0></TD>
          <TD onmouseup='this.className="caidan6"' class=caidan5 
          onmousedown='this.className="caidan7"' id=C 
          onmouseover='this.className="caidan6"' title=退出系统 
          onclick='javascript:ShowStatus();parent.location.href="/NetSoftCRM/login.crm?method=logout"' 
          onmouseout='this.className="caidan5"' noWrap width=10><IMG 
            src="<%=request.getContextPath()%>/images/top/IEquit.gif" 
  border=0></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<OBJECT id=HaiTianOA codeBase=COM/HaiTianOACOM.CAB#version=10,5,0,0 
classid=CLSID:D94C763A-FA05-4BB5-A33E-2D75977F302B></OBJECT></BODY></HTML>
