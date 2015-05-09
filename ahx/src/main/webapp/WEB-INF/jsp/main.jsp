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
<style type="text/css">
.messagebox {
	margin: auto;
	hight: 500px;
	width: 400px;
	border: 1
}

</style>
</head>
<body>
	<div class="messagebox">

		<div id="msg_rc"
			style="width: 100%; height: 400px; border: 1;overflow: scroll;">
		
		</div>
		<textarea rows="3" cols="40" style="height: 85px; width: 100%;"
			id="msg" ></textarea>
		<input type="button" value="发送" class="btn" style="float: right;" onclick="sendMsg()">
	</div>
	<script type="text/javascript">
		var ws = null;
		function connectSocket() {
			var target = 'ws://' + window.location.host + '/ahx/websocket';
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
				showMsg(event.data);

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
		
		
		function sendMsg(){
			var now=new Date();
			
			var value=$('#msg').val().toString().replace(/\'/g,'\\\'');
			
			
			
			var msg="{time:'"+timeStr(now)+"',msg:'"+value+"'}";
			ws.send(msg);
			$("#msg_rc").append("<div style='margin-left:auto;margin-right:2px;width:100px;'>"+$('#msg').val()+"</div>");
			$('#msg').val("");
		}
		
		function showMsg(msg){
			$("#msg_rc").append("<p><em>"+msg+":</em></p>");
			$("#msg_rc").append("<p>"+msg+":</p>");
		}
		
		function timeStr(now){
			
			return now.getFullYear()+"-"+(now.getMonth()+1)+"-"+(now.getDate())+" "+(now.getHours())+":"+now.getMinutes()+":"+now.getSeconds();
		}
	</script>
</body>
</html>
