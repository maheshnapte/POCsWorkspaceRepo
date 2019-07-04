$(document).ready(function() {
	$("button").click(function() {

		/* $.ajax({
		       type: 'GET',
		       url: rootURL,
		       dataType: "json", // data type of response
		       success: renderList
		   });*/

		$.ajax('getToken', {
			dataType : 'json', // type of response data
			timeout : 500, // timeout milliseconds
			success : function(data, status, xhr) { // success callback function
				$('p').append(data.tokId + ' ' + data.tokenId);
			},
			error : function(jqXhr, textStatus, errorMessage) { // error callback 
				$('p').append('Error: ' + errorMessage);
			}
		});
	});

	$("#tok_form").submit(function(e) {
		e.preventDefault(); // avoid to execute the actual submit of the form.

		var form = $(this);
		var url = form.attr('action');

		$.ajax({
			type : "POST",
			dataType : 'json', // type of response data
			timeout : 500, // timeout milliseconds
			success : function(data, status, xhr) { // success callback function
				$('p').append(data.tokId + ' ' + data.tokenId);
			},
			error : function(jqXhr, textStatus, errorMessage) { // error callback 
				$('p').append('Error: ' + errorMessage);
			}

		//type: "POST",
		/*      url: url,
		      data: form.serialize(), // serializes the form's elements.
		 */
		});

	});
});