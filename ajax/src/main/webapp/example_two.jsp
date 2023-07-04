<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//[POST 방식]
	request.setCharacterEncoding("utf-8");

	//[GET] & [POST]
	String id=request.getParameter("id");
	String name=request.getParameter("name");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
	<%=name %>[<%=id %>]님, 환영합니다.
</body>
</html>