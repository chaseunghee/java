package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//[순서-5] - EmailSendApp 클래스 생성 후 메소드 작성
public class EmailSendApp {
	public static void main(String[] args) throws Exception { //main 메소드 생성
		ApplicationContext context=new ClassPathXmlApplicationContext("07-3_email.xml"); //=>[순서-6] 07-3_email.xml 파일 생성
		//[순서-8] - 아래코드		
		EmailSendBean bean=context.getBean("emailSendBean", EmailSendBean.class);
		System.out.println("=====================================================================");
		bean.sendEmail("csh3578@naver.com", "메일 전송 테이스", "<h1>JavaMail 기능을 사용하여 전달된 이메일입니다.<h1>");
		System.out.println("=====================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
