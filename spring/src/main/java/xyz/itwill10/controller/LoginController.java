package xyz.itwill10.controller;
//[순서-1] - LoginController 클래스 생성

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Member;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login_form"; //=> [순서-2]-login_form.jsp 파일 생성 (forward이동할 수 있도록)
	}
	
	/* [순서-3] 
		
		전달값(로그인정보)을 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로 저장하고 로그인 성공 메세지를 출력하는 JSP 문서의 뷰이름을 반환하는 
		요청 처리 메소드
		=> 전달값을 String 자료형의 매개변수에 하나씩 제공받아 사용
		=> Session Scope 속성값을 저장하기 위해 매개변수로 HttpSession 객체를 제공받아 사용 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, HttpSession session, Model model) {
		if(!id.equals("abc123")||passwd.equals("123456")) { //인증 실패
			
				인증 실패 관련 정보를 Request Scope 속성값을 저장 - 입력페이지(JSP)에서 출력 저장
				
				Request Scope : 현재 요청 처리 메소드와 포워드 이동되는 뷰(JSP)에서만 속성값을
			
			model.addAttribute("message", "아이디 또는 비밀번호를 잘못 입력하였습니다."); //[순서-3] - "message"라는 이름으로 "아이디 어쩌고를" 전달 =>[순서-4] - login_form.jsp 코드 추가 작성 
			model.addAttribute("id", id);//[순서-5] - "id"라는 이름으로 id 전달 =>[순서-6] - login_form.jsp 코드 추가 작성
			return "login_form"; //입력페이지로 이동
		}
		
		   //[순서-7]
			//인증 성공 - 권한 관련 정보를 Session Scope 속성값으로 저장
			Session Scope : 동일한 세션을 사용하는 모든 요청 처리 메소드와 뷰에서 속성값을 제공받아 사용
		 	
		session.setAttribute("loginId", id);
		
		return "login_display"; //=>[순서-8] - login_display.jsp 파일 생성 및 코드
	}
*/
	
	/* [순서-13] - [순서-3,7] 주석처리하고 
		
		전달값(로그인정보)를 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로 저장하고 로그인 성공 메세지를 출력하는 
		JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
		=> 모든 전달값을 Member 클래스의 매개변수에 필드값으로 제공받아 사용
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Member member, HttpSession session, Model model) {
		if(!member.getId().equals("abc123") || !member.getPasswd().equals("123456")) {//인증 실패
			/*
				인증 실패 관련 정보를 Request Scope 속성값으로 저장 - 입력페이지(JSP)에서 출력 가능
				Request Scope : 현재 요청 처리 메소드와 포워드 이동 되는 뷰(JSP)에서만 속성값을 제공받아 사용
			*/
			model.addAttribute("message", "아이디 또는 비밀번호를 잘못 입력 하였습니다.");
			return "login_form";//입력페이지로 이동
		}
		
		/*
			인증 성공 - 권한 관련 정보를 Session Scope 속성값으로 저장
			Session Scope : 동일한 세션을 사용하는 모든 요청 처리 메소드와 뷰에서 속성값을 제공받아 사용
		*/
		session.setAttribute("loginId", member.getId());
				
		return "login_display";
	}
	
	// [순서-10]
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginId");
		session.invalidate();
		
		return "logout_display"; //=>[순서-11]-logout_display.jsp 파일 생성 및 코드
	}
	
	// [순서-12]
	@RequestMapping("/login_display")
	public String login(HttpSession session, Model model) {
		if (session.getAttribute("loginId")==null) {
			model.addAttribute("message", "로그인 사용자만 접근 가능합니다.");
			return "login_form";
		}
		return "login_display";
	}
}
