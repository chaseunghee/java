package xyz.itwill10.controller;
//[순서-1] - StudentController 클래스 생성

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

/*
	◈SpringMVC 기능을 사용하여 웹프로그램을 작성하는 방법
	=> 테이블 >> DTO 클래스 >> DAO 클래스(Mybatis) >> Service 클래스 >> Controller 클래스(요청처리메소드-백엔드) >> 테스트 프로그램(Junit) - 단위 프로그램(모듈) 테스트
		>> HTML 문서를 JSP 문서로 변환 >> 통합 프로그램 테스트 - 브라우저 이용
	
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
	[순서-2] - 테이블 생성 -student 테이블이 이미 만들어져 있으므로 생략 
	
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	[순서-28] - StudentController 실행 시 기록안됨 => 기록되게끔 해볼거임
	
	Mybatis 프레임워크에서 발생되는 로그 이벤트를 Spring 프레임워크의 로그 구현체
	1. log4jdbc-log4j2-jdbc4 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
	=> [순서-29] - pom.xml 파일 >> Log4Jdbc Log4j2 JDBC 4 » 1.16 코드 복붙
	
	2. Spring Bean Configuration File(root-context.xml)에서 DataSource 관련 클래스를 Spring Bean으로 등록한 bean 엘리먼트의 driverClassName 필드와 url 필드의 값을 변경 
	=> [순서-30] - root-context.xml 파일 코드 [순서-10] 주석 >> 코드 작성 

	3. [src/main/resources] 폴더에 [log4jdbc.log4j2.properties] 파일 작성
	=> Mybatis 프레임워크에서 발생되는 로그 이벤트를 Spring 프레임워크의 로그 구현체에게 제공하기 위한 Delegator 클래스를 지정하기 위한 파일
	=> [순서-31] - src/main/resources 폴더 >> log4jdbc.log4j2. properties 파일 생성 및 코드 작성
	
	4. SpyLogDelegator 객체에 의해 발생된 로그 이벤트를 Spring 프레임워크의 로그 구현체로 기록되도록 환경설정파일 변경 - log4j.xml : logger 엘리먼트 추가
	=> [순서-32] - log4j.xml 파일 >> logger 6개 코드 추가 작성(주석한 건 굳이 하지마셈 , 하고싶으면 그 아래꺼 하셈)
	
	--------------------------------------------------------------------------------------------------------------------------------------------------------------------

	[순서-24] - 밑에 주석 + @Controller + 코드 
	
	Controller 클래스 : 클라이언트의 요청을 처리하기 위한 기능을 제공하기 위한 클래스
	
	Controller 클래스는 Front Controller(DispatchServlet 클래스)에게 객체로 제공되어 사용되도록 반드시 Spring Bean으로 등록
	=> Controller 클래스는 @Controller 어노테이션을 사용하여 Spring Bean으로 등록
	=> @Controller 어노테이션을 사용하면 클라이언트 요청에 의해 호출되는 요청 처리 메소드 작성
	=> @Controller 어노테이션을 스프링 컨테이너가 처리하기 위해 반드시 클래스가 작성된 패키지를 
		Spring Bean Configuration File(servlet-context.xml)의 component-scan 엘리먼트로 검색되도록 설정
*/
@Controller
@RequiredArgsConstructor
/* [순서-33]
	
	@RequestMapping 어노테이션을 클래스에 선언하면 Controller 클래스의 모든 요청 처리 메소드의 요청 URL 주소 앞부분에 공통적으로 포함될 URL 주소 제공
	
	value 속성 : 모든 요청 처리 메소드의 요청 URL 주소 앞부분에 삽입된 URL 주소를 속성값으로 설정
	=> 다른 속성이 없는 경우 속성값만 설정 가능
*/
@RequestMapping("/student")
public class StudentController {
	/*
		Controller 클래스의 요청 처리 메소드에서 사용될 Service 클래스의 객체를 저장하기 위한 필드
		=> 생성자를 이용하여 필드에 Service 클래스의 객체(Spring Bean)가 저장되도록 의존성 주입
	*/
	private final StudentService studentService;
	
	//요청 처리 메소드 생성 - 아래 코드 전부
	
	//학생정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드 - GET 방식 요청
	@RequestMapping(value="/add", method=RequestMethod.GET) //value="/student/add"
	public String add() {
		return "student/student_add"; //=> [순서-25] - student폴더 안에 student_add.jsp 파일 생성 
	}
	
	
	/*
		전달값(학생정보)를 제공받아 STUDENT 테이블에 삽입처리하는 학생목록을 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드 - POST 방식 요청
	 	=> Service 클래스의 객체로 메소드를 호출하여 데이터 처리 기능 구현
	*/
	@RequestMapping(value="/add", method=RequestMethod.POST) //value="/student/add"
	public String add(@ModelAttribute Student student, Model model) {
		//[순서-27] - try-catch문 추가 작성
	
		try {
			//Service 클래스의 메소드 호출 시 예외 발생 - 중복된 학생번호가 전달되어 PK 제약조건 위반 
			studentService.addStudent(student);			
		} catch (Exception e) {
			model.addAttribute("message", "이미 사용중인 학생번호를 입력하였습니다.");
		}
		return "redirect:/student/display"; //리다이렉트 이동 => [순서-26] - student폴더 안에 student_display.jsp 파일 생성 
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 속성값으로 저장하고 학생목록을 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping("/student/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/student_display"; //=> [순서-26] - student폴더 안에 student_display.jsp 파일 생성 
	}
}
