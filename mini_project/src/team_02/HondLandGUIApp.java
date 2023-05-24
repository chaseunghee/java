package team_02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTable;

public class HondLandGUIApp extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   private JPanel contentPane;
   private JPanel page_1;
   JScrollPane scrollPane;
   private JTable page3_table;
   private JTable page4_table;
   private JTable page6_table;
   private JTable page7_table;
   private JTable page8_table;
   private JTable page9_table;
   

   // JButton 선언
   JButton page3_regno_btn, page3_size_btn, page3_gender_btn, page4_gender_btn1, page4_gender_btn2, page4_gender_btn3,
         page4_size_btn1, page4_size_btn2, page4_size_btn3, page4_select_btn, page8_regno_btn, page6_done_btn,
         page7_insert_btn, page7_delete_btn, page9_insert_btn;

   // page_3 JTextField
   private JTextField page3_regno;
   private JTextField page3_gender_text;
   private JTextField page3_size_text;

   // page_6 JTextField
   private JTextField page6_name_text;
   private JTextField page6_adopt_text;

   // page_7 JTextField
   private JTextField page7_name_text;
   private JTextField page7_gender_text;
   private JTextField page7_age_text;
   private JTextField page7_kind_text;
   private JTextField page7_reason_text;

   // page_8 JTextField
   private JTextField page8_regno_text;

   // page_9 JTextField
   private JTextField page9_name_text;
   private JTextField page9_size_text;
   private JTextField page9_kind_text;
   private JTextField page9_gender_text;
   private JTextField page9_age_text;
   private JTextField page9_startday_text;
   private JTextField page9_dday_text;
   private JTextField page9_adopt_text;
   private JTextField page9_regno_text;
   private JTextField page9_case_text;
   
   

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               HondLandGUIApp frame = new HondLandGUIApp();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });

   }

   /**
    * Create the frame.
    */
   
   
   
   public HondLandGUIApp() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1082, 656);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(240, 240, 240));
      contentPane.setForeground(new Color(255, 128, 0));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setResizable(false);// 프레임 크기 변경 불가능
      setLocationRelativeTo(null);

      setContentPane(contentPane);
      contentPane.setLayout(null);

      // page1======================================================================================================
      page_1 = new JPanel();
      page_1.setBounds(-1, 0, 1087, 641);
      contentPane.add(page_1);
      page_1.setLayout(null);

      JPanel panel_19_1 = new JPanel();
      panel_19_1.setBounds(154, 303, 725, 271);
      page_1.add(panel_19_1);
      panel_19_1.setLayout(null);

      JButton user_btn = new JButton("USER");
      user_btn.setBackground(new Color(255, 255, 255));
      user_btn.setForeground(new Color(64, 0, 64));
      user_btn.setFont(new Font("나눔고딕", Font.BOLD, 24));
      user_btn.setBounds(137, 45, 183, 141);
      panel_19_1.add(user_btn);

      JButton admin_btn = new JButton("ADMIN");
      admin_btn.setForeground(new Color(64, 0, 64));
      admin_btn.setFont(new Font("나눔고딕", Font.BOLD, 24));
      admin_btn.setBackground(Color.WHITE);
      admin_btn.setBounds(435, 45, 183, 141);
      panel_19_1.add(admin_btn);

      JLabel lblNewLabel_6 = new JLabel("HONDLAND");
      lblNewLabel_6.setForeground(new Color(0, 128, 64));
      lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 94));
      lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_6.setBounds(0, 115, 1064, 187);
      page_1.add(lblNewLabel_6);

      // page2======================================================================================================
      JPanel page_2 = new JPanel();
      page_2.setBounds(-11, -41, 1097, 660);
      contentPane.add(page_2);
      page_2.setLayout(null);

      JButton search_btn = new JButton("실종 동물 찾기");
      search_btn.setBackground(new Color(255, 255, 255));
      search_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      search_btn.setBounds(197, 258, 259, 169);
      page_2.add(search_btn);

      JButton adopt_btn = new JButton("입양 하기");
      adopt_btn.setBackground(new Color(255, 255, 255));
      adopt_btn.setForeground(new Color(0, 0, 0));
      adopt_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      adopt_btn.setBounds(601, 258, 259, 169);
      page_2.add(adopt_btn);

      JButton home_btn2 = new JButton("HOME");
      home_btn2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
      home_btn2.setBounds(977, 49, 85, 29);
      page_2.add(home_btn2);

      // page3======================================================================================================
      Object[] title_3 = { "이름", "크기", "품종", "성별", "나이", "병력", "보호시작일", "안락사예정일", "입양여부", "등록번호" };

      JPanel page_3 = new JPanel();
      page_3.setBounds(0, 0, 1068, 619);
      contentPane.add(page_3);
      page_3.setLayout(new BorderLayout(0, 0));

      JPanel panel_1 = new JPanel();
      page_3.add(panel_1, BorderLayout.NORTH);
      panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

      JPanel panel_35 = new JPanel();
      panel_1.add(panel_35);
      panel_35.setLayout(new BoxLayout(panel_35, BoxLayout.X_AXIS));

      JLabel lblNewLabel_9 = new JLabel("등록 번호");
      lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_35.add(lblNewLabel_9);

      page3_regno = new JTextField();
      page3_regno.setFont(new Font("돋움", Font.PLAIN, 30));
      page3_regno.setColumns(10);
      panel_35.add(page3_regno);

      page3_regno_btn = new JButton("SEARCH");
      page3_regno_btn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
      panel_35.add(page3_regno_btn);
      page3_regno_btn.addActionListener(this);

      JPanel panel_36 = new JPanel();
      panel_1.add(panel_36);
      panel_36.setLayout(new BoxLayout(panel_36, BoxLayout.X_AXIS));

      JLabel page3_gender_label = new JLabel("성별");
      page3_gender_label.setHorizontalAlignment(SwingConstants.CENTER);
      page3_gender_label.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_36.add(page3_gender_label);

      page3_gender_text = new JTextField();
      page3_gender_text.setFont(new Font("돋움", Font.PLAIN, 30));
      page3_gender_text.setColumns(10);
      panel_36.add(page3_gender_text);

      page3_gender_btn = new JButton("SEARCH");
      page3_gender_btn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
      panel_36.add(page3_gender_btn);
      page3_gender_btn.addActionListener(this);

      JPanel panel_37 = new JPanel();
      panel_1.add(panel_37);
      panel_37.setLayout(new BoxLayout(panel_37, BoxLayout.X_AXIS));

      JLabel page3_size_label = new JLabel("크기");
      page3_size_label.setHorizontalAlignment(SwingConstants.CENTER);
      page3_size_label.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_37.add(page3_size_label);

      page3_size_text = new JTextField();
      page3_size_text.setFont(new Font("돋움", Font.PLAIN, 30));
      page3_size_text.setColumns(10);
      panel_37.add(page3_size_text);

      page3_size_btn = new JButton("SEARCH");
      page3_size_btn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
      panel_37.add(page3_size_btn);
      page3_size_btn.addActionListener(this);

      // page3 table 객체 생성
      page3_table = new JTable(new DefaultTableModel(title_3, 0));
      page_3.add(page3_table, BorderLayout.CENTER);

      JScrollPane page3_sp = new JScrollPane(page3_table);

      JPanel panel_34 = new JPanel();
      page_3.add(panel_34, BorderLayout.SOUTH);
      page_3.add(page3_sp, "Center");
      panel_34.setLayout(new BoxLayout(panel_34, BoxLayout.X_AXIS));

      JPanel panel_57 = new JPanel();
      panel_34.add(panel_57);
      panel_57.setLayout(new BorderLayout(0, 0));

      JButton home_btn3 = new JButton("HOME");
      home_btn3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
      home_btn3.setVerticalAlignment(SwingConstants.BOTTOM);
      home_btn3.setHorizontalAlignment(SwingConstants.RIGHT);
      panel_57.add(home_btn3, BorderLayout.EAST);

      // 3페이지 비활성화
      page_3.setVisible(false);

      // home_btn3을 눌렀을 경우 1페이지 활성화+3페이지 비활성화
      home_btn3.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_3.setVisible(false);
            clear3();
         }

      });

      // page_4===================================================================================
      Object[] title_4 = { "이름", "크기", "품종", "성별", "나이", "병력", "보호시작일", "안락사예정일", "입양여부", "등록번호" };

      JPanel page_4 = new JPanel();
      page_4.setBounds(0, 0, 1068, 619);
      contentPane.add(page_4);
      page_4.setLayout(new BorderLayout(0, 0));

      JPanel panel_8 = new JPanel();
      page_4.add(panel_8, BorderLayout.CENTER);

      page4_table = new JTable();
      page4_table.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      panel_8.add(page4_table);

      // page4 table 객체 생성
      page4_table = new JTable(new DefaultTableModel(title_4, 0));
      page_4.add(page4_table, BorderLayout.CENTER);

      JScrollPane page4_sp = new JScrollPane(page4_table);
      page_4.add(page4_sp, "Center");

      JPanel panel_7 = new JPanel();
      page_4.add(panel_7, BorderLayout.NORTH);
      panel_7.setLayout(new BorderLayout(0, 0));

      JPanel panel_56 = new JPanel();
      panel_7.add(panel_56, BorderLayout.EAST);

      JButton home_btn4 = new JButton("HOME");
      home_btn4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
      panel_7.add(home_btn4, BorderLayout.EAST);

      // 4페이지 비활성화
      page_4.setVisible(false);

      // home_btn4을 눌렀을 경우 1페이지 활성화+4페이지 비활성화
      home_btn4.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_4.setVisible(false);
         }

      });

      // page5 ========================================================================================================
      JPanel page_5 = new JPanel();
      page_5.setBounds(0, 0, 1066, 629);
      contentPane.add(page_5);
      page_5.setLayout(new BorderLayout(0, 0));

      JPanel panel_9 = new JPanel();
      page_5.add(panel_9, BorderLayout.CENTER);
      panel_9.setLayout(null);

      JPanel panel_10 = new JPanel();
      panel_10.setBounds(261, 123, 513, 290);
      panel_9.add(panel_10);
      panel_10.setLayout(new GridLayout(2, 2, 0, 0));

      JButton reg_btn = new JButton("등록 번호 찾기");
      reg_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_10.add(reg_btn);

      JButton ado_btn = new JButton("입양 여부 관리");
      ado_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_10.add(ado_btn);

      JButton protect_add_btn = new JButton("보호 동물 추가");
      protect_add_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_10.add(protect_add_btn);

      JButton protect_end_btn = new JButton("보호 종료 동물 관리");
      protect_end_btn.setFont(new Font("맑은 고딕", Font.BOLD, 24));
      panel_10.add(protect_end_btn);

      JPanel panel_54 = new JPanel();
      page_5.add(panel_54, BorderLayout.NORTH);
      panel_54.setLayout(new BorderLayout(0, 0));

      JPanel panel_55 = new JPanel();
      panel_54.add(panel_55, BorderLayout.EAST);

      JButton home_btn5 = new JButton("HOME");
      home_btn5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
      panel_55.add(home_btn5);

      // home_btn5을 눌렀을 경우 1페이지 활성화+5페이지 비활성화
      home_btn5.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_5.setVisible(false);
         }

      });

      // page6 ========================================================================================================
      Object[] title_6 = { "이름", "크기", "품종", "성별", "나이", "병력", "보호시작일", "안락사예정일", "입양여부", "등록번호" };

      JPanel page_6 = new JPanel();
      page_6.setBounds(0, 0, 1066, 619);
      contentPane.add(page_6);
      page_6.setLayout(new BorderLayout(0, 0));

      JPanel panel_11 = new JPanel();
      page_6.add(panel_11, BorderLayout.CENTER);

      page6_table = new JTable();
      panel_11.add(page6_table);

      JPanel panel_12 = new JPanel();
      page_6.add(panel_12, BorderLayout.SOUTH);
      panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page6_name_label = new JLabel("이름 ");
      page6_name_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      panel_12.add(page6_name_label);

      page6_name_text = new JTextField();
      page6_name_text.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      panel_12.add(page6_name_text);
      page6_name_text.setColumns(10);

      JLabel page6_adopt_label = new JLabel("입양여부");
      page6_adopt_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      panel_12.add(page6_adopt_label);

      page6_adopt_text = new JTextField();
      page6_adopt_text.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      panel_12.add(page6_adopt_text);
      page6_adopt_text.setColumns(10);

      page6_done_btn = new JButton("확인");
      panel_12.add(page6_done_btn);
      page6_done_btn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      page6_done_btn.addActionListener(this);

      // page6 table 객체 생성
      page6_table = new JTable(new DefaultTableModel(title_6, 0));
      page_6.add(page6_table, BorderLayout.CENTER);

      JScrollPane page6_sp = new JScrollPane(page6_table);

      JPanel panel_40 = new JPanel();
      page_6.add(panel_40, BorderLayout.NORTH);
      page_6.add(page6_sp, "Center");
      panel_40.setLayout(new BorderLayout(0, 0));

      JButton home_btn6 = new JButton("HOME");
      home_btn6.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
      home_btn6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      panel_40.add(home_btn6, BorderLayout.EAST);

      // 6페이지 비활성화
      page_6.setVisible(false);
      // home_btn6을 눌렀을 경우 1페이지 활성화+6페이지 비활성화
      home_btn6.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_6.setVisible(false);
            clear6();
         }

      });

      // page7============================================================================================
      Object[] title_7 = { "이름", "품종", "성별", "나이", "보호 종료 사유" };

      JPanel page_7 = new JPanel();
      page_7.setBounds(0, 0, 1066, 617);
      contentPane.add(page_7);
      page_7.setLayout(new BorderLayout(0, 0));

      JPanel panel_13 = new JPanel();
      page_7.add(panel_13, BorderLayout.WEST);
      panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));

      JPanel panel_41 = new JPanel();
      panel_13.add(panel_41);
      panel_41.setLayout(new BoxLayout(panel_41, BoxLayout.Y_AXIS));

      JPanel panel_14_1 = new JPanel();
      panel_41.add(panel_14_1);

      JLabel page7_name_label = new JLabel("이름 :");
      panel_14_1.add(page7_name_label);
      page7_name_label.setFont(new Font("나눔고딕", Font.BOLD, 18));

      JPanel panel_15_1 = new JPanel();
      panel_41.add(panel_15_1);

      JLabel page7_age_label = new JLabel("나이 :");
      page7_age_label.setFont(new Font("나눔고딕", Font.BOLD, 18));
      panel_15_1.add(page7_age_label);

      JPanel panel_16_1 = new JPanel();
      panel_41.add(panel_16_1);

      JLabel page7_kind_label = new JLabel("품종 :");
      page7_kind_label.setFont(new Font("나눔고딕", Font.BOLD, 18));
      panel_16_1.add(page7_kind_label);

      JPanel panel_17_1 = new JPanel();
      panel_41.add(panel_17_1);

      JLabel page7_reason_label = new JLabel("사유 :");
      page7_reason_label.setFont(new Font("나눔고딕", Font.BOLD, 18));
      panel_17_1.add(page7_reason_label);

      JPanel panel_52 = new JPanel();
      panel_41.add(panel_52);

      JLabel page7_gender_label = new JLabel("성별 :");
      panel_52.add(page7_gender_label);
      page7_gender_label.setFont(new Font("나눔고딕", Font.BOLD, 18));

      JPanel panel_43 = new JPanel();
      panel_13.add(panel_43);
      panel_43.setLayout(new BoxLayout(panel_43, BoxLayout.Y_AXIS));

      JPanel panel_14 = new JPanel();
      panel_43.add(panel_14);

      page7_name_text = new JTextField();
      panel_14.add(page7_name_text);
      page7_name_text.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      page7_name_text.setColumns(10);

      JPanel panel_15 = new JPanel();
      panel_43.add(panel_15);

      page7_age_text = new JTextField();
      page7_age_text.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      page7_age_text.setColumns(10);
      panel_15.add(page7_age_text);

      JPanel panel_16 = new JPanel();
      panel_43.add(panel_16);

      page7_kind_text = new JTextField();
      page7_kind_text.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      page7_kind_text.setColumns(10);
      panel_16.add(page7_kind_text);

      JPanel panel_17 = new JPanel();
      panel_43.add(panel_17);

      page7_reason_text = new JTextField();
      page7_reason_text.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      page7_reason_text.setColumns(10);
      panel_17.add(page7_reason_text);

      JPanel panel_53 = new JPanel();
      panel_43.add(panel_53);

      page7_gender_text = new JTextField();
      panel_53.add(page7_gender_text);
      page7_gender_text.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      page7_gender_text.setColumns(10);

      JPanel panel_18 = new JPanel();
      page_7.add(panel_18, BorderLayout.SOUTH);

      page7_insert_btn = new JButton("삽입");
      page7_insert_btn.setFont(new Font("나눔고딕", Font.BOLD, 18));
      panel_18.add(page7_insert_btn);
      page7_insert_btn.addActionListener(this);

      page7_delete_btn = new JButton("삭제");
      page7_delete_btn.setFont(new Font("나눔고딕", Font.BOLD, 18));
      panel_18.add(page7_delete_btn);
      page7_delete_btn.addActionListener(this);

      JPanel panel_42 = new JPanel();
      page_7.add(panel_42, BorderLayout.CENTER);

      page7_table = new JTable();
      panel_42.add(page7_table);

      // page7 table 객체 생성
      page7_table = new JTable(new DefaultTableModel(title_7, 0));
      page_7.add(page7_table, BorderLayout.CENTER);

      JScrollPane page7_sp = new JScrollPane(page7_table);

      JPanel panel_44 = new JPanel();
      page_7.add(panel_44, BorderLayout.NORTH);
      page_7.add(page7_sp, "Center");
      panel_44.setLayout(new BorderLayout(0, 0));

      JPanel panel_45 = new JPanel();
      panel_44.add(panel_45, BorderLayout.EAST);

      JButton home_btn7 = new JButton("HOME");
      home_btn7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
      panel_45.add(home_btn7);

      // 7페이지 비활성화
      page_7.setVisible(false);

      // 7페이지 비활성화
      page_7.setVisible(false);
      // home_btn7을 눌렀을 경우 1페이지 활성화+7페이지 비활성화
      home_btn7.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_7.setVisible(false);
            clear7();
         }

      });

      // 8페이지========================================================================================
      Object[] title_8 = { "등록번호", "이름", "성별", "소유자", "전화번호", "주소" };

      JPanel page_8 = new JPanel();
      page_8.setBounds(0, 0, 1066, 617);
      contentPane.add(page_8);
      page_8.setLayout(new BorderLayout(0, 0));

      JPanel panel_20 = new JPanel();
      page_8.add(panel_20, BorderLayout.NORTH);

      JLabel page8_regno_label = new JLabel("등록 번호 ");
      page8_regno_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_20.add(page8_regno_label);

      page8_regno_text = new JTextField();
      page8_regno_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      panel_20.add(page8_regno_text);
      page8_regno_text.setColumns(10);

      page8_regno_btn = new JButton("검색");
      page8_regno_btn.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_20.add(page8_regno_btn);
      page8_regno_btn.addActionListener(this);

      JPanel panel_21 = new JPanel();
      page_8.add(panel_21, BorderLayout.CENTER);

      page8_table = new JTable();
      panel_21.add(page8_table);

      // page8 table 객체 생성
      page8_table = new JTable(new DefaultTableModel(title_8, 0));
      page_8.add(page8_table, BorderLayout.CENTER);

      JScrollPane page8_sp = new JScrollPane(page8_table);

      JPanel panel_46 = new JPanel();
      page_8.add(panel_46, BorderLayout.SOUTH);
      page_8.add(page8_sp, "Center");
      panel_46.setLayout(new BorderLayout(0, 0));

      JPanel panel_47 = new JPanel();
      panel_46.add(panel_47, BorderLayout.EAST);

      JButton home_btn8 = new JButton("HOME");
      home_btn8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
      panel_47.add(home_btn8);

      /*
       * JButton page9_init_btn = new JButton("초기화"); page9_init_btn.setFont(new
       * Font("나눔고딕", Font.BOLD, 15)); panel_32.add(page9_init_btn);
       */

      // 8페이지 비활성화
      page_8.setVisible(false);
      // home_btn8을 눌렀을 경우 1페이지 활성화+8페이지 비활성화
      home_btn8.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_8.setVisible(false);
            clear8();
         }

      });

      // 페이지9==================================================================================
      Object[] title_9 = { "이름", "크기", "품종", "성별", "나이", "병력", "보호시작일", "안락사예정일", "입양여부", "등록번호" };

      JPanel page_9 = new JPanel();
      page_9.setBounds(0, 0, 1068, 619);
      contentPane.add(page_9);
      page_9.setLayout(new BorderLayout(0, 0));

      JPanel panel_19 = new JPanel();
      page_9.add(panel_19, BorderLayout.WEST);
      panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.X_AXIS));

      JPanel panel_50 = new JPanel();
      panel_19.add(panel_50);
      panel_50.setLayout(new BoxLayout(panel_50, BoxLayout.Y_AXIS));

      JPanel panel_22_1 = new JPanel();
      panel_50.add(panel_22_1);
      panel_22_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_name_label = new JLabel("이름 :");
      page9_name_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_22_1.add(page9_name_label);

      JPanel panel_23_1 = new JPanel();
      panel_50.add(panel_23_1);
      panel_23_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_size_label = new JLabel("크기 :");
      page9_size_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_23_1.add(page9_size_label);

      JPanel panel_24_1 = new JPanel();
      panel_50.add(panel_24_1);
      panel_24_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_kind_label = new JLabel("품종 :");
      page9_kind_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_24_1.add(page9_kind_label);

      JPanel panel_25_1 = new JPanel();
      panel_50.add(panel_25_1);
      panel_25_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_gender_label = new JLabel("성별 :");
      page9_gender_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_25_1.add(page9_gender_label);

      JPanel panel_26_1 = new JPanel();
      panel_50.add(panel_26_1);
      panel_26_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_age_label = new JLabel("나이 :");
      page9_age_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_26_1.add(page9_age_label);

      JPanel panel_28_1 = new JPanel();
      panel_50.add(panel_28_1);
      panel_28_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_case_label = new JLabel("병력 :");
      panel_28_1.add(page9_case_label);
      page9_case_label.setFont(new Font("나눔고딕", Font.BOLD, 15));

      JPanel panel_29_1 = new JPanel();
      panel_50.add(panel_29_1);
      panel_29_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_ddate_label = new JLabel("안락사 예정일 :");
      page9_ddate_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_29_1.add(page9_ddate_label);

      JPanel panel_30_1 = new JPanel();
      panel_50.add(panel_30_1);
      panel_30_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_adopt_label = new JLabel("입양 상태 :");
      page9_adopt_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_30_1.add(page9_adopt_label);

      JPanel panel_31_1 = new JPanel();
      panel_50.add(panel_31_1);
      panel_31_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_regno_label = new JLabel("등록 번호 :");
      page9_regno_label.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_31_1.add(page9_regno_label);

      JPanel panel_27_1_1 = new JPanel();
      panel_50.add(panel_27_1_1);
      panel_27_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      JLabel page9_startday_label = new JLabel("보호 시작일 :");
      panel_27_1_1.add(page9_startday_label);
      page9_startday_label.setFont(new Font("나눔고딕", Font.BOLD, 15));

      JPanel panel_51 = new JPanel();
      panel_19.add(panel_51);
      panel_51.setLayout(new BoxLayout(panel_51, BoxLayout.Y_AXIS));

      JPanel panel_22 = new JPanel();
      panel_51.add(panel_22);

      page9_name_text = new JTextField();
      page9_name_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_name_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_name_text.setColumns(10);
      panel_22.add(page9_name_text);

      JPanel panel_23 = new JPanel();
      panel_51.add(panel_23);

      page9_size_text = new JTextField();
      page9_size_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_size_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_size_text.setColumns(10);
      panel_23.add(page9_size_text);

      JPanel panel_24 = new JPanel();
      panel_51.add(panel_24);

      page9_kind_text = new JTextField();
      page9_kind_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_kind_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_kind_text.setColumns(10);
      panel_24.add(page9_kind_text);

      JPanel panel_25 = new JPanel();
      panel_51.add(panel_25);

      page9_gender_text = new JTextField();
      page9_gender_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_gender_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_gender_text.setColumns(10);
      panel_25.add(page9_gender_text);

      JPanel panel_26 = new JPanel();
      panel_51.add(panel_26);

      page9_age_text = new JTextField();
      page9_age_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_age_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_age_text.setColumns(10);
      panel_26.add(page9_age_text);

      JPanel panel_27 = new JPanel();
      panel_51.add(panel_27);

      page9_case_text = new JTextField();
      panel_27.add(page9_case_text);
      page9_case_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_case_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_case_text.setColumns(10);

      JPanel panel_28 = new JPanel();
      panel_51.add(panel_28);

      page9_dday_text = new JTextField();
      page9_dday_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_dday_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_dday_text.setColumns(10);
      panel_28.add(page9_dday_text);

      JPanel panel_29 = new JPanel();
      panel_51.add(panel_29);

      page9_adopt_text = new JTextField();
      page9_adopt_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_adopt_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_adopt_text.setColumns(10);
      panel_29.add(page9_adopt_text);

      JPanel panel_30 = new JPanel();
      panel_51.add(panel_30);

      page9_regno_text = new JTextField();
      page9_regno_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_regno_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_regno_text.setColumns(10);
      panel_30.add(page9_regno_text);

      JPanel panel_31 = new JPanel();
      panel_51.add(panel_31);

      page9_startday_text = new JTextField();
      panel_31.add(page9_startday_text);
      page9_startday_text.setHorizontalAlignment(SwingConstants.CENTER);
      page9_startday_text.setFont(new Font("나눔고딕", Font.PLAIN, 15));
      page9_startday_text.setColumns(10);

      JPanel panel_32 = new JPanel();
      page_9.add(panel_32, BorderLayout.SOUTH);

      page9_insert_btn = new JButton("추가");
      page9_insert_btn.setFont(new Font("나눔고딕", Font.BOLD, 15));
      panel_32.add(page9_insert_btn);
      page9_insert_btn.addActionListener(this);

      JPanel panel_33 = new JPanel();
      page_9.add(panel_33, BorderLayout.CENTER);

      page9_table = new JTable();
      panel_33.add(page9_table);

      // page 9 객체 생성
      page9_table = new JTable(new DefaultTableModel(title_9, 0));
      page_9.add(page9_table, BorderLayout.CENTER);

      JScrollPane page9_sp = new JScrollPane(page9_table);

      JPanel panel_48 = new JPanel();
      page_9.add(panel_48, BorderLayout.NORTH);
      // page9_sp 삽입
      page_9.add(page9_sp, "Center");
      panel_48.setLayout(new BorderLayout(0, 0));

      JPanel panel_49 = new JPanel();
      panel_48.add(panel_49, BorderLayout.EAST);

      JButton home_btn9 = new JButton("HOME");
      home_btn9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
      panel_49.add(home_btn9);

      // 9페이지 비활성화
      page_9.setVisible(false);

      // home_btn9을 눌렀을 경우 1페이지 활성화+9페이지 비활성화
      home_btn9.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_9.setVisible(false);
            clear9();
         }

      });

      // 5페이지 비활성화
      page_5.setVisible(false);

      // ado_btn을 눌렀을 경우 6페이지 활성화+5페이지 비활성화
      ado_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_6.setVisible(true);
            page_5.setVisible(false);

            displayAdoptAllAnimals();
         }

      });

      // protect_end_btn을 눌렀을 경우 7페이지 활성화+5페이지 비활성화
      protect_end_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_7.setVisible(true);
            page_5.setVisible(false);
            displayEndAnimal();
         }

      });

      // reg_btn을 눌렀을 경우 8페이지 활성화+5페이지 비활성화
      reg_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_8.setVisible(true);
            page_5.setVisible(false);
         }

      });

      // protect_add_btn을 눌렀을 경우 9페이지 활성화+5페이지 비활성화
      protect_add_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_9.setVisible(true);

            page_5.setVisible(false);
            displayAll9Animals();
         }

      });

      // 2페이지 비활성화
      page_2.setVisible(false);

      // search_btn을 눌렀을 경우 3페이지 활성화+2페이지 비활성화
      search_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_3.setVisible(true);
            page_2.setVisible(false);
         }

      });

      // adopt_btn을 눌렀을 경우 4페이지 활성화+2페이지 비활성화
      adopt_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            page_4.setVisible(true);
            page_2.setVisible(false);

            displayAllAnimals();
         }

      });

      // home_btn2을 눌렀을 경우 1페이지 활성화+2페이지 비활성화
      home_btn2.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_1.setVisible(true);
            page_2.setVisible(false);
         }

      });

      // user_btn을 눌렀을 경우 2페이지 활성화+1페이지 비활성화
      user_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_2.setVisible(true);
            page_1.setVisible(false);
         }

      });

      // admin_btn을 눌렀을 경우 5페이지 활성화+1페이지 비활성화
      admin_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            page_5.setVisible(true);
            page_1.setVisible(false);
         }

      });
      
   }
   
   

   // page3 JTextfiled 컴포넌트 초기화
   public void clear3() {
      page3_regno.setText("");
      page3_gender_text.setText("");
      page3_size_text.setText("");

   }

