<%@page import="java.util.ArrayList"%>
<%@page import="com.iot.test.vo.Customer"%>
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
	function getEl(id) {
		return document.getElementById(id);
	}
	function checkValue() {
		var searchType = getEl("searchType").value.trim();
		var searchStr = getEl("searchStr").value.trim();

		if (searchType.length == 0) {
			alert("검색종류를 선택해주세요.");
			getEl("searchType").focus();
			return false;
		}
		if (searchStr.length == 0) {
			alert("검색은 두글자 이상입니다.")
			getEl("searchStr").focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<%
		/* 		List<Customer> customerList = (List<Customer>) request.getAttribute("userList");
				//String keyword = request.getParameter("param");
				String searchType = request.getParameter("searchType");
				String searchStr = request.getParameter("searchStr"); */

		List<Customer> customerList = (List<Customer>)request.getAttribute("customerList");
		String flag= (String)request.getAttribute("flag");
		if(flag==null||flag.equals("1")){
			flag="2";
		}else if(flag.equals("2")){
			flag="1";
		}	
	%>
	<c:set var="flag" value="<%=flag %>"/>
	고객리스트
	<form onsubmit="return checkValue()">
		<select name="searchType" id="searchType">
			<option value="CustomerID">아이디</option>
			<option value="CustomerName">이름</option>
			<option value="city">도시</option>
			<option value="country">국가</option>
		</select> <input type="text" name="searchStr" value="${searchStr}">
		<button type="submit">검색</button>
	</form>


	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th><a
				href="${root}/view/customer/list.jsp?order=customerid&flag=${flag}">CustomerID</a></th>
			<th><a
				href="${root}/view/customer/list.jsp?order=customername&flag=${flag}">CustomerName</a></th>
			<th><a
				href="${root}/view/customer/list.jsp?order=city&flag=${flag}">City</a></th>
			<th><a
				href="${root}/view/customer/list.jsp?order=country&flag=${flag}">Country</a></th>
			<c:if test="${customerList eq null}">
				<tr>
					<td colspan="4" align="center">고객리스트가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${customerList}" var="cl">
				<tr align="center">
					<td>${cl.customerID }</td>
					<td>${cl.customerName}</td>
					<td>${cl.city}</td>
					<td>${cl.country}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>