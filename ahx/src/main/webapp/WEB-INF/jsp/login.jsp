<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>login</title>


</head>

<body>

	<div class="error">
		<c:if test="${not empty param.kickout}">您被踢出登录。</c:if>
		${error}
	</div>
	<form action="login" method="post">
		用户名：<input type="text" name="username" value="<shiro:principal/>"><br />
		密码：<input type="password" name="password"><br /> 自动登录：<input
			type="checkbox" name="rememberMe" value="true"><br /> <input
			type="submit" value="登录">
	</form>


</body>
</html>
