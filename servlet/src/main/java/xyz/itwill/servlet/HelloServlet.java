package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	◈Servlet : Server + let 합성어로 웹서버에서 실행되는 간단한 프로그램 - Java Web Server Program
	=> 웹프로그램은 클라이언트 요청에 의해 WAS(Web Application Server)에 의해 실행되며 실행결과로 웹문서를 동적으로 생성하여 클라이언트에게 응답
	=> Servlet 프로그램은 WAS에 의해 관리(생성, 사용, 소멸)
	
	◈WAS(Web Application Server) : Web Server(요청과 응답) + Web Container(서블릿 관리)
	
	◈서블릿 프로그램 작성 방법 - 1
	1.HttpServelt 클래스(J2EE >> ApacheTomcat)를 상속받은 자식클래스 작성 - 서블릿 클래스
	=> HttpServelt 클래스를 상속받은 자식클래스는 객체 직렬화 클래스로 serialVersionUID 필드를 선언하는 것을 권장
*/

public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

/*
	◈서블릿 프로그램 작성 방법 - 2
	2.doGet() 메소드 또는 doPost() 메소드를 오버라이드 선언
	=> 클라이언트에 요청에 대한 처리 명령과 실행결과를 웹문서로 생성하는 명령을 작성하는 메소드 - 요청 처리 메소드 : WAS에 의해 자동 호출되는 메소드	
	=> doGet() : 클라이언트가 서블릿 프로그램을 GET 방식으로 효청한 경우 호출되는 메소드 
				- 
	=> doPost() : 클라이언트가 서블릿 프로그램을 POST(form태그) 방식으로 요청한 경우 호출되는 메소드 
				- 
	
	doGet() 메소드 또는 doPost() 메소드 대신 service() 메소드를 오버라이드 선언 가능
	=> service() 메소드 : 클라이언트가 서블릿 프로그램을 모든 방식으로 요청한 경우  호출되는 메소드
	=> doGet() 메소드 또는 doPost() 메소드보다 service() 메소드의 호출 우선순위가 높게 설정 - service()를 만들었으면 절대 doGet()과 doPost()는 만들면 안됨
*/
/*
	(form태그가 없으므로 POST 방식이 아닌 GET 방식 사용 - doget()오버라이드 (get 방식으로 요청했을 때랑 post 방식으로 요청했을때 다르게 작성하기 위해서는 따로 오버라이드하면 되는데 그건 고급이라 우린 하나만 작성))
	WAS 프로그램에 의해 요청 처리 메소드가 호출될 때 메소드 매개변수에는 HttpServletRequest 객체(request 객체)와 HttpServletResponse 객체(response 객체)가 전달되어 저장
*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	HttpServletRequest 객체 : 리퀘스트 메세지(요청 관련 정보)를 표현한 객체
		 	HttpServletResponse 객체 : 리스폰즈 메세지(응답 관련 정보)를 표현한 객체
		 */
		
		/*
 			◈서블릿 프로그램 작성 방법 - 3
 			3.클라이언트 요청에 대한 실행결과를 응답하기 위한 파일형태(MimeType)를 변경	
 			=> 리스폰즈 메세지의 몸체부에 저장될 파일형태 설정
 			
 			HttpServletResponse.setContentType(String mimeType[;charset=encoding]) 메소드 호출 
 			=> 리스폰즈 메세지의 몸체부에 저장될 파일형태를 변경하는 메소드
 			=> 응답 파일(String mimeType)이 문서파일인 경우 문자형태(CharacterSet - Encoding) 설정
 			
 			setContentType(String mimeType[;charset=encoding])을 작성하지 않은 경우
 			- 기본 응답 파일 형태 : text/html;charset=iso-8859-1 : 서유럽어로 만들어진 HTML 문서로 응답
		 */
		
		//한글로 만들어진 HTML 문서로 응답
		response.setContentType("text/html;charset=utf-8"); //이 코드를 작성해줘야만, 한글 깨지지 않게 출력 가능 (선택사항)
		
		/*
		 	◈서블릿 프로그램 작성 방법 - 4
		 	4.응답파일을 생성하기 위한 출력스트림을 반환받아 저장
		 	
		 	HttpServletResponse.getOutputStream() : 응답파일(Binary File)을 생성하기 위한 출력스트림(OutputStream 객체)을 반환하는 메소드
		 	=> 원시데이터(1Byte)를 전달하여 그림, 소리, 동영상 파일 등과 같은 이진파일(Binary File)을 생성하기 위한 출력스트림
		 	
		 	HttpServletResponse.getWriter() : 응답파일을 생성하기 위한 출력스트림(PrintWriter 객체)을 반환하는 메소드
		 	=> 문자데이터(2Byte)를 전달해 HTML, XML 파일등과 같은 문서파일을 생성하기 위한 출력스트림
		*/
		PrintWriter out=response.getWriter();
		
		//3번, 4번은 클라이언트 요청에 대해 파일로 응답할 때 사용하며 생략 가능
		
		/*
			◈서블릿 프로그램 작성 방법 - 5
			5.클라이언트 요청에 대한 처리 명령 작성 및 출력스트림을 이용한 응답파일 생성
			=> 클라이언트 요청에 대한 처리 명령에 필요한 값은 HttpServletRequest 객체로부터 제공받아 사용
		*/
		/*
			PrintWriter.println(String str) : 출력스트림으로 문자열을 전달하는 메소드 - 응답파일
			- 출력스트림으로 응답파일 만들어줌
		*///응답은 출력스트림으로 만들어주는데 출력스트림은 out이므로 out.println
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿(Servlet)</h1>");
		out.println("<hr>");
		out.println("<p>Hello, Servlet!!!</p>");
		out.println("</body>");
		out.println("</html>");
		
		
		/*
			◈서블릿 프로그램 작성 방법 - 6
			6.서블릿 클래스를 서블릿(웹프로그램)으로 실행되도록 설정
			=> [web.xml] 파일에서 서블릿 클래스를 서블릿으로 등록하고 서블릿을 요청할수 있는 URL 주소를 매핑 설정
			
			클라이언트가 매핑된 URL 주소의 서블릿을 요청하면 WAS 프로그램은 서블릿 클래스를 객체로 생성하여 요청 처리 메소드를 호출하고 처리결과를 클라이언트에게 전달하여 응답 (객체를 만들어야 메소드 호출 가능함)
		*/
	}

}
