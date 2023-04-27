package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP 서버에 접속하여 서버에서 보내온 날짜와 시간을 제공받아 출력하는 클라이언트 프로그램 작성
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket 클래스 : TCP 프로그램에서 다른(타겟)컴퓨터와 연결을 위한 정보를 저장하기 위한 클래스
			//- 다른 컴퓨터의 소켓과 연결되어 값을 송수신할 수 있는 입출력 스트림 제공
			//=> Socket 클래스 이용하는 방법 : Socket 클래스의 SOcket(String host, int port) 생성자를 이용하여
			//								매개변수에 접속 컴퓨터(서버)의 네트워크 식별자(컴퓨터 이름, 
			//								호스트이름,IP주소)와 활성화된 포트번호를 전달하여 Socket 객체 생성
			//								=> 서버에 접속함을 의미
			//=> UnknownHostException 및 IOException 발생 - 일반 예외이므로 반드시 예외처리
			Socket socket=new Socket("192.168.13.6",2000); //언니 IP주소 
			
			//Socket.close() : Socket 객체를 제거하는 메소드 => 접속 해제를 의미
			
			//서버측으로부터 받기 위한 코드
			
			//InputStream : 원시데이터 읽어들임
			//Socket.getInputStream() : Socket 객체의 입력스트림(InputStream 객체)을 반환하는 메소드
			InputStream stream = socket.getInputStream();
			
			//서버측으로부터 받은 건 원시데이터가 아니라 객체?라서 확장
			//InputStream 객체를 전달받아 객체를 받을 수 있는 입력스트림으로 확장
			ObjectInputStream in = new ObjectInputStream(stream);
			
			//서버측으로부터 받은 객체가 Date니까 아래 코드 작성
			//입력스트림을 이용하여 서버에서 보내온 Date 객체를 반환받아 저장
			Date date =(Date)in.readObject();
			
			//Date 객체에 저장된 날짜와 시간을 원하는 형식의 문자열로 변환하여 출력
			System.out.println("[결과]서버에서 보내온 날짜와 시간 = "
								+new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(date));
			
			//Socket.close() : Socket 객체를 제거하는 메소드 - 접속 해제
			socket.close();
			
		} catch (UnknownHostException e) {
			System.out.println("[에러]서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}

}
