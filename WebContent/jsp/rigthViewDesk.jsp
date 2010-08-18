<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/myjs.js"></SCRIPT>
<LINK href="<%=request.getContextPath()%>/css/calStyles.css" rel=stylesheet>
<SCRIPT language=javascript>
function go2DV(day,month,year)
{
window.location.href ="#"}
</SCRIPT>

<STYLE>.menu {
	BORDER-RIGHT: #a0c6e5 1px solid; BORDER-TOP: #a0c6e5 1px solid; BORDER-LEFT: #a0c6e5 1px solid; BORDER-BOTTOM: #a0c6e5 1px solid
}
BODY {
	BORDER-RIGHT: 0px solid; BORDER-TOP: 0px solid; BACKGROUND: #eff7ff; BORDER-LEFT: 0px solid; CURSOR: default; BORDER-BOTTOM: 0px solid
}
</STYLE>
<SCRIPT src="<%=request.getContextPath() %>/js/date.js">
</SCRIPT>
<SCRIPT language=javascript>
function v(e){
	e.bgColor = "#ffffff";
	e.style.borderColor = "#00557D";
}
function d(e){
	e.bgColor = "";
	e.style.borderColor = "a0c6e5";
}

function fload(){
alert("ok");
  fPopCalendar(document.all.txt1, document.all.txt1);
}
</SCRIPT>

<META content="MSHTML 6.00.2900.2912" name=GENERATOR></HEAD>
<BODY leftMargin=3 topMargin=3 scroll=no onload="fload();">
<CENTER><INPUT id=date type=hidden name=date> <INPUT id=month type=hidden 
name=month> <INPUT id=day type=hidden name=day> <INPUT id=year type=hidden 
name=year> 
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD vAlign=top align=middle width="100%">
      <TABLE cellSpacing=0 cellPadding=5 width=170 border=0>
        <TBODY>
        <TR>
          <TD vAlign=top align=middle><!--小日历-->
            <TABLE cellSpacing=0 cellPadding=0 width=156>
              <TBODY>
              	 <tr>
              	 	<td><jsp:include page="/jsp/showDate.htm"/></td>
              	 </tr>
             </TBODY></TABLE></TD></TR>
              <TR>
                <TD align=middle width="100%" colSpan=2>
                  <TABLE cellSpacing=0 cellPadding=2 width="100%">
                    <TBODY>
                    <TR>
                      <TD noWrap align=middle height=19>今天是： 1月6日 星期六&nbsp; 
                        <IMG height=5 src="<%=request.getContextPath()%>/images/space.gif" 
                        width=5> </TD></TR></TBODY></TABLE></TD></TR></tr></FORM></TBODY></TABLE><!--小日历--></TD></TR>
        <TR>
          <TD vAlign=top>
            <TABLE class=box cellSpacing=0 cellPadding=2 width="100%" 
              border=0><TBODY>
              <TR class=boxHd>
                <TD noWrap width="100%" colSpan=2>
                  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD align=left width="99%"><IMG alt=提醒 hspace=2 
                        src="<%=request.getContextPath()%>/images/task_icon.gif" 
                        border=0>&nbsp;今日日程</TD>
                      <TD align=right width="1%"><IMG id=taskicon 
                        style="CURSOR: hand" 
                        onclick="&#13;&#10;var testArray = new Array(1,taskicon,document.all.task); &#13;&#10;showHideD(testArray,'<%=request.getContextPath()%>'); " 
                        alt=单击以折叠提醒框 hspace=2 
                        src="<%=request.getContextPath()%>/images/BttnCllps.gif" 
                        align=absMiddle border=0 name=taskicon> 
                  </TD></TR></TBODY></TABLE></TD></TR>
              <TR id=task name="task">
                <TD colSpan=2>
                  <TABLE cellSpacing=3 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD vAlign=top noWrap align=middle>11:00</TD>
                      <TD vAlign=top width="100%"><A 
                        href="http://weboa.haitiansoft.com/haitianoa/Calendar/calendarmain.asp?VOID=1&amp;RiChengType=1" 
                        target=detail>讨论 OA 系统实施问题！ 
                  (工作流部分实施计划)</A></TD></TR></TBODY></TABLE></TD></TR>
              <TR>
                <TD noWrap width="100%" colSpan=2>
                  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD style="BORDER-TOP: #93bee2 1px solid" noWrap 
                      align=left></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD vAlign=top>
            <TABLE class=box cellSpacing=0 cellPadding=2 width="100%" 
              border=0><TBODY>
              <TR class=boxHd>
                <TD noWrap width="100%" colSpan=2>
                  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD align=left width="99%"><IMG alt=图片 hspace=2 
                        src="<%=request.getContextPath()%>/images/task_icon.gif" 
                        border=0>&nbsp;<A 
                        onclick="window.open('MyTuPian.asp','Photo','width=350,height=325,left=450,top=200,scrollbars=no, resizable=no,maxnimize=no')" 
                        href="javascript:void(0);">我的显示图片</A></TD>
                      <TD align=right width="1%"><IMG id=taskicon1 
                        style="CURSOR: hand" 
                        onclick="&#13;&#10;var testArray = new Array(1,taskicon1,document.all.task1); &#13;&#10;showHideD(testArray,'<%=request.getContextPath()%>'); " 
                        alt=单击以折叠 hspace=2 
                        src="<%=request.getContextPath()%>/images/BttnCllps.gif" 
                        align=absMiddle border=0 name=taskicon1> 
                  </TD></TR></TBODY></TABLE></TD></TR>
              <TR id=task1 name="task1">
                <TD colSpan=2>
                  <TABLE cellSpacing=3 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD vAlign=center noWrap align=middle colSpan=2><IMG 
                        height=165 alt=图片 
                        src="#" 
                        width=135> </TD></TR></TBODY></TABLE></TD></TR>
              <TR>
                <TD noWrap width="100%" colSpan=2>
                  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                      <TD style="BORDER-TOP: #93bee2 1px solid" noWrap 
                      align=left></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></CENTER></BODY></HTML>
