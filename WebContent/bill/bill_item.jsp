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
  				window.location.href="<%=request.getContextPath()%>/login.jsp";
  			</script>
  		</c:if>
        <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powers}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==6}">
                	<c:set var="hasPower">true</c:set>
  				</c:when>
  			</c:choose>
  		</c:forEach>
  		<!-- 当用户没有此页面的权限时，跳转到权限提示页面 -->
  		<c:if test="${hasPower==false}">
  			<script type="text/javascript">
  				window.location.href="<%=request.getContextPath()%>/nopowr.jsp";
  			</script>
  		</c:if>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" /> 
    </head>
    <body onload="initialYearAndMonth();">
        <!--Logo区域开始-->
        <div id="header">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" class="left"/>
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
        <div id="main">
            <form action="#" method="">
                <!--查询-->
                <div class="search_add">    
                	<div style="width:360px">&nbsp;&nbsp;</div>                        
                    <div style="font-size:20px">用户账单明细</div>                      
                    <input type="button" value="返回" class="btn_add" 
                    onclick="location.href='<%=request.getContextPath()%>/BillAction?operation=showBill';" />
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="width70">账单明细ID</th>
                            <th class="width150">OS 账号</th>
                            <th class="width150">服务器 IP</th>
                            <th class="width70">账务账号ID</th>
                            <th class="width150">时长</th>
                            <th>费用</th>
                            <th class="width150">资费</th>
                            <th class="width50"></th>
                        </tr>
                        
                        <c:set var="billDetailForm" value="${not empty requestScope.billDetailForm}" />
  					<c:if test="${not billDetailForm}">
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
  					
  						<c:forEach items="${requestScope.billDetailForm}" var="billDetail" >
  							<tr>
  								<td><c:out value="${billDetail.customerId}"/></td>
  								<td><c:out value="${billDetail.osAccount}"/></td>
  								<td><c:out value="${billDetail.serverIp}"/></td>
  								<td><c:out value="${billDetail.customerAccount}"/></td>
  								<td><c:out value="${billDetail.timeLong}"/></td>
  								<td><c:out value="${billDetail.cost}"/></td>
  								<td><c:out value="${billDetail.tariffName}"/></td>
  								<td><a href="<%=request.getContextPath()%>/BillAction?operation=showLogin&osId=${billDetail.osId}" title="账单明细">明细</a></td>
  							<tr>
  						</c:forEach>
                        <!-- <tr>
                            <td>1</td>
                            <td>openlab1</td>
                            <td>192.168.100.100</td>
                            <td>101</td>
                            <td>1小时3分15秒</td>
                            <td>43.45</td>
                            <td>包 20 小时</td>                          
                            <td><a href="bill_service_detail.jsp" title="业务详单">详单</a></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>openlab1</td>
                            <td>192.168.100.20</td>
                            <td>101</td>
                            <td>3分15秒</td>
                            <td>3.45</td>
                            <td>包 20 小时</td>                          
                            <td><a href="bill_service_detail.jsp" title="业务详单">详单</a></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>openlab1</td>
                            <td>192.168.0.23</td>
                            <td>101</td>
                            <td>13分15秒</td>
                            <td>13.45</td>
                            <td>包 40 小时</td>                          
                            <td><a href="bill_service_detail.jsp" title="业务详单">详单</a></td>
                        </tr> -->
                    </table>
                </div>
                <!--分页-->
                <!-- <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>     -->                
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>