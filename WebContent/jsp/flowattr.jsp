<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'flowattr.jsp' starting page</title>
    	
  <script type="text/javascript" language="javascript">
  		function openusers()
		{
			var win=window.open("/NetSoftCRM/sellitem.crm?method=getAcepEmp","mm","width=500,toolbar=false,menubar=false,resizable=true");
		}
		function rt()
		{
			var fl=document.flowForm.uid.value+","+document.flowForm.uname.value+","+document.flowForm.renwu.value+","+document.flowForm.renname.value;
			window.returnValue=fl;
			self.close();
			return;
		}
	</script>
  </head>
  
  <body>
  	<center>
  	<form name="flowForm">
  	  	<table>
				<tr>
					<td>用户</td><td><input name="uid" type="hidden">
					<input name="uname" type="text"><a onclick="javascript:openusers()"><img src="<%=request.getContextPath()%>/yl/Images/imgbtn_Date.jpg" align="absMiddle" border="0"></a></td>
				</tr>
				<tr>
					<td>步骤名称</td><td><input type="text" name="renname"></td>
				</tr>
				<tr>
					<td>任务说明</td><td><input type="text" name="renwu"></td>
				</tr>
				<tr>
					<td><input type="button" value="确定" onClick="rt();"></td>
				</tr>	
		</table>
		</form>
		</center>
  </body>
</html>
