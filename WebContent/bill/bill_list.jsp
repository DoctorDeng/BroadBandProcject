<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <jsp:include page="../template/powerPage.jsp">
  	<jsp:param value="6" name="pagePower"/>
 </jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
        <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
  	
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
		<link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" />
		<script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
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
					window.location.href="<%=request.getContextPath()%>/BillAction?operation=showBill";
				});
			}
		</script>
		
    </head>
    <body onload="initialYearAndMonth();">
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
        <div id="main">
            <form action="<%=request.getContextPath()%>/BillAction?operation" method="post">
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
                    <c:set var="billPage" value="${not empty requestScope.billPage}" />
  					<c:if test="${not billPage}">
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
  					
  						<c:forEach items="${requestScope.billPage.dataList}" var="bill" >
  							<tr>
  								<td><c:out value="${bill.billId}"/></td>
  								<td><c:out value="${bill.customerName}"/></td>
  								<td><c:out value="${bill.idNumber}"/></td>
  								<td><c:out value="${bill.customerAccount}"/></td>
  								<td><c:out value="${bill.timeLong}"/></td>
  								<td><c:out value="${bill.payWay}"/></td>
  								<td><c:out value="${bill.payStatus}"/></td>
  								<td><a href="<%=request.getContextPath()%>/BillAction?operation=showDetailBill&billId=${bill.billId}" title="账单明细">明细</a></td>
  							<tr>
  						</c:forEach>
                </table>
                <br/>
                <p id="point" style="display:none;color:red">1、搜索最多显示7条数据</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                		<c:if test="${requestScope.isPage == 'yes'}" >
                			
                			<c:if test="${requestScope.billPage.currentPage == requestScope.billPage.indexPage}">
	                			<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.indexPage}" class="btn btn-success disabled">首页</a>
        	        		</c:if>
                			<c:if test="${requestScope.billPage.currentPage != requestScope.billPage.indexPage}">
	                			<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.indexPage}" class="btn btn-success">首页</a>
        	        		</c:if>
        	        		
        	        		<c:if test="${requestScope.billPage.currentPage != 1}">
        	        			<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.upPage}" class="btn btn-danger" >上一页</a>
        	        		</c:if>
        	        		<c:if test="${requestScope.billPage.currentPage == 1}">
        	        			<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.upPage}" class="btn btn-danger disabled" >上一页</a>
        	        		</c:if>
                    
                    		<c:forEach var="i" begin="${requestScope.billPage.indexPage}" end="${requestScope.billPage.endPage}">
                    			<c:if test="${i == requestScope.billPage.currentPage}">
                    				<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${i}" class="current_page" >${i}</a>
                    			</c:if>
                    			<c:if test="${i != requestScope.billPage.currentPage}">
                    				<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${i}">${i}</a>
                    			</c:if>
                    		</c:forEach>
                    		
                    		<c:if test="${requestScope.billPage.currentPage != requestScope.billPage.nextPage}">
                    			<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.nextPage}"class="btn btn-danger" >下一页</a>
        	        		</c:if>
        	        		<c:if test="${requestScope.billPage.currentPage == requestScope.billPage.nextPage}">
                    			<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.nextPage}"class="btn btn-danger disabled" >下一页</a>
        	        		</c:if>
        	        		
        	        		<c:if test="${requestScope.billPage.currentPage != requestScope.billPage.endPage}">
	                    		<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.endPage}" class="btn btn-success">末页</a>
        	        		</c:if>
        	        		<c:if test="${requestScope.billPage.currentPage == requestScope.billPage.endPage}">
	                    		<a href="<%=request.getContextPath()%>/BillAction?operation=showBill&currentPage=${requestScope.billPage.endPage}" class="btn btn-success disabled">末页</a>
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