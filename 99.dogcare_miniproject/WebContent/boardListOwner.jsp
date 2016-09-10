<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
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
				<form name="mainForm" method="post" action="loginEnd.jsp">
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
						href="Controller?action=findMemberBylogin" class="topside">��������
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
			<div style="margin-left:550px; margin-top:50px;  ">�󼼺��⸦ ���ϴ°��� Ŭ�����ּ���.</div>
			<table style="margin-left:400px;  top:100px;text-align: center; "border="1" bordercolor="#E8C223">
				<tr align="center">
					<td>�Խñ۹�ȣ</td>
					<td>����</td>
					<td>������ �ڰݹ�ȣ</td>
					<td>�������ɾְ�</td>
					<td>����ϱ�</td>

				</tr>
				<% ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
       				Board dto = null;
            		for (int i = 0; i < list.size(); i++) {
               			dto = list.get(i);
         		%>


				<tr>
					<td>
					<a href="Controller?action=findBoardBylogin&boardNumber=<%=dto.getBoardNumber()%>"><%=dto.getBoardNumber()%></a></td>
					<td><%=dto.getTitle()%></td>
					<td>
					<a href="Controller?action=findManagerByPet&cNumber=<%=dto.getcNumber()%>"><%=dto.getcNumber()%></a></td>
					</td>
					<td><%=dto.getPossibleDogKind()%></td>
					<td>
					<a href="enrollPet.jsp?cNumber=<%=dto.getcNumber()%>">���</a></td>					

				</tr>
				<%
            }
         %>
			</table>


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