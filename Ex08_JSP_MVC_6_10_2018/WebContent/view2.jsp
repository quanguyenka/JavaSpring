<%@page import="controller.Controller"%>
<%@page import="object.Baohiem"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quản lý bảo hiểm</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/view.js"></script>
<script type="text/javascript" src="./js/update.js"></script>
</head>
<body>
	<div class="container center-block">
		<div class="row table4" id="table4">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 img-thumbnail">
				<form action="view.html" method="get" accept-charset="utf-8">
				<h2 style="text-align: center;">Quản lý bảo hiểm</h2>
				<table class="table table-condensed form-group">
					<tr>
						<td><h3>Loại bảo hiểm</h3></td>
						<td><h3 style="text-align: center;">Loại oto</h3></td>
					</tr>
					<%
						ArrayList<Baohiem> list = new ArrayList<Baohiem>();
						Controller conl = new Controller();
						HttpServletRequest req;
						request.setAttribute("listBaohiem", conl.LayDuLieuBaohiem());
						list = (ArrayList<Baohiem>) request.getAttribute("listBaohiem");
						for(int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><input type="hidden" value="<%= list.get(i).getPackagecartype() %>"><%= list.get(i).getPackagecartype() %></td>
						<td><input type="hidden" value="<%= list.get(i).getCartype() %>"><%= list.get(i).getCartype() %></td>
					</tr>
					<% } %>
					<tr>
						<td><button type="button" class="btn btn-success" name="act" id="themgoibaohiem">Thêm gói bảo hiểm</button></td>
						<td><button type="submit" class="btn btn-primary" name="act" value="goback">Quay lại</button></td>
					</tr>
				</table>
			</form>
			</div>
			<div class="col-md-3">
			</div>
		</div>
		<div class="row table5" id="table5">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 img-thumbnail">
				<form action="view.html" method="get" accept-charset="utf-8">
				<h2 style="text-align: center;">Thêm bảo hiểm</h2>
				<table class="table table-condensed form-group">
					<tr>
						<td><h3>Loại bảo hiểm</h3></td>
						<td><h3 style="text-align: center;">Năm sản xuất</h3></td>
					</tr>
					<tr>
						<td><input type="text" name="tengoi" value="" class="form-control"></td>
						<td><input type="number" min="1938" max="2100" name="namsx" value="" class="form-control"></td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-success" name="act" value="thembaohiem">Thêm</button></td>
						<td><button type="button" class="btn btn-danger" id="back">Hủy</button></td>
					</tr>
				</table>
			</form>
			</div>
			<div class="col-md-3">
			</div>
		</div>
	</div>
</body>
</html>