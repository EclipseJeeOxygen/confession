<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
<script>
</script>
</head>
<body>
	<div class="container">
		<a class="btn btn-primary btn-lg " href="<%=path%>/user/addUser.do">导入学生信息</a>
	</div>
</body>
</html>