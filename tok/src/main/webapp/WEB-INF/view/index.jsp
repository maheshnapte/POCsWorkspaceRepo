<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tok</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>

<%-- <link href='<spring:url value="/assets/myCss.css"/>' rel="stylesheet"> --%>

<link rel="stylesheet" type="text/css" href="assets/myCss.css">
<script src="assets/myscripts.js"></script>

</head>
<body>
	<p class="mah">Mahesh</p>

	<button>Get Token</button>
	<input type="text" name="token" readonly>
	<br>

	<form action="index.jsp">
		<input type="text" name="uname" value="Name..." onclick="this.value=''" /><br /> 
		<input type="text" name="uemail" value="Email ID..." onclick="this.value=''" /><br />
		<input type="password" name="upass" value="Password..." onclick="this.value=''" /><br />
		<input type="submit" value="register" />
	</form>

      <form id="tok_form" action="getTokenP" method="post">
         Name : <input type = "text" name = "name" />
         <br>
         Mobile Number : <input type = "text" name = "mob_no" />
         <input type = "reset" name = "reset"  value = "Reset" />
         <input type = "submit" name = "submit" value = "Submit" />         
      </form>

</body>
</html>