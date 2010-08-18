<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<title>sys_user_add</title>
	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<script type='text/javascript'
		src='/NetSoftCRM/dwr/interface/FeedbackStyleAjax.js'></script>
	<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
	<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>

	<script type="text/javascript">
		
		function changeFeedback()
		{
			var f=document.getElementsByName("fid")[0].value;
			if(f==0)
			{
				document.getElementsByName("style")[0].value="";
			}else
			{
				FeedbackStyleAjax.qryFeedbackStyleByFid(f,callback);
			}
		}
	function callback(msg)
	{
		 if(msg=="")
		 {
		 	document.getElementsByName("style")[0].value="";
		 	document.getElementsByName("id")[0].value="";
		 	return ;
		 }
			var obj=msg.split("@@@");
			document.getElementsByName("id")[0].value=obj[0];
			document.getElementsByName("style")[0].value=obj[1];
		
		
	}
	
	function sendMsg()
	{
		var f=document.getElementsByName("fid")[0].value;
		if(f==0)
		{
			alert("必须选择相应的反馈类型!");
			return false;
		}
		//var b=document.all["style"].value;
		//while(b.indexOf("\r\n")>=0)
		//b=b.replace("\r\n","<br/>");
		//document.getElementsByName("style")[0].value=b;
		return true;
	}
	</script>
	<table width='700' border='0' cellspacing='0' cellpadding='0'
		height='21'>
		<tr>
			<td id=mainftitle>
				[ 客户反馈内容格式设置 ]
			</td>
		</tr>
	</table>
	<html:form action="/feedbackstyle?method=saveStyle" onsubmit="return sendMsg();">
		<table cellspacing=1 cellpadding=0 border=0 id=bgtable align=center>
			<tr>
				<td align=center id=bgtitle colspan="2">
					新增客户反馈信息格式设置
				</td>
			</tr>
			<tr>
				<td id=bgtitle align="right">
					反馈类型：
					<html:hidden property="id" />
				</td>
				<td id=bgbody>
					<html:select property="fid" onchange="changeFeedback();">
						<html:option value="0">
						请选择
					</html:option>
						<logic:iterate id="fk" name="fklist">
							<html:option value="${fk.configid}">
							${fk.confignote}
						</html:option>
						</logic:iterate>
					</html:select>
				</td>
			</tr>
			<tr>
				<td id=bgbody colspan="2">
					<html:textarea property="style" rows="10" cols="50"></html:textarea>
				</td>
			</tr>

			<tr>
				<td id=bgbody colspan="2">
					<html:submit>确认修改反馈格式</html:submit>
					<input type="reset" value="重置">
				</td>
			</tr>

		</table>
	</html:form>
	<DIV class=bgdiv id=divid>
		<table cellpadding='1' cellspacing='1' width=50>
			<td width=100%>
				<span id=tablepage></span>
			</td>
		</table>
	</DIV>
</html>
