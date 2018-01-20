<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴리스트</title>
</head>
<script>

	function test(mNum){
	
		var name = document.getElementById("mNameTd"+mNum).innerHTML;
		var url = document.getElementById("mUrlTd"+mNum).innerHTML;
		var desc = document.getElementById("mDescTd"+mNum).innerHTML;
			
		$('#mNameTd'+mNum).contents().unwrap().wrap('<td><input name="updateName" type="text" size="7" value="'+name+'"/></td>');
		$('#mUrlTd'+mNum).contents().unwrap().wrap('<td><input name="updateUrl" type="text" size="10" value="'+url+'"/></td>');
		$('#mDescTd'+mNum).contents().unwrap().wrap('<td><input name="updateDesc" type="text" size="7" value="'+desc+'"/></td>');
		document.getElementById("tdId"+mNum).innerHTML+="<td><button name='updateId' value='"+mNum+"' type='submit'>수정완료</button></td>";

	}
	
</script>
<body>

	<h2>메뉴리스트</h2>

	<form>
		<select name="searchType" id="searchType">
			<option value="">선택</option>
			<option value="mName">메뉴이름</option>
			<option value="mUrl">메뉴URL</option>
			<option value="mDesc">메뉴설명</option>
		</select> <input type="text" name="searchStr" value="${searchStr}"
			placeholder="검색해주세요">
		<button type="submit">검색</button>
	</form>


	<form action="${root }/view/menu/insert.jsp">
		<table>
			<tr>
				<td><input type="text" placeholder="메뉴이름" name="mName"></td>
				<td><input type="text" placeholder="메뉴URL" name="mUrl"></td>
				<td><input type="text" placeholder="메뉴설명" name="mDesc"></td>
				<td><button>메뉴입력</button>
				<td>
			</tr>
		</table>
	</form>


	<form action="${root}/view/menu/update.jsp">
		<table border="1" style="table-layout: center; text-align: center">
			<tr>
				<th style="text-align: center">메뉴번호</th>
				<th style="text-align: center">메뉴이름</th>
				<th style="text-align: center">메뉴URL</th>
				<th style="text-align: center">메뉴설명</th>
				<th style="text-align: center">메뉴셋팅</th>
			</tr>
			<c:forEach items="${menuList}" var="ml">
				<tr id="trId${ml.mNum}">
					<td id="mId${ml.mNum}">${ml.mNum}</td>
					<td id="mNameTd${ml.mNum}">${ml.mName}</td>
					<td id="mUrlTd${ml.mNum}">${ml.mUrl }</td>
					<td id="mDescTd${ml.mNum}">${ml.mDesc }</td>
					<td id="tdId${ml.mNum}"><button id="btnId${ml.mNum}"
							type="button" onclick="test(${ml.mNum})">수정</button>
						<button type="submit" name="deleteId" value="${ml.mNum}">삭제</button></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>