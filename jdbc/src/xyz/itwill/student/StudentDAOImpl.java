package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.proxy.annotation.Pre;

//DAO 클래스를 만들면 프로그램을 만들어줘야함.(StudentCUIApp클래스)

/*
	DAO(Data Access Object) 클래스 : 저장매체에 행 단위 정보를 삽입,삭제,변경,검색하는 기능을 제공하는 클래스 - JDBC 기능을 구현해주는 클래스
		=> 저장매채 : 정보를 행단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 - DBMS 
		=> 인터페이스를 상속받아 작성하는 것을 권장 - 메소드 작성 규칙 제공 : 유지보수의 효율성 증가
		=> 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 - 프로그램에 하나의 객체만 제공되는 클래스 
*/

//반드시 StudentDAOImpl는 인터페이스(StudentDAO)를 상속받아서 오버라이드 해줘야함
/*
	STUDENT 테이블에 행을 삽입,삭제,변경,검색하는 기능의 메소드를 제공하는 클래스 
	=> 메소드는 SQL 명령에 필요한 값을 매개변수로 전달받아 하나의 SQL 명령을 DBMS로 전달하여 실행하고 실행결과를 Java 객체(값)으로 매핑하여 반환
	=>JdbcDAO 클래스를 상속받아 DAO 클래스의 메소드에서 JdbcDAO 클래스의 메소드 호출 가능
*/
public class StudentDAOImpl extends JdbcDAO implements StudentDAO {
	//싱글톤 
	private static StudentDAOImpl _dao;
	
	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAOImpl();
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 개수를 반환하는 메소드	
	@Override //SQL 명령 하나만 
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnnection();
			
			String sql="insert into student values(?,?,?,?,?)"; //StudentDTO 클래스가 가지고 있는 필드값들로 채워주면 됨(아래에 작성)
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			//executeUpdate :  수행결과로 Int 타입의 값을 반환, SELECT 구문을 제외한 다른 구문을 수행할 때 사용
			rows=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnnection();
			
			String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 개수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnnection();
			
			String sql="delete from student wherre no=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public StudentDTO selectStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		
		try { //select를 rs로 받아서 set으로 받아야함.
			con=getConnnection();
			
			String sql="select * from student where no=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			//ResultSet 객체가 저장된 검색행을 Java 객체(값)으로 매핑 처리
			//검색행이 0 또는 1인 경우 선택문 사용
			if(rs.next()) { //108행을 검색해서 검색행이 있는 경우 - 현재 행이 하나있음.
				student=new StudentDTO();
				
				//처리행의 컬럼값을 반환받아 DTO 객체의 필드값을 변경 처리
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("Address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			
		}
		//검색행이 없는 경우 - [null] 반환 / 검색행이 있는 경우 - [DTO 객체] 반환 - 검색행 하나를 반환한 것과 동일 
		return student;
	}

	//이름을 전달받아 STUDENT
	@Override
	public List<StudentDTO> selectNameStudentList(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<>();
		
		try {
			con=getConnnection();
			
			String sql="select * from student where name=?";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			//검색행이 0개 이상인 경우 반복문 사용 - while
			while (rs.next()) {
				StudentDTO student=new StudentDTO();
				
				//하나의 검색행을 DTO 객체로 매핑 처리
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("Address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				//List 객체에 DTO 객체를 요소로 추가
				studentList.add(student);
				
			}
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		
		//List객체를 반환하기 위해 List객체를 만들어줘야함
		return studentList;
	}

	@Override
	public List<StudentDTO> selectAllStudentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		List<StudentDTO> studentList=new ArrayList<>();
		
		try {
			con=getConnnection();
			
			String sql="select * from student";
			//no,name,phone,address, to_char (birthday,'yyyy-mm-dd') => substring 안써도 됨
			
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("Address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				studentList.add(student);
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}

}
