<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD><TITLE></TITLE><LINK href="<%=request.getContextPath()%>/css/CSSForV10.css" 
type=text/css rel=stylesheet>
<link href="<%=request.getContextPath()%>/css/style_2007.css" rel="stylesheet" type="text/css" />
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/orderby.js"></SCRIPT>

<STYLE>THEAD .arrow {
	COLOR: black; FONT-FAMILY: webdings
}
</STYLE>
<LINK title=style href="<%=request.getContextPath()%>/css/style.css" type=text/css 
rel=stylesheet>
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/type.js"></SCRIPT>
<LINK href="<%=request.getContextPath()%>/css/table.css" type=text/css rel=stylesheet>
<META charset=gb2312 content="MSHTML 6.00.2900.2912" name=GENERATOR>
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/HTVOS.js"></SCRIPT>
<script type='text/javascript' src='/NetSoftCRM/dwr/interface/MessageAjax.js'></script>
<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>


<SCRIPT language=javascript>

function selectall(v){
 var f = document.forms["searchform"];
 for (i=0;i<f.elements.length;i++)
 if (f.elements[i].id=="check") f.elements[i].checked = v;
}
function del(){
 var f = document.forms["searchform"];
 for (i=0;i<f.elements.length;i++)
 {
 	if (f.elements[i].id=="check" && f.elements[i].checked==1)
 	{
 		if(window.confirm("您真的要进行删除操作吗？"))
 		{
 			alert(f.elements[i].value);
 			Sellitem.deleteSellitem(f.elements[i].value,delreload);
 		}else
 		{
 			break;
 		}
 	}
 }
}

function delreload(msg)
{
	alert(msg);
	reloadall();
}

function changechecked(checkbut){
	var v =checkbut.checked;
	if (v) {
 	checkbut.checked = true;
 }else{
 	checkbut.checked = false;
 }
}

function windowopen(url,name,style)
{
	window.open(url,name,style);
}

function getdraft(style,id)
{
	Sellitem.getSellitemState(style,id,allcallback);
}

function reloadall(id)
{
	Sellitem.selectByItem(id,allcallback);
}

function reload(id)
{
	Message.getAllMessage(allcallback);
}
//定义转换规则
var getid=function(unit){return "<input type='checkbox' id='check'　onclick='changechecked(this)' value='"+unit.id+"'/>"};
var getmtheme=function(unit){return unit.mtheme};
var getmcontent=function(unit){return unit.mcontent};
var geteid=function(unit){return unit.eid};
var getmdate=function(unit){return unit.mdate};
var getmstyle=function(unit){return unit.mstyle};
var getmdelstyle=function(unit){return unit.mdelstyle};
var getoper=function(unit){return "<div class='width:50px' onclick='modi(${li.id });'>详细信息 </div>"};
function allcallback(msg)
{
　　DWRUtil.removeAllRows("employeelist");
   DWRUtil.addRows("employeelist",msg,[getid ,getmtheme,getmcontent,geteid,getmdate,getmstyle,getmdelstyle,getoper]);
}

