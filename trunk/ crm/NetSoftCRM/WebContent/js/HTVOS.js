function ReplaceAll(strOrg,strFind,strReplace){
var index = 0;
while(strOrg.indexOf(strFind,index) != -1){
strOrg = strOrg.replace(strFind,strReplace);
index = strOrg.indexOf(strFind,index);
}
return strOrg
} 


function showHide(sectionArray)
{
	if (sectionArray[0])
		{
		for (var i = 1; i < sectionArray.length; i++) {
			if (sectionArray[i].style.visibility == "hidden") {
				(sectionArray[i].style.visibility = "visible");
			}
			else {
				(sectionArray[i].style.visibility = "hidden");
			}
		}
	}
}

//Tab维护开始
var lastTab = null;
var lastDisplay = null;
function LocateTab(tabID){
	if ((lastTab != tabID) && (lastTab != null)){
		lastTab.style.zIndex = "1";
		lastTab.style.top = "3";
		lastTab.style.backgroundImage='url(images\/UnselectTab.gif)';
		lastTab.style.fontWeight='normal';
		lastTab.style.paddingTop='2px';
    	}
	if (tabID.style.zIndex == "3")
		{
	      	tabID.style.zIndex = "3";
	  	tabID.style.top = "0";
		tabID.style.backgroundImage='url(images\/SelectTab.gif)';
		tabID.style.fontWeight='bold';
		tabID.style.paddingTop='4px';
		}
	else 
		{
		tabID.style.zIndex = "3"; 
		tabID.style.top = "0";
		tabID.style.backgroundImage='url(images\/SelectTab.gif)';
		tabID.style.fontWeight='bold';
		tabID.style.paddingTop='4px';
   		lastTab = tabID;
    	}
}

function DisplayTab(displayID){

	if ((lastDisplay != displayID) && (lastDisplay != null)){
	  lastDisplay.style.display="none";
    }
	if (displayID.style.display=="block"){
      displayID.style.display="block";
	}
	else {displayID.style.display="block"; 
   	  lastDisplay = displayID;
    }
}
//Tab维护结束



//函数名:Str1HasCharOfStr2
//功能介绍：str1中是否包含str2拥有的字符
//参数说明：str1是要检查的字符串，str2是特征字符集
//返回值：1：是  0：不是
function Str1HasCharOfStr2(str1,str2)
{	
    var i,j;
	for (i=0;i<str1.length;i++)
	{	
	    j=str2.indexOf(str1.charAt(i));
	    if (j!=-1)
	    {
	       return 1;
	    }
	}
	return 0;
}
//判断日期是否合法，
function IsDate(DateString , Dilimeter) 
{ 
if (DateString==null) return false; 
if (Dilimeter=='' || Dilimeter==null) 
Dilimeter = '-'; 
var tempy=''; 
var tempm=''; 
var tempd=''; 
var tempArray; 
if (DateString.length<8 && DateString.length>10) 
return false;  
tempArray = DateString.split(Dilimeter); 
if (tempArray.length!=3) 
return false; 
if (tempArray[0].length==4) 
{ 
tempy = tempArray[0]; 
tempm = tempArray[1]; 
tempd = tempArray[2]; 
} 
else 
{ 
tempy = tempArray[2]; 
tempd = tempArray[1]; 
tempm = tempArray[0]; 
} 


if(tempm.toString().substring(0,1)=="0")
	tempm=tempm.toString().substring(1,2)
if(tempd.toString().substring(0,1)=="0")
	tempd=tempd.toString().substring(1,2)
var tDateString = tempy + '/'+ tempm + '/'+tempd+' 8:0:0';//加八小时是因为我们处于东八区 
var tempDate = new Date(tDateString); 
if (isNaN(tempDate)) 
	return false; 
if (((tempDate.getUTCFullYear()).toString()==tempy) && (tempDate.getMonth()==parseInt(tempm)-1) && (tempDate.getDate()==parseInt(tempd))) 
{ 
return true; 
} 
else 
{ 
return false; 
} 
} 

