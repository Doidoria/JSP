<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	/*
		request 내장객체 : 요청정보값	
	*/
	/* 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8"); //공식

	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String bgcolor=request.getParameter("bgcolor");
	System.out.printf("%s %s %s \n",username,password,bgcolor);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:<%=bgcolor%>">
	<h1>서버 컴퓨터 Process File</h1>
	
	username : <%=username %><br>
	password : <%=password %><br>
</body>
</html>