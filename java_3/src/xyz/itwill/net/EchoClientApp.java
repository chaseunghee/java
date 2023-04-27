package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//서버실행 후-> 클라이언트 실행
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		//1.원시데이터 1바이트 하나만 읽어들임=system.in
		//->2.키보드 입력스트림을 문자데이터로 읽어들일 수 있게 확장(문자데이터 한개)=inputStreamReader
		//->3.하나의 문자데이터가 아닌 대량의 문자데이터(문자열)을 읽어들일 수 있게 확장=BufferedReader
		
		//키보드 입력스트림을 대량의 문자데이터를 입력받을 수 있는 입력스트림으로 확장
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		try {
			Socket socket = new Socket("192.168.13.6",3000);
			
			//방법2를 더 선호함.(이유: 모든 객체를 문자열로 변환할 수 있기 때문)
			
			/*방법1
			//방법1.- 소켓의 출력스트림을 제공받아 대량의 문자데이터를 전달할 수 있는 출력스트림으로 확장
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//방법1-1.- 서버의 소켓과 연결된 출력스트림을 이용하여 문자열(메세지)을 전달
			out.write(message); //bufferedwriter 가 가지고 있는 문자
			
			//방법1-2.출력스트림의 버퍼에 존재하는 문자데이터를 출력스트림으로 전달
			out.flush(); //방법2를 사용할 때 꼭 작성해야함. 
			*/
			
			//방법2.- 소켓의 출력스트림을 제공받아 모든 자료형의 값을 문자열로 변환하여 
			//			전달할 수 있는 기능의 출력스트림으로 확장
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			//방법2-1. - printWriter.println(Object o) : 매개변수로 전달받은 모든 객체를 문자열로 변환하여
			//			전달하는 메소드
			out.write(message); //printwriter 가 가지고 있는 문자
			
			//방법1-2.- 방법1을 사용할 때 꼭 작성해야 함.
			out.flush();
			
			socket.close(); //접속 해제 
			
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다. ");
		}
	
	}

}
