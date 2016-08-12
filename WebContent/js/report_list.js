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
/**
 * 让模块对应的菜单样式为选中
 * @returns
 */
$(function(){
	$("#reportMenu").attr("class","report_on");
});