package com.jomchen.springtest.controllers.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * create by Jomchen on 2018/6/28
 */

@Controller
@MessageMapping("/stomp")
public class WebSocketController {


    @MessageMapping("handle00")
    @SendTo("/topic/subscript00")
    public String handleRequest(String data) {
        System.out.println("服务端接收到了消息: " + data);
        return data;
    }


}
