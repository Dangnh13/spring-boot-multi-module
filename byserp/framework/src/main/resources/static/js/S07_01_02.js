$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var amountMethod = $("input:checkbox[name='amountMethod']");
	var feeType = $("input:radio[name='feeType']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(amountMethod).is(":checked")) {
				$(amountMethod[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(amountMethod[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
			if (!$(feeType).is(":checked")) {
				$(feeType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(feeType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}

			expiredAtInvalid();
		}, false);
	});


	$(amountMethod).prop("required", !$(amountMethod).is(":checked"));

	$("#amount").prop("required",  $(amountMethod[0]).is(":checked"));
	$("#amount").prop("disabled", !$(amountMethod[0]).is(":checked"));

	$("#serialAmount").prop("required",  $(amountMethod[1]).is(":checked"));
	$("#serialAmount").prop("disabled", !$(amountMethod[1]).is(":checked"));
	$("#serialSetId" ).prop("required",  $(amountMethod[1]).is(":checked"));
	$("#serialSetId" ).prop("disabled", !$(amountMethod[1]).is(":checked"));
	$(amountMethod).change(function() {
		if($(amountMethod).is(":checked")) {
			$(amountMethod[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(amountMethod[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(amountMethod).prop("required", !$(amountMethod).is(":checked"));

		$("#amount").prop("required",  $(amountMethod[0]).is(":checked"));
		$("#amount").prop("disabled", !$(amountMethod[0]).is(":checked"));

		$("#serialAmount").prop("required",  $(amountMethod[1]).is(":checked"));
		$("#serialAmount").prop("disabled", !$(amountMethod[1]).is(":checked"));
		$("#serialSetId" ).prop("required",  $(amountMethod[1]).is(":checked"));
		$("#serialSetId" ).prop("disabled", !$(amountMethod[1]).is(":checked"));

		expiredAtInvalid();
	});


	$("#paidMonths").prop("required",  $(feeType[0]).is(":checked"));
	$("#paidMonths").prop("disabled", !$(feeType[0]).is(":checked"));

	$("#expiredAtFrom .datetimepicker-input").prop("required",  $(feeType[1]).is(":checked"));
	$("#expiredAtFrom .datetimepicker-input").prop("disabled", !$(feeType[1]).is(":checked"));
	$("#expiredAtTo   .datetimepicker-input").prop("required",  $(feeType[1]).is(":checked"));
	$("#expiredAtTo   .datetimepicker-input").prop("disabled", !$(feeType[1]).is(":checked"));
	$(feeType).change(function() {
		$(feeType[0]).parent().siblings(".invalid-feedback").css("display", "none");

		$("#paidMonths").prop("required",  $(feeType[0]).is(":checked"));
		$("#paidMonths").prop("disabled", !$(feeType[0]).is(":checked"));

		var valFrom = $("#expiredAtFrom .datetimepicker-input").val();
		var valTo   = $("#expiredAtTo   .datetimepicker-input").val();

		$("#expiredAtFrom .datetimepicker-input").prop("required",  $(feeType[1]).is(":checked"));
		$("#expiredAtFrom .datetimepicker-input").prop("disabled", !$(feeType[1]).is(":checked"));
		$("#expiredAtTo   .datetimepicker-input").prop("required",  $(feeType[1]).is(":checked"));
		$("#expiredAtTo   .datetimepicker-input").prop("disabled", !$(feeType[1]).is(":checked"));

		expiredAtInvalid();
	});


	$("#expiredAtFrom .datetimepicker-input").on('input', function() {
		expiredAtInvalid();
	});
	$("#expiredAtTo .datetimepicker-input").on('input', function() {
		expiredAtInvalid();
	});

	function expiredAtInvalid() {
		var invalid = false;
		if ($(feeType[1]).is(":checked")) {
			var valFrom = $("#expiredAtFrom .datetimepicker-input").val();
			var valTo   = $("#expiredAtTo   .datetimepicker-input").val();
			if (!valFrom || !valTo) {
				invalid = true;
			}
		}
		if (invalid) {
			$("#expiredAtFrom").parent().siblings(".invalid-feedback").css("display", "block");
		} else {
			$("#expiredAtFrom").parent().siblings(".invalid-feedback").css("display", "none");
		}
	}
});
