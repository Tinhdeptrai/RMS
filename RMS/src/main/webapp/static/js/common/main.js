var timeoutAjax = 100000;
$rowActive = null;
var currentRequest;

var home = $('#homePath').val();
var footer = $('.footer').css('height');

$(window).on('resize', function() {
	$('#wrapper').css("min-height", $(this).height() - 55);
}).resize();

function showShortToast(type, content) {
	toastr.options = {
		closeButton : false,
		debug : false,
		newestOnTop : true,
		progressBar : false,
		preventDuplicates : true,
		positionClass : 'toast-top-right',
		onclick : null,
		showDuration : 500,//Time in milliseconds the toast should take to show
		hideDuration : 500,//Time in milliseconds the toast should take to hide
		timeOut : 4000,// How long the toast will display without user interaction
		extendedTimeOut : 2000,// How long the toast will display after a user hovers over it
		showEasing : 'linear',
		hideEasing : 'linear',
		showMethod : 'fadeIn',
		hideMethod : 'fadeOut',
	}

	toastr[type](content);
}
function showLongToast(type, content) {
	toastr.options = {
		closeButton : false,
		debug : false,
		newestOnTop : true,
		progressBar : false,
		preventDuplicates : true,
		positionClass : 'toast-top-right',
		timeOut : 0,
		extendedTimeOut : 0,
		showEasing : 'linear',
		hideEasing : 'linear',
		showMethod : 'fadeIn',
		hideMethod : 'fadeOut',
		tapToDismiss : false
	};

	toastr[type](content);
}

$(document).ready(function() {

	$(document).on('click', '.view-header', function() {
		var body = $(this).parent().find(".view-body");
		if (body.is(":visible")) {
			body.hide(100);
		} else {
			body.show(100);
		}
	});
});