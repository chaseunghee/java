package xyz.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.mapper.StudentMapper;

//[순서-7] - StudentDAOImpl 클래스 - dao 생성 

/*  	
	SpringMVC 기능으로 웹프로그램 작성시 Mybatis 프레임워크를 이용하여 DAO 클래스를 작성하는 방법
	
	1. DataSource 관련 라이브러리와 Mybatis 관련 라이브러리를 프로젝트에 빌드 처리 - 메이븐 이용 : pom.xml 
	=> ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spring
	
	2. Mybatis 프레임워크의 환경설정파일(mybatis-config.xml) 작성 - settings 엘리먼트만 작성해주면 됨
	=> [src/main/webapp] 폴더에 작성해야만 스프링 컨테이너(WebApplicationContext 객체)가 Mybatis 프레임워크의 환경설정파일을 읽어서 SqlSessionFactory 클래스를 
	 	spring Bean으로 등록 처리 - 정석
	=> [src/main/java] 또는 [src/main/resource] 폴더에 Mybatis 프레임워크의 환경설정파일 작성 가능 - 얘도 가능은 함
	
	3. DataSource 관련 클래스, sqlSessionFactory 관련 클래스, SqlSession 관련 클래스를 Spring Bean으로 등록
	=> SpringMVC 프로그램에서 스프링 컨테이너를 초기화 처리하기 위한 Spring Bean Configuration File에서 bean 엘리먼트로 클래스를 Spring Bean으로 등록
	 	- root-context.xml(모든 controller에서 읽을 수 있음) 또는 servlet-context.xml(appServlet만 읽을 수 있음)
	
	4. 테이블 생성 >> DTO 클래스 작성 >> 매퍼 파일 작성 >> DAO 클래스 	
	
	DAO 클래스(Repository 클래스) : 저장매체(DBMS)에게 행에 대한 삽입, 변경, 삭제, 검색 기능을 제공하기 위한 클래스
	=> DAO 클래스의 메소드에서는 DBMS 서버에 SQL 명령을 전달하여 실행하고 실행결과를 Java 객체(값)으로 반환되도록 작성
	=> DAO 클래스가 변경돼도 의존관계로 설정된 Service 클래스의 영향을 최소화하기 위한 인터페이스를 상속받아 작성
	
	DAO 클래스는 Service 클래스의 객체로 제공받아 사용되도록 반드시 Spring Bean으로 등록
	=> DAO 클래스는 @Respository 어노테이션을 사용하여 Spring Bean으로 등록
	=> @Repository 어노테이션을 사용하면 SQL 명령으로 발생되는 예외(SQLException)를 Spring 예외로 제공되도록 처리 - 그래야 예외를 spring에서 잡을 수 있음
	=> @Repository 어노테이션을 스프링 컨테이너가 처리하기 위해 반드시 클래스가 작성된 패키지를 Spring Bean Configuration File(servlet-conext.xml)의 component-scan 엘리먼트로
		검색되도록 설정
		
	*1,2,3 은 한 번만 하면 됨,
	*4 는 테이블 만들때마다 무한반복 
	
	[순서-18]
*/
@Repository
/*
	final 제한자로 작성된 필드만 초기화 처리하는 생성자를 만들어주는 어노테이션
	=> 생성자가 하나만 작성된 경우 생성자에 @Autowired 어노테이션 생략 가능
*/
@RequiredArgsConstructor
public class StudentDAOImpl implements StudentDAO { //StudentDAO 인터페이스 상속
	/*
		Mybatis 프레임워크를 사용하여 DAO 클래스를 작성할 경우 매퍼에 등록된 SQL 명령을 제공받아 전달하여 실행하고 실행결과를 Java 객체(값)으로 반환받기 위해 
		SqlSession 객체 필요
		=> SqlSession 객체를 저장할 수 있는 필드를 선언하여 스프링 컨테이너가 관리하는 Spring Bean을 제공받아 의존성 주입(DI)
		=> 매개변수가 선언된 생성자를 작성하여 @Autowired 어노테이션을 사용하여 의존성 주입 - 순환참조 방지 
	*/
	//@Autowired - 말고 위에 @RequiredAragsConstructor를 사용하고 final로 주면 알아서 만들어줌
	private final SqlSession sqlSession;

	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}
	
	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}
	
}
