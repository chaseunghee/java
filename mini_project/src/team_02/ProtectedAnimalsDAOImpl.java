package team_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//PROTECTED_ANIMALS 테이블에 행을 삽입,삭제,변경,검색하는 기능의 메소드를 제공하는 클래스 
public class ProtectedAnimalsDAOImpl extends JdbcDAO implements ProtectedAnimalsDAO {
   // 싱글톤
   private static ProtectedAnimalsDAOImpl _dao;

   public ProtectedAnimalsDAOImpl() {
      // TODO Auto-generated constructor stub
   }

   static {
      _dao = new ProtectedAnimalsDAOImpl();
   }

   public static ProtectedAnimalsDAOImpl getDAO() {
      return _dao;
   }

   // 보호동물 정보를 전달받아 PROTECTED_ANIMALS 테이블에 삽입하고 삽입행의 개수를 반환하는 메소드
   @Override
   public int insertProtectedAnimals(ProtectedAnimalsDTO animal) {
      Connection con = null;
      PreparedStatement pstmt = null;
      int rows = 0;

      try {
         con = getConnnection();

         String sql = "insert into PROTECTED_ANIMALS values (?,?,?,?,?,?,?,?,?,?)";

         pstmt = con.prepareStatement(sql);

         pstmt.setString(1, animal.getAnimal_name());
         pstmt.setString(2, animal.getAnimal_size());
         pstmt.setString(3, animal.getAnimal_kind());
         pstmt.setString(4, animal.getGedger());
         pstmt.setInt(5, animal.getAge());
         pstmt.setString(6, animal.getCasehistory());
         pstmt.setString(7, animal.getProtection_startday());
         pstmt.setString(8, animal.getEuthanasia_day());
         pstmt.setString(9, animal.getAdopt());
         pstmt.setString(10, animal.getReg_no());

         rows = pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("[에러]insertProtectedAnimals() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt);
      }
      return rows;
   }

   // 보호동물 정보를 전달받아 PROTECTED_ANIMALS 테이블에 저장된 학생정보를 변경하고 변경행의 개수를 반환하는 메소드\
   @Override
   public int updateProtectedAnimals(ProtectedAnimalsDTO animal) {
      Connection con = null;
      PreparedStatement pstmt = null;
      int rows = 0;

      try {
         con = getConnnection();

         String sql = "update PROTECTED_ANIMALS set ADOPT=? where ANIMAL_NAME=? ";

         pstmt = con.prepareStatement(sql);

         pstmt.setString(1, animal.getAdopt());
         pstmt.setString(2, animal.getAnimal_name());

         rows = pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("[에러]updateProtectedAnimals() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt);
      }
      return rows;
   }

   // 이름을 전달받아 PROTECTED_ANIMALS 테이블에 저장된 동물정보를 삭제하고 삭제행의 개수를 반환하는 메소드
   @Override
   public int deleteProtectedAnimals(String animal_name) {
      Connection con = null;
      PreparedStatement pstmt = null;
      int rows = 0;

      try {
         con = getConnnection();

         String sql = "delete from PROTECTED_ANIMALS where animal_name=?";

         pstmt = con.prepareStatement(sql);

         pstmt.setString(1, animal_name);

         rows = pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println("[에러]deleteProtectedAnimals() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt);
      }
      return rows;
   }

   // 등록번호를 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
   @Override
   public ProtectedAnimalsDTO selectRegNoAnimals(String reg_no) {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ProtectedAnimalsDTO animal = null;

      try {
         con = getConnnection();

         String sql = "select * from PROTECTED_ANIMALS where reg_no=?";

         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, reg_no);

         rs = pstmt.executeQuery();

         if (rs.next()) {
            animal = new ProtectedAnimalsDTO();

            animal.setAnimal_name(rs.getString("ANIMAL_NAME"));
            animal.setAnimal_size(rs.getString("ANIMAL_SIZE"));
            animal.setAnimal_kind(rs.getString("ANIMAL_KIND"));
            animal.setGedger(rs.getString("GENDER"));
            animal.setAge(rs.getInt("AGE"));
            animal.setCasehistory(rs.getString("CASEHISTORY"));
            animal.setProtection_startday(rs.getString("PROTECTION_STARTDAY").substring(0, 10));
            animal.setEuthanasia_day(rs.getString("EUTHANASIA_DAY").substring(0, 10));
            animal.setAdopt(rs.getString(("ADOPT")));
            animal.setReg_no(rs.getString("REG_NO"));
         }

      } catch (SQLException e) {
         System.out.println("[에러]selectRegNoAnimals() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt, rs);
      }
      return animal;
   }

   // 크기를 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
   @Override
   public List<ProtectedAnimalsDTO> selectSizeAnimalsList(String animal_size) {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<ProtectedAnimalsDTO> animalList = new ArrayList<>();

      try {
         con = getConnnection();

         String sql = "select * from PROTECTED_ANIMALS where ANIMAL_SIZE=?";

         pstmt = con.prepareStatement(sql);

         pstmt.setString(1, animal_size);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            ProtectedAnimalsDTO animal = new ProtectedAnimalsDTO();

            animal.setAnimal_name(rs.getString("ANIMAL_NAME"));
            animal.setAnimal_size(rs.getString("ANIMAL_SIZE"));
            animal.setAnimal_kind(rs.getString("ANIMAL_KIND"));
            animal.setGedger(rs.getString("GENDER"));
            animal.setAge(rs.getInt("AGE"));
            animal.setCasehistory(rs.getString("CASEHISTORY"));
            animal.setProtection_startday(rs.getString("PROTECTION_STARTDAY").substring(0, 10));
            animal.setEuthanasia_day(rs.getString("EUTHANASIA_DAY").substring(0, 10));
            animal.setAdopt(rs.getString("ADOPT"));
            animal.setReg_no(rs.getString("REG_NO"));

            animalList.add(animal);
         }

      } catch (SQLException e) {
         System.out.println("[에러]selectSizeAnimalsList() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt, rs);
      }

      return animalList;
   }

   // 성별을 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
   @Override
   public List<ProtectedAnimalsDTO> selectGenderAnimalsList(String gender) {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<ProtectedAnimalsDTO> animalList = new ArrayList<>();

      try {
         con = getConnnection();

         String sql = "select * from PROTECTED_ANIMALS where gender=?";

         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, gender);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            ProtectedAnimalsDTO animal = new ProtectedAnimalsDTO();

            animal.setAnimal_name(rs.getString("ANIMAL_NAME"));
            animal.setAnimal_size(rs.getString("ANIMAL_SIZE"));
            animal.setAnimal_kind(rs.getString("ANIMAL_KIND"));
            animal.setGedger(rs.getString("GENDER"));
            animal.setAge(rs.getInt("AGE"));
            animal.setCasehistory(rs.getString("CASEHISTORY"));
            animal.setProtection_startday(rs.getString("PROTECTION_STARTDAY").substring(0, 10));
            animal.setEuthanasia_day(rs.getString("EUTHANASIA_DAY").substring(0, 10));
            animal.setAdopt(rs.getString(("ADOPT")));
            animal.setReg_no(rs.getString("REG_NO"));

            animalList.add(animal);
         }

      } catch (SQLException e) {
         System.out.println("[에러]selectGenderAnimalsList() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt, rs);
      }
      return animalList;
   }

   @Override
   public List<ProtectedAnimalsDTO> selectAllAnimalsList() {
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<ProtectedAnimalsDTO> animalList = new ArrayList<>();

      try {
         con = getConnnection();

         String sql = "select * from PROTECTED_ANIMALS order by EUTHANASIA_DAY";

         pstmt = con.prepareStatement(sql);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            ProtectedAnimalsDTO animal = new ProtectedAnimalsDTO();

            animal.setAnimal_name(rs.getString("ANIMAL_NAME"));
            animal.setAnimal_size(rs.getString("ANIMAL_SIZE"));
            animal.setAnimal_kind(rs.getString("ANIMAL_KIND"));
            animal.setGedger(rs.getString("GENDER"));
            animal.setAge(rs.getInt("AGE"));
            animal.setCasehistory(rs.getString("CASEHISTORY"));
            animal.setProtection_startday(rs.getString("PROTECTION_STARTDAY").substring(0, 10));
            animal.setEuthanasia_day(rs.getString("EUTHANASIA_DAY").substring(0, 10));
            animal.setAdopt(rs.getString("ADOPT"));
            animal.setReg_no(rs.getString("REG_NO"));

            animalList.add(animal);
         }

      } catch (SQLException e) {
         System.out.println("[에러]selectSizeAnimalsList() 메소드의 SQL 오류 = " + e.getMessage());
      } finally {
         close(con, pstmt, rs);
      }

      return animalList;
   }

}