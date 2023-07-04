<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 30px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id=display>요청 웹프로그램에 대한 응답 결과 출력</div>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id"></td> <%-- ajax로 전달 -> name 필요X --%>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id="name"></td>
		</tr>
		<tr>
			<td colspan="2"> 
				<button type="button" id="btn">입력완료</button>
		</tr>
	</table>
	
	<script type="text/javascript">
	/*
		[입력완료] 태그를 클릭한 경우 AJAX 기능을 사용하여 example_two.jsp 문서를 요청하여 응답결과를 제공받아 태그 변경 - [21번줄] 변경할것임
		=> [example_two.jsp] 문서를 요청할 때 사용자로부터 입력받은 아이디와 이름 전달
	*/
	
	var name=document.getElementById("name").value;
	if(name=""){
		document.getElementById("display").innerHTML="이름을 입력해주세요.";
		return;
	}
	
	document.getElementById("id").value="";
	document.getElementById("name").value="";
	
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange()=function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				document.getElementById("display").innerHTML=xhr.responseText;
			}else{
				alert("에러코드 = "+xhr.status);
			}
		}
		
		/*
		[GET 방식]
		id=encodeURIComponent(id);
		name=encodeURIComponent(name);
		xhr.open("get", "example_two.jsp?id="+id+"&name="+name);
		xhr.send(null);
		*/
		
		//[POST 방식]
		xhr.open("post", "example_two.jsp");
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("id="+id+"&name="+name);
	}
	</script>
</body>
</html>