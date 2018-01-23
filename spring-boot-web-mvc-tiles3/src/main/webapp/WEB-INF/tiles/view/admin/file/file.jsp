<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Spring Boot file upload example</h1>

<form method="POST" id="uploadForm" action="" enctype="multipart/form-data">
	유저명 : <input type="text" id="userName" name="userName" /><br/><br/>
    파일선택 : <input type="file" name="file" /><br/><br/>
    <button type="submit" id="btn_save">Save</button>
</form>

<script src="/js/admin/file/file.js"></script>