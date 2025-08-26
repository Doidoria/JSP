<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	request.setAttribute("C02", "C02_value");
	//Forwarding
	request.getRequestDispatcher("./03.jsp").forward(request,response);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>02.JSP PAGE</h1>
	username : <%=username %><br>
	password : <%=password %><br>
</body>
</html>