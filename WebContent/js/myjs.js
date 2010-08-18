
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

function showHideD(sectionArray,path)
{
	if (sectionArray[0])
		{
		for (var i = 1; i < 2; i++) {
			if (sectionArray[i+1].style.display == "") {
				sectionArray[i+1].style.display = "none";
				sectionArray[i].src=path+"/images/BttnPack.gif";
			}
			else {
				sectionArray[i+1].style.display = "";
				sectionArray[i].src =path+"/images/BttnCllps.gif";
			}
		}
	}
}
