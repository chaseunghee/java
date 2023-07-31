package xyz.itwill07.aop;

import lombok.Data;

//[순서-1]

@Data
//@Data 어노테이션 - setter,getter 생성할 필요없음
public class Hewon {
	private int num; //회원번호
	private String name; //회원이름

}
