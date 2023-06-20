package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	STUDENT 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 전달하여 응답하는 서블릿
	=> JDBC 프로그램을 작성하기 위해서는 JDBC 관련 라이브러리 파일(ojdbc 라이브러리)을 프로젝트 빌드처리
	순서1) STUDENT 테이블에 저장된 모든 학생정보를 검색 
	=> JDBC 관련 객체를 저장하기 위한 변수 선언
	
*/

@WebServlet("/old.itwill")
public class StudentDisplayOldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			제일 먼저 작성 - 헤더 
		*/
		response.setContentType("text/html;charset=utf-8"); //한글 안깨지게 작성
		PrintWriter out=response.getWriter(); //웹문서를 만들 수 있는 출력스트림 생성
		
		/*
			1) JDBC 관련 객체를 저장하기 위한 변수 선언 - 참조형 초기값 대부분 null
		 */
		Connection con=null; //접속
		PreparedStatement pstmt=null; //sql명령 저장 전달
		ResultSet rs=null; //select 결과 저장하기 위함 
		
		try {
			/*
				2) OracleDriver 클래스를 읽어 메모리에 저장
					=> OracleDriver 객체가 생성되어 DriverManager 클래스의 JDBC Driver로 등록
			*/
			Class.forName("oracle.jdbc.driver.OracleDriver"); //oracle dbms 접속하기 위해 driver 객체로 만들어서 등록해야함. - 클래스를 읽어들어서 메모리에 저장할 때  class.forname 안에 문자열로 전달된 읽어들어 메모리에 저장하면 자동으로 jdbc driver로 등록
			
			/*
				3) DriverManager 클래스에 등록된 JDBC 드라이버를 이용하여 DBMS 서버에 접속해 접속정보가 저장된 Connection 객체를 반환받아 저장
			*/
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott"; 
			String password="tiger";
			con=DriverManager.getConnection(url, username, password); // drivermanager로 getconnection 메소드 호출(서버에 접속하기 위한 자원정보 url,username,password 작성) - 성공X : sql exception 
																	  //																									   성공O : connection객체 반환
			
			/*
				4) Connection 객체로부터 SQL 명령이 저장된 PreparedStatement 객체를 반환받아 저장
			*/
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql); //connection 객체를 이용해 sql 매개변수 명령 prepareStatement 객체에 저장하여 전달
			
			/*
				5) PreparedStatement 객체에 저장된 SQL 명령을 DBMS 서버에 전달하여 실행한 후 실행결과를 반환받아 저장
			*/
			rs=pstmt.executeQuery(); 
			
			/*
				6) 반환받은 실행결과를 사용자에게 제공
			*/
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>학생목록</h1>");
			out.println("<hr>");
			out.println("<table border='1' cellspacing='0'>");
			out.println("<tr>");
			out.println("<th width='100'>학번</th>"); //컬럼명
			out.println("<th width='150'>이름</th>");
			out.println("<th width='200'>전화번호</th>");
			out.println("<th width='300'>주소</th>");
			out.println("<th width='250'>생년월일</th>");
			out.println("</tr>");
			
			/*
				7) ResultSet 객체에 저장된 모든 행의 컬럼값을 반환받아 클라이언트에 전달 - 반복처리
			*/
			while(rs.next()) { //rs 커서가 가르키는 행 
				out.println("<tr>");
				out.println("<td align='center'>"+rs.getInt("no")+"</td>"); //커서 위치 컬럼명 반환받아 컬럼값 cell에 포함
				out.println("<td align='center'>"+rs.getString("name")+"</td>");
				out.println("<td align='center'>"+rs.getString("phone")+"</td>");
				out.println("<td align='center'>"+rs.getString("address")+"</td>");
				out.println("<td align='center'>"+rs.getString("birthday").substring(0, 10)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (ClassNotFoundException e) {
			//2-1) 에러에 더블클릭하면 에러 위치 확인 가능 - forName
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		}catch (SQLException e) {
			//3-1)
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		}finally {//8) JDBC 관련 객체 제거
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
			}
		}
	}
}
