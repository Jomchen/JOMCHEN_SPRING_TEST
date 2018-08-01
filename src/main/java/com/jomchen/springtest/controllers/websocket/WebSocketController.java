package com.jomchen.springtest.controllers.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.jomchen.springtest.commons.web.UrlContents.*;

/**
 * create by Jomchen on 2018/6/28
 */
@Controller
@MessageMapping("/stomp")
public class WebSocketController {

    /* ----- 未处理的问题 ----- */
    // websockt 上传中文时会出错
    // 页面的编码未设成 utf-8

    @RequestMapping(value = WEBSOCKET_TEST00, method = RequestMethod.GET)
    public String websocket00() {
        return "websocket/websocket00";
    }
    @ResponseBody
    @RequestMapping(value = AJAX_WEBSOCKET_TEST00, method = RequestMethod.POST)
    public String ajaxWebsocket00(String name) {
        System.out.println("服务接到消息为：" + name);
        return "Linux";
    }

    @RequestMapping(value = WEBSOCKET_TEST01, method = RequestMethod.GET)
    public String websocket01() {
        return "websocket/websocket01";
    }


    @MessageMapping("handle00")
    @SendTo({"/topic/subscript00", "/topic/subscript01"})
    public String handleRequest00(String name) {
        System.out.println("服务端接收到了消息: " + name);
        return name;
    }

    @MessageMapping("handle01")
    @SendTo("/topic/subscript01")
    public String handleRequest01(String name) {
        System.out.println("服务端接收到了消息: " + name);
        return name;
    }


}
