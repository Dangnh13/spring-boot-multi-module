$(function() {
	'use strict';

	if (cookieEnabled()) {
		$('#env-check').html('');
	} else {
		$('#env-check').append('<div class="alert alert-danger" id="alert-cookie" role="alert"><strong>警告</strong> - 本サイトは、Cookieを使用します。Cookieを有効にしてください！</div>');
	}
});


var cookieEnabled = function() {
	if (!navigator.cookieEnabled) {
		return false;
	}

	var cookie_check = "isCookie";
	var tmpCookieVal = getCookie(cookie_check);
	var cookieEnabled;

	setCookie(cookie_check, true);
	cookieEnabled = getCookie(cookie_check) ? true : false;
	if (tmpCookieVal) {
		setCookie(cookie_check,tmpCookieVal);
	} else {
		deleteCookie(cookie_check);
	}

	return cookieEnabled;
};


function getCookie(key) {
	var cookie,cookies = document.cookie.split("; ");
	for (var i = 0; i < cookies.length; i++) {
		cookie = cookies[i].split("=");
		if (cookie[0] === key) {
			return decodeURIComponent(cookie[1]);
		}
	}
}

function setCookie(key, value, param) {
	var cookie = key + "=" + encodeURIComponent(value);
	for(var param_key in param){
		cookie += "; " + param_key + "=" + param[param_key];
	}
	document.cookie = cookie;
}

function deleteCookie(key) {
	var t = new Date();
	t.setDate(t.getDate() - 1);
	setCookie(key, '' , {"expires" : t.toUTCString()});
}