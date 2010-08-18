<%@ taglib prefix="page" uri="/WEB-INF/tags/currpage.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<html>
	<head>
		<title>sys_user_edit_list</title>
	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<body>
		<table border='0' cellspacing='0' cellpadding='0' height='21'>
			<tr>
				<td id=mainftitle>
					查询到的存在客户列表
				</td>
			</tr>
		</table>
		<br>
		<html:form action="/customer?method=customerManager">
			<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
				class=bgtable align=center width=650>
				<tr>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='username';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						客户名称
					</td>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='loginname';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						下次沟通时间
					</td>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='deptname';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						录入时间
					</td>
					<TD id=bgtitle width=100 align='left' noWrap
						onclick="javascript:report.OrderBy.value='role_name';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						客户所属人
					</td>
					<TD id=bgtitle noWrap>
						详细
					</TD>
				</tr>
				<logic:present name="elist">
					<logic:iterate id="li" name="elist">
						<TR bgcolor='#f7f5f0'
							onmouseout='this.style.backgroundColor="#f7f5f0"'
							onmouseover='this.style.backgroundColor="#EFEFEF"'>
							<TD id=bgbodyzzy align='left'>
								${li.customercompany}
							</TD>
							<TD id=bgbodyzzy align='left'>
								<bean:write name="li" property="customernextdate"
									format="yyyy-MM-dd" />
								&nbsp;
							</TD>
							<TD id=bgbodyzzy align='left'>
								<bean:write name="li" property="customeradddate"
									format="yyyy-MM-dd" />
								&nbsp;
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.ename}&nbsp;
							</TD>
							
							<TD id=bgbodyzzy align='center'>
								<logic:empty name="li" property="ename">
								<a
									href="<%=request.getContextPath()%>/customer.crm?method=detailInfo&id=${li.customerid}">详细</a>
								</logic:empty>
								<logic:notEmpty name="li" property="ename">
									<font color="red">独占客户</font>
								</logic:notEmpty>
							</TD>
						</TR>
					</logic:iterate>
				</logic:present>

				<logic:notPresent name="elist">
					<TR bgcolor='#f7f5f0'
						onmouseout='this.style.backgroundColor="#f7f5f0"'
						onmouseover='this.style.backgroundColor="#EFEFEF"'>
						<TD colspan="6" align="center" id=bgbodyzzy>
							没有符合条件的记录
						</TD>
					</TR>
				</logic:notPresent>
			</table>
		</html:form>
	</body>
</html>
