package team_02;

import java.util.List;

//DAO 클래스가 상속받기 위한 인터페이스 
public interface ProtectedAnimalsDAO {
	
	//보호동물 정보를 전달받아 PROTECTED_ANIMALS 테이블에 삽입하고 삽입행에 개수를 반환하는 메소드 
	int insertProtectedAnimals(ProtectedAnimalsDTO animal);
	
	//보호동물 정보를 전달받아 PROTECTED_ANIMALS 테이블에 저장된 동물정보를 변경하고 변경행의 개수를 반환하는 메소드
	int updateProtectedAnimals(ProtectedAnimalsDTO animal);
	
	//이름을 전달받아 PROTECTED_ANIMALS 테이블에 저장된 동물정보를 삭제하고 삭제행의 개수를 반환하는 메소드
	int deleteProtectedAnimals(String animal_name);
	
	//등록번호를 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
	ProtectedAnimalsDTO selectRegNoAnimals(String reg_no);
	
	//크기를 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
	List<ProtectedAnimalsDTO> selectSizeAnimalsList(String animal_size);
	
	//성별을 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
	List<ProtectedAnimalsDTO> selectGenderAnimalsList(String gender);
	
	//ProtectedAnimals 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<ProtectedAnimalsDTO> selectAllAnimalsList();
	
}
