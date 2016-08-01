<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,bean.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powers}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==2}">
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
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult() {
            	
            	var chks=document.getElementsByName('power');
            	var bl=true;
            	for(var i=0;i<chks.length;i++)
            	{
            	    if(chks[i].checked) 
            	    {
            	        bl=false;
            	        break;
            	    }
            	} 
            	if(bl) {
            		alert('最少选择一条权限');
            	} else {
	                showResultDiv(true);
	                window.setTimeout("showResultDiv(false)", 1000);
            	}
            }
            
            function submitForm() {
            	document.getElementById("save").submit();
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else{
                    divResult.style.display = "none";
               		submitForm();
                }
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="<%=request.getContextPath() %>/images/logo.png" alt="logo" class="left"/>
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
        <c:set var="adminID" value="${requestScope.modiAdmin.adminId}" />
    
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
     
        <form action="<%=request.getContextPath() %>/UpdateAdminInfor?adminId=<c:out value="${requestScope.modiAdmin.adminId}"/>" method="post" class="main_form" id="save">
            <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminName" value="<c:out value="${requestScope.modiAdmin.adminName}"/>" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="<c:out value="${requestScope.modiAdmin.adminAccount}"/>" name="adminAccount" /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" value="<c:out value="${requestScope.modiAdmin.phone}"/>" name="phone" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" value="<c:out value="${requestScope.modiAdmin.email}" />" name="email"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>
                   
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                                <li><input type="checkbox" name="power" value="2" checked="checked" />超级管理员</li>
                                <li><input type="checkbox" name="power" value="3"/> 资费管理员</li>
                                <li><input type="checkbox" name="power" value="4"/> 账务账号管理员</li>
                                <li><input type="checkbox" name="power" value="5"/> 业务账号管理员</li>
                                <li><input type="checkbox" name="power" value="6"/> 账单管理员</li>
                                <li><input type="checkbox" name="power" value="7"/> 报表管理员</li>
                            </ul>
                        </div>
                        
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save" onclick="showResult()"/>
                        <input type="reset" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>