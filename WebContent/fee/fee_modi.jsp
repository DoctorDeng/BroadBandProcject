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
        <title>资费修改</title>
        <script src="<%=request.getContextPath()%>/js/tariff.js"></script>
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
        <%@include file="../template/head.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="<%=request.getContextPath()%>/TariffUpdateAction" method="post" class="main_form">
                <div class="text_info clearfix"><span>资费ID：</span></div>
                <div class="input_info"><input type="text" name="tariffId" class="readonly" readonly value=${sessionScope.tariff.tariffId } /></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width300" name="tariffName" value=${sessionScope.tariff.tariffName } />
                    <span class="required">*</span>
                    <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info fee_type">
                   <c:choose>
                   <c:when test="${sessionScope.tariff.tariffType=='1' }">
                    <input type="radio" name="tariffType" value="1" checked="checked" id="monthly" dis onclick="feeTypeChange(1)" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="tariffType" value="2" id="package" onclick="feeTypeChange(2)" />
                    <label for="package">套餐</label>
                    <input type="radio" name="tariffType" value="3" id="timeBased" onclick="feeTypeChange(3)" />
                    <label for="timeBased">计时</label>
                   </c:when>
                   <c:when test="${sessionScope.tariff.tariffType=='2' }">
                    <input type="radio" name="tariffType" value="1" id="monthly" onclick="feeTypeChange(1)" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="tariffType" value="2" checked="checked" id="package" onclick="feeTypeChange(2)" />
                    <label for="package">套餐</label>
                    <input type="radio" name="tariffType" value="3" id="timeBased" onclick="feeTypeChange(3)" />
                    <label for="timeBased">计时</label>
                   </c:when>
                   <c:when test="${sessionScope.tariff.tariffType=='3' }">
                    <input type="radio" name="tariffType" value="1" id="monthly" onclick="feeTypeChange(1)" />
                    <label for="monthly">包月</label>
                    <input type="radio" name="tariffType" value="2" id="package" onclick="feeTypeChange(2)" />
                    <label for="package">套餐</label>
                    <input type="radio" name="tariffType" value="3" checked="checked" id="timeBased" onclick="feeTypeChange(3)" />
                    <label for="timeBased">计时</label>
                   </c:when>
                </c:choose>
                </div>
                <div class="text_info clearfix"><span>基本时长：</span></div>
                <div class="input_info">
                    <input type="text" name="timeLong" id="timeLong" value=${sessionScope.tariff.timeLong } class="width100" />
                    <span class="info">小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">1-600之间的整数</div>
                </div>
                <div class="text_info clearfix"><span>基本费用：</span></div>
                <div class="input_info"> 
                    <input type="text" name="tariff" id="tariff" value=${sessionScope.tariff.tariff } class="width100" />
                    <span class="info">元</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">0-99999.99之间的数值</div>
                </div>
                <div class="text_info clearfix"><span>单位费用：</span></div>
                <div class="input_info">
                    <input type="text" name="timeTariff" id="timeTariff" value=${sessionScope.tariff.timeTariff } class="width100" />
                    <span class="info">元/小时</span>
                    <span class="required">*</span>
                    <div class="validate_msg_long">0-99999.99之间的数值</div>
                </div>   
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="tariffExplain">${sessionScope.tariff.tariffExplain }
                    </textarea>
                    <div class="validate_msg_short">100长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"  onclick="" />
                    <input type="reset" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
</html>