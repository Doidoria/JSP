<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//01 파라미터 확인
	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	
	//02 유효성 검사
	if(userid.isEmpty()){	//userid 칸에 공백일 경우
		request.setAttribute("userid_msg", "ID를 입력하세요");
		request.getRequestDispatcher("./login_form.jsp").forward(request,response);		//로그인폼으로 되돌리기
		return ;	//분기처리, 여러번 포워딩하는 경우 return 처리 해야됨
	}
	if(password.isEmpty()){	//password 칸에 공백일 경우
		request.setAttribute("password_msg", "PW를 입력하세요");
		request.getRequestDispatcher("./login_form.jsp").forward(request,response);		//로그인폼으로 되돌리기
		return ;	//분기처리, 여러번 포워딩하는 경우 return 처리 해야됨
	}
	
	//03 관련 서비스 실행
	
	//03-01) userid와 동일한 계정이 있는지 확인 가져와야함
	if(!userid.equals("admin")){
		request.setAttribute("userid_msg", "해당 계정은 존재하지 않습니다");
		request.getRequestDispatcher("./login_form.jsp").forward(request,response);		//로그인폼으로 되돌리기
		return ;	//분기처리, 여러번 포워딩하는 경우 return 처리 해야됨
	}
	
	//03-02) password의 값이 입력한 값이랑 동일한지 확인
	if(!password.equals("1234")){
		request.setAttribute("password_msg", "비밀번호가 일치하지 않습니다");
		request.getRequestDispatcher("./login_form.jsp").forward(request,response);		//로그인폼으로 되돌리기
		return ;	//분기처리, 여러번 포워딩하는 경우 return 처리 해야됨
	}
	
	//03-03) session에 해당 계정에 작업에 필요한 속성들을 저장
	session.setAttribute("isAuth", true);
	session.setAttribute("role", "ROLE_ADMIN");		//권한 페이지 제한 (사용자 정보란에 role값도 저장되어야 함)
	session.setMaxInactiveInterval(30); 	//30초만 세션유지

	//04 뷰로 이동
	response.sendRedirect("./main.jsp");
	
%>