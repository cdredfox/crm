<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
	</head>
	<br>
	<BODY text='#000000' topmargin=0>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					[基础业务配置信息修改]
				</td>
			</tr>
		</table>
		<SCRIPT ID=clientEventHandlersJS LANGUAGE=javascript>
<!--    
function check() {    
	if(document.forms[0].rulevalue.value=="")
	{
		alert("折合数字不能为空,请填写!");
		return false;
	}
	if(isNaN(document.forms[0].rulevalue.value)==true)
	{
		alert("请输入数字值!");
		return false;
	}
	return true;
}    
//-->
</SCRIPT>
	<html:form action="/rule?method=updateRule" onsubmit="return check();">
			<html:hidden property="ruleid" value="${bb.ruleid}"/>
			<html:hidden property="rulecode" value="${bb.rulecode}"/>
			<html:hidden property="rulenote" value="${bb.rulenote}"/>
			<div align=center>
				<table cellspacing=1 cellpadding=0 border=0 id=bgtable>
					<TR>
						<TD id=bgtitle align=center colSpan=6>
							基础业务配置信息修改
						</TD>
					</TR>
					<TR>
						<TD id=bgtitle align=center>
							名&nbsp;&nbsp;&nbsp;&nbsp;称
						</TD>
						<TD id=bgbody>
							${bb.rulecode}
						</TD>
						<TD id=bgtitle align=center>
							折合数字
						</TD>
						<TD id=bgbody>
							<html:text property="rulevalue" value="${bb.rulevalue}" maxlength="10" size="5" styleClass="myinput"></html:text>
						</TD>
							
						<td id=bgtitle>
							说&nbsp;&nbsp;&nbsp;&nbsp;明
						</td>
						<td id=bgbody>
						${bb.rulenote}
						</td>
					</TR>
					<TR>
						<TD id=bgtitle align=center colSpan=6>
							<html:submit value="确定修改" styleClass="mybutton"></html:submit>
						</TD>
					</TR>
				</table>
			</div>
		</html:form>
	</BODY>
</html>
