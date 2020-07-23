$(document).ready(function () {

    $('#documents').on('change', function () {
        var fileLabels = new Array();
        $(this)[0].files.forEach(e => {
            fileLabels.push(e.name);
        })
        $(this).next('#document-labels').html(fileLabels.join(','));
    });

    $('#email').typeahead({
        source: function (query, process) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $.ajax({
                url: "/rqt/rqt00021/search-user",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },
                method: "POST",
                data: {email: query},
                dataType: "json",
                success: function (data) {
                    var resultList = [];
                    $.map(data.data, function (item) {
                        var aItem = {
                            id: item.username,
                            name: item.email,
                            fullname: item.fullname,
                            position: item.position
                        };
                        resultList.push(aItem);
                    });
                    process(resultList);
                }
            })
        },
        afterSelect: function (item) {
            $("#assigned-user-desc").text("(" + item.fullname + " - " + item.position + ")");
            this.$element[0].value = item.name;
            $("#assignedUser").val(item.id);
            $("#fullname").val(item.fullname);
            $("#position").val(item.position);
        },
        autoSelect: false,
        minLength: 3,
        changeInputOnMove: false

    });
})