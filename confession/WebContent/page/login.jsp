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
<title>Login</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">
</head>
<body style="background-color: #E2E2E2;">
	<div class="container">
		<div class="row text-center" style="padding-top: 100px;">
			<div class="col-md-12">
				<h2>登录</h2>
			</div>
		</div>
		<div class="row">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel">
					<div class="panel-body">
						<hr>
						<div style="color: red">
							<h5>${requestScope.message}</h5>
						</div>
						<br>
						<form action="<%=path%>/login/checkLogin.do" method="post">
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input type="text"
									name="userName" class="form-control" placeholder="用  户  名"
									required autocomplete="off" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input type="password"
									name="password" class="form-control" placeholder="密       码"
									required autocomplete="off" />
							</div>
							<div class="form-group input-group">
								<input type="submit" value="登录" class="btn btn-primary">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%=path%>/message/checkMain.htm" class="btn btn-primary">返回</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		if (window.top != window.self) {
			window.top.location = "loginForm";
		}
	</script>

	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
</body>
</html>