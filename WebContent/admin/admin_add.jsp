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
        <title>添加管理员</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
       	<script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
      	<script src="<%=request.getContextPath()%>/js/layer/layer/layer.js"></script>
        <script src="<%=request.getContextPath() %>/js/addAdmin.js">
        </script>
    </head>
    <body>
        <%@include file="../template/head.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="<%=request.getContextPath() %>/AddAdminAction" method="post" class="main_form"  id="save">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminName" id="adminName"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long" ><span id="adminError">6长度以内的汉字、字母、数字的组合</span></div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info">
                        <input type="text" name="adminAccount" id="adminAccount"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long" ><span id="accountError">10长度以内的字母、数字和下划线的组合</span></div>
                    </div>
                    <div class="text_info clearfix"><span>密码：</span></div>
                    <div class="input_info">
                        <input type="password" name="password" id="pwd"/>
                        <span class="required">*</span>
                        <div class="validate_msg_long" ><span id="pwdError">10长度以内的字母、数字和下划线的组合</span></div>
                    </div>
                    <div class="text_info clearfix"><span>重复密码：</span></div>
                    <div class="input_info">
                        <input type="password" id="rePwd" />
                        <span class="required">*</span>
                        <div class="validate_msg_long" ><span id="rePwdError">密码前后不一致</span></div>
                    </div>      
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="phone" id="phone"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium" ><span id="phoneError">电话号码11位</span></div>
                    </div>
                    <div class="text_info clearfix"><span>身份证号：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="idNumber" id="idNumber"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium" ><span id="idnumberError">真实的18位身份证号</span></div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="email" id="emial"/>
                        <span class="required"></span>
                        <div class="validate_msg_medium" ><span id="emailError">邮箱格式错误</span></div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul >
                                <li><input type="checkbox" name="power" value="2" />超级管理员</li>
                                <li><input type="checkbox" name="power" value="3"/> 资费管理员</li>
                                <li><input type="checkbox" name="power" value="4"/> 账务账号管理员</li>
                                <li><input type="checkbox" name="power" value="5"/> 业务账号管理员</li>
                                <li><input type="checkbox" name="power" value="6"/> 账单管理员</li>
                                <li><input type="checkbox" name="power" value="7"/> 报表管理员</li>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny" id="powerError"></div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save"  onclick="showResult()"/>
                        <input type="reset" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>