function tipsName()
			{
				$(function() {
			
					if ($("#adminAccount").val() == ""){
						$("#iname").html("用户名不能为空!");
						//alert("对不起，请填写用户名！");
						$("#adminAccount").focus();
						return false;
					}
					$("#iname").html("");
					
					if($("#password").val()==""){
						$("#ipswd").html("密码不能为空！");
						$("#password").focus();
						return false;
					}
					$("#ipswd").html("");
					
					
				})
				return true;

				/*var fname = $("#adminAccount").value;
				var tipA = document.getElementById("iname");
				if(fname == ""){
					tipA.innerHTML = "用户名不能为空!";
					return false;
				}
				tipA.innerHTML = "";
				 	
				var fpswd = document.getElementById("password").value
				var tipB = document.getElementById("ipswd")
				if(fpswd == ""){
					tipB.innerHTML = "密码不能为空!";
					return false;
				}
				tipB.innerHTML = "";*/
				
			}
/*function loginCheck () {
	if(tipsName()) {
		document.getElementById("form").submit();
	}
}*/

function clickBtn(event) {
	if (event.keyCode==13) {
		loginCheck();
	}
}