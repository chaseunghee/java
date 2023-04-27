package xyz.itwill.net;
 
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버 프로그램 작성
//=> NTP(Network Time Protocol) Server : 날짜와 시간을 제공하는 서버 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket 객체 생성 : 포트를 활성화하여 클라이언트가 접속할 수 있는 환경 제공
			ntpServer=new ServerSocket(2000); //2000번 포트 열어줌
			
			//SeverSocket.toString() : SeverSocket 객체에 저장된 접속 관련 정보를 문자열로 반환하는 메소드
			//System.out.println("ntp Sever = "+ntpSever);
			
			System.out.println("[메세지] NTP Sever Running...");
			
			//서버 프로그램에 다수의 클라이언트 접속을 허용하도록 무한루프 사용
			while(true) {
				//ServerSocket.accept() : 클라이언트가 접속되면 클라이언트와 값을 주고 받을 수 있는 
				//						Socket 객체를 반환하는 메소드
				//=> 클라이언트가 접속되기 전까지 스레드 일시중지되며 
				//	클라이언트가 접속하면 클라이언트의 소켓과 연결된 소켓을 생성하여 반환하고 스레드 실행
				Socket socket = ntpServer.accept(); //클라이언트가 접속되기를 계속 기다림
				
				//System.out.println("socket = "+socket);
				
				/*불필요한 참조 변수 너무 많음
				//서버측에서 날짜와 시간을 전달하기 위한 코드 
				//Socket.getOutputStream() : Socket 객체에 저장된 출력스트림(OutputStream 객체)을 반환하는 메소드
				//-OutputStream : 원시데이터 보냄 
				OutputStream stream = socket.getOutputStream();
				
				//날짜와 시간을 Date 객체로 보낼 것이기 때문에 위 코드를 ObjectoutputStream 이라는 클래스로 확장			
				//OutputStream 객체를 전달받아 객체를 전달할 수 있는 출력스트림으로 확장
				ObjectOutputStream out = new ObjectOutputStream(stream);
				
				//출력스트림을 이용하여 시스템의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 전달
				// - 클라이언트에게 날짜와 시간 전송 
				out.writeObject(new Date());
				*/
				
				//위의 주석은 불필요한 식별자가 너무 많아 아래와 같이 효율적으로 작성하는 것을 권장
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그 처리 - 기록(서버측에서 클라이언트측에 보낸 것을 알기 위해)
				//Socket.getInetAddress() : 서버의 소켓과 연결된 외부 컴퓨터의 네트워크 식별자가 저장된 
				//							InetAddress 객체를 반환하는 메소드
				System.out.println("[정보]클라이언트["+socket.getInetAddress().getHostAddress()+"] 에게 날짜와 시간을 제공하였습니다.");
				
				
				//클라이언트와의 접속 해제 - 이유: 더이상 보낼 것도 받을 것도 없어서
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생했습니다.");
		}
	}

}
