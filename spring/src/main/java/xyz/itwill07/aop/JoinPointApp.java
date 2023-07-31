package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//[순서-2]JoinPointApp 클래스 생성 후 코드 작성
public class JoinPointApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-2_param.xml");
		//=>[순서-3]07-2_param.xml 파일 생성 후 코드 작성 => [순서-4] 아래 코드
		JoinPointBean bean=context.getBean("joinPointBean",JoinPointBean.class);
		System.out.println("=============================================================");		
		bean.add();
		System.out.println("=============================================================");		
		bean.modify(100, "홍길동");
		System.out.println("=============================================================");		
		bean.remove(2000);
		System.out.println("=============================================================");		
		bean.calc(20, 10);
		System.out.println("=============================================================");		
		((ClassPathXmlApplicationContext)context).close();
	}
}
