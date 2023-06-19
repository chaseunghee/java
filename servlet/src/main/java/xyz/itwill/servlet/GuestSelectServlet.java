package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	GUEST 테이블에 저장된 모든 행을 검색하여 클라이언트에게 전달하여 응답하는 서블릿
	=> [글쓰기]를 클릭한 경우 
*/
@WebServlet("/guest/list.itwill")
public class GuestSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//GUEST 테이블에 저장된 모든 행을 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 호출
		
	}

}
