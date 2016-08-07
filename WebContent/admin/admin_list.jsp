<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <jsp:include page="../template/powerPage.jsp">
  	<jsp:param value="2" name="pagePower"/>
 </jsp:include>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>管理员</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" /> 
      	<script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
      	<script src="<%=request.getContextPath()%>/js/layer/layer/layer.js"></script>
		<script src="<%=request.getContextPath()%>/js/admin_list.js"></script>
		<script type="text/javascript">
		//查询管理员信息  
		function SerchAdminInfor() {
			var power = $("#selectPowers").find("option:selected").val();
			if (power=="0") {
				power="";
			}
			
			var adminName = document.getElementById("serchAdmin").value;
			window.location.href = "<%=request.getContextPath()%>/ShowAdminAction?operation=search&adminName="
					+ adminName+"&power="+power;
		}
		</script>
    </head>
    <body>
         <%@include file="../template/head.jsp" %>
        <!--主要区域开始-->
        <div id="main">
            <form action="<%=request.getContextPath()%>/ShowAdminAction?operation=reset" method="post" id="resetForm">
                <!--查询-->             
                <div class="search_add">
                   <div>角色：
                        <select id="selectPowers" class="select_search">
                            <option value="0">全部</option>
                            <option value="2">管理员管理</option>
                            <option value="3">资费管理</option>
                            <option value="4">账务账号</option>
                            <option value="5">业务账号</option>
                            <option value="6">账单管理</option>
                            <option value="7">报表</option>
                        </select>
                    </div>
                    <div>管理员姓名:<input type="text" id="serchAdmin" class="text_search width200" /></div>
                    <div><input type="button"  value="搜索" class="btn_search" onclick="SerchAdminInfor()" /></div>
                    <input type="button" name="reset" id="reset" value="密码重置" class="btn_add"  onclick="resetPwd()"/>
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
                                <input type="checkbox"   onclick="selectAdmins(this);" />                  
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
                        <c:if test="${sessionScope.adminPage== null || fn:length(sessionScope.adminPage.dataList) == 0}">
                        	<tr>
                        	    <td><input type="checkbox" name="choose" /></td>  
                        		<td>没有搜索到信息!</td>
                        		<td>没有搜索到信息!</td>
                        		<td>没有搜索到信息!</td>
                        		<td>没有搜索到信息!</td>
                        		<td>没有搜索到信息!</td>
                        		<td>没有搜索到信息!</td>
                        		<td>没有搜索到信息!</td>
                        	</tr>
                        </c:if>
                        <c:forEach items="${sessionScope.adminPage.dataList}" var="adminInfor" >                      	                                  
                         <tr>
                            <td><input type="checkbox" name="choose" value="<c:out value="${adminInfor.adminId}" />"/></td>
                            <td><c:out value="${adminInfor.adminId}" /></td>           
                            <td><c:out value="${adminInfor.adminName}" /></td>
                            <td><c:out value="${adminInfor.adminAccount}" /></td>
                            <td><c:out value="${adminInfor.phone}" /></td>
                            <td><c:out value="${adminInfor.email}" /></td>                 
                            <td><c:out value="${adminInfor.createTime}" /></td>
                            <td> 
                               <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">查看权限</a>                           
                                <div class="detail_info">
                        	    <c:forEach items="${adminInfor.powers}" var="power">    
                            		<c:choose>
                            			<c:when test="${power.power == '2'}">超级管理员&nbsp;</c:when>
                            			<c:when test="${power.power == '3'}">资费管理员&nbsp;</c:when>
                            			<c:when test="${power.power == '4'}">账务账号管理员<br/></c:when>
                            			<c:when test="${power.power == '5'}">业务账号管理员&nbsp;</c:when>
                            			<c:when test="${power.power == '6'}">账单管理员&nbsp;</c:when>
                            			<c:when test="${power.power == '7'}">报表管理员</c:when>
                            		</c:choose>
                            	</c:forEach>  
                            </div>              
                            </td>                       
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='<%=request.getContextPath() %>/ShowAdminAction?operation=initById&adminId=<c:out value="${adminInfor.adminId}" />';" />
                                <input type="button" value="删除" class="btn_delete" onclick="location.href='<%=request.getContextPath() %>/DelAdminAction?adminId=<c:out value="${adminInfor.adminId}" />';"/>
                            </td>
                        </tr>
                        </c:forEach>
         
                    </table>
                </div>
                <!--分页-->
                 <div id="pages">
                 	<c:if test="${sessionScope.isPage == true}">
	                	 <c:if test="${not empty sessionScope.adminPage}">
                			<a href="<%=request.getContextPath()%>/ShowAdminAction?operation=init&currentPage=${sessionScope.adminPage.indexPage}" >首页</a>
        	        		<a href="<%=request.getContextPath()%>/ShowAdminAction?operation=init&currentPage=${sessionScope.adminPage.upPage}" >上一页</a>
                        	<a href="<%=request.getContextPath()%>/ShowAdminAction?operation=init&currentPage=${sessionScope.adminPage.nextPage}">下一页</a>
                    		<a href="<%=request.getContextPath()%>/ShowAdminAction?operation=init&currentPage=${sessionScope.adminPage.endPage}" >末页</a>
                		</c:if>
                 	</c:if>
                </div>                  
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>