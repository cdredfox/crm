<%@ taglib prefix="page" uri="/WEB-INF/tags/currpage.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@ page contentType="text/html; charset=utf-8" language="java"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD><TITLE></TITLE><LINK href="<%=request.getContextPath()%>/css/CSSForV10.css" 
type=text/css rel=stylesheet>
<link href="<%=request.getContextPath()%>/css/style_2007.css" rel="stylesheet" type="text/css" />
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/orderby.js"></SCRIPT>

<STYLE>

THEAD .arrow {
	COLOR: black; FONT-FAMILY: webdings
}
.button1{
		cursor: hand;
		color:blue;
}
</STYLE>
<LINK title=style href="<%=request.getContextPath()%>/css/style.css" type=text/css 
rel=stylesheet>
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/type.js"></SCRIPT>
<LINK href="<%=request.getContextPath()%>/css/table.css" type=text/css rel=stylesheet>
<META charset=gb2312 content="MSHTML 6.00.2900.2912" name=GENERATOR>
<SCRIPT language=JavaScript src="<%=request.getContextPath()%>/js/HTVOS.js"></SCRIPT>
<script type='text/javascript' src='/NetSoftCRM/dwr/interface/RoleAjax.js'></script>
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
 			RoleAjax.delRoleById(f.elements[i].value,delreload);
 		}else
 		{
 			break;
 		}
 	}
 }
}


function seach(str1)
{
	if(str1==1)
	{
		EmployeeAjax.findEmployeeByAny("ecode",document.getElementById("code").value,allcallback);
	}else
	{
	  
		EmployeeAjax.findEmployeeByAny("ename",document.getElementById("name").value,allcallback);
	}
}

function delreload(msg)
{
	if(msg==true)
	{
	alert("您已经成功删除了！～");
	reloadall();
	}
	else{
	alert("删除失败了:)。请检查您的操作");
	reloadall();
	}
	
}

function changechecked(checkbut){
	var v =checkbut.checked;
	if (v) {
 	checkbut.checked = true;
 }else{
 	checkbut.checked = false;
 }
}

function role(id)
{
	//window.open("/NetSoftCRM/employee.crm?method=roleView&id="+id,"员工角色",'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=490,height=320,left=0,top=0');
	window.open("/NetSoftCRM/role.crm?method=getAllRole&id="+id,"角色选择",'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=300,height=320,left=512,top=384');


}

function windowopen(msg)
{
	window.open(msg,"增加员工",'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=300,height=320,left=200,top=100');
}


function reloadall()
{
	RoleAjax.getAllRoles(allcallback);
}
//定义转换规则
var getid=function(unit){return "<input type='checkbox' id='check'　onclick='changechecked(this)' value='"+unit.id+"'/>"};
var getrname=function(unit){return unit.rname};
var getrmessage=function(unit){return unit.rmessage};
var getrdelStyle=function(unit){return unit.rdelStyle==0?"有效":"<font color='red'>禁用</div>"};
var getoper=function(unit){return "<table align='center'><tr><td><div class='width:50px' onclick='givePower("+unit.id+");' style='cursor: hand;color: blue;'>角色授权</div></td><td><div class='width:50px' onclick='changeStyle("+unit.id+","+unit.rdelStyle+");' style='cursor: hand;color: blue;'>状态改变</div></TD></TR></td></tr></table>"};
function allcallback(msg)
{
　　DWRUtil.removeAllRows("roleList");
   DWRUtil.addRows("roleList",msg,[getid,getrname,getrmessage,getrdelStyle,getoper]);
}


function givePower(id)
{
	window.open("/NetSoftCRM/role.crm?method=getPowerByRole&id="+id,"角色授权",'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,copyhistory=yes,width=490,height=450,left=0,top=0');
}


function changeStyle(cid,id)
{
      RoleAjax.changeStyle(cid,id,changeCallback);
}

