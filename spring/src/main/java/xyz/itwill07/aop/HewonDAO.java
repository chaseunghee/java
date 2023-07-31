package xyz.itwill07.aop;

import java.util.List;

//[순서-2]

public interface HewonDAO {
	//추상메소드 3개 작성
	int insertHewon(Hewon hewon);
	Hewon selectHewon(int num);
	List<Hewon> selectHewonList();
}
