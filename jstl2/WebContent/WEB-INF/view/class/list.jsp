<%@page import="com.iot.test.vo.ClassInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action= "/jstl2/view/class/list.jsp">
<input type="text" name="inputText" placeholder="강의명검색"/><button type="submit">검색</button>
</form>
<table border="1">
<c:forEach items="${classList }" var="cl">
<tr>
<td>${cl.ciNo }</td><td>${cl.ciName }</td><td>${cl.ciDesc }</td>
</tr>

</c:forEach>
</table>
</body>
</html>