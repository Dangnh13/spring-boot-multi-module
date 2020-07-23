$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var authority = $("input:radio[name='authority']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(authority).is(":checked")) {
				$(authority[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(authority[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(authority).change(function() {
		$(authority[0]).parent().siblings(".invalid-feedback").css("display", "none");
	});
});
