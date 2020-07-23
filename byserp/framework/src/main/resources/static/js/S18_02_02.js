$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var setType = $("input:radio[name='setType']");
	var useType = $("input:radio[name='useType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(setType).is(":checked")) {
				$(setType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(setType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(setType).change(function() {
		$(setType[0]).parent().siblings(".invalid-feedback").css("display", "none");
	});

	$("#inputs").prop("disabled", !$(setType).is(":checked"));
	if($(setType).is(":checked")) {
		$("#setTypeSingle").prop("hidden",   !$("#setType1").is(":checked"));
		$("#serialId"     ).prop("disabled", !$("#setType1").is(":checked"));
		$("#setTypeMulti" ).prop("hidden",   !$("#setType2").is(":checked"));
		$("#serialIds"    ).prop("disabled", !$("#setType2").is(":checked"));
	} else {
		$("#setTypeMulti" ).prop("hidden",   true);
		$("#serialIds"    ).prop("disabled", true);
	}
	$(setType).change(function() {
		$("#inputs").prop("disabled", $("#setType2").is(":checked"));

		$("#setTypeSingle").prop("hidden",   !$("#setType1").is(":checked"));
		$("#serialId"     ).prop("disabled", !$("#setType1").is(":checked"));
		$("#setTypeMulti" ).prop("hidden",   !$("#setType2").is(":checked"));
		$("#serialIds"    ).prop("disabled", !$("#setType2").is(":checked"));
	});
});
