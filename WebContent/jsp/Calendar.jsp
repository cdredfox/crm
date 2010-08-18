<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
<head>
<title>日程计划</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
td {
	font-family: "Arial";
	font-size: 12px;
	color: #106FC8;
}
.mybtn {
	font-family: "Arial";
	padding-top:3px;
	padding-left:3px;
	border-bottom: #000000 1px solid; 
	border-left: #000000 1px solid; 
	border-right: #000000 1px solid; 
	border-top: #000000 1px solid;
	height:20px;
	width:80px;
	background-color: #F3F3F3;
	color: #000000;
}
.cell_over {
	border-top: 1px solid #FFFFFF;
	border-right: 1px solid #AFAEAE;
	border-bottom: 1px solid #AFAEAE;
	border-left: 1px solid #FFFFFF;
	cursor:hand;
	color:#F2AD1A;
}
.cell_current {
	border-top: 1px solid #AFAEAE;
	border-right: 1px solid #FFFFFF;
	border-bottom: 1px solid #FFFFFF;
	border-left: 1px solid #AFAEAE;
	color: #FF0000;
}
-->
</style>

<script language="javascript">
function cells_over(mobj)
{
	var strCellVal=mobj.innerHTML;
	if (strCellVal!=""&&strCellVal!=curDay+"")
	{
		mobj.className="cell_over";
	}
}
function cells_out(mobj)
{
	var strCellVal=mobj.innerHTML;
	if (strCellVal!=""&&strCellVal!=curDay+"")
	{
		mobj.className="";
	}
}

function cells_click(mobj)
{
	var strCellVal=mobj.innerHTML;
	if (strCellVal!=""&&strCellVal!=curDay+"")
	{
		
		curDay=parseInt(strCellVal);
		changeDays();
	}
}

function calenderOK()
{
	var oForm=document.myform;
	var strYear		=oForm.year.value;
	var strMonth	=(parseInt(oForm.month.value)+1)+"";
	var strDay		=curDay+"";
	var strHour		=oForm.hour.value;
	var strMinute	=oForm.minute.value;
	var strSecond	=oForm.second.value;
	strMonth	=(strMonth.length<2)?"0"+strMonth:strMonth;
	strDay 		=(strDay.length<2)?"0"+strDay:strDay;
	strHour		=(strHour.length<2)?"0"+strHour:strHour;
	strMinute	=(strMinute.length<2)?"0"+strMinute:strMinute;
	strSecond	=(strSecond.length<2)?"0"+strSecond:strSecond;
	var strTime	=strYear+"-"+strMonth+"-"+strDay+" "+strHour+":"+strMinute+":"+strSecond;
	top.returnValue=strTime;
	top.close();
}
</script>

</head>

<body bgcolor="#E4E4E4" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0" scroll="no">
<form name="myform" method="post">
<table width="100%" border="0" cellpadding="2" cellspacing="0"
	style="PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 3px; WIDTH: 100%; PADDING-TOP: 3px; BACKGROUND-COLOR: #f7f3f7" cellSpacing=0>
	<tr style="BORDER-RIGHT: #dddddd 0px solid; BORDER-TOP: #dddddd 0px solid; PADDING-LEFT: 5px; FONT-SIZE: 12px; BORDER-LEFT: #dddddd 0px solid; BORDER-BOTTOM: #dddddd 1px solid" align="right">
		<td>当前年：<select name="year" onChange="changeDays();"></select>
	当前月：<select name="month" onChange="changeDays();"></select>
		当前时间：<select name="hour"></select> <font color=#000000>时</font><select name="minute"></select> <font color=#000000>分</font>
		<select name="second"></select> <font color=#000000>秒</font>
		</td>
	</tr>
</table>
</form>
<input type="hidden" name="day">
<TABLE id=domCalendarVision style="BORDER-COLLAPSE: collapse" borderColor=#888888 width="100%" border=1>
<THEAD>
<TR class=EXIWeeks>
<TD align=middle>星期一</TD>
<TD align=middle>星期二</TD>
<TD align=middle>星期三</TD>
<TD align=middle>星期四</TD>
<TD align=middle>星期五</TD>
<TD style="COLOR: #e10000" align=middle>星期六</TD>
<TD style="COLOR: #e10000" align=middle>星期天</TD></TR></THEAD>

	<tr align="center" style="BACKGROUND-COLOR: #ffffd6" height="55">
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
	</tr>
	<tr align="center" style="BACKGROUND-COLOR: #ffffd6" height="55">
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
	</tr>
	<tr align="center" style="BACKGROUND-COLOR: #ffffd6" height="55">
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
	</tr>
	<tr align="center" style="BACKGROUND-COLOR: #ffffd6" height="55">
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
	</tr>
	<tr align="center" style="BACKGROUND-COLOR: #ffffd6" height="55">
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
	</tr>
	<tr align="center" style="BACKGROUND-COLOR: #ffffd6" height="55">
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
		<td id="cell_days" onMouseOver="cells_over(this);"
			onmouseout="cells_out(this);" onClick="cells_click(this);"></td>
	</tr>
