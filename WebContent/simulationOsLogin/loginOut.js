function loginOut(){
	$.post("/lanqiao/OsLoginAction?operation=loginOut", {
	}, function(data) {
		layer.open({
			type : 0,
			area : [ '400px', '150px' ],
			skin : 'layui-layer-molv',
			content : '<p></p><h2>'+ data+'</h2><p></p>'
		});
	});
}
function showLoginTime() {
	$.post("/lanqiao/OsLoginAction?operation=showLoginTime", {
	}, function(data) {
		layer.open({
			type : 0,
			area : [ '400px', '150px' ],
			skin : 'layui-layer-molv',
			content : '<p></p><h2>'+ data+'</h2><p></p>'
		});
	});
}
function showConsume() {
	$.post("/lanqiao/OsLoginAction?operation=showConsume", {
	}, function(data) {
		layer.open({
			type : 0,
			area : [ '400px', '150px' ],
			skin : 'layui-layer-molv',
			content : '<p></p><h2>'+ data+'</h2><p></p>'
		});
	});
}
function reLogin() {
	window.location.href = "login.jsp";
}