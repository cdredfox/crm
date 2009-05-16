<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
		<script type='text/javascript'
		src='/NetSoftCRM/dwr/interface/RoleAjax.js'></script>
	<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
	<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
	<script type="text/javascript">
	
function delRole(id)
	{
		if(window.confirm("您真的要删除当前角色对象吗？"))
		{
			RoleAjax.delRoleById(id,callBack);
		}
	}
	function callBack(msg)
	{
		alert(msg);
		if(msg=="当前角色被成功删除")
		{
		window.location.href("/NetSoftCRM/role.crm?method=getAllRole");
		}
	}
		</script>
<body>
<table width='30%' border='0' cellspacing='0' cellpadding='0' height='21'>
<tr>
<td id=mainftitle>[ 角色维护 ]</td>
</tr>
</table><br>
<html:form action="/role?method=getAllRole">
<table  cellspacing=1 cellpadding=0 border=0 id=bgtable  width=610 align=center>
<tr>
	<td  id=bgtitle align=center width=200>角色</td>
	<td  id=bgtitle align=center width=200>可使用功能列表</td>
	<td  id=bgtitle align=center width=40>修改</td>
	<td  id=bgtitle align=center width=40>删除</td></tr>

<logic:present name="roleList">
<logic:iterate id="rl" name="roleList">
<tr><td  id=bgbody align=center>${rl.rname}</td>
<td  id=bgbody>
<html:select property="rmessage">
	<logic:present name="rl" property="rmidptables">
		<logic:iterate id="rm" name="rl" property="rmidptables">
			<html:option value="${rm.id}">${rm.mname}</html:option>
		</logic:iterate>
	</logic:present>
	<logic:notPresent name="rl" property="rmidptables">
		  <option value="-1">该角色没有任何操作权限</option>
	</logic:notPresent>
	<logic:empty name="rl" property="rmidptables">
		<option value="-1">该角色没有任何操作权限</option>
	</logic:empty>
</html:select>
</td>
<td  id=bgbody align=center>
	<a href="<%=request.getContextPath()%>/role.crm?method=roleModiView&id=${rl.id}"><image src=images/edit.gif border=0></a>
</td>
<td  id=bgbody align=center>
	<a href=javascript:delRole(${rl.id})><image src=images/delete.gif border=0></a>
</td>
</tr>
</logic:iterate>
</logic:present>
</html:form>
</table></body>
