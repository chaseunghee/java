package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
		int sum=0;
		int avg=1;
		int length =age.length;
		//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
		for(int i=0;i<age.length;i++) {
			sum+=age[i];
		}
		//System.out.println(length);
		//System.out.println("합계 = "+sum);
		System.out.println("모든 사람들의 나이 평균 : "+sum/length);
		
		System.out.println("===============================================================");
		
		
		//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		//ex) 10대 = 3명
		//    20대 = 4명
		//    ...
		//    60대 = 1명
		int [] count=new int[6];
		for(int dea: age) {
			if(dea>=10 && dea<20) {
				count[0]++;
				//System.out.println("10대 = "+ count+"명");
			}else if(dea>=20 && dea<30) {
				count[1]++;
				//System.out.println("20대 = "+ count+"명");
			}else if(dea>=30 && dea<40) {
				count[2]++;
				//System.out.println("30대 = "+ count+"명");
			}else if(dea>=40 && dea<50) {
				count[3]++;
				//System.out.println("40대 = "+ count+"명");
			}else if(dea>=50 && dea<60) {
				count[4]++;
				//System.out.println("50대 = "+ count+"명");
			}else if(dea>=60 && dea<70) {
				count[5]++;
				//System.out.println("60대 = "+ count+"명");
			}
		}for(int i=0; i<count.length; i++) {
			System.out.println((i+1)*10+"대 = "+count[i]+"명");
		}
		
		System.out.println("===============================================================");
	}
	
}
