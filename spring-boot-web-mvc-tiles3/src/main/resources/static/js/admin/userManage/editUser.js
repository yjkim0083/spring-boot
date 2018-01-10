'use strict';

$(document).ready(function() {
	
	var data = {
		userId:'',
		userName:'',
		email:''
	};
	
	var userId = $("#hiddenUserId").val();
	$.ajax({
		 type: "GET", 
		 dataType: "json",
		 url: "/admin/user/info/" + userId,
		 success: function(result) {
			 $("#userId").val(result.userId);
			 $("#userName").val(result.userName);
			 $("#email").val(result.email);
		 },
		 error: function(jqXHR, textStatus, errorThrown) {
			 alert(textStatus + ' : ' + errorThrown);
		 }
	});
	
	var callback = function(){
		window.location.href = '/admin/user';
	}
	
	// 수정
	$("#userForm").submit(function(e) {
		if(e.isDefaultPrevented()) {
			return;
		} 
		
		data.userId = $("#userId").val();
		data.userName = $("#userName").val();
		data.email = $("#email").val();
	    
		$.ajax({
			cache: false,
			url: '/admin/user',
			data: JSON.stringify(data),
			type: 'PUT',
			contentType: 'application/json',
			success: function(result) {
				alert("수정 성공!!");
				callback();
			},
			 error: function(xhr, status, error) {
				 alert("수정 실패 : " + xhr.responseJSON);
	         }
		});
		
		e.preventDefault();
	});
		

	// 취소
	$("#btnCancel").click(function(e){
		window.location.href="/admin/user";
	});
	
	// 삭제
	$("#btnDeleteUser").click(function(e){
		
		$.ajax({
			cache: false,
			url: '/admin/user',
			data: JSON.stringify({userId:$("#userId").val()}),
			type: 'DELETE',
			contentType: 'application/json',
			success: function(result) {
				alert("삭제 성공!!");
				callback();
			},
			 error: function(xhr, status, error) {
				 alert("삭제 실패 : " + xhr.responseJSON);
	         }
		});
	});
});