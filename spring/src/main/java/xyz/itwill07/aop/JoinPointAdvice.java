package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//[순서-5]JoinPointAdvice 클래스 생성

//횡단관심모듈 - Advice 클래스
public class JoinPointAdvice {
	/* [순서7] 
		Around Advice Method를 제외한 나머지 Advice Method는 일반적으로 반환형을 [void]로 작성하고 매개변수를 작성하지 않거나 JoinPoint 인터페이스로 작성된 매개변수 선언 가능
		=> Advice 클래스의 메소드를 작성 규칠에 맞지 않게 작성할 경우 IllegalArgumentException 발생
		
		JoinPoint 객체 : 타겟 메소드 관련 정보가 저장된 객체
		=> 스프링 컨테이너가 Advice 클래스의 메소드를 호출할 때 타켓 메소드 관련 정보를 저장한 JoinPoint 객체를 생성하여 매개변수에 전달
		=> Advice 클래스의 메소드에서 타겟 메소드 관련 정보가 필요한 경우 매개변수를 선언하여 JoinPoint 객체를 전달받아 메소드를 호출하여 필요한 정보를 반환받아 사용 가능
	*/
	//Before Advice Method
	public void beforeDisplay(JoinPoint joinPoint) {
		/*
			joinPoint.getTarget() : 타겟 메소드를 호출한 객체(핵심관심모듈의 Spring Bean)를 반환
			Object.getClass() : 객체를 생성한 클래스의 Class 객체(Clazz)를 반환하는 메소드
			
			Class.getName() : Class 객체에 저장된 클래스의 이름(패키지 포함)을 반환하는 메소드
		System.out.println(joinPoint.getTarget().getClass().getName());
			
			Class.getSimpleName() : Class 객체에 저장된 클래스의 이름(패키지 제외)을 반환하는 메소드
		System.out.println(joinPoint.getTarget().getClass().getSimpleName()); 
		
			JoinPoint.getSignature() : 타겟 메소드의 메소드가 저장된 Signature 객체를 반환하는 메소드
			Signature.getName() : 타겟 메소드의 이름을 반환하는 메소드
		System.out.println(joinPoint.getSignature().getName());
		
			JoinPoint.getArags() : 타겟 메소드의 매개변수에 저장된 모든 값(객체)을 제공받아 Object 배열로 반환하는 메소드 
		System.out.println(joinPoint.getArgs());
		*/
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		Object[] params=joinPoint.getArgs();
		
		System.out.print("### [before]"+className+" 클래스의 "+methodName+"(");
		
		for(int i=0; i<params.length; i++) {
			System.out.print(params[i]);
			
			if(i<params.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(") 메소드 호출 ###");
	}			
	
	//[순서-10]
	//After Advice Method
	public void displayMessage(JoinPoint joinPoint) {
		Object[] params=joinPoint.getArgs();
		System.out.println("### [after] 사원번호가 "+params[0]+"인 사원정보를 삭제하였습니다.");
	}
	
	/*[순서-13] - displayName메소드 작성
	  After Returning Advice Method
	  => JoinPoint 인터페이스의 매개변수 외에 Object 클래스의 매개변수 선언 가능
	  => 스프링 컨테이너는 Object 클래스의 매개변수에 타겟 메소드의 반환값을 제공받아 전달
	  => 타겟 메소드에서 반환되는 값(객체)의 자료형이 고정되어 있는 경우 Object 클래스 대신 반환되는 값(객체)의 자료형으로 매개변수 작성 가능
	  
	  [순서-14] - 07-2_param.xml 
	  =>Object 클래스의 매개변수가 선언된 경우 Spring Bean Configuration File의 AOP 설정에서 after-returning 앨리먼트에 반드시 returning 속성을 사용하여 
	  	반환값을 저장할 매개변수의 이름을 속성값으로 지정해야함
	  => after-returning 엘리먼트에 returning 속성이 없거나 속성값이 잘못된 경우 IllegalIrgumentException 발생
	*/
	public void displayName(JoinPoint joinPoint, Object object) {
		String methodName=joinPoint.getSignature().getName();
		String userName=(String)object;
		System.out.println("### [after-returning]"+methodName+" 메소드의 반환값 = "+userName);
	}
	
	/*[순서-18] - exceptionHandle 메소드 작성
	  After  Throwing Advice Method에는 JoinPoint 인터페스의 매개변수 외에 Exception 클래스의 매개변수 선언 가능
	  => 스프링 컨테이너는 Exception 클래스의 매개변수에 타겟베소드에서 발생된 예외(Exception)를 제공받아 전달
	  => 타겟메소드에서 발생되는 예외가 고정되어 있는 경우 Exception 클래스 대신 필요한 예외 클래스로 매개변수 작성 가능
	  
	  [순서-19] - 07-2_param.xml 코드 작성
	  => Exception 클래스의 매개변수가 선언된 경우 Spring Bean Configuration File의 AOP 설정에서 매개변수의 이름을 속성값으로 지정
	  => after-returning 엘리먼트에 throwing 속성값이 잘못된 경우 IllegalArgumentException 발생
	*/
	
	public void exceptionHandle(JoinPoint joinPoint, Exception exception) {
		String methodName=joinPoint.getSignature().getName();
		
		System.out.println("###[after-thorwing]"+methodName+" 메소드에서 발생된 예외 = "+exception.getMessage());
	}
	
	/*[순서-20]
		Around Advice Method는 반환형을 Object 클래스로 작성하고 매개변수의 자료형은 ProceedingJoinPoint 인터페이스로 작성하여 선언
		=> 타겟메소드의 반환값을 제공받아 반환 처리하기 위해 Object 타입의 클래스로 반환형 작성
		=> 타겟메소드 관련 정보를 ProceedingJoinPoint 인터페이스의 매개변수로 제공받아 Around Advice Method에서 사용
		
		ProceedingJoinPoint 객체 : 타겟메소드 관련 정보를 저장하기 위한 객체
		=> JoinPoint 객체와 다른점은 타겟메소드를 직접 호출하기 위한 메소드 제공
	*/
	public Object display(ProceedingJoinPoint joinPoint) throws Throwable { //void도 가능하나 Object를 많이 사용
		System.out.println("### [around]핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드 ###");
		/*
			ProceedingJoinPoint.proceed() : 타겟메소드를 호출하는 메소드 - 핵심관심코드 실행
			=> 타겟메소드를 호출하여 반환되는 결과값을 변수에 저장 - 반환처리하기 위함
			=> Throwable(Error 클래스와 Exception 클래스의 부모클래스 => 모든 에러) 객체가 발생되므로 반드시 예외 처리하거나 예외 전달
		*/
		Object result=joinPoint.proceed(); //빨간줄 에러발생시 throws로 떠넘기면 됨
		System.out.println();
		return result; //타겟메소드의 반환값을 반환 처리
	}
	
	
	/*[순서-15]
		public void exceptionHandle() {
			//After Throwing Advice Method
			System.out.println("### [after-throwing] 핵심관심코드 실행시 예외가 발생된 경우 삽입되는 횡단관심코드 ###");
		}
	*/
	
	/*[순서-5-1]
		public void beforeDisplay() {
			//Before Advice Method => [순서-6]07-2_param.xml
			System.out.println("### [before] 핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드 ###");
	*/
	
	/* [순서-8] => [순서-9] 07-2_param.xml 코드
		public void displayMessage() {
			//After Advice Method
			System.out.println("### [after] 핵심관심코드 실행 후 무조건 삽입되어 실행될 횡단관심코드 ###");
		}
	 */
	
	/*[순서-11]=> [순서-12] 07-2_param.xml
		public void displayName() {
			//After Returning Advice Method
			System.out.println("### [after-returning] 핵심관심코드가 정상적으로 실행 후 삽입되어 실행될 횡단관심코드 ###");
	}
	*/
	
	/*[순서-15]
	public void exceptionHandle() {
		//After Throwing Advice Method
		System.out.println("### [after-throwing] 핵심관심코드 실행시 예외가 발생된 경우 삽입되는 횡단관심코드 ###");
	}
	 */
}
