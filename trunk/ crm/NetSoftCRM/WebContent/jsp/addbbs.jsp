<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<HTML>
	<HEAD>
		<STYLE type=text/css>
td {
	font-family: "宋体";
	font-size: 10.5pt
}

body {
	font-family: "宋体";
	font-size: 10.5pt;
}

.body2 {
	
}

.body3 {
	font-family: "宋体";
	font-size: 10.5pt;
}

a:hover {
	font-family: "宋体";
	color: red
}

a:link {
	font-family: "宋体";
	color: blue
}

a:visited {
	font-family: "宋体";
	color: gray
}

.input {
	font-size: 10.5pt;
	border: 1 solid #6699cc;
	color: #33568C
}

.content {
	BACKGROUND-COLOR: #eeeeee;
	COLOR: #000000;
	FONT-FAMILY: 宋体;
	LINE-HEIGHT: 25px;
	FONT-SIZE: 16px
}

.AW:link {
	COLOR: #246CAE;
	font-size: 12px;
	text-decoration: none;
}

.AW:visited {
	COLOR: #246CAE;
	font-size: 12px;
	text-decoration: none;
}

.AW:hover {
	COLOR: #CC3300;
	font-size: 12px;
}

.input4 {
	BORDER-RIGHT: #6699cc 1px solid;
	BORDER-TOP: #6699cc 1px solid;
	FONT-SIZE: 9pt;
	BORDER-LEFT: #6699cc 1px solid;
	WIDTH: 78px;
	COLOR: #33568c;
	BORDER-BOTTOM: #6699cc 1px solid;
	BACKGROUND-COLOR: #eeefff;
	CURSOR: hand
}

.input3 {
	BORDER-RIGHT: #6699cc 1px solid;
	BORDER-TOP: #6699cc 1px solid;
	FONT-SIZE: 9pt;
	BORDER-LEFT: #6699cc 1px solid;
	WIDTH: 32px;
	COLOR: #33568c;
	BORDER-BOTTOM: #6699cc 1px solid;
	BACKGROUND-COLOR: #eeefff;
	CURSOR: hand
}

BODY {
	background: #DDEAF3;
	background-attachment: fixed;
	background-repeat: no-repeat;
	FONT-FAMILY: "宋体";
	FONT-SIZE: 9pt;
}
</STYLE>

		<script type="text/javascript">
		function changeTextArea(){//用value属性将带有回车的textarea内容重置
		var b=document.all["noteBook"].value;
		while(b.indexOf("\r\n")>=0)
		 b=b.replace("\r\n","<br/>");
		 document.all["noteBook"].value=b;
}
		
	</script>
	</HEAD>
	<BODY bgcolor="#F5F9FA" rightMargin=50 leftMargin=50 topMargin=3
		id="tech_body" class="body2">
		<html:form action="/notebook?method=addNoteBook&type=addbbs"
			onsubmit="changeTextArea();">
			<table width="100%">
				<br>
				<tr>
					<td colspan="2">
						作者：
						<font color=#6699cc>${Employees.ename}</font>
						<input type="hidden" name="topid" value="${topid}" />
						<logic:equal value="Y" name="Employees" property="bbsFlag">
							<html:radio property="noteTop" value="1">置顶</html:radio>
							<html:radio property="noteTop" value="0">不置顶</html:radio>
						</logic:equal>
					</td>

				</tr>
				<tr>
					<td colspan=2>
						标题：
						<html:text property="noteTitle" size="50"></html:text>
					</td>
				</tr>
				<tr>
					<td valign=top>
						<html:textarea property="noteBook" rows="20" cols="60"
							style="font-family: 宋体, Arial; font-size: 12pt;"
							styleClass="input" value=""></html:textarea>

					</td>
				</tr>
				<tr>
					<td>
						<html:submit value="发表贴子"></html:submit>
					</td>
				</tr>
			</table>
		</html:form>
		<style type="text/css">
<!--
.font12 {
	font-size: 12px;
	LINE-HEIGHT: 18px
}

.AW:link {
	COLOR: #246CAE;
	font-size: 12px;
	text-decoration: none;
}

.AW:visited {
	COLOR: #246CAE;
	font-size: 12px;
	text-decoration: none;
}

.AW:hover {
	COLOR: #CC3300;
	font-size: 12px;
}
-->
</style>
	</BODY>
</HTML>