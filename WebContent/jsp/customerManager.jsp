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
		//重新升级
		var delflag;
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
			
		function delCustomer(id,flag)	
		{
            if(window.confirm("你真的要删除客户信息吗?"))
           {  
               delflag=flag;
               CustomerAjax.delCustomerByFlag(id,flag,callBack);
          }	   
		}
		function callBack(msg)
		{
		    if(msg)
		    {
		       alert("你已成功的删除了该客户信息!");
		       if(delflag=='y')
		       {
		        window.location.href("/NetSoftCRM/customer.crm?method=customerManager&type=invali");
		       }else
		       {
		       	 window.location.href("/NetSoftCRM/customer.crm?method=customerManager");
		       }
		      
		    }else{
		       alert("你删除该客户信息失败!");
		    }
		}
		
	
		
	function onPage(page)
	{
		document.forms[0].page.value=page;
		if(document.getElementById("flag").value=="y")
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerManager&type=all";
		}else if(document.getElementById("flag").value=="n")
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerManager&type=invali";
		}else
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerManager";
		}
		document.forms[0].submit();
	}
	
	function showView()
	{
		var customertype=document.forms[0].customertype.value;
		if(document.forms[0].customertype.value==1)
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerManager&customertype="+customertype;
			//window.location.href("/NetSoftCRM/customer.crm?method=customerManager&customertype="+customertype);
			
		}else if(document.forms[0].customertype.value==2)
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerManager&type=all&customertype="+customertype;
			//window.location.href("/NetSoftCRM/customer.crm?method=customerManager&type=all&customertype="+customertype);
		}else if(document.forms[0].customertype.value==3)
		{
			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerManager&type=invali&customertype="+customertype;
			//window.location.href("/NetSoftCRM/customer.crm?method=customerManager&type=invali&customertype="+customertype);
		}
		document.forms[0].submit();
	}
	</script>

	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<body>
		<table border='0' cellspacing='0' cellpadding='0' height='21'>
			<tr>
				<td id=mainftitle>
					<logic:present name="flag">
						<logic:equal value="y" name="flag">
						[ 所有的公开客户信息 ]
						</logic:equal>
						<logic:equal value="n" name="flag">
						[ 所有的失效客户信息 ]
						</logic:equal>
					</logic:present>
					<logic:notPresent name="flag">
					[ 我的客户列表 ]
					</logic:notPresent>
				</td>
			</tr>
		</table>
		查询客户列表：
		<br>
		<html:form action="/customer?method=customerManager">
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
									&nbsp;
									<html:text property="customercompany"></html:text>
								</td>
								<td>
									&nbsp;客户类型选择:
								</td>
								<td>
									&nbsp;

									<html:select property="customertype">
										<html:option value="1">我的客户</html:option>
										<html:option value="2">公开客户</html:option>
										<html:option value="3">撤销客户</html:option>
									</html:select>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;客户级别:
								</td>
								<td>
									&nbsp;
					                <html:select property="cutomergrade">
						               <html:option value="0">全部</html:option>
						               <logic:iterate id="dj" name="customerdj">
							           <html:option value="${dj.configid}">${dj.confignote}</html:option>
						               </logic:iterate>
					                </html:select>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;录入开始时间:
								</td>
								<td>
									&nbsp;
									<input type="text" name="startdate" style=""
										readonly="readonly" value="${startdate}" />
									<img src='/NetSoftCRM/images/calendar.jpg' border=0
										onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
								</td>
								<td>
									&nbsp;录入结束时间:
								</td>
								<td>
									&nbsp;
									<input type="text" name="enddate" style="" readonly="readonly"
										value="${enddate}">
									<img src='/NetSoftCRM/images/calendar.jpg' border=0
										onclick='GetDate(2);' style='cursor: hand' align='absmiddle'>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;
									<input type="button" value="查询" class="mybutton"
										onclick="showView();" />
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
					<logic:equal value="Y" name="Employees" property="delFlag">
						<logic:equal value="n" name="flag">
							<td id=bgtitle width=100 align='left' noWr style="CURSOR: hand">
								彻底删除
							</td>
						</logic:equal>
					</logic:equal>
					<logic:notPresent name="flag">
						<TD id=bgtitle width=60 align='left' noWrap>
							操作
						</td>
					</logic:notPresent>
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
							<logic:equal value="Y" name="Employees" property="delFlag">
								<logic:equal value="n" name="flag">
									<td id=bgbodyzzy align='left'>
										<A href="#" onClick=delCustomer(${li.customerid},'y')>彻底删除</A>
									</td>
								</logic:equal>
							</logic:equal>
							<logic:notPresent name="flag">
								<TD id=bgbodyzzy align='center'>
									<A
										href="<%=request.getContextPath()%>/customer.crm?method=customerModiView&id=${li.customerid}">修改</A>
									<A href="#" onClick=delCustomer(${li.customerid},'n')>删除</A>
								</TD>
							</logic:notPresent>
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
