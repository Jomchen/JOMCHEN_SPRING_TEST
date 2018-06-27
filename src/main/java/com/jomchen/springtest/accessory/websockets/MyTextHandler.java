package com.jomchen.springtest.accessory.websockets;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * create by Jomchen on 2018/6/25
 */
public class MyTextHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String data = message.getPayload();
        System.out.println("websocket 处理的信息为：" + data);
        System.out.println("websocket 处理的信息为：" + data);
        System.out.println("websocket 处理的信息为：" + data);
        super.handleTextMessage(session, message);
    }

}
