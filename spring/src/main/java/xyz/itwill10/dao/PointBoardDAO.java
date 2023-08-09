package xyz.itwill10.dao;

//[순서-12]

import java.util.List;

import xyz.itwill10.dto.PointBoard;

public interface PointBoardDAO {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int idx);
	PointBoard selectPointBoard(int idx);
	List<PointBoard> selectPointBoardList();
}