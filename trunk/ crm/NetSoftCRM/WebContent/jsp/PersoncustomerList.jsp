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
<script type='text/javascript' src='/NetSoftCRM/dwr/interface/CustomerAjax.js'></script>
<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>
<SCRIPT language=javascript>
function nowc(eid){
    CustomerAjax.getAllPersoncustomerByEmployye(eid,allcallback);
}
function findc(){
   var code=document.getElementById("code").value;
   alert(code);
   CustomerAjax.getPersoncustomerByCcode(code,allcallback);
}
function findn(){
   var cname=document.getElementById("cname").value;
   alert(cname);
   CustomerAjax.getPersoncustomerByName(cname,allcallback);
}
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
 			EmployeeAjax.delEmployee(f.elements[i].value,delreload);
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

function windowopen(msg)
{
	window.open(msg,"增加个人客户",'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=490,height=490,left=0,top=0');
}


function reloadall()
{
	CustomerAjax.getAllCustomer("个人客户",allcallback);
}
//定义转换规则
var getid=function(unit){return "<input type='checkbox' id='check'　onclick='changechecked(this)' value='"+unit.id+"'/>"};
var getpname=function(unit){return unit.pname};
var getpsexs=function(unit){return unit.psexs};
var getename=function(unit){return unit.ename};
var getphonetel=function(unit){return unit.phonetel};
var getccredit=function(unit){return unit.ccredit};
var getpbirthday=function(unit){return unit.pbirthday};
var getstyle=function(unit){return unit.style}
var getpaddress=function(unit){return unit.paddress};
var getoper=function(unit){return "<div class='width:50px' onclick='modi("+unit.id+");'>修改</div>"};
function allcallback(msg)
{
　　DWRUtil.removeAllRows("personcustomerlist");
   DWRUtil.addRows("personcustomerlist",msg,[getid,getpname,getename,getpsexs,getpbirthday,getphonetel,getstyle,getccredit,getpaddress,getoper]);
}


function modi(id)
{
	window.open("/NetSoftCRM/personcustomer.crm?method=modiView&id="+id,"修改个人客户",'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=450,height=490,left=0,top=0');
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
            <P style="MARGIN-TOP: 4px">我的人客户列表</P></TD></TR></TBODY></TABLE></TD></TR>
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
                                <td class=formKey vAlign=center width=65>按拼音查找</td>             
                                <td class=MR_pinp vAlign=center width=65> <input type="text" onMouseOver="this.style.borderColor='#99E300'" onMouseOut="this.style.borderColor='#A1BCA3'" name="code"  maxlength="5" tabindex="1"/> </td>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="findc()" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width=40 align="center"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align=absMiddle 
                                border=0>查 找</TD>
                                
                                <TD width=1><IMG 
                                style="MARGIN-TOP: 3px; MARGIN-LEFT: 8px; MARGIN-RIGHT: 8px" 
                                src="<%=request.getContextPath()%>/images/group.gif"></TD>
                                <td class=formKey vAlign=center width=65>按姓名查找</td>             
                                <td class=MR_pinp vAlign=center width=65> <input type="text" onMouseOver="this.style.borderColor='#99E300'" onMouseOut="this.style.borderColor='#A1BCA3'" name="cname"  maxlength="5" tabindex="1"/> </td>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="findn(); " 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="40" align="center"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align=absMiddle 
                                border=0>查 找</TD>
                                
                                  <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="reloadall();" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width=55 align="center"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align=absMiddle 
                                border=0>显示所有</TD>
                                
                                <TD width=1><IMG 
                                style="MARGIN-TOP: 3px; MARGIN-LEFT: 8px; MARGIN-RIGHT: 8px" 
                                src="<%=request.getContextPath()%>/images/group.gif"></TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="windowopen('/NetSoftCRM/jsp/addPersoncustomer.jsp');" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55" align="center"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/mailwrite.gif" 
                                align=absMiddle border=0>增加</TD>
                                
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="nowc('${Employees.id}');" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="100" align="center"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/refresh.gif" 
                                align=absMiddle border=0>切换到我的客户</TD>
                                
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="javascript:selectall(1); " 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55" align="center"><IMG class=icon0 
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
                                vAlign=center width="55" align="center"><IMG class=icon0 
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
                                vAlign=center width="55" align="center"><IMG class=icon0 
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
                            align=left>客户姓名</TD>
                            <TD class=View_title noWrap align=middle>客户所属人</TD>
                            <TD class=View_title noWrap align=left>性别</TD>
                            <TD class=View_title noWrap align=middle>生日</TD>
                            <TD class=View_title noWrap align=middle>电话</TD>
                             <TD class=View_title noWrap align=middle>客户状态</TD>
                            <TD class=View_title noWrap align=left>价值评估</TD>
                            <TD class=View_title noWrap align=middle>客户地址</TD>
                            <TD class=View_title style="BORDER-RIGHT: 0px" 
                            noWrap align=middle>操作</TD></TR></THEAD>
                          <TBODY id="personcustomerlist">
                         <logic:notPresent name="list" scope="request">
                            <tr><td>数据库中没有任何记录</td></tr>
                          </logic:notPresent>
                          <logic:present name="list" scope="request">
                          <logic:iterate id="li" name="list" scope="request">
                          <TR onMouseOver="this.bgColor='#f2f8ff';" 
                          onmouseout="this.bgColor='#ffffff';" bgColor=#ffffff 
                          width="100%">
                            <TD class=View_item2 noWrap align=middle><input type="checkbox" id="check"　onclick="changechecked(this)" value="${li.id}"/>
                             </TD>
                            <TD class=View_item2 noWrap align=middle>${li.pname}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.ename}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.psexs}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.pbirthday}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.phonetel}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.style}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.ccredit}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.paddress}</TD>
                            <TD class=View_item2 style="BORDER-RIGHT: 0px" 
                            noWrap align=middle">
                            <div class="width:50px" onclick="modi(${li.id});">修 改</div></TD></TR>
                            </logic:iterate>
                            </logic:present>
                         </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
              </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM>
</BODY></HTML>
