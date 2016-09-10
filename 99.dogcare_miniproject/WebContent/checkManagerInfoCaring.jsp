<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="work.model.dto.Manager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>강아지 돌봄 홈페이지</title>

      <script language="javascript" type="text/javascript">
	

		
</script>
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
       		<a href="Controller?action=logout" class="topside">로그인아웃</a>
			<a href="Controller?action=findManagerBylogin" class="topside">개인정보 확인&수정
			</div>
			
			
    
    	<div class="menu">
			<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> 
			<a href="how.jsp" class="topmenu">How to use</a> 
			<a href="careOwner.jsp" class="topmenu">Care</a> 
			<a href="service.jsp" class="topmenu">Services</a>
			</div>
		 
        			
      </div>
      <div id="contentCheckManager">
      

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

	<img src="images/enrollimage.jpg"
			style="position: relative; top:100px; left:400px;" width="150px"
			height="60px">
	
	<form name="checkManagerInfoForm" method="post" action="updateManagerInfo.jsp">
		<div style="position: relative; top: 100px;margin-left:400px; ">

			<div id="enrollCheckManager">
				<div style="margin-left: 200px">
				<a	href="loginEnd.jsp" class="topside"
				style="position: relative;  bottom:50px;left:140px; ">HOME</a>
					<span class="enroll"
						style="position: absolute; left:140px; ">기본정보입력</span></br>&nbsp;&nbsp;&nbsp;&nbsp;
			
					<% Manager member=(Manager)request.getAttribute("member"); %>
				</div>
				
				이 름&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"
					value="<%= member.getName()%>" style="margin: 5px" readonly><br>
				
				
				<br> 핸 드 폰 <input type="text" name="mobile"
					value="<%= member.getMobile()%>" style="margin: 5px" readonly><br>
				
				<br> 거주환경<input type="text" name="possibleArea"
					 value="<%= member.getEnviroment()%>"
					 style="margin: 5px"readonly><br>
			
				<br> 돌봄지역<input type="text" name="enviroment"
					   value="<%= member.getPosssibleArea()%>"
					  style="margin: 5px"readonly><br>
					 
			    <br> 돌봄경험<input type="text" name="carrier"
					  value="<%= member.getCarrier()%>"
					  style="margin: 5px"readonly><br>
				 
				<br> 현재돌봄여부<input type="text" name="careDog"
					  value="<%= member.getDogCare()%>"
					  style="margin: 5px"readonly><br>
			
			
				<br> <br> <input type="image"src="images/cancle.jpg"
					style="position: relative; top: 5px; left: 120px;" width="100px"
					height="50px" onclick="history.back()">
				
				</div>
			
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