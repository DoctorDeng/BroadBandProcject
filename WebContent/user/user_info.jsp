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
  				window.location.href="/lanqiao/login.jsp";
  			</script>
  		</c:if>
        <link type="text/css" rel="stylesheet" media="all" href="/lanqiao/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="/lanqiao/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
                document.getElementById("infor").submit();
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="/lanqiao/images/logo.png" alt="logo" class="left"/>
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
            <!--保存操作后的提示信息：成功或者失败-->
             <c:set var="adminInfor" value="${not empty requestScope.adminInfor}" />
  			 <c:if test="${not adminInfor}">
  				<script>
  					window.location.href = "/lanqiao/AdminInforAction?operation=initInfor";
  				</script>
  			 </c:if>
  					
  					
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
            <form action="/lanqiao/AdminInforAction?operation=updateInfor" method="post" class="main_form" id="infor">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${sessionScope.admin.adminAccount}" /></div>
                
                <div class="text_info clearfix"><span>权限：</span></div>
                
                <div class="input_info">
                   <!--  <input type="text" readonly="readonly" class="readonly width400" 
                    value='' /> -->
                  	<p style="font-size:15px;color:blue;">
                  	<c:forEach items="${sessionScope.admin.powerList}" var="power">
                		<c:out value="${power.powerName}" />
                	</c:forEach>
                  	<p>  
                  
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" value="${requestScope.adminInfor.adminName}" name="adminName" />
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${requestScope.adminInfor.phone}" name="phone"/>
                    <div class="validate_msg_medium">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" value="${requestScope.adminInfor.email}" name="email"/>
                    <div class="validate_msg_medium">50长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${requestScope.adminInfor.createTime}"/></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" onclick="showResult();" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>