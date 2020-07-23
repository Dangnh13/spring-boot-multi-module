$(document).ready(function () {

    $('#table').bootstrapTable({
        onLoadError: function (status, jqXHR) {
            alert(jqXHR.responseText);
        }
    });

    $('#startTime').datetimepicker({
        format: 'DD/MM/YYYY HH:mm'
    });

    $('#endTime').datetimepicker({
        format: 'DD/MM/YYYY HH:mm'
    });

    $('#deadline').datetimepicker({
        format: 'DD/MM/YYYY HH:mm'
    });
})