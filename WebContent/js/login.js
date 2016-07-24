function tipsName()
			{
				var fname = document.getElementById("adminAccount").value;
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
				tipB.innerHTML = "";
				return true;
			}