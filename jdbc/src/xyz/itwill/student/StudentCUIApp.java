package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	학생정보를 관리하는 프로그램 작성
	=> 메뉴 선택에 따른 학생정보 삽입,변경,삭제,검색 기능 제공
	=> 입력과 출력은 프로그램에서 구현
	=> 데이터 처리는 DAO 클래스의 메소드를 호출하여 처리 
*/
public class StudentCUIApp {
	//키보드 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	//생성자 생성 [Ctrl]+[Enter]
	public StudentCUIApp() {
		//키보드로 문자열을 입력받기 위한 입력스트림을 생성하여 필드에 저장
		in=new BufferedReader(new InputStreamReader(System.in));
		
		//배열 생성
		String[] menu= {"1.학생정보 삽입","2.학생정보 변경","3.학생정보 삭제","4.학생정보 삭제","학생정보 검색","5.학생목록 출력","6.프로그램 종료"};
		
		System.out.println("<< 학생 관리 프로그램 >>");
		
		//while구문
		while(true) {
			//menu 출력
			for(String item : menu) {
				System.out.println(item);
			}
			
			//변수 선언
			int choice;
			
			//try-catch 구문
			try {
				System.out.println("메뉴 선택[1~6] >> ");
				
				//키보드로 문자열을 입력받아 정수값으로 변환하여 변수에 저장
				choice=Integer.parseInt(in.readLine());
				
				//메뉴 선택을 잘못한 경우(choice=1,6) 인위적 예외 발생
				if(choice<1 || choice>6) throw new Exception();
				
			} catch (Exception e) {
				System.out.println("[에러]메뉴를 잘못 선택하였습니다.");
				System.out.println();
				
 				continue; //반복문(while)문 다시 실행
			}
			System.out.println();
			
			if(choice==6) break; //반복문(while)문 종료
			
			//메뉴 선택에 따른 기능 구현 - 메소드 호출
			switch(choice) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			}
			System.out.println();
		}
		System.out.println("[메세지]학생 관리 프로그램을 종료합니다.");
	}
	
	public static void main(String[] args) {
		new StudentCUIApp(); //생성자 호출
	}

}
