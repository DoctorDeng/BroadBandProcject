<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/powerPage.jsp">
	<jsp:param value="7" name="pagePower"/>
</jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>客户登陆记录</title>
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
        <%@include file="../template/head.jsp" %>
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <div>账务账号：<span class="readonly width70">${requestScope.customerAccount}</span></div>                            
                    <div>OS 账号：<span class="readonly width100">${requestScope.osAccount}</span></div>
                    <div>服务器 IP：<span class="readonly width100">${requestScope.serverIp}</span></div>
                    <div>计费时间：<span class="readonly width70">${requestScope.months}</span></div>
                    <div>费用：<span class="readonly width70">${requestScope.cost}</span></div>
                    <!-- <input type="button" value="返回" class="btn_add" onclick="location.href='bill_item.html';" />
                    <div style="width:340px">&nbsp;&nbsp;</div>                        
                    <div style="font-size:20px">用户Os账号登陆明细</div>   -->                          
                    <input type="button" value="返回" class="btn_add" 
                    onclick="location.href='<%=request.getContextPath()%>/BillAction?operation=showBill';" />
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="width150">客户登录 IP</th>
                            <th class="width150">登入时刻</th>
                            <th class="width150">登出时刻</th>
                            <th class="width100">时长（秒）</th>
                            <th class="width150">费用</th>
                            <th>资费</th>
                        </tr>
                        
                     <c:set var="osLoginForm" value="${not empty requestScope.osLoginForm}" />
  					<c:if test="${not osLoginForm}">
  						<tr>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  							<td>没有信息</td>
  						</tr>
  					</c:if>
  					
  						<c:forEach items="${requestScope.osLoginForm}" var="osLogin" >
  							<tr>
  								<td><c:out value="${osLogin.loginIp}"/></td>
  								<td><c:out value="${osLogin.loginInTime}"/></td>
  								<td><c:out value="${osLogin.loginOutTime}"/></td>
  								<td><c:out value="${osLogin.timeLong}"/></td>
  								<td><c:out value="${osLogin.cost}"/></td>
  								<td><c:out value="${osLogin.tariffName}"/></td>
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
