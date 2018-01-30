<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function checkInsert(){
	alert("??");
	return true;
}

</script>
<body>
<form action="${root }/view/user/list.jsp" method="post" onsubmit="return checkInsert()">
<table border="1">
<tr>
<th colspan="2">회원가입</th>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="uiName" id="uiName"></td>
</tr>
<tr>
	<td>나이</td>
	<td><input type="text" name="uiAge" id="uiAge"></td>
</tr>
<tr>
	<td>아이디</td>
	<td><input type="text" name="uiId" id="uiId"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="text" name="uiPwd" id="uiPwd"></td>
</tr>
<tr>
	<td>반번호</td>
	<td><input type="text" name="ciNo" id="ciNo"></td>
</tr>
<tr>
	<td>주소</td>
	<td><input type="text" name="address" id="address"></td>
</tr>
<tr>
	<td>아이디</td>
	<td><input type="text" name="uiId" id="uiId"></td>
</tr>
<tr>
	<td colspan="2" align="center"><button>회원가입완료</button></td>
</tr>
</table>
</form>
</body>
</html>