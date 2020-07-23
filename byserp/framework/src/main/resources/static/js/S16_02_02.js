$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var ancillaryType = $("input:radio[name='ancillaryType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(ancillaryType).is(":checked")) {
				$(ancillaryType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(ancillaryType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(ancillaryType).change(function() {
		$(ancillaryType[0]).parent().siblings(".invalid-feedback").css("display", "none");
	});

	$("#ancillaryName").prop("disabled", !$(ancillaryType).is(":checked"));
	$(ancillaryType).change(function() {
		$("#ancillaryName").prop("disabled", $("#ancillaryType0").is(":checked"));
	});
});
