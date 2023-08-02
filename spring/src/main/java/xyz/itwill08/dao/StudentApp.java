package xyz.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//[순서-14]
public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml"); //[순서-15] 08_dao.xml 파일 생성
		//[순서-16]
		StudentService service=context.getBean("studentService", StudentService.class);
		System.out.println("==========================================================");
		//[순서-23] - 삽입 확인 코드 (한번만 실행가능)
		Student newStudent=new Student();
		newStudent.setNo(6000);
		newStudent.setName("홍경래");
		newStudent.setPhone("010-3189-9622");
		newStudent.setAddress("서울시 도봉구");
		newStudent.setBirthday("1999-05-05");
		service.addStudent(newStudent);
		
		//[순서-22]
		List<Student> studentList=service.getStudentList();
		for(Student student : studentList) {
			System.out.println("학번 = "+student.getNo()+", 이름 = "+student.getName()
					+", 전화번호 = "+student.getPhone()+", 주소 = "+student.getAddress()+", 생년월일 = "+student.getBirthday());
		}
		System.out.println("=============================================================");
		//[순서-14]
		((ClassPathXmlApplicationContext)context).close();
	}
}
