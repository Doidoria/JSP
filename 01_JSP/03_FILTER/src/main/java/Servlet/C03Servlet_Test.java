package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main.do")
public class C03Servlet_Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /main.do...");
		
		HttpSession session=req.getSession();
		if(session.getAttribute("message")!=null) {		//(get)메세지 내용 꺼내오기 = 널값이 아니면 ↓
			String message=(String)session.getAttribute("message");
			session.removeAttribute("message");			//메세지 내용 제거
			
			req.setAttribute("message", message);
		}
		
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp); //기본 리다이렉트, 포워딩으로만 접근 가능 (main.jsp)
	}
	
}
