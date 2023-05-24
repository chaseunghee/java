package team_02;

/*
<Protected_Animals;> - TABLE 1
 이름                  널?       유형            
------------------- -------- ------------- 
ANIMAL_NAME         NOT NULL VARCHAR2(200) 
ANIMAL_SIZE         NOT NULL VARCHAR2(200) 
ANIMAL_KIND         NOT NULL VARCHAR2(200) 
GENDER              NOT NULL VARCHAR2(20)  
AGE                 NOT NULL NUMBER(2)     
CASEHISTORY                  VARCHAR2(200) 
PROTECTION_STARTDAY          DATE          
EUTHANASIA_DAY               DATE          
ADOPT                        VARCHAR2(200) 
REG_NO                       VARCHAR2(50)   
*/

//PROTECTEDANIMALS 테이블에 저장된 하나의 행(학생정보)을 저장하여 전달하기 위한 DTO 클래스 (StudentDTO)
public class ProtectedAnimalsDTO {
	//컬럼 저장할 필드 설정 
	private String animal_name;
	private String animal_size;
	private String animal_kind;
	private String gedger;
	private int age;
	private String casehistory;
	private String protection_startday;
	private String euthanasia_day;
	private String adopt;
	private String reg_no;

	//기본생성자 생성
	public ProtectedAnimalsDTO() {
		// TODO Auto-generated constructor stub
	}

	//매개변수 있는 생성자 생성
	public ProtectedAnimalsDTO(String animal_name, String animal_size, String animal_kind, String gedger, int age,
			String casehistory, String protection_startday, String duthanasia_day, String adopt, String reg_no) {
		super();
		this.animal_name = animal_name;
		this.animal_size = animal_size;
		this.animal_kind = animal_kind;
		this.gedger = gedger;
		this.age = age;
		this.casehistory = casehistory;
		this.protection_startday = protection_startday;
		this.euthanasia_day = duthanasia_day;
		this.adopt = adopt;
		this.reg_no = reg_no;
	}

	//Setter & Getter 생성
	public String getAnimal_name() {
		return animal_name;
	}

	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}

	public String getAnimal_size() {
		return animal_size;
	}

	public void setAnimal_size(String animal_size) {
		this.animal_size = animal_size;
	}

	public String getAnimal_kind() {
		return animal_kind;
	}

	public void setAnimal_kind(String animal_kind) {
		this.animal_kind = animal_kind;
	}

	public String getGedger() {
		return gedger;
	}

	public void setGedger(String gedger) {
		this.gedger = gedger;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCasehistory() {
		return casehistory;
	}

	public void setCasehistory(String casehistory) {
		this.casehistory = casehistory;
	}

	public String getProtection_startday() {
		return protection_startday;
	}

	public void setProtection_startday(String protection_startday) {
		this.protection_startday = protection_startday;
	}

	public String getEuthanasia_day() {
		return euthanasia_day;
	}

	public void setEuthanasia_day(String euthanasia_day) {
		this.euthanasia_day = euthanasia_day;
	}

	public String getAdopt() {
		return adopt;
	}

	public void setAdopt(String adopt) {
		this.adopt = adopt;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	
	
}
