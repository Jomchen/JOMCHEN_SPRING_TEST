package com.jomchen.springtest.accessory.websockets;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * create by Jomchen on 8/18/18
 */
public class MyChannelInterceptor implements ChannelInterceptor {

    private Logger logger = LoggerFactory.getLogger(MyChannelInterceptor.class);

    /**
     * 用作实验的用户集
     */
    public static final Map<String, WebSocketUser> ALL_USER = new HashMap<>();

    static {
        for (int i = 0; i < 5; i ++) {
            String name = "websocket0" + i;
            WebSocketUser user = new WebSocketUser(name, name);
            ALL_USER.put(name, user);
        }
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {

        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            logger.warn("websocket 信息通道连接。。。。");

            logger.warn("以下是帧 websocket 传过来的头信息。。。");
            message.getHeaders().entrySet().forEach(e -> {
                System.out.println(e.getKey() + "----------->" + e.getValue());
            });

            logger.warn("以下是手动传递的 头信息。。。");
            List<String> nameList = accessor.getNativeHeader("name");
            List<String> passwordList = accessor.getNativeHeader("password");
            Optional.ofNullable(nameList).ifPresent(e -> e.forEach(v -> System.out.println("========>name:" + v)));
            Optional.ofNullable(passwordList).ifPresent(e -> e.forEach(v -> System.out.println("========>password" + v)));

            WebSocketUser user = new WebSocketUser(nameList.get(0), passwordList.get(0));
            accessor.setUser(user);

            Object userTemp = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER);
            logger.warn("这个信息是：" + JSONObject.toJSONString(userTemp));



            /*Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
            if (raw instanceof Map) {
                Object name = ((Map) raw).get("name");
                if (name instanceof LinkedList) {
                    String id = ((LinkedList) name).get(0).toString();
                    //设置当前访问器的认证用户
                    accessor.setUser(new WebSocketUser(id, id));
                    webSocketServ.pushOnlineUser(id);

                    System.out.println(name.toString() + "=======================");
                }
            }*/
        } else if (StompCommand.DISCONNECT.equals(accessor.getCommand())) {
            //点击断开连接，这里会执行两次，第二次执行的时候，message.getHeaders.size()=5,第一次是6。直接关闭浏览器，只会执行一次，size是5。
            logger.warn("websocket 信息通道连接断开了。。。");
            WebSocketUser vo = (WebSocketUser) message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER);

            logger.warn("这个掉线信息是：" + JSONObject.toJSONString(vo));
            //  如果同时发生两个连接，只有都断开才能叫做不在线
            /*if (message.getHeaders().size() == 5 && StringUtils.isBlank(userRegistry.getUser(vo.getName()))) {
                webSocketServ.removeOnlineUser(vo.getName());
            }*/
        }
        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {

    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        return false;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return null;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {

    }

}
