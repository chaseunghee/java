package team_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration_AnimalDAOImpl extends JdbcDAO implements Registration_AnimalDAO{
   private static Registration_AnimalDAOImpl _dao;

   public Registration_AnimalDAOImpl() {
      // TODO Auto-generated constructor stub
   }
   
   static {
      _dao = new Registration_AnimalDAOImpl();
   }
   
   public static Registration_AnimalDAOImpl getDao(){
      return _dao;
   }
   
   //등록번호를 전달받아 Registration_Animal테이블에 저장된 해당 등록번호의 동물정보를 검색하여 반환하는 메소드
   @Override
   public Registration_AnimalDTO selectRegAnimal(String regNo) {
      Connection con =null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      Registration_AnimalDTO registration_animal = null;
      
      try {
         con=getConnnection();
         
         String sql = "select * from Registration_Animal where reg_No=?";
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, regNo);
         
         rs=pstmt.executeQuery();
         
         if(rs.next()) {
            registration_animal = new Registration_AnimalDTO();
            
            registration_animal.setRegNo(rs.getString("reg_No"));
            registration_animal.setAnimalName(rs.getString("animal_Name"));
            registration_animal.setGender(rs.getString("gender"));
            registration_animal.setMaster(rs.getString("master"));
            registration_animal.setPhone(rs.getString("phone"));
            registration_animal.setAddress(rs.getString("address"));
         }
      }catch(SQLException e) {
         System.out.println(e.getMessage());
      }finally {
         close(con, pstmt, rs);
      }
      return registration_animal;
   }

}