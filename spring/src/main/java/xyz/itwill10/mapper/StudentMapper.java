package xyz.itwill10.mapper;
//[순서-15]

import java.util.List;

import xyz.itwill10.dto.Student;

public interface StudentMapper {
	int insertStudent(Student student);
	List<Student> selectStudentList();
}

//=> 매퍼바인딩됨