<%@ taglib prefix="page" uri="/WEB-INF/tags/currpage.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<html>
	<head>
		<title>sys_user_edit_list</title>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/CustomerAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>


		<script type="text/javascript">	
	function onPage(page)
	{
		document.forms[0].page.value=page;
		if(document.getElementById("flag").value=="y")
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerAll&type=all";
		}
		document.forms[0].submit();
	}
	
	function GetDate (vid)
			{
			  reVal = window.showModalDialog("/NetSoftCRM/jsp/showDate.htm", '',
				"status:no;center:yes;scroll:no;resizable:no;help:no;dialogWidth:255px;dialogHeight:260px");
			  if(vid==1)
			  {
			  document.forms[0].startdate.value=reVal;
			  }
			  else
			  {
			  document.forms[0].enddate.value=reVal;
			  }
			}
			
				function delCustomer(id)	
		{
            if(window.confirm("你真的要删除客户信息吗?"))
           {  
               CustomerAjax.delCustomer(id,callBack);
          }	   
		}
		function callBack(msg)
		{
		    if(msg)
		    {
		       alert("你已成功的删除了该客户信息!");
		       window.location.href("/NetSoftCRM/customer.crm?method=customerManager");
		    }else{
		       alert("你删除该客户信息失败!");
		    }
		}
	</script>

	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<body>
		<table width='700' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					<logic:notPresent name="flag">
					[ 所有的客户列表 ]
					</logic:notPresent>
				</td>
			</tr>
		</table>
		查询所有客户列表：
		<br>
		<html:form action="/customer?method=customerAll">
			<input type="hidden" id="flag" value="${flag}" />
			<input type="hidden" name="page" value="0" />
			<table border=0 cellpadding=0 cellspacing="0" align="center">
				<tr>
					<td>
						<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
				 align=center>
							<tr>
					<td>
						&nbsp;公司名称:
					</td>
					<td>
						&nbsp;<html:text property="customercompany"></html:text>
					</td>
					<td>
						&nbsp;客户所属人:
					</td>
					<td>
						&nbsp;
						<html:select property="eid">
							<html:option value="0">全部</html:option>
							<logic:iterate id="e" name="el">
								<html:option value="${e.id}">${e.ename}</html:option>
							</logic:iterate>
						</html:select>
					</td>
					</tr>
					<tr>
					<td>
						&nbsp;录入开始时间:
					</td>
					<td>
						&nbsp;<input type="text" name="startdate" style="myinput" readonly="readonly" value="${startdate}"/>
						<img src='/NetSoftCRM/images/calendar.jpg' border=0
							onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
					</td>
					<td>
						&nbsp;录入结束时间:
					</td>
					<td>
						&nbsp;<input type="text" name="enddate" style="myinput" readonly="readonly" value="${enddate}">
						<img src='/NetSoftCRM/images/calendar.jpg' border=0
							onclick='GetDate(2);' style='cursor: hand' align='absmiddle'>
					</td>
					</tr>
					<tr>
					<td>
					&nbsp;&nbsp;<html:submit value="查询" styleClass="mybutton"></html:submit>
					</td>
				</tr>
						</table>
					</td>
				</tr>
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
				</TR>
			</table>
			<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
				class=bgtable align=center>
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
					<TD id=bgtitle width=60 align='left' noWrap>
						操作
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
								${li.customercompany}&nbsp;
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
								<A
									href="<%=request.getContextPath()%>/customer.crm?method=customerModiView&id=${li.customerid}">修改</A>
								<A href="#" onClick=delCustomer(${li.customerid})>删除</A>
							</TD>
							<TD id=bgbodyzzy align='center'>
								<a
									href="<%=request.getContextPath()%>/customer.crm?method=detailInfo&id=${li.customerid}">详细</a>
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
