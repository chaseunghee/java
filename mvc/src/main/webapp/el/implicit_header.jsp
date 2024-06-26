<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Parameter</h1>
	<hr>
	<h2>EL 미사용</h2>
	<ul>
		<%-- request.getHeader(String name) : 리퀘스트 메세지의 머릿부에 저장된 값들중 매개변수로 전달받은 이름의 값을 반환하는 메소드 --%>
		<li>현재 접속중인 서버 = <%=request.getHeader("host") %>
		<li>클라이언트 브라우저의 종류 = <%=request.getHeader("user-agent") %>
		<%-- .nextElement() : 첫번째 값 불러옴 --%>
		<li>전달 가능한 문서의 종류 = <%=request.getHeaders("accept").nextElement()%>
	</ul>
	<hr>
	<h2>EL 사용</h2>
	<ul>
		<%-- 
			EL 표현식에서 header 내장객체 또는 headerValues 내장객체를 사용하여 리퀘스트 메세지의 머릿부에 저장된 값을 제공받아 출력 처리 가능
			=> header 내장객체 또는 headers 내장객체는 Map 객체로 맵키 대신 헤더값을 구분하는 이름을 사용하여 헤더값을 제공받아 출력 	
		--%>
		<li>현재 접속중인 서버 = ${header.host }
		<%--  ${header.user-Agent }는 안됨 - 이름 자체에 맵키로 쓸 수 없는 문자 - 포함되어 있어서 []사용해야함. --%>
		<li>클라이언트 브라우저의 종류 = ${header["user-Agent"] } %>
		<%-- headerValues.accpet : 배열이기 때문에 [0] 작성 --%>	
		<li>전달 가능한 문서의 종류 = ${headerValues.accept[0] }</li>	
	</ul>
</body>
</html>