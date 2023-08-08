package xyz.itwill10.dto;
/* [순서-3] - Student 클래스 생성 - dto

	DTO 클래스 : DAO 클래스의 메소드에서 사용하기 위한 값을 표현하기 위한 클래스
	=> 테이블을 Java 클래스로 표현하여 객체로 생성하기 위해 
*/
import lombok.Data;

@Data
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
