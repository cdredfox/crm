<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<HTML>
	<HEAD>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/NoteBookAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
		<script type="text/javascript">
		function changeTextArea(){//用value属性将带有回车的textarea内容重置
		var b=document.all["noteBook"].value;
		while(b.indexOf("\r\n")>=0)
		 b=b.replace("\r\n","<br/>");
		 document.all["noteBook"].value=b;
}
		function onPage(page,topid)
	{
		document.forms[0].page.value=page;
		document.forms[0].action="/NetSoftCRM/notebook.crm?method=showView&type=notebook&id="+ topid;
		document.forms[0].submit();
	}
	
		function del(id,topid)
	{
		if(id==topid)
		{
			if(confirm("你真的要删除主贴吗？主贴删除后所有的跟贴将也会被删除!"))
			{
				NoteBookAjax.delNoteBook(id,callback);
			}
		}else
		{
			if(confirm("请确认是否真的要删除!"))
			{
				NoteBookAjax.delNoteBook(id,callback);
			}
		}
	}
	function callback(msg)
	{
		if(msg)
		{
			alert("已经成功删除该留言!");
		}else
		{
			alert("删除失败，请重试或者联系系统管理员!");
		}
		window.location.href("/NetSoftCRM/notebook.crm?method=showView&type=notebook&id=1");
	}
	</script>
	</HEAD>
	<BODY bgcolor="#F5F9FA" rightMargin=50 leftMargin=50 topMargin=3
		id="tech_body" class="body2">
		<html:form action="/notebook.crm?method=showView&type=notebook">
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
								<tr onClick=onPage("1",${topid});>
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
								<tr onClick=onPage("${page-1}",${topid})>
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
								<tr onClick=onPage("${page+1}",${topid})>
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
								<tr onClick=onPage("${count}",${topid})>
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
			</table>
			<BR>


			<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
				class=bgtable align=center width=730>
				<tr>
					<TD id=bgtitle width=50 align='left' noWr style="CURSOR: hand">
						用户名
					</td>
					<TD id=bgtitle width=60 align='left' noWr style="CURSOR: hand">
						所属部门
					</td>
					<TD id=bgtitle width=70 align='left' noWr style="CURSOR: hand">
						留言日期
					</td>
					<TD id=bgtitle width=430 align='left' noWr style="CURSOR: hand">
						留言内容
					</td>
						<TD id=bgtitle width=30 align='left' noWr style="CURSOR: hand">
							操作
						</td>
				</tr>
				<logic:iterate id="li" name="elist">
					<logic:notEqual value="-1" name="li" property="topid">
						<TR bgcolor='#f7f5f0'
							onmouseout='this.style.backgroundColor="#f7f5f0"'
							onmouseover='this.style.backgroundColor="#EFEFEF"'>
							<TD id=bgbodyzzy align='left'>
								${li.eid.ename}
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.eid.depts.dname}
							</TD>
							<TD id=bgbodyzzy align='left'>
								<bean:write name="li" property="writeDate"
									format="yyyy-MM-dd HH:mm:ss" />
							</TD>
							<TD id=bgbodyzzy align='left'>
								${li.note}
							</TD>
							<logic:equal value="Y" name="Employees" property="bbsFlag">
							<TD id=bgbodyzzy align='left'>
								<a href="#" onclick="del(${li.id},${topid})"><b><font
										color="red">删除</font> </b> </a>
							</TD>
						</logic:equal>
						<logic:notEqual value="Y" name="Employees" property="bbsFlag">
							<logic:equal value="${Employees.id}" name="li" property="eid.id">
								<TD id=bgbodyzzy align='left'>
									<a href="#" onclick="del(${li.id},${topid})"><b><font
											color="red">删除</font> </b> </a>
								</TD>
							</logic:equal>
							<logic:notEqual value="${Employees.id}" name="li" property="eid.id">
								<TD id=bgbodyzzy align='left'>
									无权限
								</TD>
							</logic:notEqual>
						</logic:notEqual>
						</TR>
					</logic:notEqual>
				</logic:iterate>
		</html:form>
		<table width='50%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					<a href="#top">返回页面顶端</a>
				</td>
			</tr>
		</table>
		<html:form action="/notebook?method=addNoteBook&type=showNoteBook"
			onsubmit="changeTextArea();">
			<table width="100%">
				<br>
				<tr>
					<td colspan=2>
						作者：
						<font color=#6699cc>${Employees.ename}</font>
						<input type="hidden" name="topid" value="${topid}" />
					</td>
				</tr>

				<tr>
					<td valign=top>
						<html:textarea property="noteBook" rows="8" cols="60"
							style="font-family: 宋体, Arial; font-size: 12pt;"
							styleClass="input" value=""></html:textarea>

					</td>
				</tr>
				<tr>
					<td>
						<html:submit value="发表留言"></html:submit>
					</td>
				</tr>
			</table>
		</html:form>
		
	</body>
</HTML>
