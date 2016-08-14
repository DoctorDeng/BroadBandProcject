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
        <title>用户详单</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" /> 
   		<script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
   		<script type="text/javascript">
   		/**
   		 * 让模块对应的菜单样式为选中
   		 * @returns
   		 */
   		$(function(){
   			$("#billMenu").attr("class","bill_on");
   		});
   		</script>
    </head>
    <body onload="initialYearAndMonth();">
        <!--Logo区域开始-->
        <%@include file="../template/head.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="#" method="">
                <!--查询-->
                <div class="search_add">  
                	<div>账务账号：<span class="readonly width70">${requestScope.customerAccount}</span></div>                            
                    <div>身份证：<span class="readonly width150">${requestScope.idNumber}</span></div>
                    <div>计费时间：<span class="readonly width70">${requestScope.month}</span></div>
                    <div>总费用：<span class="readonly width70">${requestScope.cost}</span></div>
                    <div style="font-size:15px">用户账单明细</div>                     
                    <input type="button" value="返回" class="btn_add" 
                    onclick="location.href='<%=request.getContextPath()%>/BillAction?operation=showBill';" />
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="width70">客户ID</th>
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
  								<td><a href="<%=request.getContextPath()%>/BillAction?operation=showLogin&osId=${billDetail.osId}&months=${billDetail.months}
  								&customerAccount=${billDetail.customerAccount}&osAccount=${billDetail.osAccount}&serverIp=${billDetail.serverIp}
  								&cost=${billDetail.cost}" title="账单明细">明细</a></td>
  							<tr>
  						</c:forEach>
                    </table>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>