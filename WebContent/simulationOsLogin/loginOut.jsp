<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模拟登出</title>
<link rel="stylesheet" href="login.css">
<script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
<script src="<%=request.getContextPath()%>/js/layer/layer/layer.js"></script>
<script src="loginOut.js"></script>
</head>
<body>
	<div id="login">
		<h2><span class="fontawesome-lock"></span>模拟登出</h2>
		<form action="javascript:void(0);" method="POST">
			<fieldset>
				<p><input type="button" value="登出,并显示本次登陆费用" onclick="loginOut()"></p>
				<p><input type="button" value="查看登入时间"  onclick="showLoginTime()"></p>
				<p><input type="button" value="查看这个月的消费" onclick="showConsume()"></p>
				<p><input type="button" value="重新登陆" onclick="reLogin()"></p>
			</fieldset>
		</form>
	</div>
</body>
</html>