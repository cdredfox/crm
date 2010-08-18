<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
			  <script type='text/javascript' src='/NetSoftCRM/dwr/interface/DeptsAjax.js'></script>
  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>

  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>

			
			<script type="text/javascript">
				function delDepts(did)
				{
					DeptsAjax.delDepts(did,callBack);
				}
				function callBack(msg)
				{
					if(msg=="1")
					{
						alert("当前部门不能被删除,部门下还有员工,请先将部门下员工转移后,再进行操作");
					}else 
					if(msg=="2")
					{
						alert("当前部门被成功删除，谢谢您的操作");
						window.location.href("/NetSoftCRM/dept.crm?method=deptsView");
					}else
					{
						alert("操作发生错误：未知错误,请联系管理员");
					}
				}
			</script>
	</head>

	<body>
		<table cellspacing=1cellpadding=0 border=1 id=bgtable 
			align=center>
			<tr>
			<td id=bgtitle colspan=6>
				所有部门列表
			</td>
			</tr>
			<tr>
				<td id=bgtitle>部门名称</td>
				<td id=bgtitle>部门负责人</td>
				<td id=bgtitle>部门信息修改</td>
				<td id=bgtitle>部门信息删除</td>
			</tr>
			<logic:iterate id="dlist" name="deptList">
				<tr>
					<td id=bgbody>
						${dlist.dname}&nbsp;
					</td>
					<td id=bgbody>
						${dlist.employyeName}&nbsp;
					</td>
					<td id=bgbody>
						<a href="<%=request.getContextPath()%>/dept.crm?method=modiView&id=${dlist.id}">修改</a>
					</td>
					<td id=bgbody>
						<a href="#" onclick="delDepts(${dlist.id});">删除</a>
					</td>
				</tr>
			</logic:iterate>
			<table>
	</body>
</html>
