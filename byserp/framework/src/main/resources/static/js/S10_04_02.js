$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var roleId = $("input:checkbox[name='roleId']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(roleId).is(":checked")) {
				$(roleId[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(roleId[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});


	$(roleId).prop("required", !$(roleId).is(":checked"));

	$("#roleId").prop("required",  $(roleId[0]).is(":checked"));
	$("#roleId").prop("disabled", !$(roleId[0]).is(":checked"));
	$(roleId).change(function() {
		if($(roleId).is(":checked")) {
			$(roleId[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(roleId[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(roleId).prop("required", !$(roleId).is(":checked"));
	});
});
