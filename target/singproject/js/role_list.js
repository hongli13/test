$(function () {
    $.post('/drug/pages/role/RoleAction/list.html', {}, function (obj) {
        for (var x = 0; x < obj.length; x++) {
            $('#role').append('<input type="checkbox" name="rid" value="' + obj[x].rid + '" title="' + obj[x].title + '" > ')
        }
    }, 'json')
})