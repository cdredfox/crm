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
		<html:form action="/rule?method=updateRuleView">
			<table width='30%' border='0' cellspacing='0' cellpadding='0'
				height='21'>
				<tr>
					<td id=mainftitle>
						基础业务规则设置
					</td>
				</tr>
			</table>
			<table align=center>
				<tr>
					<td>
						<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
							class=bgtable align=center width=820>
							<tr>
								<TD id=bgtitle width=80 align='left' noWrap
									onclick="javascript:report.OrderBy.value='taborder';report.Direction.value='DESC';report.submit();"
									style="CURSOR: hand">
									<img src='images/up.gif'></img>
									显示顺序
								</td>
								<TD id=bgtitle width=200 align='left' noWrap
									onclick="javascript:report.OrderBy.value='name';report.Direction.value='ASC';report.submit();"
									style="CURSOR: hand">
									名称
								</td>
								<TD id=bgtitle width=350 align='left' noWrap
									onclick="javascript:report.OrderBy.value='memo';report.Direction.value='ASC';report.submit();"
									style="CURSOR: hand">
									说明
								</td>
								<TD id=bgtitle width=100 align='left' noWrap
									onclick="javascript:report.OrderBy.value='num';report.Direction.value='ASC';report.submit();"
									style="CURSOR: hand">
									时间设置
								</td>
								<TD id=bgtitle width=50>
									修改
								</TD>
							</tr>
							<logic:iterate id="rule" name="rulelist">
								<TR bgcolor='#f7f5f0'
									onmouseout='this.style.backgroundColor="#f7f5f0"'
									onmouseover='this.style.backgroundColor="#EFEFEF"'>
									<TD id=bgbodyzzy align='left'>
										${rule.ruleid}
									</TD>
									<TD id=bgbodyzzy align='left'>
										${rule.rulecode}
									</TD>
									<TD id=bgbodyzzy align='left'>
										${rule.rulenote}
									</TD>
									<TD id=bgbodyzzy align='left'>
										${rule.rulevalue}
									</TD>
									<td id=bgbodyzzy align='center'>
										<a href="/NetSoftCRM/rule.crm?method=updateRuleView&id=${rule.ruleid}">修改</a>
									</td>
								</TR>
							</logic:iterate>
						</table>
						<br>
						<br>
						<br>
						<br>
					</td>
				</tr>
			</table>
		</html:form>
	</BODY>
</html>
