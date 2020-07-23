function operateFormatter(value, row, index) {
    var urlUpdate = "/cmn/cmn0002/update-branch/" + row.id;
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

    // Hiển thị id của row select
    $('form').submit(function () {
        alert($(this).serialize())
        return false
    })

    $('#btn-search').click(function () {
        $('#table').bootstrapTable('refreshOptions', {
            queryParams: function (p) {
                return {
                    branchId: $("#branchId").val(),
                    branchName: $("#branchName").val()
                }
            }
        })
    })
})