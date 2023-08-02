package xyz.itwill08.dao;

import java.util.List;

//[순서-11]
public interface StudentService {
	void addStudent(Student student);
	void modifyStudent(Student student);
	void removeStudent(int no);
	Student getStudent(int no);
	List<Student> getStudentList();
}
