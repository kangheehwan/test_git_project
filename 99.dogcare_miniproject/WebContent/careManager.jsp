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
       		  <span>님 반가워요!:) </span><p>
       		<a href="Controller?action=logout" class="topside">로그인아웃</a>
			<a href="Controller?action=findManagerbylogin" class="topside">개인정보 확인&수정
			</div>
			
    
    	
    	<div class="menu">
			<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> 
			<a href="how.jsp" class="topmenu">How to use</a> 
			<a href="careManager.jsp" class="topmenu">Care</a> 
			<a href="service.jsp" class="topmenu">Services</a>
			</div>
        			
      </div>
      <div id="contentCare">
      	<form name="insertBoard" method="post" action="insertBoard.jsp">
        <input type="image" src="images/insertboard.jpg"
		style="position: relative;top:80px;margin-left:300px;"  width="300px"height="130px"  >
        	</form>
        	
       
      	<form name="boardList" method="post" action="Controller?action=findBoardAll">
        <input type="image" src="images/list.jpg"
		style="position: relative; margin-left:720px; bottom:35px;" width="300px"height="95px"  >
      	</form>
        	
        <form name="showCaring" method="post" action="Controller?action=findCaringBycNumber">
        <input type="image" src="images/showCaring.jpg"
		style="position: relative;top:30px;margin-left:300px;"  width="300px"height="95px"  >
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
 

</body>
</html>