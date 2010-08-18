<%@ taglib prefix="role" uri="/WEB-INF/tags/menus.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	
	<script language='javascript'>
	function check() {
		return true;
	}
	
</script>
	<SCRIPT LANGUAGE=javascript>
<!--
function selall(role)
{
	var obj=document.getElementsByName(role);
	var i=obj.length;
	for(j=0;j<i;j++)
	{
		obj[j].checked="checked";
	}
}
function self(role)
{
	var obj=document.getElementsByName(role);
	var i=obj.length;
	for(j=0;j<i;j++)
	{
		obj[j].checked=false;
	}
}
//-->
</SCRIPT>

	<body>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					[ 用户角色权限修改 ]
				</td>
			</tr>
		</table>
		<br>
		<html:form action="/role?method=modiRole">
			<table cellspacing=1 cellpadding=0 border=0 id=bgtable width=100%
				align=center>
				<tr>
					<td id=bgtitle colspan=2 align=center>
						用户角色权限修改
						<html:hidden property="id" value="${id}"/>
					</td>
				</tr>

				<tr>
					<td id=bgtitle width=120>
						角色名称：
					</td>
					<td id=bgbody>
						<html:text property="rname" styleClass="myinput" value="${name}" readonly="true"></html:text>
					</td>
				</tr>
				<role:roleinit listName="menulist" scope="session" role="-1">${id}</role:roleinit>
				<role:roleinit listName="menulist" scope="session" role="-2">${id}</role:roleinit>
				<role:roleinit listName="menulist" scope="session" role="-3">${id}</role:roleinit>
				<role:roleinit listName="menulist" scope="session" role="-4">${id}</role:roleinit>
				<table cellspacing=1 cellpadding=0 border=0 id=bgtable width=100%
					align=center>
					<tr>
						<td id=bgtitle colspan=6 align=center id=bgbody>
							<html:submit styleClass="mybutton" value="确认修改角色的权限"></html:submit>
						</td>
					</tr>
				</table>
		</html:form>
	</body>
</html>
