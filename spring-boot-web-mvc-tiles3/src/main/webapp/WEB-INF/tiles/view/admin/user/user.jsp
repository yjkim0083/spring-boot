<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
th, td {
    padding: 15px;
}
</style>

<div>
	<h1>/admin/user</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>생성시간</th>
		</tr>
		<c:forEach var="item" items="${userList}" varStatus="index">
			<tr>
				<td>${item.userId}</td>
				<td>${item.userName}</td>
				<td>${item.email}</td>
				<td>${item.createTime}</td>
			</tr>
		</c:forEach>
	</table>
	
</div>
<div>
	<button id="addUser" style="width:100px;height:20px;">추가</button>
	<button id="editUser" style="width:100px;height:20px;">수정</button>
	<button id="deleteUser" style="width:100px;height:20px;">삭제</button>
</div>