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
        <title>资费信息</title>
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css" />       
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
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="<%=request.getContextPath()%>/images/logo.png" alt="logo" class="left"/>
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
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value=${sessionScope.tariff.tariffId } /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value=${sessionScope.tariff.tariffName } /></div>
                <div class="text_info clearfix"><span>资费状态：</span></div>
                <div class="input_info">
                    <select class="readonly" disabled="disabled" >
                        <c:if test="${sessionScope.tariff.status=='1' }">
                           <option selected>开通</option>
                        </c:if>
                        <c:if test="${sessionScope.tariff.status=='0' }">
                           <option selected>暂停</option>
                        </c:if>
                        <c:if test="${sessionScope.tariff.status=='2' }">
                           <option selected>删除</option>
                        </c:if>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                <c:choose>
                   <c:when test="${sessionScope.tariff.tariffType=='1' }">
                      <input type="radio" name="radFeeType" id="monthly" checked="checked" />
                      <label for="monthly" >包月</label>
                      <input type="radio" name="radFeeType" id="package" />
                      <label for="package">套餐</label>
                      <input type="radio" name="radFeeType" id="timeBased" />
                      <label for="timeBased">计时</label>
                   </c:when>
                   <c:when test="${sessionScope.tariff.tariffType=='2' }">
                      <input type="radio" name="radFeeType" id="monthly" />
                      <label for="monthly" >包月</label>
                      <input type="radio" name="radFeeType" id="package" checked="checked" />
                      <label for="package">套餐</label>
                      <input type="radio" name="radFeeType" id="timeBased" />
                      <label for="timeBased">计时</label>
                   </c:when>
                   <c:when test="${sessionScope.tariff.tariffType=='3' }">
                      <input type="radio" name="radFeeType" id="monthly" />
                      <label for="monthly" >包月</label>
                      <input type="radio" name="radFeeType" id="package" />
                      <label for="package">套餐</label>
                      <input type="radio" name="radFeeType" id="timeBased" checked="checked" />
                      <label for="timeBased">计时</label>
                   </c:when>
                </c:choose>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" class="readonly" readonly value=${sessionScope.tariff.timeLong }  />
                    <span>小时</span>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value=${sessionScope.tariff.tariff } />
                    <span>元</span>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text"  class="readonly" readonly value=${sessionScope.tariff.timeTariff } />
                    <span>元/小时</span>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value=${sessionScope.tariff.createTime } /></div>      
                <div class="text_info clearfix"><span>启动时间：</span></div>
                <div class="input_info"><input type="text"  class="readonly" readonly value=${sessionScope.tariff.openTime } /></div>      
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly>${sessionScope.tariff.tariffExplain }</textarea>
                </div>                    
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='<%=request.getContextPath()%>/TariffListAction';" />
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>