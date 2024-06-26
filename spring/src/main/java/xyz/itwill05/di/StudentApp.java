package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		System.out.println("===============Spring Container 초기화 전 =================");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("===============Spring Container 초기화 후 =================");
		Student student1=context.getBean("student1", Student.class);
		//참조변수를 출력할 경우 참조변수에 저장된 객체로 toString() 메소드 자동 호출 - 객체의 필드값 사용 
		System.out.println(student1); //05-1_di.xml에서 값 저장 안했으므로 기본값 출력 
		System.out.println("=======================================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2); //생성자 매개변수로 값 저장 (constructor-arg- value 속성, type 속성)
		System.out.println("=======================================================================");
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3); //생성자 매개변수에 값을 index 속성으로 설정(constructor-arg-value속성, index 속성)
		System.out.println("=======================================================================");
		Student student4=context.getBean("student4", Student.class); //기본생성자를 사용하여 setter메소드로 초기화
		System.out.println(student4); //기본생성자를 사용하여 객체 필드에 기본값 저장(property-name 속성,value속성)
		System.out.println("=======================================================================");
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5); //생성자인젝션(student2)+ Setter인젝션(student3)
		System.out.println("=======================================================================");	
		Student student6=context.getBean("student6", Student.class);
		System.out.println(student6); // PropertySourcesPlaceholderConfigurer 클래스를 사용하여 Properties 파일에 제공받아 사용 - property - name속성, value속성${}
		System.out.println("=======================================================================");	
		//프로그램 실행에 필요한 데이타 처리 기능을 제공하는 Service 객체를 제공받아 저장
		//StudentServiceImpl service=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
		//클래스로 참조변수(필드)를 생성하여 객체를 저장하는 것보다 인터페이스로 참조변수(필드)를 생성하여 객체를 저장하는 것이 유지보수의 효율성을 증가하는 방법
		StudentService service=context.getBean("studentServiceImpl", StudentService.class);

		//Service 객체의 메소드를 호출하여 데이타 처리 기능 구현
		service.addStudent(student1);
		service.modifyStudent(student1);
		service.removeStudent(1000);
		service.getStudent(1000);
		service.getStudentList();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}