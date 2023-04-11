package basic;

import java.util.Scanner;

//System.out : 프로그램의 값을 출력스트림을 사용하여 값을 화면에 전달하는 기능을 제공하는 객체
//System.in : 키보드로부터 전달된 값을 입력 스트림을 사용하여 프로그램에 전달하는 기능을 제공하는 객체

public class ScannerApp {
	public static void main(String[] args) {
		//Scanner 클래스 : 입력스트림(키보드 - System.in, 파일 등)을 전달받아 원하는 자료형으로 값을
		//					입력받기 위한 기능(메소드)을 제공하는 클래스
		//Scanner 객체를 생성하여 참조변수에 저장
		//=> 참조변수를 사용하여 참조변수에 저장된 객체를 사용하여 메소드 호출해 필요한 기능 구현
		
		Scanner scanner = new Scanner(System.in);
		
		//Scanner.nexLine() : 입력스트힘에 전달된 값을 문자열로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 문자열로 반환받아 변수에 저장
		//=> 키보드 입력값이 없는 경우 프로그램의 흐름(스레드)이 일시 중지
		//=> 키보드로 값을 입력한 후 Enter를 입력하면 프로그램의 흐름 재실행
		
		//사용자로부터 키보드로 이름과 나이를 입력받아 화면에 출력하는 프로그램 작성된
		System.out.print("이름 입력 >> ");
		String name= scanner.nextLine();
		
		//=> 키보드로 입력된 값이 정수값이 아닌 경우 예외(Exception) 발생-프로그램 강제 종료
		System.out.print("나이 입력 >> ");
		int age= scanner.nextInt();
		
		System.out.println("[결과] "+name+"님의 나이는 "+age+"살입니다.");
		
		//Scanner.close() : Scanner 객체가 사용한 입력스트림을 제거하는 메소드
		scanner.close();
		
	}

}
