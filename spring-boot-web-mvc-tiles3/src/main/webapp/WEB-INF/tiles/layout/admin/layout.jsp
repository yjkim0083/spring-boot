<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
		<title><tiles:getAsString name="title" /></title>
		
		<!-- jquery -->
		<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<header>
			<!-- Header -->
			<tiles:insertAttribute name="header" />
		</header>
		<section>
			<!-- Body -->
			<tiles:insertAttribute name="body" />
		</section>
		<footer>
			<!-- Footer -->
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>