<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>网软客户关系管理系统</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<NOSCRIPT>
			<META content="MSHTML 6.00.2900.2912" name=GENERATOR>
	</HEAD>
	<BODY>
		<IFRAME src="*.html"></iframe>
		</IFRAME>
		</noscript>
	<FRAMESET name="frmTool" width="800" framespacing="0" border="0"
		frameborder="NO" rows="85,11,*,0,0">
		<FRAME name="top" target="detail"
			src="<%=request.getContextPath()%>/jsp/top.jsp" noresize
			scrolling="NO">
		<FRAME id=fraConTop
			style="BORDER-RIGHT: medium none; BORDER-TOP: medium none; BORDER-LEFT: medium none; BORDER-BOTTOM: medium none"
			name="fraConTop" border="0"
			src="<%=request.getContextPath()%>/jsp/conTop.jsp" scrolling="no"
			LEFTMARGIN="0" TOPMARGIN="0" noResize frameBorder="0"
			marginHeight="0" marginWidth="0">
		<FRAMESET name="frmMenu" framespacing="0" border="0" frameborder="no"
			bordercolor="4867AE" cols="160,12,*">
			<FRAME name="dir" framespacing="0" border="0"
				src="<%=request.getContextPath()%>/jsp/menutool.jsp?taget=menu&menuid=0" scrolling="No"
				bordercolor="4867AE">
			<FRAME id=fraConLeft
				style="BORDER-RIGHT: medium none; BORDER-TOP: medium none; BORDER-LEFT: medium none; BORDER-BOTTOM: medium none"
				name="fraConLeft" border="0"
				src="<%=request.getContextPath()%>/jsp/conLeft.jsp" scrolling="no"
				LEFTMARGIN="0" TOPMARGIN="0" noResize frameBorder="0"
				marginHeight="0" marginWidth="0">
			<FRAMESET name="frmRightmain" framespacing="0" border="0"
				frameborder="NO" rows="*,25">
				<FRAME name="detail" framespacing="0" border="0"
					src="<%=request.getContextPath()%>/jsp/desktop.jsp"
					bordercolor="4867AE">
				<FRAME name="bottom"
					src="<%=request.getContextPath()%>/jsp/bottom.jsp" noresize
					scrolling="no">
			</FRAMESET>
		</FRAMESET>
		<!--用以监视系统的变化状态，以便改动Bottom条
<FRAME 
name="monitorbottom" src="<%=request.getContextPath()%>/jsp/sysmonitor.jsp" noresize 
scrolling="no">
-->
		<FRAME name="sound" src="about:blank" noresize scrolling="no">
		<NOFRAMES>
			<body>
				<p>
					您的浏览器不支持Frame格式，请下载新版本。
				</p>
			</body>
		</NOFRAMES>
	</FRAMESET>
	<NOFRAMES>
		</body>
	</NOFRAMES>
	</BODY>
</HTML>