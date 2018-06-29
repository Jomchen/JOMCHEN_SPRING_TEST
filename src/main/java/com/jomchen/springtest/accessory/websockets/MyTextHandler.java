package com.jomchen.springtest.accessory.websockets;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Jomchen on 2018/6/25
 */
public class MyTextHandler extends TextWebSocketHandler {

    Map<String, WebSocketSession> webSocketSessionMap = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String sessionId = session.getId();
        webSocketSessionMap.put(sessionId, session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        String sessionId = session.getId();
        webSocketSessionMap.remove(sessionId);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String data = message.getPayload();
        System.out.println("websocket 处理的信息为：" + data);
        System.out.println("websocket 处理的信息为：" + data);
        System.out.println("websocket 处理的信息为：" + data);
        super.handleTextMessage(session, message);
    }

    public void sendMessageToAll(String message) {
        webSocketSessionMap.values().forEach(s -> {
            try {
                s.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
