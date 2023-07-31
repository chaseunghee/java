package xyz.itwill07.aop;
//[순서-6] => [순서-7]07-1_aop.xml

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HewonAopApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-1_aop.xml");
		//[순서-8]
		HewonService service=context.getBean("hewonService", HewonService.class);
		service.addHewon(null);
		System.out.println("=============================================================");
		service.getHewon(0);
		System.out.println("=============================================================");
		service.getHewonList();
		System.out.println("=============================================================");		
		((ClassPathXmlApplicationContext)context).close();
	}

}
