/**
 * 用于添加账务账号的表单验证
 */
function checkAccount(){
	var name = document.getElementById("name").value;
	var nameMsg = document.getElementById("nameMsg");
	if(name==""){
		nameMsg.innerHTML =  "姓名不能为空！";
		return false;
	}
	var regName = /^[A-Za-z\u4e00-\u9fa5]{1,20}$/;
	if(regName.test(name)==false){
		nameMsg.innerHTML =  "姓名格式不正确，请重新输入！";
		return false;
	} 
	nameMsg.innerHTML =  "";
	
	var idNumber = document.getElementById("idNumber").value;
	var idNumberMsg = document.getElementById("idNumberMsg");
	if(idNumber==""){
		idNumberMsg.innerHTML = "身份证不能为空!";
		return false;
	}
	var regIdNumber = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	if(regIdNumber.test(idNumber)==false){
		idNumberMsg.innerHTML =  "身份证格式不满足，请重新输入！";
		return false;
	}
	idNumberMsg.innerHTML = "";
	
	var loginAccount = document.getElementById("loginAccount").value;
	var loginAccountfMsg = document.getElementById("loginAccountMsg");
	if(loginAccount==""){
		loginAccountMsg.innerHTML = "登录账号不能为空";
		return false;
	}
	var regloginAccount = /^[A-Za-z0-9_]{1,10}$/;
	if(regloginAccount.test(loginAccount)==false){
		loginAccountMsg.innerHTML =  "登录账号格式不满足，请重新输入！";
		return false;
	}
	loginAccountMsg.innerHTML = "";
	
	var password = document.getElementById("password").value;
	var passwordMsg = document.getElementById("passwordMsg");
	if(password==""){
		passwordMsg.innerHTML = "密码不能为空";
		return false;
	}
	var regPassword = /^[A-Za-z0-9_]{1,10}$/;
	if(regPassword.test(password)==false){
		passwordMsg.innerHTML =  "密码格式不满足，请重新输入！";
		return false;
	}
	passwordMsg.innerHTML = "";
	
	var rePassword = document.getElementById("rePassword").value;
	var rePasswordMsg = document.getElementById("rePasswordMsg");
	if(rePassword==""){
		rePasswordMsg.innerHTML = "密码不能为空";
		return false;
	}
	var regRePassword = /^[A-Za-z0-9_\u4e00-\u9fa5]{0,100}$/;
	if(regRePassword.test(rePassword)==false){
		rePasswordMsg.innerHTML =  "密码格式不满足，请重新输入！";
		return false;
	}
	if(rePassword!=Password){
		rePasswordMsg.innerHTML = "两次密码必须相同";
		return false;
	}
	rePasswordMsg.innerHTML = "";
	
	var phone = document.getElementById("phone").value;
	var phoneMsg = document.getElementById("phoneMsg");
	if(phone==""){
		phoneMsg.innerHTML = "电话不能为空";
		return false;
	}
	var regPhone = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
	if(regPhone.test(phone)==false){
		phoneMsg.innerHTML =  "电话格式不满足，请重新输入！";
		return false;
	}
	phoneMsg.innerHTML = "";
	
/*	var refererID = document.getElementById("refererID").value;
	var refererIDMsg = document.getElementById("refererIDMsg");
	var regRefererID = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	if(regRefererID.test(refererID)==false){
		refererIDMsg.innerHTML =  "推荐人身份证格式不满足，请重新输入！";
		return false;
	}
	refererIDMsg.innerHTML = "";
	
	var email = document.getElementById("email").value;
	var emailMsg = document.getElementById("emailMsg");
	var regEmail = /^\w+@\w+.[A-Za-z]{2,3}(.[A-Za-z]{2,3})?$/;
	if(regEmail.test(email)==false){
		emailMsg.innerHTML =  "email格式不满足，请重新输入！";
		return false;
	}
	emailMsg.innerHTML = "";
	
	var postal = document.getElementById("postal").value;
	var postalMsg = document.getElementById("postalMsg");
	var regPostal = /^[1-9]\d{5}$/;
	if(regPostal.test(postal)==false){
		postalMsg.innerHTML =  "邮编格式不满足，请重新输入！";
		return false;
	}
	postalMsg.innerHTML = "";
	
	var qq = document.getElementById("qq").value;
	var qqMsg = document.getElementById("qqMsg");
	var regQQ = /^[1-9]{5,13}$/;
	if(regQQ.test(qq)==false){
		qqMsg.innerHTML =  "QQ格式不满足，请重新输入！";
		return false;
	}
	qqMsg.innerHTML = "";*/
	
	return true;
}