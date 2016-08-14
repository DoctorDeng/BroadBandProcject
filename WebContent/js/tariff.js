//保存结果的提示
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }

        //切换资费类型
        function feeTypeChange(type) {
        	document.getElementById("tariff").value = 0
        	document.getElementById("timeLong").value = 0
        	document.getElementById("timeTariff").value = 0;
            if (type == 1) { 
                document.getElementById("tariff").disabled =  false;
                document.getElementById("timeTariff").disabled = true;
                document.getElementById("timeLong").disabled = true;
                document.getElementById("tariff").readonly =  false;
                document.getElementById("timeTariff").readonly = true;
                document.getElementById("timeLong").readonly = true;
            }
            else if (type == 2) {
            	document.getElementById("tariff").readonly = false;
                document.getElementById("timeTariff").readonly =  false;
                document.getElementById("timeLong").readonly =  false;
                document.getElementById("tariff").disabled =  false;
                document.getElementById("timeTariff").disabled =  false;
                document.getElementById("timeLong").disabled =  false;
            }
            else if (type == 3) {
            	document.getElementById("tariff").readonly = true;
                document.getElementById("timeTariff").readonly =  false;
                document.getElementById("timeLong").readonly = true;
                document.getElementById("tariff").disabled = true;
                document.getElementById("timeTariff").disabled =  false;
                document.getElementById("timeLong").disabled = true;
            }
        }
     
        function toView(){
        	
        }