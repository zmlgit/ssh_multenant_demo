<!DOCTYPE html>
<%@page pageEncoding="utf-8" %>
<head>
    <meta charset="UTF-8">
    <title>和健康·爱护心</title>
</head>
<body>
    <span><b>和健康·爱护心</b></span>
	<p>服务所在地址:</p><p>
	<%=request.getLocalAddr()+":"+request.getLocalPort() %>
	</p>
	<p>SessionId：</p>
	    <p>
	<%=session.getId() %>
	</p>
	
	<% System.out.println("--------------------------------"); %>
</body>
</html>