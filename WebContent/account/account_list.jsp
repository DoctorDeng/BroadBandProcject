<%@page import="service.AccountService"%>
<%@page import="bean.vo.AccountViewBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.vo.AccountViewBean" %>
<%@ page import="service.AccountService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/powerPage.jsp">
  	<jsp:param value="4" name="pagePower"/>
 </jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" /> 
        <script src="<%=request.getContextPath()%>/js/jquery-1.12.4.js"></script>
        <script language="javascript" type="text/javascript">
            //删除
            function deleteAccount() {
                var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
                var msg = document.getElementById("operate_result_info");
                if(r){
	                msg.innerHTML = "删除账务账号成功！";
	                msg.style.display = "block";
                	return true;
                }else{
                	return false;
                }
            }
            //开通或暂停
            function setState() {
                var r = window.confirm("确定要开通此账务账号吗？");
                var msg = document.getElementById("operate_result_info");
                if(r){
	                msg.innerHTML = "开通账务账号成功！";
	                msg.style.display = "block";
                	return true;
                }else{
                	return false;
                }
            }
            
            function pauseStatus(){
            	var r = window.confirm("确定要暂停此账号吗？\r\n暂停后该账号下的全部业务账号也会暂停！")
            	var msg = document.getElementById("operate_result_info");
            	if(r){
	                msg.innerHTML = "暂停账务账号成功！";
	                msg.style.display = "block";
            		return true;
            	}else{
            		return false;
            	}
            }
            
            function sub(){
            	document.getElementById("form").submit();
            }
            
         	function initTable(){
            	$("#datalist tr:not(:first)").remove();            	
            }
            function search() {
            	var idNumber = $("#idNumber").val();
            	var name = $("#name").val();
            	var loginAccount = $("#loginAccount").val();
            	var sstatus = $("#status  option:selected").val();
				$.post("<%=request.getContextPath()%>/BussinessAccountSearchAction", {
					'idNumber' 		:idNumber,
					'name'	   		:name,
					'loginAccount'	:loginAccount,
					'sstatus'		:sstatus
				}, function(data) {
					$("#datalist tr:not(:first)").remove();
					$("#datalist").append(data);
				});
			}
            function toPage(page){
            	var idNumber = $("#idNumber").val();
            	var name = $("#name").val();
            	var loginAccount = $("#loginAccount").val();
            	var sstatus = $("#status  option:selected").val();
            	var url = "<%=request.getContextPath()%>/BussinessAccountShowAction"
           		 +"?idNumber="+idNumber+"&loginAccount="+loginAccount+"&name="+name+"&sstatus="
        		 +sstatus+"&currentPage="+page;
            	//alert(url)
            		 window.location.href= url;
            }
            //取url参数方法 用法：GetQueryString("参数名")
            function GetQueryString(name)
            {
                 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
                 var r = window.location.search.substr(1).match(reg);
                 if(r!=null)return  unescape(r[2]); return null;
            }
            function showMenu(){
            	$("li a:eq(0)").attr("class","index_off");
            	$("li a:eq(3)").attr("class","account_on");
            }
        </script>
    </head>
    <body onload="showMenu()">
        <%@include file="../template/head.jsp" %>
        <div id="main">
            <form action="<%=request.getContextPath()%>/BussinessAccountSearchAction" method="post" id="form">
                <!--查询-->
                <div class="search_add">                        
                    <div>身份证：<input type="text" id="idNumber" name="idNumber" class="text_search" /></div>                            
                    <div>姓名：<input type="text" id="name" name="name" class="width70 text_search" /></div>
                    <div>登录名：<input type="text" name="loginAccount" id="loginAccount" class="text_search"/></div>
                    <div>
                        状态：
                        <select name="status" id="status" class="select_search">
                            <option value="-1" selected="selected">全部</option>
                            <option value="1">开通</option>
                            <option value="0">暂停</option>
                            <option value="2">删除</option>
                        </select>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" id="btnsub" onclick="search()" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='account_add.jsp';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
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
                    <c:forEach items="${sessionScope.l }" var="a">
                    <tr>
                        <td>${a.bussinessId }</td>
                        <td><a href="<%=request.getContextPath()%>/BussinessAccountDetailAction?id=${a.bussinessId }">${a.bussinessName }</a></td>
                        <td>${a.idNumber }</td>
                        <td>${a.loginAccount }</td>
                        <td><c:choose>
                        	<c:when test="${a.status=='0' }">暂停</c:when>
                        	<c:when test="${a.status=='1' }">开通</c:when>
                        	<c:when test="${a.status=='2' }">删除</c:when>
                        </c:choose></td>
                        <td>${a.createTime }</td>
                        <td>${a.lastLoginTime }</td>                           
                        <td class="td_modi">
                        	<c:if test="${a.status!='2' }">
	                        	<c:if test="${a.status=='0' }">
		                            <input type="button"  value="开通" class="btn_pause" onclick="if(setState()){ location.href='<%=request.getContextPath()%>/BussinessAccountOpenAction?id=${a.bussinessId }&status=0&currentPage=${param.currentPage }';}" />
		                        </c:if>
	                        	<c:if test="${a.status=='1' }">
		                            <input type="button" value="暂停" class="btn_pause" onclick="if(pauseStatus()){location.href='<%=request.getContextPath()%>/BussinessAccountOpenAction?id=${a.bussinessId }&status=1&currentPage=${param.currentPage }';}" />
		                        </c:if>
	                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.jsp?id=${a.bussinessId}&currentPage=${param.currentPage }';" />
	                            <input type="button" value="删除" class="btn_delete" onclick="if(deleteAccount()){location.href='<%=request.getContextPath()%>/BussinessAccountAction?id=${a.bussinessId }&currentPage=${param.currentPage }';}" />
                           </c:if>
                        </td>
                    </tr> 
                    </c:forEach>
                                
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
                <div id="pages">
                <c:if test="${param.currentPage>1 }">
                    <a href="#" onclick="toPage(1)">首页</a>
        	        <a href="#" onclick="toPage(${param.currentPage-1})">上一页</a>
        	    </c:if>
                <c:if test="${param.currentPage<=1 }">
                    <div style="width: 44px;display: inline;">首页</div>
        	        <div style="width: 56px;display: inline;">上一页</div>
        	    </c:if>
                    <a class="current_page">第${param.currentPage }页 /共${param.countPage }页</a>
                <c:if test="${param.currentPage<param.countPage}">
                    <a href="#" onclick="toPage(${param.currentPage+1})">下一页</a>
                    <a href="#" onclick="toPage(${param.countPage})">末页</a>
        	    </c:if>
                <c:if test="${param.currentPage>=param.countPage}">
                    <p style="width: 44px;display: inline;">下一页</p>
                    <p style="width: 56px;display: inline;">末页</p>
        	    </c:if>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>