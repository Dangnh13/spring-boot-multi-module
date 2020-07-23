$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var conditionType = $("input:checkbox[name='conditionType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(conditionType).is(":checked")) {
				$(conditionType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(conditionType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});


	$(conditionType).prop("required", !$(conditionType).is(":checked"));

	$("#conditionType").prop("required",  $(conditionType[0]).is(":checked"));
	$("#conditionType").prop("disabled", !$(conditionType[0]).is(":checked"));
	$(conditionType).change(function() {
		if($(conditionType).is(":checked")) {
			$(conditionType[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(conditionType[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(conditionType).prop("required", !$(conditionType).is(":checked"));
	});
});
