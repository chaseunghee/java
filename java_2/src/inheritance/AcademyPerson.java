package inheritance;

//사람정보(번호, 이름)를 저장하기 위한 클래스
//=> 학생, 강사, 직원에 대한 공통적잉ㄴ 속성과 행위를 표현하기 위한 클래스
//=> 학원인적자원 관련 클래스가 반드시 상속받아야 되는 부모클래스
public class AcademyPerson {
	
	private String name;
	private int num;
	
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void display() {
		System.out.println("번호 = "+num);
		System.out.println("이름 = "+name);
	}
}
