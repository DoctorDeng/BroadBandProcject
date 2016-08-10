/**
 * 用于添加资费的表单验证
 */
function checkTariff(){
	var tariffName = document.getElementById("tariffName").value;
	var nameMsg = document.getElementById("nameMsg");
	if(tariffName==""){
		nameMsg.innerHTML =  "资费名称不能为空！";
		return false;
	}
	if(tariffName.length > 6){
		nameMsg.innerHTML =  "资费长度应小于6";
		return false;
	} 
	nameMsg.innerHTML =  "";
	
	var timeLong = document.getElementById("timeLong").value;
	var timeMsg = document.getElementById("timeMsg");
	if(adminAccount==""){
		timeMsg.innerHTML = "基本时长不能为空!";
		return false;
	}
	if(timeLong >720 | timeLong < 0){
		timeMsg.innerHTML =  "基本时长格式不满足，请重新输入！";
		return false;
	}
	timeMsg.innerHTML = "";
	
	var tariff = document.getElementById("tariff").value;
	var tariffMsg = document.getElementById("tariffMsg");
	if(tariff==""){
		tariffMsg.innerHTML = "基本费用不能为空";
		return false;
	}
	var regTariff = /^\d+(\.\d+)?$/;
	if(regTariff.test(tariff)==false){
		tariffMsg.innerHTML =  "基本费用格式不满足，请重新输入！";
		return false;
	}
	tariffMsg.innerHTML = "";
	
	var timeTariff = document.getElementById("timeTariff").value;
	var timeTariffMsg = document.getElementById("timeTariffMsg");
	if(timeTariff==""){
		timeTariffMsg.innerHTML = "单位费用不能为空";
		return false;
	}
	var regTariffTime = /^\d+(\.\d+)?$/;
	if(regTariffTime.test(tariff)==false){
		timeTariffMsg.innerHTML =  "单位费用格式不满足，请重新输入！";
		return false;
	}
	timeTariffMsg.innerHTML = "";
	
	var tariffExplain    = document.getElementById("tariffExplain").value;
	var tariffExplainMsg = document.getElementById("tariffExplainMsg");
	var regTariffExplain = /^[A-Za-z0-9_\u4e00-\u9fa5]{0,100}$/;
	if(regTariffExplain.test(tariffExplain)==false){
		tariffExplainMsg.innerHTML =  "资费说明格式不满足，请重新输入！";
		return false;
	}
	tariffExplainMsg.innerHTML = "";
	
	return true;
}