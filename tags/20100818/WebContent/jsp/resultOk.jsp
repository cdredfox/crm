<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
	</head>
	<br>
	<BODY text='#000000' topmargin=0>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					[ 操作结果返回:操做成功 ]
				</td>
			</tr>
		</table>
		<div align=center>
			<b>${message}</b>
		</div>
	</BODY>
</html>

