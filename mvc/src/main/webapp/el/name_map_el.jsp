<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - MAP</h1>
	<hr>
	<hr>
	<%--
		스코프 객체의 속성값이 Map 객체인 경우 MapKey를 사용하여 MapValue를 제공받아 출력 처리
		=> EL 표현식으로 사용하기 부적절한 문자가 포함된 MapKey인 경우 . 연산자로 제공받아 출력 - 에러는 안떨어지는데 출력x
	<p>이름 =${nameMap.first.name } ${nameMap.second.name }</p>

		스코프 객체의 속성값이 Map 객체인 경우 EL 표현식으로 사용하기 부적절한 문자가 표현된 MapKey는 EL 표현식에서 . 연산자 대신 [] 연산자를 이용하여 표현 가능
	--%>
	<p>이름 =${nameMap["first.name"] } ${nameMap["second.name"] }</p>
	
	
</body>
</html>