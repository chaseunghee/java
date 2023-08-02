package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//[순서-4]

/*
	Model 기능을 제공하는 클래스가 반드시 상속받아야 되는 인터페이스
	=> 모든 Model 기능의 클래스에 동일한 메소드가 작성되도록 규칙 제공
	=> Controller에서 Model 기능의 클래스로 요청 처리 메소드를 쉽게 호출하여 사용하기 위해 필요한 인터페이스
*/
public interface Controller {
	//모든 Model 기능의 클래스에서 반드시 작성할 요청 처리 메소드를 추상메소드로 선언
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
