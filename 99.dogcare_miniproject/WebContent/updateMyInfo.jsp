<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="work.model.dto.Owner"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ���� Ȩ������</title>

      <script language="javascript" type="text/javascript">



	/** �Է¾�� �⺻�� �ʱ�ȭ: ���̵� */
	function clearText() {
		//Ű�Է��Ҷ����� ����ʱ�ȭ: ���� 
		//document.enrollForm.txtTest1.value="";
		var initData = document.enrollForm.userId.value;
		if (initData == "���̵�") {
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
       		<form name="mainForm" method="post" action="loginEnd.jsp">
        		<input type="image"  src="images/mainlogo.jpg" style="position:relative;width:250px;height:110px;">
        	</form>
        </div>
        

       		
       		 <div id="align-right" style="position: relative;">
       		  <%= session.getAttribute("grade")%>
       		  <%= session.getAttribute("name") %>
       		  <span>�� �ݰ�����:) </span><p>
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

<% Owner member=(Owner)request.getAttribute("member"); %>
	


	
	<form name="updateMyInfoForm" method="post" action="Controller?action=updateMyInfo">
		<div style="position: relative; top: 100px;margin-left:400px; ">

			<div id="enroll">
				<div style="margin-left: 200px">
				<a	href="loginEnd.jsp" class="topside"
				style="position: relative;  bottom:50px;left:140px; ">HOME</a>
					<span class="enroll"
						style="position: absolute; left:140px; ">�⺻�����Է�</span></br>&nbsp;&nbsp;&nbsp;&nbsp;
			
					
				</div>
				�� ��&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"
					placeholder="�̸��� �Է����ּ���" style="margin: 5px" ><br>
				<br> ���̵�&nbsp;&nbsp;<input type="text" name="userId"
					 value=<%= session.getAttribute("userId") %> style="margin: 5px" readonly ><br>
				<br> ��й�ȣ<input type="text" name="userPw"
					 placeholder=" ���ο� ��й�ȣ�� �Է����ּ���." style="margin: 5px"><br>
				<br> �� �� �� <input type="text" name="mobile"
					 placeholder=" ���ο� �ڵ�����ȣ�� �Է����ּ���." style="margin: 5px" ><br>
				<br> ���� ����<input type="text" name="address"
					  placeholder=" ���ο� �������� �Է����ּ���."style="margin: 5px"><br>
			
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