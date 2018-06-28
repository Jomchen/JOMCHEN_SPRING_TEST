package com.jomchen.springtest.accessory.websockets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * create by Jomchen on 2018/6/25
 */
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer{

    /**
     * 窗口工厂的配置
     * @return
     */
    @Bean
    public ServletServerContainerFactoryBean servletServerContainerFactoryBean() {
        ServletServerContainerFactoryBean servletServerContainerFactoryBean = new ServletServerContainerFactoryBean();
        servletServerContainerFactoryBean.setMaxTextMessageBufferSize(8192);
        servletServerContainerFactoryBean.setMaxBinaryMessageBufferSize(8192);
        return servletServerContainerFactoryBean;
    }

    /**
     * 地址映射处理
     * @param webSocketHandlerRegistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(getMyTextHandler(), "/getMyTextHandler")
                .setAllowedOrigins("*")
                .addInterceptors(httpSessionHandshakeInterceptor());
    }

    /**
     * 处理器提供
     * @return
     */
    @Bean
    public MyTextHandler getMyTextHandler() {
        return new MyTextHandler();
    }

    /**
     * 握手拦截
     * @return
     */
    @Bean
    public HttpSessionHandshakeInterceptor httpSessionHandshakeInterceptor() {
        return new HttpSessionHandshakeInterceptor() {
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
        };
    }


}
