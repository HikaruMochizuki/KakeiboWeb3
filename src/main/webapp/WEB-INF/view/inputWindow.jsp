<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Input Window</title>
</head>
<body>
	<form:form modelAttribute="inputWindowForm" method="POST">
		<form:input path="purchaceDate" />
		<form:input path="purchaceSum" />
		<input type="submit">
	</form:form>
</body>
</html>