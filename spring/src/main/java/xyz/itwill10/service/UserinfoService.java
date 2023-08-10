package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

//[순서-7]

public interface UserinfoService {
	void addUserinfo(Userinfo userinfo) throws ExistsUserinfoException; //[순서-9] - addUserinfo는 예외만 발생시키는 애고 떠넘길거니까 throws 어쩌고 작성
	//[순서-9] - throws 빼고 작성
	void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException;
	void removeUserinfo(String userid) throws UserinfoNotFoundException;
	Userinfo getUserinfo(String userid) throws UserinfoNotFoundException;
	List<Userinfo> getUserinfoList();
	Userinfo loginAuth(Userinfo userinfo) throws LoginAuthFailException;
}
