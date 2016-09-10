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
<title>강아지 돌봄 홈페이지</title>
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
				<span>님 반가워요!:) </span>
				<p>
					<a href="Controller?action=logout" class="topside">로그인아웃</a> <a
						href="Controller?action=findMemberBylogin" class="topside">개인정보
						확인&수정</a>
			</div>



			<div class="menu">
				<a href="" class="topmenu">&nbsp;&nbsp;Introduce</a> <a
					href="how.jsp" class="topmenu">How to use</a> <a
					href="careOwner.jsp" class="topmenu">Care</a> <a
					href="service.jsp" class="topmenu">Services</a>
			</div>

		</div>
		<div id="content">
			<div style="margin-left:550px; margin-top:50px;  ">상세보기를 원하는곳을 클릭해주세요.</div>
			<table style="margin-left:400px;  top:100px;text-align: center; "border="1" bordercolor="#E8C223">
				<tr align="center">
					<td>게시글번호</td>
					<td>제목</td>
					<td>돌보미 자격번호</td>
					<td>돌봄가능애견</td>
					<td>등록하기</td>

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
					<a href="enrollPet.jsp?cNumber=<%=dto.getcNumber()%>">등록</a></td>					

				</tr>
				<%
            }
         %>
			</table>


		</div>

		<div id="footer">
			<div id="align-right" style="position: relative; left: 40px">
				<a href="siteMap.jsp" class="bottommenu">사이트맵</a> <a
					href="phoneNumber" class="bottommenu">주요전화번호</a> <a href=""
					class="bottommenu">개인정보처리방침</a> <a href="" class="bottommenu">이메일주소무단수집거부</a>
				<br>
			</div>
		</div>
		<div id="bottomaddress" style="position: relative; top: 20px;">
			서울시 노원구 공릉동 서울특별시 노원구 화랑로 815<br> 815, Hwarang-ro, Nowon-gu,
			Seoul, Korea

		</div>
	</div>

</body>
</html>