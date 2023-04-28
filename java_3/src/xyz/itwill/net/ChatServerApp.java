package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//메인스레드는 클라리언트가 접속하면 소켓만 만들어주는 역할
//소켓으로 입출력하려면 새로운 스레드 사용해서 하게 만들어줌

//채팅 서버 프로그램-다중 스레드 프로그램
//=> 접속된 클라이언트에서 보내온 메세지를 전달받아 모든 클라이언트에게 전달하는 기능
//=> 클라이언트와 연결된 소켓은 새로운 스레드를 이용해서 독립적으로 입출력되도록 설정

public class ChatServerApp { //서버측에서는 일종의 중개역할만 함
	//5.
	//현재 접속중인 모든 클라이언트의 소켓정보를 저장된 List 객체를 저장하기 위한 필드
	private List<SocketThread> clientList; //객체를 저장할 수 있는 List 생성
	
	public ChatServerApp() {
		//ServerSocket이라는 클래스로 chatServer 생성
		ServerSocket chatServer=null;
		
		try {
			//포트를 활성화하여 클라이언트가 접속할 수 있게 환경 제공
			chatServer=new ServerSocket(5000);
			System.out.println("[메세지]채팅 서버 동작중...");
			
			//6.
			//ArrayList 객체를 생성하여 필드에 저장
			clientList=new ArrayList<>();
			
			while(true) {
				try {
					//클라이언트가 접속되면 클라이언트와 연결된 Socket 객체를 반환받아 저장
					Socket socket=chatServer.accept(); 
				
					System.out.println("[접속로그]"+socket.getInetAddress().getHostAddress()+"의 컴퓨터에서 서버에 접속하였습니다.");
				
					//7.
					//클라이언트가 연결된 객체가 저장된 SocketThread 객체 생성
					//=> Thread 클래스를 상속받은 스레드 클래스
					SocketThread socketThread=new SocketThread(socket);
				
					//8.
					//List 객체의 요소로 SocketThread 객체 추가
					clientList.add(socketThread);
				
					//9.
					//스레드 객체를 이용하여 새로운 스레드 생성
					//=> 새로운 스레드는 run() 메소드를 호출하여 명령 독립적으로 실행
					socketThread.start();
				}catch (IOException e) {
						System.out.println("[에러로그]클라이언트의 접속 관련 문제가 발생 하였습니다.");			
				}
			}
		}catch (IOException e) {
			System.out.println("[에러로그]서버가 정상적으로 동작되지 않습니다.");
		}
	}
		
	public static void main(String[] args) {
		new ChatServerApp(); //메인에서는 생성자만 만들어줌
	}
	
	//10.
	//현재 접속중인 모든 클라이언트에게 메세지를 전달하는 메소드
	public void sendMessage(String message) { //매개변수 message로 메세지를 받아서 모든 클라이언트에게 전달
		//List 객체에 저장된 요소(Server SocketThread 객체)를 차례대로 제공받아 반복처리
		for(SocketThread socketThread : clientList) {
			//서버SocketThread 객체의 out 필드에 저장된 출력스트림을 사용하여 메세지 전달
			//=> 외부클래스는 내부클래스로 객체를 생서앟여 접근제한자에 상관없이 필드와 메소드 접근 가능
			socketThread.out.println(message);
		}
	}

	//클라이언트와 연결된 소켓을 이용하여 입출력 기능을 제공하기 위한 스레드 클래스
	//=> 독립적인 입력 또는 출력 기능을 제공하기 위해 새로운 스레드를 생성하여 명령을 실행할 수 있도록 
	//	Thread 클래스를 상속받아 run() 메소드를 오버라이드 선언 
	public class SocketThread extends Thread{ //스레드를 상속받는 자식클래스 사용하여 소켓 사용
		//필드 생성
		//클라이언트와 연결된 Socket 객체를 저장하기 위한 필드
		private Socket client; 
		
		//클라이언트에서 보내온 메세지를 읽기 위한 입력스트림을 저장하기 위한 필드
		private BufferedReader in;
		//클라이언트에게 메세지를 보내기 위한 출력스트림을 저장하기 위한 필드
		private PrintWriter out;
		
		public SocketThread(Socket client) { //기본생성자 socket을 받아다가 
			this.client=client; //client라는 필드에 저장
		}
		
		//새로운 스레드가 실행될 명령을 작성하기 위한 메소드 
		//=>클라이언트에서 보내온 메세지를 전달받아 모든 클라이언트에게 전달하는 명령 작성
		@Override
		public void run() {
			//2.
			//클라이언트의 대화명 저장하기 위한 변수 선언
			String aliasName="";
			
			try {
				//1.입출력스트림을 먼저 작성함-보내거나 받을 수 있기 때문
				//소켓의 입력스트림(원시데이터)를 제공받아 대량의 문자데이터를 읽을 수 있는 입력스트림으로 확장하여 
				//필드에 저장
				in=new BufferedReader(new InputStreamReader(client.getInputStream()));
				//소켓의 출력스트림(원시데이터)를 제공받아 대량의 문자열을 전달할 수 있는 출력스트림으로 확장하여
				//필드에 저장
				//=> PrintWriter 클래스와 PrintWriter(OutputStream out, boolean autuFlush)생성자를 사용하여 PrintWriter객체 생성
				//=> autuFlush 매개변수에 [ture]를 전달=> 버퍼를 사용하지 않고 자동으로 무조건 출력스트림으로 데이터 전달
				//=> true 작성하면 Flush 작성안해도됨.
				//=> ture 작성안하면 Flush 무조건 작성해야됨.
				out=new PrintWriter(client.getOutputStream(),true); //printwriter는 println이나 print사용가능=>문자열 전달 가능
				//out을 이용하여 입장메세지를 보내면 현재 접속된 클라이언트 한 명밖에 못 받음
				
				//3. 클라이언트가 입력한 대화명 가져오기 위한 코드
				//클라이언트에서 보내온 대화명을 반환받아 변수에 저장
				//=> 클라이언트가 대화명을 보내오기 전까지 스레드 일시중지 
				aliasName=in.readLine(); //입력스트림을 통해 문자열 읽어드리겠다는 것을 의미 
										//입력스트림을 만들기만 하고 문자열 없으니까 지금은 일시중지
				//11. 누가 들어왔는지 알려주기 위한 코드
				//out을 이용하여 입장메세지를 보내면 현재 접속된 클라이언트 한 명밖에 못 받음=>out이용하면 안됨
				//현재 접속 중인 모든 클라이언트에게 환영의 입장메세지 전달
				//=> 내부클래스에서는 외부클래스의 필드 또는 메소드를 접근제한자와 상관없이 접근 가능
				sendMessage("["+aliasName+"]님이 입장하였습니다.");
				
				//12.
				//클라이언트에서 보내온 메세지를 전달받아 현재 접속중인 모든 클라이언트에게 전달
				//=> 클라이언트가 접속을 종료하기 전까지 반복 처리
				//=> 클라이언트가 접속을 종료한 경우 입출력이 없어져 IOException 발생
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch (IOException e) { 
				//클라이언트가 접속을 종료한 경우 실행될 명령 작성
				//List 객체에 저장된 요소 중 접속중인 클라이언트(SocketThread 객체)의 정보 삭제
				clientList.remove(this);
				
				//현재 접속중인 클라이언트
				System.out.println("["+aliasName+"]님이 퇴장하였습니다.");
				
				System.out.println("[해제로그]"+client.getInetAddress().getHostAddress()+"의 컴퓨터에서 서버 접속을 종료하였습니다.");

			}
			
		}
	}
}
