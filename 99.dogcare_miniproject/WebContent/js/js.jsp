<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" >

    // 1. ���ڸ� �Է¹ް� �ϴ� ���
    function onlyNumber() {
        if ((event.keyCode < 48) || (event.keyCode > 57))
            event.returnValue = false;
    }

    function CheckForm() {
        if (document.getElementById("txtMobile1").value == "") {
            window.alert("�޴��� ��ȣ�� �����Ͻÿ�.");
            return false;
        }
        if (document.getElementById("txtMobile2").value.length != 4) {
            window.alert("��� ��ȣ�� 4�ڸ��� �Է��ϼ���");
        }
    }

</script>

�޴��� ��ȣ: 
<select id="txtMobile1">
    <option value="">::����::</option>
    <option value="011">011</option>
    <option value="016">016</option>
    <option value="017">017</option>
    <option value="019">019</option>
    <option value="010">010</option>
</select>
<input type="text" id="txtMobile2" size="4" onkeypress="onlyNumber();" />
<input type="text" id="txtMobile3" size="4" />

<input type="button" value="����" onclick="CheckForm();" />
</head>
<body>

</body>
</html>

<script  type="text/javascript">
	// 1. ���ڸ� �Է¹ް� �ϴ� ���
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
			window.alert("�޴��� ��ȣ�� �����Ͻÿ�.");
			return false;
		}
		if (document.getElementById("txtMobile2").value.length != 4) {
			window.alert("��� ��ȣ�� 4�ڸ��� �Է��ϼ���");
		}
	}
</script>


