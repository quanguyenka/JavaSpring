$(document).ready(function() {
	$("#table2").hide();

	$("#addnew").click(function(event) {
		$("#table2").show();
		$("#table1").hide();
	});
	$("#Huy").click(function(event) {
		$("#table1").show();
		$("#table2").hide();
	});
	$("#Them").click(function(event) {
		$("#table1").show();
		$("#table2").hide();
	});
});