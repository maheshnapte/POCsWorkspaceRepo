$(document).ready(function() {
	$("button").click(function() {
		$.ajax('getToken', {
			dataType : 'json', // type of response data
			timeout : 500, // timeout milliseconds
			success : function(data, status, xhr) { // success callback
				// function
				$('p').append(data.tokId + ' ' + data.tokenId);
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback
				$('p').append('Error: ' + errorMessage);
			}
		});
	});

	$("#fSub").click(function(e) {
		e.preventDefault(); // avoid to execute the actual
		// submit of the form.
		var form = $(this);
		var myData = new Object();
		myData.name = $("#name_").val();
		myData.mobileNo = $("#mob_").val();

		$.ajax({
			datatype : "application/json",
			contentType : "application/json",
			type : "POST",
			url : "getTokenP", // type of response data
			data : JSON.stringify(myData),
			success : function(data, status, xhr) { // success
				// callback
				// function
				$('#token').text(data.token);
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback
				$('p').append('Error: ' + errorMessage);
			}

		});

	});
});