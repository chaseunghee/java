package basic;

//break : switch 구문 또는 반복문을 강제로 종료하기 위해 사용하는 제어문

public class BreakApp {
	public static void main(String[] args) {
		//반복문은 조건식의 결과가 거짓인 경우 반복문 종료
		for(int i=1; i<=5; i++) {
			if(i==3) //if 구문의 종료가 참인 경우 break 구문을 이용하여 반복문 종료
				break;
			System.out.println(i+"\t");
		}
		System.out.println();
		System.out.println("=========================================");
		
		//반복문 작성시 반복문을 구분하기 위한 식별자(라벨명) 선언가능
		//형식) 라벨명:반복문
		loop:
			for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				//break라벨명 : 라벨명으로 지정된 반복문 종료
				if(j==3)
					break loop;//for(int j=1;j<=5;j++)반복문 종료
				System.out.println("i = "+i+", j = "+j);
			}
		}

	}

}
