package xyz.itwill10.dao;

import java.util.List;

import xyz.itwill10.dto.Student;

//[순서-6] - StudentDAO 인터페이스 - dao 생성

public interface StudentDAO {
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int no);
	Student selectStudent(int no);
	List<Student> selectStudentList();
}
