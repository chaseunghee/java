<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dao.SuggestDAO"%>
<%@page import="xyz.itwill.dto.SuggestDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 검색어를 전달받아 SUGGEST 테이블에 저장된 제시어 관련 정보를 검색하여 XML 데이타로 응답하는 JSP 문서 --%>    
<%
	request.setCharacterEncoding("utf-8");

	String keyword=request.getParameter("keyword");
	
	//검색어를 전달받아 SUGGEST 테이블에 저장된 제시어 관련 정보를 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 호출
	List<SuggestDTO> suggestList=null;
	if(keyword!=null && !keyword.equals("")) {//전달값이 있는 경우
		suggestList=SuggestDAO.getDAO().selectSuggestList(keyword); 
	}
%>
<result>
	<% if(suggestList!=null && !suggestList.isEmpty()) {//검색된 제시어 관련 정보가 있는 경우 %>
	<code>success</code>
	<data><![CDATA[ <%--CDATA 안에 있는건 무조건 값이 됨. json--%>
		[
		<% for(int i=0;i<suggestList.size();i++) { %>
			<% if(i>0) { %>,<% } %>
			{"word":"<%=suggestList.get(i).getWord()%>","url":"<%=suggestList.get(i).getUrl()%>"}
		<% } %>
		]
	]]></data>		
	<% } else {//검색된 제시어 관련 정보가 없는 경우%>
	<code>empty</code>		
	<% } %>
</result>