<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html.tld"%>
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
	<head>
		<LINK href="<%=request.getContextPath()%>/css/eall2002.css"
			rel=stylesheet type=text/css>
		<script type='text/javascript'
			src='/NetSoftCRM/dwr/interface/MySqlAjax.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/engine.js'></script>
		<script type='text/javascript' src='/NetSoftCRM/dwr/util.js'></script>

		<script type="text/javascript">
		function oper(obj)
		{
			if(obj.value==2)
			{
				document.getElementById("backup").style.display="none";
				document.getElementById("import").style.display="block";
			}else
			{
				document.getElementById("import").style.display="none";
				document.getElementById("backup").style.display="block";
			}
		}
		
		function backup()
		{
			var path=document.getElementById("path").value;
			alert(path);
			MySqlAjax.backup(path,msgback);
		}
		
		function importdb()
		{
			if(window.confirm("严重警告：此项操作十分危险！数据恢复后,目前系统中的数据将全部丢失!将会使用您导入的数据！请确认您是否真的要恢复数据？"))
			{
				var path=document.getElementById("ipath").value;
				MySqlAjax.load(path,msgback);
			}
		}
	   function msgback(msg)
	   {
	   	alert(msg);
	   }
	</script>
	</head>

	<BODY>
		<table width='800' border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td id=mainftitle>
					[ 数据备份/还原 ]
				</td>
			</tr>
		</table>
		<table id=bgtable width='680' border='0' cellspacing='1'
			cellpadding='0' align=center>
			<tr>
				<td id=bgtitle colspan=5 align=center>
					<b>数据信息备份与还原</b></font>
				</td>
			</tr>
			<tr>
				<td id=bgbody>
					请选择操作:
				</td>
				<td id=bgbody>
					<input type="radio" name="type" value="1" checked="checked"
						onclick="oper(this);">
					数据备份
					<input type="radio" name="type" value="2" onclick="oper(this);">
					数据还原
				</td>

			</tr>
			<tr>
				<td colspan=5 align=center id=bgtitle>
					<div id="backup">
						<table width="100%">
							<tr>
								<td id=bgbody>
									备份路径:
								</td>
								<td id=bgbody>
									<input type="text" id="path" value="c:\" readonly />
								</td>
							</tr>
							<tr>
								<td id=bgbody>
									注意事项：
								</td>
								<td id=bgbody>
									<font color="red"><b>*系统默认的备份文件存放目录是c:\您可以在成功备份后，将该文件移到其它目录下面，安全存放</b>
									</font>
								</td>
							</tr>
							<tr>
								<td id=bgbody>
									操 作：
								</td>
								<td id=bgbody>
									<input type="button" value="确认备份操作" onclick="backup();" />
								</td>
							</tr>
						</table>
					</div>
					<div id="import" style="display: none">
						<table width="100%">
							<tr>
								<td id=bgbody>
									选择还原文件:
								</td>
								<td id=bgbody>
									<input type="file"
										id="ipath" />
								</td>
							</tr>
							<tr>
								<td id=bgbody>
									注意事项：
								</td>
								<td id=bgbody>
									<font color="red"><b>*还原后,目前数据库的数据将会丢失,所有的数据将会被更换成你还原文件中的数据</b>
									</font>
								</td>
							</tr>
							<tr>
								<td id=bgbody>
									操 作：
								</td>
								<td id=bgbody>
									<input type="button" value="确认还原操作" onclick="importdb();"/>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<div id="cccc" style="display: none">

			</div>
		</table>
	</body>
</html>