package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.FileBoard;

//[순서-43] -예외발생되게 만들어줘야되는데 파일처리하는게 중요하기 때문에 일단 안할거임 
public interface FileBoardService {
	void addFileBoard(FileBoard fileBoard);
	void removeFileBoard(int idx);
	FileBoard getFileBoard(int idx);
	List<FileBoard> getFileBoardList();
}