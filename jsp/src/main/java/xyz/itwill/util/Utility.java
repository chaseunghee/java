package xyz.itwill.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

//웹프로그램 작성에 필요한 기능을 제공하기 위한 클래스
public class Utility {
	//문자열을 전달받아 암호화 처리하여 반환하는 메소드
	public static String encrypt(String passwd) {
		String encPassword=""; //암호화 처리된 비밀번호를 저장하기 위한 변수
		try {
			/*
				MessageDigest.getInstance(encryptPasswd) : 매개변수로 전달받은 암호화 알고리즘이 저장된 MessageDigest 객체를 생성하여 반환하는 메소드
				=> MessageDigest 객체 : 암호화 처리 기능을 제공하기 위한 객체
				=> 매개변수에 잘못된 암호화 알고리즘을 전달할 경우 NoSuchAlgorithmException 발생
				
				암호화 알고리즘
				- 단방향 암호화 알고리즘(복호화 불가능) : MD5, SHA-1, SHA-256, SHA-512
				- 양방향 암호화 알고리즘(복호화 가능) : AES-123, RSA 등
			*/
			MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
			
			/*
				MessageDigest.update(byte[] input) : MessageDigest 객체에 암호화 처리하기 위한 문자열의 byte 배열로 전달받아 저장하기 위한 메소드
				String.getBytes() : String 객체에 저장된 문자열을 원시데이터(byte 배열)로 변환하여 반환하는 메소드
			*/
			messageDigest.update(passwd.getBytes());
			
			/*
				messageDigest.digest() : MessageDigest 객체에 저장된 암호화 알고리즘으로 사용하여 byte 배열의 값을 암호화 처리하여 byte 배열로 반환하는 메소드
			*/
			byte[] digest=messageDigest.digest();
			
			//암호화 처리된 byte 배열을 String 객체의 문자열로 저장
			for(int i=0; i<digest.length; i++) {
				//Integer.toHexString(
				encPassword+=Integer.toHexString(digest[i]&0xff) ;//&0xff 양수로 변환 
			}
			
		}catch (NoSuchAlgorithmException e) {
			System.err.println("[에러] 잘못된 암호화 알고리즘을 사용하였습니다.");
		}
		
		return encPassword;
	}
	
	//문자열을 전달받아 태그 관련 문자열을 모두 제거하여 반환하는 메소드
	public static String stripTag(String source) {
		
		//Pattern.compile(String regex) : 매개변수로 전달받은 정규표현식이 저장된 Pattern 객체를 생성하여 반환하는 메소드
		Pattern htmlTag=Pattern.compile("\\<.*?\\>"); //<> 문자열 의미, . : 의미의 문자가 반복됨. => <>안에 문자가 있다면 html 태그가 있다면을 의미(패턴이라는 클래스를 이용해 htmlTag 만듦)
	
		/*
			Pattern.matcher(CharSequence input) : 매개변수에 입력값(비교값)을 전달받아 Pattern 객체의 정규표현식과 비교값이 저장된 Matcher 객체를 생성하여 반환하는 메소드
			=> Matcher 객체 : 정규표현식과 입력값을 비교하여 문자열의 검색,변경,삭제 기능을 제공하기 위한 객체
			
			Matcher.replaceAll(String replacement) : 입력값에서 정규표현식과 동일한 패턴의 문자열을 모두 차장 매개변수로 전달받은 문자열로 변경하는 메소드
		*/
		
		return htmlTag.matcher(source).replaceAll("");//문자열에서 HTML 태그를 삭제
	}
	
	//문자열을 전달받아 태그 관련 문자를 회피문자로 변경하여 반환하는 메소드
	public static String escapeTag(String source) {
		return source.replace("<", "&lt;").replace(">", "&gt;");
	}

}
