<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">

<title>������ ���� Ȩ������</title>
<style>
input[type=text] {
	padding: 10px;
	width: 200px;
	text-align: left;
}
</style>

<style>
input[type=password] {
	padding: 10px;
	width: 200px;
	text-align: left;
}
</style>
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
			<a href="" class="topside">������</a>
			<a href="" class="topside">English</a> 
			<a href="loginCheck.jsp"class="topside">�α���</a>
			<a href="enrollCheck.jsp" class="topside">ȸ������</a>
			<a href="findIdPw.jsp" class="topside">���̵�/��й�ȣ ã��</a>
			</div>
    
    	
    	<div class="menu">
			<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> 
			<a href="how.jsp" class="topmenu">How to use</a> 
			<a href="careBefore.jsp" class="topmenu">Care</a> 
			<a href="service.jsp" class="topmenu">Services</a>
			</div>
		 
        			
      </div>
      <div id="loginingcontent">
      
      	<form name="loginForm" method="post" action="Controller?action=loginManager">
		<!-- �Է¾���� �б����� �׸��� ������ �ϴû�: inline������� ��Ÿ������ -->

		<img src="images/login.jpg"style="position: relative; top: 120px; left: 400px;" width="150px"
			height="50px" onclick="document.loginForm.submit();">
		<div id="loginline" style="position: relative; top: 100px; left: 600px;">
			<a	href="index.jsp" class="topside" style="position: relative; left: 310px;">HOME</a>
		</div>
		
		<div style="position: relative; top: 100px; left: 400px;">
			<div id="login">
				�ڰݹ�ȣ&nbsp;<input type="text" name="cNumber"
					placeholder="ex)1X-0000X" style="margin: 5px""><br>
				��й�ȣ&nbsp;<input type="password" name="userPw"
					placeholder="����� ��й�ȣ�� �Է����ּ���" style="margin: 5px"><br>
				<br> <input type="image"  src="images/loginsubmit.jpg"
					style="position: relative; top: 5px; left: 70px;" width="100px"
					height="60px">
					
			</div>
		</div>

	</form>
	
	<form name="enrollForm" method="post" action="managerEnroll.jsp">
		<input type="image"  src="images/enrollsubmit.jpg"
			style="position: relative; bottom: 82px; left: 700px;" width="100px"
			height="60px">
	</form>
      
      
      </div>
    
         <div id="footer">
			 <div id="align-right" style="position: relative;left:40px">
				<a href="siteMap.jsp" class="bottommenu">����Ʈ��</a>
				<a href="phoneNumber" class="bottommenu">�ֿ���ȭ��ȣ</a>
				<a href="" class="bottommenu">��������ó����ħ</a> 
				<a href=""class="bottommenu">�̸����ּҹ��ܼ����ź�</a> <br> 
			</div>
			</div>
			<div id="bottomaddress" style="position: relative; top: 20px;">
				����� ����� ������ ����Ư���� ����� ȭ���� 815</br> 815, Hwarang-ro, Nowon-gu, Seoul,
				Korea
			</div>
        
      </div>
    

</body>
</html>