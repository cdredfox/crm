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
 <script type='text/javascript' src='/NetSoftCRM/dwr/interface/Sellitem.js'></script>
  <script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>

<SCRIPT language=javascript>
function open1(id)
{
	window.open("/NetSoftCRM/sellitem.crm?method=getOnly&id="+id,"查看待审核的项目",'height=450, width=450, top=50, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
}

function realload(t,em)
{
	Sellitem.getAceptSellitem(t,em,allcallback);
}
//定义转换规则
var gettd=function(unit){return "<TD class=View_item2 noWrap align=middle></TD>"};
var getsname=function(unit){return unit.sname};
var getcname=function(unit){return unit.cname};
var getempname=function(unit){return unit.empname};
var getstyle=function(unit){return unit.tname};
var getoper=function(unit){return "<TD class=View_item2 noWrap align=middle onclick='open1("+unit.id+");'>审批</TD>"};
function allcallback(msg)
{
　　DWRUtil.removeAllRows("sellitemlist");
   DWRUtil.addRows("sellitemlist",msg,[gettd,getsname,getcname,getbyname,getstyle,getoper]);
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
            <P style="MARGIN-TOP: 4px">待审核的项目</P></TD></TR></TBODY></TABLE></TD></TR>
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
                            noWrap width="100%" style="CURSOR: hand">
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
                                </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
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
                            align=left>项目名称</TD>
                            <TD class=View_title noWrap align=middle>对应客户</TD>
                            <TD class=View_title noWrap 
                            align=left>项目发起人</TD>
                            <TD class=View_title noWrap align=middle>项目状态</TD>
                            <TD class=View_title noWrap align=middle>操作</TD>
                            </TR></THEAD>
                          <TBODY id="sellitemlist">
                         <logic:notPresent name="list" scope="request">
                            <tr><td>数据库中没有任何记录</td></tr>
                          </logic:notPresent>
                          <logic:present name="list" scope="request">
                          <logic:iterate id="li" name="list" scope="request">
                          <TR onMouseOver="this.bgColor='#f2f8ff';" 
                          onmouseout="this.bgColor='#ffffff';" bgColor=#ffffff 
                          width="100%" style="cursor: hand">
                            <TD class=View_item2 noWrap align=middle></TD>
                            <TD class=View_item2 noWrap align=middle>${li.sname}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.cname}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.empname}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.tname}</TD>
                            <TD class=View_item2 noWrap align=middle onclick="open1(${li.id});">审批</TD>
                            </TR>
                            </logic:iterate>
                            </logic:present>
                         </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
              </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM>
</BODY></HTML>
