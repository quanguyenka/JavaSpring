<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/update.js"></script>
</head>
<body>
	<div class="container img-thumbnail center-block">
		<div class="row table3" id="table3">
			<form action="view.html" method="get" accept-charset="utf-8">
				<h3>Chỉnh sửa thông tin</h3>
				<table class="table table-condensed form-group">
					<tbody>
						<tr>
							<td>Mã xe</td>
							<td><input type="text" name="maxe" value="${ maxe }" placeholder=""
								class="form-control"></td>
						</tr>
						<tr>
							<td>Hãng xe</td>
							<td><input type="text" name="hangxe" value="${ hangxe }" placeholder=""
								class="form-control"></td>
						</tr>
						<tr>
							<td>Giá xe</td>
							<td><input type="text" name="giaxe" value="${ giaxe }" placeholder=""
								class="form-control"></td>
						</tr>
						<tr>
							<td>Năm sx</td>
							<td><input type="text" name="namsx" value="${ namsx }" placeholder=""
								class="form-control"></td>
						</tr>
						<tr>
							<td>Gói bảo hiểm</td>
							<td><input type="text" name="baohiem" value="${ baohiem }" placeholder=""
								class="form-control"></td>
						</tr>
						<tr>
							<td>Số lượng</td>
							<td><input type="text" name="soluong" value="${ soluong }" placeholder=""
								class="form-control"></td>
						</tr>
						<tr>
							<td><button type="submit" name="act" value="updateform"
								class="btn btn-success">Sửa</button></td>
							<td><a type="button" class="btn btn-danger" onclick="goBack()" value="huy" name="act">Hủy</a></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>