package xyz.itwill.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트에서 보내온 메세지를 제공받아 출력하는 서버 프로그램 작성
//서버 먼저 실행-> 클라이언트 실행
public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer=null;
		
		try {
			echoServer=new ServerSocket(3000); //포트 활성화시켜 클라이언트가 접속되게 만들어줌
			System.out.println("[메세지] Echo Server Running...");
			
			while(true) {
				Socket socket = echoServer.accept(); //클라이언트가 접속되길 기다림
				//소켓이 갖고 있는 입력스트림(원시데이터-1byte)을 가져다가 문자데이터로 읽어들일 수 있도록 
				//그리고 대량의 문자데이터를 읽어드릴 수 있도록 확장 
				BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
				
				//readLine() : 대량의 문자데이터(문자열)을 읽어들임 
				//클라이언트의 소켓과 연결된 입력스트림을 이용하여 문자열(메세지)를 반환받아 출력
				System.out.println("["+socket.getInetAddress().getHostAddress()
						+"]님이 보내온 메세지 = "+in.readLine()); 
			}

		}catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생되었습니다.");
		}
	}

}
