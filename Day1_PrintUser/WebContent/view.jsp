
<%@ page pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO USER</h1>
	<jsp:useBean id="bean" scope="session" class="itsol.Controller"></jsp:useBean>
	<jsp:setProperty property="name" name="bean"/>
	<h1>User name:  <jsp:getProperty property="name" name="bean"/></h1>
	<jsp:setProperty property="pass" name="bean"/>	
    <h1>Your password: <jsp:getProperty name="bean" property="pass" /> !</h1>
	
</body>
</html>