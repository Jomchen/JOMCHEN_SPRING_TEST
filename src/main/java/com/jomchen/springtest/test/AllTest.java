package com.jomchen.springtest.test;


import com.jomchen.springtest.commons.factorys.TwoFactory;
import com.jomchen.springtest.entity.basedata.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.format.DateTimeFormatter;

/**
 * create by Jomchen on 2018/1/5
 */
public class AllTest {

    public static Logger LOGGER = LoggerFactory.getLogger(AllTest.class);
    private static DateTimeFormatter DATE_TIME_FOR_MATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static DateTimeFormatter DATE_FOR_MATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        TwoFactory twoFactory = applicationContext.getBean("twoFactory", TwoFactory.class);
        LOGGER.warn("信息为：{}", twoFactory);

    }
}
