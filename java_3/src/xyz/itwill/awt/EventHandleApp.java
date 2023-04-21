package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class EventHandleApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public EventHandleApp(String title) {
		super(title);
		
		Button exit = new Button("EXIT");
		
		setBounds(800,200,300,300);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		new EventHandleApp("이벤트처리");
	}

}
