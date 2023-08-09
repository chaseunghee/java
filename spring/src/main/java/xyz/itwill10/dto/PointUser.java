package xyz.itwill10.dto;
/* [순서-1] 
create table pointuser(id varchar2(20) primary key, name varchar2(30), point number);

[순서-2] - PointUser 클래스 - dto 생성
 */

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PointUser {
	private String id;
	private String name;
	private int point;
}
