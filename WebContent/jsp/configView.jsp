<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
			<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
	</head>
	<br>
	<BODY text='#000000' topmargin=0>
			<table width='790' border='0' cellspacing='0' cellpadding='0'
				height='21'>
				<tr>
					<td id=mainftitle>
						[ 配置信息维护 ]
					</td>
				</tr>
			</table>
		<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
			class=bgtable align=center>
			<tr>
				<TD id=bgtitle  align='left' noWrap>
					配置类型
				</td>
				<TD id=bgtitle  align='left' noWrap>
					配置类型说明
				</td>
				<TD id=bgtitle  noWrap>
					详细
				</TD>
			</tr>
			
			<logic:iterate id="cl" name="configList">
			<TR bgcolor='#f7f5f0'
				onmouseout='this.style.backgroundColor="#f7f5f0"'
				onmouseover='this.style.backgroundColor="#EFEFEF"'>
				<TD id=bgbodyzzy align='left'>
					${cl.configtypename}&nbsp;
				</TD>
				<TD id=bgbodyzzy align='left'>
					${cl.configmessage}&nbsp;
				</TD>
				<td id=bgbodyzzy align='center'>
					<a href="<%=request.getContextPath()%>/config.crm?method=configViewMessage&type=${cl.configtype}"><img
							src='images/view.gif' border=0z>
					</a>
				</td>
			</TR>
		</logic:iterate>
				<TR bgcolor='#f7f5f0'
				onmouseout='this.style.backgroundColor="#f7f5f0"'
				onmouseover='this.style.backgroundColor="#EFEFEF"'>
				<TD id=bgbodyzzy align='left'>
					反馈内容格式设置&nbsp;
				</TD>
				<TD id=bgbodyzzy align='left'>
					客户反馈内容格式设置&nbsp;
				</TD>
				<td id=bgbodyzzy align='center'>
					<a href="<%=request.getContextPath()%>/feedbackstyle.crm?method=initView"><img
							src='images/view.gif' border=0z>
					</a>
				</td>
			</TR>
		</table>
	</BODY>
</html>
