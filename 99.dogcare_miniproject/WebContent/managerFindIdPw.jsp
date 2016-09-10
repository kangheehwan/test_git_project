<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>강아지 돌봄 홈페이지</title>
</head>
<body>

<div id="container">
      <div id="header">
        <div id="mainlogo">
       		<form name="mainForm" method="post" action="index.jsp">
        		<input type="image"  src="images/mainlogo.jpg" style="position:relative;width:250px;height:110px;">
        	</form>
        </div>
        

       		
       		 <div id="align-right" style="position: relative;">
			<a href="" class="topside">日本語</a>
			<a href="" class="topside">English</a> 
			<a href="loginCheck.jsp"class="topside">로그인</a>
			<a href="enrollCheck.jsp" class="topside">회원가입</a>
			<a href="findIdPw.jsp" class="topside">아이디/비밀번호 찾기</a>
			</div>
			
    
    	<div class="menu">
			<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> 
			<a href="how.jsp" class="topmenu">How to use</a> 
			<a href="careBefore.jsp" class="topmenu">Care</a> 
			<a href="service.jsp" class="topmenu">Services</a>
			</div>
		 
        			
      </div>
      
      <div id="findcontent">
      <style>
input[type=text] {
	padding: 10px;
	width: 200px;
	text-align: left;
	border: 2px solid #0065B3;
	border-radius: 4px;
}
</style>
<style>
input[type=password] {
	padding: 10px;
	width: 200px;
	text-align: left;
	border: 2px solid #0065B3;
	border-radius: 4px;
}
</style>

</head>
<body>
      <form name="findIdForm" method="post" action="Controller?action=managerFindId">
		<!-- 입력양식의 읽기전용 항목의 색상을 하늘색: inline방식으로 스타일지정 -->

	

		<div id="loginline"
		style="position: relative; top: 100px; margin-left: 400px;">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="index.jsp" class="topside"
				style="position: relative; left: 400px;">HOME</a>
		</div>
			<div id="find" style="position: relative;  margin-left:400px;">
				<div style="position: relative; bottom: 80px; right: 80px; margin: 5px">아이디검색</div>
				
				<input type="text" name="name" placeholder="당신의 이름을 입력해주세요"
					style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>
				
				<input type="text" name="mobile" placeholder="ex)010-1234-1234"
					style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>

				<br> <input type="image" value="변경저장" src="images/findId.jpg"
					style="position: relative; bottom: 180px; left: 200px;"
					width="100px" height="80px">
					
	</form>
	<form name="findPwForm" method="post" action="Controller?action=managerFindPw">
		<div 
			style="position: relative; bottom: 80px; right: 80px; margin: 5px">비밀번호검색</div>
		<input type="text" name="cNumber" placeholder="애견관리사 자격번호를 입력해주세요"
			style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>
		<input type="text" name="mobile" placeholder="ex)010-1234-1234"
			style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>
		<br> <input type="image" value="변경저장" src="images/findPw.jpg"
			style="position: relative; bottom: 180px; left: 200px;" width="100px"
			height="80px">

		

	</form>
	
	
      </div>
      
      </div>
    
      <div id="footer">
			 <div id="align-right" style="position: relative;left:40px">
				<a href="siteMap.jsp" class="bottommenu">사이트맵</a>
				<a href="phoneNumber" class="bottommenu">주요전화번호</a>
				<a href="" class="bottommenu">개인정보처리방침</a> 
				<a href=""class="bottommenu">이메일주소무단수집거부</a> <br> 
			</div>
			</div>
			<div id="bottomaddress" style="position: relative; top: 20px;">
				서울시 노원구 공릉동 서울특별시 노원구 화랑로 815</br> 815, Hwarang-ro, Nowon-gu, Seoul,
				Korea
			</div>
        
      </div>

</body>
</html>

