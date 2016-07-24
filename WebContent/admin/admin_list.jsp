<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.impl.AdminDaoImpl"%>
<%@page import="java.util.*,bean.AdminInfor,bean.Admin"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
         <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==2}">
                	<c:set var="hasPower">true</c:set>
  				</c:when>
  			</c:choose>
  		</c:forEach>
  		<!-- 当用户没有此页面的权限时，跳转到权限提示页面 -->
  		<c:if test="${hasPower==false}">
  		</c:if>
  		<%
  		   session.getAttribute("admininforList");
  		%>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            $(function(){
            	$("#reset").click(function(){
            		 var checks = []; // 定义一个空数组
            	        var txt = $('#box').find(':text'); // 获取所有文本框
            	        for (var i = 0; i < txt.length; i++) {
            	            numArr.push(txt.eq(i).val()); // 将文本框的值添加到数组中
            	        }
            	        console.info(numArr);
            		
            	});
            });
            function resetPwd() {
            	
            	var checks = document.ge
                alert("请至少选择一条数据！");
                //document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteAdmin() {
                var r = window.confirm("确定要删除此管理员吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
            }
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
            <form action="" method="">
                <!--查询-->             
                <div class="search_add">
                    <div>
                        模块：
                        <select id="selModules" class="select_search">
                            <option>全部</option>
                            <option>角色管理</option>
                            <option>管理员管理</option>
                            <option>资费管理</option>
                            <option>账务账号</option>
                            <option>业务账号</option>
                            <option>账单管理</option>
                            <option>报表</option>
                        </select>
                    </div>
                    <div>角色：<input type="text" value="" class="text_search width200" /></div>
                    <div><input type="button" value="搜索" class="btn_search"/></div>
                    <input type="button" name="reset" id="reset" value="密码重置" class="btn_add" onclick="resetPwd();" />
                    <input type="button" value="增加" class="btn_add" onclick="location.href='admin_add.jsp';" />
                </div>
                
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
                </div> 
                
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">             
                   <tr>
                            <th class="th_select_all">
                                <input type="checkbox" id="check" value="" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>                           
                        <c:forEach items="${sessionScope.admininforList}" var="adminInfor" >                      	
                                    
                         <tr>
                            <td><input type="checkbox" name="choose"/></td>  
                            <td><c:out value="${adminInfor.adminId}" /></td>           
                            <td><c:out value="${adminInfor.adminName}" /></td>
                            <td><c:out value="${adminInfor.adminAccount}" /></td>
                            <td><c:out value="${adminInfor.phone}" /></td>
                            <td><c:out value="${adminInfor.email}" /></td>                 
                            <td><c:out value="${adminInfor.createTime}" /></td>
       
                            <td> 
                               <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">超级管理员..</a>                           
                                <div class="detail_info">
                        	    <c:forEach items="${adminInfor.powerList}" var="power">                            	
                            		<c:choose>
                            			<c:when test="${power == '2'}">
                           				超级管理员
                            			</c:when>
                            			<c:when test="${power == '3'}">
                           				资费管理员
                            			</c:when>
                            			<c:when test="${power == '4'}">
                           				账务账号管理员
                            			</c:when>
                            			<c:when test="${power == '5'}">
                           				业务账号管理员
                            			</c:when>
                            			<c:when test="${power == '6'}">
                           				账单管理员
                            			</c:when>
                            			<c:when test="${power == '7'}">
                           				报表管理员
                            			</c:when>
                            		</c:choose>
                            	</c:forEach>  
                            </div>              
                            </td>                       
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='admin_modi.jsp?adminId=<c:out value="${adminInfor.adminId}" />';" />
                                <input type="button" value="删除" class="btn_delete" onclick="location.href='http://localhost:8080/lanqiao/DelAdminAction?adminId=<c:out value="${adminInfor.adminId}" />';"/>
                            </td>
                        </tr>
                        </c:forEach>
         
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>