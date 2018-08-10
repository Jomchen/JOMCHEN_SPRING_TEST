package com.jomchen.springtest.accessory.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * create by Jomchen on 2018/6/29
 */
public class MyHttpSessionHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    private Logger logger = LoggerFactory.getLogger(MyHttpSessionHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {

        logger.warn("websocekt 执行了握手之前的方法。。");
        logger.warn("websocket 执行了握手之前的方法。。");
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(
            ServerHttpRequest request,
            ServerHttpResponse response,
            WebSocketHandler wsHandler,
            Exception ex) {

        logger.warn("websocket 执行了握手之后的方法。。");
        logger.warn("websocket 执行了握手之后的方法。。");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
