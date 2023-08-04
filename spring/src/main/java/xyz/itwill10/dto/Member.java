package xyz.itwill10.dto;

import lombok.Data;

/* [순서-26] - Member 클래스 생성 후 필드 선언

	회원정보를 저장하기 위한 클래스 - VO 클래스 : 값을 저장할 목적의 객체를 생성하기 위한 클래스
	=> DAO 클래스의 메소드에서 사용될 경우 DTO 클래스의 기능 제공
	
	[순서-30] - Command 객체로 만들기 위해선 해야됨
	=> 페이지 요청 시  
*/
@Data
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
}

