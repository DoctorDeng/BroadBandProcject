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
        <script language="javascript" type="text/javascript">
            //写入下拉框中的年份和月份
       /*      function initialYearAndMonth() {
                //写入最近3年
                var yearObj = document.getElementById("selYears");
                var year = (new Date()).getFullYear();
                for (var i = 0; i <= 2; i++) {
                    var opObj = new Option(year - i, year - i);
                    yearObj.options[i] = opObj;
                }
                //写入 12 月
                var monthObj = document.getElementById("selMonths");
                var opObj = new Option("全部", "全部");
                monthObj.options[0] = opObj;
                for (var i = 1; i <= 12; i++) {
                    var opObj = new Option(i, i);
                    monthObj.options[i] = opObj;
                }
            } */
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
            <form action="" method="">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text"  value="230101111111111111" class="text_search" /></div>
                    <div>账务账号：<input type="text" value="admin1" class="width100 text_search" /></div>                            
                    <div>姓名：<input type="text" value="张三" class="width70 text_search" /></div>
           <!--          <div>
                        <select class="select_search" id="selYears">
                        </select>
                        年
                        <select class="select_search" id="selMonths">
                        </select>
                        月
                    </div> -->
                    <div><input type="button" value="搜索" class="btn_search" /></div>
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
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
                
                <p>业务说明：<br />
                1、设计支付方式和支付状态，为用户自服务中的支付功能预留；<br />
                2、只查询近 3 年的账单，即当前年和前两年，如2013/2012/2011；<br />
                3、年和月的数据由 js 代码自动生成；<br />
                4、由数据库中的ｊｏｂ每月的月底定时计算账单数据。</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                    <a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.indexPage}">首页</a>
        	        <a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.upPage}">上一页</a>
                    
                    <a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.currentPage}" class="current_page">1</a>
                    <c:set var="pageList" value="${requestScope.page.endPage-requestScope.page.currentPage}" />
                    <c:if test="${pageList>0}" >
                    </c:if>
                    <c:forEach var="i" begin="1" end="${pageList}" step="1">
                    	<a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.currentPage + i}">
                    		<c:out value="${requestScope.page.currentPage + i}" />
                    	</a>
                    </c:forEach>
                    
                    <a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.nextPage}">下一页</a>
                    <a href="/lanqiao/BillAction?operation=showBill&currentPage=${requestScope.page.endPage}">末页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
           
        </div>
    </body>
</html>