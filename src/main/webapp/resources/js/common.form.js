
jQuery.ajaxSetup({cache: false});

function isEmpty(str) {
	if (str == null || cmmTrim(str) == "" || typeof str == 'undefined') {
		return true;
	}
	return false;
}

function cmmTrim(str) {
	if (str == "") {
		return str;
	}
	var len = str.length;
	var st = 0;
	while ((st < len) && (str.charAt(st) <= ' ')) {
		st++;
	}
	while ((st < len) && (str.charAt(len - 1) <= ' ')) {
		len--;
	}
	return ((st > 0) || (len < str.length)) ? str.substring(st, len) : str;
}


$(document).ready(function(){
	$(".number").on("keyup", function(e){
		if (!(e.keyCode >= 37 && e.keyCode <= 40)){
			$(this).val($(this).val().replace(/[^0-9]/gi,""));
		}
	});
});

