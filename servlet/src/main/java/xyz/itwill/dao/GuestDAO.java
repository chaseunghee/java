package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.GuestDTO;

//GUEST 테이블에 행을 삽입,삭제,검색하기 위한 기능을 제공하는 클래스
public class GuestDAO extends JdbcDAO{ //JdbcDAO 상속받아 메소드 사용
	//싱글톤으로 만들어줌
	
	private static GuestDAO _dao;
	
	public GuestDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new GuestDAO();
	}
	
	public static GuestDAO getDao() {
		return _dao;
	}

	//방명록 게시글 정보를 전달받아 GUEST 테이블에 삽입하고 삽입행의 개수를 반환하는 메소드
	public int inserGuest(GuestDTO guest) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="insert into guest values(guest_seq.nesxtvalue, ?, ?, ?, sysdate)";
			pstmt=con.prepareStatement(sql); 
			//?,?,? 인파라메타 작성
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());
			
			rows=pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("[에러]insertGuest 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows; //삽입행의 개수 반환
	}
	
	//방명록 게시글 정보를 전달받아 GUEST 테이블에 변경하고 변경행의 개수를 반환하는 메소드
	public int updateGuest(GuestDTO guest) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="update guest set writer=?, subject=?, content=? where num=?";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, guest.getWriter());
	        pstmt.setString(2, guest.getSubject());
	        pstmt.setString(3, guest.getContent());
	        pstmt.setInt(4, guest.getNum());
	         
	        rows=pstmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("[에러]insertGuest 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//방명록 게시글 정보를 전달받아 GUEST 테이블에 삭제하고 삭제행의 개수를 반환하는 메소드
	public int deleteGuest(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from guest where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteGuest() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//방명록 게시글 정보를 전달받아 GUEST 테이블에 검색하고 검색행의 개수를 반환하는 메소드
	public GuestDTO selectGuest(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		GuestDTO guest=null; //처리결과 GuestDTO 
		
		try {
			con=getConnection();
			
			String sql="select * from guest where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				guest=new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
			}
		}catch (SQLException e) {
			System.out.println("[에러]insertGuest 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		return guest;
	}


	//GUEST 테이블에 저장된 모든 행을 검색하여 반환하는 메소드
	public List<GuestDTO> selectGuestList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<GuestDTO> guestList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql="select * from guest order by num desc";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO guest=new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
				
				guestList.add(guest);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectGuestList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return guestList;
	}
	
}
	
