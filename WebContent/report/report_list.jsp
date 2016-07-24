<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <c:set var="admin" value="${not empty sessionScope.admin}" />
  		<c:if test="${not admin}">
  			<script type="text/javascript">
  				window.location.href="/lanqiao/login.jsp";
  			</script>
  		</c:if>
        <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==7}">
                	<c:set var="hasPower">true</c:set>
  				</c:when>
  			</c:choose>
  		</c:forEach>
  		<!-- 当用户没有此页面的权限时，跳转到权限提示页面 -->
  		<c:if test="${hasPower==false}">
  		<script type="text/javascript">
  				window.location.href="/lanqiao/nopowr.jsp";
  			</script>
  		</c:if>
        <link type="text/css" rel="stylesheet" media="all" href="/lanqiao/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/lanqiao/styles/global_color.css" /> 
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
            <img src="/lanqiao/images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
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
        	        <li><a href="/lanqiao/StatementAction?operation=default" class="tab_on" title="每位客户每月的累计时长">客户使用时长</a></li>
                    <li><a href="/lanqiao/StatementAction?operation=orderByDesc" class="tab_out" title="每台服务器上累计时长最高的前三名客户">时长排行榜</a></li>
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
                            <th class="width150">累积时长</th>
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
  							<td>没有信息</td>
  						</tr>
  					</c:if>
  					
  						<c:forEach items="${requestScope.statementForm}" var="statement" >
  							<tr>
  								<td><c:out value="${statement.bussinessId}"/></td>
  								<td><c:out value="${statement.loginAccount}"/></td>
  								<td><c:out value="${statement.customerName}"/></td>
  								<td><c:out value="${statement.idNumber}"/></td>
  								<td><c:out value="${statement.phone}"/></td>
  								<td><c:out value="${statement.timeLong}"/></td>
  							<tr>
  						</c:forEach>     
                    </table>
                    <!-- <table id="datalist2" style="display:none;">
                        <tr>                            
                            <th class="width300">Unix 服务器IP</th>
                            <th>包月</th>
                            <th>套餐</th>
                            <th>计时</th>
                        </tr>                      
                        <tr>
                            <td>192.168.0.20</td>
                            <td>345</td>
                            <td>21</td>
                            <td>34</td>
                        </tr>
                        <tr>
                            <td>192.168.0.23</td>
                            <td>32</td>
                            <td>221</td>
                            <td>314</td>
                        </tr>   -->                      
                    </table> -->
                </div>
                <!--分页-->
                <div id="pages">
                    <a href="/lanqiao/StatementAction?operation=default&currentPage=${requestScope.page.indexPage}">首页</a>
        	        <a href="/lanqiao/StatementAction?operation=default&currentPage=${requestScope.page.upPage}">上一页</a>
                    <c:forEach var="i" begin="${requestScope.page.indexPage}" end="${requestScope.page.endPage}">
                    	<c:if test="${i == requestScope.page.currentPage}">
                    		<a href="/lanqiao/StatementAction?operation=default&currentPage=${i}" class="current_page" >${i}</a>
                    	</c:if>
                    	<c:if test="${i != requestScope.page.currentPage}">
                    		<a href="/lanqiao/StatementAction?operation=default&currentPage=${i}">${i}</a>
                    	</c:if>
                    </c:forEach>
                    <a href="/lanqiao/StatementAction?operation=default&currentPage=${requestScope.page.nextPage}">下一页</a>
                    <a href="/lanqiao/StatementAction?operation=default&currentPage=${requestScope.page.endPage}">末页</a>
                </div>
            </div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
          
        </div>
    </body>
</html>