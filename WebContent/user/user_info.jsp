<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <c:set var="admin" value="${not empty sessionScope.admin}" />
  		<c:if test="${not admin}">
  			<script type="text/javascript">
  				window.location.href="<%=request.getContextPath() %>/login.jsp";
  			</script>
  		</c:if>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
        function check(){
        	var adminName = document.getElementById("adminName").value;
			var nameMsg = document.getElementById("nameMsg");
			var phone = document.getElementById("phone").value;
			var phoneMsg = document.getElementById("phoneMsg");
			var email = document.getElementById("email").value;
			var emailMsg = document.getElementById("emailMsg");
			
			if(adminName==""){
				nameMsg.innerHTML="姓名不能为空！";
				return false;
			}
			var regName=/^[A-Za-z]{8,20}$/;
			var regNameC=/^[\u4e00-\u9fa5]{2,6}$/;
			if(regName.test(adminName)==false){
				if(regNameC.test(adminName)==false){
					nameMsg.innerHTML="姓名格式不正确！";
					return false;
				}
			}
			nameMsg.innerHTML="";
			
			if(phone==""){
				phoneMsg.innerHTML="电话号码不能为空！";
				return false;
			}
			var regPhone=/^1\d{10}$/;
			if(regPhone.test(phone)==false){
				phoneMsg.innerHTML="手机格式不正确，请重新输入！";
				return false;
			}
			phoneMsg.innerHTML="";
			
			if(email==""){
				emailMsg.innerHTML="邮箱不能为空！";
				return false;
			}
			var regEmail=/^\w+@\w+.[A-Za-z]{2,3}(.[A-Za-z]{2,3})?$/;
			  if(regEmail.test(email)==false){
				  emailMsg.innerHTML="邮箱格式不正确，请重新输入！";
				  return false;
			  }
			  emailMsg.innerHTML="";
			  
			  showResult(true);
        }
            //保存成功的提示信息
            function showResult(flag) {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false)",1000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else {
                    divResult.style.display = "none";
                    document.getElementById('infor').submit();
                }
            }
            
            function reset() {
				document.getElementById("adminName").value="${sessionScope.admin.adminName}";
				document.getElementById("phone").value="${sessionScope.admin.phone}";
				document.getElementById("email").value="${sessionScope.admin.email}";
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
        <!--主要区域开始-->
        <div id="main">            
           <%--  <!--保存操作后的提示信息：成功或者失败-->
             <c:set var="adminInfor" value="6" />
  			 <c:if test="${not adminInfor}">
  				<script>
  					window.location.href = "<%=request.getContextPath() %>/AdminInforAction?operation=initInfor";
  				</script>
  			 </c:if> --%>
  					
  					
            <div id="save_result_info" class="save_success">正在保存！</div><!--保存失败，数据并发错误！-->
            <form action="<%=request.getContextPath() %>/AdminInforAction" method="post" class="main_form" id="infor" >
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${sessionScope.admin.adminAccount}" /></div>
                
                <div class="text_info clearfix"><span>权限：</span></div>
                
                <div class="input_info">
                   <!--  <input type="text" readonly="readonly" class="readonly width400" 
                    value='' /> -->
                  	<p style="font-size:15px;color:blue;">
                  	<c:forEach items="${sessionScope.admin.powers}" var="power">
                		<c:out value="${power.powerName}" />
                	</c:forEach>
                  	<p>  
                  
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" value="${sessionScope.admin.adminName}" name="adminName" id="adminName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="nameMsg">长度2-6以内的汉字或20以内字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${sessionScope.admin.phone}" name="phone" id="phone"/>
                    <div class="validate_msg_medium" id="phoneMsg">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${sessionScope.admin.email}" name="email" id="email"/>
                    <div class="validate_msg_medium" id="emailMsg">20长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${sessionScope.admin.createTime}"/></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" onclick="check();" />
                    <input type="button" value="取消" class="btn_save" onclick="reset()" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>