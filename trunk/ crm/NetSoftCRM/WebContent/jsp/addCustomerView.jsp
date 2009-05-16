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
  <script type="text/javascript">
  	function changedz()
  	{
  		var topid=document.forms[0].customercounty.value;
  		if(topid==0)
  		{
  			DWRUtil.removeAllOptions("city");
			DWRUtil.addOptions("city",[{configvalue:0,confignote:'市/地区'}],"configvalue","confignote");
  		}else
  		{
  			ConfigAjax.getAllByType('dz',topid,callBack);
  		}
  	}
  	function callBack(msg)
  	{
  		DWRUtil.removeAllOptions("city");
		DWRUtil.addOptions("city",msg,"configvalue","confignote");
		cityChange();
  	}
  	
  	function cityChange()
  	{
  		var cityid=document.forms[0].city.value;
  		selCheck(document.forms[0].phonenumer,cityid);
  		selCheck(document.forms[0].faxnumber,cityid);
  	}
  	
  	
	function selCheck(c,k)
	{
		for (var i=0;i<c.options.length ;i++ )
		{
		
			if (c.options(i).value==k)
			{
			c.selectedIndex =i;
			}
		}
	}
    function check()
    {
        if(document.forms[0].customercompany.value=="")
        {
           alert("公司名称不能为空！请输入公司名称...");
           document.forms[0].customercompany.focus();
           return false;
        }
        if(document.forms[0].customercounty.value=="0")
        {
           alert("省/市必须选择！请选择省/市...");
           document.forms[0].customercounty.focus();
           return false;
        }
        if(document.forms[0].city.value=="")
        {
           alert("市/地区必须选择！请选择市/地区...");
           document.forms[0].city.focus();
           return false;
        }
        if(document.forms[0].address.value=="")
        {
           alert("公司地址不能为空！请输入公司地址...");
           document.forms[0].address.focus();
           return false;
        }
        if(document.forms[0].pnumber.value=="")
        {
           alert("公司电话不能为空！请输入公司电话...");
           document.forms[0].pnumber.focus();
           return false;
        }  
  		if(isNaN(document.forms[0].pnumber.value)==true)
	    {
		    alert("公司电话请输入数字!");
		    return false;
	    }
        if(document.forms[0].fnumber.value=="")
        {
           alert("公司传真不能为空！请输入公司传真...");
           document.forms[0].fnumber.focus();
           return false;
        }       
  		if(isNaN(document.forms[0].fnumber.value)==true)
	    {
		    alert("公司传真请输入数字!");
		    return false;
	    }
        if(document.forms[0].customerprice.value=="")
        {
           alert("公司报价不能为空！请输入公司报价...");
           document.forms[0].customerprice.focus();
           return false;
        }       
  		if(isNaN(document.forms[0].customerprice.value)==true)
	    {
		    alert("报价请输入数字!");
		    return false;
	    }     
        if(document.forms[0].customername.value=="")
        {
           alert("公司联系人不能为空！请输入公司联系人...");
           document.forms[0].customername.focus();
           return false;
        }
        if(document.forms[0].customerhandset.value=="")
        {
           alert("联系人手机不能为空！请输入联系人手机...");
           document.forms[0].customerhandset.focus();
           return false;
        }            
  		if(isNaN(document.forms[0].customerhandset.value)==true)
	    {
		    alert("联系人手机请输入数字!");
		    return false;
	    }
        return true;
    }
  	function GetDate ()
			{
			  reVal = window.showModalDialog("/NetSoftCRM/jsp/showDate.htm", '',
				"status:no;center:yes;scroll:no;resizable:no;help:no;dialogWidth:255px;dialogHeight:260px");
			  document.forms[0].customeroutdate.value=reVal;
			}
  </script>

			
	</head>
	<br>
	<BODY>
	<html:form action="/customer?method=addCustomer" onsubmit="return check();">
		<table width='800' border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td id=mainftitle>
					[ 客户详细资料录入 ]
				</td>
			</tr>
		</table>
		<table id=bgtable border='0' cellspacing='1'
			cellpadding='0' align=center>
			<tr>
				<td id=bgtitle colspan=8 align=center>
					<b>客户基本资料</b>
				</td>
			</tr>
			<tr>
				<td id=bgred>
					<font color=red>*</font>公司名称
				</td>
				<TD id=bgbody>
					<html:text property="customercompany" size="80"></html:text>
				</td>
				</tr>
				<tr>
				<TD id=bgtitle nowrap>
					公司地址
				</TD>
				<TD id=bgbody colspan=3>
					<select name="customercounty" onchange="changedz();">
						<option value="0">省/市</option>
						<logic:iterate id="dz" name="customerdz">
								<option value="${dz.configvalue}">${dz.confignote}</option>		
						</logic:iterate>
					</select>
					<select name="city" onchange="cityChange();">
						<option>市/地区</option>
					</select>
					<input name='address' size=50 class=myinput value=''>
				</TD>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司电话
				</td>
				<td id=bgbody>
				<select class=myinput name="phonenumer">
						<logic:iterate id="qh" name="customerqh">
							<option value='${qh.configmessage}'>${qh.confignote}</option>
						</logic:iterate>
					</select>
					<input type=text class=myinput name=pnumber value='${phone}' size=14
						maxLength=14>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司传真
				</td>
				<td id=bgbody>
				<select class=myinput id="faxnumber">
						<logic:iterate id="fax" name="customerqh">
							<option value='${fax.configmessage}'>${fax.confignote}</option>
						</logic:iterate>
					</select>
					<input type=text class=myinput name=fnumber value='' size=14
						maxLength=14>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司性质
				</td>
				<td id=bgbody>
					<html:select property="customerproperty">
						<logic:iterate id="xz" name="customerxz">
							<html:option value="${xz.configid}">${xz.confignote}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司所有制性质
				</td>
				<td id=bgbody>
					<html:select property="customerowenerxz">
						<logic:iterate id="syzxz" name="customersyzxz">
							<html:option value="${syzxz.configid}">${syzxz.confignote}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>客户来源
				</td>
				<td id=bgbody>
					<html:select property="customersource">
						<logic:iterate id="ly" name="customerly">
							<html:option value="${ly.configid}">${ly.confignote}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>客户级别
				</td>
				<td id=bgbody>
					<html:select property="cutomergrade">
						<logic:iterate id="dj" name="customerdj">
							<html:option value="${dj.configid}">${dj.confignote}</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>报价
				</td>
				<td id=bgbody>
					<html:text property="customerprice" styleClass="myinput"></html:text>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司联系人
				</td>
				<td id=bgbody>
					<html:text property="customername" styleClass="myinput"></html:text>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>联系人手机
				</td>
				<td id=bgbody>
					<html:text property="customerhandset" styleClass="myinput"></html:text>
				</td>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>客户所有人
				</td>
				<td id=bgbody>
					<input type=text class=myinput value='${Employees.ename}' size=14
						maxLength=14 readonly="readonly">
					&nbsp;
					<html:hidden property="eid" value="${Employees.id}"/>
				</td>
			</tr>
			<tr>
				<td id=bgtitle colspan=8 align="left">
					<font color="red">小提醒：不知道的选项可以输入0代替！</font>
				</td>
			</tr>
			<tr>
				<td id=bgtitle colspan=8 align=center>
					<input name=bb type=submit value=提交 class=mybutton>
				</td>
			</tr>
		</table>
		</html:form>
	</body>
</html>