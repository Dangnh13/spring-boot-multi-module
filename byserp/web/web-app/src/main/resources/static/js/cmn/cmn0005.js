function operateFormatter(value, row, index) {
    var urlUpdate = "/cmn/cmn0005/update-request-type/" + row.id;
    return [
        '<a href=' + urlUpdate + ' title="update">',
        '<i class="fas fa-edit fa-fw"></i>',
        '</a>  '
    ].join('');
}

$(document).ready(function () {

    $('#table').bootstrapTable({
        onLoadError: function (status, jqXHR) {
            alert(jqXHR.responseText);
        }
    });
})