package inheritance;

//강사정보(강사번호, 강사이름, 수강과정)를 저장하기 위한 클래스
//=> 학생번호와 학생이름 관련 속성과 행위는 AcademyPerson 클래스를 상속받아 사용

public class AcademyInstructor extends AcademyPerson {
	private String subject;
	
	public AcademyInstructor() {
		// TODO Auto-generated constructor stub
	}

	public AcademyInstructor(String name, int num, String subject) {
		super(name, num);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		//super.display();
		System.out.println("강사번호 = "+getNum());
		System.out.println("강사이름 = "+getName());
		System.out.println("수강과정 = "+subject);
	}

}
