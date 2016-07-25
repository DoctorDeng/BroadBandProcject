<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <%-- <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
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
  		</c:if> --%>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script type="text/javascript" src="../js/jquery.js"></script>
       	<script language="javascript" type="text/javascript">
            $(function(){
            	$("#showId").click(function(){
            		var id = $("#idNumber").val();
            		if(""==id){	
            		}else{
            			$.ajax({
            				url:'../ServiceShowAction',
            				data:{"id": id},
            				success:function(result){
            					$("#adminId").val(result)
            				}
            			})
            		}
            	})
            }); 
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
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
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <form action="../ServiceAddAction" method="post" class="main_form">
                <!--内容项-->
               	 <div class="text_info clearfix"><span>身份证：</span></div>   
                 <div class="input_info">       
                    <input type="text" id="idNumber" class="width180"/>
                    <input type="button" id="showId" value="查询账务账号" class="btn_search_large" />
                    <span class="required">*</span>
                    <div class="validate_msg_short">没有此身份证号，请重新录入。</div>
                </div>
                <div class="text_info clearfix"><span>账务账号：</span></div>
                <input type="hidden" id="customerId"/>
                <div class="input_info">
                    <input type="text" id="adminId" onkeyup="searchAccounts(this);" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">没有此账务账号，请重新录入。</div>
                </div>

                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name = "traiffId">
                        <option value= "1">包50小时</option>
                        <option value= "2">包时8888</option>
                        <option value= "3">包月</option>
						<option value= "4">季卡</option>
						<option value= "5">年卡</option>
                </div> 
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" value="192.168.0.23"  name = "serverIp" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">15 长度，符合IP的地址规范</div>
                </div>                   
                <div class="text_info clearfix"><span>登录 OS 账号：</span></div>
                <div class="input_info">
                    <input type="text" name="osAccount" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">8长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="osPassword" />
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password"  name = "rosPassword"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">两次密码必须相同</div>
                </div>     
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
        </div>
    </body>
</html>