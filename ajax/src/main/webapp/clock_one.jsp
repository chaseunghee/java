<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
div {
	font-size: 20px;
	margin: 10px;
}
</style>
</head>
<body>
	<h1>브라우저 캐싱</h1>
	<hr>
	<div>클라이언트 플랫폼의 현재 날짜와 시간은 
		<span id="clientTime">2023년 7월 4일 12시 22분 30초</span>입니다.</div>
	<div>서버 플랫폼의 현재 날짜와 시간은 
		<span id="ServerTime">2023년 7월 4일 12시 22분 30초</span>입니다.</div>
	<script type="text/javascript">
	
	/*
		브라우저가 실행된 클라이언트 플랫폼의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
		=> 브라우저가 실행된 클라이언트에 따라 다른 결과 제공 가능
	*/
	// [자바스크립트 이용]
	function displayClientTime() {
		var now=new Date(); 
		var displayTime=now.getFullYear()+"년"+(now.getMonth()+1)+"월"+now.getDate()+"일"+now.getHours()+"시"+now.getMinutes()+"분"+now.getSeconds()+"초";
		
		document.getElementById("clientTime").innerHTML=displayTime;
	}
	
	//자바스크립트 실행되자마자 함수 실행
	displayClientTime();
	//1초마다 displayClientTime() 함수 실행
	setInterval(displayClientTime, 1000);
	
	
	
	/*
		웹프로그램을 실행하는 서버 플랫폼의 현재 날짜와 시간을 제공받아 태그를 변경하는 함수
		=> 서버 플랫폼의 날짜와 시간을 제공받아 사용하므로 모든 클라이언트에게 동일한 결과 제공 - 일관성있는 값 제공
		- 문제점 ) 동일한 웹프로그램을 지속적으로 요청한 경우 브라우저 캐싱 기능에 의해 서버에서 제공된 응답결과가 아닌 기존 응답결과를 재사용 - 최초 응답결과를 사용하여 응답처리 
		- 해결법 - 1) 요청 웹프로그램의 URL 주소에서 질의문자열(QueryString)을 계속 변경하여 요청 - 권장X
		- 해결법 - 2) 요청 웹프로그램에서 응답결과가 브라우저 캐싱 기능으로 사용되지 않도록 무효화 처리 - clock_two.jsp에서 [7~ Date now=new Date()전 번줄] 작성
	*/
	// [AJAX 이용]
	function displayServerTime() {
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					document.getElementById("ServerTime").innerHTML=xhr.responseText;
				}else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		xhr.open("get","clock_two.jsp");// - 문제발생 - 해결법 -1/2 
		/*
		해결법 -1) 질의문자열로 url 주소 바꿈 : dummy 이름은 아무거나 상관없음. new Date().getTime()는 계속 바뀜		
		xhr.open("get","clock_two.jsp?dummy="+new Date().getTime()); 
		*/

		xhr.send(null);
	}
	//자바스크립트 실행되자마자 함수 실행
	displayServerTime();
	//1초마다 displayClientTime() 함수 실행
	setInterval(displayServerTime, 1000);
	

	
	/*
		[46번줄]
		ajax는 javascript를 사용
		javascript는 browser 종류에 따라 결과가 다르게 나옴 (크롬,엣지,사파리는 괜찮 / 인터넷익스플로러,이클립스브라우저는 안괜찮)
	*/
	</script>
</body>
</html>