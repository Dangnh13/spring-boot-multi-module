function refreshButton() {
    $(".btn-action").attr("disabled", false);
}

$(document).ready(function () {

    $("#table").on("refresh.bs.table", function (params) {
        refreshButton();
    });

    $("#table").on("click-row.bs.table", function (row, $element, field) {
        var sameUserLogin = principleName === $element.assignedUser;
        $("#btn-update").attr("disabled",  ($element.requestStatus === 'CANCEL'
            || $element.requestStatus === 'PROCESSING'
            || $element.requestStatus === 'APPROVED'
            || $element.requestStatus === 'REJECT') || $element.step !== "1" || !sameUserLogin);
        $("#btn-reopen").attr("disabled", !($element.requestStatus === 'REJECT') || $element.step !== "1" || !sameUserLogin);
        $("#btn-delete-confirm").attr("disabled", ($element.requestStatus === 'PROCESSING'
            || $element.requestStatus === 'APPROVED'
            || $element.requestStatus === 'CANCEL') || $element.step !== "1" || !sameUserLogin);
    });

    $('.btn-action').click(function () {
        var rowsSelection = $('#table').bootstrapTable('getSelections');
        var btnId = $(this).attr("id");
        if (rowsSelection && rowsSelection.length > 0 && rowsSelection[0].id) {
            var requestId = rowsSelection[0].id;
            if (requestId) {
                if (btnId === 'btn-delete-confirm') {
                    $('#removeModal').modal('show');
                } else {
                    var action = "/rqt/rqt0002/update";
                    switch (btnId) {
                        case "btn-reopen":
                            var requestStatus = 'REOPEN';
                            $('#request-status-hidden').val(requestStatus);
                            break;
                    }
                    $('#request-id-hidden').val(requestId);
                    $('#rqt0002Form').attr("action", action);
                    $('#rqt0002Form').submit();
                }
            }
        } else {
            $("#toast-body").text("Vui lòng chọn 1 đơn trước khi xử lý!")
            $('.toast').toast('show');
        }
    });

    $('#btn-delete').click(function () {
        var rowsSelection = $('#table').bootstrapTable('getSelections');
        if (rowsSelection && rowsSelection.length > 0 && rowsSelection[0].id) {
            var requestId = rowsSelection[0].id;
            if (requestId) {
                var action = "/rqt/rqt0002/delete";
                $('#request-id-hidden').val(requestId);
                $('#rqt0002Form').attr("action", action);
                $('#rqt0002Form').submit();
            }
        }
    });
})