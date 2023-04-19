package xyz.itwill.lang;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 사칙 연삭식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20+10
//		[결과]30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)
//=> 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 작성
//=> 입력 연산식에 공백 입력이 가능하도록 처리
public class ConsoleCalculateApp {
	public static void main(String[] args) throws InputMismatchException, ArithmeticException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("연산식 입력 >> ");
		
		String abc = scanner.nextLine().replace(" ", "");
		String[] c_array= {"*","/","+","-"};
		
		
		int index=-1; 
		int result=0;
		
		for(String d:c_array) {
			index=abc.lastIndexOf(d);
		
			if(index!=-1) 
				break;
		}
		//연산자가 없거나 연산자가 잘못된 위치에 있는 경우
		if(index <= 0 || index >= abc.length()-1) {
			System.out.println("[에러]연산식을 잘못 입력 하였습니다.");
			System.exit(0);
		}
		
		scanner.close();
		
		
		try {
			int a=Integer.parseInt(abc.substring(0,index));
			String c=abc.substring(index,index+1);
			int b=Integer.parseInt(abc.substring(index+1));
			
			if(c.equals("*")) {
				result=a*b;
			}else if(c.equals("/")) {
				result=a/b;
			}else if(c.equals("+")) {
				result=a+b;
			}else if(c.equals("-")) {
				result=a-b;
			}
			System.out.println("[결과]"+result);
		}	
	
		 catch (NumberFormatException e) {
			System.out.println("[에러]연산식에 숫자가 아닌 값이 입력되었습니다.");
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
	}	
	
}


