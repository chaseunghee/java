package xyz.itwill08.dao;

import java.util.List;

//[순서-6] - StudentDAO 인터페이스 생성
public interface StudentDAO {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int no);
	Student selectStudent(int no);
	List<Student> selectStudentList();
}
