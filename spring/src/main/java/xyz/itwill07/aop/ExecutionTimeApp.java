package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//[순서-2] - ExecutionTimeApp 클래스 생성 - ApplicationContext와 ClassPathXmlApplicationContext 코드
public class ExecutionTimeApp {
	//main 메소드 생성
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-4_timer.xml");//=>[순서-3] 07-4_timer.xml 파일 생성
		//[순서-4]
		ExecutionTimeBean bean=context.getBean("executionTimeBean", ExecutionTimeBean.class);
		System.out.println("==========================================================");
		bean.one();
		System.out.println("==========================================================");
		bean.two();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}
