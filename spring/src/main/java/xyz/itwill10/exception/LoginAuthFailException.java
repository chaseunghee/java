package xyz.itwill10.exception;

import lombok.Getter;

/* [순서-11]

	로그인 처리할때 사용자로부터 입력받은 아이디와 비밀번호에 대한 인증이 실패한 경우 발생될 예외를 처리하기 위한 예외 클래스
*/
public class LoginAuthFailException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/*
		예외처리에 필요한 값을 저장하기 위한 필드
		=> 사용자부터 입력받은 아이디를 저장하기 위한 필드
	*/
	@Getter
	private String userid; //exceptionhandler로 예외처리해줄건데 예외처리할 때 필요한 userid 코드 작성+@
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid=userid;
	}
}
