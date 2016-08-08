function tipsName() {
	var fname = document.getElementById("adminAccount").value;
	var tipA = document.getElementById("iname");
	if (fname == "") {
		tipA.innerHTML = "用户名不能为空!";
		return false;
	}
	tipA.innerHTML = "";
	var fpswd = document.getElementById("password").value;
	var tipB = document.getElementById("ipswd");
	if (fpswd == "") {
		tipB.innerHTML = "密码不能为空!";
		return false;
	}
	tipB.innerHTML = "";
	return true;
}
function osLogin() {
	if (tipsName()) {
		document.getElementById("loginForm").submit();
	} else {
		layer.open({
			type : 0,
			area : [ '400px', '150px' ],
			skin : 'layui-layer-molv',
			content : '<p></p><h2 style="color:red">对不起,您输入的信息不合要求</h2><p></p>'
		});
	}
}