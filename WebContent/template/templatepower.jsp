<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 判断session中是否有admin，即判断用户是否登录过 -->
	<c:set var="admin" value="${not empty sessionScope.admin}" />
  	<c:if test="${not admin}">
  		<%
		//跳转到登陆页面
  		response.sendRedirect("login.jsp");
  		%>
  	</c:if>
  	
  	<!-- 以下是显示菜单的模板代码 -->
  	<div id="index_navi"> 
            <ul id="menu">
                <li><a href="index.jsp" class="index_on"></a></li>
                	<!-- 获取管理员拥有的权限 -->
            <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  				<c:set var="power">${adminPower.power}</c:set>
  				<!-- 通过管理员有的权限来显示菜单 -->
  				<!-- 当管理员的权限中有2权限时显示对应权限菜单 -->
  				<c:choose>
  					<c:when test="${power=2}">
                		 <li><a href="admin/admin_list.jsp" class="admin_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power=3}">
                		<li><a href="fee/fee_list.jsp" class="fee_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power=4}">
                		 <li><a href="account/account_list.jsp" class="account_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power=5}">
                		<li><a href="service/service_list.jsp" class="service_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power=6}">
                		 <li><a href="bill/bill_list.jsp" class="bill_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power=7}">
                		<li><a href="report/report_list.jsp" class="report_off"></a></li>
  					</c:when>
  				</c:choose>
  			</c:forEach>
                <!-- <li><a href="admin/admin_list.jsp" class="admin_off"></a></li>
                <li><a href="fee/fee_list.jsp" class="fee_off"></a></li>
                <li><a href="account/account_list.jsp" class="account_off"></a></li>
                <li><a href="service/service_list.jsp" class="service_off"></a></li>
                <li><a href="bill/bill_list.jsp" class="bill_off"></a></li>
                <li><a href="report/report_list.jsp" class="report_off"></a></li> -->
                <li><a href="user/user_info.jsp" class="information_off"></a></li>
                <li><a href="user/user_modi_pwd.jsp" class="password_off"></a></li>
            </ul>
        </div>
</body>
</html>