// page6 JTextfiled 컴포넌트 초기화
   public void clear6() {
      page6_adopt_text.setText("");
      page6_name_text.setText("");

   }

// page7 JTextfiled 컴포넌트 초기화
   public void clear7() {
      page7_age_text.setText("");
      page7_gender_text.setText("");
      page7_kind_text.setText("");
      page7_name_text.setText("");
      page7_reason_text.setText("");

   }

// page8 JTextfiled 컴포넌트 초기화
   public void clear8() {
      page8_regno_text.setText("");

   }

   // page9 JTextfiled 컴포넌트 초기화
   public void clear9() {
      page9_name_text.setText("");
      page9_size_text.setText("");
      page9_kind_text.setText("");
      page9_gender_text.setText("");
      page9_age_text.setText("");
      page9_case_text.setText("");
      page9_dday_text.setText("");
      page9_adopt_text.setText("");
      page9_regno_text.setText("");
      page9_startday_text.setText("");

   }

   // page3 USER >> 실종 동물 찾기
   public void displayProtectRegAllAnimal() {
      System.out.println(page3_regno.getText());
      ProtectedAnimalsDTO animal = ProtectedAnimalsDAOImpl.getDAO().selectRegNoAnimals(page3_regno.getText());

      if (animal == null) {
         JOptionPane.showMessageDialog(this, "저장된 동물정보가 없습니다.");
         return;
      }

      DefaultTableModel model = (DefaultTableModel) page3_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);// JTable 컴퍼넌트의 첫번째 행을 제거
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      Vector<Object> rowData = new Vector<>();
      // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
      rowData.add(animal.getAnimal_name());
      rowData.add(animal.getAnimal_size());
      rowData.add(animal.getAnimal_kind());
      rowData.add(animal.getGedger());
      rowData.add(animal.getAge());
      rowData.add(animal.getCasehistory());
      rowData.add(animal.getProtection_startday());
      rowData.add(animal.getEuthanasia_day());
      rowData.add(animal.getAdopt());
      rowData.add(animal.getReg_no());

      // JTable 컴퍼넌트에 행을 추가하여 출력
      model.addRow(rowData);
   }

   public void displayProtectGenderAllAnimal() {
      System.out.println(page3_gender_text.getText());
      List<ProtectedAnimalsDTO> animalList = ProtectedAnimalsDAOImpl.getDAO()
            .selectGenderAnimalsList(page3_gender_text.getText());

      if (animalList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "검색된 동물정보가 없습니다.");
         return;
      }

      DefaultTableModel model = (DefaultTableModel) page3_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);// JTable 컴퍼넌트의 첫번째 행을 제거
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      for (ProtectedAnimalsDTO animal : animalList) {
         Vector<Object> rowData = new Vector<>();
         // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
         rowData.add(animal.getAnimal_name());
         rowData.add(animal.getAnimal_size());
         rowData.add(animal.getAnimal_kind());
         rowData.add(animal.getGedger());
         rowData.add(animal.getAge());
         rowData.add(animal.getCasehistory());
         rowData.add(animal.getProtection_startday());
         rowData.add(animal.getEuthanasia_day());
         rowData.add(animal.getAdopt());
         rowData.add(animal.getReg_no());

         // JTable 컴퍼넌트에 행을 추가하여 출력
         model.addRow(rowData);
      }
   }

   public void displayProtectAllAnimal() {
      System.out.println(page3_size_text.getText());
      List<ProtectedAnimalsDTO> animalList = ProtectedAnimalsDAOImpl.getDAO()
            .selectSizeAnimalsList(page3_size_text.getText());

      if (animalList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "검색된 동물정보가 없습니다.");
         return;
      }

      DefaultTableModel model = (DefaultTableModel) page3_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);// JTable 컴퍼넌트의 첫번째 행을 제거
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      for (ProtectedAnimalsDTO animal : animalList) {
         Vector<Object> rowData = new Vector<>();
         // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
         rowData.add(animal.getAnimal_name());
         rowData.add(animal.getAnimal_size());
         rowData.add(animal.getAnimal_kind());
         rowData.add(animal.getGedger());
         rowData.add(animal.getAge());
         rowData.add(animal.getCasehistory());
         rowData.add(animal.getProtection_startday());
         rowData.add(animal.getEuthanasia_day());
         rowData.add(animal.getAdopt());
         rowData.add(animal.getReg_no());

         // JTable 컴퍼넌트에 행을 추가하여 출력
         model.addRow(rowData);
      }
   }

   // JTextField 컴퍼넌트로 입력된 등록번호 제공받아 protect_animals 테이블에 저장된 해당 등록번호가 포함된
   // 보호동물정보를 검색하고 JTable 컴퍼넌트에 출력하는 메소드
   public boolean searchRegNO() {
      String regNo = page3_regno.getText();

      if (regNo.equals("")) {
         JOptionPane.showMessageDialog(this, "등록번호를 반드시 입력해 주세요.");
         page3_regno.requestFocus();
         return false;
      }

      String regNoReg = "(041)\\d{9}";
      if (!Pattern.matches(regNoReg, regNo)) {
         JOptionPane.showMessageDialog(this, "041로 시작하는 12자리 등록번호를 입력해 주세요.");
         page3_regno.requestFocus();
         return false;
      }
      return true;
   }

   // JTextField 컴퍼넌트로 입력된 성별을 제공받아 protect_animals 테이블에 저장된 해당 성별이 포함된
   // 보호동물정보를 검색하고 JTable 컴퍼넌트에 출력하는 메소드
   public boolean searchGender() {
      String gender = page3_gender_text.getText();

      if (gender.equals("")) {
         JOptionPane.showMessageDialog(this, "성별을 반드시 입력해 주세요.");
         page3_gender_text.requestFocus();
         return false;
      }

      // String GenderReg="^[가-힣]{2}|^[가-힣]{3}*$";
      // if(!Pattern.matches(GenderReg, gender)) {
      if (!gender.equals("여") && !gender.equals("남") && !gender.equals("중성")) {
         JOptionPane.showMessageDialog(this, "성별은 [여],[남],[중성]에서 선택하여 반드시 입력해주세요.");
         page3_gender_text.requestFocus();
         return false;
      }
      return true;
   }

   // JTextField 컴퍼넌트로 입력된 품종을 제공받아 protect_animals 테이블에 저장된 해당 품종이 포함된
   // 보호동물정보를 검색하고 JTable 컴퍼넌트에 출력하는 메소드
   public boolean searchKind() {
      String kind = page3_size_text.getText();

      if (kind.equals("")) {
         JOptionPane.showMessageDialog(this, "크기는 [소형견],[중형견],[대형견]에서 선택하여 반드시 입력해 주세요.");
         page3_size_text.requestFocus();
         return false;
      }
      return true;

   }

   // PROCTEDANIMALS 테이블에 저장된 모든 동물정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
   public void displayAllAnimals() {
      List<ProtectedAnimalsDTO> animalList = ProtectedAnimalsDAOImpl.getDAO().selectAllAnimalsList();

      if (animalList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "저장된 동물정보가 없습니다.");
         return;
      }
      DefaultTableModel model = (DefaultTableModel) page4_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      for (ProtectedAnimalsDTO animal : animalList) {
         Vector<Object> rowData = new Vector<>();
         // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
         rowData.add(animal.getAnimal_name());
         rowData.add(animal.getAnimal_size());
         rowData.add(animal.getAnimal_kind());
         rowData.add(animal.getGedger());
         rowData.add(animal.getAge());
         rowData.add(animal.getCasehistory());
         rowData.add(animal.getProtection_startday());
         rowData.add(animal.getEuthanasia_day());
         rowData.add(animal.getAdopt());
         rowData.add(animal.getReg_no());

         // JTable 컴퍼넌트에 행을 추가하여 출력
         model.addRow(rowData);
      }

   }

   // PROCTEDANIMALS 테이블에 저장된 모든 동물정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
   public void displayAll9Animals() {
      List<ProtectedAnimalsDTO> animalList = ProtectedAnimalsDAOImpl.getDAO().selectAllAnimalsList();

      if (animalList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "저장된 동물정보가 없습니다.");
         return;
      }
      DefaultTableModel model = (DefaultTableModel) page9_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      for (ProtectedAnimalsDTO animal : animalList) {
         Vector<Object> rowData = new Vector<>();
         // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
         rowData.add(animal.getAnimal_name());
         rowData.add(animal.getAnimal_size());
         rowData.add(animal.getAnimal_kind());
         rowData.add(animal.getGedger());
         rowData.add(animal.getAge());
         rowData.add(animal.getCasehistory());
         rowData.add(animal.getProtection_startday());
         rowData.add(animal.getEuthanasia_day());
         rowData.add(animal.getAdopt());
         rowData.add(animal.getReg_no());

         // JTable 컴퍼넌트에 행을 추가하여 출력
         model.addRow(rowData);
      }

   }

   // PROCTEDANIMALS 테이블에 저장된 모든 동물정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
   public void displayAdoptAllAnimals() {
      List<ProtectedAnimalsDTO> animalList = ProtectedAnimalsDAOImpl.getDAO().selectAllAnimalsList();

      if (animalList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "저장된 동물정보가 없습니다.");
         return;
      }
      DefaultTableModel model = (DefaultTableModel) page6_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      for (ProtectedAnimalsDTO animal : animalList) {
         Vector<Object> rowData = new Vector<>();
         // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
         rowData.add(animal.getAnimal_name());
         rowData.add(animal.getAnimal_size());
         rowData.add(animal.getAnimal_kind());
         rowData.add(animal.getGedger());
         rowData.add(animal.getAge());
         rowData.add(animal.getCasehistory());
         rowData.add(animal.getProtection_startday());
         rowData.add(animal.getEuthanasia_day());
         rowData.add(animal.getAdopt());
         rowData.add(animal.getReg_no());

         // JTable 컴퍼넌트에 행을 추가하여 출력
         model.addRow(rowData);
      }

   }

   // ADMIN >> 등록번호로 동물 찾기
   public boolean regSearch() {
      String animal = page8_regno_text.getText();

      if (animal.equals("")) {
         JOptionPane.showMessageDialog(this, "등록번호를 반드시 입력해 주세요.");
         page8_regno_text.requestFocus();
         return false;
      }

      String animalReg = "(041)\\d{9}";
      if (!Pattern.matches(animalReg, animal)) {
         JOptionPane.showMessageDialog(this, "041로 시작하는 12자리 등록번호를 입력해 주세요.");
         page8_regno_text.requestFocus();
         return false;
      }
      return true;
   }

   public void displayRegSearchAnimal() {
      System.out.println(page8_regno_text.getText());
      Registration_AnimalDTO animal = Registration_AnimalDAOImpl.getDao().selectRegAnimal(page8_regno_text.getText());

      if (animal == null) {
         JOptionPane.showMessageDialog(this, "저장된 동물정보가 없습니다.");
         return;
      }

      DefaultTableModel model = (DefaultTableModel) page8_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);// JTable 컴퍼넌트의 첫번째 행을 제거
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      Vector<Object> rowData = new Vector<>();
      // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
      rowData.add(animal.getRegNo());
      rowData.add(animal.getAnimalName());
      rowData.add(animal.getGender());
      rowData.add(animal.getMaster());
      rowData.add(animal.getPhone());
      rowData.add(animal.getAddress());

      // JTable 컴퍼넌트에 행을 추가하여 출력
      model.addRow(rowData);
   }

   // ADMIN >> 입양여부관리변경
   public boolean adoptUpdate() {
      String animal_name = page6_name_text.getText();
      String animal_adopt = page6_adopt_text.getText();

      if (animal_adopt.equals("") || animal_name.equals("")) {
         JOptionPane.showMessageDialog(this, "이름과 입양여부를 반드시 입력해 주세요.");
         page6_adopt_text.requestFocus();
         return false;
      }

      String animal_nameReg = "^[가-힣]{2,5}$";
      if (!Pattern.matches(animal_nameReg, animal_name)) {
         JOptionPane.showMessageDialog(this, "한글 2~5자리로 반드시 입력해 주세요.");
         page8_regno_text.requestFocus();
         return false;
      }
      String animal_adoptReg = "^[가-힣]{2,10}$";
      if (!Pattern.matches(animal_adoptReg, animal_adopt)) {
         JOptionPane.showMessageDialog(this, "한글 2~10자리로 반드시 입력해 주세요.");
         page8_regno_text.requestFocus();
         return false;
      }

      ProtectedAnimalsDTO animal = new ProtectedAnimalsDTO();

      animal.setAnimal_name(animal_name);
      animal.setAdopt(animal_adopt);

      int rows = ProtectedAnimalsDAOImpl.getDAO().updateProtectedAnimals(animal);

      JOptionPane.showMessageDialog(this, rows + "마리의 입양여부를 변경하였습니다.");

      displayAdoptAllAnimals();

      return false;
   }

   public void displayAdoptAnimal() {
      System.out.println(page6_adopt_text.getText());
      System.out.println(page6_name_text.getText());

      Registration_AnimalDTO animal_name = Registration_AnimalDAOImpl.getDao()
            .selectRegAnimal(page6_name_text.getText());
      Registration_AnimalDTO animal_adopt = Registration_AnimalDAOImpl.getDao()
            .selectRegAnimal(page6_adopt_text.getText());

      if (animal_name.equals("")) {
         JOptionPane.showMessageDialog(this, "변경할 동물정보가 없습니다.");
         return;
      }

      DefaultTableModel model = (DefaultTableModel) page6_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);// JTable 컴퍼넌트의 첫번째 행을 제거
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      Vector<Object> rowData = new Vector<>();
      // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
      rowData.add(animal_name.getRegNo());
      rowData.add(animal_name.getAnimalName());
      rowData.add(animal_name.getGender());
      rowData.add(animal_name.getMaster());
      rowData.add(animal_name.getPhone());
      rowData.add(animal_name.getAddress());

      // JTable 컴퍼넌트에 행을 추가하여 출력
      model.addRow(rowData);
   }

