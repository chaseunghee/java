<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVS</title>
</head>
<body>
	<h1>EL -List</h1>
	<hr>
	<p>과일-1 = ${fruitsMap.one }</p>
	<p>과일-2 = ${fruitsMap.two }</p>
	<p>과일-3 = ${fruitsMap.three }</p>
	<hr>
	<p>좋아하는 과일 = ${fruitsMap.two }</p>
	<p>좋아하는 과일 = ${fruitsMap["two"] }</p>
	<hr>
	<p>${choice }</p>
	<%--
		스코프 객체의 속성값이 Map 객체인 경우 MapKey를 사용하여 MapValue를 제공받아 출력 처리
		=> MapKey로 제공되는 MapValue가 없는 경우 EL 미실행
	--%>
	<p>좋아하는 과일 = ${fruitsMap.choice }</p> <%-- fruitsMap에는 one,two,three 키만 있는데 choice가 chioce라는 맵키가 되어서 출력X --%>
	
	<%--
		스코프 객체의 속성값이 Map 객체인 경우 EL 표현식에서 [] 연산자를 사용하여 다른 스코프 객체의 속성값을 제공받아 MapKey로 사용하여 MapValue를 제공받아 출력 처리 가능
	--%>
	<p>좋아하는 과일 = ${fruitsMap[choice] }</p>
</body>
</html>