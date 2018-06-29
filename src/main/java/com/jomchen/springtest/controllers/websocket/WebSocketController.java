package com.jomchen.springtest.controllers.websocket;

import com.jomchen.springtest.accessory.websockets.MyTextHandler;
import com.jomchen.springtest.commons.enums.ErrorMessageEnum;
import com.jomchen.springtest.commons.web.ApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Jomchen on 2018/6/28
 */

@Controller
public class WebSocketController {

    @Autowired
    MyTextHandler myTextHandler;

    @MessageMapping("/greeting")
    public String handle(String greeting) {
        return "[" + System.currentTimeMillis() + ":" + greeting + "]";
    }

    @RequestMapping(value = "/senMessageToAll/{data}")
    @ResponseBody
    public ApiData senMessageToAll(@PathVariable("data") String data) {
        myTextHandler.sendMessageToAll(data);
        return new ApiData(ErrorMessageEnum.ERROR_00, "") ;
    }

}