//函数名:Str1CharAllInStr2
//功能介绍：str1中的字符是否都在str2中
//参数说明：str1是要检查的字符串，str2是特征字符集
//返回值：1：是  0：不是
function Str1CharAllInStr2(str1,str2)
{	
    var i,j;
	for (i=0;i<str1.length;i++)
	{	
	    j=str2.indexOf(str1.charAt(i));
	    if (j==-1)
	       return 0;
	}
	return 1;
	
}

//函数名:ISZhongWenAndZiFu
//功能介绍：str1中的非中文的字符是否都在str2中
//参数说明：str1是要检查的字符串，str2是特征字符集
//返回值：1：是  0：不是
function ISZhongWenAndZiFu(str1,str2)
{	
    var i,j;
	for (i=0;i<str1.length;i++)
	{	
	    j=str2.indexOf(str1.charAt(i));
	    if (j==-1&&!HasChinese(str1.charAt(i)))
	       return 0;
	}
	return 1;
	
}
//函数名IsAccount(string)
//检查用户账号是否正确
//参数说明：string是要检查的字符串
//返回值：1：是  0：不是
//
var strCharNum = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-";	
var sPhoneChar = "0123456789()+-";
function IsAccount(string)
{	
    return ISZhongWenAndZiFu(string,strCharNum);
}


//函数名IsPhoneNumber(Number)
//检查电话号码是否正确
//参数说明：string是要检查的字符串
//返回值：1：是  0：不是
//
function IsPhoneNumber(Number)
{	
    return Str1CharAllInStr2(Number,sPhoneChar);
}

//函数名IsValidEmail(Email)
//检查电子邮件是否正确
//参数说明：Email是要检查的电子邮件
//返回值：1：是  0：不是
//
function IsValidEmail(Email)
{
	var strEmail=strCharNum+'@'+'.';
	if (Email.length==0)
	    return 0;
	
	if (Str1HasCharOfStr2(Email,'@')==0)
	{	return 0;
	}
	if (Str1HasCharOfStr2(Email,'.')==0)
	{	
		return 0;
	}
	return Str1CharAllInStr2(Email,strEmail);
}







//函数名HasChinese(str)
//检查是否有中文
//参数说明：str是要检查的字符串
//返回值：1：是  0：不是
//
function HasChinese(str)
{
	if(escape(str).indexOf("%u")!=-1)
		return true;
	else
		return false;
// for (lgth=0;lgth<=str.length;lgth++)
 //     if ( (str.charCodeAt(lgth)>128) )
//	return true;
 //  return false;
}

//函数名isNumber(id)
//检查是否为数字
//参数说明：id是要检查的字符串
//返回值：1：是  0：不是
//

function isNumber(id)
{
	if (id == null || id == "") {
		return 0;
	}

	if (isNaN(id)) {
		return 0;
	}
	return 1;
}

function isOnLastPg(f)
{
	curPg = parseInt(f.currentPg.value);
	lastPg = parseInt(f.totalRecord.value);
	if (curPg >= lastPg) {
		alert("这已经是最后一页");
		return true;
	}
	return false;
}

function isOnFirstPg(f)
{
	curPg = parseInt(f.currentPg.value);
	if (curPg <= 1) {
		alert("这已经是第一页");
		return true;
	}
	return false;
}

function gotoNext(f)
{
	if (isOnLastPg(f)) return false;
	f.start.value=f.nextPg.value;
	f.submit();
	return false;
}

function gotoFirst(f)
{
	if (isOnFirstPg(f)) return false;
	f.start.value=0;
	f.submit();
	return false;
}

function gotoPrev(f)
{
	if (isOnFirstPg(f)) return false;
	f.start.value=f.prevPg.value;
	f.submit();
	return false;
}

function gotoLast(f)
{
	if (isOnLastPg(f)) return false;
	f.start.value=f.lastPg.value;
	f.submit();
	return false;
}

function changePagecount(f)
{
	f.submit();
	return false;	
	}
