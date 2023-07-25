package xyz.itwill02.factory;

/*
	Factory 디자인 패턴을 이용하여 작성된 클래스 - Factory 클래스(Provider 클래스)
	=> 프로그램 개발에 필요한 객체를 생성하여 기능을 제공하는 클래스 - 컨테이너(Container)
*/
public class MessageObjectFactory {
	//Factory 클래스에 의해 제공될 객체를 구분하기 위한 상수(Constant)
	private static final int Hello_MSG = 1;
	private static final int Hi_MSG = 2;

	/*
		매개변수에 전달된 값을 비교하여 필요한 객체를 생성하여 반환하는 메소드
		=> 인터페이스를 상속받은 클래스로 객체를 생성하여 반환
	*/
	public static MessageObject getMessageObject(int messageObject) {
		MessageObject object=null;
		switch(messageObject) {
		case Hello_MSG: 
			object=new HelloMessageObject();
			break;
		
		case Hi_MSG: 
			object=new HelloMessageObject();
			break;
		}
	
		return object;
		
	}
	

}
