<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="work.model.dto.Owner"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ���� Ȩ������</title>

      <script language="javascript" type="text/javascript">
	

		
</script>
</head>
<body>

<div id="container">
      <div id="header">
        <div id="mainlogo">
       		<form name="mainForm" method="post" action="loginEnd.jsp">
        		<input type="image"  src="images/mainlogo.jpg" style="position:relative;width:250px;height:110px;">
        	</form>
        </div>
        

       		
       		 <div id="align-right" style="position: relative;">
       		  <%= session.getAttribute("grade")%>
       		  <%= session.getAttribute("name") %>
       		  <span>�� �ݰ����� :) </span><p>
       		<a href="Controller?action=logout" class="topside">�α��ξƿ�</a>
			<a href="Controller?action=findMemberBylogin" class="topside">�������� Ȯ��&����
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

</head>
<body>

	<img src="images/enrollimage.jpg"
			style="position: relative; top:100px; left:400px;" width="150px"
			height="60px">
	
	<form name="checkMyInfoForm" method="post" action="updateMyInfo.jsp">
		<div style="position: relative; top: 100px;margin-left:400px; ">

			<div id="enroll">
				<div style="margin-left: 200px">
				<a	href="loginEnd.jsp" class="topside"
				style="position: relative;  bottom:50px;left:140px; ">HOME</a>
					<span class="enroll"
						style="position: absolute; left:140px; ">�⺻�����Է�</span></br>&nbsp;&nbsp;&nbsp;&nbsp;
			
					<% Owner member=(Owner)request.getAttribute("member"); %>
			
				</div>
				�� ��&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"
					value="<%= member.getName()%>" style="margin: 5px" readonly><br>
			
				<br> ���̵�&nbsp;&nbsp;<input type="text" name="userId"
					value="<%= member.getUserId()%>" style="margin: 5px" readonly><br>
			
				<br> ��й�ȣ<input type="text" name="userPw"
					value="<%= member.getUserPw()%>" style="margin: 5px" readonly><br>
				
				<br> �� �� �� <input type="text" name="mobile"
					value="<%= member.getMobile()%>" style="margin: 5px" readonly><br>
				
				<br> ���� ����<input type="text" name="address"
					 value="<%= member.getAddress()%>" style="margin: 5px"readonly><br>
			
				<br> <br> <input type="image"src="images/fix.jpg"
					style="position: relative; top: 5px; left: 120px;" width="100px"
					height="50px" onclick="document.checkMyInfoForm.submit()">
				
				</div>
			
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