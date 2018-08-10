package com.jomchen.springtest.accessory.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.server.HandshakeHandler;

import java.util.List;

/**
 * create by Jomchen on 2018/6/28
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/my_stomp_socket")
                /*.setHandshakeHandler(new MyHandshakeHandler())*/
                .addInterceptors(new MyHttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic", "/queue");
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setMessageSizeLimit(1024);
        registry.setSendBufferSizeLimit(1024);
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {

    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        return true;
    }


    /*@SuppressWarnings("rawtypes")
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            System.out.println("连接success");
            Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
            if (raw instanceof Map) {
                Object name = ((Map) raw).get("name");
                if (name instanceof LinkedList) {
                    String id = ((LinkedList) name).get(0).toString();
                    //设置当前访问器的认证用户
                    accessor.setUser(new WebsocketUserVO(id));
                    webSocketServ.pushOnlineUser(id);
                }
            }
        } else if (StompCommand.DISCONNECT.equals(accessor.getCommand())) {
            //点击断开连接，这里会执行两次，第二次执行的时候，message.getHeaders.size()=5,第一次是6。直接关闭浏览器，只会执行一次，size是5。
            System.out.println("断开连接");
            WebsocketUserVO vo = (WebsocketUserVO) message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER);

            //  如果同时发生两个连接，只有都断开才能叫做不在线
            if (message.getHeaders().size() == 5&&StringUtils.isBlank(userRegistry.getUser(vo.getName()))) {
                webSocketServ.removeOnlineUser(vo.getName());
            }
        }
        return message;
    }*/
}
