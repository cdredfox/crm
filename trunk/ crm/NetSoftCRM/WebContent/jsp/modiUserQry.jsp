<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<title>sys_user_edit</title>
	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<table width='700' border='0' cellspacing='0' cellpadding='0'
		height='21'>
		<tr>
			<td id=mainftitle>
				<logic:present name="transfer">
					[ 失效用户信息转移 ]
				</logic:present>
				<logic:notPresent name="transfer">
					[ 用户维护 ]
				</logic:notPresent>
			</td>
		</tr>
	</table>
	<table border=0 cellspacing=1 cellpadding=0 id=bgtable align=center>
		<html:form action="/employee?method=qryUser">
			<input type="hidden" name="transfer" value="${type}"/>
			<tr>
				<td id=bgtitle colspan=4>
					输入查询条件
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					登陆名
				</td>
				<td id=bgbody>
					<html:text property="eaccount" styleClass="myinput"></html:text>
				</td>
				<td id=bgtitle>
					姓名
				</td>
				<td id=bgbody>
					<html:text property="ename" styleClass="myinput"></html:text>
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					用户角色
				</td>
				<td colspan=1 id=bgbody>
					<html:select property="emidrs">
						<option value=''>
							全部
						</option>
						<logic:iterate id="role" name="roleList">
							<html:option value="${role.id}">${role.rname}</html:option>
						</logic:iterate>
					</html:select>
				</td>
				<td id=bgtitle align=right>
					所属部门
				</td>
				<td id=bgbody>
					<html:select property="depts">
						<option value=''>
							全部
						</option>
						<logic:iterate id="dept" name="deptList">
							<html:option value="${dept.id}">${dept.dname}</html:option>
						</logic:iterate>
					</html:select>
				</td>
				</td>
			</tr>
			<tr>
				<td id=bgtitle align=center colspan=4>
					<html:submit value="确定查询" styleClass="mybutton"></html:submit>
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
