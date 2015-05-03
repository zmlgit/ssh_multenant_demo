<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery-1.11.2.min.js"></script>
<body>

	<span> Welcome <shiro:user>
			<shiro:principal></shiro:principal>
		</shiro:user></span>
	<div></div>
	<script type="text/javascript">
		$.post("user", {
			username : "root"
		}, function(data) {

			$("div").text(data);
		}, "text");

		var ws = null;
		function connectSocket() {
			var target = 'ws://localhost:8080/ahx/websocket';
			if (target == '') {
				alert('Please select server side connection implementation.');
				return;
			}

			if (!window.WebSocket) {
				window.WebSocket = window.MozWebSocket;
			}

			if (window.WebSocket) {
				ws = new WebSocket(target);
			}

			ws.onopen = function() {
				//初始发送用户信息
				ws.send("初始接入");
				//ws.send("{'oper':'init','userType':'" + userType +"','userId':'" + myid +"','toUser':'"+toUser+"'}");
				log('Info: WebSocket connection opened.');
			};
			ws.onmessage = function(event) {
				//接收到消息
				// var pointData  = event.data;
				// drawSocketCanvs(pointData);
				document.getElementById("messagebox").value = event.data;

			};
			ws.onclose = function() {

				log('Info: WebSocket connection closed.');
			};
		}

		function disconnect() {
			if (ws != null) {
				ws.close();
				ws = null;
			}

		}

		function sendSocketPointStr(msgStr) {

			if (ws != null) {
				try {
					ws.send(msgStr);
				} catch (ex) {
					alert("已经失去连接，请重新登录");
				}
			} else {
				alert('已经失去连接，请重新登录');
			}
		}

		function sendClostmsg() {
			ws.send("{'oper':'close','userType':'" + userType + "','userId':'"
					+ myid + "','toUser':'" + toUser + "'}");
		}
		function log(msg) {
			console.log(msg);
		}
		connectSocket();
	</script>
</body>
</html>
