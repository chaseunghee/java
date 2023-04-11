package example;

public class IfExample {
	public static void main(String[] args) {
		//변수에 저장된 문자값을 출력하세요.
		//단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.
		char mun='x';
		
		if(mun>='A' && mun<='Z' || mun>='a' && mun<='z') {
			if(mun>='a' && mun<='z') {
				mun-=32;
				System.out.println("mun = "+mun);
			}
			else {
				System.out.println("mun = "+mun);
			}
		}

		/*강사님 코딩
		char mun='x';
		
		if(mun>='a' && mun<='z') {//변수값이 영문자 소문자인 경우
			mun-=21;// 소문자를 대문자로 변환
		}
		System.out.println("mun = "+mun);
		*/
		
		System.out.println("============================================================");
		
		//변수에 저장된 정수값이 4의 배수인지 아닌지를 구분하여 출력하세요.
		int num=345644;
		if(num%4==0) {
			System.out.println(num+"는 4의 배수입니다.");
		} else {
			System.out.println(num+"는 4의 배수가 아닙니다.");
		}
		
		System.out.println("============================================================");
		
		//올해가 평년인지 윤년을 구분하여 출력하세요.
		// => 년도를 4로 나누어 나머지가 0인 경우 윤년
		// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
		// => 위 조건을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
		int year=2023;
		
		if(year%4==0 && year%100!=0 || year%4==0) {
			System.out.println(year+"은 윤년입니다.");
		}else{
			System.out.println(year+"은 평년입니다.");
			}  

		System.out.println("============================================================");
		
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
		//    System.exit(0) : 프로그램을 강제로 종료하는 메소드
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name="홍길동";
		int kor=189, eng=93, mat=195;
		int sum=kor+eng+mat;
		double avg=(double)sum/3;
		avg=(int)(avg*100+0.5)/(100.0);
		String grade="";
		
		if(kor>=0 && kor<=100 && eng>=0 && eng<=100 && mat>=0 && mat<=100) {
			if(avg<=100 && avg>=90) {
				grade="A";
			}else if(avg<=89 && avg>=80) {
				grade="B";
			}else if(avg<=79 && avg>=70) {
				grade="C";
			}else if(avg<=69 && avg>=60) {
				grade="D";
			}else {
				grade="F";
			}
			System.out.println("이름 : "+name+" 합계 : "+sum+" 평균 : " +avg+" 학점 : "+grade);
		}
		else {
			//검증 결과를 저장하기 위한 변수 - false : 검증 성공, true : 검증 실패
			boolean vaild = false; 
			if(kor>100||kor<0) {
				System.out.println("[에러] 0~100 범위를 벗어난 비정상적인 국어 점수가 입력되었습니다.");
				vaild=true;
				//System.exit(0);
			} if(eng>100||eng<0) {
				System.out.println("[에러] 0~100 범위를 벗어난 비정상적인 영어 점수가 입력되었습니다.");
				vaild=true;
				//System.exit(0);
			} if(mat>100||mat<0) {
				System.out.println("[에러] 0~100 범위를 벗어난 비정상적인 수학 점수가 입력되었습니다.");
				vaild=true;
				//System.exit(0);
			}
			if(vaild)System.exit(0);
		}
		System.out.println("============================================================");
		
		/*강사님 코딩
		 
		 
		 
		 
		 
		 
		 */
		
	}
}