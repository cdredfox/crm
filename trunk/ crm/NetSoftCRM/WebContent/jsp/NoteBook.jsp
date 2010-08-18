<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<style>
</style>
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/css/eall2002.css">
		<title>迷你论坛</title>
		<script type="text/javascript">
		function onPage(page)
	{
		document.forms[0].page.value=page;
			document.forms[0].action="/NetSoftCRM/notebook.crm?method=getAll";
		document.forms[0].submit();
	}
	function jumpurl()
	{
		document.location.href("/NetSoftCRM/jsp/addbbs.jsp");
	}
		
		</script>
	</head>
	<body>

		<html:form action="/notebook?method=getAll">
			<input type="hidden" name="page" value="0" />
			<table border=0 cellpadding=0 cellspacing="0" align="center">
				<TR>
					<TD>
						<input type="hidden" id="flag" value="${flag}">
						&nbsp;
					</TD>
					<TD align=right>
						共
						<font color=red>${count}</font> 页&nbsp;&nbsp;当前第
						<font color=red>${page}</font>页&nbsp;&nbsp;
					</TD>
					<TD width=5 valign=top>
						<img height=22 src='images/toolbar1.gif' width=5>
					</TD>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("1");>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/back1.gif'"
											onMouseOver="javascript:this.src='images/back2.gif'"
											name="Image25" border="0" src="images/back1.gif" width="20"
											height="15" alt="首页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("${page-1}")>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/backward1.gif'"
											onMouseOver="javascript:this.src='images/backward2.gif'"
											name="Image25" border="0" src="images/backward1.gif"
											width="20" height="15" alt="前一页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("${page+1}")>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/forward1.gif'"
											onMouseOver="javascript:this.src='images/forward2.gif'"
											name="Image25" border="0" src="images/forward1.gif"
											width="20" height="15" alt="下一页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td valign=absmiddle noWrap width="30">
						<table border=1 bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
							cellpadding=0 cellspacing=0 height=22
							onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
							onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
							onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
							onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
							style="CURSOR: hand" width="100%">
							<tbody>
								<tr onClick=onPage("${count}")>
									<td align=center bgcolor=#ECEAE6 bordercolordark=#ECEAE6
										bordercolorlight=#ECEAE6 noWrap valign=center>
										<img onMouseOut="javascript:this.src='images/front1.gif'"
											onMouseOver="javascript:this.src='images/front2.gif'"
											name="Image25" border="0" src="images/front1.gif" width="20"
											height="15" alt="尾页">
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<TD width=5 valign=top>
						<img height=22 src='images/toolbar1.gif' width=5>
					</TD>
					<td align="right">
									<button class="button" onclick="jumpurl();">发新贴</button>
								</td>
				</TR>
			</table>
			<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
				class=bgtable align=center>
				<tr>
					<TD id=bgtitle width="50" align='left' noWrap style="CURSOR: hand">
						帖子编号
					</td>
					<TD id=bgtitle width=400 align='left' noWrap
						onclick="javascript:report.OrderBy.value='username';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						帖子主题
					</td>
					<TD id=bgtitle width=60 align='left' noWrap
						onclick="javascript:report.OrderBy.value='loginname';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						发表者
					</td>
					<TD id=bgtitle width=80 align='left' noWrap
						onclick="javascript:report.OrderBy.value='deptname';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						发表时间
					</td>
				</tr>
				<logic:present name="elist">
					<logic:iterate id="li" name="elist">
						<TR bgcolor='#f7f5f0'
							onmouseout='this.style.backgroundColor="#f7f5f0"'
							onmouseover='this.style.backgroundColor="#EFEFEF"'>
							<TD id=bgbodyzzy align='left'>
								${li.id}&nbsp;
								<logic:equal value="1" name="li" property="top">
									<font color="red"><b>[置顶]</b>
									</font>
								</logic:equal>
							</TD>
							<TD id=bgbodyzzy align='left'>
								<a href="/NetSoftCRM/notebook.crm?method=showView&id=${li.id}"><b>${li.title}
										&nbsp;</b>
								</a>
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.eid.ename} &nbsp;
							</TD>
							<TD id=bgbodyzzy align='left'>
								<bean:write name="li" property="writeDate" format="yyyy-MM-dd" />
								&nbsp;
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
