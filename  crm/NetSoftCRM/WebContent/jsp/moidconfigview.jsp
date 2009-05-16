<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
			<script type="text/javascript">
				function check()
	 {
	 	if(document.forms[0].confignote.value=="")
	 	{
	 		alert("名称/区号必须填写!");
	 		return false;
	 	}
	 	if(document.forms[0].configvalue.value=="")
	 	{
	 		alert("地方名称必须填写!");
	 		return false;
	 	}
	 	return true;
	 }
			</script>
	</head>
  <body>
    <html:form action="/config?method=modiConfig" onsubmit="return check();">
				<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
			class=bgtable align=center width=700>
					<TR>
						<TD id=bgtitle align=center colSpan=6>
							修改配置信息<font color='red'>(如果是修改区号,请不要修改配置说明字段)</font>
							<html:hidden property="configtopid"/>
							<html:hidden property="configid"/>
						</TD>
					</TR>
					<TR>	
						<TD id=bgtitle align=center width=50>
							名&nbsp;&nbsp;&nbsp;&nbsp;称
						</TD>
						<TD id=bgbody>
							<html:text property="confignote" styleClass="myinput"></html:text>
							<html:hidden property="configtype"/>
						</TD>
						<TD id=bgtitle align=center>
							折合数字代表值
						</TD>
						<TD id=bgbody>
							${maxnum}
							<html:hidden property="configvalue"/>
						</TD>
						<TD id=bgtitle align=center width=50>
							配置说明
						</TD>
						<TD id=bgbody>
							<html:text property="configmessage" styleClass="myinput"></html:text>
						</TD>
					</tr>
					<TR>
						<TD id=bgtitle align=center colSpan=6>
							<html:submit value="确认修改配置信息" styleClass="mybutton"></html:submit>
						</TD>
					</TR>
				</table>
			</html:form>
  </body>
</html>
