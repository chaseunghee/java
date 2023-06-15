package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	어노테이션(Annotation) : API 문서에 특별한 설명을 제공하기 위해 만들어진 기능
	=> 프로그램 작성에 필요한 특별한 의미를 제공하거나 실행에 필요한 정보를 제공하는 기능
	
	@WebServlet : 서블릿 클래스를 서블릿으로 등록하고 URL 패턴을 매핑하기 위한 어노테이션
	=> [web.xml] 파일의 servlet 엘리먼트와 servlet-mapping 엘리먼트로 제공하는 기능과 동일
	
	@WebServlet 어노테이션의 속성을 이용하여 서블릿의 이름과 URL 패턴 매핑 설정
	=> name 속성: 서블릿의 이름을 속성값으로 설정 - 속성을 생략하면 자동으로 클래스 이름을 서블릿의 이름으로 설정  - 생략 가능
	=> value 속성 : 서블릿을 요청하기 위한 URL 패턴을 속성값으로 설정 - value 속성외 다른 속성이 없는 경우 속성값만 설정 - 생략 불가(필수)
*/

@WebServlet("/first.itwill") // = @WebServlet(name="first",value="/first.itwill") -> name 생략 가능 = @WebServlet(value="/first.itwill") -> value 단어 생략 가능
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* ●
		클라이언트 요청에 의해 자동 호출되는 메소드 - 요청 처리 메소드
		=> 클라이언트 요청에 대한 처리 명령과 응답될 실행결과를 저장한 파일을 생성하는 명령 작성
	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*●순서1
			1. 클라이언트에게 요청에 대한 실행결과를 저장하기 위한 파일형태 변경 및 응답파일을 생성하기 위한 출력스트림을 반환받아 저장 (HelloServlet.jsp - ◈3번4번에 해당)
			=> 클라이언트에게 URL 주소로 응답할 경우 응답파일을 제공하지 않으므로 생략 가능 
		*/
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		/*●순서2
			2. 요청에 대한 처리 명령 및 처리결과를 저장할 응답파일 생성
			=> 서블릿은 모든 클라이언트에게 일관성 있는 처리결과를 동적으로 생성하여 제공
		*/
		
		//서버 플랫폼의 현재 날짜와 시간이 저장된 Date 객체 생성 - java.util 패키지꺼 사용해야함.
		Date now=new Date(); 
		
		//날짜와 시간에 대한 패턴정보를 저장한 SimpleDateFormat 객체 생성
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		//SimpleDateFormat 객체의 format() 메소드를 호출하여 매개변수로 전달받은 Date 객체를 SimpleDateFormat 객체에 저장된 날짜와 시간 패턴의 문자열로 변환하여 반환받아 저장
		String displayNow=dateFormat.format(now);
		
		//실행결과를 클라이언트에게 html 형태로 보내기 위해 실행 결과를 저장한 응답파일 생성 (아래 코드) 
		//HTML 작성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		//CSS 작성
		out.println("<style type='text/css'>");
		out.println("p {");
		out.println("width: 600px;");
		out.println("margin: 0 auto;");
		out.println("padding: 30px 0;");
		out.println("font-size: 2em;");
		out.println("font-weight: bold;");
		out.println("text-aligin: center;");
		out.println("border: 2px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿시계</h1>");
		out.println("<hr>");		
		out.println("<p>"+displayNow+"</p>");
		//JavaScript 작성
		out.println("<script type='text/javascript'>");
		out.println("setInterval(function() {");
		out.println("location.reload();");
		out.println("}, 1000);");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	} //=> 웹문서 만들기 편하게 JSP를 이용하여 만들면 됨(나중에 배울거임)

}
