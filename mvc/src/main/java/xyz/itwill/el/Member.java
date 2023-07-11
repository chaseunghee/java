package xyz.itwill.el;

public class Member {
	private String name;
	private Car car; //Car 클래스를 이용하여 필드 생성 - car 객체 저장됨 => 포함관계
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, Car car) {
		super();
		this.name = name;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
