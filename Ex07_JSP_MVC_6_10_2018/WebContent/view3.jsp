<%@page import="object.Baohiem"%>
<%@page import="object.Khachhang"%>
<%@page import="controller.Controller"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Danh sách Oto</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/view.js"></script>
<script type="text/javascript" src="./js/update.js"></script>
</head>
<body>
	<div class="container center-block">
		<div class="row table6" id="table6">
			<div class="col-md-3"></div>
			<div class="col-md-6 img-thumbnail">
				<form action="view.html" method="get" accept-charset="utf-8">
					<h2 style="text-align: center;">Quản lý xe của bạn</h2>
					<table class="table table-condensed form-group">
						<tr>
							<td><h3>Mã oto</h3></td>
							<td><h3>Loại oto</h3></td>
							<td><h3>Loại bảo hiểm</h3></td>
							<td></td>
						</tr>
						<%
							Controller conl = new Controller();
							ArrayList<Khachhang> list = new ArrayList<Khachhang>();
							HttpServletRequest req;
							list = (ArrayList<Khachhang>) request.getAttribute("listKhachhang");

							for (int i = 0; i < list.size(); i++) {
						%>
						<tr>
							<td><input type="hidden" name="carCode"
								value="<%=list.get(i).getCarCode().trim()%>"><%=list.get(i).getCarCode().trim()%></td>
							<td><input type="hidden" name="packagetype"
								value="<%=list.get(i).getCartype().trim()%>"><%=list.get(i).getCartype().trim()%></td>
							<td><input type="hidden" name="packagetype"
								value="<%=list.get(i).getPackagetype().trim()%>"><%=list.get(i).getPackagetype().trim()%></td>
							<td>
								<button type="submit" name="act" value="mua"
									class="btn btn-success">Mua</button>
								<button type="submit" name="act" value="thaydoi"
									class="btn btn-info">Thay đổi</button>
							</td>
						</tr>
						<%
							}
							list.clear();
						%>
					</table>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>

		<div class="row table7" id="table7">
			<div class="col-md-3"></div>
			<div class="col-md-6 img-thumbnail">
				<form action="view.html" method="get" accept-charset="utf-8">
					<h2 style="text-align: center;">Mua bảo hiểm</h2>
					<table class="table table-condensed form-group">
						<tr>
							<td><h3>Gói bảo hiểm</h3></td>
							<td><h3 style="text-align: center;">Loại oto</h3></td>
							<td></td>
							<td></td>
						</tr>
						<%
							ArrayList<Baohiem> listbh = new ArrayList<Baohiem>();
							request.setAttribute("listBaohiem", conl.LayDuLieuBaohiem());
							listbh = (ArrayList<Baohiem>) request.getAttribute("listBaohiem");
							System.out.println(listbh);
							for (int i = 0; i < listbh.size(); i++) {
						%>
						<tr>
							<td><input type="hidden"
								value="<%=listbh.get(i).getPackagecartype()%>"><%=listbh.get(i).getPackagecartype()%></td>
							<td><input type="hidden"
								value="<%=listbh.get(i).getCartype()%>"><%=listbh.get(i).getCartype()%></td>
							<td><button type="button" class="btn btn-success" name="act"
									id="mua">Mua</button></td>
							<td><button type="button" class="btn btn-danger" name="act"
									onclick="goBack()">Quay lại</button></td>
						</tr>
						<%
							}
						%>
					</table>
				</form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>