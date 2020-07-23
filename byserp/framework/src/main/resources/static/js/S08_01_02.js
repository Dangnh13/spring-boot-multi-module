$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var targetType = $("input:checkbox[name='targetType']");
	var gachaType = $("input:radio[name='gachaType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(targetType).is(":checked")) {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}

			if (!$(gachaType).is(":checked")) {
				$(gachaType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(gachaType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(targetType).prop("required", !$(targetType).is(":checked"));
	$("#paymentId" ).prop("required",  $(gachaType[2]).is(":checked"));
	$("#paymentId" ).prop("disabled", !$(gachaType[2]).is(":checked"));

	$(targetType).change(function() {
		if($(targetType).is(":checked")) {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(targetType).prop("required", !$(targetType).is(":checked"));
	});

	$(gachaType).change(function() {
		$(gachaType[0]).parent().siblings(".invalid-feedback").css("display", "none");

		$("#paymentId" ).prop("required",  $(gachaType[2]).is(":checked"));
		$("#paymentId" ).prop("disabled", !$(gachaType[2]).is(":checked"));
	});
});
