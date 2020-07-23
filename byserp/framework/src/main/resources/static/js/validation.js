(function () {
    'use strict';

    window.addEventListener('load', function () {
        var forms = document.getElementsByClassName('needs-validation');
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                } else {
                    var confirm = form.elements['confirm-submit'];
                    if (typeof confirm !== 'undefined') {
                        if (typeof confirmMsgId !== 'undefined') {
                            var title = '';
                            var msg;
                            var pageTitle = $('h4.page-title');
                            if (pageTitle != null) {
                                title = pageTitle.text();
                            }
                            if (typeof confirmParams === 'undefined' || confirmParams == null) {
                                msg = getMsg(confirmMsgId);
                            } else {
                                msg = getMsgWithParams(confirmMsgId, confirmParams);
                            }
                            modalConfirm({
                                icon: 'I',
                                title: title,
                                message: msg,
                                default: 'button1',
                                done: function (body) {
                                    form.submit();
                                }
                            });
                            event.preventDefault();
                            event.stopPropagation();
                        }
                    }
                }
                form.classList.add('was-validated');
            }, false);
        });

        $('#confirm-delete').on('click', function (event) {
            if (typeof deleteMsgId !== 'undefined') {
                var title = '';
                var msg;
                var pageTitle = $('h4.page-title');
                if (pageTitle != null) {
                    title = pageTitle.text();
                }
                if (typeof deleteParams === 'undefined' || deleteParams == null) {
                    msg = getMsg(deleteMsgId);
                } else {
                    msg = getMsgWithParams(deleteMsgId, deleteParams);
                }
                modalConfirm({
                    icon: 'I',
                    title: title,
                    message: msg,
                    default: 'button1',
                    done: function (body) {
                        location.href = $('#confirm-delete').attr('href');
                    }
                });
                event.preventDefault();
                event.stopPropagation();
            }
        });

        $('#confirm-cancel').on('click', function (event) {
            if (typeof cancelMsgId !== 'undefined') {
                var title = '';
                var msg;
                var pageTitle = $('h4.page-title');
                if (pageTitle != null) {
                    title = pageTitle.text();
                }
                if (typeof cancelParams === 'undefined' || cancelParams == null) {
                    msg = getMsg(cancelMsgId);
                } else {
                    msg = getMsgWithParams(cancelMsgId, cancelParams);
                }
                modalConfirm({
                    icon: 'I',
                    title: title,
                    message: msg,
                    default: 'button1',
                    done: function (body) {
                        location.href = $('#confirm-cancel').attr('href');
                    }
                });
                event.preventDefault();
                event.stopPropagation();
            }
        });

        $('#confirm-execute').on('click', function (event) {
            if (typeof executeMsgId !== 'undefined') {
                var title = '';
                var msg;
                var pageTitle = $('h4.page-title');
                if (pageTitle != null) {
                    title = pageTitle.text();
                }
                if (typeof executeParams === 'undefined' || executeParams == null) {
                    msg = getMsg(executeMsgId);
                } else {
                    msg = getMsgWithParams(executeMsgId, executeParams);
                }
                modalConfirm({
                    icon: 'I',
                    title: title,
                    message: msg,
                    default: 'button1',
                    done: function (body) {
                        location.href = $('#confirm-execute').attr('href');
                    }
                });
                event.preventDefault();
                event.stopPropagation();
            }
        });
    }, false);
})();
