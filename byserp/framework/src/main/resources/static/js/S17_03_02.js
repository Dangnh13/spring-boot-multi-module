$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			holdRangeInvalid();
		}, false);
	});


	$("#holdRangeFrom .datetimepicker-input").on('input', function() {
		holdRangeInvalid();
	});
	$("#holdRangeTo .datetimepicker-input").on('input', function() {
		holdRangeInvalid();
	});

	function holdRangeInvalid() {
		var invalid = false;
		var valFrom = $("#holdRangeFrom .datetimepicker-input").val();
		var valTo   = $("#holdRangeTo   .datetimepicker-input").val();
		if (!valFrom || !valTo) {
			invalid = true;
		}
		if (invalid) {
			$("#holdRangeFrom").parent().siblings(".invalid-feedback").css("display", "block");
		} else {
			$("#holdRangeFrom").parent().siblings(".invalid-feedback").css("display", "none");
		}
	}
});
