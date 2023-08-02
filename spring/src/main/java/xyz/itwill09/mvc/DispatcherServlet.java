package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* [순서-1] - controller 역할을 하는 servlet 
	
	컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 URL 주소를 분석하여 필요한 요청 처리 클래스(Model)의 메소드를 호출하여 클라이언트의 요청을 처리하고
							JSP 문서(View)로 스레드를 이동하여 응답 처리되도록 프로그램의 흐름을 제어하는 기능 제공 - 서블릭(Servlet)으로 구현
	
	컨트롤러 기능을 제공하기 위한 서블릿 클래스
	=> 클라이언트의 모든 요청을 받아 처리하는 단일 진점의 역할을 수행 - Front Controller Pattern
	=> 방법-1) [web.xml] 파일에서 클래스를 서블릿(웹프로그램)으로 등록하고 클라이언트의 모든 요청을 받아 처리할 수 있도록 URL 패턴 설정
*/
public class DispatcherServlet extends HttpServlet {//[순서-2] HttpServlet 상속
	private static final long serialVersionUID = 1L; 
	
	//[순서-3]
	//클라이언트의 요청을 처리하기 위한 자동 호출되는 메소드를 오버라이드 선언 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트의 요청 URL 주소를 분석하여 요청정보를 반환받아 저장
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//[순서-13]
		/*
			2. 클라이언트의 요청정보를 이용하여 요청 처리 클래스(Model)의 객체를 제공받아 객체의 메소드를 호출하여 클라이언트의 요청을 처리하고 응답(View) 관련 정보를 반환받아 저장
			인터페이스로 참조변수를 선언하면 인터페이스를 상속받은 모든 자식클래스의 객체 저장 가능
		Controller controller=null;
		//클라이언트의 요청정보를 비교하여 요청 처리 클래스(Model)로 객체를 생성하여 저장
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		
		//[순서-14]
		//요청 처리 클래스의 메소드를 호출하여 클라이언트의 요청을 처리하고 응답 처리할 JSP 문서의 이름(ViewName)을 반환받아 저장
		String viewName=controller.handleRequest(request, response);		
		*/
		
		//[순서-13] => command를 비교해서 command model 객체를 만들어내는 방법은 비효율적 => 속도 느리고 클라이언트가 요청할 때마다 model 객체 만들어야 해서 메모리 과부하 => 권장X
	
		//[순서-13] 방법 말고 아래 방법 
		/* [순서-16]
			HandlerMapping 클래스로 객체 생성
			=> HandlerMapping 클래스 :클라이언트의 요청정보와 요청 처리 클래스의 객체가 엔트리로 저장된 Map 객체를 제공하기 위한 클래스
		*/
		HandlerMapping handlerMapping=new HandlerMapping();
		//[순서-18]
		//HandlerMapping 객체의 메소드를 호출하여 매개변수에 전달된 요청정보에 대한 요청처리
		Controller controller=handlerMapping.getController(command);
		
		//[순서-15]
		//요청 처리 클래스의 메소드를 호출하여 클라이언트의 요청을 처리하고 응답 처리할 JSP 문서의 이름(ViewName)을 반환받아 저장
		String viewName=controller.handleRequest(request, response);
		
		//[순서-19]
		/*
			3. JSP 문서로 포워드 이동하여 클라이언트에게 처리결과가 응답되도록 처리
			=> 요청 처리 메소드의 반환값(ViewName)을 이용하여 JSP 문서의 경로를 완성하여 포워드 
			
			ViewResolver 클래스로 객체 생성
			=> 
		*/
		//[순서-21]
		ViewResolver viewResolver=new ViewResolver();
		String view=viewResolver.getView(viewName); //응답할 JSP 문서의 경로를 반환받아 저장
		request.getRequestDispatcher(view).forward(request, response); //JSP 문서로 포워드 이동 
		
		//=>[순서-22] WEB-INF >> mvc 폴더 생성 >> [순서-23]member_list.jsp 파일과 [순서-24]member_view.jsp 파일 생성
	}
}
