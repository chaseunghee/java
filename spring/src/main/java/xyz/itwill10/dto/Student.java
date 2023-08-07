package xyz.itwill10.dto;
//[순서-3] - Student 클래스 생성 - dto

import lombok.Data;

@Data
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
