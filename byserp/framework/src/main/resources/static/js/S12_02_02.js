$(function () {
	'use strict';

	var forms = document.getElementsByClassName('needs-validation');
	var targetType   = $("input:checkbox[name='targetType']");
	var messageType1 = $("input:radio[name='messageType1']");
	var messageType2 = $("input:radio[name='messageType2']");
	var messageType3 = $("input:radio[name='messageType3']");
	var messageType4 = $("input:radio[name='messageType4']");
	var messageType5 = $("input:radio[name='messageType5']");
	var validation = Array.prototype.filter.call(forms, function(form) {
		form.addEventListener('submit', function(event) {
			if (!$(targetType).is(":checked")) {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
			} else {
				$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
			}
		}, false);
	});

	$(targetType).prop("required", !$(targetType).is(":checked"));
	if ($(group).is(":checked")) {
		$("#groupId").attr("required", "required");
	} else {
		$("#groupId").removeAttr("required");
	}

	$("#groupId").prop("disabled", !$("#group").is(":checked"));
	$(targetType).change(function() {
		if($(targetType).is(":checked")) {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "none");
		} else {
			$(targetType[0]).parent().siblings(".invalid-feedback").css("display", "block");
		}
		$(targetType).prop("required", !$(targetType).is(":checked"));

		$("#groupId").prop("disabled", !$("#group").is(":checked"));
		if ($(group).is(":checked")) {
			$("#groupId").attr("required", "required");
		} else {
			$("#groupId").removeAttr("required");
		}
	});


	changeMessageType1();
	changeMessageType2();
	changeMessageType3();
	changeMessageType4();
	changeMessageType5();

	$(messageType1).change(function() {
		changeMessageType1();
	});

	$(messageType2).change(function() {
		changeMessageType2();
	});

	$(messageType3).change(function() {
		changeMessageType3();
	});

	$(messageType4).change(function() {
		changeMessageType4();
	});

	$(messageType5).change(function() {
		changeMessageType5();
	});


	function changeMessageType1() {
		if ($("#text1").is(":checked")) {
			$("#collapseText1").collapse('show');
			$("#collapseImg1" ).collapse('hide');
			$("#collapsePv1"  ).collapse('hide');
			$("#message1"     ).prop("required", true);
			$("#imageId1"     ).prop("required", false);
			$("#imagePvId1"   ).prop("required", false);

		}
		if ($("#image1").is(":checked")) {
			$("#collapseText1").collapse('hide');
			$("#collapseImg1" ).collapse('show');
			$("#collapsePv1"  ).collapse('show');
			$("#message1"     ).prop("required", false);
			$("#imageId1"     ).prop("required", false);
			$("#imagePvId1"   ).prop("required", false);
		}
	}

	function changeMessageType2() {
		if ($("#nothing2").is(":checked")) {
			$("#collapseText2").collapse('hide');
			$("#collapseImg2" ).collapse('hide');
			$("#collapsePv2"  ).collapse('hide');
			$("#message2"     ).prop("required", false);
			$("#imageId2"     ).prop("required", false);
			$("#imagePvId2"   ).prop("required", false);
		}
		if ($("#text2").is(":checked")) {
			$("#collapseText2").collapse('show');
			$("#collapseImg2" ).collapse('hide');
			$("#collapsePv2"  ).collapse('hide');
			$("#message2"     ).prop("required", true);
			$("#imageId2"     ).prop("required", false);
			$("#imagePvId2"   ).prop("required", false);
		}
		if ($("#image2").is(":checked")) {
			$("#collapseText2").collapse('hide');
			$("#collapseImg2" ).collapse('show');
			$("#collapsePv2"  ).collapse('show');
			$("#message2"     ).prop("required", false);
			$("#imageId2"     ).prop("required", true);
			$("#imagePvId2"   ).prop("required", true);
		}
	}

	function changeMessageType3() {
		if ($("#nothing3").is(":checked")) {
			$("#collapseText3").collapse('hide');
			$("#collapseImg3" ).collapse('hide');
			$("#collapsePv3"  ).collapse('hide');
			$("#message3"     ).prop("required", false);
			$("#imageId3"     ).prop("required", false);
			$("#imagePvId3"   ).prop("required", false);
		}
		if ($("#text3").is(":checked")) {
			$("#collapseText3").collapse('show');
			$("#collapseImg3" ).collapse('hide');
			$("#collapsePv3"  ).collapse('hide');
			$("#message3"     ).prop("required", true);
			$("#imageId3"     ).prop("required", false);
			$("#imagePvId3"   ).prop("required", false);
		}
		if ($("#image3").is(":checked")) {
			$("#collapseText3").collapse('hide');
			$("#collapseImg3" ).collapse('show');
			$("#collapsePv3"  ).collapse('show');
			$("#message3"     ).prop("required", false);
			$("#imageId3"     ).prop("required", true);
			$("#imagePvId3"   ).prop("required", true);
		}
	}

	function changeMessageType4() {
		if ($("#nothing4").is(":checked")) {
			$("#collapseText4").collapse('hide');
			$("#collapseImg4" ).collapse('hide');
			$("#collapsePv4"  ).collapse('hide');
			$("#message4"     ).prop("required", false);
			$("#imageId4"     ).prop("required", false);
			$("#imagePvId4"   ).prop("required", false);
		}
		if ($("#text4").is(":checked")) {
			$("#collapseText4").collapse('show');
			$("#collapseImg4" ).collapse('hide');
			$("#collapsePv4"  ).collapse('hide');
			$("#message4"     ).prop("required", true);
			$("#imageId4"     ).prop("required", false);
			$("#imagePvId4"   ).prop("required", false);
		}
		if ($("#image4").is(":checked")) {
			$("#collapseText4").collapse('hide');
			$("#collapseImg4" ).collapse('show');
			$("#collapsePv4"  ).collapse('show');
			$("#message4"     ).prop("required", false);
			$("#imageId4"     ).prop("required", true);
			$("#imagePvId4"   ).prop("required", true);
		}
	}

	function changeMessageType5() {
		if ($("#nothing5").is(":checked")) {
			$("#collapseText5").collapse('hide');
			$("#collapseImg5" ).collapse('hide');
			$("#collapsePv5"  ).collapse('hide');
			$("#message5"     ).prop("required", false);
			$("#imageId5"     ).prop("required", false);
			$("#imagePvId5"   ).prop("required", false);
		}
		if ($("#text5").is(":checked")) {
			$("#collapseText5").collapse('show');
			$("#collapseImg5" ).collapse('hide');
			$("#collapsePv5"  ).collapse('hide');
			$("#message5"     ).prop("required", true);
			$("#imageId5"     ).prop("required", false);
			$("#imagePvId5"   ).prop("required", false);
		}
		if ($("#image5").is(":checked")) {
			$("#collapseText5").collapse('hide');
			$("#collapseImg5" ).collapse('show');
			$("#collapsePv5"  ).collapse('show');
			$("#message5"     ).prop("required", false);
			$("#imageId5"     ).prop("required", true);
			$("#imagePvId5"   ).prop("required", true);
		}
	}
});
