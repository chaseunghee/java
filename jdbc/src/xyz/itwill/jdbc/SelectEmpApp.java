package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에 저장된 모든 사원정보의 사원번호,사원이름,급여를 급여로 내림차순 정렬되도록 검색하여 출력하는 JDBC 프로그램 작성
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="select * from emp order by sal desc"; //오라클에서 정렬된 순서대로 검색 (다중행)
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					int no=rs.getInt("empno");
					
					String name=rs.getString("ename");					
					String sal=rs.getString("sal");		
					
					System.out.println("사원번호= "+no);
					System.out.println("사원이름 = "+name);
					System.out.println("급여 = "+sal);

	
					System.out.println("==================================================");
	
				} while(rs.next()); //ResultSet 커서를 다음행으로 이동 - 처리행이 있는 경우 반복문 실행, 처리행의 없는 경우 반복문 종료
				
			} else { //ResultSet 커서 위치에 처리행이 없는 경우 - false
				System.out.println("[메세지]검색된 학생정보가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) rs.close();
				if(con!=null) rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}

}
