<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>USER NAME</h1>
	<form action="view.jsp">
		<table>
			<tr>
				<td>Enter your name: </td>
				<td><input name="name"><br></td>
			</tr>
			<tr>
				<td>Enter your password:</td>
				<td><input name="pass" type="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><button formmethod="get">OK</button></td>
			</tr>
		</table>		 
		
	</form>
</body>
</html>