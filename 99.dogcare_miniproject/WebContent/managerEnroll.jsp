<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>강아지 돌봄 홈페이지</title>

      <script language="javascript" type="text/javascript">


"WebContent/managerEnroll.jsp"
	/** 입력양식 기본값 초기화: 아이디 */
	function clearText() {
		//키입력할때마다 계속초기화: 문제 
		//document.enrollForm.txtTest1.value="";
		var initData = document.enrollForm.userId.value;
		if (initData == "아이디") {
			document.enrollForm.txtTest1.value = "";
		}
	}

	function duplicationCheck() {
		window.location='Controller?action=join&userId='+document.enrollForm.userId.value;
		var userId = document.getElementById("userId").value;		
	}
		
		function moveItem(a, b) {
			if (a.length == 4) {
				b.focus();
			}
		}

		
</script>
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
      <div id="enrollManger">
      

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
	
	<form name="enrollForm" method="post" action="Controller?action=enrollManager">
		<div style="position: relative; top: 100px;margin-left:400px; ">

			<div id="enrollManager">
				<div style="margin-left: 200px">
				<a	href="index.jsp" class="topside"
				style="position: relative;  bottom:50px;left:190px; ">HOME</a>
					<span class="enroll"
						style="position: absolute; left:140px; ">기본정보입력</span></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;					
				</div>
				자격번호*
				<input type="text" name="cNumber"
					placeholder="애견관리사자격증번호ex)1x-1000x" style="margin:5px">
				<br> 이        름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"
					placeholder="최소 8~12자리를 입력해주세요" style="margin: 5px">
					
					
				<br> 비밀번호&nbsp;&nbsp;<input type="password" name="userPw"
					placeholder=" " style="margin: 5px"><br>
				
				<br>회원등급 <input type="radio" name="grade" value="owner" disabled>맡기미
				<input type="radio" name="grade" value="manager" checked>돌보미 <br>
				
				
				<br> 휴대폰 번호 <select name="firstPhoneNumber"
					style="width: 100px; height: 35px;">
					<option value="">::선택::</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="019">019</option>
					<option value="010">010</option>
				</select> 
				<input type="text" name="middlePhoneNumber" style="width: 50px"
					onkeydown="moveItem(this.value,document.enrollForm.lastPhoneNumber)" > 
				<input type="text" size="100" name="lastPhoneNumber" style="width: 50px"> <br>
				
				
				<br> 돌봄가능지역&nbsp;&nbsp;<input type="text" name="posssibleArea"
					placeholder="ex)구단위까지만(서울시 동작구) " style="margin: 5px"><br>
				
				
				<br>거주지환경 <input type="radio" name="enviroment" value="아파트" >아파트
				<input type="radio" name="enviroment" value="주택">주택 
				<input type="radio" name="enviroment" value="빌라">빌라
				<br>
				
				<br> 애견돌봄경력&nbsp;&nbsp;<input type="text" name="carrier"
					placeholder="ex)최장기간(시츄2년) " style="margin: 5px"><br>
				<br> <input type="image" value="가입완료"
					src="images/enrollend.jpg"
					style="position: relative; top: 5px; left: 70px;" width="100px"
					height="50px"  onclick ="return validCheck()"> 
			
					</form>

			<form name="mainForm" method="post" action="loginCheck.jsp">
        		<input type="image" value="로그인"src="images/loginsubmit.jpg"
					style="position: relative; bottom: 45px; left: 200px;" width="100px"
					height="50px" >
        	</form>
		

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