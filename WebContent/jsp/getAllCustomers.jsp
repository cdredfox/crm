
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

<SCRIPT language=javascript>
function pass(id,name)
{
	opener.document.all.customerid.value=id;
	opener.document.all.customername.value=name;
	window.close();
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
            <P style="MARGIN-TOP: 4px">所有客户列表</P></TD></TR></TBODY></TABLE></TD></TR>
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
                            align=left>客户名称</TD>
                            <TD class=View_title noWrap align=middle>客户行业</TD>
                            <TD class=View_title noWrap 
                            align=left>客户电话</TD>
                            <TD class=View_title noWrap align=left>客户所属人</TD>
                            <TD class=View_title style="BORDER-RIGHT: 0px" 
                            noWrap align=middle>选择</TD></TR></THEAD>
                          <TBODY id="employeelist">
                         <logic:notPresent name="list" scope="request">
                            <tr><td>数据库中没有任何记录</td></tr>
                          </logic:notPresent>
                          <logic:present name="list" scope="request">
                          <logic:iterate id="li" name="list" scope="request">
                          <TR onMouseOver="this.bgColor='#f2f8ff';" 
                          onmouseout="this.bgColor='#ffffff';" bgColor=#ffffff 
                          width="100%">
                          	<TD class=View_item2 noWrap align=left></TD>
                            <TD class=View_item2 noWrap align=middle>${li.name}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.cindus}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.phone}</TD>
                            <TD class=View_item2 noWrap align=middle>${li.ename}</TD>
                            <TD class=View_item2 style="BORDER-RIGHT: 0px" 
                            noWrap align=middle" onclick="pass(${li.id },'${li.name }');"><img src="<%=request.getContextPath()%>/images/prev.gif"></TD>
                            </TR>
                            </logic:iterate>
                            </logic:present>
                         </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
              </TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM>
</BODY></HTML>
