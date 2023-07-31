package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

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
	
}
