package xyz.itwill06.oop;

/*[순서-4]

	횡단관심코드로 작성된 메소드가 선언된 클래스 - 횡단관심모듈 : Advice 클래스 : 각 관심사가 하는 실제 부가기능을 담은 구현체
*/
public class AopLogger {
	public void beforeLog() {
		//횡단관심코드
		System.out.println("### 메소드의 명령(핵심관심코드)이 실행되지 전에 기록될 내용 ###");
	}
}
