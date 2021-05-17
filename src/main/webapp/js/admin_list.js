$(function () {
    layui.use('table', function (obj) {
        var table = layui.table;
        table.render({
            elem: '.layui-table',
            url: '/drug/pages/admin/AdminAbsAction/listSplit.html',
            page: true,
            limit: 10,
            toolbar:'#toolBar',
            cols: [[
                {field: 'aid', title: '用户编号', sort: true},
                {field: 'password', title: '用户密码'},
                {field: 'name', title: '用户名'},
                {field: 'regdate', title: '注册日期'},
                {field: 'flag', title: '用户类型',templet:'#flag'},
                {field: 'locked', title: '是否锁定',templet:'#locked'}
            ]]
        })
    })
})