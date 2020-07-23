function refreshButton() {
    $(".btn-action").attr("disabled", false);
}

$(document).ready(function () {

    $("#table").on("refresh.bs.table", function (params) {
        refreshButton();
    });

    $("#table").on("click-row.bs.table", function (row, $element, field) {
        $("#btn-inprogress").attr("disabled", ($element.requestStatus === 'PROCESSING' || $element.requestStatus === 'REJECT' || $element.requestStatus === 'CANCEL' || $element.requestStatus === 'APPROVED'));
        $("#btn-approved").attr("disabled", ($element.requestStatus === 'REJECT' || $element.requestStatus === 'CANCEL' || $element.requestStatus === 'APPROVED'));
        $("#btn-reject").attr("disabled", ($element.requestStatus === 'REJECT' || $element.requestStatus === 'CANCEL' || $element.requestStatus === 'APPROVED'));
        $("#btn-cancel").attr("disabled", ($element.requestStatus === 'CANCEL' || $element.requestStatus === 'APPROVED'));
        $("#btn-reopen").attr("disabled", !($element.requestStatus === 'REJECT'));
    });

    $('.btn-action').click(function () {
        var rowsSelection = $('#table').bootstrapTable('getSelections');
        if (rowsSelection && rowsSelection.length > 0 && rowsSelection[0].id) {
            var btnId = $(this).attr("id");
            var requestId = rowsSelection[0].id;
            var requestStatus = null;
            if(requestId) {
                var action = "/rqt/apr0002/update";
                switch (btnId) {
                    case "btn-inprogress":
                        action = "/rqt/apr0002/update-request-status";
                        requestStatus = 'PROCESSING';
                        break;
                    case "btn-approved":
                        requestStatus = 'APPROVED';
                        break;
                    case "btn-reject":
                        requestStatus = 'REJECT';
                        break;
                    case "btn-cancel":
                        requestStatus = 'CANCEL';
                        break;
                    case "btn-reopen":
                        requestStatus = 'REOPEN';
                        break;
                }
                $('#request-id-hidden').val(requestId);
                $('#request-status-hidden').val(requestStatus);
                $('#apr0002Form').attr("action", action);
                $('#apr0002Form').submit();
            }
        } else {
            $("#toast-body").text("Vui lòng chọn 1 đơn trước khi xử lý!")
            $('.toast').toast('show');
        }
    });
})