'use strict';

$(document).ready(function() {
	
	// btn
	$("#btn_save").click(function(e) {
		
		// submit event를 막기위해..
		if(e.isDefaultPrevented()) {
    			return;
    		} 

		upload();
		
		e.preventDefault();
	});
	
});

function upload() {
	var callback = function() {
		window.location.href = '/web/job/list';
	}
	var form = $("#uploadForm")[0];
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/admin/fileUpload",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
	        	if(data === 'success') {
	        		alert("파일 업로드 성공!!");
	        	} else {
	        		alert(data);
	        	}
        },
        error: function (xhr, status, error) {
        		alert(xhr.responseJSON.message);
        }
    });
}