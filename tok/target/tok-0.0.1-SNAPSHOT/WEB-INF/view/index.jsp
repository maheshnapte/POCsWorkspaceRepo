<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tok</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="assets/myCss.css">
<script src="assets/myscripts.js"></script>

</head>
<body>
	<p class="mah">Token Number:</p>
	<p id="token" class="mah"></p>

	<form id="tok_form">
		<div class="row">
			<div class="col-25">
				<label for="fname">Your Name</label>
			</div>
			<div class="col-75">
				<input type="text" id="name_" name="mob_no"
					placeholder="Your name..">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="lname">Your contact Number</label>
			</div>
			<div class="col-75">
				<input type="text" id="mob_" name="lastname"
					placeholder="Your contact no..">
			</div>
		</div>
		<div class="row">
			<input type="submit" id="fSub" name="submit" value="Submit">
		</div>
	</form>

</body>
</html>