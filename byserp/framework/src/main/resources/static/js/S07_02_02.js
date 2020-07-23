$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			releaseDateInvalid();
		}, false);
	});

	$("#releaseDate .datetimepicker-input").on('input', function() {
		releaseDateInvalid();
	});

	function releaseDateInvalid() {
		var invalid = false;
		var valDate = $("#releaseDate .datetimepicker-input").val();
		if (!valDate) {
			invalid = true;
		}
		if (invalid) {
			$("#releaseDate").siblings(".invalid-feedback").css("display", "block");
		} else {
			$("#releaseDate").siblings(".invalid-feedback").css("display", "none");
		}
	}
});
