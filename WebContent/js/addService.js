/**
 * 用于添加账务账号的表单验证
 */
function checkService(){
	var serverIp = document.getElementById("serverIp").value;
	var serverIpMsg = document.getElementById("serverIpMsg");
	if(serverIp==""){
		serverIpMsg.innerHTML =  "服务器 IP不能为空！";
		return false;
	}
	var regServerIp = /^(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\.{4}$/;
	if(regServerIp.test(serverIp)==false){
		serverIpMsg.innerHTML =  "服务器 IP格式不正确，请重新输入！";
		return false;
	} 
	serverIpMsg.innerHTML =  "";
	
	var osAccount = document.getElementById("osAccount").value;
	var osAccountMsg = document.getElementById("osAccountMsg");
	if(osAccount==""){
		osAccountMsg.innerHTML = "OS账号不能为空!";
		return false;
	}
	var regOsAccount = /^[A-Za-z0-9_]{1,8}$/;
	if(regOsAccount.test(osAccount)==false){
		osAccountMsg.innerHTML =  "OS账号格式不满足，请重新输入！";
		return false;
	}
	osAccountMsg.innerHTML = "";
	
	var osPassword = document.getElementById("osPassword").value;
	var osPasswordMsg = document.getElementById("osPasswordMsg");
	if(osPassword==""){
		osPasswordMsg.innerHTML = "密码不能为空";
		return false;
	}
	var regOsPassword = /^[A-Za-z0-9_]{1,10}$/;
	if(regOsPassword.test(osPassword)==false){
		osPasswordMsg.innerHTML =  "密码格式不满足，请重新输入！";
		return false;
	}
	osPasswordMsg.innerHTML = "";
	
	var rosPassword = document.getElementById("rosPassword").value;
	var rosPasswordMsg = document.getElementById("rosPasswordMsg");
	if(rosPassword==""){
		rosPasswordMsg.innerHTML = "密码不能为空";
		return false;
	}
	var regRosPassword = /^[A-Za-z0-9_\u4e00-\u9fa5]{0,100}$/;
	if(regRosPassword.test(rosPassword)==false){
		rosPasswordMsg.innerHTML = "密码格式不满足，请重新输入！";
		return false;
	}
	if(rosPassword!=osPassword){
		rosPasswordMsg.innerHTML = "两次密码必须相同";
		return false;
	}
	rosPasswordMsg.innerHTML = "";
	
	return true;
}