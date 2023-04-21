package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

//MenuItem >>  Menu >> MenuBar >> Frame
public class MenuBarApp extends Frame {
   private static final long serialVersionUID = 1L;

   public MenuBarApp(String title) {
      super(title);
   
      
      MenuBar menuBar = new MenuBar();
      
      Menu file = new Menu("File");
      Menu help = new Menu("Help");

      menuBar.add(file);//메뉴바에 메뉴 배치
      menuBar.add(help);
      
      //MenuShortcut 클래스 : 메뉴 아이템에 단축키를 제공하기 위한 클래스
      //KeyEvent 클래스 : 가상의 키보드 정보를 제공하기 위한 클래스, VK(virtual keyboard) 무조건 _O랑 같이 씀
      MenuItem open = new MenuItem("open", new MenuShortcut(KeyEvent.VK_O));
      MenuItem save = new MenuItem("save", new MenuShortcut(KeyEvent.VK_S));
      MenuItem exit = new MenuItem("exit");
      
      MenuItem view = new MenuItem("helpview");
      MenuItem info = new MenuItem("infomation");
      
      file.add(open);//메뉴에 메뉴 아이템 배치
      file.add(save);
      file.add(exit);
      file.addSeparator();//메뉴에 메뉴아이템을 구분하는 구분선 배치
      
      help.add(view);
      help.add(info);
      
      //Frame.setMenuBar(menuBar bar) : 프레임의 메뉴바를 변경하는 메소드
      setMenuBar(menuBar);
      
      TextArea textArea =new TextArea();
      textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
      add(textArea, BorderLayout.CENTER);
      
      setBounds(600, 100, 500, 400);
      setVisible(true);
      
   }
   public static void main(String[] args) {
      new MenuBarApp("MenuBarApp");
   }
}