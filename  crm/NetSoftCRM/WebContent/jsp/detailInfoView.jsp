<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		  <script type='text/javascript' src='/NetSoftCRM/dwr/interface/CustomerAjax.js'></script>
		  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
		
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
		<LINK href='<%=request.getContextPath()%>/css/new_css.css'
			rel=stylesheet type=text/css>
		<script type="text/javascript">
			var cid=0;
			function jumpUrl(id)
			{
				var vid=document.forms[0].customerid.value;
				if(id==2)
				{
					window.location.href("/NetSoftCRM/customer.crm?method=feedbackView&id="+vid);
				}
			}
			
			function changeCustomerStyle(id)
			{
				if(window.confirm("您确定要将该客户设置为公开吗?"))
				{
					cid=id;
					CustomerAjax.changeCustomerOpen(id,callBack);
				}
			}
			function callBack(msg)
			{
				if(msg)
				{
					alert("您成功的将该客户设置成了公开客户!");
					window.location.href("/NetSoftCRM/customer.crm?method=detailInfo&id="+cid);
				}else
				{
					alert("取消客户独享出错了,请重试或者联系统管理员!");
				}
			}
		</script>
	</head>
	<BODY>
		<DIV id=div2 class=bgdiv style='top: 150px; left: 300px'>
		</DIV>
		<form name=form1 method='post'>
			<table width='844' border='0' cellspacing='0' cellpadding='0'
				align='center'>
				<tr border='0'>
					<td id=mainftitle align=left>
						&nbsp;
						<input type='button' name='detailInfo' value='客户信息'
							onclick='jumpUrl(1);' class='mybutton'
							style='background: url(images/xxbtn.gif); width: 74px; height: 28; border =0px; font-weight: bold; color: #FF0000'>
						<input type='button' name='feedback' value='反馈信息'
							onclick='jumpUrl(2);' class='mybutton'
							style='background: url(images/xxbtn.gif); width: 74px; height: 28; border =0px; font-weight: bold; color: #516379'>
					</td>
				</tr>
			</table>
			<table width='844' border='0' cellpadding='0' cellspacing='0'
				align='center'>
				<tr>
					<td bgcolor='#8BAAC9' height='1'></td>
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
												<body>
													<table id=bgtable border=0 cellspacing=1 cellpadding=0
														width=800 align=center>
														<tr>
															<td id=bgtitle colspan=8 align=center>
																<b>客户详细信息</b>
																<html:hidden property="customerid" value='${id}'/>
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																公司名称
															</td>
															<td id=bgbody colspan="3">
																${ctb.customercompany}&nbsp;
															</td>
															<td id=bgtitle align='center'>
																电话
															</td>
															<td id=bgbody colspan="3">
																${ctb.customerphone}&nbsp;
															</td>
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																联系地址
															</td>
															<td id=bgbody  colspan="3">
																${ctb.customeraddress}&nbsp;
															</td>
															
															<td id=bgtitle align='center' >
																传真
															</td>
															<td id=bgbody colspan="3">
																${ctb.customerfax}&nbsp;
															</td>
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																联系人名称
															</td>
															<td id=bgbody>
																${ctb.customername}&nbsp;
															</td>
															<td id=bgtitle align='center'>
																移动电话
															</td>
															<td id=bgbody>
																${ctb.customerhandset}&nbsp;
															</td>
															
															<td id=bgtitle align='center'>
																客户来源
															</td>
															<td id=bgbody colspan="3">
																<logic:iterate id="ly" name="customerly">
																	<logic:equal value="${ctb.customersource}" name="ly" property="configid">
																		${ly.confignote}
																	</logic:equal>
																</logic:iterate>&nbsp;
															</td>
															
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																当前反馈类型
															</td>
															<td id=bgbody colspan=1>
																<logic:iterate id="fk" name="customerfk">
																	<logic:equal value="${ctb.customerfeedbacktype}" name="fk" property="configid">
																		${fk.confignote}
																	</logic:equal>
																</logic:iterate>&nbsp;
															</td>
															<td id=bgtitle align='center'>
																客户性质
															</td>
															<td id=bgbody colspan="1">
																<logic:iterate id="xz" name="customerxz">
																	<logic:equal value="${ctb.customerproperty}" name="xz" property="configid">
																		${xz.confignote}
																	</logic:equal>
																</logic:iterate>&nbsp;
															</td>
															<td id=bgtitle align='center' colspan="1">
																客户所有制性质
															</td>
															<td id=bgbody colspan="3">
																<logic:iterate id="syz" name="customersyzxz">
																	<logic:equal value="${ctb.customerowenerxz}" name="syz" property="configid">
																		${syz.confignote}
																	</logic:equal>
																</logic:iterate>&nbsp;
															</td>
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																需求价格
															</td>
															<td id=bgbody>
																&nbsp;${ctb.customerprice}
															</td>
															<td id=bgtitle align='center'>
																客户等级
															</td>
															<td id=bgbody>
																<logic:iterate id="dj" name="customerdj">
																	<logic:equal value="${ctb.cutomergrade}" name="dj" property="configid">
																		${dj.confignote}
																	</logic:equal>
																</logic:iterate>&nbsp;
															</td>
															<td id=bgtitle align='center'>
																下次联系时间
															</td>
															<td id=bgbody colspan=3>
																<bean:write name="ctb" property="customernextdate" format="yyyy-MM-dd" />
																&nbsp;
															</td>
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																客户添加时间
															</td>
															<td id=bgbody>
															<bean:write name="ctb" property="customeradddate" format="yyyy-MM-dd" />
																&nbsp;
															</td>
															<td id=bgtitle align='center'>
																最后反馈时间
															</td>
															<td id=bgbody>
																<bean:write name="ctb" property="customerfeedbackdate" format="yyyy-MM-dd" />
																&nbsp;
															</td>
															<td id=bgtitle align='center'>
																客户预计出单日期
															</td>
															<td id=bgbody colspan=3>
																<bean:write name="ctb" property="customeroutdate" format="yyyy-MM-dd" />&nbsp;
															</td>
														</tr>
														<tr>
															<td id=bgtitle align='center'>
																最后反馈信息
															</td>
															<td id=bgbody colspan="8">
																&nbsp;${ctb.customerfeedback}
															</td>
														</tr>
														
														<tr>
															<td id=bgtitle align='center'>
																系统说明
															</td>
															<td id=bgbody colspan='7'>
																<logic:present name="ctb" property="employye">
																	<font color=red>&nbsp;  当前客户为独占客户，客户所有人是：${ctb.employye.ename}</font>
																</logic:present>
																<logic:notPresent name="ctb" property="employye">
																	<font color=red>&nbsp;  当前客户为公开客户,您可以联系该客户并在反馈中修改状态,使他成为您的独占客户</font>
																</logic:notPresent>
																
															</td>
														</tr>
													</table>
												</body>
											</td>
										</tr>
										<tr>
											<td bgcolor='#8BAAC9' height='1'></td>
										</tr>
										<tr>
											<td bgcolor='#F2F3F7' style='border-top: thin' align='right'>
												<font class='font5'> <span class='font3'>|</span>&nbsp;&nbsp;<a
													class='d' href='<%=request.getContextPath()%>/customer.crm?method=customerModiView&id=${ctb.customerid}'>信息修改</a>
													<span class='font3'>|</span>&nbsp;&nbsp;<a class='d'
													href='#' onclick="changeCustomerStyle(${id});">取消独享</a>
													<span class='font3'>|</span>&nbsp;&nbsp;<a class='d'
													href='javascript:jumpUrl(2);'>添加反馈</a> <span
													class='font3'>|</span>&nbsp;&nbsp;&nbsp;</font>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
				</form>
	</BODY>
</html>
