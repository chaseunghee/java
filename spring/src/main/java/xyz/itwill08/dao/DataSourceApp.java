package xyz.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

//[순서-1] - DataSourceApp 클래스 생성 

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
	DataSource 객체 : 다수의 Connection 객체를 미리 생성하여 저장하고 있는 객체 - DBCP(DataBase
	=> Spring Bean Configuration File에서 DataSource 인터페이스를 상속받은 자식클래스를 Spring Bean으로 등록하여 스프링 컨테이너에게 제공받아 사용
	방법-1 => DataSource 인터페이스를 상속받은 자식클래스는 Spring 프레임워크에서 제공하는 spring-jdbc 라이브러리를 빌드 처리 - 메이븐 사용 : pom.xml 
	-[순서-2]pom.xml >> Spring JDBC » 5.3.29, Ojdbc11 » 23.2.0.0 라이브러리 코드 복붙, Spring JDBC » 5.3.29의 version은 spring-framework와 동일하게 변경
	방법-2 => DataSource 관련 라이브러리 외에 Oracle Driver 관련 라이브러리도 프로젝트 빌드 처리 
*/

//[순서-1] 스프링 컨테이너에게 DataSource 객체를 제공받아 Connection 객체를 반환받아 사용
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml"); //[순서-3] 08_dao.xml 파일 생성
		//[순서-4]
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("=============================================================");
		System.out.println("dataSource = "+dataSource);
		System.out.println("=============================================================");
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("=============================================================");
		//[순서-1]
		((ClassPathXmlApplicationContext)context).close();
	}
}
