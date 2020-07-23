$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var sex = $("input:radio[name='sex']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(sex).is(":checked")) {
				$(sex[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(sex[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(sex).change(function() {
		$(sex[0]).parent().siblings(".invalid-feedback").css("display", "none");
	});
});
