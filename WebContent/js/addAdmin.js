/**
 * 用于添加用户的表单验证
 */
function checkAdmin(){
	var admin = document.getElementById("adminName").value;
	var adminError = document.getElementById("adminError");
	if(admin=="" | admin.length >6){
		adminError.innerHTML =  "姓名不能为空或长度不能大于6";
		return false;
	} 
	adminError.innerHTML =  "";
	
	var adminAccount = document.getElementById("adminAccount").value;
	var accountError = document.getElementById("accountError");
	if(adminAccount=="" | adminAccount.length > 10){
		accountError.innerHTML = "账号不能为空或长度不能大于10";
		return false;
	}
	accountError.innerHTML = "";
	
	var password = document.getElementById("pwd").value;
	var pwdError = document.getElementById("pwdError");
	if(password=="" | password.length > 10){
		pwdError.innerHTML = "密码不能为空或长度不能大于10";
		return false;
	}
	pwdError.innerHTML = "";
	var rePwd = document.getElementById("rePwd").value;
	var rePwdError = document.getElementById("rePwdError");
	if(password != rePwd){
		rePwdError.innerHTML = "两次密码必须相同";
		return false;
	}
	rePwdError.innerHTML = "";
	var idNumber = document.getElementById("idNumber").value;
	var idNumberError = document.getElementById("idnumberError");
	if(idNumber=="" | idNumber.length > 18){
		idNumberError.innerHTML = "身份证不能为空或长度不能大于18";
		return false;
	}
	idNumberError.innerHTML = "";
	var a = 0;
	var power = document.getElementsByName("power");
	for (var i = 0; i < power.length; i++) {
		if (power[i].checked) {
			a += 1;
		}
	}
	if (a < 1 ) {
		document.getElementById("powerError").innerHTML =  "至少选择一个";
		return false;
	}
	document.getElementById("powerError").innerHTML =  "";
	return true;
}
function showResult() {
	 if(checkAdmin()) {
       showResultDiv(true);
       window.setTimeout("showResultDiv(false)", 1000);
	 } else {
		 layer.open({
				type : 0,
				area : [ '400px', '150px' ],
				skin : 'layui-layer-molv',
				content : '<p></p><h2 style="color:red">对不起,您输入的信息不合要求</h2><p></p>'
			});
	 }
}
function submitForm() {
	document.getElementById("save").submit();
}
function showResultDiv(flag) {
   var divResult = document.getElementById("save_result_info");
   if (flag)
       divResult.style.display = "block";
   else {
       divResult.style.display = "none";
  		submitForm(); 
   }
}