function validateGotoS(f)
{
	val = f.txtGoto.selectedIndex+1;
	
	if (val == null || val == "") {
		alert("请输入页码");
		return false;
	}
	
	if (isNaN(val)) {
		alert("请输入一个有效的数字页码");
		return false;
	}
	
	val = parseInt(val)
	totalRecord = parseInt(f.totalRecord.value)
	if (val < 1 || val > totalRecord) {
		alert("请输入一个有效的页码（ 1 " + " -- " + totalRecord + "）");
		return false;
	}
	
	f.btnAction.value="Go To";
	f.start.value=val;
	f.submit();
	return false;
}
function validateGoto(f)
{
	val = f.txtGoto.value;
	
	if (val == null || val == "") {
		alert("请输入页码");
		return false;
	}
	
	if (isNaN(val)) {
		alert("请输入一个有效的数字页码");
		return false;
	}
	
	val = parseInt(val)
	totalRecord = parseInt(f.totalRecord.value)
	if (val < 1 || val > totalRecord) {
		alert("请输入一个有效的页码（ 1 " + " -- " + totalRecord + "）");
		return false;
	}
	
	f.btnAction.value="Go To";
	f.start.value=val;
	f.submit();
	return false;
}

function hasField(f, fldNm)
{
	for (var i = 0; i < f.length; i++)
		if (f.elements[i].name == fldNm ) return true;
		
	return false;
}
function markSelected(f, lstNm, v) 
{
	for (var i=0; i < f.elements.length; i++) {
		var e = f.elements[i];
		if (e.name == lstNm )
			for (var j=0; j < e.options.length; j++)
				if (e.options[j].text == v) e.options[j].selected = 1;
	}
}
function validateQuickSearch(f)
{
	val = f.keyword.value;
	
	/*if (val == null || val == "") {
		alert("输入您要查询的关键字");
		return false;
	}*/
	
	val =  f.kind.value;
	if (val == null || val == "") {
		alert("请选择需要查询的字段");
		return false;
	}
	
	f.start.value = 0;
	if (hasField(f, "lastSearchMode"))  f.lastSearchMode.value = f.currentView.value;
	markSelected(f, "lstView", "(Search results)");
	f.submit();
	return false;
}

function GetObjID(ObjName)
{
  for (var ObjID=0; ObjID < window.powersearch.elements.length; ObjID++)
    if ( window.powersearch.elements[ObjID].name == ObjName )
    {  return(ObjID);
       break;
    }
  return(-1);
}
//选择用户
function AddItem(ObjName, DesName, CatName)
{
  //得到原与目标的索引
  ObjID    = GetObjID(ObjName);
  DesObjID = GetObjID(DesName);
  k=0;
  i = document.powersearch.elements[ObjID].options.length;
  if (i==0)
    return;
  maxselected=0
  //得到当前选中的项数目k,maxselected为选择的最大数（下限）
  for (h=0; h<i; h++)
     if (document.powersearch.elements[ObjID].options[h].selected ) {
         k=k+1;
         maxselected=h+1;
         }
  if (maxselected>=i)
     maxselected=0;
  if ( ObjID != -1 && DesObjID != -1)
  { 
    //i原长度，j目的长度
    i = document.powersearch.elements[ObjID].options.length;
    j = document.powersearch.elements[DesObjID].options.length;
    
    //将左边的一个一个审查
    for (h=0; h<i; h++)
    { if (document.powersearch.elements[ObjID].options[h].selected && document.powersearch.elements[ObjID].options[h].value!="")
      {  Code = document.powersearch.elements[ObjID].options[h].value;
         Text = document.powersearch.elements[ObjID].options[h].text;
         j = document.powersearch.elements[DesObjID].options.length;
         //四种情况：
         //1、左边包含右边
        if (Code.indexOf('##')!=-1) {
			
            
            for (k=j-1; k>=0; k-- ) {
			  Code1=document.powersearch.elements[DesObjID].options[k].value;
              if(Code1.substring(0,Code1.indexOf('#')) == Code.substring(0,Code.indexOf('#')) )
                 document.powersearch.elements[DesObjID].options[k]=null;
            }
            j= document.powersearch.elements[DesObjID].options.length;
         }
         HasSelected = false;
         for (k=0; k<j; k++ ) {
			//2、右包含左
			Code1=document.powersearch.elements[DesObjID].options[k].value;
			if (Code1.indexOf('##')!=-1 &&  (Code1.substring(0,Code1.indexOf('#'))== Code.substring(0,Code.indexOf('#'))) ){
			   HasSelected = true;
			   window.alert('已经包括本选项：'+Text.substring(2,Text.length));
			   break;
			}
			//3、左边等于右边，退出
			if (document.powersearch.elements[DesObjID].options[k].value == Code)
			{  HasSelected = true;
			   break;
			}
           
        }
            
        if ( HasSelected == false)
         {
             document.powersearch.elements[DesObjID].options[j] = new Option(Text, Code);
         }//if
         document.powersearch.elements[ObjID].options[h].selected =false;
       }//if
    }//for
    document.powersearch.elements[ObjID].options[maxselected].selected =true;
  }//if
}//end of function

