package xyz.itwill07.aop;

import org.springframework.stereotype.Component;

//[순서-1] - AopAnnotationBean 클래스 생성

@Component
public class AopAnnotationBean {
	//핵심관심코드 3개 생성
	public void display1() {
		System.out.println("*** AopAnnotationBean 클래스의 display1() 메소드 호출 ***");
	}
	
	public void display2() {
		System.out.println("*** AopAnnotationBean 클래스의 display2() 메소드 호출 ***");
	}
	
	public void display3() {
		System.out.println("*** AopAnnotationBean 클래스의 display3() 메소드 호출 ***");
	}
}
