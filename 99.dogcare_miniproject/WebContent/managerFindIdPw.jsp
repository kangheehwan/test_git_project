<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ���� Ȩ������</title>
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
		<!-- �Է¾���� �б����� �׸��� ������ �ϴû�: inline������� ��Ÿ������ -->

	

		<div id="loginline"
		style="position: relative; top: 100px; margin-left: 400px;">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="index.jsp" class="topside"
				style="position: relative; left: 400px;">HOME</a>
		</div>
			<div id="find" style="position: relative;  margin-left:400px;">
				<div style="position: relative; bottom: 80px; right: 80px; margin: 5px">���̵�˻�</div>
				
				<input type="text" name="name" placeholder="����� �̸��� �Է����ּ���"
					style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>
				
				<input type="text" name="mobile" placeholder="ex)010-1234-1234"
					style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>

				<br> <input type="image" value="��������" src="images/findId.jpg"
					style="position: relative; bottom: 180px; left: 200px;"
					width="100px" height="80px">
					
	</form>
	<form name="findPwForm" method="post" action="Controller?action=managerFindPw">
		<div 
			style="position: relative; bottom: 80px; right: 80px; margin: 5px">��й�ȣ�˻�</div>
		<input type="text" name="cNumber" placeholder="�ְ߰����� �ڰݹ�ȣ�� �Է����ּ���"
			style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>
		<input type="text" name="mobile" placeholder="ex)010-1234-1234"
			style="position: relative; bottom: 70px; right: 50px; margin: 5px"><br>
		<br> <input type="image" value="��������" src="images/findPw.jpg"
			style="position: relative; bottom: 180px; left: 200px;" width="100px"
			height="80px">

		

	</form>
	
	
      </div>
      
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

