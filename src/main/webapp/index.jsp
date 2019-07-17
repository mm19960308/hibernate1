<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>index.jsp</h3>
	<table border="1px">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>birthday</td>
			<td>money</td>
			<td>operation</td>
		</tr>
		<c:forEach items="${list }" var="l">
			<tr>
				<td>${l.id }</td>
				<td>${l.name }</td>
				<td>${l.birthday }</td>
				<td>${l.money }</td>
				<td>
				<a href="User_delete?id=${l.id }">delete</a>
				|
				<a href="UpdateUI.jsp">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>