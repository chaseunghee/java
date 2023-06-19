package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/*
	JNDI(Java Naming Directory Interface) : WAS 프로그램에 의해 관리되는 객체를 미리 생성하여 저장하고 웹프로그램에서 필요한 경우 WAS 프로그램에 등록된 객체의 이름을 이용하여 객체를 제공받아 사용하기 위한 기능
	=> WAS 프로그램에 의해 관리되는 객체에 대한 정보를 src/main/webapp/META-INF/,context.xml 파일에 저장	
*/

//	WAS 프로그램에 등록된 DataSource 객체를 제공받아 DataSource 객체에 저장된 다수의 Connection 객체 중 하나를 제공받아 Connection 객체에 정보를 클라이언트에게 전달하여 응답하는 서블릿
@WebServlet("/jndi.itwill")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		try {
			/*
			InitialContext 객체 : JNDI 서비스를 제공하는 객체
			=> JNDI 서비스 : WAS 프로그램에 의해 관리되는 객체를 제공하기 위한 서비스
			
			InitialContext.lookup(String name) : 매개변수로 전달받은 이름의 객체를 반환하는 메소드
			=> 검색된 객체는 Object 객체로 반환하므로 반드시 명시적 객체 형변환 처리하여 
			=> 매개변수로 전달받아 이름의 객체가 없는 경우 NamingException 발생 - 예외처리 
			
			◎DataSrouce를 사용하여 DB작업 방법
			DataSource dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");

			1. JNDI 서버 객체 새성
			InitialContext ic= new InitialContext();

			2. lookup()
			-찾으려는 리소스의 등록된 이름을 지정
			(찾으려는 리소스의 이름은 "jdbc/oracle" 이고 WAS인 톰캣에서 리소스를 관리하는 가상의 디렉터리는 "java:comp/env")
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/oracle");

			3. getConnection()
			-lookup( ) 메소드가 반환하는 객체의 타입은 Object 이기 때문에 원래 리소스 타입으로 변환
			( 원래 DataSource로 타입을 변환
			Connection conn = ds.getConnection();

			 */
			DataSource dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
			
			Connection con=dataSource.getConnection();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>DBCP - JNDI</h1>");
			out.println("<hr>");
			out.println("<p>con = "+con+"</p>");
			out.println("</body>");
			out.println("</html>");
			
			con.close(); // 리소스를 반납하지 않고 코드를 종료해버리면 Connection 객체가 정상적으로 반납되지 않아 커넥션 풀에 구멍이 남.
			
		} catch (NamingException e) {
			e.printStackTrace(); //에러의 발생근원지를 찾아서 단계별로 에러를 출력
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
