<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/EmployeeAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>

<script language='javascript'>
function validateEmployee()
{
	var ename=document.deptForm.employyeName.value;
	EmployeeAjax.findEmployeeByAny("ename",ename,callBack);
}

function callBack(msg)
{
	if(msg=="")
	{
		alert("当前系统内,没有查找到您输入的用户!请您确认后再填写");
		//document.deptForm.employye.value＝"";
		//document.deptForm.employye.focus();
	}
}
function check() {
	if(document.deptForm.dname.value=="") {
	alert("请您输入部门名称");
	document.deptForm.dname.focus();
	return false;
	}
	return true;
	}
	
function onChangeSubmit()
{
	document.forms[0].action="/NetSoftCRM/dept.crm?method=modiDept";
	document.forms[0].submit();
}	
</script>


	</head>
	<body>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					<logic:present name="db">
						[ 部门信息修改 ]
					</logic:present>
					<logic:notPresent name="db">
						[ 新建部门 ]
					</logic:notPresent>
				</td>
			</tr>
		</table>
		<br>
		<html:form action="/dept?method=addDepts" onsubmit="return check();">
			<table cellspacing=1 cellpadding=0 border=1 id=bgtable width=100%
				align=center>
				<tr>
					<td colspan=6 align=center id=bgtitle>
						<logic:present name="db">
						对 ${db.dname} 的信息进行修改
						<html:hidden property="id" value="${db.id}"/>
					</logic:present>
					<logic:notPresent name="db">
						增加一个新的部门
					</logic:notPresent>
					</td>
				</tr>
				<tr>
					<td id=bgtitle width=100>
						部门名称
					</td>
					
					<logic:present name="db">
						<td id=bgbody>
						<html:text property="dname" styleClass="myinput" size="30" value="${db.dname}" readonly="true"></html:text>
						</td>
					</logic:present>
					<logic:notPresent name="db">
						<td id=bgbody>
						<html:text property="dname" styleClass="myinput" size="30"></html:text>
					</td>
					</logic:notPresent>
					
					
					<td id=bgtitle width=100>
						部门负责人
					</td>		
					<td id=bgbody>
						<html:text property="employyeName" styleClass="myinput" size="30" value="${db.employyeName}"></html:text>
					</td>
				</tr>
				<tr>
					<logic:present name="db">
						<td colspan=6 align=center id=bgtitle>
						<input type="button" value="确认修改部门信息" onclick="onChangeSubmit();"  onmouseover="validateEmployee();" class="mybutton" >
						&nbsp;&nbsp;
					</td>
					</logic:present>
					<logic:notPresent name="db">
						<td colspan=6 align=center id=bgtitle>
							<html:submit value="确认添加部门" styleClass="mybutton" onmouseover="validateEmployee();"></html:submit>
							&nbsp;&nbsp;
						</td>
					</logic:notPresent>
				</tr>
			</table>
		</html:form>
		<br>
	</body>
</html>
