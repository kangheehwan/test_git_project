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
       		<form name="mainForm" method="post" action="loginEnd.jsp">
        		<input type="image"  src="images/mainlogo.jpg" style="position:relative;width:250px;height:110px;">
        	</form>
        </div>
        		<% String cNumber = request.getParameter("cNumber"); %>
       		 <div id="align-right" style="position: relative;">
       		  <%= session.getAttribute("grade")%>
       		  <%= session.getAttribute("name") %>
       		  <span>님 반가워요 :) </span><p>
       		<a href="Controller?action=logout" class="topside">로그인아웃</a>
			<a href="Controller?action=findMemberBylogin" class="topside">개인정보 확인&수정
			</div>
			
    
    	
    	<div class="menu">
			<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> 
			<a href="how.jsp" class="topmenu">How to use</a> 
			<a href="careOwner.jsp" class="topmenu">Care</a> 
			<a href="service.jsp" class="topmenu">Services</a>
			</div>
        			
      </div>
      <div id="content">
      
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
      <form name="enrollForm" method="post"
				action="Controller?action=insertPet&cNumber=<%=cNumber%>">
				<div style="position: relative; top: 100px; margin-left: 400px;">

					<div id="enrollInsert">
						<div style="margin-left: 200px">
							<a href="loginEnd.jsp" class="topside"
								style="position: relative; bottom: 50px; left: 190px;">HOME</a>
							<span class="enroll" style="position: absolute; left: 140px;">강아지정보입력</span><br>
							<br>
							<br>
							<br>

						</div>
						등록번호&nbsp;<input type="text" name="dogNumber"
							placeholder="ex)애견등록번호 -> 4xxx1" style="margin: 5px"><br>

						명     칭&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dogName"
							placeholder="ex)강아지 이름을 입력해주세요." style="margin: 5px"><br>
							
						강아지종&nbsp;<input type="text" name="dogKind"
							placeholder="ex)시츄,말티즈" style="margin: 5px"><br>
							
						나           이 &nbsp;&nbsp;&nbsp;<input type="text" name="dogAge"
							placeholder="ex)3,4->나이(숫자)만 입력해주세요." style="margin: 5px"><br>
							
						성           별 &nbsp;&nbsp;&nbsp;<input type="text" name="gender"
							placeholder="ex)수컷,암컷" style="margin: 5px"><br>
						
						
						<br> <br> <input type="image" value="가입완료"
							src="images/enroll.jpg"
							style="position: relative; top: 5px; left: 70px;" width="100px"
							height="50px" onclick="return validCheck()">
			</form>


		
				<input type="image" value="취소" src="images/cancle.jpg"
					style="position: relative; top:5px; left:100px; "
					width="100px" height="50px"onclick="history.back();">
		


		</div>
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