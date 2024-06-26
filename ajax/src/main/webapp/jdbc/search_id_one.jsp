<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
     사용자로부터 이름과 이메일을 입력받아 아이디를 검색하여 클라이언트에게 전달하여 응답하는 JSP 문서 
	=> 아이디는 [search_id_two.jsp] 문서를 AJAX 기능으로 요청(이름과 이메일 전달)하여 실행결과를 XML 데이타로 응답받아 출력 처리
--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="btn">아이디 찾기</button></td>
		</tr>
	</table>
	<hr>
	<div id="result"><%-- 홍길동님의 아이디는 [abc123]입니다.--%></div>
	
	<script type="text/javascript">
	$("#btn").click(function() {
		var name=$("#name").val(); //#name = id의 name
		if(name=="") {
			$("#result").html("이름을 입력해 주세요.");
			$("#name").focus();
			return;
		}
		
		var email=$("#email").val();
		if(email=="") {
			$("#result").html("이메일을 입력해 주세요.");
			$("#email").focus();
			return;
		}
		
		$("#name").val("");
		$("#email").val("");
		
		//AJAX 기능을 사용하여 [search_id_two.jsp] 문서를 요청하여 실행결과를 XML 데이타로 응답받아 출력 처리
		$.ajax({
			type: "post",
			url: "search_id_two.jsp",
			/*
				data: "name="+name+"&email="+email 
				값을 Object 객체의 속성값으로 표현하여 전달 가능
			*/
			data: {"name":name,"email":email},
			dateType: "xml",
			success: function(xmlDoc) {
				var code=$(xmlDoc).find("code").text();
				if(code=="success") {
					var id=$(xmlDoc).find("id").text();
					$("#result").html(name+"님의 아이디는 ["+id+"]입니다.");
				} else {
					$("#result").html(name+"님의 아이디를 찾을 수 없습니다.");
				}
			}, 
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>