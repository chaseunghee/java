<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [순서-36] - same_form.jsp 파일 생성 후 코드 작성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>입력페이지</h1>
	<hr>
	<form action="same_param" method="post">
		좋아하는 음식-1 : <input type="text" name="food"><br>
		좋아하는 음식-2 : <input type="text" name="food"><br>
		<button type="submit">제출</button>
	</form>
</body>
</html>