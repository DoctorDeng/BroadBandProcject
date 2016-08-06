function checkInput() {
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