<%@ taglib prefix="role" uri="/WEB-INF/tags/menus.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<script language='javascript'>function check() {
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
function check()
{
    if(document.all("rname").value=="")
    {
       alert("角色名称不能为空！");
       document.all("rname").focus();
       return false;
    }
    return true;
}
//-->
</SCRIPT>

	<body>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					[ 用户角色增加 ]
				</td>
			</tr>
		</table>
		<br>
		<html:form action="/role?method=addRole" onsubmit="return check();">
			<table cellspacing=1 cellpadding=0 border=0 id=bgtable width=100%
				align=center>
				<tr>
					<td id=bgtitle colspan=2 align=center>
						用户角色增加
					</td>
				</tr>

				<tr>
					<td id=bgtitle width=120>
						角色名称：
					</td>
					<td id=bgbody>
						<html:text property="rname" styleClass="myinput" size="60"></html:text>
					</td>
				</tr>
				<role:roleinit listName="menulist" scope="session" role="-1"></role:roleinit>
				<role:roleinit listName="menulist" scope="session" role="-2"></role:roleinit>
				<role:roleinit listName="menulist" scope="session" role="-3"></role:roleinit>
				<role:roleinit listName="menulist" scope="session" role="-4"></role:roleinit>
				<table cellspacing=1 cellpadding=0 border=0 id=bgtable width=100%
					align=center>
					<tr>
						<td id=bgtitle colspan=6 align=center id=bgbody>
							<html:submit styleClass="mybutton" value="确认增加角色"></html:submit>
						</td>
					</tr>
				</table>
				</html:form>
	</body>
</html>
