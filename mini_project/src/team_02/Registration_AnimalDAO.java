package team_02;

//DAO 클래스가 상속받기 위한 인터페이스
public interface Registration_AnimalDAO {

   //등록번호를 가진 동물의 등록정보를 전달받아 해당 동물의 정보를 검색하여 반환하는 메소드
   Registration_AnimalDTO selectRegAnimal(String regNo);
}