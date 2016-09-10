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
       		<form name="mainForm" method="post" action="loginEndManager.jsp">
        		<input type="image"  src="images/mainlogo.jpg" style="position:relative;width:250px;height:110px;">
        	</form>
        </div>
        		
       		 <div id="align-right" style="position: relative;">
       		  <%= session.getAttribute("grade")%>
       		  <%= session.getAttribute("name") %>
       		  <span>님 반가워요 :) </span><p>
       		<a href="Controller?action=logoutManager" class="topside">로그인아웃</a>
			<a href="Controller?action=findManagerBylogin" class="topside">개인정보 확인&수정
			</div>
			
    
    	
    	<div class="menu">
			<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> 
			<a href="how.jsp" class="topmenu">How to use</a> 
			<a href="careManager.jsp" class="topmenu">Care</a> 
			<a href="service.jsp" class="topmenu">Services</a>
			</div>
        			
      </div>
      <div id="content">
      
      <div style="position: relative; top:50px; margin-left:130px; ">
			<input type="image"  src="images/kakao.jpg"style="position: relative; width:400px;height:300px; ">
			</div>
      
      		<div style="position: relative; bottom:250px; margin-left:600px; ">
			<iframe width="490" height="315" src="https://www.youtube.com/embed/Oh7eMWjw7oo" frameborder="0" allowfullscreen></iframe>
			<input type="image"  src="images/mainmovie.jpg" style="position:relative;margin-left:100px;">
			</div>
			
			<div style="position: relative; bottom:200px;  ">
			<input type="image"  src="images/advertisement.jpg"style="position: relative; margin-left:100px; ">
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
 

</body>
</html>