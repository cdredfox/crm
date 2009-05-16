<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>网软客户关系管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK id=cssLinkId href="<%=request.getContextPath() %>/css/eim.css" type=text/css 
rel=stylesheet>
<SCRIPT language=javascript src="<%=request.getContextPath() %>/js/public.js"></SCRIPT>

<SCRIPT language=javascript>       
			function InitFocus()
			{
				
				document.all('username').focus();
			}
			function check()
			{
			   if(document.all('username').value=="")
			   {
			      alert("用户名不能为空！");
			      document.all('username').focus();
			      return false;
			   }
			   if(document.all('userpwd').value=="")
			   {
			      alert("密码不能为空！");
			      document.all('userpwd').focus();
			      return false;
			   }
			}
		</SCRIPT>

<STYLE type=text/css>.style1 {
	FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #ffffff
}
BODY {
	BACKGROUND-IMAGE: url(images/di.gif)
}
.textarea-hei {
	BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; FONT-SIZE: 12px; BORDER-LEFT: #000000 1px solid; WIDTH: 90px; COLOR: #000000; BORDER-BOTTOM: #000000 1px solid; FONT-FAMILY: "����"; TEXT-DECORATION: none
}
</STYLE>
</HEAD>
<BODY onload=InitFocus()>
		<html:form action="/login?method=login" onsubmit="return check();">
			<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%"
				align=center border=0>
				<TBODY>
					<TR>
						<TD align=middle>
							<TABLE class="BlackDiv" cellSpacing=0 cellPadding=0 width=776
								background=<%=request.getContextPath() %> /images/login.jpg
								border=0>
								<TBODY>
									<TR>
										<TD vAlign=bottom align=right background="images/login.jpg" height=433>
											<TABLE cellSpacing=0 cellPadding=0 width=200 border=0>
												<TBODY>
													<TR>
														<TD vAlign=top height=180>
															<TABLE cellSpacing=0 cellPadding=0 border=0>
																<TBODY>
																	<TR>
																		<TD vAlign=center width=58 height=22>
																			<SPAN class=style1>用户名:</SPAN>
																		</TD>
																		<TD width=108>
																			<html:text property="username"
																				styleClass="textarea-hei" />
																		</TD>
																	</TR>
																	<TR>
																		<TD vAlign=center height=16>
																			&nbsp;
																		</TD>
																		<TD>
																			&nbsp;
																		</TD>
																	</TR>
																	<TR>
																		<TD vAlign=center height=21>
																			<SPAN class=style1>密 码：</SPAN>
																		</TD>
																		<TD>
																			<html:password property="userpwd"
																				styleClass="textarea-hei" />
																		</TD>
																	</TR>
																</TBODY>
															</TABLE>
															<BR>
															<TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
																<TBODY>
																	<TR>
																		<TD align=right>
																			<INPUT id=ImageButton1 type=image alt=""
																				src="<%=request.getContextPath() %>/images/dl.gif"
																				border=0 name=ImageButton1>
																		</TD>
																	</TR>
																	<tr>
																		<td vAlign=left colspan="2">${message}</td>
																	</tr>
																</TBODY>
															</TABLE>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</html:form>
	</BODY></HTML>