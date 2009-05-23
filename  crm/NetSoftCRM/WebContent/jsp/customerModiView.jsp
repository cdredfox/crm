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
		var topid=document.forms[0].customerprovinceid.value;
		if(topid==0)
		{
			DWRUtil.removeAllOptions("customercityid");
			DWRUtil.addOptions("customercityid",[{configvalue:0,confignote:'市/地区'}],"configvalue","confignote");
		}else
		{
			ConfigAjax.getAllByType('dz',topid,callBack);
		}
	}
	function callBack(msg)
	{
		DWRUtil.removeAllOptions("customercityid");
		if(msg=="")
		{
			DWRUtil.addOptions("customercityid",[{configvalue:0,confignote:'市/地区'}],"configvalue","confignote");
			}else
			{
		DWRUtil.addOptions("customercityid",msg,"configvalue","confignote");
			}
		cityChange();
	}
	
	function cityChange()
	{
		var cityid=document.forms[0].customercityid.value;
		if(cityid==0)
			return;
		selCheck(document.forms[0].customerarea,cityid);
		selCheck(document.forms[0].customerfaxarea,cityid);
	}
  	
	function selCheck(c,k)
	{
		for (var i=0;i<c.options.length ;i++ )
		{
			if (c.options(i).value==k)
			{
			c.selectedIndex =i;
			break;
			}
		}
	}
    function check()
    {
    	 if(document.forms[0].customerprovinceid.value=="0")
         {
            alert("省/市必须选择！请选择省/市...");
            document.forms[0].customerprovinceid.focus();
            return false;
         }
         if(document.forms[0].customercityid.value=="")
         {
            alert("市/地区必须选择！请选择市/地区...");
            document.forms[0].customercityid.focus();
            return false;
         }
         if(document.forms[0].customeraddress.value=="")
         {
            alert("公司地址不能为空！请输入公司地址...");
            document.forms[0].customeraddress.focus();
            return false;
         }
        if(document.forms[0].customerfax.value=="")
        {
           alert("公司传真不能为空！请输入公司传真...");
           document.forms[0].customerfax.focus();
           return false;
        }
        if(document.forms[0].customerphone.value=="")
        {
           alert("公司电话不能为空！请输入公司电话...");
           document.forms[0].customerphone.focus();
           return false;
        }  
        if(document.forms[0].customerfax.value=="")
        {
           alert("公司传真不能为空！请输入公司传真...");
           document.forms[0].customerfax.focus();
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
	<html:form action="/customer?method=modiCustomer" onsubmit="return check();">
		<table width='800' border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td id=mainftitle>
					[ 客户详细资料信息 ]
				</td>
			</tr>
		</table>
		<table id=bgtable border='0' cellspacing='1'
			cellpadding='0' align=center>
			<tr>
				<td id=bgtitle colspan=8 align=center>
					<b>客户基本资料修改</b>
				</td>
			</tr>
			<tr>
				<td id=bgred>
					<font color=red>*</font>公司名称
				</td>
					<logic:equal value="Y" name="Employees" property="roleflag">
						<TD id=bgbody>
							<html:text property="customercompany" size="80"></html:text>
							<html:hidden property="customerid"></html:hidden>
						</td>
					</logic:equal>
					<logic:notEqual value="Y" name="Employees" property="roleflag">
					<TD id=bgbody>
					<html:text property="customercompany" readonly="true" size="80"></html:text>
					<html:hidden property="customerid"></html:hidden>
				</td>
				</logic:notEqual>
				</tr>
				
				<tr>
				<TD id=bgtitle nowrap>
					<font color=red>*</font>公司地址
				</TD>
				<TD id=bgbody colspan=3>
				<html:select property="customerprovinceid" onchange="changedz();">
						<html:option value="0">省/市</html:option>
						<logic:iterate id="dz" name="customerdz">
								<html:option value="${dz.configvalue}">${dz.confignote}</html:option>		
						</logic:iterate>
					</html:select>
					<html:select property="customercityid" onchange="cityChange();">
						<html:option value="0">市/地区</html:option>
						<logic:iterate id="city" name="customercity">
								<html:option value="${city.configvalue}">${city.confignote}</html:option>		
						</logic:iterate>
						
					</html:select>
					<html:text property='customeraddress' size='50'/>
				<!--  
				    <html:text property="customeraddress" styleClass="myinput" size="50"></html:text>
				-->
				</TD>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司电话
				</td>
				<logic:equal value="Y" name="Employees" property="roleflag">
				<td id=bgbody>
				<html:select property="customerarea" styleClass="myinput">
						<logic:iterate id="qh" name="customerqh">
							<logic:equal name="qh" property="confignote" value="${customerForm.customerarea}">
								<option value='${qh.configmessage}' selected="selected">${qh.confignote}</option>
							</logic:equal>
						<logic:notEqual name="qh" property="confignote" value="${customerForm.customerarea}">
							<option value='${qh.configmessage}'>${qh.confignote}</option>
						</logic:notEqual>
						</logic:iterate>
					</html:select>
					<html:text property="customerphone" size="14" maxlength="14"></html:text>
					&nbsp;
				</td>
				</logic:equal>
				<logic:notEqual value="Y" name="Employees" property="roleflag">
				<td id=bgbody>
				    <html:text property="customerphone" styleClass="myinput" size="14" readonly="true"></html:text>
					&nbsp;
				</td>
				</logic:notEqual>
			</tr>
			<tr>
				<td id=bgred colspan=1>
					<font color=red>*</font>公司传真
				</td>
				<td id=bgbody>
				<html:select property="customerfaxarea" styleClass="myinput">
						<logic:iterate id="fax" name="customerqh">
							<logic:equal name="fax" property="confignote" value="${customerForm.customerfaxarea}">
								<option value='${fax.configmessage}' selected="selected">${fax.confignote}</option>
							</logic:equal>
							<logic:notEqual name="fax" property="confignote" value="${customerForm.customerfaxarea}">
								<option value='${fax.configmessage}'>${fax.confignote}</option>
							</logic:notEqual>
						</logic:iterate>
					</html:select>
					<html:text property="customerfax" size="14" maxlength="14"></html:text>
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
					<input type=text class=myinput value='${ename}' size=14
						maxLength=14 readonly="readonly">
					&nbsp;
					
					<html:hidden property="eid" value="${eid}"/>
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