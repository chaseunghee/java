package xyz.itwill.controller;
/* [순서-40]

*/

/* [순서-44]
	@FixMethodOrder : 
*/
@
public class StudentServiceTest {

	service클래스의 메소드를 호출해서 student 잘 출력되는지 에러도 잘 뜨는지 확인하려고 하는거임
	근데 이렇게 만드는 건 권장x >> [순서-40] - 주석 처리
	=> [순서-41] - 10.dto >> Student 클래스 - @Builder 추가
	
	/* [순서-42]
	
		Student 클래스의 
	*/
	
	
	/* [순서-43]
	
	*/
	@Test
	public void testGetStudentList() {
		
	}
	
	//문제는 Test 클래스가 두 개 있는데 누가 먼저 실행될까유 testAddStudent()가 먼저 될 거 같쥬 응 아무도 몰라유 컴퓨터 맘이예유~ => [순서-44]하면 순서 정할 수 있어유
}
