<%@ page pageEncoding="utf-8" language="java"%>
<html>
	<HEAD>
		<TITLE>角色授权</TITLE>
	   <META http-equiv=Content-Type content="text/html; charset=GBK">
		<LINK href="<%=request.getContextPath()%>/css/base.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dojo.js"></script>
<script type="text/javascript">
	dojo.require("dojo.widget.TabContainer");
	dojo.require("dojo.widget.LinkPane");
	dojo.require("dojo.widget.ContentPane");
	dojo.require("dojo.widget.LayoutContainer");
</script>
		
		
		<STYLE>
		.P_LB { PADDING-LEFT: 5px; FONT-WEIGHT: bold; WIDTH: 100px; COLOR: 
#333333; LETTER-SPACING: 1px } 
		.P_NL { } 
		.ip_text { BORDER-RIGHT: #cccccc 1px 
solid; PADDING-RIGHT: 0px; BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 0px; 
PADDING-BOTTOM: 0px; BORDER-LEFT: #cccccc 1px solid; WIDTH: 150px; PADDING-TOP: 
0px; BORDER-BOTTOM: #cccccc 1px solid; HEIGHT: 20px } 
		.ip_textarea { BORDER-
RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; OVERFLOW-Y: auto; 
BORDER-LEFT: #cccccc 1px solid; WIDTH: 100%; BORDER-BOTTOM: #cccccc 1px solid; 
HEIGHT: 100px } .title { PADDING-LEFT: 8px; FONT-WEIGHT: bold; VERTICAL-ALIGN: 
baseline; WIDTH: 100%; COLOR: #ca1313; BACKGROUND-REPEAT: repeat-x; HEIGHT: 
20px; BACKGROUND-COLOR: #e6e7e8 } .title FONT { DISPLAY: inline; FONT-SIZE: 
12px; WIDTH: 100%; FONT-FAMILY: "Tahoma"; LETTER-SPACING: 3px } .data_list_thead 
{ TABLE-LAYOUT: fixed; PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 
3px; COLOR: #000000; PADDING-TOP: 3px; HEIGHT: 22px; BACKGROUND-COLOR: #adceed } 
.formTable TD { PADDING-LEFT: 4px } .formTable TR { FONT-SIZE: 12px } .TBL_A { 
BACKGROUND-COLOR: #ffffff } .TBL_B { BACKGROUND-COLOR: #ecf3f9 } .data_list_foot 
TD { BACKGROUND-COLOR: #bcd0eb } .data_list_query { BACKGROUND-COLOR: #f4f1eb } 
BUTTON { BORDER-RIGHT: #485984 2px solid; PADDING-RIGHT: 2px; BORDER-TOP: 
#89acf0 2px solid; PADDING-LEFT: 2px; FONT-SIZE: 9pt; BORDER-LEFT-COLOR: 
#89acf0; PADDING-BOTTOM: 0px; CURSOR: hand; COLOR: #ffffff; BORDER-BOTTOM: 
#485984 2px solid; FONT-FAMILY: "宋体"; BORDER-LEFT-STYLE: solid; LETTER-
SPACING: 1px; HEIGHT: 20px; BACKGROUND-COLOR: #6980bc } .app-jwin-page-bgcolor { 
PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px } 
.app-jwin-table { BORDER-RIGHT: #cccccc 1px solid; TABLE-LAYOUT: fixed; BORDER-
TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; WIDTH: 300px; BORDER-
BOTTOM: #cccccc 1px solid; HEIGHT: 100%; BACKGROUND-COLOR: #edf2fc } .app-jwin-
header { PADDING-RIGHT: 3px; PADDING-LEFT: 3px; FONT-WEIGHT: normal; BACKGROUND-
images: url(<%=request.getContextPath()%>/images/bg2.gif); PADDING-BOTTOM: 2px; VERTICAL-ALIGN: bottom; COLOR: 
#5e656e; PADDING-TOP: 2px; BACKGROUND-REPEAT: repeat-x; LETTER-SPACING: 4px; 
BACKGROUND-COLOR: #0148b2 } .app-jwin-header-2 { PADDING-RIGHT: 3px; PADDING-
LEFT: 3px; FONT-WEIGHT: normal; BACKGROUND-images: url(<%=request.getContextPath()%>/images/bg2.gif); PADDING-
BOTTOM: 2px; VERTICAL-ALIGN: bottom; COLOR: #5e656e; PADDING-TOP: 2px; 
BACKGROUND-REPEAT: repeat-x; LETTER-SPACING: 4px; BACKGROUND-COLOR: #0148b2 } 
.app-jwin-body { PADDING-RIGHT: 5px; OVERFLOW-Y: auto; PADDING-LEFT: 5px; 
PADDING-BOTTOM: 5px; PADDING-TOP: 5px; HEIGHT: 100% } A:link { COLOR: #003399; 
TEXT-DECORATION: none } A:visited { COLOR: #003399; TEXT-DECORATION: none } 
A:hover { COLOR: #ff9900; TEXT-DECORATION: underline } .table_head { TABLE-
LAYOUT: fixed; PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 3px; 
COLOR: white; PADDING-TOP: 3px; BACKGROUND-COLOR: #8caae6 } .data_list_query TD 
{ FONT-WEIGHT: bold } FIELDSET { BORDER-RIGHT: #dddddd 1px solid; BORDER-TOP: 
#dddddd 1px solid; BORDER-LEFT: #dddddd 1px solid; BORDER-BOTTOM: #dddddd 1px 
solid } FIELDSET TD { PADDING-LEFT: 4px } FIELDSET { PADDING-RIGHT: 5px; 
PADDING-LEFT: 5px; FONT-SIZE: 12px; PADDING-BOTTOM: 5px; PADDING-TOP: 5px; FONT-
FAMILY: Tahoma; LETTER-SPACING: 1px } LEGEND { FONT-SIZE: 14px; COLOR: #008000; 
LETTER-SPACING: 1px } </STYLE>
  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
  <script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
	<script type="text/javascript">
	function getAllEmp()
		{
          DeptsAjax.getAllEmployee(msgBack);
		}
		
		function msgBack(msg)
		{
			DWRUtil.removeAllOptions('depts');
			DWRUtil.addOptions('depts', msg,"id","dname");
		    opener.reloadall();
		}
		
function GetDate ()
	{
	  reVal = window.showModalDialog("/NetSoftCRM/jsp/showDate.htm", '',
		"status:no;center:yes;scroll:no;resizable:no;help:no;dialogWidth:255px;dialogHeight:260px");
	
	  if (reVal != null)
	  {
	     document.forms[0].ebirthday.value=reVal;
	  }
	  }
	
	function winclose()
	{
		window.close();
	}
	
	function winsave()
	{
		document.forms[0].submit();
	}

	</script>
	
	
	</HEAD>
	<BODY>
	<DIV id=WAMenuID style="PADDING-RIGHT: 3px; PADDING-LEFT: 5px; BACKGROUND-IMAGE: url(<%=request.getContextPath()%>/images/mb2.gif); PADDING-BOTTOM: 5px; WIDTH: 100%; PADDING-TOP: 3px; 
BACKGROUND-REPEAT: repeat-x; HEIGHT: 24px">
    <SPAN class=WAMenuItem title="" style="PADDING-RIGHT: 5px; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; COLOR: black; BORDER-TOP-STYLE: none; PADDING-TOP: 2px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-
STYLE: none; BACKGROUND-COLOR: transparent; BORDER-BOTTOM-STYLE: none" onclick="winsave();"
>
    <IMG src="<%=request.getContextPath()%>/images/save.gif" align=absBottom> 保存</SPAN>
    <SPAN class=WAMenuItem title="" style="PADDING-RIGHT: 5px; PADDING-LEFT: 5px; PADDING-
BOTTOM: 2px; COLOR: black; BORDER-TOP-STYLE: none; PADDING-TOP: 2px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BACKGROUND-COLOR: transparent; 
BORDER-BOTTOM-STYLE: none" onclick="winclose();"><IMG 
src="<%=request.getContextPath()%>/images/co_old2.gif" align=absBottom"> 关闭窗口</SPAN></DIV>
<html:form action="/employee?method=addUser">
				<div id="mainTabContainer" dojoType="TabContainer" style="width: 100%; height: 100%" selectedTab="已有权限">
					<a dojoType="LinkPane" href="<%=request.getContextPath() %>/jsp/myPower.jsp" refreshOnShow="true" style="display: none">已有权限</a>
  					<a dojoType="LinkPane" href="<%=request.getContextPath() %>/jsp/otherPower.jsp" refreshOnShow="true" style="display: none">可分配权限</a>
  					</div>	
		</html:form>
	</BODY>
</html>