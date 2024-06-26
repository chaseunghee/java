package xyz.itwill10.mapper;
//[순서-4]
import java.util.List;

import xyz.itwill10.dto.Userinfo;

public interface UserinfoMapper {
	int insertUserinfo(Userinfo userinfo);
	int updateUserinfo(Userinfo userinfo);
	int deleteUserinfo(String userid);
	Userinfo selectUserinfo(String userid);
	List<Userinfo> selectUserinfoList();
}