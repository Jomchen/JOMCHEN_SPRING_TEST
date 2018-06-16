package com.jomchen.springtest.controllers.basedata;

import com.jomchen.springtest.controllers.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Jomchen on 2018/1/6
 */
@RequestMapping(value = "/customerController")
@Controller
public class CustomerController extends BaseController {


    @RequestMapping("testCustomerController")
    @ResponseBody
    public String testCustomerCOntroller() {
        return "Hellow Linux";
    }

    @RequestMapping("testPage")
    public String testPage() {
        return "test/test";
    }

}
