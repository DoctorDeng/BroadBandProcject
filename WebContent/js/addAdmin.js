/**
 * 用于添加用户的表单验证
 */
function checkAdmin(){
	var admin = document.getElementById(admin).value();
	var adminError = document.getElementById(adminError);
	if(admin==""){
		adminError.innerHTML =  "姓名不能为空！";
		return false;
	}
	adminError.innerHTML =  "";
	
	var adminAccount = document.getElementById(adminAccount).value;
	var accountError = document.getElementById(accountError);
	if(adminAccount==""){
		accountError.innerHTML = "账号不能为空";
		return false;
	}
	accountError.innerHTML = "";
	
	var password = document.getElementById(password).value;
	var pwdError = document.getElementById(pwdError);
	if(password==""){
		pwdError.innerHTML = "密码不能为空";
		return false;
	}
	return true;
}