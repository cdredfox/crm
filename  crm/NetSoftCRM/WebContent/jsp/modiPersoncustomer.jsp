<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<HEAD>
		<TITLE>修改个人客户</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=GBK">
		<LINK href="<%=request.getContextPath()%>/css/base.css" type=text/css rel=stylesheet>
		<STYLE>
		.P_LB { PADDING-LEFT: 5px; FONT-WEIGHT: bold; WIDTH: 100px; COLOR: 
#333333; LETTER-SPACING: 1px } 
		.P_NL { } 
		.ip_text { BORDER-RIGHT: #cccccc 1px 
solid; PADDING-RIGHT: 0px; BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 0px; 
PADDING-BOTTOM: 0px; BORDER-LEFT: #cccccc 1px solid; WIDTH: 150px; PADDING-TOP: 
0px; BORDER-BOTTOM: #cccccc 1px solid; HEIGHT: 20px } 
		.ip_textarea { BORDER-
RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; OVERFLOW-Y: auto; 
BORDER-LEFT: #cccccc 1px solid; WIDTH: 100%; BORDER-BOTTOM: #cccccc 1px solid; 
HEIGHT: 100px } .title { PADDING-LEFT: 8px; FONT-WEIGHT: bold; VERTICAL-ALIGN: 
baseline; WIDTH: 100%; COLOR: #ca1313; BACKGROUND-REPEAT: repeat-x; HEIGHT: 
20px; BACKGROUND-COLOR: #e6e7e8 } .title FONT { DISPLAY: inline; FONT-SIZE: 
12px; WIDTH: 100%; FONT-FAMILY: "Tahoma"; LETTER-SPACING: 3px } .data_list_thead 
{ TABLE-LAYOUT: fixed; PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 
3px; COLOR: #000000; PADDING-TOP: 3px; HEIGHT: 22px; BACKGROUND-COLOR: #adceed } 
.formTable TD { PADDING-LEFT: 4px } .formTable TR { FONT-SIZE: 12px } .TBL_A { 
BACKGROUND-COLOR: #ffffff } .TBL_B { BACKGROUND-COLOR: #ecf3f9 } .data_list_foot 
TD { BACKGROUND-COLOR: #bcd0eb } .data_list_query { BACKGROUND-COLOR: #f4f1eb } 
BUTTON { BORDER-RIGHT: #485984 2px solid; PADDING-RIGHT: 2px; BORDER-TOP: 
#89acf0 2px solid; PADDING-LEFT: 2px; FONT-SIZE: 9pt; BORDER-LEFT-COLOR: 
#89acf0; PADDING-BOTTOM: 0px; CURSOR: hand; COLOR: #ffffff; BORDER-BOTTOM: 
#485984 2px solid; FONT-FAMILY: "宋体"; BORDER-LEFT-STYLE: solid; LETTER-
SPACING: 1px; HEIGHT: 20px; BACKGROUND-COLOR: #6980bc } .app-jwin-page-bgcolor { 
PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px } 
.app-jwin-table { BORDER-RIGHT: #cccccc 1px solid; TABLE-LAYOUT: fixed; BORDER-
TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; WIDTH: 300px; BORDER-
BOTTOM: #cccccc 1px solid; HEIGHT: 100%; BACKGROUND-COLOR: #edf2fc } .app-jwin-
header { PADDING-RIGHT: 3px; PADDING-LEFT: 3px; FONT-WEIGHT: normal; BACKGROUND-
images: url(<%=request.getContextPath()%>/images/bg2.gif); PADDING-BOTTOM: 2px; VERTICAL-ALIGN: bottom; COLOR: 
#5e656e; PADDING-TOP: 2px; BACKGROUND-REPEAT: repeat-x; LETTER-SPACING: 4px; 
BACKGROUND-COLOR: #0148b2 } .app-jwin-header-2 { PADDING-RIGHT: 3px; PADDING-
LEFT: 3px; FONT-WEIGHT: normal; BACKGROUND-images: url(<%=request.getContextPath()%>/images/bg2.gif); PADDING-
BOTTOM: 2px; VERTICAL-ALIGN: bottom; COLOR: #5e656e; PADDING-TOP: 2px; 
BACKGROUND-REPEAT: repeat-x; LETTER-SPACING: 4px; BACKGROUND-COLOR: #0148b2 } 
.app-jwin-body { PADDING-RIGHT: 5px; OVERFLOW-Y: auto; PADDING-LEFT: 5px; 
PADDING-BOTTOM: 5px; PADDING-TOP: 5px; HEIGHT: 100% } A:link { COLOR: #003399; 
TEXT-DECORATION: none } A:visited { COLOR: #003399; TEXT-DECORATION: none } 
A:hover { COLOR: #ff9900; TEXT-DECORATION: underline } .table_head { TABLE-
LAYOUT: fixed; PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 3px; 
COLOR: white; PADDING-TOP: 3px; BACKGROUND-COLOR: #8caae6 } .data_list_query TD 
{ FONT-WEIGHT: bold } FIELDSET { BORDER-RIGHT: #dddddd 1px solid; BORDER-TOP: 
#dddddd 1px solid; BORDER-LEFT: #dddddd 1px solid; BORDER-BOTTOM: #dddddd 1px 
solid } FIELDSET TD { PADDING-LEFT: 4px } FIELDSET { PADDING-RIGHT: 5px; 
PADDING-LEFT: 5px; FONT-SIZE: 12px; PADDING-BOTTOM: 5px; PADDING-TOP: 5px; FONT-
FAMILY: Tahoma; LETTER-SPACING: 1px } LEGEND { FONT-SIZE: 14px; COLOR: #008000; 
LETTER-SPACING: 1px } </STYLE>
  <script type='text/javascript' src='/NetSoftCRM/dwr/interface/CustomerAjax.js'></script>
  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
  
<script type="text/javascript">
function GetDate ()
	{
	  reVal = window.showModalDialog("/NetSoftCRM/jsp/showDate.htm", '',
		"status:no;center:yes;scroll:no;resizable:no;help:no;dialogWidth:255px;dialogHeight:260px");
	
	  if (reVal != null)
	  {
	     document.forms[0].pbirthday.value=reVal;
	  }
	  }
	
	function winclose()
	{
		window.close();
	}
	
	function winsave(eid)
	{
		var id=document.forms[0].id.value;
	    var pname=document.forms[0].pname.value;
	    var eid=document.forms[0].eid.value;
	    var psex=document.forms[0].psex.value;
	    var pbirthday=document.forms[0].pbirthday.value;
	    var phonetel=document.forms[0].phonetel.value;
	    var paddress=document.forms[0].paddress.value;
	    var plike=document.forms[0].plike.value;
	    var ccredit=document.forms[0].ccredit.value;
	    var cremark=document.forms[0].cremark.value;
	    CustomerAjax.updatePersoncustomer(id,pname,psex, phonetel, paddress, eid, pbirthday,plike, ccredit, cremark,0);
	    opner.nowc(eid);
	    window.close();
	}
	</script>
	</HEAD>
	<BODY>
	<DIV id=WAMenuID style="PADDING-RIGHT: 3px; PADDING-LEFT: 5px; BACKGROUND-IMAGE: url(<%=request.getContextPath()%>/images/mb2.gif); PADDING-BOTTOM: 5px; WIDTH: 100%; PADDING-TOP: 3px; 
BACKGROUND-REPEAT: repeat-x; HEIGHT: 24px">
    <SPAN class=WAMenuItem title="" style="PADDING-RIGHT: 5px; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; COLOR: black; BORDER-TOP-STYLE: none; PADDING-TOP: 2px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-
STYLE: none; BACKGROUND-COLOR: transparent; BORDER-BOTTOM-STYLE: none" onclick="winsave('${Employees.id}');"
>
    <IMG src="<%=request.getContextPath()%>/images/save.gif" align=absBottom> 保存</SPAN>
    <SPAN class=WAMenuItem title="" style="PADDING-RIGHT: 5px; PADDING-LEFT: 5px; PADDING-
BOTTOM: 2px; COLOR: black; BORDER-TOP-STYLE: none; PADDING-TOP: 2px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BACKGROUND-COLOR: transparent; 
BORDER-BOTTOM-STYLE: none" onclick="winclose();"><IMG 
src="<%=request.getContextPath()%>/images/co_old2.gif" align=absBottom"> 关闭窗口</SPAN></DIV>
<html:form action="/personcustomer?method=update">
            <html:hidden property="id" value="${pc.id}"/>
			<TABLE cellPadding=3 width="100%">
				<TBODY>
				<TR>
					<TR>
						<td>
						客户姓名：
						</td>
						<TD>
							<html:text property="pname" styleClass="ip_text notnull" maxlength="50" value="${pc.pname}"></html:text>
						</TD>
					</TR>
					<TR>
						<TD>
							客户所属人：
						</TD>
						<TD>
						    <html:hidden property="eid" value="1"/>
							<html:text property="ename" styleClass="ip_text notnull" maxlength="50" value="${pc.ename}"></html:text>
						</TD>
						</tr>
					<TR>
						<TD>
							性别：
						</TD>
						<TD>
						    <html:select property="psex">
								<logic:equal value="1" name="pc" property="psex">
								<html:option value="1" style="BACKGROUND-COLOR: #cfeba5">男</html:option>
								<html:option value="0">女</html:option>
								</logic:equal>
								<logic:notEqual value="1" name="pc" property="psex">
								<html:option value="0" style="BACKGROUND-COLOR: #cfeba5">女</html:option>
								<html:option value="1">男</html:option>
								</logic:notEqual>
							</html:select>
						</TD>
						</tr>
						<TR>
						<TD>
							生日：
						</TD>
						<TD>
							<html:text property="pbirthday" readonly="true" styleClass="ip_text disabled" value="${pc.pbirthday}"></html:text>
							<IMG class=cp_date onclick="GetDate();" src="<%=request.getContextPath()%>/images/date.gif" align=absBottom>
						</TD>
					</TR>
					<tr>
						<TD>
							电话：
						</TD>
						<TD>
							<html:text property="phonetel" styleClass="ip_text notnull" maxlength="50" value="${pc.phonetel}"></html:text>
						</TD>
					</TR>
					<TR>
						<TD>
							地址：
						</TD>
						<TD>
							<html:text property="paddress" styleClass="ip_text notnull" maxlength="50" value="${pc.paddress}"></html:text>
						</TD>
					</TR>
					<TR>
						<TD>
							爱好：
						</TD>
						<TD>
							<html:text property="plike" styleClass="ip_text" maxlength="30" value="${pc.plike}"></html:text>
						</TD>
					</TR>
					<TR>
						<TD>
							信用评估：
						</TD>
						<TD>
							<html:text property="ccredit" styleClass="ip_text" maxlength="30" value="${pc.ccredit}"></html:text>
						</TD>
					</TR>
					<TR>
						<TD>
							备注：
						</TD>
						<TD>
						    <html:textarea property="cremark" rows="5" value="${pc.cremark}"></html:textarea>
						</TD>
					</TR>
					</TBODY>
			</TABLE>
		</html:form>
	</BODY>
</html>