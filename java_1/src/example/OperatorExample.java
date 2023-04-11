package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int s=245678;
		int day=s/86400;
		int hour=(s%86400)/3600;
		int min=((s%86400)%3600)/60;		
		int sec=((s%86400)%3600)%60;
		System.out.println(day + "일"+ hour +"시간" + min +"분" +sec +"초");

		/*강사님 코딩
		int cho=2345678;
		int day=cho/(60*60*24);
		cho%=86400;
		int hour=cho/(60*60);
		cho%=3600;
		int min=cho/60;
		int sec=cho%60;
		*/
		
		System.out.println("===============================================");
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		int price=150000000;
		int cnt=20;
		long pay= (long)(cnt>15?price*0.75:price)*cnt;

		System.out.println("한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액 : "+pay);
		System.out.println("===============================================");
	
	}
}