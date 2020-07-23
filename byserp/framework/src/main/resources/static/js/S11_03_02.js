$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var uses = $("input:checkbox[name='uses']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(uses).is(":checked")) {
				$(uses[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(uses[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});


	$(uses).prop("required", !$(uses).is(":checked"));

	$("#uses").prop("required",  $(uses[0]).is(":checked"));
	$("#uses").prop("disabled", !$(uses[0]).is(":checked"));
	$(uses).change(function() {
		if($(uses).is(":checked")) {
			$(uses[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(uses[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(uses).prop("required", !$(uses).is(":checked"));
	});
});
