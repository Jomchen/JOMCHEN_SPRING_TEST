package com.jomchen.springtest.test;


import com.jomchen.springtest.entity.basedata.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by Jomchen on 2018/1/5
 */
public class AllTest {

    public static Logger logger = LoggerFactory.getLogger(AllTest.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        Customer customer = applicationContext.getBean("myCustomer", Customer.class);
        logger.warn("信息为：{}", customer.toString());


    }
}
