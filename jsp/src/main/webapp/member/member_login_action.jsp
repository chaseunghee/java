<%@page import="java.net.URLEncoder"%>
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
	
	//전달값(로그인 후 요청할 JSP 문서의 URL 주소)을 반환받아 저장
	String returnUrl=request.getParameter("returnUrl");
	if(returnUrl==null){
		returnUrl="";
	}
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 DAO 클래스의 메소드 호출
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
	if(member==null || member.getMemberStatus()==0 || !member.getPasswd().equals(passwd)){
		session.setAttribute("message", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
		session.setAttribute("id", id);
		response.sendRedirect(request.getContextPath()
				+"/index.jsp?group=member&worker=member_login&returnUrl="+URLEncoder.encode(returnUrl, "utf-8"));
		return;
	}
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 회원정보의 마지막 로그인 날짜를 변경하는 DAO 클래스의 메소드 호출
	MemberDAO.getDao().updateLastLogin(id);
	
	
	//로그인 성공 - 바인딩된 세션에 권한 관련 정보의 객체를 속성값으로 저장
	// => 권한 관련 정보로 로그인 사용자정보(MemberDTO)의 객체 저장
	session.setAttribute("loginMember", MemberDAO.getDao().selectMember(id));
	
	
	//페이지 이동
	if(returnUrl.equals("")) {//반환받은 요청 JSP 문서의 URL 주소가 없는 경우 - 메인페이지 이동
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=main&worker=main_page");
	} else {//반환받은 요청 JSP 문서의 URL 주소가 있는 경우 - URL 주소의 JSP 문서로 이동
		response.sendRedirect(returnUrl);
	}
%>