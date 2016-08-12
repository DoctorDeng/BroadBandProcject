$(function(){
	     	   $("#showId").click(function(){
	     		   var id = $("#idNumber").val();
	        	   var regAge = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
	        	   if(regAge.test(id)==false){
					   sd.innerHTML="你输入的身份身份证错误！";
					   return false
				   }        	   
				   sd.innerHTML="";		
           		   $.ajax({  
           			 url:'../ServiceShowAction',
           			 data:{"id": id},
           		     success:function(result){
           			 	$("#adminId").val(result)
           			 },
           			 error:function(){
           					no.innerHTML = "没有此账务账号，请重新录入！"
           				}
           			})
           			return true;	
	     	   })
	        });  
            $(function(){
            	$("#returnList").click(function(){
            		window.location.href="${pageContext.request.getContextPath()}/ServiceListAction";
            	})
            });
            
            
            function endA() {
            	var serverIp = document.getElementById("serverIp").value;
				var ser = document.getElementById("ser");
				var regAge = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
				if (regAge.test(serverIp) == false) {
					ser.innerHTML = "15长度，符合IP的地址规范";
					return false
				}
					ser.innerHTML = ""
				
				var name = document.getElementById("osAccount").value;
				var osA = document.getElementById("osA");
				var regAge = /^[A-Za-z]{3,8}$/;
				if (regAge.test(name) == false) {
					osA.innerHTML = "必须大于三个字符，且为字母";
					return false
				}
					osA.innerHTML = ""


				var pswd = document.getElementById("osPassword").value
				var osP  = document.getElementById("osP");
				var regAge = /[a-zA-Z0-9]{6,30}/;
				if (regAge.test(pswd) == false) {
					osP.innerHTML = "26长度以内的字母、数字和下划线的组合";
						return false
				}
					osP.innerHTML = ""
						
				var firstP = document.getElementById("rosPassword").value;
				var rosP = document.getElementById("rosP");
				if (pswd !== firstP) {
					rosP.innerHTML = "您两次输入的密码不相同!";
				return false
				}
				    rosP.innerHTML = "";
					return true
		}