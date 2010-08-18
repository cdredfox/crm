<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<title>sys_user_add</title>
	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>

	<script language='javascript'>
function check() {
if(document.employeeForm.eaccount.value=="") {
alert("您的登录名不能为空！");
document.employeeForm.eaccount.focus();
return false;
}
if(document.employeeForm.ename.value=="") {
alert("您的姓名不能为空！");
document.employeeForm.ename.focus();
return false;
}
if(document.employeeForm.epwd.value=="") {
alert("您的密码不能为空！");
document.employeeForm.epwd.focus();
return false;
}
if(document.employeeForm.epwd.value.length<6) {
alert("密码长度不能小于6位！");
return false;
}
var checkedStr = "";
var checkStr = document.employeeForm.epwd.value;
var j = 0;
for ( var i = 0;  i < checkStr.length;  i++)
{
if(checkedStr==checkStr.charAt(i)){
j=j+1;
 }
checkedStr = checkStr.charAt(i);
}
if(j==checkStr.length-1){
alert("密码不能用相同的字母！");
return false;
}
if(document.employeeForm.conword.value!=document.employeeForm.epwd.value) {
alert("您的两个密码不一样！");
document.employeeForm.conword.value="";
document.employeeForm.epwd.value="";
document.employeeForm.epwd.focus();
return false;
}
return true;
}

</script>
	<table width='700' border='0' cellspacing='0' cellpadding='0'
		height='21'>
		<tr>
			<td id=mainftitle>
				[ 修改用户信息 ]
			</td>
		</tr>
	</table>
	<html:form action="/employee?method=modiUser" onsubmit="return check();">
		<table cellspacing=1 cellpadding=0 border=0 id=bgtable width=70%
			align=center>
			<html:hidden property="id"/>
			<tr>
				<td align=center id=bgtitle colspan=4>
					修改用户信息
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					登录名
				</td>
				<td id=bgbody>
					<html:text property="eaccount" styleClass="myinput"></html:text>
				</td>
				<td id=bgtitle>
					姓 名
				</td>
				<td id=bgbody>
					<html:text property="ename" styleClass="myinput"></html:text>
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					密码
				</td>
				<td id=bgbody>
					<html:password property="epwd" styleClass="myinput"></html:password>
				</td>
				<td id=bgtitle>
					确认密码
				</td>
				<td id=bgbody>
					<input type=password class=myinput name=conword
						styleClass="myinput" value="${repwd}"/>
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					所属部门
				</td>
				<td id=bgbody>
					<html:select property="depts">
						<logic:iterate id="dept" name="deptList">
							<html:option value="${dept.id}">${dept.dname}</html:option>
						</logic:iterate>
					</html:select>
				</td>
				<td id=bgtitle>
					用户角色
				</td>
				<td id=bgbody colspan=1>
					  <html:select property="emidrs">
						<logic:iterate id="role" name="roleList">
							<html:option value="${role.id}">${role.rname}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<td align=center colspan=4 id=bgtitle>
					<html:submit value="确认修改用户信息" styleClass="mybutton"></html:submit>
				</td>
			</tr>
		</table>
	</html:form>
	<DIV class=bgdiv id=divid>
		<table cellpadding='1' cellspacing='1' width=50>
			<td width=100%>
				<span id=tablepage></span>
			</td>
		</table>
	</DIV>
</html>