// 페이지 7 ADMIN >> 보호종료 테이블 메소드 호출
   public boolean endinsert() {
      String endanimal_name = page7_name_text.getText();
      String endanimal_age = page7_age_text.getText();
      String endanimal_kind = page7_kind_text.getText();
      String endanimal_reason = page7_reason_text.getText();
      String endanimal_gender = page7_gender_text.getText();

      String endanimal_nameReg = "^[가-힣]{2,5}$";
      String endanimal_ageReg = "\\d{1,2}";
      String endanimal_kindReg = "^[가-힣]{1,10}$";
      String endanimal_reasonReg = "^[가-힣]{2,10}$";

      if (endanimal_name.equals("") || endanimal_age == null || endanimal_kind.equals("")
            || endanimal_reason.equals("") || endanimal_gender.equals("")) {

         JOptionPane.showMessageDialog(this, "모든 항목을 반드시 입력해 주세요.");
         page7_name_text.requestFocus();
         return false;
      }

      if (!Pattern.matches(endanimal_nameReg, endanimal_name)) {
         JOptionPane.showMessageDialog(this, "이름은 한글 2~5자리로 반드시 입력해 주세요.");
         page7_name_text.requestFocus();
         return false;
      } else if (!Pattern.matches(endanimal_ageReg, endanimal_age)) {
         JOptionPane.showMessageDialog(this, "나이는 1~2자리 숫자로 반드시 입력해 주세요.");
         page7_age_text.requestFocus();
         return false;
      } else if (!Pattern.matches(endanimal_kindReg, endanimal_kind)) {
         JOptionPane.showMessageDialog(this, "품종은 한글 1~10자리로 반드시 입력해 주세요.");
         page7_kind_text.requestFocus();
         return false;
      } else if (!Pattern.matches(endanimal_reasonReg, endanimal_reason)) {
         JOptionPane.showMessageDialog(this, "사유는 한글 2~10자리로 반드시 입력해 주세요.");
         page7_reason_text.requestFocus();
         return false;
      } else if (!endanimal_gender.equals("여") && !endanimal_gender.equals("남") && !endanimal_gender.equals("중성")) {
         JOptionPane.showMessageDialog(this, "성별은 [여],[남],[중성]에서 선택하여 입력해주세요.");
         page7_gender_text.requestFocus();
         return false;
      }

      ProtectedEndAnimalsDTO endanimal = new ProtectedEndAnimalsDTO();

      endanimal.setAnimalName(endanimal_name);
      endanimal.setAnimalKind(endanimal_kind);
      endanimal.setGender(endanimal_gender);
      endanimal.setAge(Integer.parseInt(endanimal_age));
      endanimal.setReason(endanimal_reason);

      int rows = ProtectedEndAnimalsDAOImpl.getDAO().insertProtectedEndAnimal(endanimal);

      JOptionPane.showMessageDialog(this, rows + "마리의 동물정보를 삽입 하였습니다.");

      displayEndAnimal();

      enddelete(endanimal_name);
      return false;
   }

   public void displayEndAnimal() {
      List<ProtectedEndAnimalsDTO> animalList = ProtectedEndAnimalsDAOImpl.getDAO().endAnimalList();

      if (animalList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "저장된 동물 정보가 없습니다.");
         return;
      }
      DefaultTableModel model = (DefaultTableModel) page7_table.getModel();

      for (int i = model.getRowCount(); i > 0; i--) {
         model.removeRow(0);
      }

      // Vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
      for (ProtectedEndAnimalsDTO animal : animalList) {
         Vector<Object> rowData = new Vector<>();
         // StudentDTO 객체의 필드값을 Vector 객체의 요소로 추가
         rowData.add(animal.getAnimalName());
         rowData.add(animal.getAnimalKind());
         rowData.add(animal.getGender());
         rowData.add(animal.getAge());
         rowData.add(animal.getReason());

         // JTable 컴퍼넌트에 행을 추가하여 출력
         model.addRow(rowData);
      }
   }

   // 보호종료동물관리 페이지에서 삽입 버튼 > 유기동물 테이블(protected animal)에서 delete
   public void enddelete(String name) {

      System.out.println("aaa");
      int rows = ProtectedAnimalsDAOImpl.getDAO().deleteProtectedAnimals(name);

      System.out.println("bbb");
      if (rows > 0) {
         JOptionPane.showMessageDialog(this, "유기동물 테이블에서" + rows + "마리의 동물정보를 삭제 하였습니다.");
      } else {
         JOptionPane.showMessageDialog(this, "삭제할 동물정보가 없습니다.");
      }

      return;

   }

   // page 7 보호종료동물관리 페이지에서 삭제 버튼 > 보호종료 테이블(protected end animal)에서 삽입 실수시 delete
   public boolean misenddelete() {
      String animal_name = page7_name_text.getText();

      if (animal_name.equals("")) {
         JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
         page7_name_text.requestFocus();
         return false;
      }

      String endanimal_nameReg = "^[가-힣]{2,5}$";

      if (!Pattern.matches(endanimal_nameReg, animal_name)) {
         JOptionPane.showMessageDialog(this, "이름은 한글 2~5자리로 반드시 입력해 주세요.");
         page7_name_text.requestFocus();
         return false;
      }
      ProtectedEndAnimalsDTO endanimal = new ProtectedEndAnimalsDTO();

      endanimal.setAnimalName(animal_name);

      int rows = ProtectedEndAnimalsDAOImpl.getDAO().deleteProtectedEndAnimal(endanimal);

      JOptionPane.showMessageDialog(this, "보호 종료 동물 테이블에서 " + rows + "마리의 동물정보를 삭제 하였습니다.");

      displayEndAnimal();

      return false;

   }

   // page9 보호동물 추가 페이지에 >> 유기동물 테이블(protected animal )테이블에 추가
   public boolean addanimal() {
      String name = page9_name_text.getText();

      if (name.equals("")) {
         JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
         page9_name_text.requestFocus();
         return false;
      }

      String nameReg = "^[가-힣]{2,5}$";
      if (!Pattern.matches(nameReg, name)) {
         JOptionPane.showMessageDialog(this, "이름은 2~5 범위의 한글로만 입력해 주세요.");
         page9_name_text.requestFocus();
         return false;
      }
      String size = page9_size_text.getText();

      if (size.equals("")) {
         JOptionPane.showMessageDialog(this, "크기를 반드시 입력해 주세요.");
         page9_size_text.requestFocus();
         return false;
      }

      String sizeReg = "^[가-힣]{2,5}$";
      if (!Pattern.matches(sizeReg, size)) {
         JOptionPane.showMessageDialog(this, "[소형견],[중형견],[대형견] 중 하나를 반드시 입력해 주세요.");
         page9_size_text.requestFocus();
         return false;
      }

      String kind = page9_kind_text.getText();

      if (kind.equals("")) {
         JOptionPane.showMessageDialog(this, "품종을 반드시 입력해 주세요.");
         page9_kind_text.requestFocus();
         return false;
      }

      String kindReg = "^[가-힣]{2,10}$";
      if (!Pattern.matches(kindReg, kind)) {
         JOptionPane.showMessageDialog(this, "정확한 품종을 입력해 주세요.");
         page9_kind_text.requestFocus();
         return false;
      }

      String gender = page9_gender_text.getText();

      if (gender.equals("")) {
         JOptionPane.showMessageDialog(this, "성별을 반드시 입력해 주세요.");
         page9_gender_text.requestFocus();
         return false;
      }

      // String GenderReg="^[가-힣]{2}|^[가-힣]{3}*$";
      // if(!Pattern.matches(GenderReg, gender)) {
      if (!gender.equals("여") && !gender.equals("남") && !gender.equals("중성")) {
         JOptionPane.showMessageDialog(this, "성별은 [여],[남],[중성]에서 선택하여 입력해주세요.");
         page9_gender_text.requestFocus();
         return false;
      }

      String age = page9_age_text.getText();// JTextField 컴퍼넌트의 입력값을 반환받아 저장
      if (age.equals("")) {
         JOptionPane.showMessageDialog(this, "나이를 반드시 입력해 주세요.");
         page9_age_text.requestFocus();// JTextField 컴퍼넌트에 입력촛점을 제공하는 메소드
         return false;
      }

      String ageReg = "\\d{1,2}$";
      if (!Pattern.matches(ageReg, age)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
         JOptionPane.showMessageDialog(this, "나이는 1~2자리 숫자로만 입력해 주세요.");
         page9_age_text.requestFocus();
         return false;
      }

      String casehistory = page9_case_text.getText();// JTextField 컴퍼넌트의 입력값을 반환받아 저장

      String caseReg = "^[가-힣]{0,10}$";
      if (!Pattern.matches(caseReg, casehistory)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
         JOptionPane.showMessageDialog(this, "병력은 한글 2~10자리로 반드시 입력해 주세요.");
         page9_case_text.requestFocus();
         return false;
      }

      String startday = page9_startday_text.getText();
      if (startday.equals("")) {
         JOptionPane.showMessageDialog(this, "보호 시작일을 반드시 입력해 주세요.");
         page9_startday_text.requestFocus();
         return false;
      }

      String startdayReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
      if (!Pattern.matches(startdayReg, startday)) {
         JOptionPane.showMessageDialog(this, "보호 시작일을 형식에 맞게 입력해 주세요.");
         page9_startday_text.requestFocus();
         return false;
      }

      String dday = page9_dday_text.getText();
      if (dday.equals("")) {
         JOptionPane.showMessageDialog(this, "안락사 예정일을 반드시 입력해 주세요.");
         page9_dday_text.requestFocus();
         return false;
      }

      String ddayReg = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
      if (!Pattern.matches(ddayReg, dday)) {
         JOptionPane.showMessageDialog(this, "안락사 예정일을 형식에 맞게 입력해 주세요.");
         page9_dday_text.requestFocus();
         return false;
      }

      String adopt = page9_adopt_text.getText();
      if (adopt.equals("")) {
         JOptionPane.showMessageDialog(this, "입양 상태를 반드시 입력해 주세요.");
         page9_adopt_text.requestFocus();
         return false;
      }

      String adoptReg = "^[가-힣]{2,10}$";
      if (!Pattern.matches(adoptReg, adopt)) {
         JOptionPane.showMessageDialog(this, "입양 상태를 한글 2~10자리로 입력해 주세요.");
         page9_adopt_text.requestFocus();
         return false;
      }

      String regno = page9_regno_text.getText();

      String regnoReg = "(041)\\d{9}||\\d{0,9}";
      if (!Pattern.matches(regnoReg, regno)) {
         JOptionPane.showMessageDialog(this, "041로 시작하는 12자리 등록번호를 입력해 주세요.");
         page9_regno_text.requestFocus();
         return false;
      }

      ProtectedAnimalsDTO animal = new ProtectedAnimalsDTO();
      animal.setAnimal_name(name);
      animal.setAnimal_size(size);
      animal.setAnimal_kind(kind);
      animal.setGedger(gender);
      animal.setAge(Integer.parseInt(age));
      animal.setCasehistory(casehistory);
      animal.setProtection_startday(startday);
      animal.setEuthanasia_day(dday);
      animal.setAdopt(adopt);
      animal.setReg_no(regno);

      int rows = ProtectedAnimalsDAOImpl.getDAO().insertProtectedAnimals(animal);

      JOptionPane.showMessageDialog(this, rows + "마리의 동물정보를 삽입하였습니다.");

      displayAll9Animals();
      return false;

   }

   // JButton 이벤트 처리
   @Override
   public void actionPerformed(ActionEvent ev) {
      Component c = (Component) ev.getSource();
      try {
         if (c == page3_regno_btn) {
            if (!searchRegNO())
               return;
            displayProtectRegAllAnimal();
         } else if (c == page3_gender_btn) {
            if (!searchGender())
               return;
            displayProtectGenderAllAnimal();
         } else if (c == page3_size_btn) {
            if (!searchKind())
               return;
            displayProtectAllAnimal();
         } else if (c == page8_regno_btn) {
            if (!regSearch())
               return;
            displayRegSearchAnimal();
         } else if (c == page6_done_btn) {
            if (!adoptUpdate())
               return;
            adoptUpdate();
         } else if (c == page7_insert_btn) {
            if (!endinsert())
               return;
            endinsert();
         } else if (c == page7_delete_btn) {
            if (!misenddelete())
               return;
            misenddelete();
         } else if (c == page9_insert_btn) {
            if (!addanimal())
               return;
            addanimal();
         }
      } catch (Exception e) {
         System.out.println("예외발생" + e.getMessage());
      }
   }
}