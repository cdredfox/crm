<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META http-equiv=REFRESH content=20>
<SCRIPT language=Javascript>
</script>




<!--
 function OpenSmallWindows(strURL)
 {
 window.open (strURL,"_blank",
 "status=no,resizable=0,toolbar=no,status=no,menubar=no,scrollbars=no,width=404,height=205,left=200,top=150");
 }
	//-->	</SCRIPT>

<SCRIPT language=Javascript>
<!--
		if(parent.bottom!=null)
		parent.bottom.email.innerHTML ="<a href='#' target='detail'><img src='<%=request.getContextPath()%>/images/mail_0.gif' alt='没有新邮件！' border=0 ></a>"
	//-->	</SCRIPT>

<SCRIPT language=Javascript>
<!--
					if(parent.bottom!=null)
			{
				parent.bottom.Clock.style.display ="none"; 
				parent.bottom.information.style.display ="";
				parent.bottom.information.innerHTML ="&nbsp;&nbsp;<FONT color=#104A7B face='Wingdings 2'>8</FONT>&nbsp;<a href='#' target='detail'>待办理的流程申请：<font color=104A7B>5</font></a>&nbsp;&nbsp;<FONT color=#104A7B face='Wingdings 2'>8</FONT>&nbsp;<a href='Task/TaskCurrentDay.asp?Menu=1' target='detail'>当前任务：<font color=104A7B>1</font>件</a>";
			}
				function DisTime() {
		ctime= new Date();
		var chour=ctime.getHours();
		var cminute=ctime.getMinutes();
		var csecond=ctime.getSeconds();
		var cmonth=ctime.getMonth()+1
		var ww=ctime.getDay();
		if (ww==0) ww="星期日";
		if (ww==1) ww="星期一";
		if (ww==2) ww="星期二";
		if (ww==3) ww="星期三";
		if (ww==4) ww="星期四";
		if (ww==5) ww="星期五";
		if (ww==6) ww="星期六";
		ctime =" "+ctime.getYear()+" 年 "+cmonth+" 月 "+ctime.getDate()+" 日 "+ww;
		return ctime;
		}		
	//-->	</SCRIPT>

<META content="MSHTML 6.00.2900.2912" name=GENERATOR></HEAD>
<BODY onload="getMessage(3);"></BODY></HTML>