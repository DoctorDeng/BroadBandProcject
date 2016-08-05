function changeTab(e,ulObj) {                
    var obj = e.srcElement || e.target;
    if (obj.nodeName == "A") {
         var links = ulObj.getElementsByTagName("a");
         for (var i = 0; i < links.length; i++) {
            if (links[i].innerHTML == obj.innerHTML) {
                links[i].className = "tab_on";
            }
            else {
                links[i].className = "tab_out";
            }
         }
    }
}
function defaultTab() {
    $("#defaultTab").attr("class","tab_on");
    $("#orderTab").attr("class","tab_out");
}
function orderByTab() {
    $("#defaultTab").attr("class","tab_out");
    $("#orderTab").attr("class","tab_on");
}