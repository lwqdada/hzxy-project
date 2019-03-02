function delList(url,fresh) {
    //获取所有被选中的记录
    var rows = $("#dataTable").bootstrapTable('getSelections');
    if (rows.length== 0) {
        alert("请先选择要删除的记录!");
        return;
    }
    var ids = '';
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i]['id'] + ",";
    }
    ids = ids.substring(0, ids.length - 1);
    deleteUser(ids,url,fresh);
}


function deleteUser(ids,url,fresh) {
    var msg = "您真的确定要删除吗？";
    if (confirm(msg) == true) {
        $.ajax({
            url:url ,
            type: "post",
            data: {
                ids: ids
            },
            success: function (data) {
                alert(data.msg);
                //重新加载记录
                //重新加载数据
                $("#dataTable").bootstrapTable('refresh', {url: fresh});
            }
        });
    }
}