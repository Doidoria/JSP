package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//Request 요청 - 서블릿파일매핑 - 요청처리 - 결과 반환(웹페이지)

public class C02Servlet_Test extends HttpServlet{

	@Override
	public void init() throws ServletException {
		//서블릿 최초 실행함수
		System.out.println("C02Servlet_Test's INIT() invoke...");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//요청시마다 동작하는 함수
		System.out.println("C02Servlet_Test's SERVICE() invoke...");
	}

	@Override
	public void destroy() {
		//내용 변경시 동작하는 함수2
		System.out.println("C02Servlet_Test's DESTORY() invoke...");
	}
	
}
