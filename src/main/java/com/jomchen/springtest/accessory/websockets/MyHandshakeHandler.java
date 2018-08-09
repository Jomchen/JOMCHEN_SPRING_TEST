package com.jomchen.springtest.accessory.websockets;

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
    @Override
    public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws HandshakeFailureException {
        attributes.forEach((k, v) -> {
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
            System.out.println(k + "----------------" +v);
        });
        return true;
    }
}
