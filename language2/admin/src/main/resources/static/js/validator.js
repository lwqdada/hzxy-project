$(document).ready(function() {
    $('#tryitForm').bootstrapValidator({
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: '名字不能为空!'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名长度不能小于6位或超过30位'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能由字母、数字、点和下划线组成!'
                    },
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '手机号码不能为空！'
                    },
                    regexp: {
                        regexp: /^1\d{10}$/ ,
                        message: '请输入正确的11位手机号'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱地址不能为空！'
                    },
                    emailAddress: {
                        message: '该邮箱地址不合法！'
                    },
                    regexp: {
                        regexp: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/ ,
                        message: '请输入正确的邮箱地址'
                    }

                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不为空！'
                    }
                }
            }
        }
    });
});