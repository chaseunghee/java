package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//javax.swing 패키지의 클래스를 이용하여 GUI 프로그램을 작성하는 방법 - AWT와 다른점
//1.java.awt 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스 대신 javax.swing 패키지의 컴퍼넌트와
//컨테이너 관련 클래스를 사용하여 UI 구현
// => AWT 컴퍼넌트(컨테이너) 관련 클래스 이름 앞에 J를 붙이면 SWING 컴퍼넌트와 동일
//2.프레임의 [닫기]를 누른 경우 동작되는 기능을 기본적으로 제공
// => JFrame.setDefaultCloseOperation(int operation) 메소드를 호출하여 프레임의 [닫기]를 
//누른 경우되는 동작되는 기능을 변경 가능 
// => operation 매개변수에서는 WindowConstants 클래스의 상수 전달
// => DO_NOTHING_ON_CLOSE
// => HIDE_ON_CLOSE
// => DISPOSE_ON_CLOSE
// => EXIT_ON_CLOSE 

public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextField jTextField;
	JTextArea jTextArea;
	
	public SwingApp(String title) {
		super(title);
		
		jTextField=new JTextField();
		jTextArea=new JTextArea();
		
		//Swing프로그램에서는 운영체제에서 제공되는 모든 글꼴 사용가능
		jTextField.setFont(new Font("굴림체",Font.BOLD,20));
		jTextArea.setFont(new Font("굴림체",Font.BOLD,20));
		
		//JTextArea 컴퍼넌트에 입력촛점을 제공하지 않도록 설정 - 출력 컴퍼넌트로만 사용
		jTextArea.setFocusable(false);
		
		//JFrame.getContenPane() : 프레임의 컨테이너 기능을 객체를 반환하는 메소드
		Container container=getContentPane();
		
		container.add(jTextArea,BorderLayout.CENTER);
		container.add(jTextField, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}
}




