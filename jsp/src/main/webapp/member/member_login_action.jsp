<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	로그인정보를 전달받아 MEMBER 테이블에 저장된 회원정보와 비교하여 로그인 처리하고 [main/main_page.jsp] 문서를 요청하기 위한 URL 주소를 전달하여 응답하는 JSP 문서
	=> 전달받은 로그인정보로 인증이 실패한 경우 [member/member_login.jsp] 문서를 요청하기 위한 URL 주소를 전달하여 응답하는 JSP 문서
--%>
<% 
	//JSP 문서를 GET 방식으로 요청한 경우 - 비정상적인 요청
	if(request.getMethod().equals("GET")){
		//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=error&worker=error_404");
	}

	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=Utility.encrypt(request.getParameter("passwd"));//전달값을 암호화 처리하여 저장
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 DAO 클래스
	MemberDTO member=MemberDAO.getDao().selectMember(id);

	/* ★
	if(member==null){ //검색된 회원정보가 없는 경우 - 아이디 인증 실패
		session.setAttribute("message", "아이디를 잘못 입력했습니다. 입력하신 내");
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=member&worker=member_login");
		return;
	}
	
	//검색된 회원정보의 비밀번호와 입력되어 전달된 비밀번호를 비교하여 다른 경우 - 비밀번호 인증 실패
	if(!member.getPasswd().equals(passwd)){
		session.setAttribute("message", "비밀번호를 잘못 입력했습니다.");
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=member&worker=member_login");
		return;
	}
	*/
	
	//★ 중 하나 선택하여 작성하면 됨
	
	//★ 검색된 회원정보가 없거나 검색된 회원정보의 비밀번화 입력되어 전달된 비밀번호를 비교하여 다른 경우 - 아이디, 비밀번호 인증 실패
	if(member==null || !member.getPasswd().equals(passwd)){
		session.setAttribute("message", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=member&worker=member_login");
		return;
	}
	
	//인증 성공 - 바인딩된 세션에 권한 관련 정보의 객체를 속성값으로 저장
	session.setAttribute("loginMember", member); //member로 하면 다시 검색할 필요가 없음.
	
	//페이지 이동
	response.sendRedirect(request.getContextPath()+"/index.jsp?group=main&worker=member_main_page");
%>