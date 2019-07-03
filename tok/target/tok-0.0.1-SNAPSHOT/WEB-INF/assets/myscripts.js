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
});