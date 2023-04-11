package example;

public class MultiforExample {
	public static void main(String[] args) {
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
		System.out.println("===============================================================");
		
		//★★★★★ i=1 검은별=5 흰별=0
		//☆★★★★ i=2 검은별=4 흰별=1
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=(i-1); j++) {
				System.out.print("☆");
			}
			for(int j=1; j<=(6-i); j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//★		i=1 별=1
		//★★★	i=2 별=3
		//★★★★★
		//★★★★★★★
		//★★★★★★★★★
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=(i*2-1); j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("===============================================================");
		
		//★☆☆☆★ i=1 검은 별=1,5 흰별=나머지 234
		//☆★☆★☆ i=2 검은 별=2,4
		//☆☆★☆☆ i=3 검은 별=3
		//☆★☆★☆ i=4 검은 별=2,4
		//★☆☆☆★ i=5 검은 별=1,5
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(j*1==i || (6-j)==i) {
					System.out.print("★");
				}else{
					System.out.print("☆");}
			}
			System.out.println();
		}
	System.out.println("===============================================================");
		
		
	}
}
