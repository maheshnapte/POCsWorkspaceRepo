<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC</title>
</head>
<body>

<%
String sessionObj = (String)request.getSession().getAttribute("foodItems");
String s = (String)request.getAttribute("foodItems");
String pp = "Mahesh";
%>

MVC
<p>  <%=s%> </p>
<p>  <%=s%> </p>
<p>  <%=pp%> </p>

</body>
</html>

