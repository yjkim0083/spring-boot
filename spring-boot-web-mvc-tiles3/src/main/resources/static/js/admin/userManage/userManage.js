'use strict';

$(document).ready(function() {

	$.ajax({
		 type: "GET", 
		 dataType: "json",
		 url: "/admin/user/list",
		 success: function(result) {
			 buildHtmlTable(result);
		 },
		 error: function(jqXHR, textStatus, errorThrown) {
			 alert(textStatus + ' : ' + errorThrown);
		 }
	});
	
	// button click event
	$("#btnAddUser").click(function(e){
		window.location.href="/admin/user/add";
	});
});

function buildHtmlTable(data) {
	
	var html = '';
	
	$(data).each(function() {
		
		html += '<tr>' +
	    '<td>' + this.userId + '</td>' +
	    '<td> <a href=/admin/user/' + this.userId + '>' + this.userName + '</a></td>' +
	    
	    '<td>' + this.email + '</td>' +
	    '<td>' + this.createTime + '</td>' +
	    '</tr>';
	});

    $("#userManageTable").append(html);
}


