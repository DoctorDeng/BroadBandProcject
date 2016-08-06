/**
 * 用于添加用户的表单验证
 */
function checkAdmin(){
	var admin = document.getElementById("adminName").value();
	var adminError = document.getElementById("adminError");
	if(admin==""){
		adminError.innerHTML =  "姓名不能为空！";
		return false;
	}
	adminError.innerHTML =  "";
	
	var adminAccount = document.getElementById("adminAccount").value;
	var accountError = document.getElementById("accountError");
	if(adminAccount==""){
		accountError.innerHTML = "账号不能为空";
		return false;
	}
	accountError.innerHTML = "";
	
	var password = document.getElementById("pwd").value;
	var pwdError = document.getElementById("pwdError");
	if(password==""){
		pwdError.innerHTML = "密码不能为空";
		return false;
	}
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
				content : '<p></p><h2 style="color:red">请填写完整的信息</h2><p></p>'
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