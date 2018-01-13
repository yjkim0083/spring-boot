'use strict';

$(document).ready(function() {
	
	// 페이징 관련 값들을 리셋한다.
    pagingReset({
        rowsPerPage : 5
    });
    
	// button click event
	$("#btnAddUser").click(function(e){
		window.location.href="/admin/user/add";
	});
	
	search();
});

function search() {
	$.ajax({
		 type: "GET", 
		 dataType: "json",
		 url: "/admin/user/list",
		 //data: JSON.stringify(paging),
		 data: paging,
		 success: function(result) {
			 buildHtmlTable(result.list);
			 paging.totalCount = result.totalCnt;
			 pagingMake();
		 },
		 error: function(jqXHR, textStatus, errorThrown) {
			 alert(textStatus + ' : ' + errorThrown);
		 }
	});
}

function buildHtmlTable(data) {
	
	var html = '';
	$("#userManageTable").html(html);
	
	$(data).each(function() {
		
		html += '<tr>' +
		'<td>' + this.rowNum + '</td>' +
	    '<td>' + this.userId + '</td>' +
	    '<td> <a href=/admin/user/' + this.userId + '>' + this.userName + '</a></td>' +
	    
	    '<td>' + this.email + '</td>' +
	    '<td>' + this.createTime + '</td>' +
	    '</tr>';
	});

    $("#userManageTable").append(html);
}


