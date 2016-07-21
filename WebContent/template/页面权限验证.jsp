<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="admin" value="${not empty sessionScope.admin" />
  	<c:if test="${not admin}">
  		<%
		//跳转到登陆页面
  		response.sendRedirect("xxx.jsp");
  		%>
  	</c:if>
	<c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==1}">
                	<c:set var="hasPower">true</c:set>
  				</c:when>
  			</c:choose>
  		</c:forEach>
  	<!-- 当用户没有此页面的权限时，跳转到权限提示页面 -->
  	<c:if test="${hasPower==false}">
  		<%
  			response.sendRedirect("xxx.jsp");
  		%>
  	</c:if>
