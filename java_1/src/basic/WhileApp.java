package basic;

//while : 조건에 의해 명령을 반복 실행
//=> 반복의 횟수가 명확하지 않은 경우 사용하는 반복문
//형식) while(조건식) {명령; 명령; ...}
//=> 조건식의 결과가 참인 경우 명령을 반복 실행하고 거짓인 경우 반복문 종료
//=> 조건식 생략 불가능
//=> 블럭 내부에 작성된 명령을 0번 이상 실행

//형식) do {명령; 명령; ... } while(조건식)
//=> 블럭 내부에 작성된 명령을 1번 이상 실행

public class WhileApp {
	public static void main(String[] args) {
		//"Java Programming"을 화면에 5번 출력하는 프로그램 작성
		int i=1;
		while(i<=5) {
			System.out.println("Java Programming");
			i++;
		}
		System.out.println("=========================================");

		//1~100범위의 정수들의 합계를 계사하여 출력하는 프로그램 작성
		int j=1, tot=0;
		do {
			tot+=j;
			j++;
		}while(j<=100);
		System.out.println("1~100범위의 정수들의 합계 = "+tot);
		System.out.println("=========================================");

		//A4용지를 반으로 계속 접어 펼쳤을 경우 사각형 모양의 개수가 500개 이상이 만들어지려면 몇 번
		//접어야 되는지를 계산하여 출력하는 프로그램 작성
		int cnt=0, gae=1; //cnt : 접는 횟수, gae: 사각형 모양의 개수
		while(gae<500) {//A4용지를 반으로 계속 접기 위한 행위를 제공하는 반복문
			cnt++;//접는 횟수는 1씩 증가
			gae*=2;//사각형 모양의 개수 2배씩 증가
		}
		System.out.println("총 "+cnt+"번 접으면 "+gae+"개의 사각형이 만들어집니다.");
		System.out.println("=========================================");

		//1~X 범위의 정수들의 합계가 300 이상이 만들어지려면 X가 얼마인지 계산하여 출력하는 프로그램 작성
		//ex) 1+2+3+...+X => 300
		int a=0, sum=0;
		do {
			a++;
			sum+=a;
		}while(sum<300);
		System.out.println("1~"+a+" 범위의 정수들의 합계 : "+sum);
		
		
		
		
	}

}
