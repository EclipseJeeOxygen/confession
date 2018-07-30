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
<title>Speech</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">
	<style type="text/css">
		body{
		margin-top:2px;
		}
		.form-control{
			height:28px;
		}
	</style>
</head>
<body>
	<div class="container" style="width: 100% ;height:100%;">
		<table id="table_server"style="width: 100% ;height:100%;"></table>
	</div>
	<input id="base" type="hidden" value="<%=request.getContextPath()%>">
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
	<script type="text/javascript" src="<%=path%>/js/speech.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap-table-zh-CN.js"></script>
</body>
</html>