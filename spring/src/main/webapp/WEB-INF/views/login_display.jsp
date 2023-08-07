<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [순서-8] - login_display.jsp 파일 생성 및 코드  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>로그인 성공</h1>
	<hr>
	<h2>${loginId }님, 환영합니다.</h2>
	<a href="logout">로그아웃</a> <!-- [순서-9] - 로그아웃 태그를 눌렀을 때 로그아웃 페이지 요청하는 코드 추가 작성 -->
</body>
</html>