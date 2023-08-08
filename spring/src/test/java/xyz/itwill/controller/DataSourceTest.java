package xyz.itwill.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/* [순서-35] 

	Spring 프레임워크를 사용하여 테스트 프로그램을 작성하여 모듈(단위 프로그램) 테스트하는 방법
	=> SpringMVC 프로그램에서 사용하는 모듈 : DAO 클래스, Service 클래스, Controller 클래스 (얘네3개가 가지고 있는 메소드를 테스트 하는거임)
	
	1.
	=> [순서-36] - pom.xml에 test - 이미 있음
	=> [순서-37] - pom.xml >> Spring TestContext Framework » 5.3.29 코드 복붙 후 version - springframework와 동일하게 변경
	
	2. 
	=> [순서-34]에서 함 
	
	3.
	=> [순서-38] - pom.xml의 test-scope 주석 + junit 주석
	
	4.
*/
@Slf4j
/*
	@RunWith : 
	=> 
	
	value 속성 : 
*/
@Runwith
public class DataSourceTest {
	/*
		테스트 클래스의 메소드에서 사용할 객체를 저장하기 위한 필드 선언 
		=> 
	*/
	@Autowired
	private DataSource dataSource; //생성자로 의존성 주입x 
	
	/*
		@Test : 
	*/
	@Test
	public void testDataSource() { //우리가 호출하는 게 아니라 junit이 호출하는거임
		log.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		log.info("Connection = "+connection);
	}
}
