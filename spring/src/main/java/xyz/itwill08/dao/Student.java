package xyz.itwill08.dao;

import lombok.Data;

//[순서-5] - Student DTO 클래스 생성(이미 만들어진 Student테이블 사용)

/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE          
*/

//학생정보를 저장하기 위한 클래스 - DTO 클래스
@Data //@Data 어노테이션을 이용하여 setter,getter,string 자동 
public class Student {
	//필드 생성
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;

}
