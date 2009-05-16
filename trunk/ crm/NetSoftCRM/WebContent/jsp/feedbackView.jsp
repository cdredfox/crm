<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/FeedbackAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>

		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
		<LINK href='<%=request.getContextPath()%>/css/new_css.css'
			rel=stylesheet type=text/css>

		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/FeedbackStyleAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>



		<script type="text/javascript">
			var cid=0;
			
		String.prototype.Trim = function(){ return Trim(this);} 
		String.prototype.LTrim = function(){return LTrim(this);} 
		String.prototype.RTrim = function(){return RTrim(this);} 
	
		//此处为独立函数 
		function LTrim(str) 
		{ 
		var i; 
		for(i=0;i<str.length;i++) 
		{ 
		if(str.charAt(i)!=" "&&str.charAt(i)!=" ")break; 
		} 
		str=str.substring(i,str.length); 
		return str; 
		} 
		function RTrim(str) 
		{ 
		var i; 
		for(i=str.length-1;i>=0;i--) 
		{ 
		if(str.charAt(i)!=" "&&str.charAt(i)!=" ")break; 
		} 
		str=str.substring(0,i+1); 
		return str; 
		} 
		function Trim(str) 
		{ 
		return LTrim(RTrim(str)); 
		} 
			function jumpUrl(id)
			{
				var vid=document.forms[1].feedbackcustomer.value;
				if(id==1)
				{
					window.location.href("/NetSoftCRM/customer.crm?method=detailInfo&id="+vid);
				}
			}
			function GetDate (type)
			{
			  reVal = window.showModalDialog("/NetSoftCRM/jsp/showDate.htm", '',
				"status:no;center:yes;scroll:no;resizable:no;help:no;dialogWidth:255px;dialogHeight:260px");
			  if(reVal==undefined)
			  {
			  	reVal="";
			  }
			  if(type==1)
			  {
			  		document.forms[1].feedbacknextdate.value=reVal;
			   }else
				{
					document.forms[1].feedbackoutdate.value=reVal;
				}
			}
			function delFeedback(id,customerid)
			{
			   if(window.confirm("您确信要删除该条反馈信息?"))
			   {
			   		cid=customerid;
			   		FeedbackAjax.delFeedbackType(id,callBack);
			   }
			}
			
			function callBack(msg)
			{
				if(msg)
				{
					alert("您成功的删除了该条反馈信息!");
					window.location.href("/NetSoftCRM/customer.crm?method=feedbackView&id="+cid);
				}else
				{
					alert("删除反馈信息出错了,请重试或者联系系统管理员!");
				}
			}
			
			function onPage(page)
			{
				document.forms[0].page.value=page;
				document.forms[0].action="/NetSoftCRM/customer.crm?method=feedbackView";
				document.forms[0].submit();
			}
			//add feedback check
			function feedBackCheck()
			{
				var val=document.forms[1].feedbackmessage.value.Trim();
				var f=document.getElementsByName("feedbacktype")[0].value;
				if(val.length==0)
				{
					alert("反馈信息内容不能为空!请输入");
					return false;
				}
				if(f==0)
				{
					alert("必须选择反馈类型！");
					return false;
				}
				return true;
			}
			
			
				function changeFeedback()
		{
			var f=document.getElementsByName("feedbacktype")[0].value;
			if(f==0)
			{
				document.getElementsByName("feedbackmessage")[0].value="";
			}else
			{
				FeedbackStyleAjax.qryFeedbackStyleByFid(f,callbackstyle);
			}
		}
	function callbackstyle(msg)
	{
		 if(msg=="")
		 {
		 	document.getElementsByName("feedbackmessage")[0].value="";
		 	return ;
		 }
		
			var obj=msg.split("@@@");
			document.getElementsByName("feedbackmessage")[0].value=obj[1];
		
		
	}
	
		</script>
	</head>

	<BODY>
		<DIV id=div2 class=bgdiv style='top: 150px; left: 300px'>
		</DIV>
		<table width='844' border='0' cellspacing='0' cellpadding='0'
			align='center'>
			<tr border='0'>
				<td id=mainftitle align=left>
					&nbsp;
					<input type='button' value='客户信息' onclick='jumpUrl(1)'
						class='mybutton'
						style='background: url(images/xxbtn.gif); width: 74px; height: 28; border =0px; font-weight: bold; color: #516379'>
					<input type='button' value='反馈信息' onclick='jumpUrl(2)'
						class='mybutton'
						style='background: url(images/xxbtn.gif); width: 74px; height: 28; border =0px; font-weight: bold; color: #FF0000'>
				</td>
			</tr>
		</table>

		<table width='844' border='0' cellpadding='0' cellspacing='0'
			align='center'>
			<tr>
				<td bgcolor='#8BAAC9' height='1'>
					<html:form action="/customer?method=feedbackView">
						<input type="hidden" name="page" value="0" />
						<input type="hidden" name="id" value="${customer.customerid}" />
					</html:form>
				</td>
			</tr>
			<tr>
				<td align='left' valign='top' bgcolor='#8BAAC9'>
					<table width='841' border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td align='center' valign='middle' bgcolor='#8BAAC9'>
								<table width='839' border='0' cellpadding='0' cellspacing='0'>
									<tr>
										<td bgcolor='#F2F3F7'>
											<br>
											<table border=0 cellpadding=0 width='740' cellspacing="0">
												<TR>
													<TD>
														&nbsp;
													</TD>
													<TD align=right width=200>
														共
														<font color=red>${count}</font> 页&nbsp;&nbsp;当前第
														<font color=red>${page} </font>页&nbsp;&nbsp;
													</TD>
													<TD width=5 valign=top>
														<img height=22 src='images/toolbar1.gif' width=5>
													</TD>
													<td valign=absmiddle noWrap width="30">
														<table border=1 bordercolordark=#ECEAE6
															bordercolorlight=#ECEAE6 cellpadding=0 cellspacing=0
															height=22
															onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
															onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
															onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
															onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
															style="CURSOR: hand" width="100%">
															<tbody>
																<tr onclick="onPage(1);">
																	<td align=center bgcolor=#ECEAE6
																		bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
																		noWrap valign=center>
																		<img
																			onMouseOut="javascript:this.src='images/back1.gif'"
																			onMouseOver="javascript:this.src='images/back2.gif'"
																			name="Image25" border="0" src="images/back1.gif"
																			width="20" height="15" alt="首页">
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
													<td valign=absmiddle noWrap width="30">
														<table border=1 bordercolordark=#ECEAE6
															bordercolorlight=#ECEAE6 cellpadding=0 cellspacing=0
															height=22
															onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
															onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
															onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
															onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
															style="CURSOR: hand" width="100%">
															<tbody>
																<tr onclick="onPage(${page-1})">
																	<td align=center bgcolor=#ECEAE6
																		bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
																		noWrap valign=center>
																		<img
																			onMouseOut="javascript:this.src='images/backward1.gif'"
																			onMouseOver="javascript:this.src='images/backward2.gif'"
																			name="Image25" border="0" src="images/backward1.gif"
																			width="20" height="15" alt="前一页">
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
													<td valign=absmiddle noWrap width="30">
														<table border=1 bordercolordark=#ECEAE6
															bordercolorlight=#ECEAE6 cellpadding=0 cellspacing=0
															height=22
															onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
															onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
															onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
															onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
															style="CURSOR: hand" width="100%">
															<tbody>
																<tr onclick="onPage(${page+1})">
																	<td align=center bgcolor=#ECEAE6
																		bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
																		noWrap valign=center>
																		<img
																			onMouseOut="javascript:this.src='images/forward1.gif'"
																			onMouseOver="javascript:this.src='images/forward2.gif'"
																			name="Image25" border="0" src="images/forward1.gif"
																			width="20" height="15" alt="下一页">
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
													<td valign=absmiddle noWrap width="30">
														<table border=1 bordercolordark=#ECEAE6
															bordercolorlight=#ECEAE6 cellpadding=0 cellspacing=0
															height=22
															onMouseDown="javascript:this.borderColorDark='#ffffff';this.borderColorLight='#808080'"
															onMouseOut="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6';"
															onMouseOver="javascript:this.borderColorDark='#808080';this.borderColorLight='#ffffff';"
															onMouseUp="javascript:this.borderColorDark='#ECEAE6';this.borderColorLight='#ECEAE6'"
															style="CURSOR: hand" width="100%">
															<tbody>
																<tr onclick="onPage(${count})">
																	<td align=center bgcolor=#ECEAE6
																		bordercolordark=#ECEAE6 bordercolorlight=#ECEAE6
																		noWrap valign=center>
																		<img
																			onMouseOut="javascript:this.src='images/front1.gif'"
																			onMouseOver="javascript:this.src='images/front2.gif'"
																			name="Image25" border="0" src="images/front1.gif"
																			width="20" height="15" alt="尾页">
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
												class=bgtable align=center width=740>
												<tr>
													<TD id=bgtitle width=400 align='left' noWrap>
														<img src='images/up.gif'></img>
														反馈内容
													</td>
													<TD id=bgtitle width=100 align='left' noWrap>
														<img src='images/up.gif'></img>
														录入时间
													</td>
													<TD id=bgtitle width=100 align='left' noWrap>
														<img src='images/up.gif'></img>
														录入信息
													</td>
													<TD id=bgtitle width=50 align='left' noWrap>
														<img src='images/up.gif'></img>
														删除
													</td>
												</tr>
												<logic:iterate id="re" name="result">
													<TR bgcolor='#f7f5f0'
														onmouseout='this.style.backgroundColor="#f7f5f0"'
														onmouseover='this.style.backgroundColor="#EFEFEF"'>
														<TD id=bgbodyzzy align='left'>
															${re.feedbackmessage}&nbsp;
														</TD>
														<TD id=bgbodyzzy align='left'>
															<bean:write name="re" property="feedbackdate"
																format="yyyy-MM-dd" />
															&nbsp;
														</TD>
														<TD id=bgbodyzzy align='left'>
															${re.ename}&nbsp;
														</TD>
														<TD id=bgbodyzzy align='left'>
															<logic:equal value="Y" name="Employees"
																property="delFeedBackFlag">
																<a href="#"
																	onclick="delFeedback(${re.id},${customer.customerid});">删除</a>
															</logic:equal>
															<logic:notEqual value="Y" name="Employees"
																property="delFeedBackFlag">
																		无权限操作
																	</logic:notEqual>
														</TD>
													</TR>
												</logic:iterate>
											</table>

											<html:form action="/feedback?method=addFeedback"
												onsubmit="return feedBackCheck();">
												<table id=bgtable width="700" border="0" cellspacing="1"
													cellpadding="0" align="center">
													<tr>
														<TD id=bgtitle align="center" colspan=6>

															增加客户反馈信息
														</TD>
													</tr>
													<tr>
														<td id=bgtitle>
															反馈类型
														</TD>
														<td id=bgbody colspan=2>
															<html:select property="feedbacktype"
																styleClass="fmselect" onchange="changeFeedback();">
																<html:option value="0">请先择</html:option>
																<logic:iterate id="fk" name="customerfk">
																	<html:option value="${fk.configid}">${fk.confignote}</html:option>
																</logic:iterate>
															</html:select>
														</td>
														<td id=bgbody colspan=3>
															下次沟通时间:
															<html:text property="feedbacknextdate" size="10"
																maxlength="10" styleClass="myinput" readonly="true"
																value="${customer.customernextdate}"></html:text>
															<img src='images/calendar.jpg' border=0
																onclick='GetDate(1);' style='cursor: hand'
																align='absmiddle'>
															<font color=red>(为空表示自动生成反馈时间)</font>


														</td>
													</tr>
													<tr>
														<td id=bgtitle>
															客户编号
														</td>
														<td id=bgbody>
															<html:text property="feedbackcustomer" readonly="true"
																styleClass="myinput" value="${customer.customerid}"></html:text>
														</td>
														<td id=bgtitle>
															客户名称
														</td>
														<td id=bgbody>
															<input size=15 name=contract_code
																value="${customer.customercompany}" type="text"
																class=myinput value="">
														</td>
														<td id=bgtitle>
															联络人
														</td>
														<td id=bgbody>
															<logic:present name="customer" property="employye">
																<input name="linkman" type="text"
																	value="${customer.employye.ename}" class=myinput>
																<html:hidden property="feedbackeid"
																	value="${customer.employye.id}" />
															</logic:present>
															<logic:notPresent name="customer" property="employye">
																<input name="linkman" type="text"
																	value="${Employees.ename}" class=myinput>
																<html:hidden property="feedbackeid"
																	value="${Employees.id}" />
															</logic:notPresent>

														</td>
													</tr>

													<tr>
														<td id=bgtitle>
															预计出单日期
														</TD>
														<td id=bgbody colspan=2>
															<html:text property="feedbackoutdate"
																value="${customer.customeroutdate}" readonly="true"
																styleClass="myinput"></html:text>
															<img src='images/calendar.jpg' border=0
																onclick='GetDate(2);' style='cursor: hand'
																align='absmiddle'>
														</td>
														<td id=bgbody colspan=3>
															预计出单价格
															<html:text property="feedbackprice" size="10"
																maxlength="10" styleClass="myinput"
																value="${customer.customerprice}"></html:text>
															<font color=red>(如果还没有预计出单的信息,您可以不填写)</font>
														</td>
													</tr>
													<tr>
														<td id=bgtitle>
															*注意事项
														</td>
														<td id=bgbody colspan=5>
															<font color="red">客户增加成功后,请马上添加反馈信息,以便系统统计!</font>
														</td>
													</tr>
													<tr>
														<td id=bgtitle>
															反馈内容
														</td>
														<td id=bgbody colspan=5>
															<html:textarea property="feedbackmessage"
																styleClass="mytextarea" cols="80" rows="8"></html:textarea>
														</td>
													<tr>
														<td id=bgtitle colspan=6>
															<input name=B1 type=submit value="提交" class=mybutton>
														</TD>
													</tr>
												</table>
											</html:form>
											<br>
											<br>
											<br>
											<br>
										</td>
									</tr>
									<tr>
										<td bgcolor='#8BAAC9' height='1'></td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</BODY>
</html>
