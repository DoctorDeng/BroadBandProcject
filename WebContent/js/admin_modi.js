function checkInput() {
	/*var adminName=document.getElementsById("adminName");
	var adminError=document.getElementsById("adminError");
	var adminAccount=document.getElementsById("adminAccount");
	var accountError=document.getElementsById("accountError");
	var pwd=document.getElementsById("pwd");
	var pwdError=document.getElementsById("pwdError");
	var rePwd=document.getElementsById("rePwd");
	var rePwdError=document.getElementsById("rePwdError");
	var phone=document.getElementsById("phone");
	var phoneError=document.getElementsById("phoneError");
	var idNumber=document.getElementsById("idNumber");
	var idnumberError=document.getElementsById("idnumberError");
	var emial=document.getElementsById("emial");
	var emailError=document.getElementsById("emailError");*/
	
    if ($("#adminName").val() == "") {
        $("#adminNameError").val("姓名不能为空！");
        return false;
    }
    $("#adminNameError").val("");

    if ($("#phone").val() == "") {
        $("#phoneError").val("电话不能为空！");
        return false;
    }
    $("#phoneError").val("");

    var chks=document.getElementsByName('power');
    var bl=true;
    for(var i=0;i<chks.length;i++)
    {
        if(chks[i].checked)
        {
            bl=false;
            break;
        }
    }
    if(bl) {
        $("#powerError").val("至少选择一个");
        return false;
    } 
    $("#powerError").val("");
    return true;
}
//保存成功的提示消息
function showResult() {
    if (checkInput()) {
        showResultDiv(true);
        window.setTimeout("showResultDiv(false)", 1000);
    } else {
    	layer.open({
            type : 0,
            area : [ '400px', '150px' ],
            skin : 'layui-layer-molv',
            content : '<p></p><h2 style="color:red">对不起,您输入的信息不合要求</h2><p></p>'
        });
    }
}
function submitForm() {
    document.getElementById("save").submit();
}
function showResultDiv(flag) {
    var divResult = document.getElementById("save_result_info");
    if (flag)
        divResult.style.display = "block";
    else{
        divResult.style.display = "none";
        submitForm();
    }
}
function checked(power) {
	 var chks=document.getElementsByName('power');
	    for(var i=0;i<chks.length;i++)
	    {
	        if (power==(i+1)) {
	        	chks[i].checked = true;
	        }
	    }
}

function del(){
    
    if(window.confirm("确实要删除吗？")){
        window.location.href = "<%=request.getContextPath() %>/DelAdminAction&adminId=<c:out value='${adminInfor.adminId}' />;" //提交的url
    }else{
        return;
    }
}
/**
 * 让模块对应的菜单样式为选中
 * @returns
 */
$(function(){
	$("#adminMenu").attr("class","admin_on");
});