<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML">
<html>
<head>

<title>login</title>


</head>

<body>
	<form action="login" method="post" role="form">
		<div class="form-group">
			<label for="username">UserName:</label> <input name="username"
				type="text">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input name="password"
				type="text">
		</div>
		<input type="submit" class="btn" value="提交">
	</form>

</body>
</html>
