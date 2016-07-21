function tipsName()
			{
				var fname = document.getElementById("accountName").value;
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
				var validate = document.getElementById("validate").value;
				var validateError = document.getElementById("validateError");
				if(validate == ""){
					validateError.innerHTML = "请输入验证码!";
					return false;
				}
				if("8251"!=validate){
					validateError.innerHTML = "验证码错误！";
					return false;
				}
				validateError.innerHTML = "";
				return true;
			}