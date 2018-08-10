package com.jomchen.springtest.accessory.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeFailureException;
import org.springframework.web.socket.server.HandshakeHandler;

import java.util.Map;

/**
 * create by Jomchen on 2018/8/9
 */
public class MyHandshakeHandler implements HandshakeHandler {

    private Logger logger = LoggerFactory.getLogger(MyHandshakeHandler.class);

    @Override
    public boolean doHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws HandshakeFailureException {

        logger.warn("websocket 执行了握手处理器。。");


        return true;
    }

}
