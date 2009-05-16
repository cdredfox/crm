<%@ taglib prefix="page" uri="/WEB-INF/tags/currpage.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<html>
	<head>
		<title>sys_user_edit_list</title>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/EmployeeAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
		<script type="text/javascript">
		var vid;
		function delEmployee(id)
		{
			if(document.forms[0].employeeid.value==id)
			{
				alert("当前操作不能进行！自已不能删除自已!");
				return;
			}
			if(confirm('是否确信删除'))
			{
				EmployeeAjax.delEmployee(id,callBack);
				vid=id;
			}
		}
		function callBack(msg)
		{
			if(msg=="1")
			{
				if(window.confirm("当前员工不能被删除！请先将其名下的客户转移后再尝试删除！是否要跳到失效用户信息转移页面进行客户转移操作？"))
				{
					window.location.href("/NetSoftCRM/employee.crm?method=transferEmployeeView&id="+vid);	
				}
				
			}else if(msg=="2")
			{
				alert("您已成成功的删除了该名员工!");
				window.location.href("/NetSoftCRM/employee.crm?method=findAll");
			}else if(msg=="5")
			{
				if(window.confirm("当前员工是部门负责人,不能被删除。请先在部门维护里改变部门负责人后重试!选择 ‘是’ 将跳转到部门维护页面!"))
				{
					window.location.href("/NetSoftCRM/dept.crm?method=deptsView");
				}
			}else
			{
				alert("删除过程中出现错误！您可以尝试重试！或者联系系统管理员");
			}
		}
	
	
	function onPage(page)
	{
		document.forms[0].page.value=page;
		if(document.getElementById("flag").value=="y")
		{
			document.forms[0].action="/NetSoftCRM/employee.crm?method=qryUser";
		}else
		{
			document.forms[0].action="/NetSoftCRM/employee.crm?method=findAll";
		}
		document.forms[0].submit();
	}
	</script>

	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<body>
		<table width='700' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					[ 用户维护-用户列表 ]
				</td>
			</tr>
		</table>
		查询用户列表： 
		<br>
		<html:form action="/employee?method=qryUser">
			<input type="hidden" name="eaccount" value="${eb.eaccount}" />
			<input type="hidden" name="ename" value="${eb.ename}" />
			<input type="hidden" name="emidrs" value="${eb.roleid}" />
			<input type="hidden" name="depts" value="${eb.depts}" />
			<input type="hidden" id="flag" value="${flag}" />
			<input type="hidden" name="page" value="0" />
			<table border=0 cellpadding=0 width='820' cellspacing="0">
				<TR>
					<TD>
						&nbsp;
					</TD>
					<TD align=right width=200>
						共
						<font color=red>${count}</font> 页&nbsp;&nbsp;当前第
						<font color=red>${page}</font>页&nbsp;&nbsp;
					</TD>
					<TD width=5 valign=top>
						<img height=22 src='images/toolbar1.gif' width=5>
					</TD>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("1");>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/back1.gif'"
											onMouseOver="javascript:this.src='images/back2.gif'"
											name="Image25" border="0" src="images/back1.gif" width="20"
											height="15" alt="首页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("${page-1}")>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/backward1.gif'"
											onMouseOver="javascript:this.src='images/backward2.gif'"
											name="Image25" border="0" src="images/backward1.gif"
											width="20" height="15" alt="前一页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("${page+1}")>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/forward1.gif'"
											onMouseOver="javascript:this.src='images/forward2.gif'"
											name="Image25" border="0" src="images/forward1.gif"
											width="20" height="15" alt="下一页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("${count}")>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/front1.gif'"
											onMouseOver="javascript:this.src='images/front2.gif'"
											name="Image25" border="0" src="images/front1.gif" width="20"
											height="15" alt="尾页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<TD width=5 valign=top>
						<img height=22 src='images/toolbar1.gif' width=5>
					</TD>
				</TR>
			</table>
			<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
				class=bgtable align=center width=650>
				<tr>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='username';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						姓 名
						<input type="hidden" name="employeeid" value="${Employees.id}">
					</td>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='loginname';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						登录名
					</td>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='deptname';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						部门
					</td>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='role_name';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						角色
					</td>
					<TD id=bgtitle width=60 align='left' noWrap>
						删除用户
					</td>
					<TD id=bgtitle noWrap>
						修改用户信息
					</TD>
				</tr>
				<logic:present name="elist">
					<logic:iterate id="li" name="elist">
						<TR bgcolor='#f7f5f0'
							onmouseout='this.style.backgroundColor="#f7f5f0"'
							onmouseover='this.style.backgroundColor="#EFEFEF"'>
							<TD id=bgbodyzzy align='left'>
								${li.ename}
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.eaccount}
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.deptsName}
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.rolename}
							</TD>
							<TD id=bgbodyzzy align='left'>
								<A href="#" onClick=delEmployee(${li.id})>删除用户</A>
							</TD>
							<TD id=bgbodyzzy align='left'>
								<a
									href="<%=request.getContextPath()%>/employee.crm?method=modiView&id=${li.id}">修改用户信息</a>
							</TD>
						</TR>
					</logic:iterate>
				</logic:present>

				<logic:notPresent name="elist">
					<TR bgcolor='#f7f5f0'
						onmouseout='this.style.backgroundColor="#f7f5f0"'
						onmouseover='this.style.backgroundColor="#EFEFEF"'>
						<TD colspan="6" align="center" id=bgbodyzzy>
							没有符合条件的记录
						</TD>
					</TR>
				</logic:notPresent>
			</table>
		</html:form>
	</body>
</html>
