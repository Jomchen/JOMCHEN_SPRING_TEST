package com.jomchen.springtest.accessory.websockets;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * create by Jomchen on 2018/6/29
 */
public class MyHttpSessionHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {

        System.out.println("执行了握手之前的方法。。");
        System.out.println("执行了握手之前的方法。。");
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Exception ex) {

        System.out.println("执行了握手之后的方法。。");
        System.out.println("执行了握手之后的方法。。");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
