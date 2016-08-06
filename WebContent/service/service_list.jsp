`<%@page import="service.ProfessionService"%>
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
        <script type="text/javascript" src="../js/jquery.js"></script> 
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
            //删除
            function deleteAccount() {
                var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState() {
                var r = window.confirm("确定要开通此业务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
           /*  $(function(){
            	$("#search").click(function(){
            		var id  = "#";
            		if($("#idCard").val() !==""){
            			id = $("#idCard").val();
            		}  
            		var sIp = "#";
            		if($("#sIp").val() !== ""){
            			sIp = $("#sIp").val();
            		}
            		var osC = "#";
            		if( $("#osC").val() !== ""){
            		 osC = $("#osC").val();
            		 }
            		var status =$("#choose").val();
            		$.ajax({
            			url:'/lanqiao/ServiceSearchAction',
            			data:{  "id" : id ,
            					"osc": osC,
            					"sIp": sIp,
            					"status" : status,
            				},            		
            		})
            	})
            });  */
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
                <%@include file= "/template/power.jsp" %>
            </ul>            
        </div>
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
                            <option value="0">全部</option>
                            <option value="1">开通</option>
                            <option value="2">暂停</option>
                            <option value="3">删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search"  id="search"/></div>
                    <input type="button" value="增加"  class="btn_add" onclick="location.href='service_add.jsp';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
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
		<%
		List<OsDto> Listo = (new ProfessionService()).serviceListShow();
		for(OsDto sv:Listo){
			if("2".equals(sv.getStatus())){
				continue;
			}
		%>
                    <tr>
                        <td><a href="<%=request.getContextPath() %>/ServiceDetailAction?bussinessId=<%=sv.getBussinessId()%>" title="查看明细" ><%=sv.getBussinessId()%></a></td>
                        <td><%=sv.getCustomerId() %></td>
                        <td><%=sv.getIdNumber() %></td>
                        <td><%=sv.getCustomerName() %></td>
                        <td><%=sv.getOsAccount() %></td>
                        <td><%=!sv.getStatus().equals("1")?"暂停":"开通" %></td>
                        <td><%=sv.getServerIp()%></td>
                        <td>
                            <a class="summary" ><%=sv.getTariffName()%></a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                20小时，24.5 元，超出部分 0.03元/分钟
                            </div>
                        </td>                            
                        <td class="td_modi">
                            <input type="button" value="<%=sv.getStatus().equals("1")?"暂停":"开通" %>" class="btn_pause" onclick="location.href='<%=request.getContextPath()%>/lanqiao/BussinessAccountOpenAction?id=<%=sv.getOsAccount() %>&status=<%=sv.getStatus() %>';" />
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='service_modi.jsp?id=<%=sv.getBussinessId() %>';" />
                            <input type="button" value="删除" class="btn_delete" onclick="location.href='<%=request.getContextPath()%>/ServiceAccountAction?id=<%=sv.getCustomerId() %>';" />
                        </td>
                    </tr>
                      <%} %>                                                                 
                </table>
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页-->
              <!--   <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </div>  -->                   
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>