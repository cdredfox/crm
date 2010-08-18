<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- saved from url=(0057)http://www.erist.com/demo/VMLWorkFlow/WorkFlowDesign.aspx -->
<HTML xmlns:v = 
"urn:schemas-microsoft-com:vml"><HEAD><TITLE>WorkFlowDesign</TITLE>
<META content="MSHTML 6.00.2900.2802" name=GENERATOR>
<META content=JavaScript name=vs_defaultClientScript>
<META content=http://schemas.microsoft.com/intellisense/ie5 name=vs_targetSchema>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 

<META charset=GB2312>
<STYLE>
v\:* {
	BEHAVIOR: url(#default#VML)
}
.style3 {color: #FF9933}
</STYLE>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY  oncontextmenu='if(event.srcElement.tagName!="TEXTAREA")return false' 
onselectstart='if(event.srcElement.tagName!="TEXTAREA"&amp;&amp;event.srcElement.tagName!="INPUT")return false' 
style="CURSOR: default" bottomMargin=0 vLink=#3732cd link=#3732cd leftMargin=0 
topMargin=0 rightMargin=0>

<SCRIPT language=javascript id=clientEventHandlersJS>

//画连接两个椭圆的线
function DrawLine() {
	//alert("DrawLine....");
			//记忆最终节点
			var tempEndPoint;
			tempEndPoint=event.srcElement;
			//声明箭头对象
			var strstroke="<v:stroke color='blue' EndArrow='classic'></v:stroke>";
			var tempstroke=document.createElement(strstroke);
			//线段对象
			var strElement="<v:polyline style='Z-Index:-1' id ='ConnectLine' class='NormalLine' points='"+line1.points.value+"' EndShape='"+tempEndPoint.Refid+"' BeginShape='"+Starline.Refid+"'></v:polyline>";
			//var strElement="<v:polyline style='Z-Index:-1' id =ConnectLine class= NormalLine points="+line1.points.value+" EndShape="+tempEndPoint.Refid+" BeginShape="+Starline.Refid+"></v:polyline>";
			var newPoint = document.createElement(strElement);
			newPoint.BeginShap = Starline.Refid;
			newPoint.EndShap = tempEndPoint.Refid;
			//alert(strElement);
			//alert("newPoint.BeginShap===" + Starline.Refid + "EndShape==" + tempEndPoint.Refid);
			//alert("newPoint.BeginShap===" + newPoint.BeginShap + "EndShape==" + newPoint.EndShap);
			//增加线段的箭头。
			newPoint.appendChild(tempstroke);
			//增加子项
			WorkFlowGroup.appendChild(newPoint);
			
			//设定某个节点为起始节点
			//if(Starline.Refid=='0')
			//{
				//}
		//	document.getElementById(tempEndPoint.Refid).isStart='1';
		
	}

//画椭圆和两边的连线
function DrawWorkFlowItem()
	{
	//又是一个问题：脚本不能一次性建立group和里面的对象，只对分开建立
	//看来要定义很多对象，之后进行建立了。;
			
			//画图之前必须先把工程名填上.检测
			if(document.getElementById("xmid").value=="")
			{
				alert("对不起!你的操作有误,请在建立计划之前,首先选择你要制定计划的工程!");
				return "";
			}
			
			
			
			MaxID=MaxID+1;
					//WorkFlowItem的组
			var tempg="<v:Group style='WIDTH: 1000px; POSITION: absolute; HEIGHT: 500px;' id ='WorkFlowItemGroup' coordsize='1000,500'></v:Group>";	
					//生成组，并添加工作流项
			var tempgroupel;
			tempgroupel=document.createElement(tempg);
				//将整体加入到集合中
			WorkFlowGroup.appendChild(tempgroupel);
			
			var WorkFlowElement="<v:rect id='temp"+MaxID+"' class='WorkFlowItem' projectid='"+document.getElementById("xmid").value+"' modelid='' tacheno='' processid='" + MaxID + "' processname='新建计划' roleid='1' stepdescription='' Title='未设定角色' style='WIDTH: 1000px; POSITION: absolute; HEIGHT: 500px' coordsize = '21600,21600' fillcolor = 'red' strokecolor = '#5082b9'></v:rect>";
			//建立WorkFlowItem对象
			var NewWorkFlowItem = document.createElement(WorkFlowElement);
			tempgroupel.appendChild(NewWorkFlowItem);
			//添加一个<br>
			var br = document.createElement("<br>");
			NewWorkFlowItem.appendChild(br);			
			
			
			
				//生成fill对象并加到工作流项中
			var tempfill=document.createElement("<v:fill type = 'gradient' color2 = 'yellow' angle = '0' method = 'sigma'></v:fill>");
			NewWorkFlowItem.appendChild(tempfill);
			//生成Shadow对象并加到工作流项中
			var tempShadow=document.createElement("<v:shadow on = 't' type = 'perspective' color = 'black' opacity = '19660f' matrix = '' offset = '2pt,3pt'></v:shadow>");
			NewWorkFlowItem.appendChild(tempShadow);
			//生成Textbox对象并加到工作流项中
			var tempTextbox=document.createElement("<v:TextBox id='temp"+MaxID+"text' style='MARGIN-TOP: 4.718pt; LEFT: auto; MARGIN-LEFT: 8.312pt; WIDTH: 59.875pt; TOP: auto; HEIGHT: 29.562pt'></v:TextBox>");
			NewWorkFlowItem.appendChild(tempTextbox);
			var temptext=document.createTextNode("新建计划");
			tempTextbox.appendChild(temptext);
			
			
			
			
			//加入工作流项的流入线段,将线段加在组中。
			var tempinLine=document.createElement("<v:line class=EndLine style='POSITION: absolute;CURSOR: hand' Refid='temp"+MaxID+"' from = '1000,250' to = '1150,250' strokecolor = 'black'></v:line>");
			tempinLine.appendChild(document.createElement("<v:stroke endarrow = 'classic'></v:stroke>"));
			tempgroupel.appendChild(tempinLine);
			//加入工作流项的流出线段,将线段加在组中。
			var tempoutLine=document.createElement("<v:line class=StartLine style='POSITION: absolute;CURSOR: hand' Refid='temp"+MaxID+"'  from = '-100,250' to = '0,250'  strokecolor = 'black'></v:line>");
			tempoutLine.appendChild(document.createElement("<v:stroke startarrow = 'oval'></v:stroke>"));
			tempgroupel.appendChild(tempoutLine);
	}
	
	//根据Oval获得某个Oval的processid,roleid,tacheno,stepdescription,
	function setStep(WorkFlowItem,xmlData){
		//alert("setStep.........");
		//FlowDetail
		
		var tempElement=xmlDoc.createElement('FlowDetail');
		Root.appendChild(tempElement);
		//processid
		//alert("ProcessID........." + WorkFlowItem.getAttribute("processid"));
		var tempProcessID=xmlDoc.createElement('ProcessID');
		tempProcessID.text=WorkFlowItem.getAttribute("processid");
		tempElement.appendChild(tempProcessID);
		//RoleID
		//alert("setStep.........RoleID==" + WorkFlowItem.getAttribute("roleid"));
		var tempRoleID=xmlDoc.createElement('RoleID');
		tempRoleID.text=WorkFlowItem.getAttribute("roleid");
		tempElement.appendChild(tempRoleID);
		//TacheNo
		var tempTacheNo=xmlDoc.createElement('TacheNo');
		tempTacheNo.text=WorkFlowItem.getAttribute("tacheno");
		tempElement.appendChild(tempTacheNo);
		//StepDescription
		var StepDescription=xmlDoc.createElement('StepDescription');
		StepDescription.text=WorkFlowItem.getAttribute("stepdescription");
		tempElement.appendChild(StepDescription);
			
	}
	
	//创建各个流程的节点
	function setSteps(WorkFlowItem,xmlData){
		//alert("setSteps..");
		//FlowDetail
		xmlData += "<FlowDetail>";
		xmlData +="<projectid>" +WorkFlowItem.getAttribute("projectid") + "</projectid>";
		xmlData += "<ProcessID>" + WorkFlowItem.getAttribute("processid") + "</ProcessID>";
		xmlData +="<processname>" + WorkFlowItem.getAttribute("processname") + "</processname>";
		xmlData += "<RoleID>" + WorkFlowItem.getAttribute("roleid") + "</RoleID>";
		xmlData += "<TacheNo>" + WorkFlowItem.getAttribute("tacheno") + "</TacheNo>";
		xmlData += "<StepDescription>" + WorkFlowItem.getAttribute("stepdescription") + "</StepDescription>";		
		xmlData +="<ujdate>"+WorkFlowItem.getAttribute("ujdate")+"</ujdate>";
		xmlData += "</FlowDetail>";
		return xmlData;	
	}
	
	//取得数据，以XML形式表示
	function CreateXmlData()
	{
		//alert("CreateXmlData...");
		if(document.getElementById("modelname").value == ""){
			//alert("请填写模板名称");
			throw "请填写模板名称";
		}
		var xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		xmlData += "<flow>";
		var allSteps = new Array();
		var step;
		//取得所有的操作并进行数据形成，形成为XML格式。
		var AllOval =new Array();
		//找到所有的rect
		AllOval=document.getElementsByTagName('rect');
		//找到所有的ConnectLine
		var allLine = document.body.all.item('ConnectLine');
			var i,j;
			if (allLine!=null && AllOval!=null)
			{
				//alert("allLine!=null && AllOval!=null");
				var lines=allLine.length;
				var ovals = AllOval.length;
				if (ovals)
				{
					if(ovals != lines+1){
						//alert("ovals=lines+1 =" + ovals + "??=" + lines+1);
						throw '有未指定的关系，不能保存工作流程';
					}
					//alert("ovals>0.........");
					for (j=0; j<ovals; j++)
					{
						//如果有未指定角色的工作流项，则退出并报告错误
						if(AllOval[j].roleid=="0")
						{
							throw '有未指定角色的操作，不能保存工作流程';
							//alert("throw....");
						}
					}
				}
				
				if (lines)
				{
					//ConnectionLine的EndShape	
					var nextendShap = "";
					//获得下一个椭圆的BeginLined的RefId
					var nextbeginShap= "";
					for (i=0; i<lines; i++)
					{
						//alert("获得第一个步骤");
						//获得和开始节点连接的ConnectLine，获得第一个步骤
						if(allLine[i].BeginShap == '0'){
							//alert("allLine[i].BeginShap == '0'");
							nextendShap = allLine[i].getAttribute("EndShape"); 
							//alert("nextendShap=1=" + nextendShap);
							 for(j=0; j<ovals; j++){
							 	//alert("AllOval[i].Refid==" + AllOval[j].parentElement.children[2].Refid + "nextendShap==" + nextendShap);
							 	//即StartLine的Refid == nextendShap
							 	if(AllOval[j].parentElement.children[2].Refid == nextendShap){
							 		AllOval[j].tacheno = '1';
							 		//alert("processid====1====" + AllOval[j].getAttribute("processid"));
							 		//获得每个步骤的processid,roleid,tacheno,stepdescription,填充数据到xml中
							 		xmlData = setSteps(AllOval[j],xmlData);
							 		nextbeginShap = AllOval[j].parentElement.children[1].Refid;
							 		//alert("nextbeginShap=2=" + nextbeginShap);
							 	}
							 }
							 break;
						}else if(allLine[i].EndShap == '-1'){
							continue;
						}
					}
					//获得第二个到最后一个步骤
					//找BeginShap为nextbeginShap的ConnectLine
					step = 1;
					while(nextbeginShap != ""  && nextbeginShap != "-1"){
						alert("获得第2个以后的步骤");
						for(i=0; i<lines; i++){
							//alert("第" + i+1 + "条线");
							//alert("allLine[i].BeginShap==" + allLine[i].BeginShap + " nextbeginShap==" + nextbeginShap);
							if(allLine[i].BeginShap == nextbeginShap){
								nextendShap = allLine[i].getAttribute("EndShape");
								if(allLine[i].EndShap == '-1'){
									nextbeginShap = "-1";
									break;
								}
								 for(j=0; j<ovals; j++){
								 	if(AllOval[j].parentElement.children[2].Refid == nextendShap){
								 		step++;
								 		//alert("processid=="  + step + "== " + AllOval[j].getAttribute("processid"));
								 		AllOval[j].tacheno = step;
								 		//获得每个步骤的processid,roleid,tacheno,stepdescription,填充数据到xml中
								 		xmlData = setSteps(AllOval[j],xmlData);
								 		//allSteps[step-1] = AllOval[i].processid + "," + roleid+","+tacheno+","+stepdescription;
								 		nextbeginShap = AllOval[j].parentElement.children[1].Refid;
										i= 0;
										break;
								 	}
								 }
							}else if(allLine[i].EndShap == '-1' ||allLine[i].BeginShap == '0'){
								//alert("是第一或最后一条线");
								continue;
							}
						}
					}
				}
			}else{
				throw '有未指定的关系或角色，不能保存工作流程';
				//alert('有未指定的关系或角色，不能保存工作流程');
			}
			xmlData += "</flow>";
			//alert("xmlData==========" + xmlData);
			return xmlData;
		}
		
		
 //将WorkFlowItem的ID变化时，同时更新关系???
	function UpdateRel(oldItemID,NewItemID)
	{
	//alert("UpdateRel.......");
		var allLine = document.body.all.item('ConnectLine');
			var i;
			if (allLine!=null)
			{
				var count=allLine.length;
				if (count)
				{
					for (i=count-1; i>=0; i--)
					{
						if(allLine[i].BeginShape==oldItemID)
						allLine[i].BeginShape=NewItemID;
						if( allLine[i].EndShape==oldItemID)
						allLine[i].EndShape=NewItemID;
					}
				}
				else
				{
						if(allLine.BeginShape==oldItemID)
						allLine.BeginShape=NewItemID;
						if(allLine.EndShape==oldItemID)
						allLine.EndShape=NewItemID;
				}
			}
	}
	
	//编辑节点对应的角色
	function SelectRole(WorkFlowItemobj)
	{
		//alert("SelectRole.......");
		
		imgArr = showModalDialog('flowattr.jsp?run=' + Math.random(),window,'dialogWidth:350px; dialogHeight:150px;help:0;status:0;resizeable:1;');
		//var	imgArr = showModalDialog('flowattr.html?run=' + Math.random(),"","status:no;center:yes;scroll:no;resizable:yes;help:no;dialogWidth:370px;dialogHeight:300px");
		//window.open('../ExecuteModelAction.do?method=findAllRole&processname=' + WorkFlowItemobj.processname + '&run=' + Math.random());
		
		if (imgArr != null) 
		{
		
		//************************************
		//为进行环节号已经存在性检查
		//if (ContainDepartMent(imgArr['tacheid'])&&WorkFlowItemobj.id!=imgArr['tacheid'])
		//{
			//window.alert('环节号已经存在，请选择其它环节号');
			//return;
		//}
		//***********************************
			//保存原有的ID
			alert(imgArr);
			var arr=new Array();
			arr=imgArr.split(",");
			var oldID=WorkFlowItemobj.id;
			alert(WorkFlowItemobj);
			//为角色附值。
			//WorkFlowItemobj.title="("+imgArr['rolename']+")";
			WorkFlowItemobj.roleid=arr[0];
			
			WorkFlowItemobj.uname=arr[1];
			WorkFlowItemobj.stepdescription=arr[3];
			
			//下面这段代码.是为了更改矩形图面上的文字.通过取得那个文本节点.然后删掉.再创建一个新的上去.
			var text=document.getElementById(WorkFlowItemobj.id+"text");
			WorkFlowItemobj.removeChild(text);
			WorkFlowItemobj.processname=arr[2];//取得当前过程的名称
			var tempTextbox=document.createElement("<v:TextBox id='"+WorkFlowItemobj.id+"text' style='MARGIN-TOP: 4.718pt; LEFT: auto; MARGIN-LEFT: 8.312pt; WIDTH: 59.875pt; TOP: auto; HEIGHT: 29.562pt'></v:TextBox>");
			WorkFlowItemobj.appendChild(tempTextbox);
			var temptext=document.createTextNode(arr[2]);
			tempTextbox.appendChild(temptext);
			
			//为流入与流出节点附值
			//<v:line>的endline和startline
			//WorkFlowItemobj.parentElement.children[1].Refid=imgArr['tacheno'];
			//WorkFlowItemobj.parentElement.children[2].Refid=imgArr['tacheno'];
			
			//如果已经有关系，还得去改变关系的endshape和beginshape
			//UpdateRel(oldID,imgArr['tacheno']);
		} 
		else 
		{}
	}


	//删除节点同时删除关系
	function DeleteRelLine(WorkFlowItem)
	{
		//alert("DeleteRelLine.......");
		if(!window.confirm('确定要删除吗？'))return;
		//若是线段的话
		if(WorkFlowItem.className=="NormalLine")
		{
			WorkFlowItem.outerHTML='';
			return;
		}
		//记录节点的ID
		var tempitemid=WorkFlowItem.id;
		//清除整个组
		WorkFlowItem.parentElement.outerHTML='';

		var allLine = document.body.all.item('ConnectLine');
				var i;
				
				if (allLine!=null)
				{
					var count=allLine.length;
					if (count)
					{
						for (i=count-1; i>=0; i--)
						{
							if(allLine[i].BeginShape==tempitemid||allLine[i].EndShape==tempitemid)
							allLine[i].outerHTML='';
						}
					}
					else
					{
							if(allLine.BeginShape==tempitemid|| allLine.EndShape==tempitemid)
							allLine.outerHTML='';
					}
				}
	}
	
	function setTacheacount(){
		document.getElementById("tacheacount").value = document.getElementsByTagName('rect').length-2;
		//alert("tacheacount==" + document.getElementById("tacheacount").value);
	}

	//保存数据
	function btnSave_onclick() 
	{
		//alert("btnSave_onclick.......");
		setTacheacount();
		try
		{
		var tempdata=CreateXmlData();
			//window.alert(tempdata);
			document.all.item('Designer1_XMLData').value=tempdata;
			//window.location.href="./flow.do?method=addflow&xmldata="+tempdata;
			return true;
		}
		catch(e)
		{
			window.alert('流程不能保存，有未指定角色或关系');
			return false;
		}
	}
	
	function btnADD_onclick() {
		//alert("btnADD_onclick");
		DrawWorkFlowItem();
	}
</script>
<STYLE>A {
	COLOR: white; TEXT-DECORATION: none
}
A:hover {
	COLOR: yellow; TEXT-DECORATION: underline
}
TD {
	FONT-SIZE: 12px
}
.bon1 {
	BORDER-RIGHT: #eeeeee 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 54px; COLOR: yellow; BORDER-BOTTOM: #eeeeee 1px solid; BACKGROUND-COLOR: #619ce7
}
.bon2 {
	BORDER-RIGHT: gray 1px solid; BORDER-TOP: #eeeeee 1px solid; BORDER-LEFT: #eeeeee 1px solid; WIDTH: 54px; COLOR: white; BORDER-BOTTOM: gray 1px solid; BACKGROUND-COLOR: gray
}
</STYLE>

<form id=Form1 name=Form1 action="../flow.crm?method=addFlow" method=post>
			<INPUT type=hidden name=__EVENTTARGET> <INPUT type=hidden name=__EVENTARGUMENT> <INPUT 
			type=hidden value=dDwxNjc5MDY1NDc1Ozs+4gJe/508bS9Bw689fQ7hHI4VHXA= 
			name=__VIEWSTATE>
<SPAN id=WorkFlowItemMenu 
style="DISPLAY: none; Z-INDEX: 102; POSITION: absolute; BACKGROUND-COLOR: olive">
<!--弹出菜单-->
<INPUT class=button id=SelDep onclick='WorkFlowItemMenu.style.display="none"; SelectRole(thisobj);' type=button value=设置属性><BR>
<INPUT class=button id=shanchu onclick='WorkFlowItemMenu.style.display="none";DeleteRelLine(thisobj)' type=button value=删除><!--删除需要将节点间关系一并删除--> 
<HR style="WIDTH: 50px" color=white SIZE=0>
<INPUT class=button onclick='WorkFlowItemMenu.style.display="none"' type=button value=取消> 
</SPAN>

<TABLE id=Table1 height="100%" cellSpacing=0 cellPadding=0 width="100%" 
border=0>
  <TBODY>
  <TR>
    <TD vAlign=top noWrap align=left width="85%" height="100%">
      <DIV class=WorkFlowMap id=Chart 
      style="BORDER-RIGHT: silver 1px solid; BORDER-TOP: silver 1px solid; Z-INDEX: 101; LEFT: 0px; BORDER-LEFT: silver 1px solid; WIDTH: 100%; BORDER-BOTTOM: silver 1px solid; POSITION: absolute; TOP: 0px; HEIGHT: 95.25%">
	  <v:group 
      id=WorkFlowGroup 
      style="WIDTH: 200px; POSITION: absolute; HEIGHT: 200px; v-text-anchor: middle-center; left: -2px;" 
      coordsize = "2000,2000">
	  
	  <v:polyline id=line1 
      style="Z-INDEX: 2000; POSITION: absolute" points = "0,0,100,100"><!--钢笔可视化--><v:stroke dashstyle = 
      "shortDash"></v:stroke>
	  </v:polyline>
	  
	  <?xml version="1.0" encoding="gb2312"?>
	  <!--开始画开始节点!-->
	  <v:Group 
      id=WorkFlowItemGroup 
      style="Z-INDEX: 9000; LEFT: 502px; WIDTH: 1000px; POSITION: absolute; TOP: 1067px; HEIGHT: 500px" 
      xmlns:v="urn:schemas-microsoft-com:vml" coordsize = "1000,500"><v:rect 
      class=WorkFlowItem id=0 title=0 
      style="WIDTH: 1000px; POSITION: absolute; HEIGHT: 500px" LimiteDate="0" 
      DepName="项目开始" coordsize = "21600,21600" fillcolor = "red" strokecolor = 
      "#5082b9"><v:fill type = "gradient" color2 = "yellow" angle = "0" method = 
      "sigma"></v:fill><v:shadow on = "t" type = "perspective" color = "black" 
      opacity = "19660f" matrix = "" offset = "2pt,3pt"></v:shadow><v:TextBox 
      style="MARGIN-TOP: 4.468pt; LEFT: auto; MARGIN-LEFT: 8.437pt; WIDTH: 59.875pt; TOP: auto; HEIGHT: 29.562pt">项目开始</v:TextBox><v:stroke></v:stroke></v:rect><v:line 
      class=EndLine style="CURSOR: hand" Refid="0" from = "1000,250" to = 
      "1150,250" strokecolor = "black"><v:stroke endarrow = 
      "classic"></v:stroke></v:line><v:line class=StartLine Refid="0" from = 
      "-100,250" to = "0,250" strokecolor = "black"><v:stroke startarrow = 
      "oval"></v:stroke></v:line>
	  </v:Group>
	  <!--开始节点结束了!-->
	  
	  <!--开始画结束节点!-->
	<v:Group id=WorkFlowItemGroup 
      style="Z-INDEX: 9000; LEFT: 7315px; WIDTH: 1000px; POSITION: absolute; TOP: 1477px; HEIGHT: 500px" 
      xmlns:v="urn:schemas-microsoft-com:vml" coordsize = "1000,500"><v:rect 
      class=WorkFlowItem id=-1 title=0 
      style="WIDTH: 1000px; POSITION: absolute; HEIGHT: 500px" LimiteDate="0" 
      DepName="项目结束" coordsize = "21600,21600" fillcolor = "red" strokecolor = 
      "#5082b9"><v:fill type = "gradient" color2 = "yellow" angle = "0" method = 
      "sigma"></v:fill><v:shadow on = "t" type = "perspective" color = "black" 
      opacity = "19660f" matrix = "" offset = "2pt,3pt"></v:shadow><v:TextBox 
      style="MARGIN-TOP: 4.468pt; LEFT: auto; MARGIN-LEFT: 7.937pt; WIDTH: 59.875pt; TOP: auto; HEIGHT: 29.562pt">项目结束</v:TextBox><v:stroke></v:stroke></v:rect><v:line 
      class=EndLine style="CURSOR: hand" Refid="-1" from = "1000,250" to = 
      "1150,250" strokecolor = "black"><v:stroke endarrow = 
      "classic"></v:stroke></v:line><v:line class=StartLine Refid="-1" from = 
      "-100,250" to = "0,250" strokecolor = "black"><v:stroke startarrow = 
      "oval"></v:stroke></v:line></v:Group>
	  
	  <!--结束节点结束了!-->
	  </v:group></DIV></TD>
    <TD vAlign=top align=middle width="15%" height="100%">
      <DIV id=ToolsKit 
      style="BORDER-RIGHT: olive 1px solid; BORDER-TOP: olive 1px solid; LEFT: 614px; BORDER-LEFT: olive 1px solid; WIDTH: 90%; BORDER-BOTTOM: olive 1px solid; TOP: 100px; HEIGHT: 100%" 
      ms_positioning="FlowLayout">
      	
		  <table border="0">
		  	<tr bgcolor="#F0F0F0"><td align="center">项目名称</td></tr>
			<tr>
				<td width="68%" align="center">
					<input type="hidden" id="xmid" name="xmid"/>
					<input type="text" name="sname" id="sname">
					<a href="javascript:openmodel();"><img src="<%=request.getContextPath()%>/images/imgbtn_Date.jpg" align="absMiddle" border="0"></a>
					<input type="hidden" id="modelname" name="modelname" value="aa"/>
					<input type="hidden" id="tacheacount" name="tacheacount"/>
					
			   </td>
			</tr>
			<tr bgcolor="#F0F0F0"><td align="center">模板描述</td></tr>
			<tr>
			   <td align="center">
			   	<textarea id="modeldescription" name="modeldescription" style="width:auto;" rows="2"></textarea>
			   </td>
			 </tr>
			 <tr>
			 	<td align="center">
			 		<INPUT language=javascript id=Designer1_btnCreate class="button" onClick="javascript:window.location.reload();" type=button value=新建流程图 name=Designer1:btnCreate><br><br>
			 		<INPUT language=javascript id=Designer1_btnSave class="button" onClick="btnSave_onclick()" type=submit value=保存流程模板 name=Designer1:btnSave><BR>
			 		<!--保存模板步骤XML的数据-->
			 		<INPUT id=Designer1_XMLData type=hidden name=Designer1_XMLData> 
			 	</td>
			 </tr>
		  </table>
	  
	  <hr color="#CCCCCC" size="1" align="center"/>
	  <table border="0">
		  <tr align="center"><td><img src="<%=request.getContextPath()%>/images/flow.bmp" style="cursor:hand " onClick="btnADD_onclick();"></td></tr>
		</table>
		<hr align="center" color="#CCCCCC" size="1"/>
	  </DIV>
	  </TD>
	</TR>
	  
  </TBODY></TABLE>
</form>
<SCRIPT language=jscript>
var canmove=false;
var scaleFactor=10.26;

var tempOffsetX=0;
var tempOffsetY=0;

var mapOffsetX=0;
var mapOffsetY=0;
var Starline;
var activeConcept;
var thisobj=null   //为了完成各种基本编辑功能，如“置前”“复制”“删除”等
var StartPointX;
var StartPointY;
var MaxID=0;

var stepid = 0;
function MoveStart()
{

if(event.srcElement.className!="WorkFlowItem" && event.srcElement.className!="EndLine" &&event.srcElement.className!="StartLine") return;
	if (event.srcElement.className=="WorkFlowItem")
	{
	event.srcElement.parentElement.style.position="absolute"; 	activeConcept=event.srcElement.parentElement;
	//window.alert(GetPreWorkFlowItems(event.srcElement.id));
	//CreateXmlData();
	canmove=true;
	}
	tempOffsetX = event.offsetX;
	tempOffsetY = event.offsetY;
	
	mapOffsetX = GetMapOffsetY();
	mapOffsetY = GetMapOffsetX();	
	//为节点间画线而设
	if (event.srcElement.className=="EndLine" || event.srcElement.className=="StartLine" )
		{
		line1.style.display='';
		//保存起始线段
			Starline=event.srcElement;
			//保存开始点信息
			StartPointX=((event.x  - tempOffsetX -mapOffsetX + document.body.scrollLeft ) * scaleFactor);
			StartPointY=((event.y - tempOffsetY - mapOffsetY + document.body.scrollTop ) * scaleFactor+80);
			line1.points.value=StartPointX+","+StartPointY+","+((event.x  - tempOffsetX -mapOffsetX + document.body.scrollLeft ) * scaleFactor)+","+((event.y - tempOffsetY - mapOffsetY + document.body.scrollTop ) * scaleFactor+80);
		}
		
	Chart.attachEvent('onmousemove',Moving); 
	
}

function Moving()
{
	if (event.button !=1) return;
	
	if(canmove)
	{
		document.selection.empty();
		activeConcept.style.pixelLeft = (event.x  - tempOffsetX -mapOffsetX + document.body.scrollLeft ) * scaleFactor;
		activeConcept.style.pixelTop = (event.y - tempOffsetY - mapOffsetY + document.body.scrollTop ) * scaleFactor;
	
	}
	else
	{
	window.status=event.srcElement.className;	
	if(event.srcElement.className=="StartLine")
	{
		event.srcElement.style.cursor="hand";
		event.srcElement.title='放置在此处将建立流程';
	}

	//记录点的集合
	var EndX=((event.x  - tempOffsetX -mapOffsetX + document.body.scrollLeft) * scaleFactor);
	var EndY=((event.y - tempOffsetY - mapOffsetY + document.body.scrollTop) * scaleFactor+80);
	//前趋线段
	//增加点集合使曲线闭合
	if(EndX>StartPointX)
		{
			line1.points.value=StartPointX+","+StartPointY+","+(StartPointX+400)+","+StartPointY+","+(StartPointX+400)+","+EndY+","+EndX+","+EndY+","+(StartPointX+400)+","+EndY+","+(StartPointX+400)+","+StartPointY+","+StartPointX+","+StartPointY;
			//alert("startPointX==" + StartPointX);
			//alert("前趋线段==" + line1.points.value);
		}
		//后趋线段
		else
		{
			line1.points.value=StartPointX+","+StartPointY+","+(StartPointX+400)+","+StartPointY+","+(StartPointX+400)+","+(EndY+600)+","+EndX+","+(EndY+600)+","+EndX+","+EndY+","+
			EndX+","+(EndY+600)+","+(StartPointX+400)+","+(EndY+600)+","+(StartPointX+400)+","+StartPointY+","+StartPointX+","+StartPointY;
			//alert("后趋线段==" + line1.points.value);
		}
		
		}
}

//显示并调整所有的线段
function ShowAllLine()
{
	var allLine = document.body.all.item('ConnectLine');
	var i;
	
	if (allLine!=null)
	{
		//alert(document.body.all.item('ConnectLine').length);
		var count=allLine.length;
		if (count>0)
		{
			for (i=count-1; i>=0; i--)
			{
				
				UpdateOneLinePos(allLine[i]);
				allLine[i].className = "NormalLine";
			}
		}
		else
		{
			UpdateOneLinePos(allLine);
			allLine.className="NormalLine";	
		}
	}
}

function UpdateOneLinePos(line)
{
	
	var beginShape;
	var endShape;
	//alert("line.getAttribute('BeginShape')==" + document.all.item(line.getAttribute("BeginShape")).parentElement.id);
	//alert("line.getAttribute('BeginShape').value===" + line.getAttribute("EndShape"));
	//alert("line.getAttribute('EndShape').value===" + line.getAttribute("EndShape"));
	beginShape = document.body.all.item(line.getAttribute("BeginShape")).parentElement;
	endShape = document.body.all.item(line.getAttribute("EndShape")).parentElement;
	SetJoinLine(beginShape,endShape,line);	
}

function SetJoinLine(fromShape,toShape,Line)
{
	var fromShapeCenterX = GetCenterX(fromShape);
	var fromShapeCenterY = GetCenterY(fromShape);
	
	var toShapeCenterX = GetCenterX(toShape);
	var toShapeCenterY = GetCenterY(toShape);	
	//取得开始点与结束点
	//此处附值时，必须用（括起来。
	var StartX=(fromShape.style.pixelLeft + fromShape.style.pixelWidth+150);
	var StartY=fromShapeCenterY;
	var EndXLine=(toShape.style.pixelLeft-50);
	var EndYLine=toShapeCenterY;
	//设定新的线段点集合
	if(EndXLine>StartX)
	{
		Line.points.value=EndXLine+","+EndYLine+","+(StartX+200)+","+EndYLine+","+(StartX+200)+","+StartY+","+StartX+","+StartY
		+","+(StartX+200)+","+StartY+","+(StartX+200)+","+EndYLine+","+EndXLine+","+EndYLine;
	
	}
	else
	{
		Line.points.value=EndXLine+","+EndYLine+","+EndXLine+","+(EndYLine+500)+","+(StartX+200)+","+(EndYLine+500)+","+(StartX+200)+","+StartY+","+StartX+","+StartY+","+
		(StartX+200)+","+StartY+","+
		(StartX+200)+","+(EndYLine+500)+","+
		EndXLine+","+(EndYLine+500)+","+
		EndXLine+","+EndYLine;
	}
}




function GetCenterX(shape)
{
	 return shape.style.pixelLeft + shape.style.pixelWidth / 2;
}

function GetCenterY(shape)
{
	return shape.style.pixelTop + shape.style.pixelHeight / 2;
}


function EndMove()
{
	canmove=false;
	document.selection.empty();
}

function GetMapOffsetY()
{
	var tempMap = Chart;
	var tempY = 0;
	
	while (tempMap.tagName!="BODY")
	{		
		tempY = tempY + tempMap.offsetTop;
		tempMap = tempMap.offsetParent;
	}
	
	return 	tempY + document.body.topMargin ;
}

function GetMapOffsetX()
{
	var tempMap = Chart;
	var tempX=0;
	
	while (tempMap.tagName!="BODY")
	{		
		tempX = tempX + tempMap.offsetLeft;
		tempMap = tempMap.offsetParent;
	}
	
	return 	tempX + document.body.leftMargin ;
}

function MouseUP()
{
	line1.style.display='none';
	var tempEnd=event.srcElement;
	WorkFlowItemMenu.style.display='none';
	if((tempEnd.className=="WorkFlowItem" ||tempEnd.className=="NormalLine") && event.button==2 && tempEnd.id!='0'&& tempEnd.id!='-1')
	{
		document.all.item('SelDep').style.display='';
		if(tempEnd.className=="NormalLine")
		{
			 document.all.item('SelDep').style.display='none';
		}
		WorkFlowItemMenu.style.left=event.x;
		WorkFlowItemMenu.style.top=event.y;
		WorkFlowItemMenu.style.display='';
		thisobj=event.srcElement;
	}
	else
	{
		if(tempEnd.className=="StartLine")
		{
			//画节点之间的关系
			//加线之前进行判断
			//判断条件为：两个对象是否已经建立关系了。两个对象只建立一次关系。不能与开始节点建立流入关系
			if (!ContainLine(Starline,tempEnd)&& tempEnd.Refid!='0'&& Starline.Refid!='-1')
			{
			DrawLine();
			//引发服务器端事件__doPostBack('Add','');
			}
			else
			{
			  	window.alert('无法建立关系，可能是关系已经存在或在同一节点上建立关系');
			}
		}		
	}
			ShowAllLine();
}

	//判断节点间是否已经有关系了
	function ContainLine(fromline,Toline)
	{
		var allLine = document.body.all.item('ConnectLine');
		var i;
		
		if (allLine!=null)
		{
			var count=allLine.length;
			if (count)
			{
				for (i=count-1; i>=0; i--)
				{
					//alert("allLine[i].BeginShape==" + allLine[i].BeginShape + "  fromline.Refid=" + fromline.Refid);
					//alert("allLine[i].EndShape==" + allLine[i].EndShape + "  Toline.Refid==" +Toline.Refid);
			
					if((allLine[i].BeginShape==fromline.Refid && allLine[i].EndShape==Toline.Refid)||fromline.Refid==Toline.Refid)
					return true;
				}
			}
			else
			{
				//alert("allLine.BeginShape==" + allLine.BeginShape + "  fromline.Refid=" + fromline.Refid);
				//alert("allLine.EndShape==" + allLine.EndShape + "  Toline.Refid==" +Toline.Refid);
				if((allLine.BeginShape==fromline.Refid && allLine.EndShape==Toline.Refid)||fromline.Refid==Toline.Refid)
				return true;
			}
				return false;
		}
	}
	document.onclick = EndMove;
	Chart.onmousedown = MoveStart;
	Chart.onmouseup=MouseUP;
	function openmodel()
		{
			var win=window.open("/NetSoftCRM/sellitem.crm?method=getPass","审批通过的项目","height=450, width=450, top=50, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
		}

</SCRIPT>

<SCRIPT language=jscript>
	ShowAllLine();
</SCRIPT>

