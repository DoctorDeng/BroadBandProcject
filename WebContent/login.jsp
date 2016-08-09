<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
        <script type="text/javascript" src="js/login.js"></script>
    </head>
    <body class="index">
        <div class="login_box">
        <form action="LoginAction" method="post" id ="form" name= "login" onsubmit="return tipsName()">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="adminAccount" id="adminAccount" type="text" class="width150" /></td>
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
                   <img src="images/login_btn.png" onclick="loginCheck()" /></td>  
                    <td><span class="required"></span></td>                               
                </tr>
            </table>
            </form>
        </div>
    </body>
</html>