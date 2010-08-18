//
function document.onmouseover()
{
if ((event.srcElement.type=="button")||(event.srcElement.type=="submit")||(event.srcElement.type=="reset")){
if(event.srcElement.className=="buttons02")
{event.srcElement.className="buttons02-o";}
else{
if(event.srcElement.className=="buttonsShort")
{event.srcElement.className="buttonsShort-o";}
else
{event.srcElement.className="button1-o";}
}}
}
function document.onmouseout(){
if ((event.srcElement.type=="button")||(event.srcElement.type=="submit")||(event.srcElement.type=="reset")){
if(event.srcElement.className=="buttons02-o")
{event.srcElement.className="buttons02";}
else{
 if(event.srcElement.className=="buttonsShort-o")
 {event.srcElement.className="buttonsShort";}
else
{event.srcElement.className="button1";}}
}
}