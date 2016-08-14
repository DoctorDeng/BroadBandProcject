<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	      <li><a href="<%=request.getContextPath() %>/index.jsp" class="index_off" id="indexMenu"></a></li>
            <!-- 获取管理员拥有的权限 -->
            <c:forEach items="${sessionScope.admin.powers}" var="adminPower">
  				<c:set var="power">${adminPower.power}</c:set>
  				<!-- 通过管理员有的权限来显示菜单 -->
  				<!-- 当管理员的权限中有2权限时显示对应权限菜单 -->
  				<c:choose>
  					<c:when test="${power==2}">
                		 <li><a href="<%=request.getContextPath() %>/ShowAdminAction?operation=init" class="admin_off" id="adminMenu"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==3}">
                		<li><a href="<%=request.getContextPath() %>/TariffListAction" class="fee_off" id="feeMenu"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==4}">
                		 <li><a href="<%=request.getContextPath() %>/BussinessAccountShowAction" class="account_off" id="bussinessMenu"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==5}">
                		<li><a href="<%=request.getContextPath() %>/ServiceListAction" class="service_off" id="serviceMenu"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==6}">
                		 <li><a href="<%=request.getContextPath() %>/BillAction?operation=showBill" class="bill_off" id="billMenu"></a></li>
  					</c:when>
  				</c:choose>
  				
  				<c:choose>
  					<c:when test="${power==7}">
                		<li><a href="<%=request.getContextPath() %>/StatementAction?operation=default" class="report_off" id="reportMenu"></a></li>
  					</c:when>
  				</c:choose>
  			</c:forEach>
                <li><a href="<%=request.getContextPath() %>/user/user_info.jsp" class="information_off" id="informationMenu"></a></li>
                <li><a href="<%=request.getContextPath() %>/user/user_modi_pwd.jsp" class="password_off" id="passwordMenu"></a></li>