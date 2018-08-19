package com.jomchen.springtest.controllers.test;

import com.jomchen.springtest.commons.web.UrlContents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Jomchen on 8/19/18
 */
@Controller
public class TestController {

    @RequestMapping(UrlContents.CUSTOMER_TEST_CUSTOMER)
    @ResponseBody
    public String testCustomer() {
        return "Hellow Linux";
    }

    @RequestMapping(UrlContents.CUSTOMER_TEST_PAGE)
    public String testPage() {
        return "test/test";
    }

    @RequestMapping(UrlContents.CUSTOMER_TEST00_PAGE)
    public String test00Page() { return "test/test00"; }
}
