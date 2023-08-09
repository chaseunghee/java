package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

/* [순서-40] - 아래 코드 전부
	@WebAppConfiguration : ApplicationContext 객체가 아닌 WebApplicationContext 객체를 스프링 컨테이너로 사용할 수 있도록 설정하기 위한 어노테이션
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

/* [순서-44]
	@FixMethodOrder : 테스트 메소드 호출순서를 설정하기 위한 어노테이션
	
	value 속성 : MethodSorters 자료형(Enum)의 상수 중 하나를 속성값으로 설정
	=> MethodSorters.DEFAULT : JUnit 프로그램의 내부 규칙에 의해 정렬되어 메소드 호출 - 테스트 프로그램 실행시 동일한 순서로 메소드 호출
	=> MethodSorters.JVM : JVM에 의해 정렬되어 메소드 호출 - 테스트 프로그램을 실행할 때마다 불규칙적인 순서로 메소드 호출
	=> MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름을 오름차순 정렬하여 메소드 호출
*/
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() {
		/*
		Student student=new Student();
		student.setNo(7000);
		student.setName("로빈훗");
		student.setPhone("010-7841-3454");
		student.setAddress("서울시 중랑구");
		student.setBirthday("2000-09-10");
		*/
		/*	service클래스의 메소드를 호출해서 student 잘 출력되는지 에러도 잘 뜨는지 확인하려고 하는거임
		근데 이렇게 만드는 건 권장x >> [순서-40] - 주석 처리
		=> [순서-41] - 10.dto >> Student 클래스 - @Builder 추가
		 */
		
	/* [순서-42]
		Student 클래스의 builder() 메소드를 호출하여 StudentBuilder 객체를 제공받아 필드 관련 메소드로 필드값을 변경하고 build() 메소드를 호출하여 Student 객체를 반환받아 사용
	*/
		Student student=Student.builder()
				.no(7000)
				.name("로빈훗")
				.phone("010-7841-3454")
				.address("서울시 중랑구")
				.birthday("2000-09-10")
				.build();
		
		studentService.addStudent(student);
	}
	
	
	// [순서-43]
	@Test
	public void testGetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		
		for(Student student : studentList) {
			//DTO 클래스의 객체로 toString() 메소드를 호출하여 모든 필드값을 문자열로 반환받아 사용 가능
			log.info(student.toString());
		}
	
	//문제는 Test 클래스가 두 개 있는데 누가 먼저 실행될까유 testAddStudent()가 먼저 될 거 같쥬 응 아무도 몰라유 컴퓨터 맘이예유~ => [순서-44]하면 순서 정할 수 있어유
	}
}
