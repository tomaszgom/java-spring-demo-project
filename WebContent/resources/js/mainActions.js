function showStats() {
   document.getElementById('statsTable').style.display = "table";
}

/* Show Navigation Panel */
function showNavi() {
    document.getElementById("naviPanelId").style.width = "180px";
    document.getElementById("mainContentId").style.marginLeft = "180px";
    /* document.body.style.backgroundColor = "rgba(0,0,0,0.4)"; */
}

/* Hide Navigation Panel */
function hideNavi() {
    document.getElementById("naviPanelId").style.width = "0";
    document.getElementById("mainContentId").style.marginLeft = "0";
    /*  document.body.style.backgroundColor = "white"; */
} 

function showPleaseWait() {
    document.getElementById("pleaseWaitId").style.width = "650px";
    /* document.body.style.backgroundColor = "rgba(0,0,0,0.4)"; */
}

function checkSelectedClient() {	
	
	var radios = document.getElementsByName('clientId');
	var selectedID = -1;
	
	for (var i = 0; i < radios.length; i++){
		if (radios[i].checked){			
			selectedID = radios[i].value
			break;
		}
	}
	
		if(selectedID==-1){
			alert("Please select client, before adding order details.");
			return false;	
		}else{
			//alert("Selected client: "+selectedID)
			showPleaseWait();
			return true;	
		}						
	}

function purchaseOrderAddSearchClient(){
    document.purchaseOrder.action = "purchaseOrderAddSearchClient";
    document.purchaseOrder.submit();
    return true;
}

function confirmationBox(){
    var retVal = confirm("Do you want to delete the item?");
    if( retVal == true ){
       return true;
    }else{
       return false;
    }
 }

