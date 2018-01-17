<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String root = request.getContextPath();
	String uri = request.getRequestURI();
	 int idx = uri.lastIndexOf(".");
	if(idx!=-1){
		uri = uri.substring(14,idx);
		uri = root+uri+".jsp";
	}	 
%>

<c:set var="root" value="<%=root%>" />
<script src="${root}/ui/js/jquery-3.2.1.js"></script>
<script src="${root}/ui/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${root}/ui/css/bootstrap.min.css">

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<c:forEach items="${menuList}" var="ml">
					<li><a href="${root}${ml.mUrl}.jsp">${ml.mName}</a></li>
				</c:forEach>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>

<script>
$(document).ready(function(){
	$("li a[href='<%=uri%>']").parent().attr("class","active");
})
</script>











