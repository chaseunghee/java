package xyz.itwill.swing;

import java.util.Vector;

import javax.swing.DefaultButtonModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableApp extends JFrame{
	private static final long serialVersionUID=1L;
	
	public JTableApp(String title) {
		super(title);
		
		String[] columnName= {"학번","이름","전화번호"};
		String[][] rowDate= {{"1000","홍길동","010-1324-5343"},{"2000","임꺽정","010-1234-7611"}
						,{"3000","전우치","010-7213-3499"},{"4000","일지매","010-3247-6121"},{"5000","장길산","010-8781-0111"}};
		
		//DefaultTableModel 클래스 : 테이블 관련 정보를 저장하기 위한 클래스
		//=> 테이블의 행 또는 열 (셀:cell)을 조작할 수 있는 메소드 제공 
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowDate, columnName); //행,열 조작할 때 사용
		
		//Vector 클래스 : 값을 행과 열로 구성된 표 형식으로 출력하기 위한 컴퍼넌트
		Vector<String> vector=new Vector<>();
		vector.add("6000");
		vector.add("홍경래");
		vector.add("010-3232-6355");
		
		//DefaultTableModel.addRow(Vector vector) : 테이블에 행을 추가하는 메소드
		defaultTableModel.addRow(vector);
		
		//JTable 클래스 : 값을 행과 열로 구성된 표 형식으로 출력하기 위한 컴퍼넌트
		//JTable jTable=new JTable(rowData, columnName);
		JTable jTable=new JTable(defaultTableModel);
		
		JScrollPane jScrollPane=new JScrollPane(jTable);
		
		getContentPane().add(jScrollPane);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,500,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableApp("JTable 컴포넌트");
	}

}
