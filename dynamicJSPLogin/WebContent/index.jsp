<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	Hi, Mahesh here ...

	<form action="loginMe" method="get" style="width: 300px">
		Username: <input type="text" name="userName" /> Password: <input
			type="password" name="password" />
		<button class="btn btn-primary" type="submit" name="submit"
			value="login">call loginServlet via get call</button>
	</form>

	<hr>
	<form action="loginMe" method="post" style="width: 300px">
		Username: <input type="text" name="userName" /> Password: <input
			type="password" name="password" />
		<button class="btn btn-primary" type="submit" name="submit"
			value="login">call loginServlet Via Post call</button>
	</form>
</body>
</html>