var modalDone = false;
var clickedOK = false;


/* --------------------------------------------------------------------------------------------------
modalConfirm({
     icon: ,							// 'A' : <i class="fas fa-times-circle fa-lg"></i>
     									// 'W' : <i class="fas fa-exclamation-triangle fa-lg"></i>
     									// 'I' : <i class="fas fa-info-circle fa-lg"></i>
     									// 'Q' : <i class="fas fa-question-circle fa-lg"></i>
    title: ,							// 文字列
    color: ,							// タイトルカラー
  message: ,							// メッセージ文字列
     html: ,							// メッセージHTML
  button1: ,							// キャンセルボタン文字列
  button2: ,							// OKボタン文字列
  default: ,							// デフォルトボタン 'button1', 'button2'
     done: function(body) {},			// OKボタン押下時のコールバック
   cancel: function() {}				// キャンセルボタン押下時のコールバック
});
-------------------------------------------------------------------------------------------------- */
function modalConfirm(arg) {

  // modalConfirmの存在チェック
  if (document.getElementById("modalConfirm") == null) {

    /* 無なければ追加 */
    $('body').append('\
<div class="modal fade" id="modalConfirm" tabindex="-1" role="dialog" aria-labelledby="modalConfirmLabel" aria-hidden="true">\
  <div class="modal-dialog modal-dialog-centered" role="document">\
    <div class="modal-content">\
      <div class="modal-header">\
        <h5 class="modal-title" id="modalConfirmLabel"><span id="confirmIcon"></span> <b><span id="confirmTitle">タイトル</span></b></h5>\
        <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">\
          <span aria-hidden="true">&times;</span>\
        </button>\
      </div>\
      <div class="modal-body" id="confirmMessage">\
      </div>\
      <div class="modal-footer">\
        <button type="button" class="btn btn-outline-primary" id="confirmButton1" data-dismiss="modal">キャンセル</button>\
        <button type="button" class="btn btn-primary" id="confirmButton2">OK</button>\
      </div>\
    </div>\
  </div>\
</div>\
    ');
  }

  // イベントクリア
  $('#modalConfirm').off('show.bs.modal');
  $('#modalConfirm').off('shown.bs.modal');
  $('#modalConfirm').off('hidden.bs.modal');
  $('#modalConfirm').off('click', '#confirmButton1');
  $('#modalConfirm').off('click', '#confirmButton2');
  modalDone = false;
  clickedOK = false;

  /* 引数を設定 */
  $('#modalConfirm').on('show.bs.modal', function(event) {
    var modal = $(this);
    if (arg.icon) {
      var icon = {
        A: '<i class="fas fa-times-circle fa-lg"></i>',
        W: '<i class="fas fa-exclamation-triangle fa-lg"></i>',
        I: '<i class="fas fa-info-circle fa-lg"></i>',
        Q: '<i class="fas fa-question-circle fa-lg"></i>'
      }
      modal.find('#confirmIcon').html(icon[arg.icon]);
    }
    if (arg.title) {
      modal.find('#confirmTitle').text(arg.title);
    }
    if (arg.color) {
      modal.find('#modalConfirmLabel').css('color', arg.color);
    }
    if (arg.message) {
      modal.find('#confirmMessage').text(arg.message);
    }
    if (arg.html) {
      modal.find('#confirmMessage').html(arg.html);
    }
    if (arg.button1) {
      modal.find('#confirmButton1').text(arg.button1);
    }
    if (arg.button2) {
      modal.find('#confirmButton2').text(arg.button2);
    }
  });

  // ダイアログ表示直後にフォーカスを設定する
  $('#modalConfirm').on('shown.bs.modal', function(event) {
    if (arg.default == 'button1') {
      $(this).find('#confirmButton1').focus();
    } else {
      $(this).find('#confirmButton2').focus();
    }
  });

  // ダイアログを表示
  $('#modalConfirm').modal();

  $('#modalConfirm').on('click', '#confirmButton1', function() {
    if (arg.cancel) {
      arg.cancel();
    }
    $('#modalConfirm').modal('hide');
  });

  $('#modalConfirm').on('click', '#confirmButton2', function() {
    if (arg.done) {
      arg.done($('#modalConfirm').find('#confirmMessage'));
    }
    clickedOK = true;
    $('#modalConfirm').modal('hide');
  });

  $('#modalConfirm').on('hidden.bs.modal', function(event) {
    if (arg.cancel) {
      arg.cancel();
    }
    modalDone = true;
  });

}


