package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean 클래스의 기본 생성자 호출 ### ");
	}
	
	public void init() {
		System.out.println("### InitDestroyMethodBean 클래스의 init() 생성자 호출 ### ");
	}
	
	public void destroy() {
		System.out.println("### InitDestroyMethodBean 클래스의 destroy() 생성자 호출 ### ");	
	}
	
	public void display() {
		System.out.println("### InitDestroyMethodBean 클래스의 display() 생성자 호출 ### ");	
	}
	
}
