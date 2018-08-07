package com.jomchen.springtest.controllers.websocket;

import com.alibaba.fastjson.JSONObject;
import com.jomchen.springtest.entity.basedata.Customer;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    /* ----- 未处理的问题 -----

    1. websocket 上传如果有中文的情况会报错
    2. 页面的编码未设成 utf-8 编码

    ----------------------- */

    /**
     * 到 websocket00 页面
     * @return
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
     * websocket00 的订阅
     */
    @MessageMapping("/stomp/handle00")
    @SendTo({"/topic/subscript00", "/topic/subscript01"})
    public String handleRequest00(Customer customer) {
        System.out.println("websocekt00 服务端接收到了消息: " + JSONObject.toJSONString(customer));
        customer.setCname("有梦的人00");
        return JSONObject.toJSONString(customer);
    }

    /**
     * websocket01 的订阅
     */
    @MessageMapping("/stomp/handle01")
    @SendTo({"/topic/subscript00", "/topic/subscript01"})
    public String handleRequest01(Customer customer) {
        System.out.println("websocekt01 服务端接收到了消息: " + JSONObject.toJSONString(customer));
        customer.setCname("有梦的人01");
        return JSONObject.toJSONString(customer);
    }


}
