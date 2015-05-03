<!DOCTYPE html>
<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<shiro:authenticated>
	<jsp:forward page="/main"></jsp:forward>
</shiro:authenticated>
<shiro:notAuthenticated>
	<jsp:forward page="/login"></jsp:forward>
</shiro:notAuthenticated>