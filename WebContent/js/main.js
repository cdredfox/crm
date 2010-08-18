
function ShowHideLeft(path){//用来缩放或者展开左边栏
		if (top.frmMenu.cols!="0,12,*"){
			top.frmMenu.cols="0,12,*";
			icon_left.src=path+"images/open_left.gif";
		}else{
			top.frmMenu.cols="160,12,*";
			icon_left.src=path+"images/close_left.gif";
		}
	}
function ShowHideTop(path){//用来缩放或者展开顶边栏
		if (top.frmTool.rows!="0,11,*,0,0"){
			top.frmTool.rows="0,11,*,0,0";
			icon_top.src=path+"/images/open_top.gif";
		}else{
			top.frmTool.rows="85,11,*,0,0";
			icon_top.src=path+"/images/close_top.gif";
		}
	}
	
var movx,scrollx,scrolly;
function movstar(a,time){//��ֱ�ƶ��˵�
	movx=setInterval("mov("+a+")",time);
	}
function movover(){
	clearInterval(movx);
	}
function mov(a){//���ʱ�����ƶ��˵�
	scrollx=menu_scroll.document.body.scrollLeft;
	scrolly=menu_scroll.document.body.scrollTop;
	scrolly=scrolly+a;
	menu_scroll.window.scroll(scrollx,scrolly);
	}
function showHideMenu()
{
	menu_scroll=(menu_scroll==new_date)?xinxipage:new_date;
	if(xinxi.style.height=="100%")
	{
		imgCaidan.src="images/menu_up.gif";
		imgXinxi.src="images/info_up.gif";
		menu.style.height="100%";
		xinxi.style.height="0";
		document.getElementById("new_date").style.display="block";
		document.getElementById("xinxipage").style.display="none";
	}else{
		imgCaidan.src="images/menu_down.gif";
		imgXinxi.src="images/info_down.gif";
		menu.style.height="0";
		xinxi.style.height="100%";
		document.getElementById("xinxipage").style.display="block";
		document.getElementById("new_date").style.display="none";
	}
}
/*function wback(){
	if(new_date.history.length==0){window.history.back()}
	else{new_date.history.back()}
}
*/