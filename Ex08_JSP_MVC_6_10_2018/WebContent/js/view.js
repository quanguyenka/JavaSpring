$(document).ready(function() {
	
//	$("#Xoa").click(function() {
//		var name = $("#Xoa").parent().prevUntil("#stt").map(function() {return $(this).text()})[5].trim();		
//		var oldUrl = $(location)[0].href;
//		var newUrl = $(location)[0].href + "&maxe=" + name;
//		window.location = newUrl;		
//	});
	//jagsjkajs
	$("#Them").click(function() {
		$(".table1").css("display", "none");
		$(".container").removeClass("img-thumbnail");
		$(".table2").css("display", "block");
	});
	$("#Huy").click(function() {
		$(".container").addClass("img-thumbnail");
		$(".table1").css("display", "block");
		$(".table2").css("display", "none");
	});	
	$("#HuyUpdate").click(function() {
		$(".table1").css("display", "block");
		$(".table3").css("display", "none");
	});
	$(".table5").hide();
	$("#themgoibaohiem").click(function() {
		$(".table4").hide();
		$(".table5").show();
	});
	$("#back").click(function() {
		$(".table5").hide();
		$(".table4").show();
	});
});
//function Update() {
//	document.getElementById("table3").style.display="block";
//	document.getElementById("table1").style.display="none";
//}