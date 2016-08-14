<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <jsp:include page="../template/powerPage.jsp">
  	<jsp:param value="3" name="pagePower"/>
 </jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>资费列表</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath() %>/styles/global_color.css" />
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
   		<script type="text/javascript">
   		/**
   		 * 让模块对应的菜单样式为选中
   		 * @returns
   		 */
   		$(function(){
   			$("#feeMenu").attr("class","fee_on");
   		});
   		</script>
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc")
                    btnObj.className = "sort_asc";
                else
                    btnObj.className = "sort_desc";
            }

            //启用
            function startFee() {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteFee() {
                var r = window.confirm("确定要删除此资费吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
            
            
            
        </script>  
          <script src="<%=request.getContextPath()%>/js/addTariff.js"></script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="<%=request.getContextPath() %>/images/logo.png" alt="logo" class="left"/>
            <a href="<%=request.getContextPath() %>/loginOutAction">[退出]</a>             
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
            <form action="<%=request.getContextPath()%>/TariffListAction?operation" method="post">
                <!--排序-->
                <div class="search_add">
                   <!--  <div>
                        <input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div> -->
                    <input type="button" value="增加" class="btn_add" onclick="window.location.href='fee_add.jsp';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="<%=request.getContextPath() %>/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data"> 
                <%
                  
                %>           
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>
                        <c:set var="tariffPage" value="${not empty sessionScope.tariffPage}" />
  					    <c:if test="${not tariffPage}">
  						   <tr>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  							   <td>没有信息</td>
  						   </tr>
  					    </c:if> 
  					    <c:forEach items="${sessionScope.tariffPage.dataList}" var="tariff" >
  							<tr>
  								<td><c:out value="${tariff.tariffId}"/></td>
  								<td><a href="<%=request.getContextPath()%>/TariffByNameAction?id=${tariff.tariffId }">${tariff.tariffName }</a></td>
  								<td><c:out value="${tariff.timeLong}"/></td>
  								<td><c:out value="${tariff.tariff}"/></td>
  								<td><c:out value="${tariff.timeTariff}"/></td>
  								<td><c:out value="${tariff.createTime}"/></td>
  								<%-- <td><c:out value="${tariff.openTime}"/></td> --%>
  								<td>
  								<c:if test="${tariff.openTime==null}">
  								</c:if>
  								<c:if test="${tariff.openTime!=null}">
  								${tariff.openTime}
  								</c:if>
  								<%-- <td><c:out value="${tariff.status}"/></td> --%>
  								</td>
  								<td>
  								<c:if test="${tariff.status==1}">
  								开通
  								</c:if>
  								<c:if test="${tariff.status==0}">
  								暂停
  								</c:if>
  								<c:if test="${tariff.status==2}">
  								删除
  								</c:if>
  								</td>
  								<td>
  								<c:if test="${tariff.status == '0'}">
  								<input type="submit" value="启用" class="btn_start" onclick="window.location.href='<%=request.getContextPath()%>/TariffOpenAction?tariffId=${tariff.tariffId}';" />
                                <input type="button" value="修改" class="btn_modify" onclick="window.location.href='<%=request.getContextPath()%>/TariffDetailAction?id=${tariff.tariffId}';" />
                                <input type="button" value="删除" name="delTariff" class="btn_delete" onclick="window.location.href='<%=request.getContextPath()%>/TariffDelAction?tariffId=${tariff.tariffId}';" />
  							    </c:if>
  							    </td>
  							<tr>
  						</c:forEach>  
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                 	<c:if test="${sessionScope.isPage == true}">
	                	 <c:if test="${not empty sessionScope.tariffPage}">
                			<a href="<%=request.getContextPath()%>/TariffListAction?currentPage=${sessionScope.tariffPage.indexPage}" >首页</a>
        	        		<a href="<%=request.getContextPath()%>/TariffListAction?currentPage=${sessionScope.tariffPage.upPage}" >上一页</a>
                            <a href="<%=request.getContextPath()%>/TariffListAction?currentPage=${sessionScope.tariffPage.currentPage}" >第${sessionScope.tariffPage.currentPage}页/共${sessionScope.tariffPage.pageNum}页</a>
                        	<a href="<%=request.getContextPath()%>/TariffListAction?currentPage=${sessionScope.tariffPage.nextPage}">下一页</a>
                    		<a href="<%=request.getContextPath()%>/TariffListAction?currentPage=${sessionScope.tariffPage.endPage}" >末页</a>
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