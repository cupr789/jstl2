<%@page import="com.iot.test.vo.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script>
function getEl(id){
	return document.getElementById(id);
}
function checkValue(){
	var searchType = getEl("searchType").value.trim();
	var searchStr = getEl("searchStr").value.trim();
	
	if(searchType.length==0){
		alert("검색종류를 선택해주세요.");
		getEl("searchType").focus();
		return false;
	}
	if(searchStr.length==0){
		alert("검색은 두글자 이상입니다.")
		getEl("searchStr").focus();
		return false;
	}
	return true;
}
</script>



<body>
	<%
		List<UserInfo> userList = (List<UserInfo>) request.getAttribute("userList");
		String keyword = request.getParameter("param");
		String searchType = request.getParameter("searchType");
		String searchStr = request.getParameter("searchStr");
	%>
	유저리스트
	<br>
	<c:set var="inputText" value="<%=keyword%>" />
	<form action="/jstl2/view/user/list.jsp">
		<input type="text" name="param" placeholder="유저명검색" value="${inputText}" />
		<button type="submit">검색</button>
	</form>
	
	<form onsubmit="return checkValue()">
		<select	name="searchType" id="searchType">
			<option value="">선택</option>
			<option value="uiName">이름</option>
			<option value="uiAge">나이</option>
			<option value="address">주소</option>
		</select>
		<input type="text" name="searchStr" value="${searchStr}">
		<button type="submit">검색</button>
	</form>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
			<th>아이디</th>
		</tr>
		<c:forEach items="${userList }" var="ui">
			<tr>
				<td>${ui.uiName }</td>
				<td>${ui.uiAge }</td>
				<td>${ui.address }</td>
				<td>${ui.uiId }</td>
			</tr>
		</c:forEach>
	</table>

</body>
<script>
$(document).ready(function(){
	$("option[value='<%=searchType%>']").attr("selected","selected");
})
</script>
</html>