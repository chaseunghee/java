package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
	키보드로 SQL 명령을 입력받아 DBMS 서버에 전달하여 실행하고 실행결과를 출력하는 JDBC 프로그램 작성
	=> 키보드로 INSERT,UPDATE,DELETE,SELECT 명령만 입력받아 전달받아 실행
	=> SQL 명령은 [exit] 명령을 입력하기 전까지 반복적으로 입력받아 실행 -대소문자 미구분
	=> 입력받은 SQL 명령이 잘못된 경우 에러 메세지 풀력
*/
public class SqlMinusApp {
	public static void main(String[] args) throws Exception {
		//키보드로 SQL 명령을 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=null;
		
		System.out.println("SQLMinus 프로그램을 실행합니다.(종료 : exit)");
		
		while(true) { 
			//키보드로 SQL 명령을 입력받아 저장
			System.out.println("SQL> ");
			
			//키보드로 입력받은 문자열의 앞과 뒤에 존재하는 모든 공백을 제거한 후 변수에 저장
			String sql=in.readLine().trim();
			
			//키보드 입력값이 없는 경우 반복문을 처음부터 다시 실행
			if(sql==null || sql.equals("")) continue;
			
			//키보드 입력값이 [exit]인 경우 반복문 종료 - 프로그램 종료
			if(sql.equalsIgnoreCase("exit")) break;
			
			String sql1="select * from student where name = ? order by no";
			rs=stmt.executeQuery(sql1);
			//입력받은 SQL 명령을 전달하여 실행하고 실행결과를 반환받아 출력
			if(sql=="select") {
				System.out.println("<<학생 정보 출력>>");
				while(rs.next()) {
					System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name")
						+", 전화번호 = "+rs.getString("phone")+", 주소 = "+rs.getString("address")
						+", 생년월일 = "+rs.getString("birthday").substring(0, 10));
				}
				System.out.println("======================================================================");
			}else if(sql=="select")
			ConnectionFactory.close(con, stmt, rs);
		}
	}
}