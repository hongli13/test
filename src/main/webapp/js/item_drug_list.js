$(function () {
    $.post('/drug/pages/admin/item/ItemAction/list.html', {}, function (obj) {
        for (var x = 0; x < obj.length; x++) {
            $('#item').append('<option value="' + obj[x].iid + '">' + obj[x].title + '</option>');
        }
    }, 'json');
})