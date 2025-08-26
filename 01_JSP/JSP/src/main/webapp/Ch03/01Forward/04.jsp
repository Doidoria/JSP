<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>04.JSP PAGE</h1>
	username : ${param.username}<br>
	password : ${param.password}<br>
	C02_value : ${C02}<br>
	C03_value : ${C03}<br>
</body>
</html>