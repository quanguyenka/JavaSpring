<%@page import="object.Oto"%>
<%@page import="controller.Controller"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Quản lý xe</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/view.css">
<script type="text/javascript" src="./js/view.js"></script>
</head>
<body>
	<div class="container img-thumbnail center-block">
		<div class="row table1" id="table1">

			<h2 style="text-align: center;">QUẢN LÝ OTO</h2>
			<div class="table table-condensed">
				<div class="thead">
					<div class="tr">
						<span class="th col-md-1">STT</span> <span class="th col-md-1">Chọn</span>
						<span class="th col-md-1">Mã xe</span> <span class="th col-md-1">Hãng
							xe</span><span class="th col-md-1">Loại xe</span> <span
							class="th col-md-2">Giá xe</span> <span class="th col-md-1">Năm
							sx</span> <span class="th col-md-2">Gói bảo hiểm</span> <span
							class="th col-md-1">Số lượng</span> <span class="th col-md-1">Thao
							tác</span>
					</div class ="tr">
				</div class="thead">
				<div class="tbody">
					<%
						ArrayList<Oto> listOto = new ArrayList<Oto>();
						HttpServletRequest req;
						listOto = (ArrayList<Oto>) request.getAttribute("listOto");
						for (int i = 0; i < listOto.size(); i++) {
					%>
					<form action="view.html" method="get" accept-charset="utf-8"
						class="form-group">
						<div class="tr">
							<span class="td col-md-1" id="stt"><%=i%></span> <span
								class="td col-md-1"><input type=checkbox></span> <span
								class="td col-md-1"><%=listOto.get(i).getMaXe()%><input
								type="hidden" name="maxe"
								value="<%=listOto.get(i).getMaXe().trim()%>" id="maxe"></span>
								
								<span class="td col-md-1" id="hangxe"><%=listOto.get(i).getHangXe()%><input
								type="hidden" name="hangxe"
								value="<%=listOto.get(i).getHangXe().trim()%>"></span>
								
								<span class="td col-md-1" id="hangxe"><%=listOto.get(i).getLoaixe()%><input
								type="hidden" name="loaixe"
								value="<%=listOto.get(i).getLoaixe().trim()%>"></span>
								
								<span
								class="td col-md-2"><%=listOto.get(i).getGiaXe()%><input
								type="hidden" name="giaxe"
								value="<%=listOto.get(i).getGiaXe()%>"></span> <span
								class="td col-md-1"><%=listOto.get(i).getNamSx()%><input
								type="hidden" name="namsx"
								value="<%=listOto.get(i).getNamSx()%>"></span> <span
								class="td col-md-2"><%=listOto.get(i).getBaoHiem()%><input
								type="hidden" name="baohiem"
								value="<%=listOto.get(i).getBaoHiem().trim()%>"></span> <span
								class="td col-md-1"><%=listOto.get(i).getSoLuong()%><input
								type="hidden" name="luong"
								value="<%=listOto.get(i).getSoLuong()%>"></span> <span
								class="td col-md-1"><button type="submit" name="act"
									value="update" id="update" class="btn btn-warning">Sửa</button>
								<button type="submit" class="btn btn-danger" id="Xoa" name="act"
									value="delete">Xóa</button> </span>
						</div>
					</form>
					<%
						}
						listOto.clear();
					%>
					<form action="view.html" method="get" accept-charset="utf-8"
						class="form-group">
						<div class="tr">
							<span class="td" colspan="4"><input type="button" name=""
								id="Them" value="Thêm" class="btn btn-info"> <input
								type="button" name="" value="Xóa" class="btn btn-danger">
								<input type="button" name="" value="Tìm kiếm"
								class="btn btn-primary">
								<button type="submit" name="act" value="qlbh"
									class="btn btn-success">Quản lý bảo hiểm</button> <input
								type="number" min="5" max="30" class="input-hienthi"
								name="soluonghienthi">
								<button type="submit" name="act" value="hienthigioihan"
									class="btn" style="background: #029000; color: #fff;">Hiển
									thị giới hạn</button></span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row table2">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2 style="text-align: center;">THÊM OTO</h2>
				<form action="view.html" name="act" value="insert" method="get"
					accept-charset="utf-8" method="get" class="form-group">
					<table class="center-block img-thumbnail" style="padding: 32px;">
						<tbody>
							<tr>
								<td>Mã xe:</td>
								<td><input type="text" name="maxe" required
									placeholder="Nhập mã xe" class="form-control"></td>
							</tr>
							<tr>
								<td>Hãng xe:</td>
								<td><input type="text" name="hangxe" required
									placeholder="Nhập hãng xe" class="form-control"></td>
								<td><p id="hangxe"></p></td>
							</tr>
							<tr>
								<td>Giá xe:</td>
								<td><input type="text" name="giaxe" required
									placeholder="Nhập giá xe" class="form-control"></td>
								<td><p id="giaxe"></p></td>
							</tr>
							<tr>
								<td>Năm sản xuất:</td>
								<td><input type="text" name="namsanxuat" required
									placeholder="Nhập năm sản xuất" class="form-control"></td>
								<td><p id="namsanxuat"></p></td>
							</tr>
							<tr>
								<td>Gói bảo hiểm:</td>
								<td><input type="text" name="goibaohiem" required
									placeholder="Nhập gói bảo hiểm" class="form-control"></td>
								<td><p id="goibaohiem"></p></td>
							</tr>
							<tr>
								<td>Số lượng:</td>
								<td><input type="text" name="soluong" required
									placeholder="Nhập số lượng" class="form-control"></td>
								<td><p id="soluong"></p></td>
							</tr>
							<tr>
								<td colspan="2"><button type="submit" name="act"
										value="insert" class="btn btn-success" id="ThemOto">Thêm</button></td>
								<td><a class="btn btn-danger" id="Huy">Hủy</a></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>

	</div>
</body>
</html>