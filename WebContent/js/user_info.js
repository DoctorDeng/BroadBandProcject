function check() {
	var adminName = document.getElementById("adminName").value;
	var nameMsg = document.getElementById("nameMsg");
	var phone = document.getElementById("phone").value;
	var phoneMsg = document.getElementById("phoneMsg");
	var email = document.getElementById("email").value;
	var emailMsg = document.getElementById("emailMsg");

	if (adminName == "") {
		nameMsg.innerHTML = "姓名不能为空！";
		return false;
	}
	var regName = /^[A-Za-z]{8,20}$/;
	var regNameC = /^[\u4e00-\u9fa5]{2,6}$/;
	if (regName.test(adminName) == false) {
		if (regNameC.test(adminName) == false) {
			nameMsg.innerHTML = "姓名格式不正确！";
			return false;
		}
	}
	nameMsg.innerHTML = "";

	var regPhone = /^1\d{10}$/;
	if (regPhone.test(phone) == false) {
		phoneMsg.innerHTML = "手机格式不正确，请重新输入！";
		return false;
	}
	phoneMsg.innerHTML = "";

	var regEmail = /^\w+@\w+.[A-Za-z]{2,3}(.[A-Za-z]{2,3})?$/;
	if (regEmail.test(email) == false) {
		emailMsg.innerHTML = "邮箱格式不正确，请重新输入！";
		return false;
	}
	emailMsg.innerHTML = "";

	showResult(true);
}
//保存成功的提示信息
function showResult(flag) {
	showResultDiv(true);
	window.setTimeout("showResultDiv(false)", 1000);
}
function showResultDiv(flag) {
	var divResult = document.getElementById("save_result_info");
	if (flag)
		divResult.style.display = "block";
	else {
		divResult.style.display = "none";
		document.getElementById('infor').submit();
	}
}
function updateInfo() {
	$.p
}
function reset() {
	document.getElementById("adminName").value = "${sessionScope.admin.adminName}";
	document.getElementById("phone").value = "${sessionScope.admin.phone}";
	document.getElementById("email").value = "${sessionScope.admin.email}";
}
/**
 * 让模块对应的菜单样式为选中
 * @returns
 */
$(function() {
	$("#informationMenu").attr("class", "information_on");
});
/**
 * 展示提示信息
 * @param promptType  提示的类型
 * @param showType    展现提示信息的类型,隐藏或展示
 * @returns
 */
function showPrompt(promptType,showType){
	switch (promptType) {
	case "success":
		if(showType=="hide") {
			$("#updateSuccess").slideUp('fast');
		} else {
			$("#updateSuccess").slideDown('fast');
		}
		break;
	case "error":
		if(showType=="hide") {
			$("#updateError").slideUp('fast');
		} else {
			$("#updateError").slideDown('fast');
		}
		break;
	case "info":
		if(showType=="hide") {
			$("#updating").slideUp('fast');
		} else {
			$("#updating").slideDown('fast');
		}
		break;
	}
}
