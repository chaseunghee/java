package xyz.itwill07.aop;
//[순서-4]

import java.util.List;

public interface HewonService {
	//추상메소드 3개 작성
	void addHewon(Hewon hewon);
	Hewon getHewon(int num);
	List<Hewon> getHewonList();
}
