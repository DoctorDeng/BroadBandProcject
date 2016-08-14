<%@page import="service.ProfessionService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bean.dto.*" %>
    <%@page import="java.util.*" %>
    <%@page import="mapper.*" %>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <script type="text/javascript" src="../js/jquery.js"></script>
      	<c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powers}" var="adminPower" >
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
  		</c:if> 
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
   		<script type="text/javascript">
   		/**
   		 * 让模块对应的菜单样式为选中
   		 * @returns
   		 */
   		$(function(){
   			$("#serviceMenu").attr("class","service_on");
   		});
   		</script>  
        <script language="javascript" type="text/javascript">
        function deleteAccount() {
            var r = window.confirm("确定要删除此业务账号吗？\r\n删除后此业务账号将不能进行开通暂停功能");
            var msg = document.getElementById("operate_result_info");
            if(r){
                msg.innerHTML = "删除业务账号成功！";
                msg.style.display = "block";
            	return true;
            }else{
            	return false;
            }
        }
        </script>
    </head>
    <body>
    	<%@include file="../template/head.jsp" %>
        <!--Logo区域开始-->
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
             <form action="<%=request.getContextPath() %>/ServiceSearchAction" method="post">
                <!--查询-->
               <div class="search_add">                        
                    <div>OS 账号：<input type="text" id="osC" name="osC" class="width100 text_search" /></div>                            
                    <div>服务器 IP：<input type="text" name="sIp" class="width100 text_search" /></div>
                    <div>身份证：<input type="text"  name="idCard" class="text_search" /></div>
                    <div>状态：
                        <select class="select_search" id="choose" name="status">
                            <option value="-1">全部</option>
                            <option value="1">开通</option>
                            <option value="0">暂停</option>
                            <option value="2">删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search"  id="search"/></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='service_add.jsp';" />
                	</div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>OS 账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200"></th>
                    </tr>
					<c:forEach items="${sessionScope.lsa}"  var="OsDto">
					<c:choose>
					<c:when test="${OsDto.status==2}">
						<tr>
		                    <td><a href="<%=request.getContextPath() %>/ServiceDetailAction?bussinessId=${OsDto.bussinessId}">${OsDto.bussinessId}</a></td>
		                    <td>${OsDto.customerId}</td>
		                    <td>${OsDto.idNumber}</td>
		                    <td>${OsDto.customerName}</td>
		                    <td>${OsDto.osAccount}</td>
		                    <td>${OsDto.status=='2'?"删除":"开通"}</td>
		                    <td>${OsDto.serverIp}</td>
		                    <td>
		                        <a class="summary" >${OsDto.tariffName}</a>
		                        <!--浮动的详细信息-->
		                        <div class="detail_info">
		                            20小时，24.5 元，超出部分 0.03元/分钟
		                        </div>
		                    </td>                            
                    		<td class="td_modi">            
                    		</td>
                		</tr>
                </c:when>
                <c:otherwise>
                <tr>
                    <td><a href="<%=request.getContextPath() %>/ServiceDetailAction?bussinessId=${OsDto.bussinessId}">${OsDto.bussinessId}</a></td>
                    <td>${OsDto.customerId}</td>
                    <td>${OsDto.idNumber}</td>
                    <td>${OsDto.customerName}</td>
                    <td>${OsDto.osAccount}</td>
                    <td>${OsDto.status=='0'?"暂停":"开通"}</td>
                    <td>${OsDto.serverIp}</td>
                    <td>
                        <a class="summary" >${OsDto.tariffName}</a>
                        <!--浮动的详细信息-->
                        <div class="detail_info">
                            20小时，24.5 元，超出部分 0.03元/分钟
                        </div>
                    </td>                                   
                        <td class="td_modi">
                            <input type="button" value=${OsDto.status=='1'?"暂停":"开通"} class="btn_pause" onclick="location.href='<%=request.getContextPath()%>/ServiceOpenAction?id=${OsDto.bussinessId}&status=${OsDto.status}';" />
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.jsp?id=${OsDto.bussinessId}';" />
                            <input type="button" value="删除" class="btn_delete" onclick="if(deleteAccount()){location.href='<%=request.getContextPath()%>/ServiceAccountAction?id=${OsDto.bussinessId}'}"  />
                        </td>
                    </tr>
        			</c:otherwise>
        			</c:choose>
        			</c:forEach>                                                   
                </table>
                </div>                    
                <!--分页-->      
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
        </div>
    </body>
</html>