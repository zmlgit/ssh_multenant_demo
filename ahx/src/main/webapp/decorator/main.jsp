<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery-1.11.2.min.js"></script>
<body>
	经过装饰了
	<sitemesh:write property='body' />
</body>
</html>
