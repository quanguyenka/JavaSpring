<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="container center-block">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 img-thumbnail LoginForm">
				<h3 style="text-align: center;">Đăng nhập</h3>
				<form action="index.html">
					<table>
						<tr>
							<td>Tên đăng nhập:</td>
							<td><input type="text" class="form-control" name="name"></td>
						</tr>
						<tr>
							<td>Mật khẩu:</td>
							<td><input type="password" class="form-control" name="pass"></td>
						</tr>
						<tr>
							<td><button type="submit" formmethod="post" class="btn btn-success" name="type" value="manage">Quản lý</button></td>
							<td><button type="submit" formmethod="post" class="btn btn-success" name="type" value="customer">Khách hàng</button></td>
						</tr>
						<tr>
							<td colspan="2"><p name="err" style="color: red">${ err }</p></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
</body>
</html>