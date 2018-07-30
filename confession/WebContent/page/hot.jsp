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
<title>Hot</title>
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
				<div>
					<label>发表人:</label>
					<c:out value="${list.name }"></c:out>
				</div>
				<div>
					<label>发表时间:</label>
					<c:out value="${list.time }"></c:out>
					<label>热度:</label>
					<c:out value="${list.commentNum }"></c:out>
				</div>
				<div>
					<label>表白语:</label>
					<c:out value="${list.leaveMessage }"></c:out>
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