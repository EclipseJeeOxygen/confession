<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	/* application.setAttribute("path", path); */
%>
<%-- <%
	String path = request.getServletContext().getContextPath();
	application.setAttribute("path", path);
%> --%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>main</title>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"
	type="text/css">


</head>
<body>
	<!-- style="background-color:#FFBBFF;" -->
	<div class='container'>
		<div class=jum>
			<img src="<%=path%>/img/biaobai.jpg"
				style="max-width: 100%; max-height: 100%">
		</div>
		<div class="panel">
			<div class="panel-body">
				<div class='row'>
					<div class="col-md-4 col-sm-4">
						<div class="list-group">
							<div class="list-group-item"
								style="height: auto; width: auto; background-color: #F0F0F0;">
								<h4>
									<font face="LiSu" size="4" color="#FF34B3"
										style="font-weight: bold; height: 100%; width: 100%;">欢迎来到表白墙,大胆地向TA告白吧!</font>
								</h4>
							</div>
							<form id="form" method="post" action="<%=path%>/message/main.do"
								onsubmit="return  checked(this)">
								<div class="list-group-item" style="height: 100%;">
									<!-- 50px -->
									<label>欢迎，${sessionScope.user.andName}</label> <a
										href="<%=path%>/login/go.do">个人中心</a> <a
										href="<%=path%>/login/exit.do">退出</a>
								</div>
								<div class="list-group-item" style="height: 100%;">
									<!-- 135px -->
									<textarea name="leaveMessage" class="form-control" rows="4"
										placeholder="听说,在这里表白都会成功哦!(限155个汉字)" maxlength="155" required
										autocomplete="off"></textarea>
									<button name="submit" class="btn btn-primary btn-xs btn-block">填好了,起飞吧!</button>
								</div>
							</form>
							<a href="<%=path%>/page/login.jsp"
								class="btn btn-block btn-primary">登录</a> <a
								href="<%=path%>/message/checkHot.htm"
								class="btn btn-block btn-primary" target="view_window">热门</a>
						</div>
					</div>
					<c:forEach begin="${beginIndex}" end="${endIndex}" var="list"
						items="${requestScope.list}">
						<div class="col-md-4 col-sm-4">
							<div class="list-group-item"
								style="height: 100%; background-color: #F0F0F0">
								<!-- 40px -->
								<label style="width: 90px;">
									<!-- 90px --> <c:out value="${list.time}"></c:out>
								</label> <label style="margin-left: 50px;"> <font size="4"
									color="#66B3F" face="华文行楷 ">来自: </font> <c:out
										value="${list.name}"></c:out>
								</label>
								<form action="<%=path%>/comment/selectComment.htm">
									<input type="hidden" name="messageId" value="${list.id}">
									<button name="submit" class="btn btn-primary btn-xs">查看评论</button>
								</form>

							</div>
							<div class="list-group-item"
								style="witdh: 220px; /* 220px */ height: 215px;">
								<font size="3" color="#6495ed" face="lisu "> <c:out
										value="${list.leaveMessage}"></c:out>
								</font>
							</div>
							<form action="<%=path%>/comment/addConmment.do" method="post">
								<div class="list-group-item" style="margin-bottom: 20px;">
									<input name="comment" type="text" class="form-control"
										placeholder="我也说一句" required autocomplete="off"> <input
										type="hidden" name="messageId" value="${list.id}">
									<button name="submit" class="btn btn-primary btn-xs btn-block">评论</button>
								</div>
							</form>
						</div>
					</c:forEach>
				</div>
				<div class="text-center">
					<ul class="pagination">
						<li><a href="<c:url value="/message/checkMain.htm?page=1"/>">首页</a>
						</li>
						<li><a
							href="<c:url value="/message/checkMain.htm?page=${page-1>1?page-1:1}"/>">&laquo;</a>
						</li>
						<c:forEach begin="1" end="${totalPages}" varStatus="loop">
							<c:set var="active" value="${loop.index==page?'active':''}" />
							<li class="${active}"><a
								href="<c:url value="/message/checkMain.htm?page=${loop.index}"/>">${loop.index}</a>
							</li>
						</c:forEach>
						<li><a
							href="<c:url value="/message/checkMain.htm?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
						</li>
						<li><a
							href="<c:url value="/message/checkMain.htm?page=${totalPages}"/>">尾页</a>
						</li>
					</ul>
				</div>
				<div class="panel-footer"
					style="background-color: #ffcdd1; text-align: center; vertical-align: middle;">
					<h4>
						<font face="LiSu" size="4" style="font-weight: bold;">南京机电职业技术学院|信息工程系|软件工作室</font>
					</h4>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=path%>/js/holder.js"></script>
</body>
</html>