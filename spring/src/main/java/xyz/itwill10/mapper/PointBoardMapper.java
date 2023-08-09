package xyz.itwill10.mapper;

//[순서-11]

import java.util.List;

import xyz.itwill10.dto.PointBoard;

public interface PointBoardMapper {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int idx);
	PointBoard selectPointBoard(int idx);
	List<PointBoard> selectPointBoardList();
}