</table>

<script language="javascript">
var strMonthNames = new Array('一月', '二月', '三月', '四月', '五月', '六月', 
            '七月', '八月', '九月', '十月', '十一月', '十二月');
var strDayNames = new Array( 
  new Array('S', 'M', 'T', 'W', 'T', 'F', 'S'),
  new Array('日', '一', '二', '三', '四', '五', '六'),
  new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday')
  );
var intMonthDays = new Array( 
   /* Jan */ 31,     /* Feb */ 29, /* Mar */ 31,     /* Apr */ 30, 
   /* May */ 31,     /* Jun */ 30, /* Jul */ 31,     /* Aug */ 31, 
   /* Sep */ 30,     /* Oct */ 31, /* Nov */ 30,     /* Dec */ 31 );

function checkLeapYear(yearVal)
{
  intMonthDays[1]=(((!(yearVal%4))&&(yearVal%100))||!(yearVal % 400))? 29 : 28;
}

function setSelValue(mobj,intB,intE,curVal)
{
	for(var i=intB;i<=intE;i++)
	{
		var mOption=new Option(i,i+"");
		mobj.add(mOption);
	}
	mobj.value=curVal+"";
}

function changeDays()
{
	var oForm=document.myform;
	var intYear=parseInt(oForm.year.value);
	var intMonth=parseInt(oForm.month.value);
	setDays(intYear,intMonth,curDay);
}

function setDays(intYear,intMonth,intDay)
{
	var myDate=new Date(intYear,intMonth,1);
	checkLeapYear(intYear);
	var DaysOfMonth=intMonthDays[intMonth];
	var bDay=myDate.getDay();
	for(var i=0;i<cell_days.length;i++)
	{
		if (i<bDay||i>=bDay+DaysOfMonth)
		{
			cell_days[i].innerHTML="";
		}
		else
			{
			cell_days[i].innerHTML=i-bDay+1+"日";
		}
		cell_days[i].className="";
	}
	var curCell_id=intDay;
	if (curCell_id>DaysOfMonth)
	{
		curCell_id=DaysOfMonth;
		curDay=curCell_id;
	}
	curCell_id+=bDay;
	cell_days[curCell_id-1].className="cell_current";
}

function setSelArray(mobj,vals,curVal)
{
	for(var i=0;i<vals.length;i++)
	{
		var mOption=new Option(vals[i],(i)+"");
		mobj.add(mOption);
	}
	mobj.value=curVal+"";
}

var curDate		=new Date();
var curDay		=curDate.getDate();
var curWeek		=curDate.getDay();
var curMonth	=curDate.getMonth();
var curYear 	=curDate.getFullYear();
var curHour		=curDate.getHours();
var curMinute	=curDate.getMinutes();
var curSecond	=curDate.getSeconds();

var strInitDate=window.dialogArguments+"";
var strDate		="";
var strTime		="";
if (strInitDate.indexOf(" ")>0)
{
	strDate=strInitDate.substring(0,strInitDate.indexOf(" "));
	var tempArray=strDate.split("-");
	curYear	=parseInt(parseFloat(tempArray[0]));
	curMonth=parseInt(parseFloat(tempArray[1]))-1;
	curDay	=parseInt(parseFloat(tempArray[2]));
	strTime=strInitDate.substring(strInitDate.indexOf(" ")+1);
	var tempArray=strTime.split(":");
	curHour		=parseInt(parseFloat(tempArray[0]));
	curMinute	=parseInt(parseFloat(tempArray[1]));
	curSecond	=parseInt(parseFloat(tempArray[2]));
}else{
	if (strInitDate.indexOf("-")>0)
	{
		strDate=strInitDate;
		var tempArray=strDate.split("-");
		curYear	=parseInt(parseFloat(tempArray[0]));
		curMonth=parseInt(parseFloat(tempArray[1]))-1;
		curDay	=parseInt(parseFloat(tempArray[2]));
	}
	if (strInitDate.indexOf(":")>0)
	{
		strTime=strInitDate;
		var tempArray=strTime.split(":");
		curHour		=parseInt(parseFloat(tempArray[0]));
		curMinute	=parseInt(parseFloat(tempArray[1]));
		curSecond	=parseInt(parseFloat(tempArray[2]));
	}
}

var myDate=new Date(2003,7,10)

if (curYear<100) curYear += 1900;

setSelValue(document.myform.year,curYear-50,curYear+5,curYear);
setSelArray(document.myform.month,strMonthNames,curMonth);
setSelValue(document.myform.hour,0,23,curHour);
setSelValue(document.myform.minute,0,59,curMinute);
setSelValue(document.myform.second,0,59,curSecond);
setDays(curYear,curMonth,curDay);
</script>

</body>
</html>
