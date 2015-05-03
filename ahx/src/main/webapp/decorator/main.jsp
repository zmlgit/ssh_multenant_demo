<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title><sitemesh:write property='title' /></title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<sitemesh:write property='head' />
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery-1.11.2.min.js"></script>
<body>
	经过装饰了
	<sitemesh:write property='body' />
</body>
</html>
