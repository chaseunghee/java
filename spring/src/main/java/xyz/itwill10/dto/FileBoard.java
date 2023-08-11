package xyz.itwill10.dto;
/* [순서-37] - 테이블 생성
create table fileboard(idx number primary key, writer varchar2(20), subject varchar2(100)
    , origin varchar2(100), upload varchar(100));

create sequence fileboard_seq;

이름      널?       유형            
------- -------- ------------- 
IDX     NOT NULL NUMBER         - 글번호
WRITER           VARCHAR2(20)   - 작성사
SUBJECT          VARCHAR2(100)  - 제목
ORIGIN           VARCHAR2(100)  - 사용자로부터 입력받은 파일명
UPLOAD           VARCHAR2(100)  - 서버에 저장된 파일명

*/

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/* [순서-38] - FileBoard 클래스 생성 및 코드 작성 - dto

	DAO 클래스의 메소드에서 사용하기 위한 객체를 표현하기 위한 클래스 - DTO 클래스
	=> 전달값이 저장된 Command 객체를 표현하기 위한 클래스의 기능 
*/
@Data
public class FileBoard {
	private int idx;
	private String writer;
	private String subject;
	private String origin;
	private String upload;
	//사용자로부터 입력되어 전달된 파일정보를 저장하기 필드
	private MultipartFile multipartFile;
}