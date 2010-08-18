<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/CustomerAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
		<script type="text/javascript">
  	function check()
  	{
  		if(document.forms[0].phone.value=="" && document.forms[0].customercompany.value=="")
  		{
  			alert("电话号码和公司名称必须填写一项!");
  			return false;
  		}
  		if(document.forms[0].customercompany.value.length<2)
  		{
  			alert("客户名称必须大于一个字符!");
  			return false;
  		}
  		return true;
  	}
  	function checkInfo()
  	{
  		if(check())
  		{
	  		var phonetype=document.forms[0].phonetype.value;
	  		var phone=document.forms[0].phone.value;
	  		var customername=document.forms[0].customercompany.value;
	  		CustomerAjax.checkCustomer(phonetype,phone,customername,callBack);
  		}
  	}
  	function callBack(msg)
  	{
  		if(msg==2)
  		{
  			alert("当前系统中已经存在您录入的客户信息并且该客户为独享客户!不能重复录入,请确认!");
  		}else if(msg==0)
  		{
  			document.forms[0].submit();
  		}else
  		{
  			//var companyname=document.getElementsByName("customercompany")[0].value;
  			alert("您录入的客户名称,在系统中已存在,但该客户为公开客户或撤销客户,将跳转到列表页面,供您操作!");
  			//alert(companyname);
  			//window.location.href("/NetSoftCRM/customer.crm?method=customerList&companyname="+companyname);
  			document.forms[0].action="/NetSoftCRM/customer.crm?method=customerList";
  			document.forms[0].submit();
  		}
  	}
  </script>

	</head>
	<BODY>
		<html:form action="/customer?method=addCustomerView">
			<table width='800' border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td id=mainftitle>
						[ 客户信息录入验证 ]
					</td>
				</tr>
			</table>
			<table id=bgtable width='680' border='0' cellspacing='1'
				cellpadding='0' align=center>
				<tr>
					<td id=bgtitle colspan=5 align=center>
						<b>客户资料验证</b><font color="red">*(电话不用输区号)</font>
					</td>
				</tr>
				<tr>
					<td id=bgred colspan=1>
						<font color=red>*</font>电话类型
					</td>
					<td id=bgbody>
						<html:select property="phonetype">
							<option value="2">
								电话
							</option>
							<option value="1">
								手机
							</option>
						</html:select>
					</td>
					<td id=bgbody width="30">
						<html:text property="phone"></html:text>
					</td>
					<td id=bgred colspan=1>
						<font color=red>*</font>公司名称
					</td>
					<td id=bgbody>
						<html:text property="customercompany" size="50"></html:text>
					</td>
				</tr>
				<tr>
					<td id=bgtitle colspan=5 align=center>
						<input type="button" value=提交 class=mybutton
							onclick="checkInfo();">
					</td>
			</table>
		</html:form>
	</body>
</html>