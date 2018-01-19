<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴리스트</title>
</head>
<script>
	function testAlert(){
		var objs = document.getElementsByTagName("button");
		for(var obj of objs){
			alert(obj.innerHTML);
		}
	}
	function test(mNum){

		var name = document.getElementById("mNameTd"+mNum).innerHTML;
		var url = document.getElementById("mUrlTd"+mNum).innerHTML;
		var desc = document.getElementById("mDescTd"+mNum).innerHTML;
		
		$('#mNameTd'+mNum).contents().unwrap().wrap('<td><input type="text" size="3" value="'+name+'"></input></td>');
		$('#mUrlTd'+mNum).contents().unwrap().wrap('<td><input type="text" size="5" value="'+url+'"></input></td>');
		$('#mDescTd'+mNum).contents().unwrap().wrap('<td><input type="text" size="5" value="'+desc+'"></input></td></form>');
	 	$('#btnId').attr("type","submit"); 
		//$('#btnId').contents().unwrap().wrap('');
		//$('#btnId').onclick=testAlert();
	}
	
</script>
<body>
<c:forEach items="${menuList}" var="ml">
<table border="1">
<form action="${root}/view/menu/list.jsp">
<tr>
<td id="mNameTd${ml.mNum}">${ml.mName}</td><td id="mUrlTd${ml.mNum}">${ml.mUrl }</td><td id="mDescTd${ml.mNum}">${ml.mDesc }</td><td><button id="btnId" type="button" onclick="test(${ml.mNum})">수정</button></td>
</tr>
</form>
</table>
</c:forEach>
</body>
</html>