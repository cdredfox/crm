<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<title>sys_user_edit</title>
	</head>
	<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
		rel=stylesheet type=text/css>
	<script type="text/javascript">
	   function check(){
          if(document.forms[0].oldpwd.value=="") {
              alert("您的原密码不能为空！");
              document.forms[0].oldpwd.focus();   
              return false;
          }
          if(document.forms[0].newpwd.value==""){
             alert("您的新密码不能为空！");
             document.forms[0].newpwd.focus();
             return false;
          }
          if(document.forms[0].renewpwd.value==""){
             alert("您的重复新密码不能为空！");
             document.forms[0].renewpwd.focus();
             return false;
          }
          if(document.forms[0].newpwd.value != document.forms[0].renewpwd.value){
            alert("您的新密码和重复新密码输入不一致！");
            document.forms[0].newpwd.value="";
            document.forms[0].renewpwd.value="";
            document.forms[0].newpwd.focus();
            return false;
          }
          if(document.forms[0].newpwd.value.length<6)
          {
            alert("密码长度不能小于6位！");
            document.forms[0].newpwd.value="";
            document.forms[0].renewpwd.value="";
            document.forms[0].newpwd.focus();
            return false;
          }
	   }
	</script>	
	<table width='700' border='0' cellspacing='0' cellpadding='0'
		height='21'>
		<tr>
			<td id=mainftitle>
				用户密码修改
			</td>
		</tr>
	</table>
	<table border=0 cellspacing=1 cellpadding=0 id=bgtable align=center>
		<html:form action="/employee?method=changePWD" onsubmit="return check();">
			<tr>
				<td id=bgtitle colspan=4>
					输入原始密码与新密码
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					原密码:
				</td>
				<td id=bgbody>
					<input type="password" name="oldpwd" class="myinput"/>
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					新密码:
				</td>
				<td colspan=1 id=bgbody>
					<input type="password" name="newpwd" class="myinput"/>
				</td>
			</tr>
			<tr>
				<td id=bgtitle>
					重复新密码:
				</td>
				<td colspan=1 id=bgbody>
					<input type="password" name="renewpwd" class="myinput"/>
				</td>
			</tr>
			<tr>
				<td id=bgtitle align=center colspan=4>
					<html:submit value="确定修改密码" styleClass="mybutton"></html:submit>
				</td>
			</tr>
		</html:form>
		
	</table>
	<DIV class=bgdiv id=divid>
		<table cellpadding='1' cellspacing='1' width=50>
			<td width=100%>
				<span id=tablepage></span>
			</td>
		</table>
	</DIV>
</html>
