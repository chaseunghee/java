package xyz.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.BadRequestException;

/* [순서-3] - AdminAuthInterceptor 클래스 생성 

	Intercepter 클래스 : 요청 처리 메소드가 호출되기 전 또는 후에 삽입되어 실행될 기능을 제공하는 클래스
	=> Interceptor 클래스는 반드시 HandlerInterceptor 인터페이스를 상속받아 작성 - 필요한 메소드만 오버라이드 선언하여 사용
	=> Interceptor 클래스는 Spring Bean Configuration File(servlet-context.xml)에 Spring Bean으로 등록하고 요청 처리 메소드 호출 전 또는 후에 실행되도록 설정
	
	관리자 관련 권한 처리를 위해 작성된 인터셉터 클래스
	=> 요청 처리 메소드 호출 전에 비로그인 사용자이거나 관리자가 아닌 사용자가 페이지를 요청한 경우 인위적으로 예외 발생 - 에러 페이지로 응답 처리

*/
public class AdminAuthInterceptor implements HandlerInterceptor {
	/* [순서-4] - preHandle()메소드 override 및 안에 코드 작성
	
		preHandle 메소드 : 요청 처리 메소드가 호출되기 전에 실행될 명령을 작성하기 위한 메소드
		=> false 반환 : 요청 처리 메소드 미호출 
		   true 반환 : 요청 처리 메소드 호출
	*/
	@Override //요청처리 전에 호출되는 메소드, 오버라이드하면 return하는 기본값은 true임
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) //반드시 boolean 반환해야됨
			throws Exception {
		HttpSession session=request.getSession(); //얘가 세션객체를 바인딩해서 줄거임
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		//비로그인 사용자이거나 관리자가 아닌 사용자인 경우 
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			/* [순서-6] - [순서-5]말고 이 방법도 있음
			response.sendError(HttpServletResponse.SC_FORBIDDEN);//403 에러코드 전달
			return false;//요청 처리 메소드 미호출
			*/
			
			/*
			request.getRequestDispatcher("userinfo/user_error.jsp").forward(request, response); // user_error.jsp로 스레드를 이동시켜서 응답처리하라는 거
			return false; //요청 처리 메소드 미호출 - 실행안된다는 뜻
			*/
			
			//[순서-5] - 근데 예외 발생시키는 인터셉터를 만들거임,그니까 위에 return false로 한 request.getRequestDispatcher,return 주석
			throw new BadRequestException("비정상적인 요청입니다.");//프론트컨트롤러에게 모든 예외 전달됨 그 예외를 받아서 에러페이지로 이동할거임
		}
		return true; //요청처리메소드 호출
	}
	
	/* [순서-7]
		postHandle 메소드 : 요청 처리 메소드가 호출되어 반환된 뷰이름으로 ViewResolver가 뷰(View)를 생성되기 전에 실행될 명령을 작성하기 위한 메소드
		=> ModelAndView 객체를 제공받아 ViewName 또는 Model 객체의 속성값을 저장(변경)하기 위해 사용하는 메소드
	*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/* [순서-8]
		afterCompletion 메소드 : 요청 처리 메소드가 호출되어 반환된 뷰이름으로 ViewResolver가 뷰(View)를 생성한 후에 실행될 명령을 작성하기 위한 메소드
		=> 뷰(View)를 변경하기 위해 사용하는 메소드
	*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	/*
		제가 하고싶은 인터셉터는 관리자 권한 처리를 위해 작성된 인터셉터이고 
		요청처리메소드가 호출되기 "전" "예외발생-에러페이지로 이동"
		다른 건 필요없음-[순서-5,6]은 굳이 안만들어도됨 필요하면 만들고
	*/
}
