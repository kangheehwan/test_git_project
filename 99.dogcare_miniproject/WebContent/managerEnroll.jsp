<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ���� Ȩ������</title>

      <script language="javascript" type="text/javascript">


"WebContent/managerEnroll.jsp"
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
						style="position: absolute; left:140px; ">�⺻�����Է�</span></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;					
				</div>
				�ڰݹ�ȣ*
				<input type="text" name="cNumber"
					placeholder="�ְ߰������ڰ�����ȣex)1x-1000x" style="margin:5px">
				<br> ��        ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"
					placeholder="�ּ� 8~12�ڸ��� �Է����ּ���" style="margin: 5px">
					
					
				<br> ��й�ȣ&nbsp;&nbsp;<input type="password" name="userPw"
					placeholder=" " style="margin: 5px"><br>
				
				<br>ȸ����� <input type="radio" name="grade" value="owner" disabled>�ñ��
				<input type="radio" name="grade" value="manager" checked>������ <br>
				
				
				<br> �޴��� ��ȣ <select name="firstPhoneNumber"
					style="width: 100px; height: 35px;">
					<option value="">::����::</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="019">019</option>
					<option value="010">010</option>
				</select> 
				<input type="text" name="middlePhoneNumber" style="width: 50px"
					onkeydown="moveItem(this.value,document.enrollForm.lastPhoneNumber)" > 
				<input type="text" size="100" name="lastPhoneNumber" style="width: 50px"> <br>
				
				
				<br> ������������&nbsp;&nbsp;<input type="text" name="posssibleArea"
					placeholder="ex)������������(����� ���۱�) " style="margin: 5px"><br>
				
				
				<br>������ȯ�� <input type="radio" name="enviroment" value="����Ʈ" >����Ʈ
				<input type="radio" name="enviroment" value="����">���� 
				<input type="radio" name="enviroment" value="����">����
				<br>
				
				<br> �ְߵ������&nbsp;&nbsp;<input type="text" name="carrier"
					placeholder="ex)����Ⱓ(����2��) " style="margin: 5px"><br>
				<br> <input type="image" value="���ԿϷ�"
					src="images/enrollend.jpg"
					style="position: relative; top: 5px; left: 70px;" width="100px"
					height="50px"  onclick ="return validCheck()"> 
			
					</form>

			<form name="mainForm" method="post" action="loginCheck.jsp">
        		<input type="image" value="�α���"src="images/loginsubmit.jpg"
					style="position: relative; bottom: 45px; left: 200px;" width="100px"
					height="50px" >
        	</form>
		

			</div>
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