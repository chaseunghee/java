package xyz.itwill.io;

import java.io.Serializable;
/*
객체 직렬화(Object Serialization) : 객체를 byte(원시데이터) 배열로 변환하여 입력 또는 출력 처리되기위한 기능을 제공 
>> 원시데이터로 전달 > 어디부터 어디까지가 객체인지 묶어서 보내야 구분 가능 >> 객체 직렬화
 
클래스를 객체 직렬화 처리하는 방법 - 객체 직렬화 클래스
1. Serializable 인터페이스를 상속받아서 클래스로 작성 
> Serializable 인터페이스의 추상메소드가 없음 > 오버라이드 선언 X
> 가장 간단하고 많이 쓰는 방법!, 객체의 모든 필드값을 byte배열로 변환하여 입력 또는 출력 처리

2. Externalizable 인터페이스를 상속받아 클래스로 작성
> Externalizable 인터페이스의 추상메소드가 있음 > readExternal(Object in)와 writereadExternal(Object out) 메소드를 반드시 오버라이드 선언 
> 오버라이드 선언된 메소드에서 원하는 필드값만을 byte배열로 변환하여 입력 또는 출력 처리
>> 객체의 값이 많을때 유용함, 요즘은 잘쓰지않음

*/
//회원정보(아이디, 이름, 전화번호)를 저장하기위한 클래스 - VO클래스 : 값을 저장할 목적을 가진 객체를 만드는 클래스
// >> 객체단위로 입력 또는 출력 처리하기 위한 클래스는 반드시 객체 직렬화 클래스로 선언 
public class Member implements Serializable{

	private static final long serialVersionUID = -3306639107947980039L;
//객체 직렬화 클래스는 클래스를 구분하기 위한 고유값을 저장할 serialVersionUID 필드 선언 권장
   // - 필드의 자료형은 Long타입으로 설정하고 static final 제한자 사용
   // >> 이클립스에서는 고유값이 저장된 serialVersionUID 필드를 자동생성하여 기능을 제공 // 입출력할려면 고유값 저장된 형태가 효율적 
	
   private String id;
   private String name;
   private String phone;

   
   public Member() {
      // TODO Auto-generated constructor stub
   }


   public Member(String id, String name, String phone) {
      super();
      this.id = id;
      this.name = name;
      this.phone = phone;
   }


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
   }


   public String getName() {
      return name;
   }


   public void setName(String name) {
      this.name = name;
   }


   public String getPhone() {
      return phone;
   }


   public void setPhone(String phone) {
      this.phone = phone;
   }
   
   @Override
   public String toString() {
      // TODO Auto-generated method stub
      return "아이디 = "+id+", 이름 = "+name + ", 전화번호 = "+ phone;
      
      
   }
 }