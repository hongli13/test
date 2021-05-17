$(function(){
    layui.use(['form','jquery','layer'],function(){
        var form = layui.form,
            $ = layui.jquery,
            layer = layui.layer;
        form.on('submit(submitBtn)',function (obj) {
            $.ajax({
                url:'/drug/AdminAction/login.html',
                type:'POST',
                data:$('.layui-form').serialize(),
                success:function (data) {
                    if(data == "success"){
                        layer.msg('登录成功',{time:1000,icon:1,end:function () {
                                window.location.href='/drug/successUrl.html'
                            }})
                    }else if(data == "error"){
                        layer.msg('错误的用户名或密码',{time:1000,icon:2,end:function () {
                            window.location.reload();
                        }})
                    }else{
                        layer.msg('请输入用户名或密码',{time:1000,icon:2,end:function () {
                                window.location.href='/drug/loginUrl.html'
                            }});
                    }
                }
            })
        })
    })
})