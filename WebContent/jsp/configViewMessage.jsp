<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
	  <script type='text/javascript' src='/NetSoftCRM/dwr/interface/ConfigAjax.js'></script>
	  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
	  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
	   <script type='text/javascript' src='/NetSoftCRM/dwr/interface/ConfigAjax.js'></script>	  
	<script type="text/javascript">
		var type;
		function del(id,t)
		{
			if(confirm('是否确信删除'))
			{
				if(id==999999)
				{
					alert("客户等级：[撤销客户] 不能被删除");
					return ;
				}
				if(t=="dj")
				{
					alert("客户等级暂时不支持删除！因为如果删除客户等级将导致自动运行程序无法更新数据！因为您设置了自动公开的功能，如果需要删除功能，请联系系统管理员开发新功能");
					return ;
				}
				type=t;
				ConfigAjax.delConfig(id,callBack);
			}
		}
		function callBack(msg)
		{
			if(msg==true)
			{
				alert("配置信息删除成功,谢谢您的操作");
				window.location.href("/NetSoftCRM/config.crm?method=configViewMessage&type="+type);
			}else
			{
				alert("当前配置信息删除失败, 请重试或者联系管理员");
			}
		}
		
		function changedz()
		  	{
		  		var topid=document.forms[0].customercounty.value;
		  		if(topid==0)
		  		{
		  			DWRUtil.removeAllOptions("city");
					DWRUtil.addOptions("city",[{configvalue:0,confignote:'市/地区'}],"configvalue","confignote");
		  		}else
		  		{
		  			ConfigAjax.getAllByType('dz',topid,callBack1);
		  		}
		  	}
  	function callBack1(msg)
  	{
  		DWRUtil.removeAllOptions("configmessage");
		DWRUtil.addOptions("configmessage",msg,"configvalue","confignote");
		initaddress();
  	}
	  
	 function initaddress()
	 {
	 	
	 	var con=document.forms[0].configmessage;
	 	document.forms[0].configvalue.value=con.options[con.selectedIndex].text;
	 }
	 
	 function check()
	 {
	 	if(document.forms[0].confignote.value=="")
	 	{
	 		alert("名称/区号必须填写!");
	 		return false;
	 	}
	 	if(document.forms[0].configvalue.value=="")
	 	{
	 		alert("地方名称必须填写!");
	 		return false;
	 	}
	 	return true;
	 }
	</script>
			
	</head>
	<br>
	<BODY text='#000000' topmargin=0>
		<table width='30%' border='0' cellspacing='0' cellpadding='0'
			height='21'>
			<tr>
				<td id=mainftitle>
					${typeName}[基本类型]维护
				</td>
			</tr>
		</table>
		<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
			class=bgtable align=center width=520>
			<tr>
				<TD id=bgtitle width=50 align='left' noWrap
					onclick="javascript:report.OrderBy.value='id';report.Direction.value='ASC';report.submit();"
					style="CURSOR: hand">
					编号
				</td>
				<logic:equal value="qh" name="type">
					<TD id=bgtitle width=80 align='left' noWrap
						onclick="javascript:report.OrderBy.value='taborder';report.Direction.value='DESC';report.submit();"
						style="CURSOR: hand">
						<img src='images/up.gif'></img>
						地方名称
					</td>
					<TD id=bgtitle align='left' noWrap
						style="CURSOR: hand">
						区号
					</td>
				</logic:equal>
				<logic:notEqual value="qh" name="type">
					<TD id=bgtitle width=80 align='left' noWrap
						onclick="javascript:report.OrderBy.value='taborder';report.Direction.value='DESC';report.submit();"
						style="CURSOR: hand">
						<img src='images/up.gif'></img>
						数字代表值
					</td>
					<TD id=bgtitle align='left' noWrap
						onclick="javascript:report.OrderBy.value='name';report.Direction.value='ASC';report.submit();"
						style="CURSOR: hand">
						名称
					</td>
				</logic:notEqual>
				<td id=bgtitle width=50>
					修改
				</td>
				<TD id=bgtitle width=50 noWrap>
					删除
				</TD>
			</tr>
			<logic:iterate id="configlist" name="configViewList">
				<TR bgcolor='#f7f5f0'
					onmouseout='this.style.backgroundColor="#f7f5f0"'
					onmouseover='this.style.backgroundColor="#EFEFEF"'>
					<TD id=bgbodyzzy align='left'>
						${configlist.configid}
					</TD>
					<TD id=bgbodyzzy align='left'>
						${configlist.configvalue}
					</TD>
					<logic:equal value="dz" name="type">
					<TD id=bgbodyzzy align='left'>
						<a href="<%=request.getContextPath()%>/config.crm?method=configViewMessage&type=dzsubtype&id=${configlist.configvalue}" style='CURSOR: hand'>${configlist.confignote}</a>
					</TD>
					</logic:equal>
					<logic:notEqual value="dz" name="type">
					<TD id=bgbodyzzy align='left'>
						${configlist.confignote}
						</TD>
					</logic:notEqual>
					<td id=bgbodyzzy align='center'>
						<a style='CURSOR: hand' href='/NetSoftCRM/config.crm?method=modiConfigView&id=${configlist.configid}'>修改</a>
					</td>
					<td id=bgbodyzzy align='center'>
						<a style='CURSOR: hand'
							onclick="del(${configlist.configid},'${configlist.configtype}');">删除</a>
					</td>
				</TR>
			</logic:iterate>
			<br />
			<html:form action="/config?method=addConfig" onsubmit="return check();">
				<table id=t1 name=t1 cellspacing=1 cellpadding=0 border=0
			class=bgtable align=center width=700>
					<TR>
						<TD id=bgtitle align=center colSpan=6>
							新建配置
							<html:hidden property="configtopid" value="0"/>
						</TD>
					</TR>
					<TR>
					<logic:equal value="qh" name="type">
						<TD id=bgtitle align=center width=50>
							区&nbsp;&nbsp;&nbsp;&nbsp;号
						</TD>
						<TD id=bgbody>
							<html:text property="confignote" styleClass="myinput"></html:text>
						</TD>
						
						<TD id=bgtitle align=center>
							地方名称
						</TD>
						<TD id=bgbody>
							<html:text property="configvalue" styleClass="myinput" readonly="true"></html:text>
							<html:hidden property="configtype" value="${type}"/>
						</TD>
						<TD id=bgtitle align=center>
							区号所属地区
						</TD>
						<TD id=bgbody>
							<select name="customercounty" onchange="changedz();">
								<option value="0">请选择</option>
								<logic:iterate id="config1" name="dzlist">
									<option value="${config1.configvalue}">${config1.confignote}</option>
								</logic:iterate>
							</select>
							省
							<html:select property="configmessage" styleClass="myselect" onchange="initaddress();">
								<html:option value="0">请选择</html:option>
							</html:select>
						</TD>
						</logic:equal>
						
						
						
				<logic:notEqual value="qh" name="type">
				
					<logic:equal value="dzsubtype" name="type">
						<TD id=bgtitle align=center width=50>
							名&nbsp;&nbsp;&nbsp;&nbsp;称
							<input type="hidden" name="id" value="${id}"> 
						</TD>
						<TD id=bgbody>
							<html:text property="confignote" styleClass="myinput"></html:text>
							<html:hidden property="configtype" value="${type}"/>
						</TD>
						<TD id=bgtitle align=center>
							折合数字代表值
						</TD>
						<TD id=bgbody>
							${maxcount+1}
							<html:hidden property="configvalue" value="${maxcount+1}"/>
						</TD>
						<TD id=bgtitle align=center width=50>
							配置说明
						</TD>
						<TD id=bgbody>
							<html:text property="configmessage" styleClass="myinput"></html:text>
						</TD>
					
					</logic:equal>
					<logic:notEqual value="dzsubtype" name="type">
						<TD id=bgtitle align=center width=50>
							名&nbsp;&nbsp;&nbsp;&nbsp;称
						</TD>
						<TD id=bgbody>
							<html:text property="confignote" styleClass="myinput"></html:text>
							<html:hidden property="configtype" value="${type}"/>
						</TD>
						<TD id=bgtitle align=center>
							折合数字代表值
						</TD>
						<TD id=bgbody>
							${maxcount+1}
							<html:hidden property="configvalue" value="${maxcount+1}"/>
						</TD>
						<TD id=bgtitle align=center width=50>
							配置说明
						</TD>
						<TD id=bgbody>
							<html:text property="configmessage" styleClass="myinput"></html:text>
						</TD>
						</logic:notEqual>
				</logic:notEqual>
					</tr>
					<TR>
						<TD id=bgtitle align=center colSpan=6>
							<html:submit value="确认增加" styleClass="mybutton"></html:submit>
						</TD>
					</TR>
				</table>
			</html:form>
	</BODY>
</html>
