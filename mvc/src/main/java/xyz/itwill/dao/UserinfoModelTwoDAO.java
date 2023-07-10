package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.UserinfoDTO;

/*		
	◈[modelone]과 [model_two] 비교
	[model_one]에서 dao가 catch로 sqlexception잡아냈는데 [model_two]는 throws로 sqlexceiption 떠넘김.
	
	◈[model_two]에서 catch로 안하고 throws로 떠넘기는 이유
	모든 예외는 클래스마다 처리하는 건 권장x - 모델이 한번에 해줄것 
	
	-dao에 있는 메소드는 Service가 가져다 쓰고 Service에 있는 건 model이 가져다 쓰고 model은 control이 사용
	각각에서 exception이 떨어질 수 있기 때문에 각각에 에러를 잡는 것보단 다음에 떠넘긴담에 model에서 한 번에 try catch로 잡아주는것이 효율적임	
	
	-요청처리하는 메소드에서 trycatch사용하는 것이 효과적 -> 그것이 바로 Model
	
	◈[model_one]
	소형프로그램 -> dao - catch
	=> dao는 다 똑같음 (자바객체로 반환하는 걸로 끝나면 됨)
	
	◈[model_two]
	대형프로그램 -> dao - 모듈화시켜서 사용 - 서비스 사용 - throws / model에서 try-catch
*/

public class UserinfoModelTwoDAO extends JdbcDAO{
	private static UserinfoModelTwoDAO _dao;
	
	public UserinfoModelTwoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new UserinfoModelTwoDAO();
	}
	
	public static UserinfoModelTwoDAO getDAO() {
		return _dao;
	}
	
	//회원정보를 전달받아 USERINFO 테이블의 회원정보로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertUserinfo(UserinfoDTO userinfo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();

			String sql="insert into userinfo values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getUserid());
			pstmt.setString(2, userinfo.getPassword());
			pstmt.setString(3, userinfo.getName());
			pstmt.setString(4, userinfo.getEmail());
			pstmt.setInt(5, userinfo.getStatus());

			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateUserinfo(UserinfoDTO userinfo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();

			String sql="update userinfo set password=?, name=?, email=?, status=? where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getPassword());
			pstmt.setString(2, userinfo.getName());
			pstmt.setString(3, userinfo.getEmail());
			pstmt.setInt(4, userinfo.getStatus());
			pstmt.setString(5, userinfo.getUserid());

			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteUserinfo(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();

			String sql="delete from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);

			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 메소드
	public UserinfoDTO selectUserinfo(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserinfoDTO userinfo=null;
		try {
			con=getConnection();

			String sql="select * from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs=pstmt.executeQuery();

			if(rs.next()) {
				userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setStatus(rs.getInt("status"));
			}
		} finally {
			close(con, pstmt, rs);
		}
		return userinfo;
	}	

	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 List 객체로 반환하는 메소드
	public List<UserinfoDTO> selectUserinfoList() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<UserinfoDTO> userinfoList=new ArrayList<>();
		try {
			con=getConnection();

			String sql="select * from userinfo order by userid";
			pstmt=con.prepareStatement(sql);

			rs=pstmt.executeQuery();

			while(rs.next()) {
				UserinfoDTO userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setStatus(rs.getInt("status"));
				userinfoList.add(userinfo);
			}
		} finally {
			close(con, pstmt, rs);
		}
		return userinfoList;
	}
}

