<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
		내장객체를 이용하여 객체를 속성값으로 저장
		=> 속성명을 이용하여 속성값을 구분 - 내장객체가 다른 경우 같은 이름의 속성명 사용 가능 
		=> 내장객체에 동일한 속성명이 있는 경우 기존 속성값 대신 새로운 속성값으로 변경
		
		☆set 실행 후 get 실행한 결과 
		★브라우저 다 닫고 다시 실행한 결과 (session 소멸되므로)
		◇was를 restart 한 결과 (was 종료되어 다 소멸되므로)
	*/
	pageContext.setAttribute("pageName", "홍길동"); //page Scope라고 부름 - 홍길동이라고 저장된 속성값은 자기 자신만 사용 가능 => ☆null >> ★null >> ◇null
	request.setAttribute("requestName","임꺽정" ); //request Scope - 자기자신과 스레드가 이동된 JSP 사용 가능 => ☆null >> ★null >> ◇null	
	session.setAttribute("sessionName", "전우치"); //session Scope - 동일한 클라이언트가 사용하는 모든 JSP 사용 가능 => ☆전우치 >> ★null >> ◇null
	application.setAttribute("applicationName", "일지매"); //application Scope - 클라이언트에 상관없이 같은 WAS 사용하는 모든 JSP 사용 가능 => ☆일지매 >> ★일지매 >> ◇null
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<%
		/*
			내장객체에 저장된 속성값을 속성명으로 구분하여 반환받아 저장
			=> 속성명의 속성값이 없는 경우 null(아무것도 없음을 나타내는 키워드) 반환
			=> 속성값을 Object 객체로 반환하므로 반드시 명시적 객체 형변환 사용
		*/
		String pageName=(String)pageContext.getAttribute("pageName");
		String requesName=(String)request.getAttribute("requestName");
		String sessionName=(String)session.getAttribute("sessionName");
		String applicationName=(String)application.getAttribute("applicationName");
	%>
	<p>pageName = <%=pageName %></p>
	<p>requesName = <%=requesName %></p>
	<p>sessionName = <%=sessionName %></p>
	<p>applicationName = <%=applicationName %></p>
	
	
	
</body>
</html>