package xyz.itwill.student;

import java.util.List;

//DAO 이전에 DTO 클래스 먼저 만들어야함.

/*
	DAO 클래스가 상속받기 위한 인터페이스
	  => 추상메소드가 이용하여 인터페이스를 상속받은 모든 자식클래스(DAO 클래스)가 동일한 메소드가 선언되도록 메소드의 작성 규칙 제공
	  => 프로그램에서 사용하는 DAO 클래스가 변경돼도 프로그램에 영향을 최소화하기 위해 인터페이스 선언
*/

public interface StudentDAO { //-추상메소드(아래6개 메소드)를 StudentDAO 인터페이스(DAO)가 오버라이드해줘야함
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행에 개수를 반환하는 메소드 - 학생정보를 DTO 클래스로 해서 전달받아 작성
	//int insertStudent(int no, String name, String phone, String address, String birthday);
	int insertStudent(StudentDTO student);
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 개수를 반환하는 메소드
	int updateStudent(StudentDTO student);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 개수를 반환하는 메소드
	int deleteStudent(StudentDTO student);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 반환하는 메소드
	//=> 단일행 : 값 또는 DTO 객체 반환 
	StudentDTO selectStudent(int no); //StudentDTO - 한명만 반환
	
	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드
	//=> 다중행 : List 객체 반환 
	List<StudentDTO> selectNameStudentList(String name); //여러명 반환하고 싶으면 set,map,list(순서)
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<StudentDTO> selectAllStudentList(); 
}





