
var tenbai;
var tendetai;
var thoigian;
var trangthai;
var noidung;
var lienkettinh;
var so;

function duyet(so) {
	so = so;
	trangthai = "trangthaicon" + so.toString();
	document.getElementById(trangthai).value = "Duyệt";
	document.getElementById(trangthai).style.background = "#5cb85c";
}
function chan(so) {
	so = so;
	trangthai = "trangthaicon" + so.toString();
	if (confirm("Bạn muốn chặn bài viết này?")) {
		document.getElementById(trangthai).value = "Chặn";
		document.getElementById(trangthai).style.background = "#f0ad4e";
	}	
}
function txoa(so) {
	so = so;
	trangthai = "trangthaicon" + so.toString();
	if (confirm("Bạn muốn xóa bài viết này?")) {
		document.getElementById(trangthai).value = "Xóa";
		document.getElementById(trangthai).style.background = "#d9534f";
	}
}



function xoa() {
	var num = 0;
	var idnum = [];
	var check = document.getElementsByName('check');
	for (var i = 0; i < check.length; i++) {

		var snum = "bai";
		if (check[i].checked == true) {
			num++;
			snum = snum + check[i].value.toString();
			idnum.push(snum);
		}
	}

	if (num != 0) {
		if (confirm("Bạn thực sự muốn xóa dữ liệu vừa chọn?")) {
			for (var i = 0; i < idnum.length; i++) {
				var del = document.getElementById(idnum[i]);
				document.getElementById(idnum[i].toString()).style.display = "none";
			}
		}
		
	}

	//window.location="G:/Code_projects/HTML_CSS/Ex07_HTML_CSS/UpContent.html";
}



function xem() {
	var num = 0;
	var stext = "ndbai";
	var tenbai = "bai";
	var check = document.getElementsByName('check');
	for (var i = 0; i < check.length; i++) {
		if (check[i].checked == true) {
			num++;
			stext = stext + check[i].value.toString();
			tenbai = tenbai + check[i].value.toString();
		}
	}

	if (num != 1) {
		alert("Chọn đúng 1 dòng dữ liệu để xem chi tiết!");
	} else {
		document.getElementById("tieude").value = document.getElementsByName(tenbai)[0].innerText;
		document.getElementById("tieude").readOnly = "true";
		document.getElementById("lienkettinh").innerHTML = window.location.href;

		noidung = document.getElementById(stext).innerHTML;
		document.getElementById("content").textContent = noidung.trim();
		document.getElementById("content").readOnly = "true";
		document.getElementById("btnDangbai").disabled = "true";
		document.getElementById("btnReset").disabled = "true";

		document.getElementById("List").style.display = "none";
		document.getElementById("Content").style.display = "block";
		alert("Bạn không thể chỉnh sửa nội dung!");
	}

	//window.location="G:/Code_projects/HTML_CSS/Ex07_HTML_CSS/UpContent.html";
}

function quaylai() {
	document.getElementById("List").style.display = "block";
	document.getElementById("Content").style.display = "none";
}

function sua() {
	var num = 0;
	var stext = "ndbai";
	var tenbai = "bai";
	var check = document.getElementsByName('check');
	for (var i = 0; i < check.length; i++) {
		if (check[i].checked == true) {
			num++;
			stext = stext + check[i].value.toString();
			tenbai = tenbai + check[i].value.toString();
		}
	}

	if (num != 1) {
		alert("Chọn đúng 1 dòng dữ liệu để xem chi tiết!");
	} else {
		document.getElementById("tieude").value = document.getElementsByName(tenbai)[0].innerText;
		document.getElementById("lienkettinh").innerHTML = window.location.href;
		noidung = document.getElementById(stext).innerText;
		document.getElementById("content").textContent = noidung.trim();

		document.getElementById("List").style.display = "none";
		document.getElementById("Content").style.display = "block";
		alert("Bạn có thể chỉnh sửa nội dung!");
	}

	//window.location="G:/Code_projects/HTML_CSS/Ex07_HTML_CSS/UpContent.html";
}

function redirect() {

	tenbai = document.getElementById("tenbai").innerText;
	alert(tenbai);
	document.getElementById("tieude").value = tenbai;
	document.getElementById("tieude").readOnly = "true";
	document.getElementById("lienkettinh").innerHTML = window.location.href;
	noidung = document.getElementById("bai1").innerText;
	document.getElementById("content").textContent = noidung.trim();
	document.getElementById("content").readOnly = "true";


	

	document.getElementById("List").style.display = "none";
	document.getElementById("Content").style.display = "block";

	//window.location="G:/Code_projects/HTML_CSS/Ex07_HTML_CSS/UpContent.html";
}
var num_tag = 0;
function save_tag() {
	if (num_tag >= 10) {
		alert("Quá số thẻ quy định");
		return;			
	} else {
		num_tag++;
	}
	var content = document.getElementById("tag").value;

	if (content == "") {
		alert('Nội dung trống');			
	} else {
		var node = document.createTextNode(content);
		var para = document.createElement("td");
		para.appendChild(node);
		document.getElementById("tags").appendChild(para)
	}
}