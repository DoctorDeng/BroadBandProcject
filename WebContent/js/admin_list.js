//显示角色详细信息
function showDetail(flag, a) {
	var detailDiv = a.parentNode.getElementsByTagName("div")[0];
	if (flag) {
		detailDiv.style.display = "block";
	} else
		detailDiv.style.display = "none";
}
//查询管理员信息  
function SerchAdminInfor() {
	var adminId = document.getElementById("serchAdmin").value;
	window.location.href = "<%=request.getContextPath()%>/ShowAdminAction?operation=search&adminId="
			+ adminId;
}

function resetPwd() {
	var a = 0;
	var choose = document.getElementsByName("choose");
	for (var i = 0; i < choose.length; i++) {
		if (choose[i].checked) {
			a += 1;
		}
	}
	if (a > 0) {
		document.getElementById("resetForm").submit();
	} else {
		layer.open({
			type : 0,
			area : [ '400px', '150px' ],
			skin : 'layui-layer-molv',
			content : '<p></p><h2>请选择至少一个管理员</h2><p></p>'
		});
	}
}

function selectAdmins(inputObj) {
	var inputArray = document.getElementById("datalist").getElementsByTagName(
			"input");
	for (var i = 1; i < inputArray.length; i++) {
		if (inputArray[i].type == "checkbox") {
			inputArray[i].checked = inputObj.checked;
		}
	}
}