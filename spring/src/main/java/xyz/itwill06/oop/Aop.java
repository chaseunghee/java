package xyz.itwill06.oop;
/*	[순서-1]

	횡단관심코드가 삽입될 핵심관심코드로 작성된 메소드를 추상메소드로 선언 - PointCut : JoinPoint의 부분 집합으로 실제 Advice가 적용되는 JoinPoint 
*/
public interface Aop {
	void display1(); //메소드들이 호출될 떄 횡단관심코드가 삽입되게 해줄 것
	void display2();
	void display3();
}