package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
// => 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int count=0;
		int[] num = new int[10];
		int computer=(int)(Math.random()*100)+1;
			while(true) {
				int user;

				loop : while(true) {
					System.out.println("정수 난수값을 입력하세요.");
					for(int i=0; i<num.length; i++) {
						user=scanner.nextInt();
						if(user>0&&user<=100)break loop;
						System.out.println("[에러]1~100 범위의 정수 난수값을 입력하세요.");
					}
				}
				
				System.out.println("컴퓨터 >> "+computer);
				System.out.println("사용자 >> "+user);
				if(computer>user) {
					System.out.println("큰 값 입력");
				}else if(computer<user) {
					System.out.println("작은 값 입력");
				}else {
					System.out.println(count++);
					System.exit(0);
				}
				if(num.length<user) {
					System.out.println(computer);
				}
			
			}
	}
}
	

