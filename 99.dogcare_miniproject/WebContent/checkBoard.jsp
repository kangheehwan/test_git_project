<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
	<%@ page import="work.model.dto.Board"%>
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
					<input type="image" src="images/mainlogo.jpg"
						style="position: relative; width: 250px; height: 110px;">
				</form>
			</div>

			<div id="align-right" style="position: relative;">
				<%= session.getAttribute("grade")%>
				<%= session.getAttribute("name") %>
				<span>�� �ݰ�����!:) </span>
				<p>
					<a href="Controller?action=logout" class="topside">�α��ξƿ�</a> <a
						href="Controller?action=findManagrBylogin" class="topside">��������
						Ȯ��&����</a>
			</div>



			<div class="menu">
				<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> <a
					href="how.jsp" class="topmenu">How to use</a> <a
					href="careOwner.jsp" class="topmenu">Care</a> <a
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
		<% Board board=(Board)request.getAttribute("board"); %>


			<form name="FixForm" method="post"action="Controller?action=">
				<div style="position: relative; top: 100px; margin-left: 400px;">
					<div id="enrollInsert">
						<div style="margin-left: 200px">
							<a href="loginEndManager.jsp" class="topside"
								style="position: relative; bottom: 50px; left: 190px;">HOME</a>
							<span class="enroll" style="position: absolute; left: 180px;">�Խñۺ���</span><br>
							<br> <br> <br></div>
					
						�� ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title"
							value="<%= board.getTitle()%>" style="margin: 5px"readonly><br>

						<br>���񽺰���<input type="text" name="price"
							style="width: 300px;"
							value="<%= board.getPrice()%>"
							style="margin: 5px"readonly><br>
						
						<br>������ ��&nbsp;&nbsp;<input
							type="text" name="possibleDogKind"
							value="<%= board.getPossibleDogKind()%>"
							style="margin: 5px"readonly><br>
						
						
						<br>�ڱ�Ұ���<br>
						<br>
						<textarea name="content" cols="50" rows="5"
							onkeydown="textlimit()"
							style="background-color: transparent; border: 5 solid blue;"readonly><%=board.getContent() %></textarea>
						
						
				
			</form>


			
				<input type="image" value="���" src="images/cancle.jpg" 
					style="position: relative; top: 30px; left: 130px;"
					width="100px" height="50px" onclick="history.back();">
			


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
		����� ����� ������ ����Ư���� ����� ȭ���� 815<br> 815, Hwarang-ro, Nowon-gu,
		Seoul, Korea

	</div>
	</div>

</body>
</html>