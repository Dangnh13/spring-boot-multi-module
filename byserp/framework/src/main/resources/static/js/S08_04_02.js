$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var targetType = $("input:checkbox[name='targetType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(targetType).is(":checked")) {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(targetType).prop("required", !$(targetType).is(":checked"));

	$("#groupId").prop("disabled", !$("#group").is(":checked"));
	$(targetType).change(function() {
		if($(targetType).is(":checked")) {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(targetType).prop("required", !$(targetType).is(":checked"));

		$("#groupId").prop("disabled", !$("#group").is(":checked"));
		if ($(group).is(":checked")) {
			$("#groupId").attr("required", "required");
		} else {
			$("#groupId").removeAttr("required");
		}
	});
});
