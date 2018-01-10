<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h1>/admin/user/add</h1>
	
	<form id="userForm" name="userForm" action="" method="post">
		<fieldset>
		 <legend>사용자 추가</legend>
		 <ol>
		  <li>
		   <label for="userId">아이디</label>
		   <input type="text" id="userId" name="userId" placeholder="아이디를 입력하세요." required />
		  </li>
		  <li>
		   <label for="userName">이름</label>
		   <input type="text" id="userName" name="userName" placeholder="이름을 입력하세요." required />
		  </li>
		  <li>
		   <label for="email">이메일</label>
		   <input type="email" id="email" name="email" placeholder="이메일을 입력하세요." required />
		  </li>
		 </ol>
		</fieldset>
		<button id="btnAddUser" type="submit" style="width:100px;height:20px;">저장</button>
		<button id="btnCancel" type="button" style="width:100px;height:20px;">취소</button>
	</form>
</div>

<script src="/js/admin/userManage/addUser.js"></script>
