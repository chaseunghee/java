package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/*
	JDBC 기능을 제공하는 DAO 클래스가 상속받아 사용하기 위한 작성된 부모 클래스
	=> WAS 프로그램에 의해 관리되는 DataSource 객체를 제공받아 필드에 저장 - 정적영역에서 작성하여 한 번만 실행 
	=> DataSource 객체로부터 Connection 객체를 제공받아 반환하는 메소드
	=> 매개변수로 전달받은 JDBC 관련 객체를 제거하는 메소드
*/
public class JdbcDAO { //상속만을 목적으로 작성된 클래스
	/*
		ConnectionPool에는 여러개의 Connection 객체가 생성되어 운용되는데 직접 애플리케이션에서 다루기 힘들기 때문에 DataSource라는 개념 도입하여 사용
		
		DataSource : ConnectionPool의 Connection 관리하기 위한 객체
					 JNDI Server 통해서 이용
					 DataSource 객체를 통해서 필용한 Connection을 획득,반납 등의 작업함
					 
		DataSouce 사용 순서 - 1) JNDI Server에서 lookup() 메소드를 통해 DataSource 객체 획득
							- 2) DataSource 객체의 getConnection() 메소드를 통해서 Connection Pool에서 Free 상태의 Connection 객체 획득
							- 3) Connection 객체를 통한 DBMS 작업 수행
							- 4) 모든 작업이 끝나면 DataSource 객체를 통해서 Connection Pool에 Connection 반납
	*/
	private static DataSource dataSource;
	
	static {
		try {
			dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//DataSource 객체로부터 Connection 객체를 제공받아 반환하는 메소드
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//매개변수로 Connection 객체를 제공받아 제거
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}