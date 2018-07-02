package com.jomchen.springtest.controllers.websocket;

import com.jomchen.springtest.accessory.websockets.MyTextHandler;
import com.jomchen.springtest.commons.enums.ErrorMessageEnum;
import com.jomchen.springtest.commons.web.ApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Jomchen on 2018/6/28
 */

@Controller
public class WebSocketController {

    @Autowired
    MyTextHandler myTextHandler;

    /**
     * 对于普通 webSocket 发送消息用于全部广播
     * @param data
     * @return
     */
    @RequestMapping(value = "/senMessageToAll", method = RequestMethod.POST)
    @ResponseBody
    public ApiData senMessageToAll(String data) {
        myTextHandler.sendMessageToAll(data);
        return new ApiData(ErrorMessageEnum.ERROR_00, "") ;
    }

    @MessageMapping("/greeting")
    public String handle(String greeting) {
        return "[" + System.currentTimeMillis() + ":" + greeting + "]";
    }

}
