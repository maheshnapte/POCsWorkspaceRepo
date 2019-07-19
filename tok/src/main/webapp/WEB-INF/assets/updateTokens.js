$(document).ready(function() {

	$("button").click(function() {
		$.ajax('getAllTokens', {
			dataType : 'json', // type of response data
			//timeout : 5000, // timeout milliseconds
			success : function(data, status, xhr) { // success callback
				// function
				// var data1 = $.parseJSON(data);
				
			//	$('#tableDiv').html('<tr><th>Name</th><th>Mobile Number</th><th>Token</th><th>Is Priviledged</th></tr>');
				  
				var table_body = '<table border="1"> <tr><th>Name</th><th>Mobile Number</th><th>Token</th><th>Is Priviledged</th></tr>';

				$(data).each(function(i, val) {
					console.log(i + " : " + val);
					table_body += '<tr>';
					table_body += '<td>';
					table_body += val.name;
					table_body += '</td>';

					table_body += '<td>';
					table_body += val.mobileNo;
					table_body += '</td>';

					table_body += '<td>';
					table_body += val.token;
					table_body += '</td>';

					table_body += '<td>';
					table_body += val.isPriviledged;
					table_body += '</td>';

					table_body += '</tr>';
				});

				table_body += '</table>';
				$('#tableDiv').html(table_body);
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