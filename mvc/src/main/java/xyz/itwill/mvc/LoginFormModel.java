package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	클라이언트가 [/loginform.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
	=> [user_login.jsp]로 포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
*/
public class LoginFormModel implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward(); //무조건 작성
		actionForward.setForward(true); //true - forward 방식
		actionForward.setPath("/model_two/user_login.jsp");
		return actionForward; //포워드 이동하기 위한 정보가 저장된 ActionForward 객체 반환
	}
	
}
