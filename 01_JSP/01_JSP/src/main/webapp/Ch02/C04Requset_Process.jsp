<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8"); //공식
%>
   <jsp:useBean id="dto" class="Ch02.ProfileDto" scope="request" />
   <jsp:setProperty name="dto" property="*" /> 
   <!-- property="*" -> set 함수를 통해서 파라미터로 넘어오는걸 넣어줌 -->
<%
	System.out.println("dto : "+dto);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>서버 컴퓨터 Process File</h1>
	
	ProfileDto : <%=dto %><br>
</body>
</html>