<%@ taglib prefix="page" uri="/WEB-INF/tags/currpage.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=gb2312'>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
		
		  <script type='text/javascript' src='/NetSoftCRM/dwr/interface/EmployeeAjax.js'></script>
		  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
	<script type="text/javascript">
		function deptChange()
		{
			var deptid = DWRUtil.getValue("depts");
			EmployeeAjax.findEmployeeByAny("depts",deptid,callBack);
		}
		function callBack(msg)
		{
			DWRUtil.removeAllOptions("toId");
			DWRUtil.addOptions("toId",msg,"id","ename");
		}
		
		function check()
		{
			var obj=document.forms[0].open;
			var checkvalue;
			for(var i=0;i<obj.length;i++)
			{
				if(obj[i].checked)
				{
					checkvalue=obj[i].value;
					break;
				}
			}
			if(checkvalue==0)
			{
				if(document.forms[0].toId.value==0)
				{
					alert("在选择不全转为公开客户的情况下，请选择要接受客户信息的员工!");
					return false;
				}
			}
			return true;
		}
	</script>
		
		
	</head>
	<body>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					[ 修改信息责任人 ]
				</td>
			</tr>
		</table>
		<br>
		<html:form action="/employee?method=transferEmployee" onsubmit="return check();">
			<table border=0 cellspacing=1 cellpadding=0 id=bgtable align=center>
				<tr>
					<td id=bgtitle align=center colspan=6>
						修改信息责任人
					</td>
				</tr>
				<tr>
					<td id=bgtitle>
						原信息责任人
					</td>
					<td id=bgbody colspan=5>
						${em.ename}
						<html:hidden property="id" value="${em.id}"/>
					</td>
				</tr>
				<tr>
					<td id=bgtitle>
						修改为...
					</td>
					<td id=bgbody colspan=5>
						<html:select property="depts" onchange="deptChange();">
							<html:option value="0">请选择</html:option>
						<logic:iterate id="dept" name="dlist">
							<html:option value="${dept.id}">${dept.dname}</html:option>
						</logic:iterate>
					</html:select>
						责任人
						<html:select property="toId">
						<logic:iterate id="ems" name="emlist">
							<html:option value="${ems.id}">${ems.ename}</html:option>
						</logic:iterate>
					</html:select>
					</td>
				<tr>
					<td id=bgtitle>
						全部公开
					</td>
					<td id=bgbody colspan=5>
						<input type=radio name="open" checked value=0>
						否
						<input type=radio name="open" value=1>
						是
					</td>
				</tr>
				<tr>
					<td id=bgtitle colspan="6">
						<font color="red">如果选择全部公开,则上述选择的责任人不起作用<br/>
						员工 ${em.ename} 名下的客户,将全部转为公开信息</font>
					</td>
				</tr>
				<tr>
					<td id=bgtitle colspan="6">
						<input type=submit value='设  定' class=mybutton>
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
	</body>
</html>
