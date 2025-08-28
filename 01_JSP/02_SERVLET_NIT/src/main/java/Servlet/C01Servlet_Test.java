package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//Request 요청 - 서블릿파일매핑 - 요청처리 - 결과 반환(웹페이지)

@WebServlet("/TEST_01")
public class C01Servlet_Test extends HttpServlet{

	@Override
	public void init() throws ServletException {
		//서블릿 최초 실행함수
		System.out.println("INIT() invoke...");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//요청시마다 동작하는 함수
		System.out.println("SERVICE() invoke...");
	}

	@Override
	public void destroy() {
		//내용 변경시 동작하는 함수
		System.out.println("DESTORY() invoke...");
	}
	
}
