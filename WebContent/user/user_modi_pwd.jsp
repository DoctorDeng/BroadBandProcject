<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />        
		<script type="text/javascript">
			function check(){
				var oldPassword = document.getElementById("oldPassword").value;
				var msg = document.getElementById("msg");
				var newPassword = document.getElementById("newPassword").value;
				var newMsg = document.getElementById("newMsg");
				var reNewPwd = document.getElementById("reNewPwd").value;
				var reNewMsg = document.getElementById("reNewMsg");
				
				if(oldPassword==""){
					msg.innerHTML="请输入旧密码！";
					return false;
				}
				if(newPassword==""){
					newMsg.innerHTML="请输入新密码！";
					return false;
				}
				if(oldPassword==newPassword){
					newMsg.innerHTML="新密码与旧密码相同，请重新输入！";
					return false;
				}
				if(reNewPwd==""){
					reNewMsg.innerHTML="请重新输入新密码！";
					return false;
				}
				if(reNewPwd!=newPassword){
					reNewMsg.innerHTML="两次密码不一致，请重新输入！";
					return false;
				}
				msg.innerHTML="";
				newMsg.innerHTML="";
				reNewMsg.innerHTML="";
			}
			
			function reset() {
				document.getElementById("oldPassword").value="";
				document.getElementById("newPassword").value="";
				document.getElementById("reNewPwd").value="";
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
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，旧密码错误！-->
            <form action="<%=request.getContextPath() %>/ChangePasswordAction" method="post" class="main_form" onsubmit="return check()" onreset="reset()">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200" name="oldPassword" id="oldPassword"/><span class="required">*</span>
                    <div class="validate_msg_medium" id="msg">20长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200" name="newPassword" id="newPassword"/><span class="required">*</span>
                    <div class="validate_msg_medium" id="newMsg">20长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200"  name="reNewPwd" id="reNewPwd"/><span class="required">*</span>
                    <div class="validate_msg_medium" id="reNewMsg">两次新密码必须相同</div>
                </div>
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" />
                    <input type="reset" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer"></div>
        
    </body>
</html>