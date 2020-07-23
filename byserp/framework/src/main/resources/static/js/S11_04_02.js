$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var birthdayFlag    = $("input:checkbox[name='birthdayFlag']");
	var anniversaryDate = $("#anniversaryDate").children("input");;
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(birthdayFlag).is(":checked")) {
				$(anniversaryDate).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(anniversaryDate).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});


	$(anniversaryDate).prop("required", !$(birthdayFlag).is(":checked"));
	$(anniversaryDate).prop("disabled",  $(birthdayFlag).is(":checked"));
	$(birthdayFlag).change(function() {
		$(anniversaryDate).prop("required", !$(birthdayFlag).is(":checked"));
		$(anniversaryDate).prop("disabled",  $(birthdayFlag).is(":checked"));
		if (!$(birthdayFlag).is(":checked")) {
			$(anniversaryDate).parent().siblings(".invalid-feedback").css("display", "block");
		} else {
			$(anniversaryDate).parent().siblings(".invalid-feedback").css("display", "none");
		}
	});
});
