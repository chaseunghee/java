package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//[순서-7] - StudentDAOImpl 클래스 생성 

/*
	SpringDAO 기능을 이용하여 DAO 클래스 작성 - spring-jdbc 라이브러리를 프로젝트에 빌드 처리
	=> JDBCTemplate 객체의 메소드를 호출하여 DAO 클래스의 메소드 작성
*/
public class StudentDAOImpl implements StudentDAO{ //[순서-9] - StudentDAO 상속 >> 전부 override >> 순서대로 코드 작성
	/*[순서-8] - 필드 선언
		
		JDBCTemplate 객체를 저장하기 위한 필드 선언
		=> Spring Bean Configuration File에서 DAO 클래스를 Spring Bean으로 등록할 때 JdbcTemplate 클래스의 Spring Bean을 제공받아 의존성 주입 - Setter Injection
	*/
	@Setter
	private JdbcTemplate jdbcTemplate; //JdbcTemplate jdbcTemplate에 객체를 저장하는 것은 springbean이 함
	
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		/*
			JdbcTemplate.update(String sql, Object ...args) : SQL 명령(INSERT, UPDATE, DELETE)을 DBMS 서버에 전달하여 실행하는 메소드 - 조작행의 개수(int)반환
			=> 매개변수에는 DBMS 서버에 전달하여 실행할 SQL 명령과 InParameter(?) 대신 사용될 값을 차례대로 나열하여 제공 
			=> SQL 명령의 InParameter(?) 개수만큼 반드시 args 매개변수에 값을 전달
			
			-String sql : sql 명령
			-Object ...args : InParameter 대신에 사용될 것 0개 이상
		*/
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
		}
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 개수를 반환하는 메소드
	@Override
		public int updateStudent(Student student) {
			String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
			return jdbcTemplate.update(sql, student.getName(), student.getPhone(), student.getAddress(), student.getBirthday(), student.getNo());
		}
	
	//학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 개수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}
	
	/*
	//학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 DTO 객체로 반환하는 메소드 - 매핑 간단하게 사용할 때
	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select no, name, phone, address, birthday from student where no=?";
			
			JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
			=> SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
			=> 단일행의 검색결과를 하나의 Java 객체로 반환하기 위해 사용
			=> 매개변수에는 DBMS 서버에 전달하여 실행할 SQL 명령과 검색행을 Java 객체로 변환하기 위한 매핑정보를 제공하는 RowMapper 객체와 InParameter(?) 대신 사용될 값을 
				차례대로 나열하여 제공

			RowMapper 객체 : 검색행을 Java 객체로 변환하여 제공하기 위한 매핑정보가 저장된 객체
			=> 검색행의 컬럼값을 Java 객체 필드에 저장하기 위한 매핑정보 제공
			=> RowMapper 인터페이스를 상속받은 자식클래스로 객체 생성 - 익명의 내부클래스로 객체 생성 가능
			=> RowMapper 객체를 생성할 때 사용되는 제네릭<>에는 변환할 Java 객체의 자료형을 설정
			=> RowMapper 인터페이스를 상속받은 자식클래스는 mapRow() 추상메소드를 오버라이드 선언
			=> mapRow() 메소드의 매개변수로 검색결과(ResultSet 객체)를 제공받아 Java 객체로 변환하는 명령 작성  
			
			return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() { //new RowMapper<Student>: 검색행을 이용하여 Student 객체 만들어줌
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student=new Student();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					return student;
				}
			},no);
		}catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObeject() 메소드로 전달된 SELECT 명령에 대한 검색행이 없는 경우 발생되는 예외
			return null;
		}
	}
	*/
	
	//학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 DTO 객체로 반환하는 메소드 - 매핑정보를 자주 사용할 때 [순서-10]과 연관
	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select no, name, phone, address, birthday from student where no=?";
			/*
				JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
				=> SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
				=> 단일행의 검색결과를 하나의 Java 객체로 반환하기 위해 사용
				=> 매개변수에는 DBMS 서버에 전달하여 실행할 SQL 명령과 검색행을 Java 객체로 변환하기 위한 매핑정보를 제공하는 
					RowMapper 객체와 InParameter(?) 대신 사용될 값을 차례대로 나열하여 제공
			*/
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() 메소드로 전달된 SELECT 명령에 대한 검색행이 없는 경우 발생되는 예외
			return null;
		}
	}
	
	
	/*
	//STUDENT 테이믈에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드 - 매핑 간단하게 사용할 때 
	@Override
	public List<Student> selectStudentList() {
		String sql="select no, name, phone, address, birthday from student order by no";
			JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
			=> SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
			=> 단일행의 검색결과를 하나의 Java 객체로 반환하기 위해 사용 - 하나의 검색행은 List 
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				return student;
			}
		});
	}
	 */
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 메소드 - 매핑정보를 자주 사용할 때 [순서-10]과 연관
	@Override
	public List<Student> selectStudentList() {
		String sql="select no, name, phone, address, birthday from student order by no";
		/*
			JdbcTemplate.query(String sql, RowMapper<T> rowMapper, Object ... args)
			=> SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
			=> 다수행의 검색결과를 List 객체로 반환하기 위해 사용 - 하나의 검색행은 List 객체의 요소로 저장
			=> 매개변수에는 DBMS 서버에 전달하여 실행할 SQL 명령과 검색행을 Java 객체로 변환하기 위한 매핑정보를 제공하는 
				RowMapper 객체와 InParameter(?) 대신 사용될 값을 차례대로 나열하여 제공
		*/
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	/* [순서-10] - 매핑정보를 자주 사용할 때의 방법- RowMapper를 상속받은 StudentRowMapper 클래스 생성 >> 위 주석처리(매핑 간단하게 사용할 때) 후 밑에 코드 
		
		RowMapper 객체를 생성하기 위해 내부 클래스 선언
		RowMapper 객체 : 검색행을 Java 객체로 변환하여 제공하기 위한 매핑정보가 저장된 객체
		=> 검색행의 컬럼값을 Java 객체 필드에 저장하기 위한 매핑정보 제공
		=> RowMapper 인터페이스를 상속받은 자식클래스로 객체 생성 - 익명의 내부클래스로 객체 생성 가능
		=> RowMapper 객체를 생성할 때 사용되는 제네릭에는 검색행을 변환할 Java 객체의 자료형을 설정
		=> RowMapper 인터페이스를 상속받은 자식클래스는 mapRow() 추상메소드를 오버라이드 선언
		=> mapRow() 메소드의 매개변수로 ResultSet 객체를 제공받아 Java 객체로 변환하는 명령 작성
	*/
	public class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		}
	}
}
