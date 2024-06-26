package xyz.itwill09.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

//[순서-7] - Member - DTO 클래스 생성

//회원정보를 저장하기 위한 클래스 - DTO 클래스 
@AllArgsConstructor
@Data
public class Member {
	private String id;
	private String name;
	private String address;
}
