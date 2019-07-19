<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update tokens</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="assets/myCss.css">
<script src="assets/updateTokens.js"></script>

</head>
<body>
	<p id="token" class="mah"></p>

	<!-- 	<form id="up_form">
		<div class="row">
			<div class="col-25">
				<label for="fname">From Date</label>
			</div>
			<div class="col-75">
				<input type="date" id="from_" name="from" placeholder="Your name..">
			</div>
		</div>
		<div class="row">
			<div class="col-25">
				<label for="lname">To Date</label>
			</div>
			<div class="col-75">
				<input type="date" id="to_" name="to"
					placeholder="Your contact no..">
			</div>
		</div>
		<div class="row">
			<button id="ss">getAllTokens</button>
		</div>
	</form> -->

	<button id="ss">getAllTokens</button>
	<div id="tableDiv">table data</div>

</body>
</html>