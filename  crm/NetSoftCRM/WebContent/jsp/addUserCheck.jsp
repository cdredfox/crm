<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<title>sys_user_add</title>
		
		  <script type='text/javascript' src='/NetSoftCRM/dwr/interface/EmployeeAjax.js'></script>
		  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
	  	  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
			<LINK href="<%=request.getContextPath()%>/css/eall2002.css" rel=stylesheet type=text/css>
		  <script language='javascript'>
		  
		  	function checkUserName()
			{
	         EmployeeAjax.findEmployeeByAny("eaccount",document.employeeForm.eaccount.value,msgBack)
			}
		
		function msgBack(msg)
		{	
			if(msg=="")
			{
				document.employeeForm.submit();
			}else
			{
				alert("该用户名已经存在,请重新录入!");
			}
		}
		  
		  
		  	function check() {
				if(document.employeeForm.eaccount.value=="") {
				alert("您的登录名不能为空！");
				document.employeeForm.eaccount.focus();
				}
				else {
				checkUserName();
				}
				}
		</script>


		
	</head>

	<table width='700' border='0' cellspacing='0' cellpadding='0'
		height='21'>
		<tr>
			<td id=mainftitle>
				[ 新建用户 ]
			</td>
		</tr>
	</table>
	<html:form action="/employee?method=addUserCheck">
		<table border=0 cellspacing=1 cellpadding=0 id=bgtable align=center>

			<tr>
				<td align=center id=bgtitle colspan=2>
					输入登陆名
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					登录名
				</td>
				<td id=bgbody>
					<html:text property="eaccount"></html:text>
				</td>
			</tr>
			<tr>
				<td id=bgtitle align=center colspan=2>
					<input type="button" value="提交" onclick="check();">
				</td>
			</tr>
		</table>
	</html:form>
</html>
