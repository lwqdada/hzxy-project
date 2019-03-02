
/*drozone上传图片*/
function  DropzoneUpload(id,valueId) {

    Dropzone.autoDiscover = false;//防止报"Dropzone already attached."的错误
    $(id).dropzone({
        url:"/upload",
        paramName:"dropFile",
        maxFiles: 10, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 2, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
        init:function () {
            this.on("success",function (file,res) {

                $(valueId).val(res.fileName);

            });

            this.on("queuecomplete",function(file) {
            });
            this.on("removedfile",function(file){
                //删除文件时触发的方法
                $(valueId).val(null);
            });



        }
    });

}


/*wangeditor上传图片*/
function wanditorUpload(valueid) {

    var E = window.wangEditor;
    var editor = new E('#editor');
    // 配置服务器端地址
    editor.customConfig.uploadImgServer = '/upload';
    editor.customConfig.uploadFileName = 'editorFiles';
    editor.create();

    $("#btnSubmit").bind("click", function() {
        var contentHtml = editor.txt.html();

        $(valueid).val(contentHtml);
    });

}
