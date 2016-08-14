<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="service.*" %>
<%@page import="bean.dto.*" %>
<%@page import="bean.*" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
       <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powers}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==5}">
                	<c:set var="hasPower">true</c:set>
  				</c:when>
  			</c:choose>
  		</c:forEach>
  		<!-- 当用户没有此页面的权限时，跳转到权限提示页面 -->
  		<c:if test="${hasPower==false}">
  		<%
  			response.sendRedirect("../nopower.jsp");
  		%>
  		</c:if> 
  		 <%
	            TariffService tm = new TariffService();
	            List<Tariff> tv = tm.selectByOpenStatus();
	            request.getSession().setAttribute("tariffs",tv );
            %>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script src="../js/serviceAdd.js"></script>
    </head>
    <body>
    	<%@include file="../template/head.jsp" %>
        <!--Logo区域开始-->
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <form action="../ServiceAddAction" method="post" class="main_form" onsubmit=" return endA()">
                <!--内容项-->
               	 <div class="text_info clearfix"><span>身份证：</span></div>   
                 <div class="input_info">       
                    <input type="text" id="idNumber" class="width180"/>
                    <input type="button" id="showId" value="查询账务账号" class="btn_search_large" />
                    <span class="required">*</span>
                    <div class="validate_msg_short" id="sd"></div>
                </div>
                <div class="text_info clearfix"><span>账务账号：</span></div>
                <input type="hidden" id="customerId"/>
                <div class="input_info">
                    <input type="text" id="adminId" onkeyup="searchAccounts(this);" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="no"></div>
                </div>

                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name = "traiffId">
                        <c:forEach items="${sessionScope.tariffs}" var="Tariff">
                        	<option value="${Tariff.tariffId}">${Tariff.tariffName}</option>
                    	</c:forEach>
					</select>
                </div> 
                <div class="text_info clearfix" ><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" id="serverIp"  name = "serverIp" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="ser"></div>
                </div>                   
                <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" name="osAccount" id="osAccount"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="osA"></div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="osPassword"  id="osPassword"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="osP"></div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password"  name = "rosPassword" id="rosPassword"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="rosP"></div>
                </div>     
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"  />
                    <input type="button" value="取消" class="btn_save"  id="returnList"/>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
        </div>
    </body>
</html>