function DeleteItem(ObjName)
{
  ObjID = GetObjID(ObjName);
  minselected=0;
  if ( ObjID != -1 )
  {
    for (i=window.powersearch.elements[ObjID].length-1; i>=0; i--)
    {  if (window.powersearch.elements[ObjID].options[i].selected)
       { // window.alert(i);
          if (minselected==0 || i<minselected)
            minselected=i;
          window.powersearch.elements[ObjID].options[i] = null;
       }
    }
    i=window.powersearch.elements[ObjID].length;

    if (i>0)  {
        if (minselected>=i)
           minselected=i-1;
        window.powersearch.elements[ObjID].options[minselected].selected=true;
        }
  }
}
function fillDuty(f)
{

	for (var i=0; i < f.DepartMentID.options.length; i++)
		if (f.DepartMentID.options[i].selected) temp= f.DepartMentID.options[i].value;
	f.Duty.selectedIndex=0;
	f.Duty.options[0]=new Option("----选择职务----","");
	j=1;
	for (var i=0; i < f.Dutytotal.options.length; i++)
	{
		if((f.Dutytotal.options[i].value).indexOf('*'+temp+'*')!=-1){
			f.Duty.options[j]=new Option(f.Dutytotal.options[i].text,f.Dutytotal.options[i].value);
			j++;
		}
	}
	f.Duty.options.length=j;
	
}
function filldepart(f)
{
	for (var i=0; i < f.Duty.options.length; i++)
		if (f.Duty.options[i].selected){
			if(f.Duty.options[i].value==""){ return;}
			break;
		}
	for (var j=0; j < f.DepartMentID.options.length; j++){
		if((f.Duty.options[i].value).indexOf("*" + f.DepartMentID.options[j].value + "*")!=-1){
		f.DepartMentID.selectedIndex=j;
		break;}
	}

}

function fillreqtype(f)
{
	for (var i=0; i < f.reqlevel2.options.length; i++)
		if (f.reqlevel2.options[i].selected){
			if(f.reqlevel2.options[i].value==""){ return;}
			break;
		}
	for (var j=0; j < f.reqlevel1.options.length; j++){
		if((f.reqlevel1.options[j].value).substring(0,2) == (f.reqlevel2.options[i].value).substring(0,2)){
		f.reqlevel1.selectedIndex=j;
		break;}
	}

}
function fillreqcontent(f)
{

	for (var i=0; i < f.reqlevel1.options.length; i++)
		if (f.reqlevel1.options[i].selected){temp= (f.reqlevel1.options[i].value).substring(0,2);break;}
	f.reqlevel2.selectedIndex=0;
	f.reqlevel2.options[0]=new Option("","");
	j=1;
	for (var i=0; i < f.reqlevel2total.options.length; i++)
	{
		if((f.reqlevel2total.options[i].value).substring(0,2) == temp){
			f.reqlevel2.options[j]=new Option(f.reqlevel2total.options[i].text,f.reqlevel2total.options[i].value);
			j++;
		}
	}
	f.reqlevel2.options.length=j;
	
}

