package com.jomchen.springtest.controllers.test;

import com.jomchen.springtest.commons.web.UrlContents;
import com.jomchen.springtest.entity.basedata.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = UrlContents.TEST00_AJAX)
    @ResponseBody
    public Customer test00Ajax(@RequestBody String name) {
        System.out.println(name);
        /*if (null != customer) {
            System.out.println(customer.getCid());
            System.out.println(customer.getCname());
            System.out.println(customer.getAddress());
            System.out.println(customer.getAge());
        }*/
        return new Customer(1, 22, "李寻欢", "京城", null);
    }
}
