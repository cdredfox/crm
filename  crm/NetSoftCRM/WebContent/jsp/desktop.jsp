<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
<LINK href='<%=request.getContextPath()%>/css/new_css.css' rel=stylesheet type=text/css>
</head><br>
<STYLE type=text/css>A:link {
	FONT-SIZE: 12px;COLOR: #006600; TEXT-DECORATION: none
}
A:visited {
	FONT-SIZE: 12px;COLOR: #006600; TEXT-DECORATION: none
}
A:active {
	FONT-SIZE: 12px;COLOR: #006600; TEXT-DECORATION: none
}
A:hover {
	FONT-SIZE: 12px;COLOR: #189AA5; TEXT-DECORATION: none;position:relative;top:1px;left:1px;
}
</STYLE>
<BODY width='100%' topmargin=0 bgColor='#DDEAF3'>
<table width='30%' border='0' cellspacing='0' cellpadding='0' height='21'>
<tr>
<td id=mainftitle><font class='font3'>[ 系统桌面 ]</font></td>
</tr>
</table>
<br><div align=center >
  <table width="100%" align="center">
<tr>
		<td></td>
		<td align="right" width="20%">
			<table width="100%">
				<tr><td align="center" id="bgtitle"><b>系统状态：</b><font color="#33CC00"><b>正常</b></font></td></tr>
				<tr>
					<td id="bgbody">当前系统版本为：V1.0</td>
				</tr>
				<tr>
					<td id="bgbody">服务器最新版为：V1.0</td>
				</tr>
				<tr>
					<td><input type="button" value="自动升级" disabled="disabled"> </td>
				</tr>
			</table>
			</td>
</tr>
</table></div>
<br>
<table width="100%" align="center" >
<tr>
	<td align="center">
<h2><b><font color='red'>客户关系管理系统，携手创造美好明天</font><b></h2>
	<TD>
</tr>
</table>
</BODY>
</html>
