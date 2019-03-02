

/*左侧边栏下拉框*/
$(document).ready(function () {
    $(".dropdownMenu").dropdown();
    $(".nav-left-dropdown>a").click(function () {


        if ($(this).attr("d") != 1 && $(this).attr("d") != undefined) {
            $(this).removeClass("nav-left-dropdown-a");
            $this = $(this);
            $(this).next("ul").slideUp(300, function () { $this.removeClass("nav-left-bottrom-border"); $this.removeClass("nav-left-dropdown-ul") });

            $(this).attr("d", "1");

        } else {
            $(this).addClass("nav-left-dropdown-a");
            $(this).addClass("nav-left-bottrom-border");
            $(this).next("ul").addClass("nav-left-dropdown-ul").slideDown(300);
            $(this).attr("d", "2");

        }


    })
});


/*根据id删除用户并给出警告提示*/
function deleteById( deleteurl) {
    $("#warnModal").modal("show");
    var result;
    // 绑定删除事件
    $("#btnModalOk").bind("click", function () {
        $.ajax({
            "url": deleteurl,
            "type": "GET",
            "dataType": "JSON",
            "success": function (data) {
                $("#btnModalOk").unbind("click");
            }
        });
        $("#warnModal").modal("hide");
        window.location.reload();
    });

}
/*全选复选框*/
function  check() {
    var flag=document.getElementById("big_box").checked;
    var minimals=document.getElementsByClassName("minimal");
    if(flag){
        for(var i=0;i<minimals.length;i++){
            minimals[i].checked=true;
        }
    }else{
        for(var i=0;i<minimals.length;i++ ){
            minimals[i].checked=false;
        }

    }
}





