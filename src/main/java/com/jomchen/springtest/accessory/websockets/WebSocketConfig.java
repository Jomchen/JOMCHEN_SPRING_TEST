package com.jomchen.springtest.accessory.websockets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * create by Jomchen on 2018/6/25
 */
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer{

    @Bean
    public ServletServerContainerFactoryBean servletServerContainerFactoryBean() {
        ServletServerContainerFactoryBean servletServerContainerFactoryBean = new ServletServerContainerFactoryBean();
        servletServerContainerFactoryBean.setMaxTextMessageBufferSize(8192);
        servletServerContainerFactoryBean.setMaxBinaryMessageBufferSize(8192);
        return servletServerContainerFactoryBean;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        HttpSessionHandshakeInterceptor httpSessionHandshakeInterceptor = new HttpSessionHandshakeInterceptor();
        webSocketHandlerRegistry.addHandler(getMyTextHandler(), "/getMyTextHandler")
                .setAllowedOrigins("*")
                .addInterceptors(httpSessionHandshakeInterceptor);
    }

    @Bean
    public MyTextHandler getMyTextHandler() {
        return new MyTextHandler();
    }

}
