<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ���� Ȩ������</title>

<script type="text/javascript">
	function textlimit() {
		var textlimit = document.enrollForm.content.value;
		if (textlimit.length > 90) {
			//�Էµ����� ����ó��
			alert("90���ڸ� �ѱ�ϴ�.");
			return false;
		}
		var checkText = document.getElementById("check");
		checkText.style = "color:blue;"
		checkText.innerHTML = textlimit.length;

	}
</script>
</head>
<body>

	<div id="container">
		<div id="header">
			<div id="mainlogo">
				<form name="mainForm" method="post" action="loginEndManager.jsp">
					<input type="image" src="images/mainlogo.jpg"
						style="position: relative; width: 250px; height: 110px;">
				</form>
			</div>



			<div id="align-right" style="position: relative;">
				<%=session.getAttribute("grade")%>
				<%=session.getAttribute("name")%>
				<span>�� �ݰ�����!:) </span>
				<p>
					<a href="Controller?action=logout" class="topside">�α��ξƿ�</a> <a
						href="Controller?action=findMemberBylogin" class="topside">��������
						Ȯ��&���� 
			</div>


			<div class="menu">
				<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> <a
					href="how.jsp" class="topmenu">How to use</a> <a
					href="careBefore.jsp" class="topmenu">Care</a> <a
					href="service.jsp" class="topmenu">Services</a>
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
				action="Controller?action=insertBoard">
				<div style="position: relative; top: 100px; margin-left: 400px;">

					<div id="enrollInsert">
						<div style="margin-left: 200px">
							<a href="loginEndManager.jsp" class="topside"
								style="position: relative; bottom: 50px; left: 190px;">HOME</a>
							<span class="enroll" style="position: absolute; left: 140px;">�����������Է�</span><br>
							<br> <br> <br>

						</div>
						�� ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title"
							placeholder="ex)07�� 25��~26�� �����帳�ϴ�." style="margin: 5px"><br>



						<br>���񽺰���<input type="text" name="price"
							style="width: 300px;"
							placeholder="ex)������10000�� ������20000����(24�ð� ����)"
							style="margin: 5px"><br> <br>������ ��&nbsp;&nbsp;<input
							type="text" name="possibleDogKind"
							placeholder="ex)������(������,������ ����)" style="margin: 5px"><br>

						<br>�ڱ�Ұ���[<span id="check">0</span>/90]<br> <br>
						<textarea name="content" cols="50" rows="5"
							onkeydown="textlimit()"
							style="background-color: transparent; border: 5 solid blue;"></textarea>
						<br> <br> <input type="image" value="���ԿϷ�"
							src="images/enroll.jpg"
							style="position: relative; top: 5px; left: 70px;" width="100px"
							height="50px" onclick="return validCheck()">
			</form>


			<form name="mainForm" method="post" action="careManager.jsp">
				<input type="image" value="���" src="images/cancle.jpg"
					style="position: relative; bottom: 45px; left: 200px;"
					width="100px" height="50px">
			</form>

</div>
		</div>
	</div>


	<div id="footer">
		<div id="align-right" style="position: relative; left: 40px">
			<a href="siteMap.jsp" class="bottommenu">����Ʈ��</a> <a
				href="phoneNumber" class="bottommenu">�ֿ���ȭ��ȣ</a> <a href=""
				class="bottommenu">��������ó����ħ</a> <a href="" class="bottommenu">�̸����ּҹ��ܼ����ź�</a>
			<br>
		</div>
	</div>
	<div id="bottomaddress" style="position: relative; top: 20px;">
		����� ����� ������ ����Ư���� ����� ȭ���� 815</br> 815, Hwarang-ro, Nowon-gu, Seoul, Korea
	</div>




</body>
</html>