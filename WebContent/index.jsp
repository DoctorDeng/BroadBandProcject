<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 		<c:set var="admin" value="${not empty sessionScope.admin}" />
  		<c:if test="${not admin}">
  			<script type="text/javascript">
  				window.location.href="<%=request.getContextPath()%>/login.jsp";
  			</script>
  		</c:if>
	<title>首页</title>
 	<link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
    <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
   		<script type="text/javascript">
   		/**
   		 * 让模块对应的菜单样式为选中
   		 * @returns
   		 */
   		$(function(){
   			$("#indexMenu").attr("class","index_on");
   		});
   		</script>
    </head>
    <body class="index">
        <!--导航区域开始-->
        <div id="index_navi">
            <ul id="menu">
           	<%@include file= "template/power.jsp" %>
            </ul>
        </div>
    </body>
</html>