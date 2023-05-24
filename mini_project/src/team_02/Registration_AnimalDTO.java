package team_02;

/*
이름          널?       유형            
----------- -------- ------------- 
REG_NO      NOT NULL VARCHAR2(200) 
ANIMAL_NAME NOT NULL VARCHAR2(200) 
GENDER      NOT NULL VARCHAR2(200) 
MASTER      NOT NULL VARCHAR2(200) 
PHONE       NOT NULL VARCHAR2(200) 
ADDRESS     NOT NULL VARCHAR2(200) 
 */


//Registration_Animal 테이블에 저장된 하나의 행을 저장하여 전달하기 위한 DTO 클래스
public class Registration_AnimalDTO {
   private String regNo;
   private String animalName;
   private String gender;
   private String master;
   private String phone;
   private String address;
   
   public Registration_AnimalDTO() {
      // TODO Auto-generated constructor stub
   }

   public Registration_AnimalDTO(String regNo, String animalName, String gender, String master, String phone,
         String address) {
      super();
      this.regNo = regNo;
      this.animalName = animalName;
      this.gender = gender;
      this.master = master;
      this.phone = phone;
      this.address = address;
   }

   public String getRegNo() {
      return regNo;
   }

   public void setRegNo(String regNo) {
      this.regNo = regNo;
   }

   public String getAnimalName() {
      return animalName;
   }

   public void setAnimalName(String animalName) {
      this.animalName = animalName;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getMaster() {
      return master;
   }

   public void setMaster(String master) {
      this.master = master;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
   
   
   
   
}