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
      
      <div id="logincontent">
     	 <form name="ownerForm" method="post" action="ownerEnroll.jsp">
      		<input type="image" value="owner"src="images/owner.jpg"
			style="position: relative; top: 30px; left: 200px;" width="400px"
					height="250px">
      </form>
      
      <form name="managerForm" method="post" action="managerEnroll.jsp">
      	<input type="image" value="manager"src="images/manager.jpg"
		style="position: relative; bottom: 220px; left:700px;" width="400px"
					height="250px">
					
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
   

</body>
</html>