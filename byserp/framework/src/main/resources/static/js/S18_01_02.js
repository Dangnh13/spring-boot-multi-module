$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var serialType = $("input:radio[name='serialType']");
	var useType = $("input:radio[name='useType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(serialType).is(":checked")) {
				$(serialType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(serialType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
			if (!$(useType).is(":checked")) {
				$(useType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(useType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(serialType).change(function() {
		$(serialType[0]).parent().siblings(".invalid-feedback").css("display", "none");
	});
	$(useType).change(function() {
		$(useType[0]).parent().siblings(".invalid-feedback").css("display", "none");
	});

	$("#outputs").prop("disabled", !$(serialType).is(":checked"));
	$(serialType).change(function() {
		$("#outputs").prop("disabled", $("#serialType2").is(":checked"));
	});
});
