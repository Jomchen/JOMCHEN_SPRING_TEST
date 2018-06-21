package com.jomchen.springtest.test;


import com.jomchen.springtest.entity.basedata.Kongfu;
import com.jomchen.springtest.interfaces.test.MyTestService;
import com.jomchen.springtest.interfaces.test.impl.MyTestServiceImpl;
import com.jomchen.springtest.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.format.DateTimeFormatter;

/**
 * create by Jomchen on 2018/1/5
 */
@ComponentScan(basePackages = {"com.jomchen.springtest"})
@EnableAspectJAutoProxy
public class AllTest {

    public static Logger LOGGER = LoggerFactory.getLogger(AllTest.class);
    private static DateTimeFormatter DATE_TIME_FOR_MATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static DateTimeFormatter DATE_FOR_MATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void main(String[] args) {
        Object data = null;

        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");*/
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AllTest.class);
        /*applicationContext.register(TwoFactory.class, OneFactory.class);
        applicationContext.refresh();*/


        MyTestService myTestService = applicationContext.getBean(MyTestService.class);
        myTestService.add(3);



        applicationContext.close();
    }
}
