<%@ taglib prefix="menus" uri="/WEB-INF/tags/menus.tld" %>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
	td{font-size:9pt;}
</style>
<script language="javascript">

//下面是生成菜单的代码 请不要改动js代码。很难调到 杨飞提醒
bground="menubg_level1.gif";
bgroundOver="menubg_level1_h.gif";
bgroundStatus="menubg_level1_now.gif";
imgBasePath="/NetSoftCRM/images/menuimages/";
menuHasUrl="menubg_level1.gif";
menuHasUrlOver="menubg_level1_h.gif";
nextbground="menubg_level2.gif";
nextbgroundOver="menubg_level2_h.gif";
nextbgroundStatus="menubg_level2_now.gif";
urlBasePath="";
var leftMenuXml;//模块节点
var leftMenuId;
var levelStatus=null;//第一层最后点击项
var level2Status=null;//第二层最后点击项
var menuConfig;//xml文件中的配置信息，在整个过程中应用
//主菜单鼠标效果
function menuMouseOver(ob)
{
//	if (ob.parentElement.flag=="true")
//	return;
	ob.style.background='url('+ imgBasePath + bgroundOver + ')';
}
function menuMouseOut(ob)
{
//	if (ob.parentElement.flag=="true")
//	return;
	ob.style.background='url(' + imgBasePath + bground + ')';
}
//子菜单鼠标效果
function menuNextMouseOver(ob)
{
	if (ob.flagNext=="true")
	return;
	ob.style.background='url(' + imgBasePath + nextbgroundOver + ')';
}
function menuNextMouseOut(ob)
{
	if (ob.flagNext=="true")
	return;
	ob.style.background='url(' + imgBasePath + nextbground + ')';
}
//根据点击模块，隐藏上一项，展开当前项
function showHideSubMenu(f)
{	
	event.cancelBubble=true;
	var ob=event.srcElement.parentElement;
	if(levelStatus!=null&&levelStatus!=ob)
		{
			showHideMenu(levelStatus);	
		}
	if(levelStatus!=null)
		{
			if(typeof(levelStatus.flagHasUrl)=="undefined")
			{
				levelStatus.flag="false";
				levelStatus.children[0].style.background='url(' + imgBasePath+ bground+ ')';
			}else{
				levelStatus.flagHasUrl="false";
				levelStatus.children[0].style.background='url(' + imgBasePath + menuHasUrl + ')';
			}
		}
	if(levelStatus==ob)
		{
			levelStatus=null;
			ob.flag="false";
			ob.children[0].style.background='url(' + imgBasePath+ bground+ ')';
		}
		else
			levelStatus=ob;
		showHideMenu(ob);
}
//子菜单链结
function doLink(url,frm)
{
	//window.alert(url);
	var ob=event.srcElement;
	ob.flagNext="true";
	if(level2Status!=null&&level2Status!=ob)	
	{
		level2Status.flagNext="false";
		level2Status.style.background='url(' + imgBasePath + nextbground + ')';
	}
	level2Status=ob;
	//top.main.location.href=urlBasePath + url;
	if(frm=="detail")
		top.detail.location.href =url;
	else
		window.open(url);
}
//查找具有相同level属性的行除去第一行外都隐藏
function showHideMenu(ob)
{
	var parentmenu=ob.level;
	if(ob.nextSibling==null)
	return false;
	ob=ob.nextSibling;
	var showorhide=(ob.style.display!="none")?"none":"block";
	while(ob.level==parentmenu)
	{
		ob.style.display=showorhide;
		if(ob.nextSibling==null)
		return false;
		ob=ob.nextSibling;
	}
}
--></script>
  </head>
  
  <body leftmargin="0" bgcolor="#E7EEFA" topmargin="0" marginwidth="0" marginheight="0" >
    <menus:menus listName="list" scope="session" role="${mid}"></menus:menus>
  </body>
</html>