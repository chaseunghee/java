
package example;

public class VariableExample {
	public static void main(String[] args) {
		
		//가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이를 계산하여 출력하세요.
		int width=7, length=10;
		int square_area=width*length;
		
		System.out.println("가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이 : "+square_area);
		System.out.println("======================================================");
		
		//높이가 9이고 밑변의 길이가 7인 삼각형의 넓이를 계산하여 출력하세요.
		int height=9, base=7;
		double triangle_area=(double)height*base/2;
		
		System.out.println("높이가 9이고 밑변의 길이가 7인 삼각형의 넓이 : "+triangle_area);
		System.out.println("======================================================");
		
		//10명의 전체 몸무게가 759Kg인 경우 평균 몸무게를 계산하여 출력하세요.
		double weight_avg = 759/10.;
		System.out.println("높이가 9이고 밑변의 길이가 7인 삼각형의 넓이 : "+weight_avg);
		System.out.println("======================================================");
		
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균을 계산하여 이름, 총점, 평균을 출력하세요.
		//단, 평균은 소숫점 한자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name="홍길동";
		int kor=89;
		int eng=93;
		int math=95;
		int score=kor+eng+math;
		double avg=score/3.;
		System.out.println("이름 : ["+name+"], 총점 : "+score+" , 평균 : "+(int)(avg*10+0.5)/(10.0));
		System.out.println("======================================================");
	}
}