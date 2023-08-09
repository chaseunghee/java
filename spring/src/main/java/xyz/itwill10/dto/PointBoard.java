package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

/* [순서-1]
	
	create table pointboard(idx number primary key, writer varchar2(20), subject varchar2(100));
	create sequence pointboard_seq;

	[순서-9] - PointBoard 클래스 생성 및 코드 작성
*/

@Data
@Builder
public class PointBoard {
	private int idx;
	private String writer;
	private String subject;
}