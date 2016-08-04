<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/powerPage.jsp">
	<jsp:param value="7" name="pagePower"/>
</jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>报表</title>
        <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
        <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
        
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" /> 
        <script language="javascript" type="text/javascript">
            function changeTab(e,ulObj) {                
                var obj = e.srcElement || e.target;
                if (obj.nodeName == "A") {
                    var links = ulObj.getElementsByTagName("a");
                    for (var i = 0; i < links.length; i++) {
                        if (links[i].innerHTML == obj.innerHTML) {
                            links[i].className = "tab_on";
                        }
                        else {
                            links[i].className = "tab_out";
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" class="left"/>
            <a href="<%=request.getContextPath() %>/loginOutAction">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <%@include file= "../template/power.jsp" %>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->        
        <div id="report_main">
        	<div class="tabs">
    	        <ul onclick="changeTab(event,this);">
        	        <li><a href="<%=request.getContextPath()%>/StatementAction?operation=default" class="tab_out" title="每位客户每月的累计时长">客户使用时长</a></li>
                    <li><a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc" class="tab_out" title="每台服务器上累计时长最高的前三名客户">时长排行榜</a></li>
                </ul>
            </div>            
            <div class="report_box">
                <!--数据区域：用表格展示数据-->
                <div id="report_data">
                    <table id="datalist">
                        <tr>                            
                            <th>账号 ID</th>
                            <th>账务帐号</th>
                            <th>客户名称</th>
                            <th class="width200">身份证号码</th>
                            <th>电话</th>
                            <th>月份<th>
                            <th>累积时长</th>
                        </tr>     
                   <c:set var="statementForm" value="${not empty requestScope.statementForm}" />
  					<c:if test="${not statementForm}">
  						<tr>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  						</tr>
  					</c:if>
  					
  						<c:forEach items="${requestScope.statementForm}" var="statement" >
  							<tr>
  								<td><c:out value="${statement.customerId}"/></td>
  								<td><c:out value="${statement.customerAccount}"/></td>
  								<td><c:out value="${statement.customerName}"/></td>
  								<td><c:out value="${statement.idNumber}"/></td>
  								<td><c:out value="${statement.phone}"/></td>
  								<td><c:out value="${statement.months}" /></td>
  								<td><c:out value="${statement.timeLong}"/></td>
  							<tr>
  						</c:forEach>     
                    </table>
                </div>
                <!--分页-->
                <c:choose>
                	<c:when test="${operation == 'default'}">
                		 
                <div id="pages">
                    <a href="<%=request.getContextPath()%>/StatementAction?operation=default&currentPage=${requestScope.page.indexPage}">首页</a>
        	        <a href="<%=request.getContextPath()%>/StatementAction?operation=default&currentPage=${requestScope.page.upPage}">上一页</a>
                    <c:forEach var="i" begin="${requestScope.page.indexPage}" end="${requestScope.page.endPage}">
                    	<c:if test="${i == requestScope.page.currentPage}">
                    		<a href="<%=request.getContextPath()%>/StatementAction?operation=default&currentPage=${i}" class="current_page" >${i}</a>
                    	</c:if>
                    	<c:if test="${i != requestScope.page.currentPage}">
                    		<a href="<%=request.getContextPath()%>/StatementAction?operation=default&currentPage=${i}">${i}</a>
                    	</c:if>
                    </c:forEach>
                    <a href="<%=request.getContextPath()%>/StatementAction?operation=default&currentPage=${requestScope.page.nextPage}">下一页</a>
                    <a href="<%=request.getContextPath()%>/StatementAction?operation=default&currentPage=${requestScope.page.endPage}">末页</a>
                </div>
                	</c:when>
                	<c:when test="${operation == 'orderByDesc'}">
                		 
                <div id="pages">
                    <a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc&currentPage=${requestScope.page.indexPage}">首页</a>
        	        <a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc&currentPage=${requestScope.page.upPage}">上一页</a>
                    <c:forEach var="i" begin="${requestScope.page.indexPage}" end="${requestScope.page.endPage}">
                    	<c:if test="${i == requestScope.page.currentPage}">
                    		<a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc&currentPage=${i}" class="current_page" >${i}</a>
                    	</c:if>
                    	<c:if test="${i != requestScope.page.currentPage}">
                    		<a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc&currentPage=${i}">${i}</a>
                    	</c:if>
                    </c:forEach>
                    <a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc&currentPage=${requestScope.page.nextPage}">下一页</a>
                    <a href="<%=request.getContextPath()%>/StatementAction?operation=orderByDesc&currentPage=${requestScope.page.endPage}">末页</a>
                </div>
                	</c:when>
                </c:choose>
            </div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
          
        </div>
    </body>
</html>