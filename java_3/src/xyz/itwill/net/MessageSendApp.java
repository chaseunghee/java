package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP 프로그램 : DatagramSocket 클래스와 DatagramPacket 클래스를 이용하여 작성
//타 컴퓨터가 받던 말던 연결하는 것이 아니라 그냥 보내는 것
//하나의 프로그램으로 다수의 컴퓨터에게 여러 값을 보낼 수 있음(딱 한 번)

public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("전달 메세지 입력 >> ");
		String message= in.readLine();
		
		//DatagramSocket 클래스 : 다른 컴퓨터와 연결하기 위한 정보를 저장하기 위한 클래스
		//=> 데이터를 보내는 컴퓨터는 기본 생성자를 사용하여 DatagramSocket 객체 생성
		DatagramSocket socket = new DatagramSocket();
		
		//연결할 컴퓨터의 네트워크 식별자가 저장된 InetAddress 객체를 반환받아 저장
		InetAddress address = InetAddress.getByName("192.168.13.6");
		
		//String.getBytes() : String 객체에 저장된 문자열을 byte 배열로 변환하여 반환하는 메소드
		//문자열로 전달할 수 없으므로 바이트로 변환해야함.
		byte[] data=message.getBytes();
		
		//DatagramPacket 클래스 : 연결 컴퓨터에게 보낼 패킷정보를 저장하기 위한 클래스 
		//=> DatagramPacket 클래스의 Datagrampacket(byte[] data(보낼 데이터), int length(보낼 데이터의 크기), 
		//	InetAddress(보낼 컴퓨터의 네트워크 식별자), int port(활성화된 포트)) 생성자를
		//	사용하여 데이터를 보내기 위한 패킷정보가 저장된 DatagramPacket 객체 생성
		//=> 누구한테 어떤 크기로 보낼 건지 정해줌.
		DatagramPacket packet = new DatagramPacket(data, data.length,address, 4000);
		
		//DatagramSocket.send(DatagrampPacket packet) : 매개변수로 전달받은 DatagramPacket 객체의 정보를
		//												이용하여 데이터를(패킷) 전달하는 메소드
		socket.send(packet); //데이터를 보내는 메소드=> send
		
		//DatagramSocket.close() : DatagramSocket 객체를 제거하는 메소드
		socket.close();
		
		System.out.println("[결과]연결 컴퓨터에게 메세지를 보냈습니다."); //바이트로 설정했기 때문에 파일도 보낼 수 있음
	}

}
