package basic;

public class MultiForApp {
	public static void main(String[] args) {
		int cnt=0; //이동방법의 개수를 저장하기 위한 변수
		
		for(int i=1; i<=3; i++) { //A나라 >> 섬 - 반복문
			for(int j=1; j<=4; j++) { //섬 >> B나라 - 반복문
				cnt++;
			}
		}
		System.out.println("이동방법의 개수 = "+cnt);
		System.out.println("=========================================");
		
		//★★★★★★★
		System.out.print("★★★★★★★");
		System.out.println("");
		System.out.println("=========================================");

		//★★★★★★★
		for(int i=1; i<=7; i++) {
			System.out.print("★");
		}
		System.out.println("");
		System.out.println("=========================================");

		//★★★★★★★
		//★★★★★★★
		//★★★★★★★
		//★★★★★★★
		for(int j=1; j<=4; j++) { //Low행 처리 반복문
			for(int i=1; i<=7; i++) { //Column열 처리 반복문
				System.out.print("★");
			}
			System.out.println("");
		}
		System.out.println("=========================================");
		
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		//2*=	3*=		...		8*=		9*=
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.print(j+"*=\t");
			}
			System.out.println();
		}
		System.out.println("=========================================");

		for(int i=1; i<=9; i++) {
			System.out.println(i+"단");
			for(int j=1; j<=9; j++) {
				System.out.println(i+" * "+j+ " = "+(i*j));
			}
		}
		System.out.println("=========================================");

		for(int i=1; i<=9; i++) {
			System.out.print(i+"단\t\t");
		}
		System.out.println();
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.print(j+" * "+i+ " = "+(i*j)+"\t");
			}
			System.out.println();
		}
		System.out.println("=========================================");

		//★ 		i=1 별=1
		//★★
		//★★★
		//★★★★
		//★★★★★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=========================================");

		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=========================================");

		//☆☆☆☆★ 		i=1 흰별=4 검은별=1
		//☆☆☆★★
		//☆☆★★★
		//☆★★★★
		//★★★★★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=(5-i); j++) {
				System.out.print("☆");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=========================================");

		//☆☆☆☆★ 		i=1 흰별=4 검은별=1
		//☆☆☆★★
		//☆☆★★★
		//☆★★★★
		//★★★★★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i+j<6) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		System.out.println("=========================================");
	}
}