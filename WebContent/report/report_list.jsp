<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
        <script language="javascript" type="text/javascript">
            function changeTab(e,ulObj) {                
                var obj = e.srcElement || e.target;
                if (obj.nodeName == "A") {
                    var links = ulObj.getElementsByTagName("a");
                    for (var i = 0; i < links.length; i++) {
                        if (links[i].innerHTML == obj.innerHTML) {
                            links[i].className = "tab_on";
                        }
                        else {
                            links[i].className = "tab_out";
                        }
                    }
                }
            }
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
                <li><a href="../index.jsp" class="index_off"></a></li>
                <li><a href="../role/role_list.jsp" class="role_off"></a></li>
                <li><a href="../admin/admin_list.jsp" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.jsp" class="fee_off"></a></li>
                <li><a href="../account/account_list.jsp" class="account_off"></a></li>
                <li><a href="../service/service_list.jsp" class="service_off"></a></li>
                <li><a href="../bill/bill_list.jsp" class="bill_off"></a></li>
                <li><a href="../report/report_list.jsp" class="report_on"></a></li>
                <li><a href="../user/user_info.jsp" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.jsp" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->        
        <div id="report_main">
        	<div class="tabs">
    	        <ul onclick="changeTab(event,this);">
        	        <li><a href="#####" class="tab_on" title="每位客户每月的累计时长">客户使用时长</a></li>
                    <li><a href="#####" class="tab_out" title="每台服务器上累计时长最高的前三名客户">时长排行榜</a></li>
                    <li><a href="#####" class="tab_out" title="每台服务器每种资费标准的使用次数">资费使用率</a></li>
                </ul>
            </div>            
            <div class="report_box">
                <!--数据区域：用表格展示数据-->
                <div id="report_data">
                    <table id="datalist">
                        <tr>                            
                            <th>账号 ID</th>
                            <th>账务帐号</th>
                            <th>客户名称</th>
                            <th class="width200">身份证号码</th>
                            <th>电话</th>
                            <th class="width150">月份</th>
                            <th class="width150">累积时长</th>
                        </tr>                      
                        <tr>
                            <td>1</td>
                            <td>mary</td>
                            <td>贾强</td>
                            <td>220222020202020202</td>
                            <td>13987654345</td>
                            <td>2013年1月</td>
                            <td>16小时32分</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>mary</td>
                            <td>贾强</td>
                            <td>220222020202020202</td>
                            <td>13987654345</td>
                            <td>2013年2月</td>
                            <td>16小时32分</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>mary</td>
                            <td>贾强</td>
                            <td>220222020202020202</td>
                            <td>13987654345</td>
                            <td>2013年3月</td>
                            <td>16小时32分</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>tony</td>
                            <td>真真</td>
                            <td>220222020202020202</td>
                            <td>13987654345</td>
                            <td>2013年1月</td>
                            <td>16小时32分</td>
                        </tr>
                    </table>
                    <table id="datalist1" style="display:none;">
                        <tr>                            
                            <th class="width300">Unix 服务器IP</th>
                            <th>账务帐号</th>
                            <th>客户名称</th>
                            <th class="width200">身份证号码</th>
                            <th class="width150">累积时长</th>
                        </tr>                      
                        <tr>
                            <td>192.168.0.20</td>
                            <td>mary</td>
                            <td>贾强</td>
                            <td>220222020202020202</td>
                            <td>106小时32分</td>
                        </tr>
                        <tr>
                            <td>192.168.0.20</td>
                            <td>tony</td>
                            <td>米奇</td>
                            <td>220222020202020202</td>
                            <td>96小时32分</td>
                        </tr><tr>
                            <td>192.168.0.20</td>
                            <td>jecy</td>
                            <td>米妮</td>
                            <td>220222020202020202</td>
                            <td>16小时32分</td>
                        </tr>
                        <tr>
                            <td>192.168.0.23</td>
                            <td>mary</td>
                            <td>贾强</td>
                            <td>220222020202020202</td>
                            <td>16小时32分</td>
                        </tr>
                    </table>
                    <table id="datalist2" style="display:none;">
                        <tr>                            
                            <th class="width300">Unix 服务器IP</th>
                            <th>包月</th>
                            <th>套餐</th>
                            <th>计时</th>
                        </tr>                      
                        <tr>
                            <td>192.168.0.20</td>
                            <td>345</td>
                            <td>21</td>
                            <td>34</td>
                        </tr>
                        <tr>
                            <td>192.168.0.23</td>
                            <td>32</td>
                            <td>221</td>
                            <td>314</td>
                        </tr>                        
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
                </div>

            </div>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
          
        </div>
    </body>
</html>