package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.Student;

//[순서-20]

public interface StudentService {
	void addStudent(Student student);
	List<Student> getStudentList();
}
