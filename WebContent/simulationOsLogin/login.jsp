<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>模拟Os账号登陆</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" />
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
      	<script src="<%=request.getContextPath()%>/js/layer/layer/layer.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/osLogin.js"></script>
    </head>
    <body class="index">
        <div class="login_box">
        <form action="<%=request.getContextPath()%>/OsLoginAction?operation=login" method="post" id ="loginForm" name= "login" >
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="osAccount" id="adminAccount" type="text" class="width150" /></td>
                    <td class="login_error_info"><span class="required" id = "iname"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="password" type="password" class="width150" id="password"/></td>
                    <td><span class="required" id = "ipswd"></span></td>
                </tr>
              
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                      <img style= "CURSOR:hand;" src="<%=request.getContextPath()%>/images/login_btn.png" onclick="osLogin()" /></td>  
                    <td><span class="required"></span></td>                               
                </tr>
            </table>
            </form>
        </div>
    </body>
</html>