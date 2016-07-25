<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="service.AccountService"%>
<%@page import="bean.viewBean.AccountViewBean"%>
<%@page import="dao.impl.AccountViewDaoImpl"%>
<%@page import="dao.impl.AdminInforDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.viewBean.AccountViewBean" %>
<%@ page import="service.AccountService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==4}">
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
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount() {
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState() {
                var r = window.confirm("确定要开通此账务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
            function sub(){
            	document.getElementById("form").submit();
            }
            
         	function initTable(){
            	$("#datalist tr:not(:first)").remove();            	
            }
            function sub(){
            	document.getElementById("form").submit();
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
           <img src="../images/logo.png" alt="logo" class="left" />
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
            <form action="http://localhost:8080/lanqiao/BussinessAccountSearchAction" method="post" id="form">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text" id="idNumber" name="idNumber" value="不验证" class="text_search" /></div>                            
                    <div>姓名：<input type="text" id="name" name="name" class="text_search" value="不验证" /></div>
                    <div>登录名：<input type="text" name="loginAccount" value="不验证" id="loginAccount" class="text_search"/></div>
                    <div>
                        状态：
                        <select name="status" class="select_search">
                            <option value="-1">全部</option>
                            <option value="1">开通</option>
                            <option value="0">暂停</option>
                            <option value="-1">删除</option>
                        </select>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" id="btnsub" onclick="sub()" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='account_add.jsp';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                      
                        <th class="width200"></th>
                    </tr>
                    <%
                    int currentPage = 0;
                    String c = request.getParameter("currentPage");
                    if(c!=""&&c!=null){
                    	currentPage = Integer.parseInt(c);
                    } else{
                    	currentPage = 1;
                    }
                    if(request.getParameter("type")==null||"".equals(request.getParameter("type"))){	                                               
	                    List<AccountViewBean> l = new AccountService().getAccountViewBean(currentPage);
						session.setAttribute("l", l);
	                    for(AccountViewBean a:l){
                    %>
                    <tr>
                        <td><%=a.getBussinessId() %></td>
                        <td><a href="account_detail.jsp"><%=a.getBussinessName() %></a></td>
                        <td><%=a.getIdNumber() %></td>
                        <td><%=a.getLoginAccount() %></td>
                        <td><%=a.getStatus() %></td>
                        <td><%=a.getCreateTime() %></td>
                        <td><%=a.getLastLoginTime() %></td>                           
                        <td class="td_modi">
                            <input type="button" value="<%=a.getStatus().equals("1")?"暂停":"开通" %>" class="btn_pause" onclick="location.href='http://localhost:8080/lanqiao/BussinessAccountOpenAction?id=<%=a.getBussinessId() %>&status=<%=a.getStatus() %>';" />
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.jsp?id=<%=a.getBussinessId() %>';" />
                            <input type="button" value="删除" class="btn_delete" onclick="location.href='http://localhost:8080/lanqiao/BussinessAccountAction?id=<%=a.getBussinessId() %>';" />
                        </td>
                    </tr> 
                    <%}
                    }
                    else if("search".equals(request.getParameter("type"))){
                    	AccountViewBean a = new AccountViewBean();
                    	a.setIdNumber(request.getParameter("idNumber"));
                    	a.setBussinessName(request.getParameter("bussinessName"));
                    	a.setLoginAccount(request.getParameter("loginAccount"));
                    	List<AccountViewBean> ls = (List<AccountViewBean>)session.getAttribute("ls");
	                    for(AccountViewBean ac:ls){
                    %> 
                    	<tr>
                        <td><%=ac.getBussinessId() %></td>
                        <td><a href="account_detail.jsp"><%=ac.getBussinessName() %></a></td>
                        <td><%=ac.getIdNumber() %></td>
                        <td><%=ac.getLoginAccount() %></td>
                        <td><%=ac.getStatus() %></td>
                        <td><%=ac.getCreateTime() %></td>
                        <td><%=ac.getLastLoginTime() %></td>                           
                        <td class="td_modi">
                            <input type="button" value="<%=ac.getStatus().equals("1")?"暂停":"开通" %>" class="btn_pause" onclick="location.href='http://localhost:8080/lanqiao/BussinessAccountOpenAction?id=<%=ac.getBussinessId() %>&status=<%=a.getStatus() %>';" />
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.jsp?id=<%=ac.getBussinessId() %>';" />
                            <input type="button" value="删除" class="btn_delete" onclick="location.href='http://localhost:8080/lanqiao/BussinessAccountAction?id=<%=ac.getBussinessId() %>';" />
                        </td>
                    </tr> 
                    <%
                    }
                    }%>            
                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <%
                if(request.getParameter("type")==null||"".equals(request.getParameter("type"))){
                %>
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="account_list.jsp?currentPage=<%=currentPage-1 %>">上一页</a>
                    <a href="#" class="current_page"><%=currentPage %></a>                 
                    <a href="account_list.jsp?currentPage=<%=currentPage+1 %>">下一页</a>
                    <a href="#">末页</a>
                </div>
                <%}
                else if("search".equals(request.getParameter("type"))){%> 
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="account_list.jsp?currentPage=<%=currentPage-1 %>">上一页</a>
                    <a href="#" class="current_page"><%=currentPage %></a>                 
                    <a href="account_list.jsp?currentPage=<%=currentPage+1 %>">下一页</a>
                    <a href="#">末页</a>
                </div>
                <%} %>                   
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>