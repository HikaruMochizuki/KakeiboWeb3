<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Input Window</title>
	<!-- カレンダーアイコン設定要javascript&css -->
	<link href="<c:url value="/resources/css/jquery-ui.theme.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/jquery-ui.structure.css" />" rel="stylesheet">
	<script type="text/javascript" src=<c:url value="/resources/js/jquery-3.3.1.min.js" />></script>
	<script type="text/javascript" src=<c:url value="/resources/js/jquery-ui.min.js" />></script>
	<script type="text/javascript" src=<c:url value="/resources/js/datepicker-ja.js" />></script>
	<script type="text/javascript">
		$(function(){
			$('#jquery-ui-datepicker').datepicker({
				showOn: "button",
				buttonImage: "resources/icon/calendar.png",
				buttonImageOnly: true
			});
		});
	</script>
</head>
<body>
	<h2>${message}</h2>
	<!-- レシート登録フォーム -->
	<form:form modelAttribute="inputWindowForm" method="post">
	<!-- 入力チェックエラーメッセージ -->
	<div><form:errors path="*" /></div>
		<table>
			<tbody>
				<tr>
					<td><form:label path="purchaceDate">購入日：</form:label></td>
					<td><form:input path="purchaceDate" id="jquery-ui-datepicker" /></td>
				</tr>
				<tr>
					<td><form:label path="purchaceSum">購入金額：</form:label></td>
					<td><form:input path="purchaceSum" /></td>
					<td><form:label path="purchaceSum">円</form:label></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="登録">
	</form:form>
	<!-- レシート一覧 -->
	<c:if test="${not empty receiptList}">
		<table border="1">
			<tbody>
				<tr>
					<th>購入日</th>
					<th>購入金額</th>
				</tr>
				<c:forEach var="receipt" items="${receiptList}">
					<tr>
						<td><c:out value="${receipt.purchaceDate}"></c:out></td>
						<td><c:out value="${receipt.purchaceSum}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>