package xyz.itwill05.di;

import java.util.List;

/*
	◈순서-5 : Spring Bean Configuration File
*/
public class StudentMybatisDAO implements StudentDAO{
	public StudentMybatisDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentMybatisDAO 클래스의 insertStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentMybatisDAO 클래스의 updateStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentMybatisDAO 클래스의 deleteStudent(int num) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentMybatisDAO 클래스의 selectStudent(int num) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentMybatisDAO 클래스의 selectStudentList() 메소드 호출 ***");
		return null;
	}

}