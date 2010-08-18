<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <LINK href="<%=request.getContextPath()%>/css/base.css" type=text/css rel=stylesheet>
    <title>My JSP 'myPower.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

　　<STYLE>
		.P_LB { PADDING-LEFT: 5px; FONT-WEIGHT: bold; WIDTH: 100px; COLOR: 
#333333; LETTER-SPACING: 1px } 
		.P_NL { } 
		.ip_text { BORDER-RIGHT: #cccccc 1px 
solid; PADDING-RIGHT: 0px; BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 0px; 
PADDING-BOTTOM: 0px; BORDER-LEFT: #cccccc 1px solid; WIDTH: 150px; PADDING-TOP: 
0px; BORDER-BOTTOM: #cccccc 1px solid; HEIGHT: 20px } 
		.ip_textarea { BORDER-
RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; OVERFLOW-Y: auto; 
BORDER-LEFT: #cccccc 1px solid; WIDTH: 100%; BORDER-BOTTOM: #cccccc 1px solid; 
HEIGHT: 100px } .title { PADDING-LEFT: 8px; FONT-WEIGHT: bold; VERTICAL-ALIGN: 
baseline; WIDTH: 100%; COLOR: #ca1313; BACKGROUND-REPEAT: repeat-x; HEIGHT: 
20px; BACKGROUND-COLOR: #e6e7e8 } .title FONT { DISPLAY: inline; FONT-SIZE: 
12px; WIDTH: 100%; FONT-FAMILY: "Tahoma"; LETTER-SPACING: 3px } .data_list_thead 
{ TABLE-LAYOUT: fixed; PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 
3px; COLOR: #000000; PADDING-TOP: 3px; HEIGHT: 22px; BACKGROUND-COLOR: #adceed } 
.formTable TD { PADDING-LEFT: 4px } .formTable TR { FONT-SIZE: 12px } .TBL_A { 
BACKGROUND-COLOR: #ffffff } .TBL_B { BACKGROUND-COLOR: #ecf3f9 } .data_list_foot 
TD { BACKGROUND-COLOR: #bcd0eb } .data_list_query { BACKGROUND-COLOR: #f4f1eb } 
BUTTON { BORDER-RIGHT: #485984 2px solid; PADDING-RIGHT: 2px; BORDER-TOP: 
#89acf0 2px solid; PADDING-LEFT: 2px; FONT-SIZE: 9pt; BORDER-LEFT-COLOR: 
#89acf0; PADDING-BOTTOM: 0px; CURSOR: hand; COLOR: #ffffff; BORDER-BOTTOM: 
#485984 2px solid; FONT-FAMILY: "宋体"; BORDER-LEFT-STYLE: solid; LETTER-
SPACING: 1px; HEIGHT: 20px; BACKGROUND-COLOR: #6980bc } .app-jwin-page-bgcolor { 
PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px } 
.app-jwin-table { BORDER-RIGHT: #cccccc 1px solid; TABLE-LAYOUT: fixed; BORDER-
TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; WIDTH: 300px; BORDER-
BOTTOM: #cccccc 1px solid; HEIGHT: 100%; BACKGROUND-COLOR: #edf2fc } .app-jwin-
header { PADDING-RIGHT: 3px; PADDING-LEFT: 3px; FONT-WEIGHT: normal; BACKGROUND-
images: url(<%=request.getContextPath()%>/images/bg2.gif); PADDING-BOTTOM: 2px; VERTICAL-ALIGN: bottom; COLOR: 
#5e656e; PADDING-TOP: 2px; BACKGROUND-REPEAT: repeat-x; LETTER-SPACING: 4px; 
BACKGROUND-COLOR: #0148b2 } .app-jwin-header-2 { PADDING-RIGHT: 3px; PADDING-
LEFT: 3px; FONT-WEIGHT: normal; BACKGROUND-images: url(<%=request.getContextPath()%>/images/bg2.gif); PADDING-
BOTTOM: 2px; VERTICAL-ALIGN: bottom; COLOR: #5e656e; PADDING-TOP: 2px; 
BACKGROUND-REPEAT: repeat-x; LETTER-SPACING: 4px; BACKGROUND-COLOR: #0148b2 } 
.app-jwin-body { PADDING-RIGHT: 5px; OVERFLOW-Y: auto; PADDING-LEFT: 5px; 
PADDING-BOTTOM: 5px; PADDING-TOP: 5px; HEIGHT: 100% } A:link { COLOR: #003399; 
TEXT-DECORATION: none } A:visited { COLOR: #003399; TEXT-DECORATION: none } 
A:hover { COLOR: #ff9900; TEXT-DECORATION: underline } .table_head { TABLE-
LAYOUT: fixed; PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 3px; 
COLOR: white; PADDING-TOP: 3px; BACKGROUND-COLOR: #8caae6 } .data_list_query TD 
{ FONT-WEIGHT: bold } FIELDSET { BORDER-RIGHT: #dddddd 1px solid; BORDER-TOP: 
#dddddd 1px solid; BORDER-LEFT: #dddddd 1px solid; BORDER-BOTTOM: #dddddd 1px 
solid } FIELDSET TD { PADDING-LEFT: 4px } FIELDSET { PADDING-RIGHT: 5px; 
PADDING-LEFT: 5px; FONT-SIZE: 12px; PADDING-BOTTOM: 5px; PADDING-TOP: 5px; FONT-
FAMILY: Tahoma; LETTER-SPACING: 1px } LEGEND { FONT-SIZE: 14px; COLOR: #008000; 
LETTER-SPACING: 1px } </STYLE>
  </head>
  
  <body>
   <html:form action="/menus?method=addPower&pid=${rid}">
   		<table>
   			<logic:present name="otherPower">
   			<logic:iterate name="otherPower" id="mp" indexId="id">
   			 
   				<c:if test="${(id%4)==0}">
   					<tr>
   				</c:if>	
   				<td>
   				<c:if test="${mp.mtopId<0}">
   				<html:checkbox property="id" value="${mp.id}"><b><font color="blue">${mp.mname}</font></b></html:checkbox>
   				</c:if>
   				<c:if test="${mp.mtopId>=0}">
   				<html:checkbox property="id" value="${mp.id}">${mp.mname}</html:checkbox>
   				</c:if>	
   				</td>
   				</logic:iterate>
   				</tr>
   			</logic:present>
   			<tr>
   			<td><html:submit value="确定操作"/></td>
   			<td><html:reset value="取消操作"/></td>
   		</tr>
   		<logic:notPresent name="otherPower"> 
   		
   		<tr>
   			<td>对不起。您没有任何权限</td>
   		</tr>
   		</logic:notPresent>   		
   		</table>
   		<table>
   				<tr>
   			<td><font color="red">温馨小提示：<br/>
   					蓝色加粗字体表示的选项为主菜单</font>
   			</td>
   		</tr>
   		</table>
   		</html:form>
  </body>
</html>
