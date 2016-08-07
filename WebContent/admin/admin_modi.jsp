<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <jsp:include page="../template/powerPage.jsp">
  	<jsp:param value="2" name="pagePower"/>
 </jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>修改管理员</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
      	<script src="<%=request.getContextPath()%>/js/layer/layer/layer.js"></script>
        <script src="<%=request.getContextPath() %>/js/admin_modi.js"></script>
    </head>
    <body>
        <%@include file="../template/head.jsp" %>
        <!--导航区域结束-->
        <c:set var="adminID" value="${requestScope.modiAdmin.adminId}" />
    
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">正在保存!</div>
     
        <form action="<%=request.getContextPath() %>/UpdateAdminInfor?adminId=<c:out value="${requestScope.modiAdmin.adminId}"/>" method="post" class="main_form" id="save">
            <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminName" value="<c:out value="${requestScope.modiAdmin.adminName}"/>" id="adminName"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long" id="adminNameError">6长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="<c:out value="${requestScope.modiAdmin.adminAccount}"/>" name="adminAccount" /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" value="<c:out value="${requestScope.modiAdmin.phone}"/>" name="phone" id="phone"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long" id="phoneError"></div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" value="<c:out value="${requestScope.modiAdmin.email}" />" name="email"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium"></div>
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
                        <div class="validate_msg_tiny" id="powerError">至少选择一个</div>
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
        
        <c:forEach items="${requestScope.modiAdmin.powers}" var="power" >
        	<input type="hidden" name="power"  value='<c:out value="${power.power}"/>'>
  		</c:forEach>
  		<script type="text/javascript">
  				var powers = document.getElementsByName("power");
  				for (var i=0;i<powers.length;i++) {
  					checked(powers[i].value);
  				}
        </script>
    </body>
</html>