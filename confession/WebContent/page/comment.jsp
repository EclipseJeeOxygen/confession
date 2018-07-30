<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">
</head>
<body>
	<div class='container'>
		<div class=jum>
			<img src="<%=path%>/img/biaobai.jpg"
				style="max-width: 100%; max-height: 100%; margin-bottom: 10px;">
		</div>
		<c:forEach var="list" items="${requestScope.list }">
			<div style="height: 100%; width: 100%;">
				<!-- border:3px solid transparent; -->
				<div>
					<label>评论人:</label>
					<c:out value="${list.commentName }"></c:out>
				</div>
				<div>
					<label>评论时间:</label>
					<c:out value="${list.commentTime }"></c:out>
				</div>
				<div>
					<label>评论内容:</label>
					<c:out value="${list.comment }"></c:out>
				</div>
			</div>
			<br>
		</c:forEach>
	</div>
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
</body>
</html>