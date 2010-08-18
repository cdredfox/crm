<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="<%=request.getContextPath()%>/css/CSSForV10.css" type=text/css rel=stylesheet>
<STYLE type=text/css>.sbut {
	BORDER-RIGHT: #d6d3ce 1px solid; PADDING-RIGHT: 0px; BACKGROUND-POSITION: center center; BORDER-TOP: #d6d3ce 1px solid; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; BORDER-LEFT: #d6d3ce 1px solid; WIDTH: 20px; CURSOR: hand; PADDING-TOP: 0px; BORDER-BOTTOM: #d6d3ce 1px solid; BACKGROUND-REPEAT: no-repeat; HEIGHT: 20px
}
.main {
	BORDER-RIGHT: medium none; BORDER-TOP: medium none; BORDER-LEFT: medium none; BORDER-BOTTOM: medium none; HEIGHT: 100%; border-spacing: 1px
}
BODY {
	BACKGROUND: #70adde
}
</STYLE>

<SCRIPT language=javascript>
 function OpenWindows(strURL)
 {
 window.open (strURL,"_blank",
 "status=no,resizable=0,toolbar=no,status=no,menubar=no,scrollbars=no,width=500,height=500,left=150,top=100");
 } 
 function OpenWindowsCanShu(strURL)
 {
 window.open (strURL,"_blank",
 "status=no,resizable=0,toolbar=no,status=no,menubar=no,scrollbars=no,width=450,height=350,left=200,top=150");
 } 
function winOpen(url) 
 { 
 window.open(url, "", "directories=no,location=no,resizable=no,scrollbars=yes,left=230,top=170,menubar=no,width=450,height=400"); }
</SCRIPT>

<META content="MSHTML 6.00.2900.2912" name=GENERATOR></HEAD>
<BODY bottomMargin=2 leftMargin=4 topMargin=4 scroll=no rightMargin=4>
<TABLE class=ViewListLocal id=Table_HomeLeft1 cellSpacing=0 cellPadding=0 
width="100%" border=0>
  <TBODY>
  <TR vAlign=top>
    <TD align=middle width="100%" background=<%=request.getContextPath() %>/images/VOD_2001.gif 
    height=23></TD></TR>
  <TR vAlign=top>
    <TD class=Middle>
      <TABLE style="MARGIN-TOP: 8px" cellSpacing=0 cellPadding=0 width="96%" 
      align=center border=0>
        <TBODY>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu 
            href="http://weboa.haitiansoft.com/haitianoa/sms/sms_infor.asp" 
            target=detail>发送短信</A></TD></TR>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu 
            href="http://weboa.haitiansoft.com/haitianoa/calendar/LoadCalendar.asp?RiChengType=1" 
            target=detail>我的日程</A></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD width="100%" background=<%=request.getContextPath() %>/images/VOD_2002.gif 
height=23></TD></TR>
  <TR vAlign=top>
    <TD class=Middle>
      <TABLE style="MARGIN-TOP: 8px" cellSpacing=0 cellPadding=0 width="96%" 
      align=center border=0>
        <TBODY>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu 
            href="http://weboa.haitiansoft.com/haitianoa/information/OA_InforList.asp" 
            target=detail>资讯内容维护</A></TD></TR>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu 
            href="http://weboa.haitiansoft.com/haitianoa/information/OA_GongGaoList.asp" 
            target=detail>行政公告维护</A></TD></TR>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu 
            onclick="javascript:winOpen('VO_FunOrder.asp');" 
            href="javascript:void(0);">自定义快捷菜单</A></TD></TR>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu onClick="OpenWindows('MyInfor.asp')" 
            href="javascript:void(0);">个人信息设置</A></TD></TR>
        <TR vAlign=top>
          <TD class=menu_td width="9%"><IMG class=menu_icon1 
            src="<%=request.getContextPath() %>/images/k7.gif"></TD>
          <TD width="91%"><A class=menu 
            onclick="OpenWindowsCanShu('SA_SysPersonal.asp')" 
            href="javascript:void(0);">系统参数设置</A></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD background=<%=request.getContextPath() %>/images/VOD_2003.gif height=23></TD></TR>
  <TR vAlign=top>
    <TD>
      <TABLE style="MARGIN-TOP: 8px" cellSpacing=0 cellPadding=0 width="96%" 
      align=center border=0>
        <TBODY>
        <TR>
          <TD>
            <SCRIPT language=JavaScript 
            src="<%=request.getContextPath()%>/ToolsDetail.files/vote.htm"></SCRIPT>
          </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></BODY></HTML>
