$(function () {
    layui.use(['table', 'layer', 'jquery'], function (obj) {
        var table = layui.table,
            layer = layui.layer,
            $ = layui.jquery;
        table.render({
            elem: '.layui-table',
            url: '/drug/pages/admin/drug/DrugAction/listSplit.html',
            page: true,
            limit: 10,
            toolbar: '#toolBar',
            cols: [[
                {field: 'drid', title: '药品编号', sort: true},
                {field: 'title', title: '药品名称'},
                {field: 'prodate', title: '入库日期'},
                {field: 'address', title: '生产地址'},
                {field: 'phone', title: '联系电话'},
                {field: 'count', title: '药品数量'},
                {field: 'status', title: '药品状态', templet: '#status'},
                {field: 'right', title: '操作', templet: '#barOption'}
            ]],
            id: 'testReload'
        })
        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');
                table.reload('testReload', {
                    page: {
                        curr: 1
                    }, where: {
                        kw: demoReload.val()
                    }
                })
            }
        }
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        table.on('tool(listSplit)', function (obj) {
            var data = obj.data;
            if (obj.event == 'edit') {
                var drid = data.drid;
                console.log(drid)
                $.ajax({
                    url: '/drug/pages/admin/drug/DrugAction/update.html',
                    type: 'POST',
                    data: {"drid": drid},
                    success: function (data) {
                        if (data == "success") {
                            layer.msg('状态修改成功', {
                                time: 1000, icon: 1, end: function () {
                                    window.location.href = '/drug/drugListUrl.html'
                                }
                            })
                        } else if (data == "error") {
                            layer.msg('状态修改失败', {
                                time: 1000, icon: 2, end: function () {
                                    window.location.reload();
                                }
                            })
                        }
                    }
                })
            } else if (obj.event == 'add') {
                var title = data.title;
                var cou = data.count;
                var drid = data.drid;
                console.log(title + "," + cou + "," + drid);
                layer.open({
                    type: 1,
                    title: '出库记录',
                    shade: 0,
                    maxmin: true,
                    area: ['450px', '300px'],
                    skin: 'layui-layer-molv',
                    content: "<br><br><div class='layui-col-md11'><form class='layui-form'>" +
                        "<div class='layui-form-item'>" +
                        "<label for='title' class='layui-form-label'>药品名称:</label>" +
                        "<div class='layui-input-block'>" +
                        "<input type=\"text\" name=\"title\" value='" + title + "' required lay-verify=\"required\" placeholder=\"请输入药品名称\"\n" +
                        "                                   autocomplete=\"off\" class=\"layui-input\" readonly>" +
                        "</div>" +
                        "</div>" +
                        "<div class='layui-form-item'>" +
                        "<label for='title' class='layui-form-label'>领取人姓名:</label>" +
                        "<div class='layui-input-block'>" +
                        "<input type=\"text\" name=\"name\" required lay-verify=\"required\" placeholder=\"请输入领取人姓名\"\n" +
                        "                                   autocomplete=\"off\" class=\"layui-input\">" +
                        "</div>" +
                        "</div>" +
                        "<div class='layui-form-item'>" +
                        "<label for='title' class='layui-form-label'>领取数量:</label>" +
                        "<div class='layui-input-block'>" +
                        "<input type=\"text\" name=\"count\"  required lay-verify=\"required|number\" placeholder=\"请输入领取数量\"\n" +
                        "                                   autocomplete=\"off\" class=\"layui-input\">" +
                        "</div>" +
                        "</div>" +
                        "<div class='layui-form-item'>" +
                        "<div class='layui-input-block'>" +
                        "<input type='hidden' name='cou' value='" + cou + "'> " +
                        "<input type='hidden' name='drid' value='" + drid + "'> " +
                        "<input type='button' class=\"layui-btn layui-btn-sm layui-col-md-offset6\" id='addBtn' lay-filter=\"submitBtn\" lay-submit value=\"增加\"/> " +
                        "<button type='reset' class='layui-btn layui-btn-sm layui-btn-danger'>重置</button>" +
                        "</div></div>" +
                        "</form></div><div class='layui-col-md1'>&nbsp;</div>",
                })
                $(function () {
                    $('#addBtn').on('click', function () {
                        $.ajax({
                            url: '/drug/pages/admin/stock/StockAction/add.html',
                            type: 'POST',
                            data: $('.layui-form').serialize(),
                            success: function (data) {
                                if (data == "success") {
                                    layer.msg('记录成功', {
                                        time: 1000, icon: 1, end: function () {
                                            window.location.href = '/drug/drugListUrl.html'
                                        }
                                    })
                                } else if (data == "error") {
                                    layer.msg('记录失败', {
                                        time: 1000, icon: 2, end: function () {
                                            window.location.reload();
                                        }
                                    })
                                }
                            }
                        })
                    })
                })
            } else if (obj.event == 'list') {
                var title = data.title;
                table.render({
                    elem: '#stockTable',
                    url: '/drug/pages/admin/stock/StockAction/listSplit.html?title=' + title,
                    page: true,
                    limit: 10,
                    cols: [[
                        {field: 'stid', title: '出库编码', sort: true},
                        {field: 'title', title: '药品名称'},
                        {field: 'name', title: '药品领取人'},
                        {field: 'regdate', title: '领取日期'},
                        {field: 'count', title: '领取数量'}
                    ]]
                })
            }
        })
    })
})