$(document).ready(function() {
	$("input").focus(function() {
		$(this).css("background", "#dff2ff");
	});
	$("input").blur(function() {
		$(this).css("background", "#fff");
	});
});