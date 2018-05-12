package com.jomchen.springtest.test;


import com.jomchen.springtest.entity.basedata.Customer;
import com.jomchen.springtest.interfaces.basedata.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * create by Jomchen on 2018/1/5
 */
public class AllTest {

    public static Logger logger = LoggerFactory.getLogger(AllTest.class);

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setAge(2);
        customer.setAddress("北京");
        customer.setBirthday(new Date());
        customer.setCname("李刚");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        CustomerService customerService = (CustomerService)applicationContext.getBean("customerService");
        logger.error("这个是一个信息:{}", customer.toString());
        BeanFactory beanFactory = applicationContext;
        boolean b = beanFactory.containsBean("customerService");
        logger.warn("到底有没有呢：" + b);

    }
}