/* --------------------------------------------------------------------------------------------------
modalAlert({
     icon: ,							// 'A' : <i class="fas fa-times-circle fa-lg"></i>
     									// 'W' : <i class="fas fa-exclamation-triangle fa-lg"></i>
     									// 'I' : <i class="fas fa-info-circle fa-lg"></i>
     									// 'Q' : <i class="fas fa-question-circle fa-lg"></i>
    title: ,							// 文字列
    color: ,							// タイトルカラー
  message: ,							// メッセージ文字列
     html: ,							// メッセージHTML
   button: ,							// OKボタン文字列
  default: ,							// デフォルトボタン 'button'
     done: function(body) {}			// OKボタン押下時のコールバック
});
-------------------------------------------------------------------------------------------------- */
function modalAlert(arg) {

  // modalAlertの存在チェック
  if (document.getElementById("modalAlert") == null) {

    /* 無なければ追加 */
    $('body').append('\
<div class="modal fade" id="modalAlert" tabindex="-1" role="dialog" aria-labelledby="modalAlertLabel" aria-hidden="true">\
  <div class="modal-dialog modal-dialog-centered" role="document">\
    <div class="modal-content">\
      <div class="modal-header">\
        <h5 class="modal-title" id="modalAlertLabel"><span id="alertIcon"></span> <b><span id="alertTitle">タイトル</span></b></h5>\
        <button type="button" class="close" data-dismiss="modal" aria-label="閉じる">\
          <span aria-hidden="true">&times;</span>\
        </button>\
      </div>\
      <div class="modal-body" id="alertMessage">\
      </div>\
      <div class="modal-footer">\
        <button type="button" class="btn btn-primary" id="alertButton">OK</button>\
      </div>\
    </div>\
  </div>\
</div>\
    ');
  }

  // イベントクリア
  $('#modalAlert').off('show.bs.modal');
  $('#modalAlert').off('shown.bs.modal');
  $('#modalAlert').off('hidden.bs.modal');
  $('#modalAlert').off('click', '#alertButton');
  modalDone = false;


  /* 引数を設定 */
  $('#modalAlert').on('show.bs.modal', function(event) {
    var modal = $(this);
    if (arg.icon) {
      var icon = {
        A: '<i class="fas fa-times-circle fa-lg"></i>',
        W: '<i class="fas fa-exclamation-triangle fa-lg"></i>',
        I: '<i class="fas fa-info-circle fa-lg"></i>',
        Q: '<i class="fas fa-question-circle fa-lg"></i>'
      }
      modal.find('#alertIcon').html(icon[arg.icon]);
    }
    if (arg.title) {
      modal.find('#alertTitle').text(arg.title);
    }
    if (arg.color) {
      modal.find('#modalAlertLabel').css('color', arg.color);
    }
    if (arg.message) {
      modal.find('#alertMessage').text(arg.message);
    }
    if (arg.html) {
      modal.find('#alertMessage').html(arg.html);
    }
    if (arg.button1) {
      modal.find('#alertButton').text(arg.button);
    }
  });

  // ダイアログ表示直後にフォーカスを設定する
  $('#modalAlert').on('shown.bs.modal', function(event) {
    if (arg.default == 'button') {
      $(this).find('#alertButton').focus();
    }
  });

  // ダイアログを表示
  $('#modalAlert').modal();


  $('#modalAlert').on('click', '#alertButton', function() {
    if (arg.done) {
      arg.done($('#modalAlert').find('#alertMessage'));
    }
    clickedOK = true;
    $('#modalAlert').modal('hide');
  });

  $('#modalAlert').on('hidden.bs.modal', function(event) {
    modalDone = true;
  });
}


function consoleLog(msg) {
	var date = new Date();
	console.log(date.toISOString() + " : " + msg);
}

$(function () {
  $('[data-toggle="tooltip"]').tooltip()
});
