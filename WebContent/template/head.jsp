<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Logo区域 -->
<div id="header">
	<img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" class="left"/>
	<a href="<%=request.getContextPath() %>/loginOutAction">[退出]</a>            
</div>
<!--  导航区域 -->
<div id="navi">                        
	<ul id="menu">
		<%@include file= "../template/power.jsp" %>
	</ul>            
</div>