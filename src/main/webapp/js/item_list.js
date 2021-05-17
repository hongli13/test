$(function () {
    layui.use('table', function (obj) {
        var table = layui.table;
        table.render({
            elem: '.layui-table',
            url: '/drug/pages/admin/item/ItemAction/listSplit.html',
            page: true,
            limit: 10,
            toolbar:'#toolBar',
            cols: [[
                {field: 'iid', title: '编码', sort: true},
                {field: 'title', title: '分类名称'},
                {field: 'note', title: '分类描述'}
            ]]
        })
    })
})