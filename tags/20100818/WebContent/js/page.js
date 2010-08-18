//这个是分页标签AJAX功能所用到的JS代码。
//除说明能够修改的值以外。请不要修改其它的值。。。
//如有任何问题。请联系我：183723465 杨飞。

//可修改的参数：tablename 的value值。。请修改成你的<tbody>中的ID名称

var tablename;//表单中<tbody>的ID的名字
var nowPage;//记录当前页数


//这个方法用于下拉列表的取值得到页数，以及第一页和最后一页
function Curpage(pages,pageSize,selectPages)
{
//这里用IF是因为我传进来的pages参数。有两种可能
//第一种为直接传数字进来。第二种是传整个select对象进来
   tablename="pageTable";
    if(isNaN(pages))
    {
    nowPage=pages.value;
    CurrentPages.CurrentPage(pages.value,pageSize,callBack);
	}else
	{
	if(parseInt(pages)<=1)
  {
		selectPages.options[0].selected="selected";
	}
	if(parseInt(pages)>=selectPages.options.length)
  {
		selectPages.options[selectPages.options.length-1].selected="selected";
   }
	nowPage=pages;
	CurrentPages.CurrentPage(pages,pageSize,callBack);
	}
}
//取得下一页
function getNextPage(pageSize,selectPage)
{   
	if(nowPage==null||parseInt(nowPage)>=selectPage.options[selectPage.options.length-1].value)
	{
	nowPage=0;
	}
	nowPage=parseInt(nowPage)+1;
	selectPage.options[nowPage-1].selected="selected";
	Curpage(nowPage,pageSize,selectPage);
}
//取得上一页
function getTopPage(pageSize,selectPage)
{
	if(nowPage==null || parseInt(nowPage)>selectPage.options[selectPage.options.length-1].value)
	{
	nowPage=0;
	}
	nowPage=parseInt(nowPage)-1;
	if(nowPage<=0)
	{
		nowPage=selectPage.options[selectPage.length-1].value;
	}
	selectPage.options[nowPage-1].selected="selected";
	Curpage(nowPage,pageSize,selectPage);
}
//定义转换规则
var getId=function(unit){return unit.id};
var getChinese=function(unit){return unit.chinese};
var getPinying=function(unit){return unit.pinying};
var getStyle=function(unit){return unit.style};
var getCode=function(unit){return unit.code};


//回调方法得到值
function callBack(dateMessage)
{
   DWRUtil.removeAllRows(tablename);
   DWRUtil.addRows(tablename,dateMessage,[getId,getChinese,getPinying,getStyle,getCode]);
}