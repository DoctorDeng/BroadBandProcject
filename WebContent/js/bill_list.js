function search() {
	var idNumber = $("#idNumber").val();
	var loginAccount = $("#loginAccount").val();
	var customerName = $("#customerName").val();
	var year = $("#selYears").find("option:selected").val();
	var month = $("#selMonths").find("option:selected").val();
	var months = year + month;
	
	$("#pages").hide();
	$("#datalist").hide("fast");

	$.post("/lanqiao/BillTest", {
		'idNumber' : idNumber,
		'loginAccount' : loginAccount,
		'customerName' : customerName,
		'months' : months
	}, function(data) {
		var $menuId = $("#menuId");
		$("#datalist").empty();
		$("#datalist").append($menuId);
		$("#datalist").append(data);
		$("#datalist").show("slow", function() {
			$("#point").show();
		});
	});
}

function show(temp) {
	$("#datalist")
			.hide(
					"slow",
					function() {
						window.location.href = temp+"/BillAction?operation=showBill";
					});
}
//写入下拉框中的年份和月份
function initialYearAndMonth() {
	//写入最近3年
	var yearObj = document.getElementById("selYears");
	var year = (new Date()).getFullYear();
	for (var i = 0; i <= 2; i++) {
		var opObj = new Option(year - i, year - i);
		yearObj.options[i] = opObj;
	}
	//写入 12 月
	var monthObj = document.getElementById("selMonths");
	var opObj = new Option("全部", "");
	monthObj.options[0] = opObj;
	for (var i = 1; i < 13; i++) {
		if (i < 10) {
			var opObj = new Option(i, "0"+(i));
		} else {
			var opObj = new Option(i, i);
		}
		monthObj.options[i] = opObj;
	}
}
$(document).ready(function() {
	initialYearAndMonth();
});
/**
 * 让模块对应的菜单样式为选中
 * @returns
 */
$(function(){
	$("#billMenu").attr("class","bill_on");
});