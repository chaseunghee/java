<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [순서-23] - join_display.jsp 파일 생성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원가입확인</h1>
	<hr>
	<%-- 
	<ul>
		<li>아이디 = ${id }</li>
		<li>비밀번호 = ${passwd }</li>
		<li>이름 = ${name }</li>
		<li>이메일 = ${email }</li>
	</ul>
	--%>
	
	<!-- [순서-28] - join_display.jsp 코드 수정(주석 >> 새로 코드 작성)
	<ul>
		<li>아이디 = ${member.id }</li>
		<li>비밀번호 = ${member.passwd }</li>
		<li>이름 = ${member.name }</li>
		<li>이메일 = ${member.email }</li>
	</ul>
	 -->
	 
	 <!-- [순서-32] - join_display.jsp 코드 수정(주석 >> 새로 코드 작성) -->
	 <ul>
		<li>아이디 = ${mem.id }</li>
		<li>비밀번호 = ${mem.passwd }</li>
		<li>이름 = ${mem.name }</li>
		<li>이메일 = ${mem.email }</li>
	</ul>
</body>
