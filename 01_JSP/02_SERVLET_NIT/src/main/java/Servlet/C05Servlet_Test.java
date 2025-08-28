package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class C05Servlet_Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//페이지 전송
		System.out.println("GET /login.do...");
		
		HttpSession session=req.getSession();
		if(session.getAttribute("message")!=null) {		//(get)메세지 내용 꺼내오기 = 널값이 아니면 ↓
			String message=(String)session.getAttribute("message");
			session.removeAttribute("message");			//메세지 내용 제거
			
			req.setAttribute("message", message);
		}
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원가입 처리용
		System.out.println("POST /login.do...");
		//01 파라미터
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		
		//02 유효성
		if(!isValid(userid,password,req)) {
			//로그인완료 페이지로 이동(message 전달)
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			return;
		}
		
		//03 서비스처리(로그인 처리)
		// 사용자 ID
		// 입력한 PW 일치 여부 (대조)
		// 인증완료 정보 + ROLE(권한) 저장
		try {
			DbUtils.conn();
			UserDto dto=DbUtils.selectUser(userid);
			if(dto==null) {
				req.setAttribute("message", "동일한 ID가 존재하지 않습니다.");
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				return;
			}
			if(!password.equals(dto.getPassword())) {
				req.setAttribute("message", "PW가 일치하지 않습니다.");
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				return;
			}
			DbUtils.disConn();
			// 인증완료 정보 + ROLE 저장 - SESSION
			HttpSession session=req.getSession();
			session.setAttribute("userid", userid);
			session.setAttribute("isAuth", true);	//로그인 인증
			session.setAttribute("role", "ROLE_USER");	//권한 부여
			
			//04 뷰로이동(뷰로 데이터 전송)
			session.setAttribute("message", "로그인 성공!");
			resp.sendRedirect(req.getContextPath()+"/main.do");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	public boolean isValid(String userid, String password, HttpServletRequest req) {
		boolean flag=true;
		if(userid.isEmpty()) {
			req.setAttribute("userid_msg","ID를 입력하세요");
			flag=false;
		}
		if(password.isEmpty()) {
			req.setAttribute("password_msg", "PW를 입력하세요");
			flag=false;
		}
		return flag;
	}
}
