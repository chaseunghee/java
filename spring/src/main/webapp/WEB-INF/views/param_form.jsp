<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [순서-11] - param_form.jsp 파일 생성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>입력페이지</h1>
	<hr>
	<form action="param" method="post">
		<%-- 내가 좋아하는 음식 : <input type="text" name="food"> --%>
		내가 좋아하는 음식 : <input type="text" name="foodname">
		<button type="submit">제출</button>
	</form>
</body>
</html>