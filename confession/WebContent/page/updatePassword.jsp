<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">
</head>
<body>
	<div class='container'>
		<div>
			<form action="<%=path%>/user/updatePassword.htm" method="post">
				<label>你好，${sessionScope.user.andName}</label> <input
					name="password" type="text" class="form-control"
					placeholder="请输入新密码" required autocomplete="off">
				<button name="submit" class="btn btn-primary btn-lg btn-block">确认修改</button>
			</form>
		</div>
	</div>
	<!-- <script type="text/javascript">
		if (window.top != window.self) {
			window.top.location = "loginForm";
		}
	</script> -->
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
</body>
</html>