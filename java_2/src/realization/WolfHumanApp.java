package realization;

//인터페이스(Interface) : 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 자료형(참조변수)
//=> 상수필드(Constant Field)와 추상메소드(Abstract Method)만 선언 가능
//=> JDK11 이상에서는 정적메소드(Static Method)와 기본메소드(Default Method)도 선언 가능
//형식) [public] interface 인터페이스명 {
//				자료형 필드명 = 값;// public static final 생략 가능
//				...
//				public abstract 반환형 메소드명(자료형 매개변수, ...);
//	}
//=> 인터페이스의 이름은 파스칼 표기법을 사용하여 작성하는 것을 권장

//인터페이스는 클래스가 상속받아 사용하기 위한 자료형 - 다중 상속 가능
//형식) public class 클래스명 implements 인터페이스명, 인터페이스명,...{}
//=> 인터페이스를 상속받은 자식클래스는 무조건 부모 인터페이스의 모든 추상메소드를 오버라이드 선언
//=> 인터페이스로 객체 생성은 불가능하지만 참조변수를 생성하여 인터페이스를 상속받은 자식클래스로 객체를 생성하여 저장 가능
//클래스로 객체를 생성하여 저장 가능 - 참조변수에 자식클래스의 메소드 호출(묵시적 객체 형변환)

//인터페이스는 다른 인터페이스를 상속받아 사용 가능 - 다중 상속 가능
//형식) public interface 인터페이슴여 extends 인터페이스명, 인터페이스명, ...){}

//인터페이스를 선언하여 클래스가 상속받아 사용하는 이유
//1. 클래스의 단일 상속 관련 문제를 일부 보완하기 위해 인터페이스 사용


public class WolfHumanApp {
	public static void main(String[] args) {
		WolfHuman wolfHuman=new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.fastWalk();
		wolfHuman.cryLoudly();
		System.out.println("=============================================");
	
	
	//부모클래스로 참조변수를 생성하여 자식클래스의 객체 저장
	//=> 참조변수는 기본적으로 부모클래스의 메소드만 호출 가능
	Human human =new WolfHuman();
	
	human.speak();
	human.walk();
	human.smile();
	System.out.println("=============================================");
	//명시적 객체 형변환을 사용하여 자식클래스의 메소드 호출
	((WolfHuman)human).change();
	System.out.println("=============================================");
	//인터페이스로 참조변수를 생성하여 자식클래스의 객체 저장 가능
	//Wolf wolf=human;
	
	//자식클래스가 같은 클래스와 인터페이스는 명시적 형변환을 이용하면 자식클래스의 객체를 공유하여 사용 가능
	Wolf wolf=(Wolf)human;
	
	//묵시적 객체 형변환에 의해 자동으로 자식클래스의 메소드가 호출
	wolf.fastWalk();
	wolf.cryLoudly();
	System.out.println("=============================================");

	
	
	
	
	}
	
}
