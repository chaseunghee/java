package xyz.itwill.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

/* [순서-35] 

	Spring 프레임워크를 사용하여 테스트 프로그램을 작성하여 모듈(단위 프로그램) 테스트하는 방법
	=> SpringMVC 프로그램에서 사용하는 모듈 : DAO 클래스, Service 클래스, Controller 클래스 (얘네3개가 가지고 있는 메소드를 테스트 하는거임)
	
	1. junit 라이브러리와 spring-test 라이브러리를 프로젝트 빌드 처리 - 메이븐 : pom.xml
	=> [순서-36] - pom.xml에 test - 이미 있음
	=> [순서-37] - pom.xml >> Spring TestContext Framework » 5.3.29 코드 복붙 후 version - springframework와 동일하게 변경
	
	2. 테스트 프로그램에서 사용될 로그 구현체에 대한 환경설정파일 변경
	=> [순서-34]에서 함 
	
	3. [src/test/java] 폴더에 테스트 프로그램 관련 클래스 작성
	=> junit 라이브러리와 spring-test 라이브러리의 scope 속성을 주석 처리한 후 테스트 프로그램
	=> [순서-38] - pom.xml의 test-scope 주석 + junit 주석
	
	4. 테스트 프로그램을 실행하여 모듈 검사
*/

//[순서-39] - 아래 코드 쭈욱

@RunWith(SpringJUnit4ClassRunner.class)
/*
	@RunWith : 테스트 프로그램을 실행하기 위한 실행 클래스를 설정하는 어노테이션
	=> 테스트 프로그램 관련 클래스를 객체로 생성하여 메소드를 호출하기 위한 클래스 지정
	
	value 속성 : 테스트 프로그램을 실행하기 위한 클래스(Class 객체)를 속성값으로 설정
	=> 다른 속성이 없는 경우 속성값만 설정 가능
	
	SpringJUnit4ClassRunner 클래스를 사용하여 테스트 프로그램을 실행할 경우 자동으로 스프링 컨테이너(ApplicationContext 객체)를 생성하여 제공
*/
/*
	@ContextConfiguration : 테스트 프로그램에서 사용될 Spring Bean를 제공하기 위한 Spring Bean Configuration File을 설정하기 위한 어노테이션
	
	locations 속성 : Spring Bean Configuration File의 경로를 요소로 저장한 배열을 속성값으로 설정
	=> Spring Bean Configuration File의 경로는 file 접두사를 사용하여 파일 시스템 형식으로 표현하여 제공
*/
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class DataSourceTest {
	/*
		테스트 클래스의 메소드에서 사용할 객체를 저장하기 위한 필드 선언 
		=> 필드에 @Autowired 어노테이션을 사용하여 의존성 주입 - 생성자를 이용한 의존성 주입 불가능  
	*/
	@Autowired
	private DataSource dataSource; //생성자로 의존성 주입x 
	
	/*
		@Test : 테스트 메소드를 설정하는 어노테이션 - 테스트 명령을 작성하여 실행
		=> SpringJUnit4ClassRunner 클래스에 의해 테스트 프로그램 관련 클래스가 객체로 생성된 후 자동 호출 메소드
	*/
	@Test
	public void testDataSource() throws SQLException { //우리가 호출하는 게 아니라 junit이 호출하는거임
		log.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		log.info("Connection = "+connection);
		connection.close();
	}
}
