package xyz.itwill10.service;
/* [순서-21] 

	Service 클래스 : 데이터 처리 관련 기능을 모듈화하여 제공하기 위한 기능을 제공하기 위한 클래스
	=> Service 클래스의 메소드에서는 데이터 처리에 필요한 기능을 구현하기 위한 DAO 클래스의 메소드를 호출하여 작성 - 컴퍼넌트(Component)
	=> Service 클래스가 변경돼도 의존관계로 설정된 Controller 클래스의 영향을 최소화하기 위한 인터페이스를 상속받아 작성

	Service 클래스는 Controller 클래스에서 객체로 제공받아 사용되도록 반드시 Spring Bean으로 등록 
	=> Service 클래스는 @Service 어노테이션을 사용하여 Spring Bean으로 등록
	=> @Service 어노테이션을 사용하면 TransactionManager에 의해 트랜잭션 관리 가능
	=> @Service 어노테이션을 스프링 컨테이너가 처리하기 위해 반드시 클래스가 작성된 패키지를 Spring Bean Configuration File(servlet-context.xml)의 component-scan 엘리먼트로
		검색되도록 설정
*/

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

//[순서-23] 
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{ //StudentService 인터페이스 상속
	/*
		Service 클래스의 메소드에서 사용될 DAO 클래스의 객체를 저장하기 위한 필드
		=> 생성자를 이용하여 필드에 DAO 클래스의 객체가 저장되도록 의존성 주입
	*/
	private final StudentDAO studentDAO; //무조건 인터페이스로 만들어야함 - StudentDAO 인터페이스 사용함
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);		
	}
	
	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}
	
}
