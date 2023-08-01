package xyz.itwill07.aop;

//[순서-1] - ExecutionTimeBean 클래스 생성 >> one, two 메소드 생성
public class ExecutionTimeBean {	
	/* [순서-5] - 횡단관심코드 - 순서1 이 실행되기 전에 순서5 먼저 
		
		System.currentTimeMillis() : 시스템의 현재 날짜와 시간에 대한 타임스탬프를 반환하는 메소드
		타임스탬프(TimeStamp) : 날짜와 시간을 정수값으로 변환한 값 - 
	*/
	//long startTime=System.currentTimeMillis();
	
	//[순서-1] - 핵심관심코드
	public void one() {
		long count=0;
		for(long i=1; i<=10000000000L; i++) {
			count++;
		}
		System.out.println("count = "+count);
		
		//[순서-6] - 횡단관심코드
		//long endTime=System.currentTimeMillis();
		//System.out.println("ExecutionTimeBean 클래스의 one() 메소드 실행 시간 = "+(endTime-startTime)+"ms");
	}
	
	//[순서-1] - 핵심관심코드
	public void two() {
		long count=0;
		for(long i=1; i<=20000000000L; i++) {
			count++;
		}
		System.out.println("count = "+count);
		
		//[순서-7] - 횡단관심코드
		//long endTime=System.currentTimeMillis();
		//System.out.println("ExecutionTimeBean 클래스의 two() 메소드 실행 시간 = "+(endTime-startTime)+"ms");
	}
}
//[순서-7]핵심관심코드와 횡단관심코드를 분리시켜서 one,two가 필요할때마다 가져다 쓸 수 있게 advice 클래스를 따로 만들어 작성 => ExecutionTimeAdvice
