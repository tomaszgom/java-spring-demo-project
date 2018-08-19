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