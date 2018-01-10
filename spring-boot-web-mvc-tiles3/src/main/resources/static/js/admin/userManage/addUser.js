'use strict';

$(document).ready(function() {
	
	var data = {
		userId:'',
		userName:'',
		email:''
	};
	
	// button click event
	$("#userForm").submit(function(e) {
		if(e.isDefaultPrevented()) {
			return;
		} 
		
		data.userId = $("#userId").val();
		data.userName = $("#userName").val();
		data.email = $("#email").val();
		
		var callback = function(){
			window.location.href = '/admin/user';
		}
	    
		$.ajax({
			cache: false,
			url: '/admin/user',
			data: JSON.stringify(data),
			type: 'POST',
			contentType: 'application/json',
			success: function(result) {
				alert("등록 성공!!");
				callback();
			},
			 error: function(xhr, status, error) {
				 alert("등록 실패 : " + xhr.responseJSON);
	         }
		});
		
		e.preventDefault();
	});
		

	
	$("#btnCancel").click(function(e){
		window.location.href="/admin/user";
	});
	
	
});