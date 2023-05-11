package xyz.itwill.jdbc;

public class StaticBlock {
	//정적영역(Static Block) : 클래스가 메모리에 저장된 후 자동 실행될 명령을 작성하는 영역
	//=> 정적영역에 작성된 명령은 프로그램에서 프로그램 실행시 한 번만 실행(이유: 클래스를 메모리에 저장할 때 클래스를 쓸 때마다 저장하는 것이 아니라 최초로 사용할 때 저장됨. 최초 사용될 때 저장이 이미 되어있어서 한 번만 저장)
	static {
		System.out.println("### StaticBlock 클래스의 정적영역에 작성된 명령 실행 ###");
		StaticBlock sb = new StaticBlock(); //객체 생성
		sb.display(); //메소드 호출
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock 클래스의 기본 생성자 호출 - 객체 생성 ###");
	}
	
	//인스턴스(객체) 메소드
	public void display() {
		System.out.println("### StaticBlock 클래스의 display() 메소드 호출 ###");
	}

}
