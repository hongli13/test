$(function(){
    layui.use(['form','jquery','layer'],function(){
        var form = layui.form,
            $ = layui.jquery,
            layer = layui.layer;
        form.on('submit(submitBtn)',function (obj) {
            $.ajax({
                url:'/drug/pages/admin/AdminAbsAction/updateByPassword.html',
                type:'POST',
                data:$('.layui-form').serialize(),
                success:function (data) {
                    if(data == "success"){
                        layer.msg('增加成功',{time:1000,icon:1,end:function () {
                                window.location.href='/drug/adminUpdateByPasswordUrl.html'
                            }})
                    }else if(data == "error"){
                        layer.msg('增加失败',{time:1000,icon:2,end:function () {
                            window.location.reload();
                        }})
                    }
                }
            })
        })
    })
})