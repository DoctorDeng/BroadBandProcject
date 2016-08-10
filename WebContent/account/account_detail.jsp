<%@page import="bean.vo.AccountViewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powers}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==4}">
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
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
        <script language="javascript" type="text/javascript">
        	function getBirth(){
        		var idCard18 = $("#idNumber").val();
        		var year =  idCard18.substring(6,10);   
        	    var month = idCard18.substring(10,12);   
        	    var day = idCard18.substring(12,14); 
        	    $("#birth").val(year+"年"+month+"月"+day+"日");
        	}
        </script>
    </head>
    <body onload="getBirth()">
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left" />
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
            <form action="" method="" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${sessionScope.acc.bussinessId }" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info"><input type="text" value="${sessionScope.acc.bussinessName }" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" value="${sessionScope.acc.idNumber }" readonly class="readonly" id="idNumber"/>
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${sessionScope.acc.loginAccount }" readonly class="readonly" />
                </div>                   
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200 readonly" readonly value="${sessionScope.acc.phone }" />
                </div>
                <!-- <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="" /></div>
                <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="" /></div> -->
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select disabled="disabled">
                    	<c:if test="${sessionScope.acc.status=='1' }">
                        	<option selected>开通</option>
                        </c:if>
                        <c:if test="${sessionScope.acc.status=='0' }">
                        	<option selected>暂停</option>
                        </c:if>
                        <c:if test="${sessionScope.acc.status=='2' }">
                        	<option selected>删除</option>
                        </c:if>
                    </select>                        
                </div>                    
                <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${sessionScope.acc.createTime }" /></div>

                <div class="text_info clearfix"><span>上次登录时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${sessionScope.acc.lastLoginTime }" /></div>
                <!-- <div class="text_info clearfix"><span>上次登录IP：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="" /></div> -->
                <!--可选项数据-->
                <div class="text_info clearfix"><span >生日：</span></div>
                <div class="input_info">
                    <input type="text" readonly class="readonly" value="" id="birth"/>
                </div>
                <!-- <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width350 readonly" readonly value="" />
                </div> 
                <div class="text_info clearfix"><span>职业：</span></div>
                <div class="input_info">
                    <select disabled>
                        <option>干部</option>
                        <option>学生</option>
                        <option>技术人员</option>
                        <option>其他</option>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="radSex" checked="checked" id="female" disabled />
                    <label for="female">女</label>
                    <input type="radio" name="radSex" id="male" disabled />
                    <label for="male">男</label>
                </div> 
                <div class="text_info clearfix"><span>通信地址：</span></div>
                <div class="input_info"><input type="text" class="width350 readonly" readonly value="" /></div> 
                <div class="text_info clearfix"><span>邮编：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="" /></div> 
                <div class="text_info clearfix"><span>QQ：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="" /></div> -->                
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='account_list.jsp';" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>