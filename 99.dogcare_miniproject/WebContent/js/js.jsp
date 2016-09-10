<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" >

    // 1. 숫자만 입력받게 하는 방법
    function onlyNumber() {
        if ((event.keyCode < 48) || (event.keyCode > 57))
            event.returnValue = false;
    }

    function CheckForm() {
        if (document.getElementById("txtMobile1").value == "") {
            window.alert("휴대폰 번호를 선택하시오.");
            return false;
        }
        if (document.getElementById("txtMobile2").value.length != 4) {
            window.alert("가운데 번호는 4자리로 입력하세요");
        }
    }

</script>

휴대폰 번호: 
<select id="txtMobile1">
    <option value="">::선택::</option>
    <option value="011">011</option>
    <option value="016">016</option>
    <option value="017">017</option>
    <option value="019">019</option>
    <option value="010">010</option>
</select>
<input type="text" id="txtMobile2" size="4" onkeypress="onlyNumber();" />
<input type="text" id="txtMobile3" size="4" />

<input type="button" value="가입" onclick="CheckForm();" />
</head>
<body>

</body>
</html>

<script  type="text/javascript">
	// 1. 숫자만 입력받게 하는 방법
	function onlyNumber() {
		if ((event.keyCode < 48) || (event.keyCode > 57))
			event.returnValue = false;
	}
	function moveItem(a, b) {
		if (a.length == 4) {
			b.focus();
		}
	}

	function CheckForm() {
		if (document.getElementById("txtMobile1").value == "") {
			window.alert("휴대폰 번호를 선택하시오.");
			return false;
		}
		if (document.getElementById("txtMobile2").value.length != 4) {
			window.alert("가운데 번호는 4자리로 입력하세요");
		}
	}
</script>


