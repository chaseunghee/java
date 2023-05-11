package xyz.itwill.jdbc;

//Class 객체(Clazz)를 수동으로 생성하는 방법
//1.Class.forName(String className) 메소드를 호출하여 반환하는 방법
//2.Object.getClass() 메소드를 호출하여 현재 사용중인 클래스에 대한 Class 객체 반환받는 방법
//3.[클래스명.class] 형식으로 표현하는 방법 - 외부클래스 불러다 쓸 때 사용

public class StaticBlockApp {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		//1. JVM은 ClassLoader 프로그램을 이용하여 클래스(Class 파일)을 읽어 메모리(Method 영역)에 저장 - JVM이 자동으로 해줌 
		//2.번으로 넘어가기 전에 정적영역(static)이 먼저 실행됨.
		//2. new 연산자로 메모리에 저장된 클래스(Class 객체 - Clazz)의 생성자를 호출하여 
		//	객체(Object=instance) 생성 - 메모리의 힙(heap)영역에 객체 생성(메모리에 이름 부여 못함)
		//3. 생성된 객체의 메모리 주소(HashCode)를 제공받아 참조변수를 생성하여 저장
		//	- 참조변수는 메모리의 스택(Stack)영역에 생성
		StaticBlock sb = new StaticBlock(); //인스턴스(객체) 호출 - 이름 부여못함 => StaticBlock으로 참조변수 만듦
		
		//참조변수에 저장된 메모리 주소로 객체를 참조하여 메소드 호출 
		sb.display(); //sb 참조변수로 display 인스턴스(객체)가 가지고 있는 메소드 호출
		*/
		
		//위1.번(자동)이 아닌 수동으로 클래스(Class 파일)을 읽어 메모리(Method 영역)에 저장
		//Class.forName(String className) : 문자열로 표현된 패키지가 포함된 클래스를 전달받아 
		//									ClassLoader 프로그램을 사용하여 클래스를 읽어 메모리에 저장하는 메소드
		//=> 메모리에 저장된 클래스의 정보가 저장된 Class 객체(Clazz) 반환
		//=> ClassNotFoundException 발생 : 해당 패키지에 클래스가 없는 경우 발생 - 일반 예외 (무조건 예외처리해줘야함 -try/catch로 하는게 정석이지만 떠넘김=>JVM이 해줌) 
		Class.forName("xyz.itwill.jdbc.StaticBlock"); //수동으로 클래스를 메모리에 저장
		//객체를 만들거나 호출하지 않아도 정적영역안에서 자기 자신을 가져다가 객체를 생성하고 메소드 호출함.
		//StaticBlock sb = new StaticBlock();
		//sb.display();
		
	}

}
