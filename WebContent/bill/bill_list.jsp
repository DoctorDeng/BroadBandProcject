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
  				<c:when test="${power==6}">
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
		<script src="js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
			function search() {
				
				var idNumber = $("#idNumber").val();
            	var loginAccount = $("#loginAccount").val();
            	var customerName = $("#customerName").val();
            	$("#pages").hide();
            	$("#datalist").hide("fast");
            	
				$.post("/lanqiao/BillTest", {
					'idNumber' 	   : idNumber,
					'loginAccount' : loginAccount,
					'customerName' : customerName
				}, function(data) {
					var $menuId = $("#menuId");
					$("#datalist").empty();
					$("#datalist").append($menuId);
					$("#datalist").append(data);
					$("#datalist").show("slow",function(){
						$("#point").show();
					});
				});
			}
			
			function  show() {
				$("#datalist").hide("slow",function(){
					window.location.href="/lanqiao/BillAction?operation=showBill";
				});
			}
		</script>
    </head>
    <body onload="initialYearAndMonth();">
        <!--Logo区域开始-->
        <div id="header">
            <img src="/lanqiao/images/logo.png" alt="logo" class="left"/>
            <a href="# ">[退出]</a>            
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
            <form action="/lanqiao/BillAction?operation" method="post">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text" id="idNumber"       class="text_search" /></div>
                    <div>账务账号：<input type="text"  id="loginAccount" class="width100 text_search" /></div>                            
                    <div>姓名：<input type="text"     id="customerName" class="width70 text_search" /></div>
                    <div><input type="button" value="搜索" class="btn_search" onclick="search()" /></div>
                    <div><input type="button" value="显示所有" class="btn_search" onclick="show()" /></div>
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr id="menuId">
                        <th class="width50">账单ID</th>
                        <th class="width70">姓名</th>
                        <th class="width150">身份证</th>
                        <th class="width150">账务账号</th>
                        <th class="width100">总时长</th>
                        <th class="width100">支付方式</th>
                        <th class="width100">支付状态</th>                                                        
                        <th class="width50"></th>
                    </tr>
                    <c:set var="billForm" value="${not empty requestScope.billForm}" />
  					<c:if test="${not billForm}">
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
  					
  						<c:forEach items="${requestScope.billForm}" var="bill" >
  							<tr>
  								<td><c:out value="${bill.billId}"/></td>
  								<td><c:out value="${bill.customerName}"/></td>
  								<td><c:out value="${bill.idNumber}"/></td>
  								<td><c:out value="${bill.loginAccount}"/></td>
  								<td><c:out value="${bill.timeLong}"/></td>
  								<td><c:out value="${bill.payWay}"/></td>
  								<td><c:out value="${bill.payStatus=='0'?'未支付':'支付'}"/></td>
  								<td><a href="/lanqiao/BillAction?operation=showDetailBill&billId=${bill.billId}" title="账单明细">明细</a></td>
  							<tr>
  						</c:forEach>
                </table>
                <br/>
                <p id="point" style="display:none;color:red">1、搜索最多显示7条数据</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                	<c:if test="${not empty requestScope.page}">
                		<c:if test="${requestScope.isPage == 'yes'}" >
                			<a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.indexPage}">首页</a>
        	        		<a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.upPage}">上一页</a>
                    
                    		<c:forEach var="i" begin="${requestScope.page.indexPage}" end="${requestScope.page.endPage}">
                    			<c:if test="${i == requestScope.page.currentPage}">
                    				<a href="/lanqiao/BillAction?operation=showBill&currentPage=${i}" class="current_page" >${i}</a>
                    			</c:if>
                    			<c:if test="${i != requestScope.page.currentPage}">
                    				<a href="/lanqiao/BillAction?operation=showBill&currentPage=${i}">${i}</a>
                    			</c:if>
                    		</c:forEach>
                    		<a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.nextPage}">下一页</a>
                    		<a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.endPage}">末页</a>
                		</c:if>
                	</c:if>
                </div>   
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
           
        </div>
    </body>
</html>