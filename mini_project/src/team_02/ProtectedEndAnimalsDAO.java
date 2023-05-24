package team_02;

import java.util.List;

//PROTECTED_END_ANIMALS 관련 DAO가 상속받기 위한 인터페이스
public interface ProtectedEndAnimalsDAO {
 //1. 보호종료동물 정보를 전달받아 PROTECTED_END_ANIMALS 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
 int insertProtectedEndAnimal(ProtectedEndAnimalsDTO proEndAnimal);
 
 //2. 잘못 삽입된 보호종료동물 이름을 전달받아 PROTECTED_END_ANIMALS 테이블에 저장된 동물정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
 int deleteProtectedEndAnimal(ProtectedEndAnimalsDTO proEndAnimal);
 
 List<ProtectedEndAnimalsDTO> endAnimalList();
}