function search() {
	var idNumber = $("#idNumber").val();
	var loginAccount = $("#loginAccount").val();
	var customerName = $("#customerName").val();
	var year = $("#selYears").find("option:selected").text();
	var month = $("#selMonths").find("option:selected").text();
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

function show() {
	$("#datalist")
			.hide(
					"slow",
					function() {
						window.location.href = "../BillAction?operation=showBill";
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
	/*   var opObj = new Option("全部", "全部");
	  monthObj.options[0] = opObj; */
	for (var i = 0; i < 12; i++) {
		if (i < 9) {
			var opObj = new Option("0" + (i + 1), i);
		} else {
			var opObj = new Option(i + 1, i);
		}
		monthObj.options[i] = opObj;
	}
}
$(document).ready(function() {
	initialYearAndMonth();
});