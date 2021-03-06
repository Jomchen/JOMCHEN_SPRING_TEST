package com.jomchen.springtest.controllers.websocket;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.springtest.entity.basedata.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static com.jomchen.springtest.commons.web.UrlContents.*;

/**
 * create by Jomchen on 2018/6/28
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 到 websocket00 页面
     */
    @RequestMapping(value = WEBSOCKET_TEST00, method = RequestMethod.GET)
    public String websocket00() {
        return "websocket/websocket00";
    }

    /**
     * websocket00 页面的 ajax 请求
     */
    @RequestMapping(value = AJAX_WEBSOCKET_TEST00, method = RequestMethod.POST)
    @ResponseBody
    public String ajaxWebsocket00(String name) {
        System.out.println("websocket00 服务接到 ajax 消息为：" + name);
        Customer customer = new Customer(1, 22, name, "京城", new Date());
        return JSONObject.toJSONString(customer);
    }

    /**
     * 到 websocket01 页面
     */
    @RequestMapping(value = WEBSOCKET_TEST01, method = RequestMethod.GET)
    public String websocket01() {
        return "websocket/websocket01";
    }

    /**
     * 到 websocket01 页面的 ajax 请求
     */
    @RequestMapping(value = AJAX_WEBSOCKET_TEST01, method = RequestMethod.POST)
    @ResponseBody
    public String ajaxWebsocket01(String name) {
        System.out.println("websocket01 服务接到 ajax 消息为：" + name);
        Customer customer = new Customer(2, 44, name, "天涯", new Date());
        return JSONObject.toJSONString(customer);
    }



    /**
     * 项目启动后对订阅了 /app/jomchen 的会直接发送一次给它,
     * 并且如果在 类头部有 @MessageMapping 那么会带上相应注解里的路径
     */
    @SubscribeMapping("jomchen")
    public String execute() {
        System.out.println("经过了 subscribeMapping");
        Customer customer = new Customer();
        customer.setCname("i am jomchen");
        return JSONObject.toJSONString(customer);
    }

    /**
     * websocket00 的订阅
     */
    @MessageMapping("/stomp/handle00")
    @SendTo({"/topic/subscript00", "/topic/subscript01"})
    public String handleRequest00(Customer customer) {
        System.out.println("websocekt00 服务端接收到了消息: " + JSONObject.toJSONString(customer));
        return JSONObject.toJSONString(customer);
    }

    /**
     * websocket00 的对自己发送
     */
    @MessageMapping("/stomp/handleRequest00ToItself")
    @SendToUser("/queue/notifications")
    public String handleRequest00ToItself(Customer customer) {
        System.out.println("websocket00ToUser 服务端接收到了消息: " + JSONObject.toJSONString(customer));
        return JSONObject.toJSONString(customer);
    }

    /**
     * websocket00 对指定用户发送信息
     */
    @MessageMapping("/stomp/handleRequest00ToUser")
    public void handleRequest00ToUser(Customer customer) {
        System.out.println("handleRequest00ToUser 服务端接收到消息为：" + JSONObject.toJSONString(customer));
        simpMessagingTemplate.convertAndSendToUser(customer.getCname(), "/queue/notifications", customer.getAddress());
    }

    /**
     * websocket01 的订阅
     */
    @MessageMapping("/stomp/handle01")
    @SendTo({"/topic/subscript00", "/topic/subscript01"})
    public String handleRequest01(Customer customer) {
        System.out.println("websocekt01 服务端接收到了消息: " + JSONObject.toJSONString(customer));
        return JSONObject.toJSONString(customer);
    }

}
