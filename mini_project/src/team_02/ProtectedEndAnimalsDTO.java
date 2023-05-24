package team_02;

/*[테이블명: PROTECTED_END_ANIMALS]
 * 
 이름          널?       유형            
----------- -------- ------------- 
ANIMAL_NAME NOT NULL VARCHAR2(200) 
ANIMAL_KIND NOT NULL VARCHAR2(200) 
GENDER      NOT NULL VARCHAR2(20)  
AGE         NOT NULL NUMBER(2)     
REASON      NOT NULL VARCHAR2(200)  
 */


//PROTECTED_END_ANIMALS 테이블에 저장된 하나의 행을 저장하여 전달하기 위한 DTO 클래스
public class ProtectedEndAnimalsDTO {
   
   private String animalName;
   private String animalKind;
   private String gender;
   private int age;
   private String reason;
   
   
   public ProtectedEndAnimalsDTO() {
      // TODO Auto-generated constructor stub
   }


   public ProtectedEndAnimalsDTO(String animalName, String animalKind, String gender, int age, String reason) {
      super();
      this.animalName = animalName;
      this.animalKind = animalKind;
      this.gender = gender;
      this.age = age;
      this.reason = reason;
   }


   public String getAnimalName() {
      return animalName;
   }


   public void setAnimalName(String animalName) {
      this.animalName = animalName;
   }


   public String getAnimalKind() {
      return animalKind;
   }


   public void setAnimalKind(String animalKind) {
      this.animalKind = animalKind;
   }


   public String getGender() {
      return gender;
   }


   public void setGender(String gender) {
      this.gender = gender;
   }


   public int getAge() {
      return age;
   }


   public void setAge(int age) {
      this.age = age;
   }


   public String getReason() {
      return reason;
   }


   public void setReason(String reason) {
      this.reason = reason;
   }
   
   

}