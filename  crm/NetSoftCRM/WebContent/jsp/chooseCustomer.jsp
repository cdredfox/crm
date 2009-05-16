<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网软CRM--客户选择</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript" src="../js/dojo.js"></script>
   <script type="text/javascript">
	dojo.require("dojo.widget.TabContainer");
	dojo.require("dojo.widget.LinkPane");
	dojo.require("dojo.widget.ContentPane");
	dojo.require("dojo.widget.LayoutContainer");
</script>
   
   </head>
  
  <body>
  <div id="mainTabContainer" dojoType="TabContainer" style="width: 100%; height: 70%" selectedTab="个人客户">
  	<a dojoType="LinkPane" href="" refreshOnShow="true" style="display: none">个人客户</a>
  	<a dojoType="LinkPane" href="" refreshOnShow="true" style="display: none">企业客户</a>
  </div>
  </body>
</html>
