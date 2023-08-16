package xyz.itwill10.dto;

import lombok.Data;

/* [순서-16]

create table restboard(idx number primary key, writer varchar2(50)
    , content varchar2(100), regdate date);
    
create SEQUENCE restboard_seq;

이름      널?       유형            
------- -------- ------------- 
IDX     NOT NULL NUMBER        
WRITER           VARCHAR2(50)  
CONTENT          VARCHAR2(100) 
REGDATE          DATE   

*/

@Data
public class RestBoard {
	private int idx;
	private String writer;
	private String content;
	private String regDate;
}
