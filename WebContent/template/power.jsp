<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	      <li><a href="index.jsp" class="index_on"></a></li>
            <!-- 获取管理员拥有的权限 -->
            <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  				<c:set var="power">${adminPower.power}</c:set>
  				<!-- 通过管理员有的权限来显示菜单 -->
  				<!-- 当管理员的权限中有2权限时显示对应权限菜单 -->
  				<c:choose>
  					<c:when test="${power==2}">
                		 <li><a href="/lanqiao/admin/admin_list.jsp" class="admin_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==3}">
                		<li><a href="/lanqiao/fee/fee_list.jsp" class="fee_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==4}">
                		 <li><a href="/lanqiao/account/account_list.jsp" class="account_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==5}">
                		<li><a href="/lanqiao/service/service_list.jsp" class="service_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==6}">
                		 <li><a href="/lanqiao/BillAction?operation=showBill" class="bill_off"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==7}">
                		<li><a href="/lanqiao/StatementAction?operation=default" class="report_off"></a></li>
  					</c:when>
  				</c:choose>
  			</c:forEach>
                <li><a href="/lanqiao/AdminInforAction?operation=initInfor" class="information_off"></a></li>
                <li><a href="/lanqiao/user/user_modi_pwd.jsp" class="password_off"></a></li>