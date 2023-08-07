<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [순서-18] - hewon_view.jsp 파일 생성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원정보</h1>
	<hr>
	<ul>
		<li>아이디 = ${hewon.id }</li>
		<li>이름 = ${hewon.name }</li>
		<li>이메일 = ${hewon.email }</li>
	</ul>
	<%-- 회원정보 변경페이지를 요청할 수 있는 링크 제공 - 아이디 전달 --%>	
	<%-- <button type="button" onclick="location.href='hewon_update?id=${hewon.id}';">회원정보변경</button> --%>

	<%-- [순서-25] - 주석 
		
	
	--%> 
</body>
</html>