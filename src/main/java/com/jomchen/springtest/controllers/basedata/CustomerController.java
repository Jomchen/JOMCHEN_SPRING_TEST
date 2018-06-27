package com.jomchen.springtest.controllers.basedata;

import com.jomchen.springtest.commons.web.UrlContents;
import com.jomchen.springtest.controllers.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Jomchen on 2018/1/6
 */
@Controller
public class CustomerController extends BaseController {


    @RequestMapping(UrlContents.CUSTOMER_TEST_CUSTOMER)
    @ResponseBody
    public String testCustomer() {
        return "Hellow Linux";
    }

    @RequestMapping(UrlContents.CUSTOMER_TEST_PAGE)
    public String testPage() {
        return "test/test";
    }

}
