<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<title>sys_user_edit</title>
		<script type="text/javascript">
			function refresh()
			{
				var selectValue=document.getElementById("id").value;
				if(selectValue=="-1")
				{
					alert("请选择有效的员工来进行设置!");
					return;
					}
				document.forms[0].action="employee.crm?method=userDataControlView";
				document.forms[0].submit();
				}
			function checkRule()
			{
				var selectValue=document.getElementById("id").value;
				if(selectValue=="-1")
				{
					alert("请选择有效的员工来进行设置!");
					return false;
					}
				return true;
				}
		</script>
	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<table width='700' border='0' cellspacing='0' cellpadding='0'
		height='21'>
		<tr>
			<td id=mainftitle>
					[ 用户数据查看权限维护 ]
			</td>
		</tr>
	</table>
	<table border=0 cellspacing=1 cellpadding=0 id=bgtable align=center>
		<html:form action="/employee?method=userDataControl" onsubmit="return checkRule();">
			<input type="hidden" name="transfer" value="${type}"/>
			<tr>
				<td id=bgtitle colspan=4>
					设置用户数据查询权限
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					要设置的用户：
				</td>
				<td id=bgbody>
					<html:select property="id" onchange="refresh();">
						<html:option value="-1">请选择</html:option>
						<html:options collection="employees" labelProperty="ename" property="id"/>
					</html:select>
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					可设置的用户：
				</td>
				<td colspan=1 id=bgbody>
					<logic:iterate id="e" name="employees">
					<bean:define id="isChecked" value="false"></bean:define>
						<logic:present name="top">
						<logic:iterate id="t" name="top">
							<logic:equal value="${t}" name="e" property="id">
								<input type="checkbox" name="topId" value="${e.id}" checked="checked">${e.ename}</input>
								<bean:define id="isChecked" value="true"></bean:define>
							</logic:equal>
							</logic:iterate>
						</logic:present>
						<logic:notEqual value="true" name="isChecked">
								<html:checkbox property="topId" value="${e.id}">${e.ename}</html:checkbox>
						</logic:notEqual>
					</logic:iterate>
				</td>
			</tr>
			<tr>
				<td id=bgtitle align=center colspan=4>
					<html:submit value="确定设置" styleClass="mybutton"></html:submit>
				</td>
			</tr>
		</html:form>
	</table>
	<DIV class=bgdiv id=divid>
		<table cellpadding='1' cellspacing='1' width=50>
			<td width=100%>
				<span id=tablepage></span>
			</td>
		</table>
	</DIV>
	</body>
</html>
