<!DOCTYPE html>
<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<head>
    <meta charset="UTF-8">
    <title>和健康·爱护心</title>
</head>
<body>
<shiro:hasRole name="root"> this is a root user</shiro:hasRole>
 this isn't a root user
</body>
</html>