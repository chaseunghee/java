package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성

public class WantCalendarApp {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		System.out.print("[년]을 입력하세요. >> ");
		int year=scanner.nextInt();

		System.out.print("[월]을 입력하세요. >> ");
		int month=scanner.nextInt();

		Calendar calendar=Calendar.getInstance();

		calendar.set(Calendar.YEAR, year); //입력받은 년도로 세팅
		calendar.set(Calendar.MONTH, month); //입력받은 월로 세팅

		System.out.println(+year+"년 "+month+"월");

		System.out.println("  일  월  화  수  목  금  토");

		calendar.set(year,month-1,1);

		int week=calendar.get(Calendar.DAY_OF_WEEK);
		
		for(int i=1;i<week;i++) {	
			System.out.print("    ");
		}
 			for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {	
				//날짜 출력 >> 자릿수 맞춤
				if(i <= 9) {
					System.out.print("   "+i);
				} else {
					System.out.print("  "+i);
				}
	
				week++;
	
				if(week % 7 == 1) {//다음 출력값(일)이 일요일인 경우
					System.out.println();
				}
	
			}
			System.out.println();
		}
}