function changeCallback(msg)
{
	if(msg==true)
	{
		alert("角色状态已经被成功更改");
		reloadall();
	}else
	{
		alert("角色状态修改失败了。操作有误");
		reloadall();
	}
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
            <P style="MARGIN-TOP: 4px">所有角色列表</P></TD></TR></TBODY></TABLE></TD></TR>
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
                                <td class=MR_pinp vAlign=center width=65 > <input type="text" onMouseOver="this.style.borderColor='#99E300'" onMouseOut="this.style.borderColor='#A1BCA3'" id="code"  maxlength="30" tabindex="1"/> </td>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="seach(1);" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width=55><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align=absMiddle 
                                border=0>查找</TD>
                                
                                <TD width=1><IMG 
                                style="MARGIN-TOP: 3px; MARGIN-LEFT: 8px; MARGIN-RIGHT: 8px" 
                                src="<%=request.getContextPath()%>/images/group.gif"></TD>
                                <td class=formKey vAlign=center width=65>按姓名查找</td>             
                                <td class=MR_pinp vAlign=center width=65 > <input type="text" onMouseOver="this.style.borderColor='#99E300'" onMouseOut="this.style.borderColor='#A1BCA3'" id="name"  maxlength="30" tabindex="1"/> </td>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                id=Td_ColumnSet 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="seach(2);" 
                                onmouseout="this.className='formKey'" 
                                vAlign=center width="55"><IMG class=icon0 
                                style="MARGIN-LEFT: 3px; CURSOR: hand" 
                                src="<%=request.getContextPath()%>/images/icon_search.gif" 
                                align=absMiddle 
                                border=0>查找</TD>
                                <TD width=1><IMG 
                                style="MARGIN-TOP: 3px; MARGIN-LEFT: 8px; MARGIN-RIGHT: 8px" 
                                src="<%=request.getContextPath()%>/images/group.gif"></TD>
                                <TD onMouseUp="this.className='formKey_over'" 
                                class=formKey 
                                onmousedown="this.className='formKey_down'" 
                                onmouseover="this.className='formKey_over'" 
                                style="CURSOR: hand" 
                                onclick="windowopen('/NetSoftCRM/jsp/addRole.jsp');" 
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
                            align=left>角色名称</TD>
                             <TD class=View_title noWrap 
                            align=left>角色信息</TD>
                            <TD class=View_title noWrap align=middle>角色状态</TD>
                            <TD class=View_title style="BORDER-RIGHT: 0px" 
                            noWrap align=middle>操作</TD></TR></THEAD>
                          <TBODY id="roleList">
                         <logic:notPresent name="role" scope="request">
                            <tr><td>数据库中没有任何记录</td></tr>
                          </logic:notPresent>
                          <logic:present name="role" scope="request">
                          <logic:iterate id="r" name="role" scope="request">
                          <TR onMouseOver="this.bgColor='#f2f8ff';" 
                          onmouseout="this.bgColor='#ffffff';" bgColor=#ffffff 
                          width="100%">
                          
                            <TD class=View_item2 noWrap align=middle><input type="checkbox" id="check"　onclick="changechecked(this)" value="${r.id}"/>
                             </TD>
                            <TD class=View_item2 noWrap align=left>${r.rname}</TD>
                            <TD class=View_item2 noWrap align="left">${r.rmessage}</TD>
                            <TD class=View_item2 noWrap align="center">${r.rdelStyle==0?"有效":"<font color='red'>禁用</div>"}
                            </TD>
                            <TD class=View_item2 style="BORDER-RIGHT: 0px" 
                            noWrap align=middle">
                            <table align="center">   
                            <tr>
                            <td>
                            <div class="width:50px" onclick="givePower(${r.id});" style="cursor: hand;color: blue;">角色授权</div></td><td><div class="width:50px" onclick="changeStyle(${r.id},${r.rdelStyle});" style="cursor: hand;color: blue;">状态改变</div></TD></TR>
                            </td>
                            </tr>
                            </table>
                            </logic:iterate>
                            </logic:present>
           
 
        
                         </TBODY></TABLE>
                          <!--  
                          <page:currpage page="${page}" count="${count}" action="fontpage.do" valuename="page" ajaxOn="true" methodName="Curpage" pageSize="1"/>
                         -->
                         </TD></TR></TBODY></TABLE></TD></TR>
              </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM>
</BODY></HTML>