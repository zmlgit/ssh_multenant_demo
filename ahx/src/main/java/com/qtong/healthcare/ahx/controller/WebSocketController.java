package com.qtong.healthcare.ahx.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketController implements WebSocketHandler,
		WebSocketConfigurer {

	private static Logger logger = Logger.getLogger(WebSocketController.class);

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		logger.info("connection success");
	}

	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {

		logger.info(message);

		System.out.println(session.getPrincipal());

		WebSocketMessage<String> back = new TextMessage("Server back");
		session.sendMessage(back);

	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		logger.info("connection closed");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

		registry.addHandler(this, "/websocket");

	}

}
