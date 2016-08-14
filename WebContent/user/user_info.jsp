<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息修改</title>
<link type="text/css" rel="stylesheet" media="all"
	href="<%=request.getContextPath() %>/styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="<%=request.getContextPath() %>/styles/global_color.css" />
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/user_info.js"></script>
	<script type="text/javascript">
      $(function () {
        $('[data-toggle="popover"]').popover();
      })
      function test () {
        $("#updateSuccess").slideUp('fast');
      }
       function testA () {
        $("#updateSuccess").slideDown('fast');
      }
    </script>
</head>
<body>
	<%@include file="../template/head.jsp"%>
	<!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
	
	 	<div class="alert alert-danger" id="updateError" style="display:none; position: absolute;left: 350px;top: 180px;">
        	<strong>警告！</strong>修改信息发生错误
      	</div>
      	<div class="alert alert-success" id="updateSuccess" style="display:none; position: absolute;left: 350px;top: 180px;">
        	<strong>提示！</strong>保存成功!!!
      	</div>
      	<div class="alert alert-info" id="updating" style="display:none; position: absolute;left: 350px;top: 180px;">
        	<strong>提示！</strong>正在保存.....
      	</div>
      	
		<div id="save_result_info" class="save_success">正在保存！</div>
		<!--保存失败，数据并发错误！-->
		<form action="${pageContext.request.contextPath}/AdminInforAction"
			method="post" class="main_form" id="infor">
			<div class="text_info clearfix">
				<span>管理员账号：</span>
			</div>
			<div class="input_info">
				<input type="text" readonly="readonly" class="readonly"
					value="${sessionScope.admin.adminAccount}" />
			</div>

			<div class="text_info clearfix">
				<span>权限：</span>
			</div>

			<div class="input_info">
				<!--  <input type="text" readonly="readonly" class="readonly width400" 
                    value='' /> -->
				<p style="font-size: 15px; color: blue;">
					<c:forEach items="${sessionScope.admin.powers}" var="power">
						<c:out value="${power.powerName}" />
					</c:forEach>
				<p>
			</div>
			<div class="text_info clearfix">
				<span>姓名：</span>
			</div>
			<div class="input_info">
				<input type="text" value="${sessionScope.admin.adminName}"
					name="adminName" id="adminName" /> <span class="required">*</span>
				<div class="validate_msg_long" id="nameMsg" style="color: red">长度2-6以内的汉字或20以内字母的组合</div>
			</div>
			<div class="text_info clearfix">
				<span>电话：</span>
			</div>
			<div class="input_info">
				<input type="text" class="width200"
					value="${sessionScope.admin.phone}" name="phone" id="phone" />
				<div class="validate_msg_medium" id="phoneMsg" style="color: red">电话号码格式：手机或固话</div>
			</div>
			<div class="text_info clearfix">
				<span>Email：</span>
			</div>
			<div class="input_info">
				<input type="text" class="width200"
					value="${sessionScope.admin.email}" name="email" id="email" />
				<div class="validate_msg_medium" id="emailMsg" style="color: red">20长度以内，符合
					email 格式</div>
			</div>
			<div class="text_info clearfix">
				<span>创建时间：</span>
			</div>
			<div class="input_info">
				<input type="text" readonly="readonly" class="readonly"
					value="${sessionScope.admin.createTime}" />
			</div>
			<div class="button_info clearfix">
				<input type="button" value="保存" class="btn_save" onclick="check();" />
				<input type="button" value="取消" class="btn_save" onclick="reset()" />
			</div>
		</form>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<button class="btn btn-success" onclick="test()">测试关闭警告</button>
      <button class="btn btn-success" onclick="testA()">测试开启警告</button>
	</div>
</body>
</html>