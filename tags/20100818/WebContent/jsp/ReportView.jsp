<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
			<script type='text/javascript' src='<%=request.getContextPath()%>/js/tablesort.js'></script>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/ConfigAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
		<script type="text/javascript">

			function onSubmit()
			{
				var obj=document.getElementsByName("custId");
				var checkFlag=false;
				for(var i=0;i<obj.length;i++)
				{
					if(obj[i].checked)
					{
						checkFlag=true;
						break;
						}
					}
				if(checkFlag)
				{
					var name=event.srcElement.name;
					if(event.srcElement.value=="-1")
					{
						alert("请选择正确的选项，您选择的[请选择]无效!");
						return ;
						}
					document.getElementsByName("control")[0].value=name;
					document.forms[1].submit();
					}
				else
				{
					alert("您没有选中任保客户,请至少选择一个客户进行操作！");
					}
				}
			function checkAll()
			{
				var obj=document.getElementsByName("custId");
				if(event.srcElement.checked)
				{
					for(var i=0;i<obj.length;i++)
					{
						obj[i].checked=true;
						}
					document.getElementById("topAllCheck").checked=true;
					document.getElementById("downAllCheck").checked=true;
					}else{
						for(var i=0;i<obj.length;i++)
						{
							obj[i].checked=false;
							}
						document.getElementById("topAllCheck").checked=false;
						document.getElementById("downAllCheck").checked=false;
						}
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
			
			function check()
			{
				
				if(document.forms[0].startdate!=null && document.forms[0].startdate.value=="")
				{
					alert("开始日期不能为空！请选择");
					return false;
				}
				if(document.forms[0].enddate!=null&&document.forms[0].enddate.value=="")
				{
					alert("结束日期不能为空！请选择");
					return false;
				}
				return true;
			}
			
			function changedz()
  	{
  		var topid=document.forms[0].customercounty.value;
  		if(topid==0)
  		{
  			DWRUtil.removeAllOptions("city");
			DWRUtil.addOptions("city",[{configvalue:0,confignote:'全部'}],"configvalue","confignote");
  		}else
  		{
  			ConfigAjax.getAllByType('dz',topid,callBack);
  		}
  	}
  	function callBack(msg)
  	{
  		DWRUtil.removeAllOptions("city");
  		DWRUtil.addOptions("city",[{configvalue:0,confignote:'全部'}],"configvalue","confignote");
		DWRUtil.addOptions("city",msg,"configvalue","confignote");
		//cityChange();
  	}
			
			</script>
	</head>
	<body>
		<table width='100%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle colspan=2>
					<logic:notPresent name="flag">
					[ 反馈统计报表 ]
			    </logic:notPresent>
					<logic:present name="flag">
						<logic:equal value="flag" name="flag">
						[ 新增客户统计 ]
					</logic:equal>
						<logic:equal value="colligate" name="flag">
						[ 综合业务统计 ]
					</logic:equal>
						<logic:equal value="inback" name="flag">
						[ 内网客户反馈统计报表 ]
					</logic:equal>
						<logic:equal value="busiowen" name="flag">
						[ 各业务人员当前客户统计数据报表 ]
					</logic:equal>
					<logic:equal value="busiowen" name="flag">
						[ 反馈统计明细表 ]
					</logic:equal>
					</logic:present>
				</td>
			</tr>
			<tr>
		</table>
		<br>
		<div align=center>
			<html:form action="/report?method=feedbackReport"
				onsubmit="return check();">
				<input type="hidden" name="flag" value="${flag}" />
				<table width=800>
				
					<!-- 以下是反馈统计明细表的选项 -->
					<logic:equal value="feedbackDaily" name="flag">
						<td align="center">
							<table>
								
								<tr>
									<td>
										&nbsp;业务员名称:
									</td>
										<td>
											<html:select property="eid">
												<logic:iterate id="e" name="el">
													<html:option value="${e.id}">${e.ename}</html:option>
												</logic:iterate><!--  
												<html:option value="open">公开客户</html:option>-->
											</html:select>
										</td>
									<td>
										查询日期:
									</td>
									<td>
										<html:text property="startdate" size="10" maxlength="10"
											styleClass="myinput" readonly="true" />
										<img src='/NetSoftCRM/images/calendar.jpg' border=0
											onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
									</td>
									<td>
										<html:submit styleClass="mybutton" value="查询"></html:submit>
									<td>
								</tr>
							</table>
						</td>
					</logic:equal>
					
					<!--
				    以下是内网客户反馈统计报表的选项 
				 -->
					<logic:equal value="inback" name="flag">
						<td align="center">
							<table>
								<tr>
									
									<td>
										&nbsp;公司名称:
									</td>
									<td>
										<html:text property="companyName"></html:text>
									</td>
								</tr>
								<tr>
									<td>
										&nbsp;客户所有人:
									</td>
									<logic:equal value="Y" name="Employees" property="viewFlag">
										<td>
											<html:select property="eid">
												<html:option value="">全部</html:option>
												<logic:iterate id="e" name="el">
													<html:option value="${e.id}">${e.ename}</html:option>
												</logic:iterate>
												<html:option value="open">公开客户</html:option>
											</html:select>
										</td>
									</logic:equal>
									<logic:notEqual value="Y" name="Employees" property="viewFlag">
										<td>
											<html:select property="eid">
												<html:options collection="subordinate" labelProperty="ename" property="id"/>
												<html:option value="open">公开客户</html:option>
											</html:select>
										</td>
									</logic:notEqual>
								</tr>

								<tr>
									<td>
										客户级别：
									</td>

									<td>
										<html:select property="qrydz">
											<html:option value="">全部</html:option>
											<logic:iterate id="qry" name="qrylist">
												<html:option value="${qry.configid}">${qry.confignote}</html:option>
											</logic:iterate>
										</html:select>
									</td>


								</tr>

								<tr>
									<td>
										客户性质：
									</td>
									<td>
										<html:select property="qryxz">
											<html:option value="">全部</html:option>
											<logic:iterate id="qry1" name="xzlist">
												<html:option value="${qry1.configid}">${qry1.confignote}</html:option>
											</logic:iterate>
										</html:select>
									</td>
								</tr>
								<tr>
									<td>
										客户地址：
									</td>
									<td>

										<select name="customercounty" onchange="changedz();">
											<option value="0">
												全部
											</option>
											<logic:iterate id="dz" name="customerdz">
												<option value="${dz.configvalue}">
													${dz.confignote}
												</option>
											</logic:iterate>
										</select>
										<select name="city">
											<option value="0">
												全部
											</option>
										</select>

									</td>
								</tr>
								<tr>
									<td>
										选择查询起止日期:
									</td>
									<td>
										<html:text property="startdate" size="10" maxlength="10"
											styleClass="myinput" readonly="true" />
										<img src='/NetSoftCRM/images/calendar.jpg' border=0
											onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
										—
										<html:text property="enddate" size="10" maxlength="10"
											styleClass="myinput" readonly="true" />
										<img src='/NetSoftCRM/images/calendar.jpg' border=0
											onclick='GetDate(2);' style='cursor: hand' align='absmiddle'>
									</td>
								</tr>
								<tr>
									<td>
										<html:submit styleClass="mybutton" value="查询"></html:submit>
									<td>
								</tr>
							</table>
						</td>
					</logic:equal>

					<!--
				    以下是综合查询统计报表的选项 
				 -->

					<logic:equal value="colligate" name="flag">
						<td align="center">
							<table>
								<tr>
									<td>
										选择查询起止日期:
									</td>
									<td>
										<html:text property="startdate" size="10" maxlength="10"
											styleClass="myinput" readonly="true" />
										<img src='/NetSoftCRM/images/calendar.jpg' border=0
											onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
										—
										<html:text property="enddate" size="10" maxlength="10"
											styleClass="myinput" readonly="true" />
										<img src='/NetSoftCRM/images/calendar.jpg' border=0
											onclick='GetDate(2);' style='cursor: hand' align='absmiddle'>
									</td>
								</tr>
								<tr>
									<td>
										客户级别：
									</td>
									<td>
										<html:select property="qrydz">
											<logic:iterate id="qry" name="qrylist">
												<html:option value="${qry.configid}">${qry.confignote}</html:option>
											</logic:iterate>
										</html:select>
									</td>
								</tr>
								<tr>
									<td>
										类别:
									</td>
									<td>
										<html:radio property="type" value="xz">性质</html:radio>
										<!--  
							<html:radio property="type" value="dq">地区</html:radio>
							-->
										<html:radio property="type" value="ly">来源</html:radio>
									</td>
								</tr>
								<tr>
									<td>
										<html:submit styleClass="mybutton" value="查询"></html:submit>
									<td>
								</tr>
							</table>
						</td>
					</logic:equal>
					<!-- 新增客户统计 -->
					<logic:equal value="flag" name="flag">
						<tr>
							<td>
								选择查询起止日期:
								<html:text property="startdate" size="10" maxlength="10"
									styleClass="myinput" readonly="true" />
								<img src='/NetSoftCRM/images/calendar.jpg' border=0
									onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
								—
								<html:text property="enddate" size="10" maxlength="10"
									styleClass="myinput" readonly="true" />
								<img src='/NetSoftCRM/images/calendar.jpg' border=0
									onclick='GetDate(2);' style='cursor: hand' align='absmiddle'>
								<html:submit styleClass="mybutton" value="查询"></html:submit>
							</td>
						</tr>
					</logic:equal>
					<!-- 反馈报表 -->
					<logic:equal value="" name="flag">
						<tr>
							<td>
								选择查询起止日期:
								<html:text property="startdate" size="10" maxlength="10"
									styleClass="myinput" readonly="true" />
								<img src='/NetSoftCRM/images/calendar.jpg' border=0
									onclick='GetDate(1);' style='cursor: hand' align='absmiddle'>
								—
								<html:text property="enddate" size="10" maxlength="10"
									styleClass="myinput" readonly="true" />
								<img src='/NetSoftCRM/images/calendar.jpg' border=0
									onclick='GetDate(2);' style='cursor: hand' align='absmiddle'>
								<html:submit styleClass="mybutton" value="查询"></html:submit>
							</td>
						</tr>
					</logic:equal>
				</table>
			</html:form>
			<html:form action="/report?method=batchControl">
			<table width="800" cellspacing="1" cellpadding="0" border="0" id="bgtable" onclick="sortColumn(event)">
				<thead>
				<tr>
					<td id=bgtitle>
						&nbsp;
					</td>
					<td id=bgtitle colspan=11>
						<logic:notPresent name="flag">
						各业务人员客户反馈数据报表
						</logic:notPresent>
						<logic:present name="flag">

							<logic:equal value="flag" name="flag">
								各业务人员新增客户统计数据报表
								</logic:equal>
							<logic:equal value="colligate" name="flag">
								各业务人员客户综合统计数据报表
							</logic:equal>
							<logic:equal value="inback" name="flag">
								内网客户反馈统计数据报表
							</logic:equal>
							<logic:equal value="busiowen" name="flag">
						各业务人员当前客户统计数据报表
					</logic:equal>
					<!-- 以下是反馈统计明细表的选项 -->
					<logic:equal value="feedbackDaily" name="flag">
						反馈统计明细表
					</logic:equal>
						</logic:present>
					</td>
				</tr>
				<tr>
					<logic:equal value="inback" name="flag">
						<td id=bgtitle>
								&nbsp;<input type="checkbox" id="topAllCheck" onclick="checkAll();"/>
									</td>
						<td id=bgtitle>
							公司名称
						</td>
					</logic:equal>
				
					<logic:notEqual value="inback" name="flag">
							<!-- 以下是反馈统计明细表 -->
						<logic:equal value="feedbackDaily" name="flag">
							<td id=bgtitle>
								时间段
							</td>
						</logic:equal>
					<!-- 反馈统计明细表结束 -->
						<logic:notEqual value="feedbackDaily" name="flag">
							<td id=bgtitle>
								业务员名称
							</td>
						</logic:notEqual>
					</logic:notEqual>
					<logic:present name="fklist">
						<logic:iterate id="fl" name="fklist">
							<td id=bgtitle>
								${fl.confignote}
							</td>
						</logic:iterate>
					</logic:present>

					<td id=bgtitle>
						合计
					</td>
					<logic:equal value="inback" name="flag">
						<td id=bgtitle>
							最后反馈类型
						</td>
					</logic:equal>

					<logic:equal value="inback" name="flag">
						<td id=bgtitle>
							多久不反馈将公开
						</td>
					</logic:equal>
				</tr>
				</thead>
				
				<logic:present name="frb">
				<tbody>
					<logic:iterate id="f" name="frb">
						<tr>
							<logic:equal value="1" property="iscolor" name="f">
								<logic:equal value="inback" name="flag">
									<td id=bgbody align="center">
										&nbsp;<input type="checkbox" name="custId" value="${f.customerid}"/>
									</td>
									<td id=bgbody align="center">
										<font color="red"><a
											href="<%=request.getContextPath()%>/customer.crm?method=detailInfo&id=${f.customerid}">${f.ename}</a>
										</font>
									</td>
								</logic:equal>
								<logic:notEqual value="inback" name="flag">
									<td id="bgbody" align="center">
										<font color="red">${f.ename}</font>
									</td>
								</logic:notEqual>
								<logic:present name="fklist">
									<logic:iterate id="fl" name="fklist">
										<logic:present name="f" property="feedsubbean">
											<logic:iterate id="fb" name="f" property="feedsubbean">
												<logic:equal value="${fl.configid}" name="fb"
													property="type">
													<td id=bgbody align="center">
														<font color="red">${fb.num}</font>
													</td>
												</logic:equal>
											</logic:iterate>
										</logic:present>
									</logic:iterate>
								</logic:present>
								<td id=bgbody align="center">
									<font color="red">${f.count}</font>
								</td>
								<logic:equal value="inback" name="flag">
									<td id=bgbody>
										<logic:iterate id="fk" name="fklist">
											<logic:equal value="${f.lastfeedbacktype}" name="fk"
												property="configid">
												<font color="red">${fk.confignote}</font>
											</logic:equal>
										</logic:iterate>
										&nbsp;

									</td>
								</logic:equal>

								<logic:equal value="inback" name="flag">
									<td id=bgbody>
										<font color="red">${f.openDate}</font>
									</td>
								</logic:equal>
							</logic:equal>
							<logic:notEqual value="1" property="iscolor" name="f">
								<logic:equal value="inback" name="flag">
									<td id=bgbody align="center">
										&nbsp;<input type="checkbox" name="custId" value="${f.customerid}"/>
									</td>
									<td id=bgbody align="center">
										<a
											href="<%=request.getContextPath()%>/customer.crm?method=detailInfo&id=${f.customerid}">${f.ename}</a>
									</td>
								</logic:equal>
								<logic:notEqual value="inback" name="flag">
									<td id="bgbody" align="center">
										<b>${f.ename}</b>
									</td>
								</logic:notEqual>
								<logic:present name="fklist">
									<logic:iterate id="fl" name="fklist">
										<logic:present name="f" property="feedsubbean">
											<logic:iterate id="fb" name="f" property="feedsubbean">
												<logic:equal value="${fl.configid}" name="fb"
													property="type">
													<td id=bgbody align="center">
														${fb.num}
													</td>
												</logic:equal>
											</logic:iterate>
										</logic:present>
									</logic:iterate>
								</logic:present>
								<td id=bgbody align="center">
									${f.count}
								</td>
								<logic:equal value="inback" name="flag">
									<td id=bgbody>
										<logic:iterate id="fk" name="fklist">
											<logic:equal value="${f.lastfeedbacktype}" name="fk"
												property="configid">
																		${fk.confignote}
																	</logic:equal>
										</logic:iterate>
										&nbsp;

									</td>
								</logic:equal>

								<logic:equal value="inback" name="flag">
									<td id=bgbody>
										${f.openDate}
									</td>
								</logic:equal>
							</logic:notEqual>


						</tr>
					</logic:iterate>
					</tbody>
				</logic:present>
			
				<logic:present name="countfrb">
					<logic:present name="countfrb" property="feedsubbean">
						<tr>
						<logic:equal value="inback" name="flag">
							<td id=bgtitle>
										&nbsp;<input type="checkbox" id="downAllCheck" onclick="checkAll();"/>
									</td>
							</logic:equal>		
							<td id=bgtitle>
								${countfrb.ename}
							</td>
							<logic:present name="fklist">
								<logic:iterate id="fl" name="fklist">
									<logic:iterate id="cfb" name="countfrb" property="feedsubbean">
										<logic:equal value="${fl.configid}" name="cfb" property="type">
											<td id=bgtitle>
												${cfb.num}
											</td>
										</logic:equal>
									</logic:iterate>
								</logic:iterate>
							</logic:present>
							<td id=bgtitle>
								${countfrb.count}
							</td>
							<logic:equal value="inback" name="flag">
								<td id=bgtitle>
									&nbsp;
								</td>
							</logic:equal>
							<logic:equal value="inback" name="flag">
								<td id=bgtitle>
									${countfrb.openDate}&nbsp;
								</td>
							</logic:equal>
						</tr>
					</logic:present>
				</logic:present>
			</table>
			<DIV class=bgdiv id=divid>
				<table cellpadding='1' cellspacing='1' width=50>
					<td width=100%>
						<span id=tablepage></span>
					</td>
				</table>
			</DIV>
	<logic:equal value="inback" name="flag">
		<logic:equal value="Y" name="Employees" property="batchControlFlag">
			<table width="600" cellspacing="1" cellpadding="0" border="0" id="bgtable">
				<tr><td id=bgtitle colspan=4>批量操作栏</td></tr>
				<tr>
					<td id=bgtitle >
						批量修改客户级别：</td><td id=bgbody><select onchange="onSubmit();" name="changeGrade">
											<option value="-1">请选择</option>
											<logic:iterate id="qry" name="qrylist">
												<option value="${qry.configid}">${qry.confignote}</option>
											</logic:iterate>
										</select>
											
					</td>
					<td id=bgtitle>
						批量删除客户：</td><td id=bgbody><input type="button" value="确定批量删除" onclick="onSubmit();" name="batchDel"/>
					</td>
				</tr>
				<tr>
					<td id=bgtitle> 
						批量更改客户所有人：</td><td id=bgbody><select onchange="onSubmit();" name="changeOwener">
												<option value="-1">请选择</option>
												<logic:iterate id="e" name="el">
													<option value="${e.id}">${e.ename}</option>
												</logic:iterate>
												<option value="open">公开客户</option>
											</select>
					</td>
					<td id=bgtitle>
						批量公开客户：</td><td id=bgbody><input type="button" value="确定批量公开" onclick="onSubmit();" name="batchOpen"/>
					</td>
				</tr>
			</table>
			<input type="hidden" name="control" />
			</logic:equal>
			</logic:equal>
			</html:form>
	</BODY>
</html>
