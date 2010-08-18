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

//Tabά����ʼ
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
//Tabά������



//������:Str1HasCharOfStr2
//���ܽ��ܣ�str1���Ƿ����str2ӵ�е��ַ�
//����˵����str1��Ҫ�����ַ�����str2�������ַ���
//����ֵ��1����  0������
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
//�ж������Ƿ�Ϸ���
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
var tDateString = tempy + '/'+ tempm + '/'+tempd+' 8:0:0';//�Ӱ�Сʱ����Ϊ���Ǵ��ڶ����� 
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

//������:Str1CharAllInStr2
//���ܽ��ܣ�str1�е��ַ��Ƿ���str2��
//����˵����str1��Ҫ�����ַ�����str2�������ַ���
//����ֵ��1����  0������
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

//������:ISZhongWenAndZiFu
//���ܽ��ܣ�str1�еķ����ĵ��ַ��Ƿ���str2��
//����˵����str1��Ҫ�����ַ�����str2�������ַ���
//����ֵ��1����  0������
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
//������IsAccount(string)
//����û��˺��Ƿ���ȷ
//����˵����string��Ҫ�����ַ���
//����ֵ��1����  0������
//
var strCharNum = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-";	
var sPhoneChar = "0123456789()+-";
function IsAccount(string)
{	
    return ISZhongWenAndZiFu(string,strCharNum);
}


//������IsPhoneNumber(Number)
//���绰�����Ƿ���ȷ
//����˵����string��Ҫ�����ַ���
//����ֵ��1����  0������
//
function IsPhoneNumber(Number)
{	
    return Str1CharAllInStr2(Number,sPhoneChar);
}

//������IsValidEmail(Email)
//�������ʼ��Ƿ���ȷ
//����˵����Email��Ҫ���ĵ����ʼ�
//����ֵ��1����  0������
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







//������HasChinese(str)
//����Ƿ�������
//����˵����str��Ҫ�����ַ���
//����ֵ��1����  0������
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

//������isNumber(id)
//����Ƿ�Ϊ����
//����˵����id��Ҫ�����ַ���
//����ֵ��1����  0������
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
		alert("���Ѿ������һҳ");
		return true;
	}
	return false;
}

function isOnFirstPg(f)
{
	curPg = parseInt(f.currentPg.value);
	if (curPg <= 1) {
		alert("���Ѿ��ǵ�һҳ");
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
		alert("������ҳ��");
		return false;
	}
	
	if (isNaN(val)) {
		alert("������һ����Ч������ҳ��");
		return false;
	}
	
	val = parseInt(val)
	totalRecord = parseInt(f.totalRecord.value)
	if (val < 1 || val > totalRecord) {
		alert("������һ����Ч��ҳ�루 1 " + " -- " + totalRecord + "��");
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
		alert("������ҳ��");
		return false;
	}
	
	if (isNaN(val)) {
		alert("������һ����Ч������ҳ��");
		return false;
	}
	
	val = parseInt(val)
	totalRecord = parseInt(f.totalRecord.value)
	if (val < 1 || val > totalRecord) {
		alert("������һ����Ч��ҳ�루 1 " + " -- " + totalRecord + "��");
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
		alert("������Ҫ��ѯ�Ĺؼ���");
		return false;
	}*/
	
	val =  f.kind.value;
	if (val == null || val == "") {
		alert("��ѡ����Ҫ��ѯ���ֶ�");
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
//ѡ���û�
function AddItem(ObjName, DesName, CatName)
{
  //�õ�ԭ��Ŀ�������
  ObjID    = GetObjID(ObjName);
  DesObjID = GetObjID(DesName);
  k=0;
  i = document.powersearch.elements[ObjID].options.length;
  if (i==0)
    return;
  maxselected=0
  //�õ���ǰѡ�е�����Ŀk,maxselectedΪѡ�������������ޣ�
  for (h=0; h<i; h++)
     if (document.powersearch.elements[ObjID].options[h].selected ) {
         k=k+1;
         maxselected=h+1;
         }
  if (maxselected>=i)
     maxselected=0;
  if ( ObjID != -1 && DesObjID != -1)
  { 
    //iԭ���ȣ�jĿ�ĳ���
    i = document.powersearch.elements[ObjID].options.length;
    j = document.powersearch.elements[DesObjID].options.length;
    
    //����ߵ�һ��һ�����
    for (h=0; h<i; h++)
    { if (document.powersearch.elements[ObjID].options[h].selected && document.powersearch.elements[ObjID].options[h].value!="")
      {  Code = document.powersearch.elements[ObjID].options[h].value;
         Text = document.powersearch.elements[ObjID].options[h].text;
         j = document.powersearch.elements[DesObjID].options.length;
         //���������
         //1����߰����ұ�
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
			//2���Ұ�����
			Code1=document.powersearch.elements[DesObjID].options[k].value;
			if (Code1.indexOf('##')!=-1 &&  (Code1.substring(0,Code1.indexOf('#'))== Code.substring(0,Code.indexOf('#'))) ){
			   HasSelected = true;
			   window.alert('�Ѿ�������ѡ�'+Text.substring(2,Text.length));
			   break;
			}
			//3����ߵ����ұߣ��˳�
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
	f.Duty.options[0]=new Option("----ѡ��ְ��----","");
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

