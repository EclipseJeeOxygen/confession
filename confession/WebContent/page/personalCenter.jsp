<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">
</head>
<body>
	<div class='container'>
		<div class="jumbotron">
			<h3 style="margin-left: 40%;">个人中心</h3>
		</div>
		<div>
			<div class="row"
				style="margin: 0px; padding-top: 0px; margin-top: 0px;">
				<div class="col-md-2"
					style="background-color: #EAEAEA; height: 550px;">
					<ul class="nav" style="list-style: none;">
						<li role="presentation"><a
							href="<%=path%>/page/updateName.jsp" target="myFrame">修改昵称</a></li>
						<li role="presentation"><a
							href="<%=path%>/page/updatePassword.jsp" target="myFrame">修改密码</a></li>
					</ul>
				</div>
				<div class="col-md-10">
					<iframe style="width: 934px; height: 550px;" name="myFrame"></iframe>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
</body>
</html>