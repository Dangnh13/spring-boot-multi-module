$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var targetType = $("input:checkbox[name='targetType']");
	var method = $("input:radio[name='method']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(targetType).is(":checked")) {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}

			if (!$(method).is(":checked")) {
				$(method[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(method[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(targetType).prop("required", !$(targetType).is(":checked"));
	$("#odds"    ).prop("required",  $(method[0]).is(":checked"));
	$("#odds"    ).prop("disabled", !$(method[0]).is(":checked"));
	$("#quantity").prop("required",  $(method[1]).is(":checked"));
	$("#quantity").prop("disabled", !$(method[1]).is(":checked"));

	$(targetType).change(function() {
		if($(targetType).is(":checked")) {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(targetType).prop("required", !$(targetType).is(":checked"));
	});

	$(method).change(function() {
		$(method[0]).parent().siblings(".invalid-feedback").css("display", "none");

		$("#odds"    ).prop("required",  $(method[0]).is(":checked"));
		$("#odds"    ).prop("disabled", !$(method[0]).is(":checked"));
		$("#quantity").prop("required",  $(method[1]).is(":checked"));
		$("#quantity").prop("disabled", !$(method[1]).is(":checked"));
	});
});