function modi(id)
{
	window.open("/NetSoftCRM/sellitem.crm?method=modiView&id="+id,"修改项目",'height=450, width=450, top=50, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
}
</SCRIPT>
</HEAD>
<BODY text=#000000 vLink=#003399 aLink=#003399 link=#003399 bgColor=#ffffff 
leftMargin=0 topMargin=0 MARGINWIDTH="0" MARGINHEIGHT="0">
<FORM id=searchform><INPUT id=dellist type=hidden name=dellist> 
<TABLE class=View_table id=ViewMainTable cellSpacing=0 cellPadding=0 
width="100%" border=0>
  <TBODY>
  <TR vAlign=top>
    <TD vAlign=center width="100%" height=23>
      <TABLE class=ViewBar height=23 cellSpacing=0 cellPadding=0 width="100%" 
      background=<%=request.getContextPath()%>/images/bar.gif border=0>
        <TBODY>
        <TR>
          <TD width=25><IMG 
            style="MARGIN-TOP: 4px; MARGIN-LEFT: 10px; MARGIN-RIGHT: 8px" 
            height=12 src="<%=request.getContextPath()%>/images/barlu.gif"></TD>
          <TD vAlign=center noWrap align=left>
            <P style="MARGIN-TOP: 4px">所有消息列表</P></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD style="PADDING-TOP: 1px" width="100%" height="100%">
    <TABLE class=com_layoutTable height="100%" cellSpacing=0 cellPadding=0 
      width="100%" align=center border=0>
        <TBODY>
        <TR vAlign=top>
          <TD class=form_boxDis width="100%">
            <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" 
            border=0>
              <TBODY>
              <TR vAlign=top>
                <TD width="100%">
                  <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR vAlign=top>
                      <TD style="BACKGROUND-REPEAT: repeat-x" 
                      background=<%=request.getContextPath()%>/images/Title2.gif>
                        <TABLE cellSpacing=0 cellPadding=0 width="100%" 
border=0>
                          <TBODY>
                          <TR vAlign=top>
                            <TD class=h32 style="BACKGROUND-REPEAT: no-repeat" 
                            noWrap width="100%">
                              <P class=view 
                              style="MARGIN-LEFT: 5px; MARGIN-RIGHT: 10px"><IMG 
                              class=menu_icon0 height=9 
                              src="<%=request.getContextPath()%>/images/k7.gif" width=9 
                              align=absMiddle></P></TD></TR></TBODY></TABLE></TD>
                      <TD width=10><IMG height=21 
                        src="<%=request.getContextPath()%>/images/Title3.gif" width=16></TD>
                      <TD style="BACKGROUND-REPEAT: repeat-x" vAlign=bottom 
                      width="100%" background=<%=request.getContextPath()%>/images/Title4.gif>
                        <TABLE style="MARGIN-TOP: 0px; MARGIN-BOTTOM: 0px" 
                        cellSpacing=0 cellPadding=0 width="100%" border=0>
                          <TBODY>
                          <TR vAlign=top>
                            <TD vAlign=bottom>
                              <TABLE cellSpacing=0 cellPadding=0 width="100%" 
                              border=0>
                                <TBODY>
                                <TR vAlign=top>
                                <TD vAlign=bottom width="100%" height=28>
                                <TABLE cellSpacing=0 cellPadding=0 width="100%" 
                                border=0>
                                <TBODY>
                                <TR vAlign=top>
                                <TD vAlign=bottom align=right width="100%" 
                                height=28>
                                <DIV align=right>
                                <TABLE class=button_table cellSpacing=0 
                                cellPadding=0 border=0>
                                <TBODY>
                                <TR vAlign=top height=22>
                                 <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="getdraft(1,${Employees.id});" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width=50><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align=absMiddle 
                                border=0>所有消息</TD>
                                 <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="getdraft(3,${Employees.id}); " 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width=80><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align="middle" 
                                border=0>未查看的消息</TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="getdraft(4,${Employees.id}); " 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width=80><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align="middle" 
                                border=0>已查看的消息</TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="windowopen('<%=request.getContextPath()%>/jsp/addMessage.jsp','增加消息  ','height=450, width=450, top=50, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/mailwrite.gif" 
                                align=absMiddle border=0>增加</TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="reloadall();" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/refresh.gif" 
                                align=absMiddle border=0>刷新</TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="javascript:selectall(1); " 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/selAll.gif" 
                                align=absMiddle border=0>全选</TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="javascript:selectall(0); " 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/DisSelAll.gif" 
                                align=absMiddle border=0>重置</TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="del();" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/del.gif" align=absMiddle 
                                border=0>删除</TD>
                                </TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
                            <TD vAlign=bottom 
                        width=15>&nbsp;</TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
              <TR vAlign=top>
                <TD 
                style="PADDING-RIGHT: 4px; PADDING-LEFT: 4px; PADDING-BOTTOM: 4px; PADDING-TOP: 4px" 
                width="100%" height="100%">
                  <TABLE class=viewMainWhite height="100%" cellSpacing=0 
                  cellPadding=0 width="100%" align=center border=0>
                    <TBODY>
                    <TR vAlign=top>
                      <TD 
                      style="PADDING-RIGHT: 4px; PADDING-LEFT: 4px; PADDING-BOTTOM: 4px; PADDING-TOP: 4px" 
                      width="100%">
                        <TABLE class=workflow_View onclick=sortMyTable(event) 
                        cellSpacing=0 cellPadding=0 width="100%" align=center 
                        border=0>
                          <THEAD>
                          <TR style="CURSOR: hand">
                            <TD class=View_title noWrap align=left 
                            width=10>&nbsp;</TD>
                            <TD class=View_title noWrap 
                            align=left>消息主题</TD>
                            <TD class=View_title noWrap align=left>消息要提醒的人</TD>
                            <TD class=View_title noWrap align=left>消息发布的时间</TD>
                            <TD class=View_title noWrap align=left>消息的状态</TD>
                            </TR></THEAD>
                          <TBODY id="employeelist">
                         <logic:notPresent name="list" scope="request">
                            <tr><td>数据库中没有任何记录</td></tr>
                          </logic:notPresent>
                          <logic:present name="list" scope="request">
                          <logic:iterate id="li" name="list" scope="request">
                          <TR onMouseOver="this.bgColor='#f2f8ff';" 
                          onmouseout="this.bgColor='#ffffff';" bgColor=#ffffff 
                          width="100%" style="CURSOR: hand">
                            <TD class=View_item2 noWrap align=middle><input type="checkbox" id="check"　onclick="changechecked(this)" value="${li.id}"/>
                             </TD>
                            <TD class=View_item2 noWrap align=middle>${li.mtheme}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.ename}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.mdate}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.mstyles}</TD>
                            <TD class=View_item2 style="BORDER-RIGHT: 0px" 
                            noWrap align=middle"><div class="width:50px" onclick="modi(${li.id });">详细信息</div></TD></TR>
                            </logic:iterate>
                            </logic:present>
                         </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
              </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM>
</BODY></HTML>

